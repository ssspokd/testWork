/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testwork;

import java.io.IOException;

/**
 *
 * @author ssspokd
 */
public class main {
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here       
       PaymentSystem paymentSystem  =  new PaymentSystem();
       paymentSystem.start();
    }
}
