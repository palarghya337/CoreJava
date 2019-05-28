package com.corejava.practice.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import com.corejava.practice.utils.Log;

public class SingleThreadPoolExample {

	public static void main(String[] args) {
		/* Creates an Executor that uses a single worker thread
		 * operating off an unbounded queue. (Note however that
		 * if this single thread terminates due to a failure
		 * during execution prior to shutdown, a new one will
		 * take its place if needed to execute subsequent tasks.)
		 * Tasks are guaranteed to execute sequentially, and no
		 * more than one task will be active at any given time.
		 * Unlike the otherwise equivalent newFixedThreadPool(1)
		 * the returned executor is guaranteed not to be
		 * reconfigurable to use additional threads.
		 **/
		ExecutorService service = Executors.newSingleThreadExecutor();
		service.execute(new Task("A"));
		service.execute(new Task("B"));
		service.execute(new Task("C"));
		service.execute(new Task("D"));
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
		IntStream.range(0, 5).forEach(index -> {
			sleep(500);
			Log.logInfo("Task {0} is executing -> {1}", this.taskName, index);
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
