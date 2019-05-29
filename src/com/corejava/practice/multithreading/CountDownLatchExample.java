package com.corejava.practice.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.corejava.practice.utils.Log;

public class CountDownLatchExample {

  public static void main(String[] args) {
    
    /* Given the count as 4 so it will wait 4 thread to complete
     * it's task. then it will execute all the other task present
     * after await() method.
     **/
    CountDownLatch countDownLatch = new CountDownLatch(5);
    ExecutorService executorService = Executors.newFixedThreadPool(4);
    executorService.execute(new CountDownLatchTask("Task-1", countDownLatch));
    executorService.execute(new CountDownLatchTask("Task-2", countDownLatch));
    executorService.execute(new CountDownLatchTask("Task-3", countDownLatch));
    executorService.execute(new CountDownLatchTask("Task-4", countDownLatch));
    executorService.shutdown();
    try {
      countDownLatch.await();
    } catch (InterruptedException e) {
      Log.logInfo("Exception: {0}", e.getMessage());
      Thread.currentThread().interrupt();
    }
    Log.logInfo("All the tasks are done.");
  }
}
