/*
* Classname: BigCalculator.
*
* Date: August,9,2017.
*
* The user can input the decimal place that that user wish to calculate the value of Pi to. 
* The program also support the ability to stop the calculating process and print out 
* the lastest result of the approximately.
*/
package com.sonpham.it.CalculatingPi.Calculator;

import java.math.BigDecimal;

import com.sonpham.it.CalculatingPi.CalculatingThread.BigCalculatingThread;
import com.sonpham.it.CalculatingPi.Common.Constant;

public class BigCalculator implements Calculator {
	/* The class is used to calculate pi with small decimal place which is greater than or equals 17. */
	
	/* Singleton for this class*/
	
	// Make the constructor private so that this class cannot be instantiated.
	private BigCalculator(){}
	
	// Create a SingtonHelper class to create an object of SmallCalculator
	private static class SingletonHelper{
		private static final BigCalculator instance = new BigCalculator();
	}
	// Get the only object available.
	public static BigCalculator getInstance(){
		return SingletonHelper.instance;
	}
	
	/* Create resultPi variable.*/
	BigDecimal resultPi = new BigDecimal(0);
	
	@Override
	public void calculate(int decimalDegree) {
		/* declares and assigns a value of fromIndex.*/ 
		long fromIndex = 0;
		
		/* declares and assigns a value of toIndex.*/ 
		long toIndex = Constant.MAX_VALUE_PER_THREAD;
		
		/* Create array of Thread */
		Thread [] threads = new Thread [Constant.MAX_THREAD];
		
		/* Create array objects of BigCalculatingThread.*/
		BigCalculatingThread [] bigCalculatingThreads = new BigCalculatingThread [Constant.MAX_THREAD];
		
		for (int i = 0; i < Constant.MAX_THREAD; i++){
			
			bigCalculatingThreads[i] = new BigCalculatingThread(fromIndex,toIndex,decimalDegree);
			threads[i] = new Thread(bigCalculatingThreads[i]);
			// Set thread name
			threads[i].setName("Thread" + i);
			
			// Run thread
			threads[i].start();
			try {
				threads[i].join();
				
				// calculate value of resultPi from getResult method.
				resultPi = resultPi.add(bigCalculatingThreads[i].getResult());
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// Set again fromIndex.
			fromIndex = toIndex;
			
			// Set again toIndex.
			toIndex = toIndex + Constant.MAX_VALUE_PER_THREAD;
		}
		
		/* multiply value of resultPi by 4.*/
		resultPi = resultPi.multiply(Constant.FOUR);
	}
	@Override
	public void printResult() {
		System.out.print("\n\n\tPI = " + resultPi + "\n");
	}
	

}
