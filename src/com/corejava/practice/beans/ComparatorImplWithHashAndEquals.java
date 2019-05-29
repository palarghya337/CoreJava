package com.corejava.practice.beans;

import java.util.Comparator;

/**
 * This class implements {@linkplain Comparator} interface and overrides hashCode() and equals()
 * method of Object class
 * @author apal
 *
 */
public class ComparatorImplWithHashAndEquals implements Comparator<ComparatorImplWithHashAndEquals> {

  private int age;

  public ComparatorImplWithHashAndEquals(int age) {
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
    return age == ((ComparatorImplWithHashAndEquals) obj).age;
  }

  @Override
  public int compare(ComparatorImplWithHashAndEquals o1, ComparatorImplWithHashAndEquals o2) {
    return o1.getAge() - o2.getAge();
  }

  @Override
  public String toString() {
    return "ComparatorImpl [age=" + age + "]";
  }
}
