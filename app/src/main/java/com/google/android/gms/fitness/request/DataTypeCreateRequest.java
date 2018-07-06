package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataTypeCreateRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataTypeCreateRequest> CREATOR = new i();
  private final int CK;
  private final List<Field> Uv;
  private final String mName;
  
  DataTypeCreateRequest(int paramInt, String paramString, List<Field> paramList)
  {
    this.CK = paramInt;
    this.mName = paramString;
    this.Uv = Collections.unmodifiableList(paramList);
  }
  
  private DataTypeCreateRequest(Builder paramBuilder)
  {
    this.CK = 1;
    this.mName = Builder.a(paramBuilder);
    this.Uv = Collections.unmodifiableList(Builder.b(paramBuilder));
  }
  
  private boolean a(DataTypeCreateRequest paramDataTypeCreateRequest)
  {
    return (jv.equal(this.mName, paramDataTypeCreateRequest.mName)) && (jv.equal(this.Uv, paramDataTypeCreateRequest.Uv));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof DataTypeCreateRequest)) && (a((DataTypeCreateRequest)paramObject)));
  }
  
  public List<Field> getFields()
  {
    return this.Uv;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.mName;
    arrayOfObject[1] = this.Uv;
    return jv.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    return jv.h(this).a("name", this.mName).a("fields", this.Uv).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    i.a(this, paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private List<Field> Uv = new ArrayList();
    private String mName;
    
    public Builder addField(Field paramField)
    {
      if (!this.Uv.contains(paramField)) {
        this.Uv.add(paramField);
      }
      return this;
    }
    
    public Builder addField(String paramString, int paramInt)
    {
      if ((paramString != null) || (!paramString.isEmpty())) {}
      for (boolean bool = true;; bool = false)
      {
        jx.b(bool, "Invalid name specified");
        return addField(new Field(paramString, paramInt));
      }
    }
    
    public DataTypeCreateRequest build()
    {
      boolean bool1 = true;
      boolean bool2;
      if (this.mName != null)
      {
        bool2 = bool1;
        jx.a(bool2, "Must set the name");
        if (this.Uv.isEmpty()) {
          break label50;
        }
      }
      for (;;)
      {
        jx.a(bool1, "Must specify the data fields");
        return new DataTypeCreateRequest(this, null);
        bool2 = false;
        break;
        label50:
        bool1 = false;
      }
    }
    
    public Builder setName(String paramString)
    {
      this.mName = paramString;
      return this;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.request.DataTypeCreateRequest
 * JD-Core Version:    0.7.0.1
 */