package com.corejava.practice.multithreading;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

import com.corejava.practice.utils.Log;

public class CountDownLatchTask implements Runnable {

  private String taskName;
  private CountDownLatch countDownLatch;

  public CountDownLatchTask(String taskName, CountDownLatch countDownLatch) {
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
