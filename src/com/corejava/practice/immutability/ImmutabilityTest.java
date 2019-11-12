package com.corejava.practice.immutability;

import com.corejava.practice.utils.Log;

public class ImmutabilityTest {

	public static void main(String[] args) {
		
		String obj1 = new String("StringObject");
		String obj2 = "StringObject";
		String obj3 = obj1;
		String obj4 = obj2.toUpperCase();
		String obj5 = "STRINGOBJECT";
		Log.logInfo(obj1 == obj2);
		Log.logInfo(obj1 == obj3);
		Log.logInfo(obj4 == obj5);
		Log.logInfo(obj4);
	}
}
