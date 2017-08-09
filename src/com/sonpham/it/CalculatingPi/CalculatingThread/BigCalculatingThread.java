/*
* Classname: BigCalculatingThread.
*
* Date: August,9,2017.
*
* The user can input the decimal place that that user wish to calculate the value of Pi to. 
* The program also support the ability to stop the calculating process and print out 
* the lastest result of the approximately.
*/
package com.sonpham.it.CalculatingPi.CalculatingThread;

import java.math.BigDecimal;

import com.sonpham.it.CalculatingPi.Common.Constant;

public class BigCalculatingThread extends CalculatingThread<BigDecimal> implements Runnable{

	// decimalDegree variable.
	private int decimalDegree;
	
	/* Create result variable with BigDecimal type. */
	private volatile BigDecimal result = new BigDecimal(0);
	
	/*Create BigCalculatingThread constructor.*/
	public BigCalculatingThread(long fromIndex, long toIndex, int decimalDegree) {
		super(fromIndex, toIndex);
		this.decimalDegree = decimalDegree;
	}

	@Override
	public void run() {
		
		BigDecimal i  = Constant.ONE;
		for (long n = fromIndex; n < toIndex; n++){
			if (n <= 5 * Math.pow(10, decimalDegree -1) -1 / 2){
				
				// change type of n
				BigDecimal bigDecimalN = new BigDecimal(n);
				// calculate result
				result = result.add(i.divide((Constant.TWO.multiply(bigDecimalN).add(Constant.ONE)), decimalDegree, BigDecimal.ROUND_HALF_UP));
				i = i.multiply(Constant.N_ONE);
			}
		}
		
	}

	@Override
	public BigDecimal getResult() {
		return result;
	}

}
