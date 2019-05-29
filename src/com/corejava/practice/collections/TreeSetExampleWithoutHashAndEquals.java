package com.corejava.practice.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.corejava.practice.beans.ComparableImplWithoutHashAndEquals;
import com.corejava.practice.utils.Log;

/**
 * What will happen if we try to sort some object which does
 * not implement hashCode() and equals() method but it implements
 * sorting interface.
 * @author apal
 *
 */
public class TreeSetExampleWithoutHashAndEquals {

  public static void main(String[] args) {

    List<ComparableImplWithoutHashAndEquals> list = new ArrayList<>();
    list.add(new ComparableImplWithoutHashAndEquals("Sharath"));
    list.add(new ComparableImplWithoutHashAndEquals("Chandan"));
    list.add(new ComparableImplWithoutHashAndEquals("Bratajit"));

    Collections.sort(list);
    Log.logInfo(list);
  }
}

