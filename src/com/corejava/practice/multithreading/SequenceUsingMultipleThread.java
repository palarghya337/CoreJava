package com.corejava.practice.multithreading;

import com.corejava.practice.utils.Log;

public class SequenceUsingMultipleThread {

	public static void main(String[] args) {
		
		SUMThread obj = new SUMThread();
		Thread t1 = new Thread(obj);
		Thread t2 = new Thread(obj);
		Thread t3 = new Thread(obj);
		Thread t4 = new Thread(obj);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
class SUMThread implements Runnable {
	
	private int number;
	
	@Override
	public void run() {
		
		while (number < 10) {
			synchronized (this) {
				
				Log.logInfo("{0}-> {1}", Thread.currentThread().getName(), number);
				number++;
				notifyAll();
				try {
					this.wait();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		}
		synchronized (this) {
			notifyAll();
		}
	}
}