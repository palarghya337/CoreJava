package com.corejava.practice.interfaces;

@FunctionalInterface
public interface Function2<T, U, V> {

    public V apply(T t, U u);

    default void count() {
    	System.out.println("some count operation");
    }
}
