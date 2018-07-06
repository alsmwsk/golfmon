package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.in;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CastDevice
  implements SafeParcelable
{
  public static final Parcelable.Creator<CastDevice> CREATOR = new b();
  private final int CK;
  private String FG;
  String FH;
  private Inet4Address FI;
  private String FJ;
  private String FK;
  private String FL;
  private int FM;
  private List<WebImage> FN;
  private int FO;
  private int FP;
  
  private CastDevice()
  {
    this(3, null, null, null, null, null, -1, new ArrayList(), 0, -1);
  }
  
  CastDevice(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, List<WebImage> paramList, int paramInt3, int paramInt4)
  {
    this.CK = paramInt1;
    this.FG = paramString1;
    this.FH = paramString2;
    if (this.FH != null) {}
    try
    {
      InetAddress localInetAddress = InetAddress.getByName(this.FH);
      if ((localInetAddress instanceof Inet4Address)) {
        this.FI = ((Inet4Address)localInetAddress);
      }
      this.FJ = paramString3;
      this.FK = paramString4;
      this.FL = paramString5;
      this.FM = paramInt2;
      this.FN = paramList;
      this.FO = paramInt3;
      this.FP = paramInt4;
      return;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      for (;;)
      {
        this.FI = null;
      }
    }
  }
  
  public static CastDevice getFromBundle(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    paramBundle.setClassLoader(CastDevice.class.getClassLoader());
    return (CastDevice)paramBundle.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    CastDevice localCastDevice;
    do
    {
      do
      {
        return true;
        if (!(paramObject instanceof CastDevice)) {
          return false;
        }
        localCastDevice = (CastDevice)paramObject;
        if (getDeviceId() != null) {
          break;
        }
      } while (localCastDevice.getDeviceId() == null);
      return false;
    } while ((in.a(this.FG, localCastDevice.FG)) && (in.a(this.FI, localCastDevice.FI)) && (in.a(this.FK, localCastDevice.FK)) && (in.a(this.FJ, localCastDevice.FJ)) && (in.a(this.FL, localCastDevice.FL)) && (this.FM == localCastDevice.FM) && (in.a(this.FN, localCastDevice.FN)) && (this.FO == localCastDevice.FO) && (this.FP == localCastDevice.FP));
    return false;
  }
  
  public int getCapabilities()
  {
    return this.FO;
  }
  
  public String getDeviceId()
  {
    return this.FG;
  }
  
  public String getDeviceVersion()
  {
    return this.FL;
  }
  
  public String getFriendlyName()
  {
    return this.FJ;
  }
  
  public WebImage getIcon(int paramInt1, int paramInt2)
  {
    Object localObject1 = null;
    if (this.FN.isEmpty()) {
      return null;
    }
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      return (WebImage)this.FN.get(0);
    }
    Iterator localIterator = this.FN.iterator();
    Object localObject2 = null;
    Object localObject3;
    int i;
    int j;
    Object localObject4;
    if (localIterator.hasNext())
    {
      localObject3 = (WebImage)localIterator.next();
      i = ((WebImage)localObject3).getWidth();
      j = ((WebImage)localObject3).getHeight();
      if ((i >= paramInt1) && (j >= paramInt2))
      {
        if ((localObject2 != null) && ((((WebImage)localObject2).getWidth() <= i) || (((WebImage)localObject2).getHeight() <= j))) {
          break label223;
        }
        Object localObject5 = localObject1;
        localObject4 = localObject3;
        localObject3 = localObject5;
      }
    }
    for (;;)
    {
      localObject2 = localObject4;
      localObject1 = localObject3;
      break;
      if ((i < paramInt1) && (j < paramInt2) && ((localObject1 == null) || ((localObject1.getWidth() < i) && (localObject1.getHeight() < j))))
      {
        localObject4 = localObject2;
        continue;
        if (localObject2 != null) {}
        for (;;)
        {
          return localObject2;
          if (localObject1 != null) {
            localObject2 = localObject1;
          } else {
            localObject2 = (WebImage)this.FN.get(0);
          }
        }
      }
      else
      {
        label223:
        localObject3 = localObject1;
        localObject4 = localObject2;
      }
    }
  }
  
  public List<WebImage> getIcons()
  {
    return Collections.unmodifiableList(this.FN);
  }
  
  public Inet4Address getIpAddress()
  {
    return this.FI;
  }
  
  public String getModelName()
  {
    return this.FK;
  }
  
  public int getServicePort()
  {
    return this.FM;
  }
  
  public int getStatus()
  {
    return this.FP;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public boolean hasIcons()
  {
    return !this.FN.isEmpty();
  }
  
  public int hashCode()
  {
    if (this.FG == null) {
      return 0;
    }
    return this.FG.hashCode();
  }
  
  public boolean isOnLocalNetwork()
  {
    return !this.FG.startsWith("__cast_nearby__");
  }
  
  public boolean isSameDevice(CastDevice paramCastDevice)
  {
    if (paramCastDevice == null) {}
    do
    {
      return false;
      if (getDeviceId() != null) {
        break;
      }
    } while (paramCastDevice.getDeviceId() != null);
    return true;
    return in.a(getDeviceId(), paramCastDevice.getDeviceId());
  }
  
  public void putInBundle(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    paramBundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", this);
  }
  
  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.FJ;
    arrayOfObject[1] = this.FG;
    return String.format("\"%s\" (%s)", arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.cast.CastDevice
 * JD-Core Version:    0.7.0.1
 */