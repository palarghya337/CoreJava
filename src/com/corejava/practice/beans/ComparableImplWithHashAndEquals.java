/* 
 * PORTWARE DISCLAIMER 
 * COPYRIGHT (C) 2004 PORTWARE LLC. ALL RIGHTS RESERVED. 
 * 
 * THIS SOURCE CODE AND/OR DOCUMENTATION IS THE CONFIDENTIAL AND PROPRIETARY 
 * INFORMATION OF PORTWARE,LLC. ("CONFIDENTIAL INFORMATION"). YOU SHALL  NOT 
 * DISCLOSE SUCH CONFIDENTIAL INFORMATION AND SHALL USE IT ONLY IN ACCORDANCE 
 * WITH THE TERMS OF THE LICENSE AND/OR NON-DISCLOSURE AGREEMENT YOU ENTERED 
 * INTO WITH PORTWARE. 
 * 
 * THIS PROGRAMMING CODE IS INTENDED FOR ILLUSTRATIVE PURPOSES ONLY. PORTWARE 
 * MAKES NO REPRESENTATIONS OR WARRANTIES, EITHER EXPRESS OR IMPLIED, ABOUT 
 * THE SUITABILITY OF THE CODE FOR PRODUCTION. THIS INCLUDES, BUT IS NOT 
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY, NON-INFRINGEMENT 
 * AND FITNESS FOR A PARTICULAR PURPOSE. PORTWARE SHALL NOT BE LIABLE FOR ANY 
 * DAMAGES SUFFERED AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS CODE 
 * OR ITS DERIVATIVES. 
 */ 
package com.corejava.practice.beans;

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
