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
public class LimitSecond  extends Limits
{

    public LimitSecond(Collection<Payment> payments, Payment payment) {
        super(payments, payment);
    }

    @Override
    protected String Validate() {
        int currentTimeInMinute = (payment.getDatePayment().getHours() * 60) + payment.getDatePayment().getMinutes();
        int summ = 0;
        for(Payment p: payments){
           if((currentTimeInMinute -(p.getDatePayment().getHours()*60 + p.getDatePayment().getMinutes()) <60)){
               summ = summ + p.getSummPay();
           }
        }
         return (summ > 3000?Config.LimitIsNotExceeded:Config.LimitIsExceeded);
    }
    
}
