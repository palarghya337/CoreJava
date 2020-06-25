package com.corejava.practice.classloader;

import java.io.File;

public class NoClassDefFoundErrorExample {

	public static void main(String[] args) {
		exampleOfNoClassDefFoundError();
	}
	/**
	 * <p>
	 * We get {@link NoClassDefFoundError} when a particular
	 * class was present at compile time, but somehow it is
	 * missing at run time.</p>
	 * 
	 * When you run the code you will see if .class file for Dummy
	 * is present then programmatically deletes that Dummy.class
	 * file to get {@link NoClassDefFoundError}.
	 */
	private static void exampleOfNoClassDefFoundError() {
		try {

			File file = new File(getAbsolutePath());
			System.out.println("AbsolutePath: " + file.getAbsolutePath());
			System.out.println("isFileExist: " + file.exists());
			System.out.println("isDeleted: " + file.delete());
			/* Here it is trying to create the object of Dummy and it
			 * will fail
			 */
			new NoClassDefFoundErrorExample().new Dummy();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	private static String getAbsolutePath() {

		String userDir = System.getProperty("user.dir");
		String packageName = NoClassDefFoundErrorExample.class
				.getPackage().getName();
		packageName = packageName.replaceAll("[//.]", "/");
		String className = "/NoClassDefFoundErrorExample$Dummy.class";
		String absolutePath = userDir + "/bin/" + packageName + className;
		return absolutePath;
	}
	/*
	 * Dummy class, whose .class file would be created and we will
	 * try to load and create object for this class.
	 **/
	class Dummy {
	}
}