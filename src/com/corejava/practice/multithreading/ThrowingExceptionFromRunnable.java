package com.corejava.practice.multithreading;

import java.util.concurrent.FutureTask;

import com.corejava.practice.exceptions.InvalidOperationException;
import com.corejava.practice.utils.Log;

public class ThrowingExceptionFromRunnable {

  public static void main(String[] args) {

    /* Creating an instance of Runnable interface which
     * is throwing an exception inside run() method
     **/
    Runnable runnableImpl = () -> {
      throw new InvalidOperationException("Exception is throwing from run() method of Runnable interface");
    };
    /* Creating an object of FutureTask by passing object of runnable
     * and result as null. Here result to return on successful completion.
     **/
    FutureTask<String> fTask = new FutureTask<>(runnableImpl, null);
    Thread t1 = new Thread(fTask);
    t1.start();
    try {
      fTask.get();
    } catch (Exception e) {
      Log.logInfo(e.getMessage());
    }
  }
}
