/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testwork;


import java.util.List;


/**
 *
 * @author ssspokd
 */
public class ChecksRuleTheFirstLimits extends ChecksRuleLimits
{

    @Override
    boolean ValidateForLimit() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    
    public ChecksRuleTheFirstLimits(List<Payment> payments) {
        super(payments);
    }
   

    @Override
    boolean ValidateForLimit(Payment p) {
        return (equalsSumPay(p) && startTimeEquals(p)&& stopTimeEquals(p));
    }
}

