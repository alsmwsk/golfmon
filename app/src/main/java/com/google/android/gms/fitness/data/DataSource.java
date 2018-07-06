package com.google.android.gms.fitness.data;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.mg;

public class DataSource
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataSource> CREATOR = new g();
  public static final String EXTRA_DATA_SOURCE = "vnd.google.fitness.data_source";
  public static final int TYPE_DERIVED = 1;
  public static final int TYPE_RAW;
  private final int CK;
  private final int Gt;
  private final DataType TM;
  private final Device Ul;
  private final a Um;
  private final String Un;
  private final boolean Uo;
  private final String Up;
  private final String mName;
  
  DataSource(int paramInt1, DataType paramDataType, String paramString1, int paramInt2, Device paramDevice, a parama, String paramString2, boolean paramBoolean)
  {
    this.CK = paramInt1;
    this.TM = paramDataType;
    this.Gt = paramInt2;
    this.mName = paramString1;
    this.Ul = paramDevice;
    this.Um = parama;
    this.Un = paramString2;
    this.Uo = paramBoolean;
    this.Up = jy();
  }
  
  private DataSource(Builder paramBuilder)
  {
    this.CK = 3;
    this.TM = Builder.a(paramBuilder);
    this.Gt = Builder.b(paramBuilder);
    this.mName = Builder.c(paramBuilder);
    this.Ul = Builder.d(paramBuilder);
    this.Um = Builder.e(paramBuilder);
    this.Un = Builder.f(paramBuilder);
    this.Uo = Builder.g(paramBuilder);
    this.Up = jy();
  }
  
  private boolean a(DataSource paramDataSource)
  {
    return this.Up.equals(paramDataSource.Up);
  }
  
  public static DataSource extract(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    return (DataSource)c.a(paramIntent, "vnd.google.fitness.data_source", CREATOR);
  }
  
  private String getTypeString()
  {
    switch (this.Gt)
    {
    default: 
      throw new IllegalArgumentException("invalid type value");
    case 0: 
      return "raw";
    }
    return "derived";
  }
  
  private String jy()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getTypeString());
    localStringBuilder.append(":").append(this.TM.getName());
    if (this.Um != null) {
      localStringBuilder.append(":").append(this.Um.getPackageName());
    }
    if (this.Ul != null) {
      localStringBuilder.append(":").append(this.Ul.getStreamIdentifier());
    }
    if (this.Un != null) {
      localStringBuilder.append(":").append(this.Un);
    }
    return localStringBuilder.toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof DataSource)) && (a((DataSource)paramObject)));
  }
  
  public String getAppPackageName()
  {
    if (this.Um == null) {
      return null;
    }
    return this.Um.getPackageName();
  }
  
  public DataType getDataType()
  {
    return this.TM;
  }
  
  public Device getDevice()
  {
    return this.Ul;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getStreamIdentifier()
  {
    return this.Up;
  }
  
  public String getStreamName()
  {
    return this.Un;
  }
  
  public int getType()
  {
    return this.Gt;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    return this.Up.hashCode();
  }
  
  public DataSource jA()
  {
    Device localDevice;
    if (this.Ul == null)
    {
      localDevice = null;
      if (this.Um != null) {
        break label63;
      }
    }
    label63:
    for (a locala = null;; locala = this.Um.jl())
    {
      return new DataSource(3, this.TM, this.mName, this.Gt, localDevice, locala, mg.bw(this.Un), this.Uo);
      localDevice = this.Ul.jE();
      break;
    }
  }
  
  public a jx()
  {
    return this.Um;
  }
  
  public boolean jz()
  {
    return this.Uo;
  }
  
  public String toDebugString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1;
    String str2;
    label50:
    String str3;
    label107:
    StringBuilder localStringBuilder4;
    if (this.Gt == 0)
    {
      str1 = "r";
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(":").append(this.TM.jB());
      if (this.Um != null) {
        break label164;
      }
      str2 = "";
      StringBuilder localStringBuilder3 = localStringBuilder2.append(str2);
      if (this.Ul == null) {
        break label214;
      }
      str3 = ":" + this.Ul.getModel() + ":" + this.Ul.getUid();
      localStringBuilder4 = localStringBuilder3.append(str3);
      if (this.Un == null) {
        break label221;
      }
    }
    label164:
    label214:
    label221:
    for (String str4 = ":" + this.Un;; str4 = "")
    {
      return str4;
      str1 = "d";
      break;
      if (this.Um.equals(a.TT))
      {
        str2 = ":gms";
        break label50;
      }
      str2 = ":" + this.Um.getPackageName();
      break label50;
      str3 = "";
      break label107;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("DataSource{");
    localStringBuilder.append(getTypeString());
    if (this.mName != null) {
      localStringBuilder.append(":").append(this.mName);
    }
    if (this.Um != null) {
      localStringBuilder.append(":").append(this.Um);
    }
    if (this.Ul != null) {
      localStringBuilder.append(":").append(this.Ul);
    }
    if (this.Un != null) {
      localStringBuilder.append(":").append(this.Un);
    }
    localStringBuilder.append(":").append(this.TM);
    return "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    g.a(mg.c(this), paramParcel, paramInt);
  }
  
  public static final class Builder
  {
    private int Gt = -1;
    private DataType TM;
    private Device Ul;
    private a Um;
    private String Un = "";
    private boolean Uo = false;
    private String mName;
    
    public DataSource build()
    {
      boolean bool1 = true;
      boolean bool2;
      if (this.TM != null)
      {
        bool2 = bool1;
        jx.a(bool2, "Must set data type");
        if (this.Gt < 0) {
          break label45;
        }
      }
      for (;;)
      {
        jx.a(bool1, "Must set data source type");
        return new DataSource(this, null);
        bool2 = false;
        break;
        label45:
        bool1 = false;
      }
    }
    
    public Builder setAppPackageName(Context paramContext)
    {
      return setAppPackageName(paramContext.getPackageName());
    }
    
    public Builder setAppPackageName(String paramString)
    {
      this.Um = new a(paramString, null, null);
      return this;
    }
    
    public Builder setDataType(DataType paramDataType)
    {
      this.TM = paramDataType;
      return this;
    }
    
    public Builder setDevice(Device paramDevice)
    {
      this.Ul = paramDevice;
      return this;
    }
    
    public Builder setName(String paramString)
    {
      this.mName = paramString;
      return this;
    }
    
    public Builder setObfuscated(boolean paramBoolean)
    {
      this.Uo = paramBoolean;
      return this;
    }
    
    public Builder setStreamName(String paramString)
    {
      if (paramString != null) {}
      for (boolean bool = true;; bool = false)
      {
        jx.b(bool, "Must specify a valid stream name");
        this.Un = paramString;
        return this;
      }
    }
    
    public Builder setType(int paramInt)
    {
      this.Gt = paramInt;
      return this;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.data.DataSource
 * JD-Core Version:    0.7.0.1
 */