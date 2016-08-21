/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testWorkWithDB;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import testWorkWithDB.Entity.Payments;
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
        
        List<Payments> res =  new LinkedList<>();
        Session session = null;
        try{
            session = getSession();
            session.getTransaction().begin();           
            
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter  format = DateTimeFormatter.ofPattern("dd.MM.YYYY HH:mm:ss");
            String date_end = dateTime.format(format); 
            String date_start = dateTime.minusHours(1).format(format);    
            
            Query categoryQuery  = session.createQuery("from Payments  where "
                    + "DATE_PAYMENT > '"+date_start+"' and DATE_PAYMENT < '"+date_end+"'");
            session.getTransaction().commit();
            res = categoryQuery.list();           
        }
        catch(Exception e){
            System.out.println(e.toString());
            session.getTransaction().rollback();
        }
        return (sumPay(res)>Config.SECOND_LIMIT_MAX_MONEY?Config.LIMIT_IS_EXCEEDED:Config.LIMIT_IS_NOT_EXCEEDED);
    }
    private static int sumPay(List<Payments> payments){
        int ret = 0;
        for(Payments p: payments){
            ret = ret + p.getSumPay();
        }   
        return ret;
    }
    
    //validate for Third limit
    public static String validateThirdLimit(int idService){
        
        List<Payments> res =  new LinkedList<>();
        Session session = null;
        try{
            session = getSession();
            session.getTransaction().begin();                
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter  format = DateTimeFormatter.ofPattern("dd.MM.YYYY HH:mm:ss");   
            dateTime.minusHours(dateTime.getHour()).format(format);    
            dateTime.minusMinutes(dateTime.getMinute());
            String date_start = dateTime.format(format); 
            dateTime.plusHours(23);
            dateTime.plusMinutes(59);
            String date_end = dateTime.format(format);
            Query categoryQuery  = session.createSQLQuery("from Payments  join  service on payments.service_id = service.id "
                    + " where service.id = " + idService  + " and "                   
                    + " DATE_PAYMENT > '" +date_start+"' and DATE_PAYMENT < '"+ date_end+"'");
            session.getTransaction().commit();
            res = categoryQuery.list();           
        }
        catch(Exception e){
            System.out.println(e.toString());
            session.getTransaction().rollback();
        }
        return (res.size()>Config.THIRD_LIMIT_COUNT_PAYMENT?Config.LIMIT_IS_EXCEEDED:Config.LIMIT_IS_NOT_EXCEEDED);
    }
}
