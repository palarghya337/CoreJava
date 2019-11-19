package com.corejava.practice.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import com.corejava.practice.utils.Log;

/**
 * This is an example of how to block a thread to submit
 * a task when queue is full so that it can not throw any
 * exception.
 * @author Bittu
 *
 */
public class SimaphoreExample {

	public static void main(String[] args) {
		
		int permits = 10;
		Semaphore semaphore = new Semaphore(permits);
		ArrayBlockingQueue<Runnable> queue =
				new ArrayBlockingQueue<>(permits);
		SimaphoreExample example = new SimaphoreExample();
		ExecutorService service =new ThreadPoolExecutor(
				3, 5, 0, TimeUnit.MILLISECONDS, queue);
		IntStream.range(0, 20).forEach(i -> {
			try {
				semaphore.acquire();
				service.execute(example.new STask(i, semaphore));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				Log.logInfo("Exception while sleeping a thread {0}",
						e.getMessage());
			}
		});
		service.shutdown();
	}
	private class STask implements Runnable {
		
		private int taskNumber;
		private Semaphore semaphore;

		public STask(int taskNumber, Semaphore semaphore) {
			this.taskNumber = taskNumber;
			this.semaphore = semaphore;
		}
		@Override
		public void run() {
			try {
				Log.logInfo("Task#{0} is running.", taskNumber);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				Log.logInfo("Exception while sleeping a thread {0}",
						e.getMessage());
			} finally {
				Log.logInfo("Task#{0} is done.", taskNumber);
				semaphore.release();
			}
		}
	}
}
