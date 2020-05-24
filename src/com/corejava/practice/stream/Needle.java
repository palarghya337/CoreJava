package com.corejava.practice.stream;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Needle {

	public static int count(String needle, InputStream haystack) throws Exception {
		
		if (haystack == null || needle == null
				|| needle.isEmpty()) {
			return 0;
		}
		InputStreamReader inputStreamReader = new InputStreamReader(haystack);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		
		String regex = "[^a-zA-Z0-9]";
		return (int) bufferedReader.lines()
				.map(words -> words.split(" "))
				.flatMap(Arrays::stream)
				.map(word -> word.replaceAll(regex, ""))
				.filter(word -> word.equalsIgnoreCase(needle))
				.count();
	}

	public static void main(String[] args) throws Exception {
		String inMessage = "Hello, there!\nHow are you today?\nYes, you over there.";

		try(InputStream inStream = new ByteArrayInputStream(inMessage.getBytes())) {
			System.out.println(Needle.count("there", inStream));
		}
	}
}
