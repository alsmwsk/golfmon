package com.google.android.gms.internal;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class aq
{
  private static boolean a(Character.UnicodeBlock paramUnicodeBlock)
  {
    return (paramUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) || (paramUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) || (paramUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B) || (paramUnicodeBlock == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) || (paramUnicodeBlock == Character.UnicodeBlock.CJK_RADICALS_SUPPLEMENT) || (paramUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY) || (paramUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS) || (paramUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) || (paramUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT) || (paramUnicodeBlock == Character.UnicodeBlock.BOPOMOFO) || (paramUnicodeBlock == Character.UnicodeBlock.HIRAGANA) || (paramUnicodeBlock == Character.UnicodeBlock.KATAKANA) || (paramUnicodeBlock == Character.UnicodeBlock.HANGUL_SYLLABLES) || (paramUnicodeBlock == Character.UnicodeBlock.HANGUL_JAMO);
  }
  
  static boolean d(int paramInt)
  {
    return (Character.isLetter(paramInt)) && (a(Character.UnicodeBlock.of(paramInt)));
  }
  
  public static int o(String paramString)
  {
    try
    {
      byte[] arrayOfByte2 = paramString.getBytes("UTF-8");
      arrayOfByte1 = arrayOfByte2;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        byte[] arrayOfByte1 = paramString.getBytes();
      }
    }
    return lk.a(arrayOfByte1, 0, arrayOfByte1.length, 0);
  }
  
  public static String[] p(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    char[] arrayOfChar = paramString.toCharArray();
    int i = paramString.length();
    int j = 0;
    int k = 0;
    int m = 0;
    int n;
    int i1;
    int i3;
    int i4;
    if (m < i)
    {
      n = Character.codePointAt(arrayOfChar, m);
      i1 = Character.charCount(n);
      if (d(n))
      {
        if (j != 0) {
          localArrayList.add(new String(arrayOfChar, k, m - k));
        }
        localArrayList.add(new String(arrayOfChar, m, i1));
        i3 = k;
        i4 = 0;
      }
    }
    for (;;)
    {
      m += i1;
      int i5 = i4;
      k = i3;
      j = i5;
      break;
      if (Character.isLetterOrDigit(n))
      {
        if (j == 0) {
          k = m;
        }
        i3 = k;
        i4 = 1;
      }
      else if (j != 0)
      {
        localArrayList.add(new String(arrayOfChar, k, m - k));
        i3 = k;
        i4 = 0;
        continue;
        if (j != 0) {
          localArrayList.add(new String(arrayOfChar, k, m - k));
        }
        return (String[])localArrayList.toArray(new String[localArrayList.size()]);
      }
      else
      {
        int i2 = j;
        i3 = k;
        i4 = i2;
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.aq
 * JD-Core Version:    0.7.0.1
 */