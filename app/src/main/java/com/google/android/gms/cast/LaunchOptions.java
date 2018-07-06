package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.in;
import com.google.android.gms.internal.jv;
import java.util.Locale;

public class LaunchOptions
  implements SafeParcelable
{
  public static final Parcelable.Creator<LaunchOptions> CREATOR = new c();
  private final int CK;
  private boolean FQ;
  private String FR;
  
  public LaunchOptions()
  {
    this(1, false, in.b(Locale.getDefault()));
  }
  
  LaunchOptions(int paramInt, boolean paramBoolean, String paramString)
  {
    this.CK = paramInt;
    this.FQ = paramBoolean;
    this.FR = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    LaunchOptions localLaunchOptions;
    do
    {
      return true;
      if (!(paramObject instanceof LaunchOptions)) {
        return false;
      }
      localLaunchOptions = (LaunchOptions)paramObject;
    } while ((this.FQ == localLaunchOptions.FQ) && (in.a(this.FR, localLaunchOptions.FR)));
    return false;
  }
  
  public String getLanguage()
  {
    return this.FR;
  }
  
  public boolean getRelaunchIfRunning()
  {
    return this.FQ;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Boolean.valueOf(this.FQ);
    arrayOfObject[1] = this.FR;
    return jv.hashCode(arrayOfObject);
  }
  
  public void setLanguage(String paramString)
  {
    this.FR = paramString;
  }
  
  public void setRelaunchIfRunning(boolean paramBoolean)
  {
    this.FQ = paramBoolean;
  }
  
  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Boolean.valueOf(this.FQ);
    arrayOfObject[1] = this.FR;
    return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s)", arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
  
  public static final class Builder
  {
    private LaunchOptions FS = new LaunchOptions();
    
    public LaunchOptions build()
    {
      return this.FS;
    }
    
    public Builder setLocale(Locale paramLocale)
    {
      this.FS.setLanguage(in.b(paramLocale));
      return this;
    }
    
    public Builder setRelaunchIfRunning(boolean paramBoolean)
    {
      this.FS.setRelaunchIfRunning(paramBoolean);
      return this;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.cast.LaunchOptions
 * JD-Core Version:    0.7.0.1
 */