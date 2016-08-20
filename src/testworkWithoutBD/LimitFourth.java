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
        for(Payment p : payments){
            if(equalsTimePayments(currentTimeInMinute(), p))
                {
                    countPayment++;
                    sumPay = sumPay + p.getSummPay();
                }
            }
        return(equalsCountSumPay(countPayment, sumPay)?Config.LIMIT_IS_NOT_EXCEEDED:Config.LIMIT_IS_EXCEEDED);
    }
    
    private boolean equalsTimePayments(int currentTimeInMinute, Payment p){
        return ((currentTimeInMinute -(p.getDatePayment().getHours()*Config.COUNT_MINUTE + p.getDatePayment().getMinutes()) < Config.FOURTH_LIMIT_TIME)
                    && (p.getIdClient() == payment.getIdClient()));
    }
    
    
    
    private boolean equalsCountSumPay(int countPayment, int sumPay)
    {
        return (countPayment > Config.FOURH_LIMIT_COUNT_PAYMENT || sumPay > Config.FOURTH_LIMIT_MAX_MONEY);
    }
}
