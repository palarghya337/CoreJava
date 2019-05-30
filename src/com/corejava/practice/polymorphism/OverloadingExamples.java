package com.corejava.practice.polymorphism;

import com.corejava.practice.utils.Log;

public class OverloadingExamples {

  public static void main(String[] args) {

    Log.logInfo(overloadingDemo(10, 20));
    Log.logInfo(overloadingDemo(new Integer(10), new Integer(20)));
    Log.logInfo(overloadingDemo(10, new Integer(20)));
    Log.logInfo(overloadingDemo(new Integer(10), 20));
    Log.logInfo(overloadingDemo(10, 20.51f));
    Log.logInfo(overloadingDemo(10, 20.51));
    Log.logInfo(overloadingDemo(new Integer(10), 20.51));
    /* This below method call is ambiguous because we can assign null
     * to Integer as well as Double.
     * */
//    Log.logInfo(overloadingDemo(null));
    Log.logInfo(overloadingDemo(10));
    Log.logInfo(overloadingDemo(10.52));
    /* Below method will throw the compile time exception because
     * 10.52 will consider as a double value and there is no such
     * overloaded method which takes double and integer as a parameter.
     **/
//    Log.logInfo(overloadingDemo(10.52, 10)); 
  }

  private static String overloadingDemo(int a, int b) {
    return "(int a, int b) -> " + (a + b);
  }

  private static String overloadingDemo(Integer a, Integer b) {
    return "(Integer a, Integer b) -> " + (a + b);
  }

  private static String overloadingDemo(int a, Integer b) {
    return "(int a, Integer b) -> " + (a + b);
  }

  private static String overloadingDemo(Integer a, int b) {
    return "(Integer a, int b) -> " + (a + b);
  }

  private static String overloadingDemo(int a, float b) {
    return "(int a, float b) -> " + (a + b);
  }

  private static String overloadingDemo(int a, double b) {
    return "(int a, double b) -> " + (a + b);
  }
  
  private static String overloadingDemo(Integer a, double b) {
    return "(Integer a, double b) -> " + (a + b);
  }

  private static String overloadingDemo(Object obj) {
    return "(Object obj) -> " + obj;
  }

  private static String overloadingDemo(String obj) {
    return "(String obj) -> " + obj;
  }

  private static String overloadingDemo(Integer obj) {
    return "(Integer obj) -> " + obj;
  }

  private static String overloadingDemo(Double obj) {
    return "(Double obj) -> " + obj;
  }

  private static String overloadingDemo(float a, int b) {
    return "(float a, int b) -> " + (a + b);
  }
}
