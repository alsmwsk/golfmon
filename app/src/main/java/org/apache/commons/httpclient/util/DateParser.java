package org.apache.commons.httpclient.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;

public class DateParser
{
  private static final Collection DEFAULT_PATTERNS = Arrays.asList(new String[] { "EEE MMM d HH:mm:ss yyyy", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE, dd MMM yyyy HH:mm:ss zzz" });
  public static final String PATTERN_ASCTIME = "EEE MMM d HH:mm:ss yyyy";
  public static final String PATTERN_RFC1036 = "EEEE, dd-MMM-yy HH:mm:ss zzz";
  public static final String PATTERN_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";
  
  public static Date parseDate(String paramString)
    throws DateParseException
  {
    return parseDate(paramString, null);
  }
  
  public static Date parseDate(String paramString, Collection paramCollection)
    throws DateParseException
  {
    if (paramString == null) {
      throw new IllegalArgumentException("dateValue is null");
    }
    if (paramCollection == null) {
      paramCollection = DEFAULT_PATTERNS;
    }
    if ((paramString.length() > 1) && (paramString.startsWith("'")) && (paramString.endsWith("'"))) {
      paramString = paramString.substring(1, -1 + paramString.length());
    }
    SimpleDateFormat localSimpleDateFormat = null;
    Iterator localIterator = paramCollection.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        throw new DateParseException("Unable to parse the date " + paramString);
      }
      String str = (String)localIterator.next();
      if (localSimpleDateFormat == null)
      {
        localSimpleDateFormat = new SimpleDateFormat(str, Locale.US);
        localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
      }
      for (;;)
      {
        try
        {
          Date localDate = localSimpleDateFormat.parse(paramString);
          return localDate;
        }
        catch (ParseException localParseException) {}
        localSimpleDateFormat.applyPattern(str);
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.util.DateParser
 * JD-Core Version:    0.7.0.1
 */