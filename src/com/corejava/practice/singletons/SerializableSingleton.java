package com.corejava.practice.singletons;

import java.io.Serializable;

import com.corejava.practice.utils.Log;

public class SerializableSingleton implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private static final SerializableSingleton INSTANCE = new SerializableSingleton();
  
  private SerializableSingleton() {
    /* 
     * Making private constructor so that
     * no one can create another object.
     **/
  }
  /**
   * This is just a dummy method.
   */
  public void displaySingleton() {
    Log.logInfo("Singleton object was already created for {0}",
        Thread.currentThread().getStackTrace()[1].getClassName());
  }
  /**
   * For Serializable and Externalizable classes, the readResolve
   * method allows a class to replace/resolve the object read from
   * the stream before it is returned to the caller. By implementing
   * the readResolve method, a class can directly control the types
   * and instances of its own instances being deserialized.
   * The method is defined as follows - <p><b>
   * ANY-ACCESS-MODIFIER Object readResolve() throws ObjectStreamException;
   * </b></p>
   * The readResolve method is called when ObjectInputStream has read
   * an object from the stream and is preparing to return it to the caller.
   * ObjectInputStream checks whether the class of the object defines the
   * readResolve method. If the method is defined, the readResolve method
   * is called to allow the object in the stream to designate the object
   * to be returned. The object returned should be of a type that is
   * compatible with all uses. If it is not compatible, a ClassCastException
   * will be thrown when the type mismatch is discovered.
   * 
   * Non-final classes which implement readResolve(), should not
   * set its visibility to private since it will then be unavailable
   * to child classes.
   * @return
   */
  protected Object readResolve() {
    return INSTANCE;
  }
  /**
   * This method will return the same object of {@linkplain BillPughSingleton}
   * class every time.
   * 
   * @return SerializableSingleton
   */
  public static SerializableSingleton getInstance() {
    return INSTANCE;
  }
}
