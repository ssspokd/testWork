/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testWorkWithDB;

import java.util.LinkedList;
import java.util.List;
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
        Session session = getSession();
        try{
            session.getTransaction().begin();
            ret =  (Service) session.createCriteria("select * from SERVICE where   " + values + "  >= service.min_value and " +values+ " < service.max_value");   
            session.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e.toString());
            session.getTransaction().rollback();
        }
        return ret;
    }
    
}
