package testWorkWithDB.Interfaces;


import com.mchange.v1.db.sql.UnsupportedTypeException;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.DAO;

public  abstract class AbstractObjectDB<T> extends DAO implements ObjectDB<T> 
{

    public static final int INTERVAL = 1;
    private String tableName;

    public AbstractObjectDB(String tableName) {
        this.tableName = tableName;
    }

    protected void clearTime(Calendar c) {
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
    }

    protected boolean getBooleanFromInt(int number) {
        if (number > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void UpdateObject(T t) throws SQLException {
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
    public void UpdateOrInsertObject(T t) throws SQLException {
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
    public void DeleteObject(T t) throws SQLException {
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
        Session session = null;
        try {
            session = getSession();
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
        List<T> list   = null;
        Session session = null;
	try {
            session = getSession();         
            list = session.createQuery("from " + tableName).list();         		    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }       
        return (ArrayList<T>) list;     
    }
    
}
