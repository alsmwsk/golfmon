package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class hp
  implements SafeParcelable
{
  public static final hq CREATOR = new hq();
  final int CK;
  public final String Dh;
  public final boolean Di;
  public final boolean Dj;
  public final String Dk;
  public final hj[] Dl;
  final int[] Dm;
  public final String Dn;
  public final String name;
  public final int weight;
  
  hp(int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, String paramString3, hj[] paramArrayOfhj, int[] paramArrayOfInt, String paramString4)
  {
    this.CK = paramInt1;
    this.name = paramString1;
    this.Dh = paramString2;
    this.Di = paramBoolean1;
    this.weight = paramInt2;
    this.Dj = paramBoolean2;
    this.Dk = paramString3;
    this.Dl = paramArrayOfhj;
    this.Dm = paramArrayOfInt;
    this.Dn = paramString4;
  }
  
  hp(String paramString1, String paramString2, boolean paramBoolean1, int paramInt, boolean paramBoolean2, String paramString3, hj[] paramArrayOfhj, int[] paramArrayOfInt, String paramString4)
  {
    this(2, paramString1, paramString2, paramBoolean1, paramInt, paramBoolean2, paramString3, paramArrayOfhj, paramArrayOfInt, paramString4);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof hp;
    boolean bool2 = false;
    if (bool1)
    {
      hp localhp = (hp)paramObject;
      boolean bool3 = this.name.equals(localhp.name);
      bool2 = false;
      if (bool3)
      {
        boolean bool4 = this.Dh.equals(localhp.Dh);
        bool2 = false;
        if (bool4)
        {
          boolean bool5 = this.Di;
          boolean bool6 = localhp.Di;
          bool2 = false;
          if (bool5 == bool6) {
            bool2 = true;
          }
        }
      }
    }
    return bool2;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    hq.a(this, paramParcel, paramInt);
  }
  
  public static final class a
  {
    private String Do;
    private boolean Dp;
    private int Dq;
    private boolean Dr;
    private String Ds;
    private final List<hj> Dt;
    private BitSet Du;
    private String Dv;
    private final String mName;
    
    public a(String paramString)
    {
      this.mName = paramString;
      this.Dq = 1;
      this.Dt = new ArrayList();
    }
    
    public a G(boolean paramBoolean)
    {
      this.Dp = paramBoolean;
      return this;
    }
    
    public a H(boolean paramBoolean)
    {
      this.Dr = paramBoolean;
      return this;
    }
    
    public a Q(int paramInt)
    {
      if (this.Du == null) {
        this.Du = new BitSet();
      }
      this.Du.set(paramInt);
      return this;
    }
    
    public a at(String paramString)
    {
      this.Do = paramString;
      return this;
    }
    
    public a au(String paramString)
    {
      this.Dv = paramString;
      return this;
    }
    
    public hp fG()
    {
      int i = 0;
      BitSet localBitSet = this.Du;
      int[] arrayOfInt = null;
      if (localBitSet != null)
      {
        arrayOfInt = new int[this.Du.cardinality()];
        int j = this.Du.nextSetBit(0);
        while (j >= 0)
        {
          int k = i + 1;
          arrayOfInt[i] = j;
          j = this.Du.nextSetBit(j + 1);
          i = k;
        }
      }
      return new hp(this.mName, this.Do, this.Dp, this.Dq, this.Dr, this.Ds, (hj[])this.Dt.toArray(new hj[this.Dt.size()]), arrayOfInt, this.Dv);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hp
 * JD-Core Version:    0.7.0.1
 */