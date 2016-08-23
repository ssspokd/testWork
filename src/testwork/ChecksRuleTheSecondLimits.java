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

    public ChecksRuleTheSecondLimits(List<Payment> payments) {
        super(payments);
    }

    @Override
    boolean ValidateForLimit(Payment p) {
        throw new UnsupportedOperationException("Not supported yet."); 
        
    }

    @Override
    boolean ValidateForLimit() {
        int summ = 0;
        for(Payment p1: payments){
           if(timeDifference(p1) < Config.SECOND_LIMIT_TIME){
               summ = summ + p1.getSummPay();
           }
        }
         return (summ <= Config.SECOND_LIMIT_MAX_MONEY);
     }
    
    
}
