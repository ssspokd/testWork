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
public class ViewerLimits {
    public  static void viewLimits(){
        System.out.println("    1. Не более " + Config.FIRST_LIMIT_MAX_MONEY +" руб. днем с " +
                Config.FIRST_LIMIT_START_DAY_HOURS  +":"+Config.FIRST_LIMIT_START_DAY_MINUTE+" утра до "+ Config.FIRST_LIMIT_END_DAY_HOURS +
                ":" + Config.FIRST_LIMIT_END_DAY_MINUTE + "за одну услугу");
        System.out.println("    2. Не более "+ Config.SECOND_LIMIT_MAX_MONEY +" руб. в течение  " 
                + Config.SECOND_LIMIT_TIME + "часа(ов) за одну услугу;");
        System.out.println("    3. Не более + " + Config.THIRD_LIMIT_COUNT_PAYMENT 
                + "одинаковых платежей(одинаковые клиент и мобильный оператор) в "
                + Config.THIRD_LIMIT_TIME +"часа");
        System.out.println("    4. Не более "+ Config.FOURH_LIMIT_COUNT_PAYMENT+" платежей не более чем на "+
                Config.FOURTH_LIMIT_MAX_MONEY +" руб. в течение  " + Config.FOURTH_LIMIT_TIME + " минут одним клиентом.");
    }
    
}
