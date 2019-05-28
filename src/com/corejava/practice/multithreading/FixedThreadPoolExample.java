package com.corejava.practice.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import com.corejava.practice.utils.Log;

public class FixedThreadPoolExample {
  
  public static void main (String... args) {

    ExecutorService pool = Executors.newFixedThreadPool(2);
    
    pool.execute(new Task("A"));
    pool.execute(new Task("B"));
    pool.execute(new Task("C"));
    pool.execute(new Task("D"));
    pool.shutdown();
  }
}
