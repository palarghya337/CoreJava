package com.corejava.practice.stream;

import java.util.Arrays;
import java.util.List;

import com.corejava.practice.utils.Log;

public class SingleVsParallelStream {

	public static void main(String[] args) {
		
		List<Integer> listOfNumbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
		Log.logInfo("----- Execution of stream() -----");
		listOfNumbers.stream().forEach(Log::logInfo);
		Log.logInfo("----- Execution of parallelStream() -----");
		listOfNumbers.parallelStream().forEach(Log::logInfo);
	}
}
