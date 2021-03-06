package com.corejava.practice.timeutils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.corejava.practice.utils.Log;

public class DisplayZoneAndOffSet {

  public static void main(String[] argv) {

    Map<String, String> sortedMap = new LinkedHashMap<>();

    List<String> zoneList = new ArrayList<>(ZoneId.getAvailableZoneIds());

    //Get all ZoneIds
    Map<String, String> allZoneIds = getAllZoneIds(zoneList);

    //sort map by key
    /*allZoneIds.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(e -> sortedMap.put(e.getKey(), e.getValue()));*/

    //sort by value, descending order
    allZoneIds.entrySet().stream().sorted(Map.Entry.<String, String> comparingByValue().reversed())
        .forEachOrdered(e -> sortedMap.put(e.getKey(), e.getValue()));

    // print map
    sortedMap.forEach((k, v) -> Log.logInfo("(UTC{0}) {1}", v, k));

    Log.logInfo("\nTotal Zone IDs {0}", sortedMap.size());

  }

    private static Map<String, String> getAllZoneIds(List<String> zoneList) {

        Map<String, String> result = new HashMap<>();

        LocalDateTime dt = LocalDateTime.now();

        for (String zoneId : zoneList) {

            ZoneId zone = ZoneId.of(zoneId);
            ZonedDateTime zdt = dt.atZone(zone);
            ZoneOffset zos = zdt.getOffset();

            //replace Z to +00:00
            String offset = zos.getId().replaceAll("Z", "+00:00");

            result.put(zone.toString(), offset);

        }

        return result;

    }

}
