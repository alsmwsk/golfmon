package com.google.android.gms.internal;

import android.os.Parcel;
import android.view.View;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class jg
{
  private final View JJ;
  private final a Mw;
  
  public jg(String paramString1, Collection<String> paramCollection, int paramInt, View paramView, String paramString2)
  {
    this.Mw = new a(paramString1, paramCollection, paramInt, paramString2);
    this.JJ = paramView;
  }
  
  public String getAccountName()
  {
    return this.Mw.getAccountName();
  }
  
  public String hm()
  {
    return this.Mw.hm();
  }
  
  public int hn()
  {
    return this.Mw.hn();
  }
  
  public List<String> ho()
  {
    return this.Mw.ho();
  }
  
  public String[] hp()
  {
    return (String[])this.Mw.ho().toArray(new String[0]);
  }
  
  public String hq()
  {
    return this.Mw.hq();
  }
  
  public View hr()
  {
    return this.JJ;
  }
  
  public static final class a
    implements SafeParcelable
  {
    public static final jw CREATOR = new jw();
    private final int CK;
    private final String DZ;
    private final int JI;
    private final String JK;
    private final List<String> Kh = new ArrayList();
    
    a(int paramInt1, String paramString1, List<String> paramList, int paramInt2, String paramString2)
    {
      this.CK = paramInt1;
      this.DZ = paramString1;
      this.Kh.addAll(paramList);
      this.JI = paramInt2;
      this.JK = paramString2;
    }
    
    public a(String paramString1, Collection<String> paramCollection, int paramInt, String paramString2)
    {
      this(3, paramString1, new ArrayList(paramCollection), paramInt, paramString2);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String getAccountName()
    {
      return this.DZ;
    }
    
    public int getVersionCode()
    {
      return this.CK;
    }
    
    public String hm()
    {
      if (this.DZ != null) {
        return this.DZ;
      }
      return "<<default account>>";
    }
    
    public int hn()
    {
      return this.JI;
    }
    
    public List<String> ho()
    {
      return new ArrayList(this.Kh);
    }
    
    public String hq()
    {
      return this.JK;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      jw.a(this, paramParcel, paramInt);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jg
 * JD-Core Version:    0.7.0.1
 */