/*
* Classname: MainApplication.
*
* Date: August,9,2017.
*
* The user can input the decimal place that that user wish to calculate the value of Pi to. 
* The program also support the ability to stop the calculating process and print out 
* the lastest result of the approximately.
*/

package com.sonpham.it.CalculatingPi.Common;

import java.math.BigDecimal;

public class Constant {

    public static final long NSPACE = 500000000;
    public static final int MAX_THREAD = 10;
    public static final long MAX_VALUE_PER_THREAD = NSPACE / MAX_THREAD;
    public static final BigDecimal ONE = new BigDecimal(1);
    public static final BigDecimal TWO = new BigDecimal(2);
    public static final BigDecimal N_ONE = new BigDecimal(-1);
    public static final BigDecimal FOUR = new BigDecimal(4);

}
