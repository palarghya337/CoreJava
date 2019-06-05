package com.corejava.practice.polymorphism;

import com.corejava.practice.exceptions.CheckedException;
import com.corejava.practice.exceptions.UncheckedException;
import com.corejava.practice.utils.Log;

public class OverridingExample extends Parent {

  public static void main(String[] args) {
    OverridingExample overridingExample = new OverridingExample();
    overridingExample.method1();
    try {
      overridingExample.method2();
    } catch (CheckedException e1) {
      Log.logInfo("Handled checked exception. {0}", e1.getMessage());
    }
    overridingExample.method5();
    Parent parent = new OverridingExample();
    try {
      parent.method2();
    } catch (Exception e) {
      Log.logInfo("Exception: {0}", e.getMessage());
    }
  }

  @Override
  protected void method2() throws CheckedException {
    Log.logInfo("Overridden method is throwing child checked exception which is allowed.");
    throw new CheckedException("Throwing CheckedException from " + getCurrentMethod());
  }

  @Override
  protected void method4() {
    Log.logInfo("Overridden method is not throwing any exception which is allowed.");
  }

  /**
   * This will throw the Compile time exception as throwing
   * parent exception is not allowed in the overloaded exception.
   * 
   */
  /*
  @Override
  protected void method3() throws Exception {
    System.out.println(getCurrentMethod());
  }*/

  @Override
  protected String method5() {
    Log.logInfo(
        "Overriding is possible by changeing the returntype.\n If child class is returning an object of a sub class type.");
    return "Returning object of String class";
  }
}

class Parent {

  private static final String CLASS_NAME = Parent.class.getSimpleName();

  protected void method1() {
    Log.logInfo("Inside {0}", getCurrentMethod());
  }

  protected void method2() throws Exception {
    throw new Exception("Throwing Exception from " + getCurrentMethod());
  }

  protected void method3() throws UncheckedException {
    throw new UncheckedException("Throwing UncheckedException from " + getCurrentMethod());
  }

  protected void method4() throws CheckedException {
    throw new CheckedException("Throwing checked exception from " + getCurrentMethod());
  }

  protected Object method5() {
    return "Returning object of Object class";
  }

  protected String getCurrentMethod() {
    StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[2];
    StringBuilder builder = new StringBuilder();
    Class<?> classObj;
    try {
      classObj = Class.forName(stackTraceElement.getClassName());
      builder.append(classObj.getSimpleName());
    } catch (ClassNotFoundException e) {
      Log.logInfo("Exception: {0}", e.getMessage());
    }
    builder.append(">>");
    builder.append(stackTraceElement.getMethodName());
    return builder.toString();
  }
}