/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testwork;

/**
 *
 * @author ssspokd
 */
public class ServiceMegafon extends Services{
    
    public ServiceMegafon(String nameService) {
        super(nameService);
    }
    @Override
    protected void paymentService() {
        System.out.println("payment is made, mobile operator " + super.getNameService());
    }
    
}
