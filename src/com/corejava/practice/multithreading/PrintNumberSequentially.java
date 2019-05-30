package com.corejava.practice.multithreading;

import java.util.stream.IntStream;

import com.corejava.practice.utils.Log;

/**
 * This is an example where number will be printed sequentially
 * using multiple threads.
 * @author Bittu
 *
 */
public class PrintNumberSequentially {

	public static void main(String[] args) {

    PrintNumber obj = new PrintNumber(10);
    IntStream.range(0, 3).forEach(index -> new Thread(obj).start());
	}
}
class PrintNumber implements Runnable {
	
	private int number;
	private int range;
	
	public PrintNumber(int range) {
		this.range = range;
	}
	
	@Override
	public void run() {
		
		while (number < range) {
			synchronized (this) {
        /* Checking the condition again because different thread might have
         * updated the number while current thread is waiting to acquire the lock.
         **/
        if (number < range) {
          Log.logInfo("{0}, Number-{1}", Thread.currentThread().getName(), number++);
          /* This notify is to notify all the other thread
           * if any thread is waiting to acquire the lock
           * to print the number.
           * */
          this.notifyAll();
          try {
            /* Waiting the current thread so that other
             * thread can also get a chance to print the
             * number.
             **/
            this.wait();
          } catch (InterruptedException e) {
            Log.logInfo("Exception: {0}", e.getMessage());
            Thread.currentThread().interrupt();
          }
          /* This notify is use to notify all the waiting thread
           * to finish the task after the condition fulfills(i.e.-
           * number became greater or equals the iterationTime)
           * If we did not notify all the thread then deadlock
           * would happen because waiting thread will keep on
           * waiting.
           **/
          this.notifyAll();
        }
			}
		}
	}
}
