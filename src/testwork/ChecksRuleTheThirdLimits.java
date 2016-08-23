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
public  class ChecksRuleTheThirdLimits extends ChecksRuleLimits
{

    public ChecksRuleTheThirdLimits(List<Payment> payments) {
        super(payments);
    }

    @Override
    boolean ValidateForLimit() {
        int countPayment = 0;
        for(Payment p: payments){
            if(equalsDatePayment(p) && equalsIDClient(p)&& equalsNameServicePayment(p))
            {
                countPayment++;
            }
        }
        return (countPayment <= Config.THIRD_LIMIT_COUNT_PAYMENT); 
    }

    @Override
    boolean ValidateForLimit(Payment p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
