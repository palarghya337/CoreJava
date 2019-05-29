package com.corejava.practice.multithreading;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample {

  public static void main(String[] args) {

    CyclicBarrier barrier = new CyclicBarrier(4);
    ExecutorService executorService = Executors.newFixedThreadPool(4);
    executorService.execute(new CyclicBarrierTask("Task-1", barrier));
    executorService.execute(new CyclicBarrierTask("Task-2", barrier));
    executorService.execute(new CyclicBarrierTask("Task-3", barrier));
    executorService.execute(new CyclicBarrierTask("Task-4", barrier));
    executorService.shutdown();
  }

}
