package com.corejava.practice.singletons;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.corejava.practice.utils.Log;

public class TestSingleton {

  public static void main(String[] args) {
    
    testBillPughSingleton();
    testSerializableSingleton();
  }

  /**
   * 
   */
  private static void testBillPughSingleton() {
    
    try {
      Class<BillPughSingleton> billPughSingletonClass = BillPughSingleton.class;
      Constructor<BillPughSingleton> billPughSingletonConstructor = billPughSingletonClass.getDeclaredConstructor();
      billPughSingletonConstructor.setAccessible(true);
      BillPughSingleton billPughSingleton = billPughSingletonConstructor.newInstance();
      billPughSingleton.displaySingleton();
      
      Log.logInfo("BillPughSingleton1 hashCode:- {0}", billPughSingleton.hashCode()); 
      Log.logInfo("BillPughSingleton2 hashCode:- {0}", BillPughSingleton.getInstance().hashCode());
    } catch (InstantiationException | IllegalAccessException | NoSuchMethodException
        | SecurityException | IllegalArgumentException | InvocationTargetException e) {
      Log.logInfo("Exception: {0}", e);
    }
  }

  /**
   * 
   */
  private static void testSerializableSingleton() {
    try (
        ObjectOutput outStream = new ObjectOutputStream(new FileOutputStream("file.text"));
        ObjectInput inStream = new ObjectInputStream(new FileInputStream("file.text"));
        ) {

      SerializableSingleton instance1 = SerializableSingleton.getInstance();
      outStream.writeObject(instance1);
      SerializableSingleton instance2 = (SerializableSingleton) inStream.readObject();

      Log.logInfo("instance1 hashCode:- {0}", instance1.hashCode()); 
      Log.logInfo("instance2 hashCode:- {0}", instance2.hashCode());
    } catch (ClassNotFoundException | IOException e) {
      Log.logInfo("Exception: {0}", e.getMessage());
    }
  }
  private static <E> E getInstance(String className) {
    // Need to implement
    return null;
  }
}
