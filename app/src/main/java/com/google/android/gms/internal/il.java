package com.google.android.gms.internal;

import android.text.TextUtils;
import java.io.IOException;

public abstract class il
{
  protected final is He;
  private final String Hf;
  private iu Hg;
  
  protected il(String paramString1, String paramString2, String paramString3)
  {
    in.aF(paramString1);
    this.Hf = paramString1;
    this.He = new is(paramString2);
    if (!TextUtils.isEmpty(paramString3)) {
      this.He.aK(paramString3);
    }
  }
  
  public final void a(iu paramiu)
  {
    this.Hg = paramiu;
    if (this.Hg == null) {
      fV();
    }
  }
  
  protected final void a(String paramString1, long paramLong, String paramString2)
    throws IOException
  {
    this.He.a("Sending text message: %s to: %s", new Object[] { paramString1, paramString2 });
    this.Hg.a(this.Hf, paramString1, paramLong, paramString2);
  }
  
  public void aD(String paramString) {}
  
  public void b(long paramLong, int paramInt) {}
  
  protected final long fU()
  {
    return this.Hg.fS();
  }
  
  public void fV() {}
  
  public final String getNamespace()
  {
    return this.Hf;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.il
 * JD-Core Version:    0.7.0.1
 */