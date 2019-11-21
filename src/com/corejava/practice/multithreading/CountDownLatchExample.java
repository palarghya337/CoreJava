package com.corejava.practice.multithreading;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import com.corejava.practice.utils.Log;

public class CountDownLatchExample {

	public static void main(String[] args) {

		int numberOfThreads = 4;
		CountDownLatchExample example = new CountDownLatchExample();
		CountDownLatch countDownLatch = new CountDownLatch(numberOfThreads);
		ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
		executorService.execute(example.new CDLTask("Task-1", countDownLatch));
		executorService.execute(example.new CDLTask("Task-2", countDownLatch));
		executorService.execute(example.new CDLTask("Task-3", countDownLatch));
		executorService.execute(example.new CDLTask("Task-4", countDownLatch));
		executorService.shutdown();
		try {
			/* Here we have called await() method, which will wait
			 * till all the above task completes their operation or
			 * clearly saying it will cause the current thread to
			 * wait until the latch has counted down to zero.
			 * Once all the tasks are done i.e. if the current count
			 * is zero then this method will release the lock and
			 * rest of the code will execute.
			 **/
			countDownLatch.await();
		} catch (InterruptedException e) {
			Log.logInfo("Exception: {0}", e.getMessage());
			Thread.currentThread().interrupt();
		}
		Log.logInfo("All the tasks are done.");
	}
	private class CDLTask implements Runnable {

		private String taskName;
		private CountDownLatch countDownLatch;

		public CDLTask(String taskName, CountDownLatch countDownLatch) {
			this.taskName = taskName;
			this.countDownLatch = countDownLatch;
		}

		@Override
		public void run() {

			IntStream.range(0, 2).forEach(index -> {
				sleep(500);
				Log.logInfo("Thread: {0}, Task: {1}, Index: {2}", Thread.currentThread().getName(), this.taskName, index);
			});
			if (!Objects.isNull(countDownLatch)) {
				/* Decrements the count of the latch, releasing all waiting threads
				 * if the count reaches zero. If the current count is greater than
				 * zero then it is decremented. If the new count is zero then all
				 * waiting threads are re-enabled for thread scheduling purposes.
				 * If the current count equals zero then nothing happens.
				 **/
				countDownLatch.countDown();
			}
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
}
