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
public class LimitsFirst extends Limits
{
    
    public LimitsFirst(Collection<Payment> payments, Payment payment) {
        super(payments, payment);
    }
    
    @Override
    protected  String Validate(){
        
        return ( (payment.getSummPay() > Config.firstLimitMaxMoney) && 
                ((payment.getDatePayment().getHours()*60 + payment.getDatePayment().getMinutes()) >= 
                (Config.firstLimitStartDayHours*60 + Config.firstLimitStartDayMinute))&&
                ((payment.getDatePayment().getHours()*60 + payment.getDatePayment().getMinutes()) 
                < (Config.fisrtLimitStopDayHours*60 + Config.firstLimitStopDayMinute))?
                Config.LimitIsExceeded:Config.LimitIsNotExceeded);
    }
    
}
