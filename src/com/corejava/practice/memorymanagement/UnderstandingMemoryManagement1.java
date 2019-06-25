package com.corejava.practice.memorymanagement;

import java.util.Set;
import java.util.TreeSet;

import com.corejava.practice.utils.Log;

public class UnderstandingMemoryManagement1 {

  private static boolean flag = false;
  public static void main(String[] args) {
    
    Set<String> mainNameSet = getNameSet();
    mainNameSet.add("Name-6");
    /* In the below logging both will log false because method
     * getNameSet() will always create a new TreeSet object and
     * return that object by adding proper value to it. In this
     * case we have called getNameSet() method three times, that
     * means 2 object of TreeSet will be created. mainNameSet
     * variable will contain the reference of the first object
     * created. Now we are comparing first object reference with
     * the second "mainNameSet == getNameSet()" which will
     * obviously return false as both are different object. Again
     * we are equating first object value with third object value
     * "mainNameSet.equals(getNameSet())". As in the first object
     * we inserted new element so it will
     * return false.
     **/
    Log.logInfo(mainNameSet == getNameSet());
    Log.logInfo(mainNameSet.equals(getNameSet()));
    Log.logInfo("------main() END------");
  }
  /**
   * @return Set<String>
   */
  public static Set<String> getNameSet() {
    
    Set<String> nameSet = new TreeSet<>();
    nameSet.add("Name-1");
    nameSet.add("Name-2");
    nameSet.add("Name-3");
    nameSet.add("Name-4");
    
    Set<String> otherSet = nameSet;
    otherSet.add("Name-5");
    
    if (!flag ) {
      
      flag = true;
      /* In the below logging both will log true because variable nameSet
       * and otherSet both are referring to the same object and has same
       * value in it.
       * */
      Log.logInfo(nameSet == otherSet);
      Log.logInfo(nameSet.equals(otherSet));
      Log.logInfo("------getNameSet() END------");
    }
    return nameSet;
  }
}
