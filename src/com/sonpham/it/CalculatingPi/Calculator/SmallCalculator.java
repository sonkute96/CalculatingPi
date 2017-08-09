/*
* Classname: SmallCalculator.
*
* Date: August,9,2017.
*
* The user can input the decimal place that that user wish to calculate the value of Pi to. 
* The program also support the ability to stop the calculating process and print out 
* the lastest result of the approximately.
*/
package com.sonpham.it.CalculatingPi.Calculator;

import com.sonpham.it.CalculatingPi.CalculatingThread.SmallCalculatingThread;
import com.sonpham.it.CalculatingPi.Common.Constant;

public class SmallCalculator implements Calculator {
	
	/* The class is used to calculate pi with small decimal place from 1 to 16. */
	
	/* Singleton for this class*/
	
	// Make the constructor private so that this class cannot be instantiated.
	private SmallCalculator(){}
	
	// Create a SingtonHelper class to create an object of SmallCalculator
	private static class SingletonHelper{
		private static final SmallCalculator instance = new SmallCalculator();
	}
	// Get the only object available.
	public static SmallCalculator getInstance(){
		return SingletonHelper.instance;
	}
	
	/* Declares and assigns a value of PI. */
	private double resultPi = 0;

	@Override
	public void calculate(int decimalDegree) {
		/* declares and assigns a value of fromIndex.*/ 
		long fromIndex = 0;
		
		/* declares and assigns a value of toIndex.*/ 
		long toIndex = Constant.MAX_VALUE_PER_THREAD;
		
		/* Create array of Thread */
		Thread [] threads = new Thread [Constant.MAX_THREAD];
		
		/* Create array objects of SmallCalculatingThread.*/
		SmallCalculatingThread [] smallCalculatingThreads = new SmallCalculatingThread[Constant.MAX_THREAD];
		
		for (int i = 0; i < Constant.MAX_THREAD; i++){
			smallCalculatingThreads[i] = new SmallCalculatingThread(fromIndex,toIndex,decimalDegree);
			threads[i] = new Thread(smallCalculatingThreads[i]);
			// Set thread name.
			threads[i].setName("Thread:" + i);
			// run thread
			threads[i].start();
			try {
				threads[i].join();
				
				// calculate value of resultPi from getResult method.
				resultPi += smallCalculatingThreads[i].getResult();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// set again fromIndex
			fromIndex = toIndex;
			// set again toIndex
			toIndex = toIndex + Constant.MAX_VALUE_PER_THREAD;
			
			
		}
		
		/* Format value of resultPi variable by multiply with 4 and round with decimalDegree.*/
		resultPi = Math.round(resultPi * 4 * Math.pow(10, decimalDegree)) / Math.pow(10, decimalDegree);			
		
	}

	@Override
	public void printResult() {
		
		 System.out.print("\n\n\tPI = " + resultPi + "\n");
	}

}
