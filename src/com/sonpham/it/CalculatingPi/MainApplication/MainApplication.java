/*
* Classname: MainApplication.
*
* Date: August,9,2017.
*
* The user can input the decimal place that that user wish to calculate the value of Pi to. 
* The program also support the ability to stop the calculating process and print out 
* the lastest result of the approximately.
*/

package com.sonpham.it.CalculatingPi.MainApplication;



import java.util.Scanner;

import com.sonpham.it.CalculatingPi.Calculator.Calculator;
import com.sonpham.it.CalculatingPi.CalculatorFactoryPattern.CalculatorFactory;

public class MainApplication {
	
	/* The main class is where the user can input the decimal place and calculate the value of Pi. */

	public static void main(String[] args) {
		
		// Create variable decimalDegree.
		int decimalDegree;
		
		// The user inputs value of decimalDegree.
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n DecimalDegree = ");
		
		// input value of decimalDegree.
		decimalDegree = scanner.nextInt();
		
		
		/* Create instance of CalculatorFactory.*/
		CalculatorFactory instanceCalculatorFactory = new CalculatorFactory();
		
		/* Create instance of Calculator.*/
		Calculator instanceCalculator = instanceCalculatorFactory.getCalculator(decimalDegree);
		
		/* Call calculate method */
		instanceCalculator.calculate(decimalDegree);
		
		/* Print value of Pi */
		instanceCalculator.printResult();
		

	}

}
