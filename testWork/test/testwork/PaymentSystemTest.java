/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testwork;

import java.util.ArrayList;
import testworkWithoutBD.LimitsFirst;
import testworkWithoutBD.Limits;
import testworkWithoutBD.PaymentSystem;
import testworkWithoutBD.Payment;
import testworkWithoutBD.ServiceBeeline;
import testworkWithoutBD.Service;
import testworkWithoutBD.LimitSecond;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ssspokd
 */
public class PaymentSystemTest {
    
    public PaymentSystemTest() {
        this.instance = new PaymentSystem();
        this.payments = new ArrayList<>();    
        this.date = new Date();
        this.mobileNumber = "9091231212";
        this.idClient = 10;
        this.sumPay = 1000;
        this.service = new ServiceBeeline("Beeline");
        this.payment = new Payment(idClient, service, idClient, sumPay, date, mobileNumber);
        payments.add(payment);
        payments.add(new Payment(idClient, service, idClient, sumPay, date, mobileNumber));
        payments.add(new Payment(idClient, service, idClient, sumPay, date, mobileNumber));
        payments.add(new Payment(idClient, service, idClient, sumPay, date, mobileNumber));
        payments.add(new Payment(idClient, service, idClient, sumPay, date, mobileNumber));
    }
    
    private final String mobileNumber;
    private final int idClient;
    private final int sumPay;
    private final Service service;
    private final Date date;
    private final Payment payment;
    private final Collection<Payment> payments;
    private final PaymentSystem instance;
       
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getIdPayment method, of class PaymentSystem.
     */
    @Test
    public void testGetIdPayment() {
        System.out.println("getIdPayment");
        PaymentSystem instance = new PaymentSystem();
        int expResult = 0;
        int result = instance.getIdPayment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.      
    }


    /**
     * Test of validateForLimits method, of class PaymentSystem.
     */
    @Test
    public void testValidateForLimitsFirst() {
        System.out.println("validateForLimits");        
        ///
        Limits limit = new LimitsFirst(payments, payment);  
        String expResult = "ready to host";
        String result = instance.validateForLimits(payment, limit);
        System.out.println(result);
        assertEquals(expResult, result);
        
           
    }
    
    @Test
    public void testValidateForLimitsSecond() {
        System.out.println("validateForLimitsSecond");  
        Limits limit = new LimitsFirst(payments, payment);  
        String expResult = "ready to host";
        limit = new LimitSecond(payments, payment);             
        String result = instance.validateForLimits(payment, limit);
        System.out.println(result);
        assertEquals(expResult, result);
           
    }
    
    @Test
    public void testValidateForLimitsFirstSecond() {
        System.out.println("validateForLimitsFirstSecond");  
        Limits limit = new LimitsFirst(payments, payment);  
        String expResult = "ready to host";
        limit = new LimitSecond(payments, payment);             
        String result = instance.validateForLimits(payment, limit);
        limit = new LimitsFirst(payments, payment);
        result = instance.validateForLimits(payment, limit);
        System.out.println(result);
        assertEquals(expResult, result);         
    }

    /**
     * Test of isMobilePhoneNumber method, of class PaymentSystem.
     */
    @Test
    public void testIsMobilePhoneNumber() {
        System.out.println("isMobilePhoneNumber");
        //PaymentSystem instance = new PaymentSystem();
        boolean expResult = true;
        boolean result = instance.isMobilePhoneNumber(mobileNumber);
        assertEquals(expResult, result);    
    }   
    
    
}
