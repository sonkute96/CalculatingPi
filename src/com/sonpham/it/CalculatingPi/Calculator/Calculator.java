/*
* Interface name: Calculator.
*
* Date: August,9,2017.
*
* The user can input the decimal place that that user wish to calculate the value of Pi to. 
* The program also support the ability to stop the calculating process and print out 
* the lastest result of the approximately.
*/
package com.sonpham.it.CalculatingPi.Calculator;

public interface Calculator {
	
	public void calculate(int decimalDegree);
	
	public void printResult();

}
