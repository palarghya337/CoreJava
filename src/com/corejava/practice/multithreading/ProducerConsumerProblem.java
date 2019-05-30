package com.corejava.practice.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
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

    MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(10);
    new LinkedBlockingQueue<>();
    // Thread-1 is the producer thread.
    Runnable producer = () -> IntStream.range(0, 4).forEach(index -> {
      queue.put(index);
      Log.logInfo("Thread: {0}, Produced: {1}", Thread.currentThread().getName(), index);
    });
    Runnable consumer = () -> {
      while (true) {
        Log.logInfo("Thread: {0}, Consumed: {1}", Thread.currentThread().getName(), queue.take());
      }
    };

    Thread proThread = new Thread(producer);
    Thread conThread = new Thread(consumer);
    proThread.start();
    conThread.start();
  }
}

class MyBlockingQueue<E> {

  private int maxSize = 16;
  private Queue<E> queue;
  private Object full = new Object();
  private Object empty = new Object();

  public MyBlockingQueue(int size) {
    this.maxSize = size;
    queue = new LinkedList<>();
  }

  public boolean put(E value) {
    synchronized (full) {
      while (queue.size() == maxSize) {
        try {
          full.wait();
        } catch (InterruptedException e) {
          Log.logInfo("Exception: {0}", e.getMessage());
          Thread.currentThread().interrupt();
        }
      }
    }
    synchronized (empty) {
      boolean isAdded = queue.add(value);
      empty.notifyAll();
      return isAdded;
    }
  }

  public E take() {

    synchronized (empty) {
      while (queue.isEmpty()) {
        try {
          empty.wait();
        } catch (InterruptedException e) {
          Log.logInfo("Exception: {0}", e.getMessage());
          Thread.currentThread().interrupt();
        }
      }
    }
    synchronized (full) {
      E value = queue.remove();
      full.notifyAll();
      return value;
    }
  }
}