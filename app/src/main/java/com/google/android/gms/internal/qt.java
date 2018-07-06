package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class qt
{
  private qr<?, ?> azd;
  private Object aze;
  private List<qy> azf = new ArrayList();
  
  private byte[] toByteArray()
    throws IOException
  {
    byte[] arrayOfByte = new byte[c()];
    a(qp.q(arrayOfByte));
    return arrayOfByte;
  }
  
  void a(qp paramqp)
    throws IOException
  {
    if (this.aze != null) {
      this.azd.a(this.aze, paramqp);
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.azf.iterator();
      while (localIterator.hasNext()) {
        ((qy)localIterator.next()).a(paramqp);
      }
    }
  }
  
  void a(qy paramqy)
  {
    this.azf.add(paramqy);
  }
  
  <T> T b(qr<?, T> paramqr)
  {
    if (this.aze != null)
    {
      if (this.azd != paramqr) {
        throw new IllegalStateException("Tried to getExtension with a differernt Extension.");
      }
    }
    else
    {
      this.azd = paramqr;
      this.aze = paramqr.m(this.azf);
      this.azf = null;
    }
    return this.aze;
  }
  
  int c()
  {
    int i;
    if (this.aze != null) {
      i = this.azd.B(this.aze);
    }
    for (;;)
    {
      return i;
      Iterator localIterator = this.azf.iterator();
      i = 0;
      while (localIterator.hasNext()) {
        i += ((qy)localIterator.next()).c();
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2;
    if (paramObject == this) {
      bool2 = true;
    }
    qt localqt;
    qr localqr1;
    qr localqr2;
    do
    {
      boolean bool1;
      do
      {
        return bool2;
        bool1 = paramObject instanceof qt;
        bool2 = false;
      } while (!bool1);
      localqt = (qt)paramObject;
      if ((this.aze == null) || (localqt.aze == null)) {
        break;
      }
      localqr1 = this.azd;
      localqr2 = localqt.azd;
      bool2 = false;
    } while (localqr1 != localqr2);
    if (!this.azd.ayX.isArray()) {
      return this.aze.equals(localqt.aze);
    }
    if ((this.aze instanceof byte[])) {
      return Arrays.equals((byte[])this.aze, (byte[])localqt.aze);
    }
    if ((this.aze instanceof int[])) {
      return Arrays.equals((int[])this.aze, (int[])localqt.aze);
    }
    if ((this.aze instanceof long[])) {
      return Arrays.equals((long[])this.aze, (long[])localqt.aze);
    }
    if ((this.aze instanceof float[])) {
      return Arrays.equals((float[])this.aze, (float[])localqt.aze);
    }
    if ((this.aze instanceof double[])) {
      return Arrays.equals((double[])this.aze, (double[])localqt.aze);
    }
    if ((this.aze instanceof boolean[])) {
      return Arrays.equals((boolean[])this.aze, (boolean[])localqt.aze);
    }
    return Arrays.deepEquals((Object[])this.aze, (Object[])localqt.aze);
    if ((this.azf != null) && (localqt.azf != null)) {
      return this.azf.equals(localqt.azf);
    }
    try
    {
      boolean bool3 = Arrays.equals(toByteArray(), localqt.toByteArray());
      return bool3;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException);
    }
  }
  
  public int hashCode()
  {
    try
    {
      int i = Arrays.hashCode(toByteArray());
      return i + 527;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.qt
 * JD-Core Version:    0.7.0.1
 */