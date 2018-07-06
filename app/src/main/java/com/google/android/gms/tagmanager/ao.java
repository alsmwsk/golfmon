package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

class ao
  extends aj
{
  private static final String ID = a.ac.toString();
  private static final String arp = b.bw.toString();
  private static final String arr = b.de.toString();
  private static final String arv = b.bn.toString();
  
  public ao()
  {
    super(str, arrayOfString);
  }
  
  private byte[] d(String paramString, byte[] paramArrayOfByte)
    throws NoSuchAlgorithmException
  {
    MessageDigest localMessageDigest = MessageDigest.getInstance(paramString);
    localMessageDigest.update(paramArrayOfByte);
    return localMessageDigest.digest();
  }
  
  public d.a B(Map<String, d.a> paramMap)
  {
    d.a locala1 = (d.a)paramMap.get(arp);
    if ((locala1 == null) || (locala1 == di.rb())) {
      return di.rb();
    }
    String str1 = di.j(locala1);
    d.a locala2 = (d.a)paramMap.get(arv);
    String str2;
    d.a locala3;
    String str3;
    label79:
    byte[] arrayOfByte;
    if (locala2 == null)
    {
      str2 = "MD5";
      locala3 = (d.a)paramMap.get(arr);
      if (locala3 != null) {
        break label124;
      }
      str3 = "text";
      if (!"text".equals(str3)) {
        break label134;
      }
      arrayOfByte = str1.getBytes();
    }
    for (;;)
    {
      label134:
      try
      {
        d.a locala4 = di.u(j.d(d(str2, arrayOfByte)));
        return locala4;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        label124:
        bh.T("Hash: unknown algorithm: " + str2);
      }
      str2 = di.j(locala2);
      break;
      str3 = di.j(locala3);
      break label79;
      if ("base16".equals(str3))
      {
        arrayOfByte = j.co(str1);
      }
      else
      {
        bh.T("Hash: unknown input format: " + str3);
        return di.rb();
      }
    }
    return di.rb();
  }
  
  public boolean pe()
  {
    return true;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.ao
 * JD-Core Version:    0.7.0.1
 */