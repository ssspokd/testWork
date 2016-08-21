/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testWorkWithDB;

import java.util.LinkedList;
import java.util.List;
import org.hibernate.Session;
import testWorkWithDB.DAO.Service;
import testWorkWithDB.Interfaces.AbstractObjectDB;
import static util.DAO.getSession;


/**
 *
 * @author spok
 */
public class ServiceIMPl extends AbstractObjectDB<Service>
{
    public final static String TABLE_NAME = "SERVICE";
    
    private ServiceIMPl() {
        super(TABLE_NAME);
    }
    private static ServiceIMPl instance = null;
    
    public static ServiceIMPl getInstance() {
        if (instance == null) {
            instance = new ServiceIMPl();
        }

        return instance;
    }
    
    public List<Service> getListService(int value){
        List<Service>  ret = new LinkedList<>();
        Session session = getSession();
        try{
            session.getTransaction().begin();
            ret = session.createSQLQuery("select * from SERVICE where   :param3  >= service.min_value and :param3 < service.max_value").setInteger("param3", value).list();   
            session.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e.toString());
            session.getTransaction().rollback();
        }
        return ret;
    }
    
}
