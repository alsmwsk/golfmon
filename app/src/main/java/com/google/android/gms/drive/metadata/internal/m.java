package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.UserMetadata;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class m
  extends j<UserMetadata>
{
  public m(String paramString, int paramInt)
  {
    super(paramString, bp(paramString), Collections.emptyList(), paramInt);
  }
  
  private String bo(String paramString)
  {
    return q(getName(), paramString);
  }
  
  private static Collection<String> bp(String paramString)
  {
    String[] arrayOfString = new String[5];
    arrayOfString[0] = q(paramString, "permissionId");
    arrayOfString[1] = q(paramString, "displayName");
    arrayOfString[2] = q(paramString, "picture");
    arrayOfString[3] = q(paramString, "isAuthenticatedUser");
    arrayOfString[4] = q(paramString, "emailAddress");
    return Arrays.asList(arrayOfString);
  }
  
  private static String q(String paramString1, String paramString2)
  {
    return paramString1 + "." + paramString2;
  }
  
  protected boolean b(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    return !paramDataHolder.h(bo("permissionId"), paramInt1, paramInt2);
  }
  
  protected UserMetadata j(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    String str1 = paramDataHolder.c(bo("permissionId"), paramInt1, paramInt2);
    if (str1 != null)
    {
      String str2 = paramDataHolder.c(bo("displayName"), paramInt1, paramInt2);
      String str3 = paramDataHolder.c(bo("picture"), paramInt1, paramInt2);
      Boolean localBoolean = Boolean.valueOf(paramDataHolder.d(bo("isAuthenticatedUser"), paramInt1, paramInt2));
      String str4 = paramDataHolder.c(bo("emailAddress"), paramInt1, paramInt2);
      return new UserMetadata(str1, str2, str3, localBoolean.booleanValue(), str4);
    }
    return null;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.metadata.internal.m
 * JD-Core Version:    0.7.0.1
 */