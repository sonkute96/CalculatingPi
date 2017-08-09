/*
* Classname: CalculatorFactory.
*
* Date: August,9,2017.
*
* The user can input the decimal place that that user wish to calculate the value of Pi to. 
* The program also support the ability to stop the calculating process and print out 
* the lastest result of the approximately.
*/

package com.sonpham.it.CalculatingPi.CalculatorFactoryPattern;

import com.sonpham.it.CalculatingPi.Calculator.BigCalculator;
import com.sonpham.it.CalculatingPi.Calculator.Calculator;
import com.sonpham.it.CalculatingPi.Calculator.SmallCalculator;

public class CalculatorFactory {
	
	/* The class is used to create object and refer to newly created object using a common Calculator interface*/
	
	/*
	 * Use getCalculator method to get object of type Calculator.
	 * */
	public Calculator getCalculator(int decimalDegree){
		if(decimalDegree > 0 && decimalDegree < 17)
			return SmallCalculator.getInstance();
		else
			return BigCalculator.getInstance();
	}

	
}
