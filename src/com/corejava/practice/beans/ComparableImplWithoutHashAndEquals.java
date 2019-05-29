package com.corejava.practice.beans;

/**
 * This class does not override any hashCode() and equals() method of Object class.
 * @author apal
 *
 */
public class ComparableImplWithoutHashAndEquals implements Comparable<ComparableImplWithoutHashAndEquals> {

  private String name;

  public ComparableImplWithoutHashAndEquals(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public int compareTo(ComparableImplWithoutHashAndEquals o) {
    return this.name.compareTo(o.getName());
  }

  @Override
  public String toString() {
    return this.name;
  }
}
