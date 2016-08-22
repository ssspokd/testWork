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
public class ChecksRuleTheSecondLimits  extends ChecksRuleLimits
{

    public ChecksRuleTheSecondLimits(List<Payment> payments, Payment payment) {
        super(payments, payment);
    }

    @Override
    protected String Validate() {
        int summ = 0;
        for(Payment p: payments){
           if(timeDifference(p) < Config.SECOND_LIMIT_TIME){
               summ = summ + p.getSummPay();
           }
        }
         return (summ <= Config.SECOND_LIMIT_MAX_MONEY?Config.LIMIT_IS_NOT_EXCEEDED:Config.LIMIT_IS_EXCEEDED);
    }
    
    
}
