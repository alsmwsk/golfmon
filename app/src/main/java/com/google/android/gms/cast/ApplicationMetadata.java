package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.in;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;
import java.util.List;

public final class ApplicationMetadata
  implements SafeParcelable
{
  public static final Parcelable.Creator<ApplicationMetadata> CREATOR = new a();
  private final int CK;
  String Fo;
  List<WebImage> Fp;
  List<String> Fq;
  String Fr;
  Uri Fs;
  String mName;
  
  private ApplicationMetadata()
  {
    this.CK = 1;
    this.Fp = new ArrayList();
    this.Fq = new ArrayList();
  }
  
  ApplicationMetadata(int paramInt, String paramString1, String paramString2, List<WebImage> paramList, List<String> paramList1, String paramString3, Uri paramUri)
  {
    this.CK = paramInt;
    this.Fo = paramString1;
    this.mName = paramString2;
    this.Fp = paramList;
    this.Fq = paramList1;
    this.Fr = paramString3;
    this.Fs = paramUri;
  }
  
  public boolean areNamespacesSupported(List<String> paramList)
  {
    return (this.Fq != null) && (this.Fq.containsAll(paramList));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    ApplicationMetadata localApplicationMetadata;
    do
    {
      return true;
      if (!(paramObject instanceof ApplicationMetadata)) {
        return false;
      }
      localApplicationMetadata = (ApplicationMetadata)paramObject;
    } while ((in.a(this.Fo, localApplicationMetadata.Fo)) && (in.a(this.Fp, localApplicationMetadata.Fp)) && (in.a(this.mName, localApplicationMetadata.mName)) && (in.a(this.Fq, localApplicationMetadata.Fq)) && (in.a(this.Fr, localApplicationMetadata.Fr)) && (in.a(this.Fs, localApplicationMetadata.Fs)));
    return false;
  }
  
  public Uri fP()
  {
    return this.Fs;
  }
  
  public String getApplicationId()
  {
    return this.Fo;
  }
  
  public List<WebImage> getImages()
  {
    return this.Fp;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getSenderAppIdentifier()
  {
    return this.Fr;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[7];
    arrayOfObject[0] = Integer.valueOf(this.CK);
    arrayOfObject[1] = this.Fo;
    arrayOfObject[2] = this.mName;
    arrayOfObject[3] = this.Fp;
    arrayOfObject[4] = this.Fq;
    arrayOfObject[5] = this.Fr;
    arrayOfObject[6] = this.Fs;
    return jv.hashCode(arrayOfObject);
  }
  
  public boolean isNamespaceSupported(String paramString)
  {
    return (this.Fq != null) && (this.Fq.contains(paramString));
  }
  
  public String toString()
  {
    return this.mName;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.cast.ApplicationMetadata
 * JD-Core Version:    0.7.0.1
 */