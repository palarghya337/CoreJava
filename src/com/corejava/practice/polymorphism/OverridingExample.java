package com.corejava.practice.polymorphism;

import com.corejava.practice.exceptions.CheckedException;
import com.corejava.practice.exceptions.UncheckedException;
import com.corejava.practice.utils.Log;

public class OverridingExample extends Parent {

	public static void main(String[] args) {
		OverridingExample overridingExample = new OverridingExample();
		try {
			overridingExample.method1();
		} catch (UncheckedException e2) {
			Log.logInfo(e2.getMessage());
		}
		try {
			overridingExample.method2();
		} catch (CheckedException e1) {
			Log.logInfo(e1.getMessage());
		}
		
		overridingExample.method5();
		Parent parent = new OverridingExample();
		try {
			parent.method2();
		} catch (Exception e) {
			Log.logInfo("Exception: {0}", e.getMessage());
		}
	}
	/*
	@Override
	protected void method1() throws CheckedException {
		/* parent class method is not throwing any exception but
		 * child class method is throwing checked exception which
		 * is not allowed.
	}*/

	/* (non-Javadoc)
	 * @see com.corejava.practice.polymorphism.Parent#method1()
	 * parent class method is not throwing any exception but child
	 * method is throwing unchecked exception which is allowed.
	 */
	@Override
	protected void method1() throws UncheckedException {
		throw new UncheckedException("parent class method is not throwing any exception but child"
				+ "method is throwing unchecked exception which is allowed.");
	}
	/* (non-Javadoc)
	 * @see com.corejava.practice.polymorphism.Parent#method2()
	 * Parent class method is throwing parent exception but child
	 * class method is throwing child exception which is allowed.
	 */
	@Override
	protected void method2() throws CheckedException {
		throw new CheckedException("Parent class method is throwing parent exception but child"
				+ "class method is throwing child exception which is allowed.");
	}

	/*
	@Override
	protected void method3() throws CheckedException {
		  /* parent method is throwing unchecked exception
	 * but child method is throwing checked exception
	 * which is not allowed.
	 ** //
	}*/
	/* (non-Javadoc)
	 * @see com.corejava.practice.polymorphism.Parent#method3()
	 * Parent class method is throwing child unchecked exception
	 * but child class is throwing parent unchecked exception
	 * which is allowed.
	 */
	@Override
	protected void method3() throws RuntimeException {
		throw new RuntimeException("Parent class method is throwing child unchecked exception,"
				+ "but child class is throwing parent unchecked exception which is allowed.");
	}
	/* (non-Javadoc)
	 * @see com.corejava.practice.polymorphism.Parent#method4()
	 * parent class method is throwing checked exception but
	 * child class method is not throwing any exception which is allowed.
	 */
	@Override
	protected void method4() {
		Log.logInfo("Overridden method is not throwing any exception which is allowed.");
	}

	/**
	 * This will throw the Compile time exception as throwing
	 * parent exception is not allowed in the overloaded exception.
	 * 
	 */

	@Override
	protected String method5() {
		Log.logInfo(
				"Overriding is possible by changeing the returntype.\n If child class is returning an object of a sub class type.");
		return "Returning object of String class";
	}
	/**
	 * The below example is of hiding the method.
	 * When we create a static method with the same name and
	 * signature of the parent class, parent class method
	 * would be hidden and child class method will be shown.
	 * This is called method hiding.
	 */
	//@Override
	protected static void staticMethod() {
		Log.logInfo("This is child class static method.");
	}
}

class Parent {

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
  protected static void staticMethod() {
	  Log.logInfo("This is parent class static method.");
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