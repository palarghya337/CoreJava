package com.corejava.practice.classloader;

import com.corejava.practice.utils.Log;

public class ClassLoaderExamples {

	public static void main(String[] args) {
		differentClassLoaders();
		exampleOne();
		Log.logInfo(System.getProperty("java.class.path"));
	}

	/**
	 * According to visibility principle, Child ClassLoader can
	 * see class loaded by Parent ClassLoader but vice-versa is
	 * not true. Which mean if class Abc is loaded by Application
	 * class loader than trying to load class ABC explicitly
	 * using extension ClassLoader will throw either
	 * java.lang.ClassNotFoundException. as shown in below Example
	 */
	private static void exampleOne() {
		try {
			Class<ClassLoaderExamples> classObj = (Class<ClassLoaderExamples>) Class
					.forName("com.corejava.practice.classloader.ClassLoaderExamples",
					true, ClassLoaderExamples.class.getClassLoader());
			Class<ClassLoaderExamples> classObj1 = (Class<ClassLoaderExamples>) Class.forName("com.corejava.practice.classloader.ClassLoaderExamples",
					true, ClassLoaderExamples.class.getClassLoader());
			Log.logInfo(classObj);
			Log.logInfo(classObj1);
		} catch (ClassNotFoundException e) {
			Log.logInfo(e);
		}
	}

	private static void differentClassLoaders() {
		Log.logInfo(ClassLoaderExamples.class.getClassLoader());
		Log.logInfo(ClassLoaderExamples.class.getClassLoader().getParent());
		Log.logInfo(ClassLoaderExamples.class.getClassLoader().getParent().getParent());
	}
}
