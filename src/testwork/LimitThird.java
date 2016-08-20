/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testwork;

import java.util.Collection;

/**
 *
 * @author ssspokd
 */
public  class LimitThird extends Limits
{

    public LimitThird(Collection<Payment> payments, Payment payment) {
        super(payments, payment);
    }

    @Override
    protected String Validate() {
        int countPayment = 0;
        for(Payment p: payments){
            if(equalsDatePayment(p) && equalsIDClient(p)&& equalsNameServicePayment(p))
            {
                countPayment++;
            }
        }
        return (countPayment <= Config.THIRD_LIMIT_COUNT_PAYMENT?Config.LIMIT_IS_NOT_EXCEEDED:Config.LIMIT_IS_EXCEEDED); 
    }
    
    private boolean equalsDatePayment(Payment p){
        return (p.getDatePayment().getDate() == payment.getDatePayment().getDate());
    }
    
    private boolean equalsNameServicePayment(Payment p){
        return  (p.getNameService().equals(payment.getNameService()));
    }
}