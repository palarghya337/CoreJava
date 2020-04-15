package com.corejava.practice.classloader;

import java.io.File;

public class GetCurrentWD {

	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		
		File file = new File("./");
		System.out.println(file.getAbsolutePath());
		
		System.out.println(GetCurrentWD.class.getProtectionDomain().getCodeSource().getLocation().toString());
	}
}
