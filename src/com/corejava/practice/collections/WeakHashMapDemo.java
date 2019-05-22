package com.corejava.practice.collections;

import java.util.Map;
import java.util.WeakHashMap;

import com.corejava.practice.utils.Log;

public class WeakHashMapDemo {

	public static void main(String[] args) {
		
		/* If we use WeakHashMap if key does not
		 * hold any object then that object will
		 * be garbage collected.
		 **/
		Map<Integer, String> whm = new WeakHashMap<>();
		Integer key = Integer.valueOf(22148);
		whm.put(key, "Value");
		Log.logInfo("WeakHashMap before System.gc() method call." + whm.toString());
		key = null; // freeing the reference
		/* Calling this method suggests that the Java Virtual
		 * Machine expend effort toward recycling unused objects
		 * in order to make the memory they currently occupy
		 * available for quick reuse. When control returns from
		 * the method call, the Java Virtual Machine has made
		 * a best effort to reclaim space from all discarded objects.
		 * This method does not guarantee the garbage collection.
		 **/
		System.gc();
		try {
			Log.logInfo("Waiting for some time for garbage collection...");
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		Log.logInfo("WeakHashMap after System.gc() method call.\n" + whm.toString());
	}
}
