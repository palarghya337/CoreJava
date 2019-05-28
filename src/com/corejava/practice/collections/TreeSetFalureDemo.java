package com.corejava.practice.collections;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import com.corejava.practice.utils.Log;

/**
 * This class will show the result, what will
 * happen if you are trying to add an object
 * which does not implement {@link Comparable}
 * interface.
 * @author Bittu
 *
 */
public class TreeSetFalureDemo {

	public static void main(String[] args) {
		
//		addObjectWihoutComparableImplementation();
//		addObjectWhichImplementsComparableInterface();
		addObjectWhichImplementsComparatorInterface();
	}

	private static void addObjectWhichImplementsComparatorInterface() {
		
		Set<ComparatorImpl> set = new TreeSet<>();
		set.add(new ComparatorImpl(42));
		set.add(new ComparatorImpl(52));
		set.add(new ComparatorImpl(29));
		set.add(new ComparatorImpl(34));
		Log.logInfo(set.toString());
	}
	private static void addObjectWhichImplementsComparableInterface() {
		Set<ComparableImpl> set = new TreeSet<>();
		set.add(new ComparableImpl(42));
		set.add(new ComparableImpl(52));
		set.add(new ComparableImpl(29));
		set.add(new ComparableImpl(34));
		Log.logInfo(set.toString());
	}

	private static void addObjectWihoutComparableImplementation() {
		
		Set<WithoutComparableImplementation> set = new TreeSet<>();
		set.add(new WithoutComparableImplementation(42));
		set.add(new WithoutComparableImplementation(52));
		set.add(new WithoutComparableImplementation(29));
		set.add(new WithoutComparableImplementation(34));
		Log.logInfo(set.toString());
	}
}
class WithoutComparableImplementation {
	
	private int age;
	
	public WithoutComparableImplementation(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
}
/**
 * @author Bittu
 *
 */
class ComparableImpl implements Comparable<ComparableImpl> {
	
	private int age;
	public ComparableImpl(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComparableImpl other = (ComparableImpl) obj;
		if (age != other.age)
			return false;
		return true;
	}
	
	@Override
	public int compareTo(ComparableImpl o) {
		return this.getAge() - o.getAge();
	}
	@Override
	public String toString() {
		return "ComparableImpl [age=" + age + "]";
	}
}
class ComparatorImpl implements Comparator<ComparatorImpl> {
	
	private int age;
	public ComparatorImpl(int age) {
		this.age = age;
	}
	public int getAge() {
		return this.age;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComparatorImpl other = (ComparatorImpl) obj;
		if (age != other.age)
			return false;
		return true;
	}
	@Override
	public int compare(ComparatorImpl o1, ComparatorImpl o2) {
		return o1.getAge() - o2.getAge();
	}
	@Override
	public String toString() {
		return "ComparatorImpl [age=" + age + "]";
	}
}