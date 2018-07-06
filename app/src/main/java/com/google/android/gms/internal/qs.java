package com.google.android.gms.internal;

class qs
{
  private static final qt ayZ = new qt();
  private boolean aza = false;
  private int[] azb;
  private qt[] azc;
  private int mSize;
  
  public qs()
  {
    this(10);
  }
  
  public qs(int paramInt)
  {
    int i = idealIntArraySize(paramInt);
    this.azb = new int[i];
    this.azc = new qt[i];
    this.mSize = 0;
  }
  
  private boolean a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    for (int i = 0; i < paramInt; i++) {
      if (paramArrayOfInt1[i] != paramArrayOfInt2[i]) {
        return false;
      }
    }
    return true;
  }
  
  private boolean a(qt[] paramArrayOfqt1, qt[] paramArrayOfqt2, int paramInt)
  {
    for (int i = 0; i < paramInt; i++) {
      if (!paramArrayOfqt1[i].equals(paramArrayOfqt2[i])) {
        return false;
      }
    }
    return true;
  }
  
  private void gc()
  {
    int i = this.mSize;
    int[] arrayOfInt = this.azb;
    qt[] arrayOfqt = this.azc;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      qt localqt = arrayOfqt[j];
      if (localqt != ayZ)
      {
        if (j != k)
        {
          arrayOfInt[k] = arrayOfInt[j];
          arrayOfqt[k] = localqt;
          arrayOfqt[j] = null;
        }
        k++;
      }
      j++;
    }
    this.aza = false;
    this.mSize = k;
  }
  
  private int hj(int paramInt)
  {
    int i = 0;
    int j = -1 + this.mSize;
    while (i <= j)
    {
      int k = i + j >>> 1;
      int m = this.azb[k];
      if (m < paramInt) {
        i = k + 1;
      } else if (m > paramInt) {
        j = k - 1;
      } else {
        return k;
      }
    }
    return i ^ 0xFFFFFFFF;
  }
  
  private int idealByteArraySize(int paramInt)
  {
    for (int i = 4;; i++) {
      if (i < 32)
      {
        if (paramInt <= -12 + (1 << i)) {
          paramInt = -12 + (1 << i);
        }
      }
      else {
        return paramInt;
      }
    }
  }
  
  private int idealIntArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 4) / 4;
  }
  
  public void a(int paramInt, qt paramqt)
  {
    int i = hj(paramInt);
    if (i >= 0)
    {
      this.azc[i] = paramqt;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.mSize) && (this.azc[j] == ayZ))
    {
      this.azb[j] = paramInt;
      this.azc[j] = paramqt;
      return;
    }
    if ((this.aza) && (this.mSize >= this.azb.length))
    {
      gc();
      j = 0xFFFFFFFF ^ hj(paramInt);
    }
    if (this.mSize >= this.azb.length)
    {
      int k = idealIntArraySize(1 + this.mSize);
      int[] arrayOfInt = new int[k];
      qt[] arrayOfqt = new qt[k];
      System.arraycopy(this.azb, 0, arrayOfInt, 0, this.azb.length);
      System.arraycopy(this.azc, 0, arrayOfqt, 0, this.azc.length);
      this.azb = arrayOfInt;
      this.azc = arrayOfqt;
    }
    if (this.mSize - j != 0)
    {
      System.arraycopy(this.azb, j, this.azb, j + 1, this.mSize - j);
      System.arraycopy(this.azc, j, this.azc, j + 1, this.mSize - j);
    }
    this.azb[j] = paramInt;
    this.azc[j] = paramqt;
    this.mSize = (1 + this.mSize);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    qs localqs;
    do
    {
      return true;
      if (!(paramObject instanceof qs)) {
        return false;
      }
      localqs = (qs)paramObject;
      if (size() != localqs.size()) {
        return false;
      }
    } while ((a(this.azb, localqs.azb, this.mSize)) && (a(this.azc, localqs.azc, this.mSize)));
    return false;
  }
  
  public int hashCode()
  {
    if (this.aza) {
      gc();
    }
    int i = 17;
    for (int j = 0; j < this.mSize; j++) {
      i = 31 * (i * 31 + this.azb[j]) + this.azc[j].hashCode();
    }
    return i;
  }
  
  public qt hh(int paramInt)
  {
    int i = hj(paramInt);
    if ((i < 0) || (this.azc[i] == ayZ)) {
      return null;
    }
    return this.azc[i];
  }
  
  public qt hi(int paramInt)
  {
    if (this.aza) {
      gc();
    }
    return this.azc[paramInt];
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  public int size()
  {
    if (this.aza) {
      gc();
    }
    return this.mSize;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.qs
 * JD-Core Version:    0.7.0.1
 */