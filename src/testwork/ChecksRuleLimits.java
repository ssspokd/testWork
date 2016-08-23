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
    protected final Payment payment  = null;

    public ChecksRuleLimits(List<Payment> payments) {
        this.payments = payments;     
    }
    
    protected int currentTimeInMinute(Payment payment){
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
        return (currentTimeInMinute(p) - getTimeInPayment(p));
    }
    
    
    ///
     protected boolean startTimeEquals(Payment p){
        return (currentTimeInMinute(p) >= Config.FIRST_LIMIT_TIME_IN_START);
    }
    
    protected boolean stopTimeEquals(Payment p){
        return (currentTimeInMinute(p) <  Config.FIRST_LIMIT_TIME_END);  
    }
    
    protected boolean equalsSumPay(Payment payment){
        return (payment.getSummPay() > Config.FIRST_LIMIT_MAX_MONEY);
    }
    
    ///second
    protected boolean equalsTimePayments(Payment p){
        return (timeDifference(p) < Config.FOURTH_LIMIT_TIME);
    }
    
    protected boolean equalsCountAnsSumPay(int countPayment, int sumPay)
    {
        return (countPayment > Config.FOURH_LIMIT_COUNT_PAYMENT || sumPay > Config.FOURTH_LIMIT_MAX_MONEY);
    }
    
    ///third
    protected boolean equalsDatePayment(Payment p){
        return (p.getDatePayment().getDate() == payment.getDatePayment().getDate());
    }
    
    protected boolean equalsNameServicePayment(Payment p){
        return  (p.getNameService().equals(payment.getNameService()));
    }
    
    abstract boolean ValidateForLimit(Payment p);
    abstract boolean  ValidateForLimit();
}
