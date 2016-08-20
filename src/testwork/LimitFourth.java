/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testwork;

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
            if(equalsTimePayments(p) && equalsIDClient(p))
                {
                    countPayment++;
                    sumPay = sumPay + p.getSummPay();
                }
            }
        return(equalsCountAnsSumPay(countPayment, sumPay)?Config.LIMIT_IS_EXCEEDED:Config.LIMIT_IS_NOT_EXCEEDED);
    }
    
    private boolean equalsTimePayments(Payment p){
        return (TimeDifference(p) < Config.FOURTH_LIMIT_TIME);
    }
    
    private boolean equalsCountAnsSumPay(int countPayment, int sumPay)
    {
        return (countPayment > Config.FOURH_LIMIT_COUNT_PAYMENT || sumPay > Config.FOURTH_LIMIT_MAX_MONEY);
    }
}
