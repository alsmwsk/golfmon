package com.appg.golfmon.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class FormatUtil
{
  private static final String PATTERN_Email = "\\w+[@]\\w+\\.\\w+";
  private static final String PATTERN_Passwrod = "^(?=.*[a-zA-Z]+)(?=.*[!@#$%^*+=-]|.*[0-9]+).{5,32}$";
  private static final String PATTERN_Phone = "01[016789][1-9]{1}[0-9]{2,3}[0-9]{4}$";
  private static final String[] dayOfWeek = { "일", "월", "화", "수", "목", "금", "토" };
  private static final String[] dayOfWeek_full = { "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일" };
  private static final double distance = 1000.0D;
  
  public static String convertMD5(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest2 = MessageDigest.getInstance("MD5");
      localMessageDigest1 = localMessageDigest2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        byte[] arrayOfByte;
        int i;
        LogUtil.w(localException);
        MessageDigest localMessageDigest1 = null;
        continue;
        String str2 = Integer.toHexString(0xFF & arrayOfByte[i]);
        if (str2.length() < 2) {
          str2 = "0" + str2;
        }
        String str1 = str1 + str2;
        i++;
      }
    }
    str1 = "";
    arrayOfByte = localMessageDigest1.digest(paramString.getBytes());
    i = 0;
    if (i >= arrayOfByte.length) {
      return str1;
    }
  }
  
  public static long diffOfDate(String paramString)
  {
    String str = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(new Date());
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    try
    {
      Date localDate1 = localSimpleDateFormat.parse(str);
      Date localDate2 = localSimpleDateFormat.parse(paramString);
      long l = (localDate1.getTime() - localDate2.getTime()) / 86400000L;
      return l;
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
    }
    return 0L;
  }
  
  public static long diffOfDate(String paramString1, String paramString2)
    throws Exception
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date localDate = localSimpleDateFormat.parse(paramString1);
    return (localSimpleDateFormat.parse(paramString2).getTime() - localDate.getTime()) / 86400000L;
  }
  
  public static int getByteLength(String paramString1, String paramString2)
  {
    try
    {
      int i = paramString1.getBytes(paramString2).length;
      return i;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return -1;
  }
  
  public static String getDateAmPm(Calendar paramCalendar)
  {
    if (paramCalendar.get(11) >= 12) {
      return "PM";
    }
    return "AM";
  }
  
  public static String getDateCalendarToString(Calendar paramCalendar, String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(paramString);
    try
    {
      String str = localSimpleDateFormat.format(paramCalendar.getTime());
      return str;
    }
    catch (Exception localException) {}
    return "";
  }
  
  public static int getDateColor(Calendar paramCalendar)
  {
    if (paramCalendar == null) {
      return -13421773;
    }
    switch (paramCalendar.get(7))
    {
    default: 
      return -13421773;
    case 1: 
      return -2023132;
    }
    return -12683546;
  }
  
  public static String getDateConvert(String paramString1, String paramString2, String paramString3)
  {
    String str = getDateCalendarToString(getDateStringToCalendar(paramString1, paramString2), paramString3);
    if (isNullorEmpty(paramString1)) {
      str = paramString1;
    }
    return str;
  }
  
  public static String getDateDayOfWeek(Calendar paramCalendar, boolean paramBoolean)
  {
    if (paramCalendar != null)
    {
      if (paramBoolean) {
        return dayOfWeek_full[(-1 + paramCalendar.get(7))];
      }
      return dayOfWeek[(-1 + paramCalendar.get(7))];
    }
    return "";
  }
  
  public static String getDateMonth(Calendar paramCalendar, boolean paramBoolean)
  {
    switch (paramCalendar.get(2))
    {
    default: 
      return "";
    case 0: 
      if (paramBoolean) {
        return "Jan";
      }
      return "January";
    case 1: 
      if (paramBoolean) {
        return "Feb";
      }
      return "February";
    case 2: 
      if (paramBoolean) {
        return "Mar";
      }
      return "March";
    case 3: 
      if (paramBoolean) {
        return "Apr";
      }
      return "April";
    case 4: 
      if (paramBoolean) {
        return "May";
      }
      return "May";
    case 5: 
      if (paramBoolean) {
        return "Jun";
      }
      return "June";
    case 6: 
      if (paramBoolean) {
        return "Jul";
      }
      return "July";
    case 7: 
      if (paramBoolean) {
        return "Aug";
      }
      return "August";
    case 8: 
      if (paramBoolean) {
        return "Sep";
      }
      return "September";
    case 9: 
      if (paramBoolean) {
        return "Oct";
      }
      return "October";
    case 10: 
      if (paramBoolean) {
        return "Nov";
      }
      return "November";
    }
    if (paramBoolean) {
      return "Dec";
    }
    return "December";
  }
  
  public static Calendar getDateStringToCalendar(String paramString1, String paramString2)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(paramString2);
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    try
    {
      localGregorianCalendar.setTime(localSimpleDateFormat.parse(paramString1));
      return localGregorianCalendar;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public static String getRegistDT(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    if (paramCalendar1 == null) {
      return "";
    }
    return getDateCalendarToString(paramCalendar1, "MM/dd") + "(" + getDateDayOfWeek(paramCalendar1, false) + ") " + getDateCalendarToString(paramCalendar1, "HH:mm");
  }
  
  public static int getRegistDTColor(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    if (paramCalendar1 == null) {}
    while ((paramCalendar2.get(1) != paramCalendar1.get(1)) || (paramCalendar2.get(2) != paramCalendar1.get(2)) || (paramCalendar2.get(5) != paramCalendar1.get(5))) {
      return -13421773;
    }
    return -12683546;
  }
  
  public static boolean isEmailPattern(String paramString)
  {
    if (isNullorEmpty(paramString)) {
      return false;
    }
    return Pattern.compile("\\w+[@]\\w+\\.\\w+").matcher(paramString).find();
  }
  
  public static boolean isNullorEmpty(String paramString)
  {
    return (paramString == null) || (paramString.trim().length() == 0) || ("".equalsIgnoreCase(paramString.trim())) || ("null".equalsIgnoreCase(paramString.trim()));
  }
  
  public static boolean isNullorEmpty(JSONObject paramJSONObject)
  {
    return (paramJSONObject == null) || (paramJSONObject.length() == 0);
  }
  
  public static boolean isPasswrodPattern(String paramString)
  {
    return Pattern.compile("^(?=.*[a-zA-Z]+)(?=.*[!@#$%^*+=-]|.*[0-9]+).{5,32}$").matcher(paramString).matches();
  }
  
  public static boolean isPhoneNumber(String paramString)
  {
    if (isNullorEmpty(paramString)) {
      return false;
    }
    return Pattern.compile("01[016789][1-9]{1}[0-9]{2,3}[0-9]{4}$").matcher(paramString.replaceAll("\\D", "")).matches();
  }
  
  public static String toPhoneNumber(String paramString)
  {
    String str1;
    if (isNullorEmpty(paramString)) {
      str1 = "";
    }
    for (;;)
    {
      return str1;
      str1 = paramString.replaceAll("\\D", "");
      try
      {
        if (str1.startsWith("02"))
        {
          if (str1.length() == 9) {
            return str1.substring(0, 2) + "-" + str1.substring(2, 5) + "-" + str1.substring(5, 9);
          }
          if (str1.length() == 10) {
            return str1.substring(0, 2) + "-" + str1.substring(2, 6) + "-" + str1.substring(6, 10);
          }
        }
        else
        {
          if (str1.length() == 10) {
            return str1.substring(0, 3) + "-" + str1.substring(3, 6) + "-" + str1.substring(6, 10);
          }
          if (str1.length() == 11)
          {
            String str2 = str1.substring(0, 3) + "-" + str1.substring(3, 7) + "-" + str1.substring(7, 11);
            return str2;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return str1;
  }
  
  public static String toPriceFormat(double paramDouble)
  {
    return toPriceFormat(paramDouble, false);
  }
  
  public static String toPriceFormat(double paramDouble, boolean paramBoolean)
  {
    String str = new DecimalFormat("###,###,###,###,###,##0").format(paramDouble);
    if (paramBoolean) {
      return str + "원";
    }
    return str;
  }
  
  public static String toPriceFormat(String paramString)
  {
    return toPriceFormat(paramString, false);
  }
  
  public static String toPriceFormat(String paramString, boolean paramBoolean)
  {
    if (isNullorEmpty(paramString)) {
      return paramString;
    }
    try
    {
      String str = toPriceFormat(Double.valueOf(paramString).doubleValue(), paramBoolean);
      return str;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return paramString;
  }
  
  public static String trimLeft(String paramString)
  {
    if (isNullorEmpty(paramString)) {
      return "";
    }
    return paramString.replaceAll("^\\s+", "");
  }
  
  public static String trimRight(String paramString)
  {
    if (isNullorEmpty(paramString)) {
      return "";
    }
    return paramString.replaceAll("\\s+$", "");
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.util.FormatUtil
 * JD-Core Version:    0.7.0.1
 */