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
    
    private boolean startTimeEquals(){
        return (currentTimeInMinute() >= Config.FIRST_LIMIT_TIME_IN_START);
    }
    
    private boolean stopTimeEquals(){
        return (currentTimeInMinute() <  Config.FIRST_LIMIT_TIME_END);  
    }
    
    private boolean equalsSumPay(){
        return (payment.getSummPay() > Config.FIRST_LIMIT_MAX_MONEY);
    }
    
}

