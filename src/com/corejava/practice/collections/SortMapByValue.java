package com.corejava.practice.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.corejava.practice.utils.Log;

public class SortMapByValue {

  public static void main(String[] args) {

    Map<String, Integer> keyValue = new HashMap<>();
    keyValue.put("Math", 98);
    keyValue.put("Data Structure", 85);
    keyValue.put("Database", 91);
    keyValue.put("Java", 95);
    keyValue.put("Operating System", 79);
    keyValue.put("Networking", 80);

    Log.logInfo("Before sorting: {0}", keyValue);
    List<Map.Entry<String, Integer>> entrySet = new ArrayList<>(keyValue.entrySet());
    Collections.sort(entrySet, (item1, item2) -> item1.getValue().compareTo(item2.getValue()));
    /* Storing the value into LinkedHashMap because it will maintain
     * insertion order.
     * */
    Map<String, Integer> sortedByValue = new LinkedHashMap<>();
    entrySet.forEach(entry -> sortedByValue.put(entry.getKey(), entry.getValue()));
    Log.logInfo("After sorting: {0}", sortedByValue);
  }
}
