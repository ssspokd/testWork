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
public class LimitsFirst extends Limits
{
    
    private final int  timeInConfigStart = Config.FIRST_LIMIT_START_DAY_HOURS*Config.COUNT_MINUTE + Config.FIRST_LIMIT_START_DAY_MINUTE;
    private final int  timeInConfigStop = Config.FIRST_LIMIT_END_DAY_HOURS*Config.COUNT_MINUTE + Config.FIRST_LIMIT_END_DAY_MINUTE;
    
    public LimitsFirst(Collection<Payment> payments, Payment payment) {
        super(payments, payment);
    }
    
    @Override
    protected  String Validate(){
        
        return ( equalsSumPay() && startTimeEquals()&& stopTimeEquals()?
                Config.LIMIT_IS_EXCEEDED:Config.LIMIT_IS_NOT_EXCEEDED);
    }
    
    private boolean startTimeEquals(){
        return (currentTimeInMinute() >= timeInConfigStart);
    }
    
    private boolean stopTimeEquals(){
        return (currentTimeInMinute() <  timeInConfigStop);  
    }
    
    private boolean equalsSumPay(){
        return (payment.getSummPay() > Config.FIRST_LIMIT_MAX_MONEY);
    }
    
}

