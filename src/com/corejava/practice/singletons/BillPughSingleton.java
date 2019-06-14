package com.corejava.practice.singletons;

import com.corejava.practice.utils.Log;

public class BillPughSingleton {

  private BillPughSingleton() {
    /* 
     * Making private constructor so that
     * no one can create another object.
     **/
    if (InstanceHolder.INSTANCE != null) {
      throw new UnsupportedOperationException("Multiple instance creation is not allowed.");
    }
  }
  /**
   * This method will return the same object of {@linkplain BillPughSingleton}
   * class every time.
   * 
   * @return UsingInstanceHolder
   */
  public static BillPughSingleton getInstance() {
    return InstanceHolder.INSTANCE;
  }
  /**
   * This is just a dummy method.
   */
  public void displaySingleton() {
    Log.logInfo("Singleton object was already created for {0}",
        Thread.currentThread().getStackTrace()[1].getClassName());
  } 
  /**
   * @author apal
   *
   */
  private static final class InstanceHolder {
    
    private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    private InstanceHolder() {
      /* 
       * Making private constructor so that
       * no one can create another object.
       **/
    }
  }
}
