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
public abstract class Services {
    private final  String nameService;
    
    public Services(String nameService) {
        this.nameService = nameService;
    }

    public String getNameService() {
        return nameService;
    }
    
    abstract protected void paymentService();
    
}
