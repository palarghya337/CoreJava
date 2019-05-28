package com.corejava.practice.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.corejava.practice.utils.Log;

public class SingleThreadPoolExample {

	public static void main(String[] args) {
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		service.execute(new Task("A"));
		service.execute(new Task("B"));
		service.execute(new Task("D"));
		service.execute(new Task("C"));
		service.shutdown();
	}
}
class Task implements Runnable {
	
	private String taskName;
	public Task(String taskName) {
		this.taskName = taskName;
	}
	@Override
	public void run() {
		sleep(1000);
		Log.logInfo("Task {0} is executing.", this.taskName);
	}
	public void sleep(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException ie) {
			Log.logInfo("Exception: {0}", ie.getMessage());
			Thread.currentThread().interrupt();
		}
	}
}
