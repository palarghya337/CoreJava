package com.corejava.practice.multithreading;

import java.util.Objects;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

import com.corejava.practice.utils.Log;

public class CyclicBarrierTask implements Runnable {

  private String taskName;
  private CyclicBarrier cyclicBarrier;

  public CyclicBarrierTask(String taskName, CyclicBarrier cyclicBarrier) {
    this.taskName = taskName;
    this.cyclicBarrier = cyclicBarrier;
  }

  @Override
  public void run() {

    IntStream.range(0, 2).forEach(index -> {
      sleep(500);
      Log.logInfo("Thread: {0}, Task: {1}, Index: {2}", Thread.currentThread().getName(), this.taskName, index);
    });
    if (!Objects.isNull(cyclicBarrier)) {
      try {
        // Waits until all parties have invoked await on this barrier. 
        cyclicBarrier.await();
      } catch (InterruptedException | BrokenBarrierException e) {
        Log.logInfo("Exception: {0}", e.getMessage());
        Thread.currentThread().interrupt();
      }
    }
    Log.logInfo("Task is done for all the threads and result is showing for - {0}", Thread.currentThread().getName());
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
