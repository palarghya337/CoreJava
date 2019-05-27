package com.corejava.practice.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import com.corejava.practice.utils.Log;

public class CallebleExample {

  public static void main(String[] args) {
    // Using executor service
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Future<String> returnValue = executorService.submit(new CDThread());

    printResult(returnValue);
    Log.logInfo("Before executor service shutdown method.");
    executorService.shutdown();
    Log.logInfo("After executor service shutdown method.");

    // Using thread
    FutureTask<String> task = new FutureTask<>(new CDThread());
    Thread callableThread = new Thread(task);
    callableThread.start();
    printResult(task);
  }

  private static void printResult(Future<String> returnValue) {
    try {
      Log.logInfo(returnValue.get());
    } catch (InterruptedException | ExecutionException e) {

      Log.logInfo("Exception: {0}", e.getMessage());
      Thread.currentThread().interrupt();
    }
  }
}

class CDThread implements Callable<String> {

  @Override
  public String call() throws Exception {

    Log.logInfo("Before sleep");
    Thread.sleep(2000);
    Log.logInfo("After sleep");
    return Thread.currentThread().getName();
  }
}