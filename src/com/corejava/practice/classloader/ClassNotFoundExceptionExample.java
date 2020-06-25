package com.corejava.practice.classloader;

public class ClassNotFoundExceptionExample {

	public static void main(String[] args) {
		
		Class<?> classObj = loadClass();
		if (classObj != null) {
			
			System.out.println("Class object is created for class "
					+ classObj.getName());
		}
	}

	/**
	 * <p>
	 * In this example we will see {@linkplain ClassNotFoundException}.
	 * When Java program dynamically tries to load a Java class
	 * and don’t find the corresponding class file on
	 * the classpath it will throw ClassNotFoundException.
	 * </p><p>
	 * If presence of any class on Java classpath is not checked
	 * on compile time. Even if those classes are not present
	 * on Java classpath, your program will compile successfully
	 * and only fail when you try to run it.
	 * </p>
	 * <p>
	 * Below it will try to load the class from class path. In
	 * case of eclipse by default it stores the .class file in
	 * the <b><i>bin/src/< package-location>/< class-name></i></b>.
	 * In this case .class file is stored in
	 * <b><i>bin/src/com/corejava/practice/classloader/.</i></b>
	 * <br>
	 * Delete the .class file from there(if present) and try to
	 * run this code you will get the exception. 
	 * </p>
	 * @return Class<?>
	 */
	private static Class<?> loadClass() {
		try {
			return Class.forName("com.corejava.practice.classloader.ClassNotFoundExceptionExample$Dummy");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * Dummy class, whose .class file would be created and we
	 * will try to load this class.
	 **/
	class Dummy {
	}
}
