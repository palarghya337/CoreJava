package com.corejava.practice.beans;

public class WithoutComparableImplementation {

	private int age;

	public WithoutComparableImplementation(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "WithoutComparableImplementation [age=" + age + "]";
	}
}
