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
public  class LimitThird extends Limits
{

    public LimitThird(Collection<Payment> payments, Payment payment) {
        super(payments, payment);
    }

    @Override
    protected String Validate() {
        int countPayment = 0;
        for(Payment p: payments){
            if((p.getDatePayment().getDate() == payment.getDatePayment().getDate()) && 
                    (p.getIdClient() == payment.getIdClient()) &&
                    (p.getNameService() == payment.getNameService())){
                countPayment++;
            }
        }
        return (countPayment > Config.thirdLimitCountPayment?Config.LimitIsNotExceeded:Config.LimitIsExceeded); 
    }
    
}
