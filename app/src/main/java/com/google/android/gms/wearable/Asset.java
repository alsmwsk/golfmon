package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

public class Asset
  implements SafeParcelable
{
  public static final Parcelable.Creator<Asset> CREATOR = new a();
  final int CK;
  private byte[] aeA;
  private String axa;
  public ParcelFileDescriptor axb;
  public Uri uri;
  
  Asset(int paramInt, byte[] paramArrayOfByte, String paramString, ParcelFileDescriptor paramParcelFileDescriptor, Uri paramUri)
  {
    this.CK = paramInt;
    this.aeA = paramArrayOfByte;
    this.axa = paramString;
    this.axb = paramParcelFileDescriptor;
    this.uri = paramUri;
  }
  
  public static Asset createFromBytes(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("Asset data cannot be null");
    }
    return new Asset(1, paramArrayOfByte, null, null, null);
  }
  
  public static Asset createFromFd(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    if (paramParcelFileDescriptor == null) {
      throw new IllegalArgumentException("Asset fd cannot be null");
    }
    return new Asset(1, null, null, paramParcelFileDescriptor, null);
  }
  
  public static Asset createFromRef(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Asset digest cannot be null");
    }
    return new Asset(1, null, paramString, null, null);
  }
  
  public static Asset createFromUri(Uri paramUri)
  {
    if (paramUri == null) {
      throw new IllegalArgumentException("Asset uri cannot be null");
    }
    return new Asset(1, null, null, null, paramUri);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    Asset localAsset;
    do
    {
      return true;
      if (!(paramObject instanceof Asset)) {
        return false;
      }
      localAsset = (Asset)paramObject;
    } while ((jv.equal(this.aeA, localAsset.aeA)) && (jv.equal(this.axa, localAsset.axa)) && (jv.equal(this.axb, localAsset.axb)) && (jv.equal(this.uri, localAsset.uri)));
    return false;
  }
  
  public byte[] getData()
  {
    return this.aeA;
  }
  
  public String getDigest()
  {
    return this.axa;
  }
  
  public ParcelFileDescriptor getFd()
  {
    return this.axb;
  }
  
  public Uri getUri()
  {
    return this.uri;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = this.aeA;
    arrayOfObject[1] = this.axa;
    arrayOfObject[2] = this.axb;
    arrayOfObject[3] = this.uri;
    return jv.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Asset[@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    if (this.axa == null) {
      localStringBuilder.append(", nodigest");
    }
    for (;;)
    {
      if (this.aeA != null)
      {
        localStringBuilder.append(", size=");
        localStringBuilder.append(this.aeA.length);
      }
      if (this.axb != null)
      {
        localStringBuilder.append(", fd=");
        localStringBuilder.append(this.axb);
      }
      if (this.uri != null)
      {
        localStringBuilder.append(", uri=");
        localStringBuilder.append(this.uri);
      }
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      localStringBuilder.append(", ");
      localStringBuilder.append(this.axa);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt | 0x1);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.Asset
 * JD-Core Version:    0.7.0.1
 */