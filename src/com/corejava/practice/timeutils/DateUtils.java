package com.corejava.practice.timeutils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {

  public static final String REGEX_HOUR = "(([01]?[0-9]{1})|(2[0-3]{1}))";
  public static final String REGEX_MINUTE = "([0-5]{1}[0-9]{1})";
  public static final String REGEX_SECOND = "([0-5]{1}[0-9]{1})";
  public static final String COLON = ":";
  public static final String OR = "|";
  public static final String OPENING_BRACKET = "(";
  public static final String CLOSING_BRACKET = ")";
  private static final String REGEX_HHMMSS = "(([01]?[0-9]{1})|(2[0-3]{1})):([0-5]{1}[0-9]{1}):([0-5]{1}[0-9]{1})";
  private static final String REGEX_HHMM = "(([01]?[0-9]{1})|(2[0-3]{1})):([0-5]{1}[0-9]{1})";

  private DateUtils() {}
  
  public static boolean isTimeOnly(String time) {
    return time != null && (time.matches(REGEX_HHMMSS) || time.matches(REGEX_HHMM));
  }
  public static boolean isTimeOnlyFormat(String time) {
    return time != null && (isTimeOnlyHHmm(time) || isTimeOnlyHHmmss(time));
  }

  public static boolean isTimeOnlyHHmmss(String time) {

    final StringBuilder timeOnlyRegex = new StringBuilder();
    timeOnlyRegex.append(REGEX_HOUR);
    timeOnlyRegex.append(COLON);
    timeOnlyRegex.append(REGEX_MINUTE);
    timeOnlyRegex.append(COLON);
    timeOnlyRegex.append(REGEX_SECOND);
    return time.matches(timeOnlyRegex.toString());
  }

  public static boolean isTimeOnlyHHmm(String time) {

    final StringBuilder timeOnlyRegex = new StringBuilder();
    timeOnlyRegex.append(REGEX_HOUR);
    timeOnlyRegex.append(COLON);
    timeOnlyRegex.append(REGEX_MINUTE);
    return time.matches(timeOnlyRegex.toString());
  }
  public static String getTimeBasedOnTimeZone(String inputTime, String inputTimeZoneID, String outputTimeZoneID, String pattern) throws ParseException {
    if (inputTime != null && !inputTime.isEmpty() ) {
      
      Date inputDate = convertStringToDate(inputTime, inputTimeZoneID, pattern);
      return convertDateToString(inputDate, pattern, outputTimeZoneID);
    }
    return null;
  }
  
  public static String convertDateToString(Date date, String pattern, String timeZoneID) {
    if (date != null) {
      SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
      dateFormat.setTimeZone(TimeZone.getTimeZone(timeZoneID));
      return dateFormat.format(date);
    }
    return null;
  }
  
  public static Date convertStringToDate(String dateAndTime, String zoneID, String pattern) throws ParseException {
    if (dateAndTime != null && !dateAndTime.isEmpty()) {
      SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
      dateFormat.setTimeZone(TimeZone.getTimeZone(zoneID));
      return dateFormat.parse(dateAndTime);
    }
    return null;
  }
  /**
   * Builds a display name for the time zone in the format -
   * TimeZone ID (Time zone display ID) (+/- UTC)
   * @param timeZone String value for the time zone
   * @param fmt Format for the date
   * @return Formatted time zone name
   */
  public static String getTimeZoneDisplayName(String timeZone, DateFormat fmt) {
    TimeZone tz = TimeZone.getTimeZone(timeZone);
    StringBuilder timeZoneStr = new StringBuilder();
    timeZoneStr.append(timeZone).append(" (")
    .append(tz.getDisplayName()).append(") ");
    timeZoneStr.append("(GMT");
    if (tz.getRawOffset() < 0) {
      timeZoneStr.append("-");
    } else {
      timeZoneStr.append("+");
    }
    timeZoneStr.append(fmt.format(new Date(Math.abs(tz.getRawOffset()))));
    timeZoneStr.append(")");
    return timeZoneStr.toString();
  }
}