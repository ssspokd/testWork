package util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ssspokd
 */
public class Config {
    //
    public  static  final int COUNT_MINUTE = 60; 
    //mobile opertor
    public  static  final int MTS = 999;
    public  static  final int BEELINE = 300;
    public  static  final int MEGAFON = 600;
    
    
    //Status Payment
    public  static   final String LIMIT_IS_EXCEEDED = "require confirmation";
    public  static   final String LIMIT_IS_NOT_EXCEEDED = "ready to host";
    
    
    ///Limits
    //firstLimit
    public static   final int FIRST_LIMIT_MAX_MONEY = 5000;  
    public static   final int FIRST_LIMIT_START_DAY_HOURS = 9; //in  hours
    public static   final int FIRST_LIMIT_END_DAY_HOURS = 23; // in  hours
    public static   final int FIRST_LIMIT_START_DAY_MINUTE = 0; //in minutes
    public static   final int FIRST_LIMIT_END_DAY_MINUTE = 0; //in minutes
     //second Limit
    public static   final int SECOND_LIMIT_MAX_MONEY  = 3000;
    public static   final int SECOND_LIMIT_TIME = 60; //in minutes
    //third limit
    public static   final int THIRD_LIMIT_COUNT_PAYMENT = 20;
    public static   final int THIRD_LIMIT_TIME = 24; //in  hours
    //fourth limit
    public static   final int FOURTH_LIMIT_MAX_MONEY = 3000;
    public static   final int FOURTH_LIMIT_TIME = 120; //in  minutes
    public static   final int FOURH_LIMIT_COUNT_PAYMENT = 10;  
    
}
