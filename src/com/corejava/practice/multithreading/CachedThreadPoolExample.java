package com.corejava.practice.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.corejava.practice.utils.Log;

public class CachedThreadPoolExample {

  public static void main (String... args) {

    /* Creates a thread pool that creates new threads as needed,
     * but will reuse previously constructed threads when they
     * are available. These pools will typically improve the
     * performance of programs that execute many short-lived
     * asynchronous tasks. Calls to execute will reuse previously
     * constructed threads if available. If no existing thread
     * is available, a new thread will be created and added to
     * the pool. Threads that have not been used for sixty
     * seconds are terminated and removed from the cache. Thus,
     * a pool that remains idle for long enough will not consume
     * any resources. Note that pools with similar properties but
     * different details (for example, timeout parameters) may
     * be created using ThreadPoolExecutor constructors.
     **/
    ExecutorService pool = Executors.newCachedThreadPool();
    pool.execute(new Task("A"));
    pool.execute(new Task("B"));
    pool.execute(new Task("C"));
    pool.execute(new Task("D"));
    /* Call of this shutdown() method would not shutdown the
     * service immediately. Instead it will wait for the
     * existing task to complete then shut down. No new task
     * would be accepter after this method call.
     **/
    pool.shutdown();
    Log.logInfo("ExecutorService will be shut down.");
  }
}
