package com.corejava.practice.singletons;

import com.corejava.practice.utils.Log;

public enum EnumSingleton {

  INSTANCE;
  
  /**
   * This is just a dummy method.
   */
  public void displaySingleton() {
    Log.logInfo("Singleton object was already created for {0}",
        Thread.currentThread().getStackTrace()[1].getClassName());
  } 
}
