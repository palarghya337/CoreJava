package com.corejava.practice.generics;

import java.util.ArrayList;
import java.util.List;

public class SuperAndExtendsInGenerics {

	public static void main(String[] args) {
		
		method(new ArrayList<Child>());
		method(new ArrayList<MyParent>());
		/* 
		 * Below method call will fail because MyGrandParent
		 * class is not child or same type of MyParent class
		 */
//		method(new ArrayList<GrandParent>());
		method2(new ArrayList<MyGrandParent>());
		/*
		 * Below method call will fail because Child class is
		 * not the super or same type of MyParent class.
		 **/
//		method2(new ArrayList<Child>());
	}
	/**
	 * This method only can take list of objects which are
	 * sub type of Number
	 * 
	 * @param listOfNumbers
	 */
	public static void method(List<? extends MyParent> listOfNumbers) {
		// some operation
	}
	/**
	 * @param listOfInteger takes only list of objects which are
	 * super type of Integer;
	 */
	public static void method2(List<? super MyParent> listOfInteger) {
		// some operation
	}
	private class MyGrandParent {}
	private class MyParent extends MyGrandParent {}
	private class Child extends MyParent {}
}