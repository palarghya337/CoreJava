package com.corejava.practice.multithreading;

import java.util.concurrent.TimeUnit;

import com.corejava.practice.utils.Log;

public class DeadLockExample {

	public static void main(String[] args) {
		createDeadLock();
//		fixedDeadLock();
		Log.logInfo("Main thread ended.");
	}
	private static void createDeadLock() {
		
		final Object lock1 = new Object();
		final Object lock2 = new Object();
		Thread thread1 = new Thread(() -> {
				String threadName = Thread.currentThread().getName();
				synchronized (lock1) {
					Log.logInfo("{0} acquired the lock1 object", threadName);
					try {
						TimeUnit.MILLISECONDS.sleep(50);
					} catch (InterruptedException e) {
						Log.logInfo(e.getMessage());
						Thread.currentThread().interrupt();
					}
					Log.logInfo("Before taking a lock of lock2 object");
					synchronized (lock2) {
						Log.logInfo("{0} acquired the lock1 & lock2 object", threadName);
					}
				}
		});
		thread1.start();
		Thread thread2 = new Thread(() -> {
	        	String threadName = Thread.currentThread().getName();
	            synchronized (lock2) {
	            	Log.logInfo("{0} acquired the lock2 object", threadName);
	                try {
	                    TimeUnit.MILLISECONDS.sleep(50);
	                } catch (InterruptedException e) {
	                	Log.logInfo(e.getMessage());
						Thread.currentThread().interrupt();
	                }
	                Log.logInfo("Before taking a lock of lock1 object");
	                synchronized (lock1) {
	                	Log.logInfo("{0} acquired the lock1 & lock2 object", threadName);
	                }
	            }
	    });
		thread2.start();
	}
	
	/**
	 * To fix the deadlock need to acquire the object
	 * sequentially, i.e.- if thread1 acquires the lock1
	 * object before then lock2 then thread2 also should
	 * follow the same sequence to avoid the deadlock.
	 */
	public static void fixedDeadLock() {
		
		final Object lock1 = new Object();
		final Object lock2 = new Object();
		Thread thread1 = new Thread(() -> {
				String threadName = Thread.currentThread().getName();
				synchronized (lock1) {
					Log.logInfo("{0} acquired the lock1 object", threadName);
					try {
						TimeUnit.MILLISECONDS.sleep(50);
					} catch (InterruptedException e) {
						Log.logInfo(e.getMessage());
						Thread.currentThread().interrupt();
					}
					Log.logInfo("Before taking a lock of lock2 object");
					synchronized (lock2) {
						Log.logInfo("{0} acquired the lock1 & lock2 object", threadName);
					}
				}
		});
		thread1.start();
		Thread thread2 = new Thread(() -> {
	        	String threadName = Thread.currentThread().getName();
	            synchronized (lock1) {
	            	Log.logInfo("{0} acquired the lock1 object", threadName);
	                try {
	                    TimeUnit.MILLISECONDS.sleep(50);
	                } catch (InterruptedException e) {
	                	Log.logInfo(e.getMessage());
						Thread.currentThread().interrupt();
	                }
	                Log.logInfo("Before taking a lock of lock2 object");
	                synchronized (lock2) {
	                	Log.logInfo("{0} acquired the lock1 & lock2 object", threadName);
	                }
	            }
	    });
		thread2.start();
	}
}
