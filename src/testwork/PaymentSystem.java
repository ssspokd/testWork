/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testwork;

import util.Config;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.hibernate.Session;
import testWorkWithDB.Entity.Service;
import testWorkWithDB.Entity.Payments;
import testWorkWithDB.PaymentsIMPL;
import util.DAO;

/**
 *
 * @author ssspokd
 */
public class PaymentSystem {

    private int idPayment =  0;
    private final List<Payment> paymentsColl =  new ArrayList<>();
    private Services mobileService = null;
    private final int increaseIdPayment = 1;
    private final int lengMobileNumber = 10;
     
    
    public int getIdPayment() {
        return idPayment;
    }
    
    private void incrementIdPayment(){
         idPayment+=increaseIdPayment;
    }
    
    ///создание платёжного поручения, все платёжки хрантся в List
    public  void createPayment(String mobileNumber, int idClient,int sumPay){       
        incrementIdPayment();
        Payment payment =  new Payment(idClient, mobileService , getIdPayment(),sumPay, new Date(), mobileNumber);
        paymentsColl.add(payment);
        payment.setStatusPayment(validateForLimits(payment, new ChecksRuleTheFirstLimits(paymentsColl)));      
        payment.paying();           
    }
    public String validateForLimits(Payment payment,ChecksRuleLimits limit){
        return (limit.ValidateForLimit(payment)?Config.LIMIT_IS_EXCEEDED:Config.LIMIT_IS_NOT_EXCEEDED);
    }
    ///реализованна возможность записи платёжных  поручений в БД
    //
    public  void createPaymentDB(String mobileNumber, int idClient,int sumPay){
        incrementIdPayment();     
        Date currentDate = new Date();       
        Session session =  DAO.getSession();
        session.beginTransaction();     
        Payments payments = new Payments(sumPay,getService(mobileNumber),idClient, sumPay, currentDate, 
                getStatusValidatedPayment(sumPay,currentDate), mobileNumber);
        session.save(payments);
        session.getTransaction().commit();
    }
    private Service getService(String mobileNumber){
        return testWorkWithDB.ServiceIMPl.getInstance().getListService(Integer.valueOf(mobileNumber.substring(0, 3)));
    }
    
    private String getStatusValidatedPayment(int sumPay,Date currentDate){
        return PaymentsIMPL.validateFirstLimit(sumPay,currentDate);
    }
    ////
    
    
    public boolean isMobilePhoneNumber(String mobileNumber){        
        String reg = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
        Pattern p = Pattern.compile(reg);
        Matcher  m = p.matcher(mobileNumber);
        return m.matches();
    }
    
    private void whoIsOperator(String mobileNumber){
       String str = mobileNumber.substring(0, 3);
       int numOper = (Integer.valueOf(str));
       if(numOper <= Config.BEELINE)
       {
           mobileService =  new ServiceMTS(MobileOperator.BEELINE.name());
       }
       else if(numOper >= Config.BEELINE && numOper < Config.MEGAFON)
       {
                   mobileService =  new ServiceMegafon(MobileOperator.MEGAFON.name());
       }
       else if(numOper >= Config.MEGAFON && numOper < Config.MTS)
       {
           mobileService =  new ServiceMegafon(MobileOperator.MTS.name());
       }
    }
     
    private boolean validNumber(String mobilePhoneNumber){
        
        boolean isValid = false;        
        if(mobilePhoneNumber.length() != lengMobileNumber){              
                isValid = false;
        }
        else if(isMobilePhoneNumber(mobilePhoneNumber))
        {     
            isValid = true;        
        } 
        
        return isValid;
    }
    
    private void printFirstScreen(){
        System.out.println("1. View limits");
        System.out.println("2. Createp payment");
        System.out.println("3. Exit");
    }
   
    private int getIdClient(Scanner in){
        int ret = 0;
        System.out.println("Enter ID client");
        try{
            Integer s =  new Integer(in.next());
            ret = s;          
        }
        catch(Exception e){
                System.out.println("Enter correct ID client");
                System.out.println("Payment №" + idPayment +  " not created");
                ret = -1;                  
        }       
        return ret;         
    }
    
    private String inputMobileNumber()
    {
        String ret = "";
        BufferedReader bReader = new BufferedReader (new InputStreamReader(System.in));
        System.out.println("Enter mobile number");
        // ввод строки данных               
        try{
                String mobilePhoneNumber = bReader.readLine();
                if(!validNumber(mobilePhoneNumber))
                {
                    System.out.println("Wrong number, the number should be 10 digits and contain only digits 0-9");
                    System.out.println("Payment №" + idPayment +  " not created");
                }  
                else{
                    ret = mobilePhoneNumber;
                }
        } catch (IOException ex)
        {
                        Logger.getLogger(PaymentSystem.class.getName()).log(Level.SEVERE, null, ex);
        }      
        
        return ret;
    }
    
    public int inputSumPay(Scanner in){
        System.out.println("Enter sum payment");
        int ret = 0;      
        try{
            Integer s =  new Integer(in.next());
            ret = s;         
        }
        catch(Exception e){
                System.out.println("Enter correct sum pay");
                System.out.println("Payment №" + idPayment +  " not created");
                ret = -1;                  
        } 
        return ret;
    }
    
    public void start() throws IOException{
        Scanner in =  new Scanner(System.in);
        boolean stop = true;
        while(stop){
        printFirstScreen();
        int a =  in.nextInt();  
            switch (a) {
                case 1:
                    ViewerLimits.viewLimits(); 
                    break;
                case 2:                    
                    int idClient = getIdClient(in);
                    if(idClient == -1){
                        continue;
                    }                
                    String mobilePhoneNumber = inputMobileNumber();                    
                    if(mobilePhoneNumber.isEmpty()){
                        continue;
                    }
                    whoIsOperator(mobilePhoneNumber);               
                    int sumPay  = inputSumPay(in);
                    if(sumPay == -1){
                        continue;
                    }
                    createPayment(mobilePhoneNumber, idClient,sumPay);
                    break;
                case 3:
                    stop = false;
                    break;
                default:
                    System.out.println("enter 1,2 or 3");
                    break;
            }
        }
    }
    
    
    
}
