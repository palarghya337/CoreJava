package com.corejava.practice.interfaces;

/**
 * It is not mandatory to define a Functional Interface with
 * @FunctionalInterface annotation. If we don’t want, we can
 * omit this annotation. However, if we use it in Functional
 * Interface definition, Java Compiler forces to use one and
 * only one abstract method inside that interface.
 * @author Bittu
 *
 */
@FunctionalInterface
public interface ImplementFunctionalInterface {

	/*
	 * We cannot define more than one abstract method.
	 * Have to use @FunctionalInterface annotation in interface definition.
	 * We can define any number of other methods like Default methods,
	 * Static methods.
	 * If we override java.lang.Object class’s method as an abstract method,
	 * which does not count as an abstract method.
	 **/
	public abstract int addNumbers(int firstNumber, int secondNumber);
	public default int substractNumbers(int firstNumber, int secondNumber) {
		return firstNumber - secondNumber;
	}
	public static int multiplyNumbers(int firstNumber, int secondNumber) {
		return firstNumber * secondNumber;
	}
	public abstract String toString();
	public abstract int hashCode();
	public static final int SIZE = 10;
	public enum TYPE {
		Open, Close
	}
}
