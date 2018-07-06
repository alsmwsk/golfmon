package com.google.android.gms.internal;

import java.io.IOException;

public abstract class qq<M extends qq<M>>
  extends qw
{
  protected qs ayW;
  
  public final <T> T a(qr<M, T> paramqr)
  {
    if (this.ayW == null) {}
    qt localqt;
    do
    {
      return null;
      localqt = this.ayW.hh(qz.hl(paramqr.tag));
    } while (localqt == null);
    return localqt.b(paramqr);
  }
  
  public void a(qp paramqp)
    throws IOException
  {
    if (this.ayW == null) {}
    for (;;)
    {
      return;
      for (int i = 0; i < this.ayW.size(); i++) {
        this.ayW.hi(i).a(paramqp);
      }
    }
  }
  
  protected final boolean a(qo paramqo, int paramInt)
    throws IOException
  {
    int i = paramqo.getPosition();
    if (!paramqo.gQ(paramInt)) {
      return false;
    }
    int j = qz.hl(paramInt);
    qy localqy = new qy(paramInt, paramqo.s(i, paramqo.getPosition() - i));
    qt localqt = null;
    if (this.ayW == null) {
      this.ayW = new qs();
    }
    for (;;)
    {
      if (localqt == null)
      {
        localqt = new qt();
        this.ayW.a(j, localqt);
      }
      localqt.a(localqy);
      return true;
      localqt = this.ayW.hh(j);
    }
  }
  
  protected final boolean a(M paramM)
  {
    if ((this.ayW == null) || (this.ayW.isEmpty())) {
      return (paramM.ayW == null) || (paramM.ayW.isEmpty());
    }
    return this.ayW.equals(paramM.ayW);
  }
  
  protected int c()
  {
    int i = 0;
    if (this.ayW != null)
    {
      j = 0;
      while (i < this.ayW.size())
      {
        j += this.ayW.hi(i).c();
        i++;
      }
    }
    int j = 0;
    return j;
  }
  
  protected final int rQ()
  {
    if ((this.ayW == null) || (this.ayW.isEmpty())) {
      return 0;
    }
    return this.ayW.hashCode();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.qq
 * JD-Core Version:    0.7.0.1
 */