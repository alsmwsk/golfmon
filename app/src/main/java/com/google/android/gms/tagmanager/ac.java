package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class ac
  extends aj
{
  private static final String ID = a.aa.toString();
  private static final String arp = b.bw.toString();
  private static final String arq = b.dH.toString();
  private static final String arr = b.de.toString();
  private static final String ars = b.dP.toString();
  
  public ac()
  {
    super(str, arrayOfString);
  }
  
  public d.a B(Map<String, d.a> paramMap)
  {
    d.a locala1 = (d.a)paramMap.get(arp);
    if ((locala1 == null) || (locala1 == di.rb())) {
      return di.rb();
    }
    String str1 = di.j(locala1);
    d.a locala2 = (d.a)paramMap.get(arr);
    String str2;
    d.a locala3;
    String str3;
    if (locala2 == null)
    {
      str2 = "text";
      locala3 = (d.a)paramMap.get(ars);
      if (locala3 != null) {
        break label165;
      }
      str3 = "base16";
      label79:
      d.a locala4 = (d.a)paramMap.get(arq);
      if ((locala4 == null) || (!di.n(locala4).booleanValue())) {
        break label355;
      }
    }
    label165:
    label328:
    label355:
    for (int i = 3;; i = 2)
    {
      for (;;)
      {
        byte[] arrayOfByte1;
        String str4;
        try
        {
          if ("text".equals(str2))
          {
            byte[] arrayOfByte2 = str1.getBytes();
            arrayOfByte1 = arrayOfByte2;
            if (!"base16".equals(str3)) {
              break label281;
            }
            str4 = j.d(arrayOfByte1);
            return di.u(str4);
            str2 = di.j(locala2);
            break;
            str3 = di.j(locala3);
            break label79;
          }
          if ("base16".equals(str2))
          {
            arrayOfByte1 = j.co(str1);
            continue;
          }
          if ("base64".equals(str2))
          {
            arrayOfByte1 = Base64.decode(str1, i);
            continue;
          }
          if ("base64url".equals(str2))
          {
            arrayOfByte1 = Base64.decode(str1, i | 0x8);
            continue;
          }
          bh.T("Encode: unknown input format: " + str2);
          d.a locala5 = di.rb();
          return locala5;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          bh.T("Encode: invalid input:");
          return di.rb();
        }
        if ("base64".equals(str3))
        {
          str4 = Base64.encodeToString(arrayOfByte1, i);
        }
        else
        {
          if (!"base64url".equals(str3)) {
            break label328;
          }
          str4 = Base64.encodeToString(arrayOfByte1, i | 0x8);
        }
      }
      bh.T("Encode: unknown output format: " + str3);
      return di.rb();
    }
  }
  
  public boolean pe()
  {
    return true;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.ac
 * JD-Core Version:    0.7.0.1
 */