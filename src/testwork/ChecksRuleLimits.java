/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testwork;

import util.Config;
import java.util.List;

/**
 *
 * @author ssspokd
 */
public abstract class ChecksRuleLimits {
    
    protected final List<Payment> payments;
    protected final Payment payment;
    
    public ChecksRuleLimits(List<Payment> payments, Payment payment) {
        this.payments = payments;
        this.payment = payment;
    }
    
    protected int currentTimeInMinute(){
        return (payment.getDatePayment().getHours() * Config.COUNT_MINUTE + payment.getDatePayment().getMinutes());             
    }
    
    protected int getTimeInPayment(Payment p){
        return  p.getDatePayment().getHours()*Config.COUNT_MINUTE +
                p.getDatePayment().getMinutes();
    }
    
    protected boolean equalsIDClient(Payment p){
        return (p.getIdClient() == payment.getIdClient());
    }
    
    protected int timeDifference(Payment p){
        return (currentTimeInMinute() - getTimeInPayment(p));
    }
    
    abstract protected String Validate();      
}
