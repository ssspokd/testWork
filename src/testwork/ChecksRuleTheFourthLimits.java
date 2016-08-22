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
public class ChecksRuleTheFourthLimits extends ChecksRuleLimits
{

    public ChecksRuleTheFourthLimits(List<Payment> payments, Payment payment) {
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
    
    
}
