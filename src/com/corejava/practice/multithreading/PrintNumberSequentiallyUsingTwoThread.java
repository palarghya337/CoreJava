package com.corejava.practice.multithreading;

import com.corejava.practice.utils.Log;

/**
 * This is an example where number will be printed sequentially
 * using multiple threads.
 * @author Bittu
 *
 */
public class PrintNumberSequentiallyUsingTwoThread {

	public static void main(String[] args) {

    PrintNumberWithTwoThreads obj = new PrintNumberWithTwoThreads(20);
    Thread t1 = new Thread(obj);
    Thread t2 = new Thread(obj);
    t1.start();
    t2.start();
	}
}

class PrintNumberWithTwoThreads implements Runnable {
	
  private int number = 1;
	private int range;
	
  public PrintNumberWithTwoThreads(int range) {
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

          String tName = Thread.currentThread().getName();
          /* Below condition checks whether thread is even thread or odd.
           * If thread is odd and number is odd then sets the boolean as
           * true otherwise false.
           **/
          boolean isOddNumber = tName.contains("1") && number % 2 != 0;
          /* Below condition checks whether thread is even thread or odd.
           * If thread is even and number is even then sets the boolean
           * as true otherwise false.
           **/
          boolean isEvenNumber = tName.contains("0") && number % 2 == 0;
          if (isOddNumber || isEvenNumber) {
            Log.logInfo("{0}, Number-{1}", Thread.currentThread().getName(), number++);
            /* This notify is to notify the other thread
             * if any thread is waiting to acquire the lock
             * to print the number.
             * */
            this.notifyAll();
          } else {
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
          }
        }
			}
		}
	}
}
