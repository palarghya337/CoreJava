package com.corejava.practice.collections;

import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

import com.corejava.practice.utils.Log;

public class NavigableMapExample {

	public static void main(String[] args) {
		
		NavigableMap<Integer, String> naviMap = new TreeMap<>();
		naviMap.put(10, "Value-1");
		naviMap.put(7, "Value-2");
		naviMap.put(9, "Value-3");
		naviMap.put(5, "Value-4");
		Entry<Integer, String> entry = naviMap.ceilingEntry(8);
//		entry.setValue("Value-5");
		Log.logInfo(naviMap.lowerKey(9).toString());
	}
}
