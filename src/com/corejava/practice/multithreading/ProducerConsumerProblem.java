package com.corejava.practice.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

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

    BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
    // Thread-1 is the producer thread.
    Thread producerThread = new Thread(new Producer(queue));
    Thread consumerThread = new Thread(new Consumer(queue));
    producerThread.start();
    consumerThread.start();
  }
}

class Producer implements Runnable {

  private BlockingQueue<Integer> queue;
  private Integer data = 0;

  public Producer(BlockingQueue<Integer> queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
    produce();
  }

  private void produce() {

    synchronized (queue) {
      while (!queue.isEmpty()) {
        try {
          Log.logInfo("Need to wait as consumer is consuming the data.");
          queue.wait();
        } catch (InterruptedException e) {
          Log.logInfo("Exception: {0}", e.getMessage());
          Thread.currentThread().interrupt();
        }
      }
    }
    while (queue.size() != 10) {
      try {
        queue.add(data);
        Log.logInfo(Thread.currentThread().getName() + " produced: " + data);
        data++;
      } catch (Exception e) {
        Log.logInfo("Queue is full.");
      }
    }
    synchronized (queue) {
      queue.notifyAll();
    }
  }
}

class Consumer implements Runnable {

  private BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

  public Consumer(BlockingQueue<Integer> queue) {
    this.queue = queue;
  }

  @Override
  public void run() {

    synchronized (queue) {
      while (queue.size() != 10) {
        try {
          Log.logInfo("Need to wait as producer is producing the data.");
          queue.wait();
        } catch (InterruptedException e) {
          Log.logInfo("Exception: {0}", e.getMessage());
          Thread.currentThread().interrupt();
        }
      }
    }
    while (!queue.isEmpty()) {
      try {

        Integer data = queue.remove();
        Log.logInfo(Thread.currentThread().getName() + " consumed: " + data);
      } catch (Exception e) {
        Log.logInfo("Queue is empty");
      }
    }
    synchronized (queue) {
      queue.notifyAll();
    }
  }
}