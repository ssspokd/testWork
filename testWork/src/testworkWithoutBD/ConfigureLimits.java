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
public class ConfigureLimits {
    public  static void viewLimits(){
        System.out.println("    1. Не более " + Config.firstLimitMaxMoney +" руб. днем с " +
                Config.firstLimitStartDayHours  +":"+Config.firstLimitStartDayMinute+" утра до "+ Config.fisrtLimitStopDayHours +
                ":" + Config.firstLimitStopDayMinute + "за одну услугу");
        System.out.println("    2. Не более "+ Config.secondLimitMaxMoney +" руб. в течение  " 
                + Config.secondLimitTimeLimit + "часа(ов) за одну услугу;");
        System.out.println("    3. Не более + " + Config.thirdLimitCountPayment 
                + "одинаковых платежей(одинаковые клиент и мобильный оператор) в "
                + Config.thirdLimitTime +"часа");
        System.out.println("    4. Не более "+ Config.fourthLimitCountPayment+" платежей не более чем на "+
                Config.fourthLimitMaxMoney +" руб. в течение  " + Config.fourthLimitTime + " минут одним клиентом.");
    }
    
}
