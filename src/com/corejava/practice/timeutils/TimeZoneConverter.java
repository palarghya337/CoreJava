package com.corejava.practice.timeutils;

import java.text.ParseException;
import java.time.ZoneId;
import java.util.Calendar;

import com.corejava.practice.utils.Log;

public class TimeZoneConverter {

  public static void main(String... args) throws ParseException {
    
    String pattern = "yyyyMMdd-HH:mm:ss";
    String inputTime = "20190523-01:10:09";
    String inputTimeZoneID = "GMT";
    String outputTimeZoneID = "Hongkong";
    String estTimeZoneID = "US/Eastern";
    String gmtTimeZoneID = "GMT";
    String gmtTime = DateUtils.getTimeBasedOnTimeZone(inputTime, inputTimeZoneID, gmtTimeZoneID, pattern);
    String estTime = DateUtils.getTimeBasedOnTimeZone(inputTime, inputTimeZoneID, estTimeZoneID, pattern);
    String outPutTime = DateUtils.getTimeBasedOnTimeZone(inputTime, inputTimeZoneID, outputTimeZoneID, pattern);
    
    Log.logInfo("Input Time  [{0}]: {1}", inputTimeZoneID, inputTime);
    Log.logInfo("Output Time [{0}]: {1}", outputTimeZoneID, outPutTime);
    Log.logInfo("{0}: {1}", gmtTimeZoneID, gmtTime);
    Log.logInfo("{0}: {1}", estTimeZoneID, estTime);
    
    for (String zoneID : ZoneId.getAvailableZoneIds()) {
      if (zoneID.contains("Chicago")) {
        Log.logInfo(zoneID);
      }
    }
    Calendar cal = Calendar.getInstance();
    cal.setTime(DateUtils.convertStringToDate(outPutTime, outputTimeZoneID, pattern));
    Log.logInfo(cal.get(7));

  }
}
