/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testWorkWithDB;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import testWorkWithDB.Entity.Payments;
import testWorkWithDB.Entity.Service;
import testWorkWithDB.Interfaces.AbstractObjectDB;
import util.Config;
import static util.DAO.getSession;

/**
 *
 * @author spok
 */
public class PaymentsIMPL extends AbstractObjectDB<Payments>
{
    public final static String TABLE_NAME = "PAYMENTS";
    public PaymentsIMPL() {
        super(TABLE_NAME);
    }
    private static PaymentsIMPL instance = null;
    
    public static PaymentsIMPL getInstance() {
        if (instance == null) {
            instance = new PaymentsIMPL();
        }

        return instance;
    }
    
    public static List<String> getContragentFromOSp(int id){
        List<String> ret = new LinkedList<>();
        Session session = getSession();
        try{
            ret = session.createSQLQuery("select NAME_CONTRAGENT from Contragent where ID_OSP = :param1").setInteger("param1", id).list();
            session.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        return ret;
    }
    
  
    ///validate for first limit
    public static String  validateFirstLimit(int sum,Date date){
        return ( sum > Config.FIRST_LIMIT_MAX_MONEY && startTimeEquals(date)&& stopTimeEquals(date)?
                Config.LIMIT_IS_EXCEEDED:Config.LIMIT_IS_NOT_EXCEEDED);
    }
    private static  boolean startTimeEquals(Date date){
        return (getCurrentTimeInMinute(date) >= Config.timeInConfigStart);
    }
    
    private static boolean stopTimeEquals(Date date){
        return (getCurrentTimeInMinute(date) <  Config.timeInConfigStop);  
    }
    
      public static int getCurrentTimeInMinute(Date date){
        return (date.getHours() * Config.COUNT_MINUTE + date.getMinutes());             
    }
    
    //validate for second limit
    public static String  validateSecondLimit(int sum,Date date){
        
        String ret = null;
        Session session = null;
        try{
            session = getSession();
            session.getTransaction().begin();           
            Date start_date = date;
            date.setHours(date.getHours() -1);
            Date end_date = date;
            List<Payments> categoryQuery  = session.createQuery("from Payments where date(DATE_PAYMENT) BETWEEN  "
                    + ":p1 AND :p2").setDate("p1",start_date)
                    .setDate("p2", end_date).list();
            session.getTransaction().commit();
            
        }
        catch(Exception e){
            System.out.println(e.toString());
            session.getTransaction().rollback();
        }
        return ret;
    }
}
