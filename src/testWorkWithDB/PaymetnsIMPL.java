/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testWorkWithDB;


import java.util.LinkedList;
import java.util.List;
import org.hibernate.Session;
import testWorkWithDB.DAO.Payments;
import testWorkWithDB.Interfaces.AbstractObjectDB;

/**
 *
 * @author spok
 */
public class PaymetnsIMPL extends AbstractObjectDB<Payments>
{
    public final static String TABLE_NAME = "PAYMENTS";
    public PaymetnsIMPL() {
        super(TABLE_NAME);
    }
    private static PaymetnsIMPL instance = null;
    
    public static PaymetnsIMPL getInstance() {
        if (instance == null) {
            instance = new PaymetnsIMPL();
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
   
    public boolean firstLimitValidate(){
        
        
        return  false;
    }
}
