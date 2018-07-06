package com.google.android.gms.internal;

import android.content.Intent;

@ey
public class ek
{
  private final String oK;
  
  public ek(String paramString)
  {
    this.oK = paramString;
  }
  
  public boolean a(String paramString, int paramInt, Intent paramIntent)
  {
    if ((paramString == null) || (paramIntent == null)) {}
    String str1;
    String str2;
    do
    {
      return false;
      str1 = ei.e(paramIntent);
      str2 = ei.f(paramIntent);
    } while ((str1 == null) || (str2 == null));
    if (!paramString.equals(ei.D(str1)))
    {
      gr.W("Developer payload not match.");
      return false;
    }
    if ((this.oK != null) && (!el.b(this.oK, str1, str2)))
    {
      gr.W("Fail to verify signature.");
      return false;
    }
    return true;
  }
  
  public String cC()
  {
    return gi.dx();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ek
 * JD-Core Version:    0.7.0.1
 */