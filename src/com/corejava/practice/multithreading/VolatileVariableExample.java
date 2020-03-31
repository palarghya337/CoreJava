package com.corejava.practice.multithreading;

import com.corejava.practice.utils.Log;

public class VolatileVariableExample {

//	private static boolean isExit;
	/*
	 * comment the volatile variable and comment the
	 * previous variable
	 **/
	private static volatile boolean isExit;
	
	public static void main(String[] args) {
		
		new Thread(() -> {
			
			Log.logInfo("Starting the thread...");
			while (!isExit) {
				/*
				 * The output of this code shows that the inside
				 * thread is never stopped. This happens because
				 * the change made to ‘isExit’ variable in the
				 * main thread is not visible to the inside thread.
				 * This is so because the inside thread locally
				 * caches the value of isExit. To prevent this
				 * from happening we can use a volatile variable.
				 **/
			}
			Log.logInfo("Exiting the thread...");
		}).start();
		
		sleep(1000);
		isExit = true;
		Log.logInfo("main method stopped..");
	}

	private static void sleep(long timeInMillis) {
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
