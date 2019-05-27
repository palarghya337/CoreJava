package com.corejava.practice.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import com.corejava.practice.utils.Log;

public class FixedThreadPoolExample {
  
  public static void main (String... args) {

    ExecutorService pool = Executors.newFixedThreadPool(2);
    
    pool.execute(new CountDownClockFixed("A"));
    pool.execute(new CountDownClockFixed("B"));
    pool.execute(new CountDownClockFixed("C"));
    pool.execute(new CountDownClockFixed("D"));
    pool.shutdown();
  }
}

class CountDownClockFixed implements Runnable {

  private String clockName;
  public CountDownClockFixed(String clockName) {
    this.clockName = clockName;
  }

  public void run() {

    String threadName = Thread.currentThread().getName();
    IntStream.range(0, 5).forEach(i -> {

      Log.logInfo("{0} -> {1}: {2}", threadName, clockName, i);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        Log.logInfo("Exception: {0}", e.getMessage());
        Thread.currentThread().interrupt();
      }
    });
  }
}