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
public class ChecksRuleTheFourthLimits extends ChecksRuleLimits
{

    public ChecksRuleTheFourthLimits(List<Payment> payments) {
        super(payments);
    }

    @Override
    boolean ValidateForLimit() {
        int countPayment = 0;
        int sumPay = 0; 
        for(Payment p : payments){
            if(equalsTimePayments(p) && equalsIDClient(p))
                {
                    countPayment++;
                    sumPay = sumPay + p.getSummPay();
                }
            }
        return(equalsCountAnsSumPay(countPayment, sumPay));
    }

    @Override
    boolean ValidateForLimit(Payment p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
