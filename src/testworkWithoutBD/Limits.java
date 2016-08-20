/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testworkWithoutBD;

import java.util.Collection;

/**
 *
 * @author ssspokd
 */
public abstract class Limits {
    
    protected final Collection<Payment> payments;
    protected final Payment payment;
    public Limits(Collection<Payment> payments, Payment payment) {
        this.payments = payments;
        this.payment = payment;
    }
    
    protected int currentTimeInMinute(){
        return (payment.getDatePayment().getHours() * Config.COUNT_MINUTE) + payment.getDatePayment().getMinutes();
                
    }
    
    abstract protected String Validate();   
}
