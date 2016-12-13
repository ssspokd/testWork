/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import testwork.PaymentSystem;
import java.security.cert.*;

/**
 *
 * @author ssspokd
 */
public class main {
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, KeyStoreException {
        // TODO code application logic here       
      PaymentSystem paymentSystem  =  new PaymentSystem();
       paymentSystem.start();
       KeyStore keyStore  = KeyStore.getInstance("  ");
       java.security.cert.Certificate certificate =   keyStore.getCertificate(" ");
      int x = 1, m = 1;
      while(x<10){
          x = x +1;
          m = m*x;
      }
        System.out.println(m);
    }
    //private final ObjectCodeTemplate template; 
}
