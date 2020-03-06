package com.corejava.practice.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.stream.IntStream;

import com.corejava.practice.utils.Log;

/**
 * In this problem producer thread would have to
 * wait if consumer thread is consuming the data
 * and in the same way consumer thread would have
 * to wait if producer thread is producing the data.
 * The solution of the above problem is done using
 * only two thread.
 * @author apal
 *
 */
public class ProducerConsumerProblem {

  public static void main(String[] args) {

    // Custom queue which will manage producer-consumer problem.
    MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(10);
    Random randomInteger = new Random();

    Runnable producerRunnable = () -> IntStream.range(0, 4).forEach(index -> {
      int ranIn = randomInteger.nextInt(20);
      queue.put(ranIn);
      Log.logInfo("Thread: {0}, Produced: {1}", Thread.currentThread().getName(), ranIn);
    });

    Runnable producerRunnable1 = () -> IntStream.range(0, 4).forEach(index -> {
      int ranIn = randomInteger.nextInt(20);
      queue.put(ranIn);
      Log.logInfo("Thread: {0}, Produced: {1}", Thread.currentThread().getName(), ranIn);
    });

    Runnable consumerRunnable = () -> {
      while (true) {
        Log.logInfo("Thread: {0}, Consumed: {1}", Thread.currentThread().getName(), queue.take());
      }
    };

    Thread producerThread = new Thread(producerRunnable);
    Thread producerThread1 = new Thread(producerRunnable1);
    Thread consumerThread = new Thread(consumerRunnable);
    producerThread.start();
    producerThread1.start();
    consumerThread.start();
  }
}

class MyBlockingQueue<E> {

  private int maxSize = 16;
  private Queue<E> queue;
  private Object producerLock = new Object();
  private Object consumerLock = new Object();

  public MyBlockingQueue(int size) {
    this.maxSize = size;
    queue = new LinkedList<>();
  }

  /**
   * This method add the data to the queue if space is available
   * in the queue. If space is not available then it will wait
   * to remove some data from the queue and space to become available.
   * 
   * @param value
   * @return boolean
   */
  public boolean put(E value) {
	  
	  boolean isAdded = false;
	  synchronized (producerLock) {
		  while (queue.size() == maxSize) {
			  try {
				  producerLock.wait();
			  } catch (InterruptedException e) {
				  Log.logInfo("Exception: {0}", e.getMessage());
				  Thread.currentThread().interrupt();
			  }
		  }
		  isAdded = queue.add(value);
	  }
	  synchronized (consumerLock) {
		  consumerLock.notifyAll();
	  }
	  return isAdded;
  }

  /**
   * This method removes the data from the queue if queue is not
   * empty. If queue is empty then it will wait until some data
   * is available in the queue to consume.
   * 
   * @return E
   */
  public E take() {

	  E value = null;
	  synchronized (consumerLock) {
		  while (queue.isEmpty()) {
			  try {
				  consumerLock.wait();
			  } catch (InterruptedException e) {
				  Log.logInfo("Exception: {0}", e.getMessage());
				  Thread.currentThread().interrupt();
			  }
		  }
		  value = queue.poll();
	  }
	  synchronized (producerLock) {
		  producerLock.notifyAll();
	  }
	  return value;
  }

  /**
   * If size of the queue is zero then this method will return
   * true otherwise false.
   * @return boolean
   */
  public boolean isEmpty() {
    return queue.isEmpty();
  }
}