package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import com.google.android.gms.internal.jx;
import java.util.List;

public class e
  implements SafeParcelable
{
  public static final Parcelable.Creator<e> CREATOR = new f();
  private final int CK;
  private final DataSet UP;
  
  e(int paramInt, DataSet paramDataSet)
  {
    this.CK = paramInt;
    this.UP = paramDataSet;
  }
  
  private e(a parama)
  {
    this.CK = 1;
    this.UP = a.a(parama);
  }
  
  private boolean a(e parame)
  {
    return jv.equal(this.UP, parame.UP);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof e)) && (a((e)paramObject)));
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.UP;
    return jv.hashCode(arrayOfObject);
  }
  
  public DataSet jH()
  {
    return this.UP;
  }
  
  public String toString()
  {
    return jv.h(this).a("dataSet", this.UP).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    f.a(this, paramParcel, paramInt);
  }
  
  public static class a
  {
    private DataSet UP;
    
    public a b(DataSet paramDataSet)
    {
      this.UP = paramDataSet;
      return this;
    }
    
    public e jU()
    {
      boolean bool1 = true;
      boolean bool2;
      boolean bool3;
      if (this.UP != null)
      {
        bool2 = bool1;
        jx.a(bool2, "Must set the data set");
        if (this.UP.getDataPoints().isEmpty()) {
          break label74;
        }
        bool3 = bool1;
        label34:
        jx.a(bool3, "Cannot use an empty data set");
        if (this.UP.getDataSource().jx() == null) {
          break label79;
        }
      }
      for (;;)
      {
        jx.a(bool1, "Must set the app package name for the data source");
        return new e(this, null);
        bool2 = false;
        break;
        label74:
        bool3 = false;
        break label34;
        label79:
        bool1 = false;
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.request.e
 * JD-Core Version:    0.7.0.1
 */