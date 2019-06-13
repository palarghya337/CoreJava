package com.corejava.practice.multithreading;

import com.corejava.practice.utils.Log;

/**
 * This example will show how dead lock will happen if 
 * you call join method in improper way.
 * @author apal
 *
 */
public class DeadLockByJoinMethod {

  public static void main(String[] args) {
    try {
      Log.logInfo("Before join() method call.-{0}", Thread.currentThread().getName());
      /* In this case you are trying to join current thread.
       * What join method does? The join() method is used to
       * hold the execution of currently running thread until
       * the specified thread is dead(finished execution).
       * In our case currently running thread is main thread
       * and specified thread is also main thread which would
       * not able to finish the execution as that is on hold.
       **/
      Thread.currentThread().join();
      Log.logInfo("After join() method call.");
    } catch (InterruptedException e) {
      Log.logInfo("Exception: {0}", e.getMessage());
      Thread.currentThread().interrupt();
    }
  }
}
