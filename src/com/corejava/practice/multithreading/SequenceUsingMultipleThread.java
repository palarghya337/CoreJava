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
	private ThreadLocal<Integer> supportCount = ThreadLocal.withInitial(() -> number + 3);
	
	@Override
	public void run() {
		
		while (number < 10) {
			synchronized (this) {
				
				int count = supportCount.get();
				Log.logInfo("{0}-> {1} - {2}", Thread.currentThread().getName(), number, count);
				number++;
//				Log.logInfo(Thread.currentThread().getName() + "Test" + supportCount.get());
//				notify();
				try {
					while (number != count) {
						this.wait(1000);
					}
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
				supportCount.set(number + 2);
			}
		}
	}
}