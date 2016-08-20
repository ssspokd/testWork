/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testworkWithoutBD;

import java.util.Date;



/**
 *
 * @author ssspokd
 */
public class Payment {

    private final int idPayment;
    private String statusPayment;
    private final int summPay;
    private final Date datePayment;
    private final String nameService;    
    private final int idClient;  
    private final Service service;
    private final String mobileNumber;
  

    public Service getService() {
        return service;
    }
    
    public String getStatusPayment() {
        return statusPayment;
    }

    public int getIdPayment() {
        return idPayment;
    }

    public int getSummPay() {
        return summPay;
    }

    public Date getDatePayment() {
        return datePayment;
    }

    public String getNameService() {
        return nameService;
    }

    public int getIdClient() {
        return idClient;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
    
    public void setStatusPayment(String statusPayment) {
        this.statusPayment = statusPayment;
    }
    
    public Payment(int idClient, Service service, int idPayment,int summPay,Date datePayment, String mobileNumber) {
        this.idPayment = idPayment;     
        this.service = service;
        this.nameService =  this.service.getNameService();
        this.idClient = idClient;   
        this.summPay = summPay;
        this.datePayment  =  datePayment;
        this.mobileNumber = mobileNumber;
    }
    
    public void Paying(){     
        System.out.println("Number payment document "  + idPayment);
        System.out.println("Payment in the amount of:" + this.summPay + " mobile number:" + 
                mobileNumber +  " mobile operator:"+service.getNameService());
        System.out.println(getStatusPayment());
        service.paymentService();
    } 
}
