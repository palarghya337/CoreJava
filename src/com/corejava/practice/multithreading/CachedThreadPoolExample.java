package com.corejava.practice.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import com.corejava.practice.utils.Log;

public class CachedThreadPoolExample {

  public static void main (String... args) {

    ExecutorService pool = Executors.newCachedThreadPool();
    pool.execute(new CountDownClock("A"));
    pool.execute(new CountDownClock("B"));
    pool.execute(new CountDownClock("C"));
    pool.execute(new CountDownClock("D"));
    pool.shutdown();
  }
}

class CountDownClock implements Runnable {

  private String clockName;
  public CountDownClock(String clockName) {
    this.clockName = clockName;
  }

  public void run() {

    String threadName = Thread.currentThread().getName();
    IntStream.range(0, 5).forEach(index -> {

      Log.logInfo("{0} -> {1}: {2}", threadName, clockName, index);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        Log.logInfo("Exception: {0}", e.getMessage());
        Thread.currentThread().interrupt();
      }
    });
  }
}
