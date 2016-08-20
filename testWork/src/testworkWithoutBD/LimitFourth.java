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
public class LimitFourth extends Limits
{

    public LimitFourth(Collection<Payment> payments, Payment payment) {
        super(payments, payment);
    }

    @Override
    protected String Validate() {
        int countPayment = 0;
        int sumPay = 0;
        int currentTimeInMinute = (payment.getDatePayment().getHours() * 60) + payment.getDatePayment().getMinutes();
        for(Payment p : payments){
            if((currentTimeInMinute -(p.getDatePayment().getHours()*60 + p.getDatePayment().getMinutes()) < Config.fourthLimitTime)
                    && (p.getIdClient() == payment.getIdClient()))
                {
                    countPayment++;
                    sumPay = sumPay + p.getSummPay();
                }
            }
        return((countPayment > Config.fourthLimitCountPayment || sumPay > Config.fourthLimitMaxMoney)?
                Config.LimitIsNotExceeded:Config.LimitIsExceeded);
    }
    
}
