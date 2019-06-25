package com.corejava.practice.immutability;

public final class ImmutableHasAClass {

  private final int primitiveField;
  private final String immutableObject;
  
  public ImmutableHasAClass(int primitiveField, String immutableObject) {
    this.primitiveField = primitiveField;
    this.immutableObject = immutableObject;
  }

  public int getPrimitiveField() {
    return primitiveField;
  }

  public String getImmutableObject() {
    return immutableObject;
  }
}
