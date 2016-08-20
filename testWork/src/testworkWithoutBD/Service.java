/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testworkWithoutBD;

/**
 *
 * @author ssspokd
 */
public abstract class Service {
    private final  String nameService;
    
    public Service(String nameService) {
        this.nameService = nameService;
    }

    public String getNameService() {
        return nameService;
    }
    
    abstract protected void paymentService();
    
}
