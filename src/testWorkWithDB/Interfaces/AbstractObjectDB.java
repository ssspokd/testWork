package testWorkWithDB.Interfaces;


import java.util.ArrayList;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import util.DAO;

public  abstract class AbstractObjectDB<T> extends DAO implements ObjectDB<T> 
{

    public static final int INTERVAL = 1;
    private final String tableName;

    public AbstractObjectDB(String tableName) {
        this.tableName = tableName;
    }

    protected boolean getBooleanFromInt(int number) {     
        return (number > 0);
    }

    @Override
    public void updateObject(T t) throws SQLException {
        Session session = getSession();
	try {
            org.hibernate.Transaction tx  = beginTransaction();
            tx.begin();
            session.update(t);
            session.getTransaction().commit();	    
            } 
        catch (Exception e) {
            System.err.println(e.getMessage());
        }      
    }

    @Override
    public void updateOrInsertObject(T t) throws SQLException {
        Session session = getSession();
        try {
            org.hibernate.Transaction tx  = beginTransaction();
            tx.begin();
            session.saveOrUpdate(t);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteObject(T t) throws SQLException {
        Session session = getSession();
        try {          
            org.hibernate.Transaction tx  = beginTransaction();
            tx.begin();
            session.delete(t);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }     
    }
    
    @Override
    public void insert(T t) throws SQLException {
        Session session = getSession();
	try {         
            org.hibernate.Transaction tx  = beginTransaction();
            tx.begin();          
            session.save(t);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }     
    }


    @Override
    public T getObjectByID(long id) throws SQLException {
        T object = null;
        Session session = getSession();
        try {
  
            Query categoryQuery = getSession().createQuery(
                    " from " + tableName + " where ID = :id").setLong("id", id);          
            object = (T) categoryQuery.uniqueResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return object;
    }

    @Override
    public ArrayList<T> getAllObjects() throws SQLException {     
        List<T> list   = new LinkedList<>();
        Session session = getSession();
	try {        
            list = session.createQuery("from " + tableName).list();         		    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }       
        return (ArrayList<T>) list;     
    }
    
}
