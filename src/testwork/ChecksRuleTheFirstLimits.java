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
public class ChecksRuleTheFirstLimits extends ChecksRuleLimits
{
    
    
    public ChecksRuleTheFirstLimits(List<Payment> payments, Payment payment) {
        super(payments, payment);
    }
    
    
    @Override
    protected  String Validate(){
        return ( equalsSumPay() && startTimeEquals()&& stopTimeEquals()?
                Config.LIMIT_IS_EXCEEDED:Config.LIMIT_IS_NOT_EXCEEDED);
    }
}

