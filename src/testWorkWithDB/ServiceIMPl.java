/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testWorkWithDB;

import java.util.LinkedList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import testWorkWithDB.Entity.Service;
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
    
    public Service getListService(int values){
        Service ret = null;
        Session session = null;
        try{
            session = getSession();
            session.getTransaction().begin();           
            Query categoryQuery  = session.createQuery("from Service where   :param1  >= min_value and :param1 < max_value").setInteger("param1", values);   
            session.getTransaction().commit();
            ret = (Service) categoryQuery.uniqueResult();
        }
        catch(Exception e){
            System.out.println(e.toString());
            session.getTransaction().rollback();
        }
        return ret;
    }
    
}
