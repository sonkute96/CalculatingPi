/*
* Classname: SmallCalculatingThread.
*
* Date: August,9,2017.
*
* The user can input the decimal place that that user wish to calculate the value of Pi to. 
* The program also support the ability to stop the calculating process and print out 
* the lastest result of the approximately.
*/
package com.sonpham.it.CalculatingPi.CalculatingThread;

public class SmallCalculatingThread extends CalculatingThread<Double> implements Runnable{
	
	/* The class is used to run threads of SmallCalculator.*/

	// decimalDegree variable.
	private int decimalDegree;
	
	/* Declare result variable with double type. */
	private volatile double result;
	
	/*Create SmallCalculatingThread constructor*/
	public SmallCalculatingThread(long fromIndex, long toIndex, int decimalDegree) {
		super(fromIndex,toIndex);
		this.decimalDegree = decimalDegree;
	}

	@Override
	public void run() {
		
		for (long n = fromIndex; n < toIndex; n++){
			if (n <= 5 * Math.pow(10,decimalDegree -1) - 1 / 2){
				result = result + (double)Math.pow(-1, n) / (2 * n + 1);
			}
		}
	}
	@Override
	public Double getResult() {
		return result;
	}

}
