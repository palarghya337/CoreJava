/* 
 * PORTWARE DISCLAIMER 
 * COPYRIGHT (C) 2004 PORTWARE LLC. ALL RIGHTS RESERVED. 
 * 
 * THIS SOURCE CODE AND/OR DOCUMENTATION IS THE CONFIDENTIAL AND PROPRIETARY 
 * INFORMATION OF PORTWARE,LLC. ("CONFIDENTIAL INFORMATION"). YOU SHALL  NOT 
 * DISCLOSE SUCH CONFIDENTIAL INFORMATION AND SHALL USE IT ONLY IN ACCORDANCE 
 * WITH THE TERMS OF THE LICENSE AND/OR NON-DISCLOSURE AGREEMENT YOU ENTERED 
 * INTO WITH PORTWARE. 
 * 
 * THIS PROGRAMMING CODE IS INTENDED FOR ILLUSTRATIVE PURPOSES ONLY. PORTWARE 
 * MAKES NO REPRESENTATIONS OR WARRANTIES, EITHER EXPRESS OR IMPLIED, ABOUT 
 * THE SUITABILITY OF THE CODE FOR PRODUCTION. THIS INCLUDES, BUT IS NOT 
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY, NON-INFRINGEMENT 
 * AND FITNESS FOR A PARTICULAR PURPOSE. PORTWARE SHALL NOT BE LIABLE FOR ANY 
 * DAMAGES SUFFERED AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS CODE 
 * OR ITS DERIVATIVES. 
 */ 
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
