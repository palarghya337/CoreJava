package com.corejava.practice.collections;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import com.corejava.practice.beans.ComparableImplWithHashAndEquals;
import com.corejava.practice.beans.ComparatorImplWithHashAndEquals;
import com.corejava.practice.beans.WithoutComparableImplementation;
import com.corejava.practice.utils.Log;

/**
 * This class will show the result, when you are trying to add an object
 * which does not implement {@link Comparable} interface.
 * @author Bittu
 *
 */
public class TreeSetFalureDemo {

	public static void main(String[] args) {

		resultWhenObjectWihoutComparableImplementation();
//		resultWhenObjectImplementsComparatorInterface();
//		resultWhenObjectImplementsComparableInterface();
	}

	/**
	 * This method will show the result if we are trying to sort an object
	 * which implements {@linkplain Comparator} interface but not {@linkplain Comparable}
	 * interface.
	 */
	private static void resultWhenObjectImplementsComparatorInterface() {

		Set<ComparatorImplWithHashAndEquals> set = new TreeSet<>();
		set.add(new ComparatorImplWithHashAndEquals(42));
		set.add(new ComparatorImplWithHashAndEquals(52));
		set.add(new ComparatorImplWithHashAndEquals(29));
		set.add(new ComparatorImplWithHashAndEquals(34));
		Log.logInfo(set.toString());
	}

	/**
	 * This method will show the result if we are trying to sort an object
	 * which implements {@linkplain Comparable} interface.
	 */
	private static void resultWhenObjectImplementsComparableInterface() {
		Set<ComparableImplWithHashAndEquals> set = new TreeSet<>();
		set.add(new ComparableImplWithHashAndEquals(42));
		set.add(new ComparableImplWithHashAndEquals(52));
		set.add(new ComparableImplWithHashAndEquals(29));
		set.add(new ComparableImplWithHashAndEquals(34));
		Log.logInfo(set.toString());
	}

	/**
	 * This method will show the result if we are trying to sort an object
	 * which does not implements {@linkplain Comparable} interface.
	 */
	private static void resultWhenObjectWihoutComparableImplementation() {

		Set<WithoutComparableImplementation> set = new TreeSet<>();
		set.add(new WithoutComparableImplementation(42));
		set.add(new WithoutComparableImplementation(52));
		set.add(new WithoutComparableImplementation(29));
		set.add(new WithoutComparableImplementation(34));
		Log.logInfo(set.toString());
	}
}
