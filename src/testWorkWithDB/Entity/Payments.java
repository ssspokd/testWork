package testWorkWithDB.Entity;
// Generated 21.08.2016 17:12:33 by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Payments generated by hbm2java
 */
@Entity
@Table(name="PAYMENTS"
)
public class Payments  implements java.io.Serializable {


     private int id;
     private Service service;
     private int clientId;
     private int sumPay;
     private Date datePayment;
     private String status;
     private String mobileNumber;

    public Payments() {
    }

    public Payments(int id, Service service, int clientId, int sumPay, Date datePayment, String status, String mobileNumber) {
       this.id = id;
       this.service = service;
       this.clientId = clientId;
       this.sumPay = sumPay;
       this.datePayment = datePayment;
       this.status = status;
       this.mobileNumber = mobileNumber;
    }
   
    @Id    
    @Column(name="ID", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="SERVICE_ID", nullable=false)
    public Service getService() {
        return this.service;
    }
    
    public void setService(Service service) {
        this.service = service;
    }

    
    @Column(name="CLIENT_ID", nullable=false)
    public int getClientId() {
        return this.clientId;
    }
    
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    
    @Column(name="SUM_PAY", nullable=false)
    public int getSumPay() {
        return this.sumPay;
    }
    
    public void setSumPay(int sumPay) {
        this.sumPay = sumPay;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DATE_PAYMENT", nullable=false, length=19)
    public Date getDatePayment() {
        return this.datePayment;
    }
    
    public void setDatePayment(Date datePayment) {
        this.datePayment = datePayment;
    }

    
    @Column(name="STATUS", nullable=false, length=25)
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    
    @Column(name="MOBILE_NUMBER", nullable=false, length=11)
    public String getMobileNumber() {
        return this.mobileNumber;
    }
    
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }




}


