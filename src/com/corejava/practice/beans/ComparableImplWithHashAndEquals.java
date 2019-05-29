package com.corejava.practice.beans;

/**
 * This class implements {@linkplain Comparable} interface and overrides hashCode() and equals()
 * method of Object class
 * @author apal
 *
 */
public class ComparableImplWithHashAndEquals implements Comparable<ComparableImplWithHashAndEquals> {

  private int age;

  public ComparableImplWithHashAndEquals(int age) {
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
    return age == ((ComparableImplWithHashAndEquals) obj).age;
  }

  @Override
  public int compareTo(ComparableImplWithHashAndEquals o) {
    return this.getAge() - o.getAge();
  }

  @Override
  public String toString() {
    return "ComparableImpl [age=" + age + "]";
  }
}
