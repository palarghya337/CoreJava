package com.corejava.practice.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.corejava.practice.utils.Log;

public class FindNthLargestNumber {

	public static void main(String[] args) {
		
		List<Integer> listOfNumbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		long findLargestPosition = 5;
		int max = listOfNumbers.stream()
				.sorted(Collections.reverseOrder())
				.limit(findLargestPosition).skip(findLargestPosition - 1)
				.findFirst().orElse(-1).intValue();
		Log.logInfo("Max: {0}", max);
	}
}
