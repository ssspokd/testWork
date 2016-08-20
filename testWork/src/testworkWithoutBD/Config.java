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
public class Config {
    // коля
    //Status Payment
    public  static String LimitIsExceeded = "require confirmation";
    public  static String LimitIsNotExceeded = "ready to host";
    
    ///Limits
    //firstLimit
    public static int firstLimitMaxMoney = 5000;  
    public static int firstLimitStartDayHours = 9; //in  hours
    public static int fisrtLimitStopDayHours = 23; // in  hours
    public static int firstLimitStartDayMinute = 0; //in minutes
    public static int firstLimitStopDayMinute = 0; //in minutes
     //second Limit
    public static int secondLimitMaxMoney  = 3000;
    public static int secondLimitTimeLimit = 60; //in minutes
    //third limit
    public static int thirdLimitCountPayment = 20;
    public static int thirdLimitTime = 24; //in  hours
    //fourth limit
    public static int fourthLimitMaxMoney = 3000;
    public static int fourthLimitTime = 120; //in  minutes
    public static int fourthLimitCountPayment = 10;  
    
}
