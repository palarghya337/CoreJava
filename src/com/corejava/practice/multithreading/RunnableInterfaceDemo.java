package com.corejava.practice.multithreading;

import com.corejava.practice.utils.Log;

public class RunnableInterfaceDemo {

	public static void main(String[] args) {
		new Thread(new RIDThread()).start();
	}
}
class RIDThread implements Runnable {
	
	@Override
	public void run() {
		Log.logInfo("Inside run() method of RIDThread class.");
	}
}