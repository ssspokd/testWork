/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testwork;

import util.Config;
import java.util.Collection;


/**
 *
 * @author ssspokd
 */
public class LimitsFirst extends Limits
{
    
    
    public LimitsFirst(Collection<Payment> payments, Payment payment) {
        super(payments, payment);
    }
    
    
    @Override
    protected  String Validate(){
        return ( equalsSumPay() && startTimeEquals()&& stopTimeEquals()?
                Config.LIMIT_IS_EXCEEDED:Config.LIMIT_IS_NOT_EXCEEDED);
    }
    
    private boolean startTimeEquals(){
        return (currentTimeInMinute() >= Config.timeInConfigStart);
    }
    
    private boolean stopTimeEquals(){
        return (currentTimeInMinute() <  Config.timeInConfigStop);  
    }
    
    private boolean equalsSumPay(){
        return (payment.getSummPay() > Config.FIRST_LIMIT_MAX_MONEY);
    }
    
}

