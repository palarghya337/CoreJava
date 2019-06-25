package com.corejava.practice.immutability;

import java.util.Collections;
import java.util.List;

public final class ImmutableClass {

  private final int primitiveField;
  private final String immutablObjField;
  private final ImmutableHasAClass hasARelationshipClass;
  private final List<String> collectionField;
  
  public ImmutableClass(int primitiveField, String immutablObjField,
      ImmutableHasAClass hasARelationshipClass, List<String> collectionField) {
    
    this.primitiveField = primitiveField;
    this.immutablObjField = immutablObjField;
    this.hasARelationshipClass = hasARelationshipClass;
    this.collectionField = collectionField;
  }

  public int getPrimitiveField() {
    return primitiveField;
  }

  public String getImmutablObjField() {
    return immutablObjField;
  }

  public ImmutableHasAClass getHasARelationshipClass() {
    return hasARelationshipClass;
  }

  public List<String> getCollectionField() {
    return Collections.unmodifiableList(collectionField);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((collectionField == null) ? 0 : collectionField.hashCode());
    result = prime * result + ((hasARelationshipClass == null) ? 0 : hasARelationshipClass.hashCode());
    result = prime * result + ((immutablObjField == null) ? 0 : immutablObjField.hashCode());
    result = prime * result + primitiveField;
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
    ImmutableClass other = (ImmutableClass) obj;
    if (collectionField == null) {
      if (other.collectionField != null)
        return false;
    } else if (!collectionField.equals(other.collectionField))
      return false;
    if (hasARelationshipClass == null) {
      if (other.hasARelationshipClass != null)
        return false;
    } else if (!hasARelationshipClass.equals(other.hasARelationshipClass))
      return false;
    if (immutablObjField == null) {
      if (other.immutablObjField != null)
        return false;
    } else if (!immutablObjField.equals(other.immutablObjField))
      return false;
    if (primitiveField != other.primitiveField)
      return false;
    return true;
  }
}
