package com.corejava.practice.multithreading;

import java.util.stream.IntStream;

import com.corejava.practice.utils.Log;

public class Task implements Runnable {
	
	private String taskName;

	public Task(String taskName) {
		this.taskName = taskName;
	}

	@Override
	public void run() {
		IntStream.range(0, 5).forEach(index -> {
			sleep(500);
			Log.logInfo("Thread: {0}, Task: {1}, Index: {2}",
					Thread.currentThread().getName(), this.taskName,
					index);
		});
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
