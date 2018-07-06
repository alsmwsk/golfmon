package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

@ey
public class dk
{
  private final boolean rs;
  private final boolean rt;
  private final boolean ru;
  private final boolean rv;
  private final boolean rw;
  
  private dk(a parama)
  {
    this.rs = a.a(parama);
    this.rt = a.b(parama);
    this.ru = a.c(parama);
    this.rv = a.d(parama);
    this.rw = a.e(parama);
  }
  
  public JSONObject toJson()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("sms", this.rs).put("tel", this.rt).put("calendar", this.ru).put("storePicture", this.rv).put("inlineVideo", this.rw);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      gr.b("Error occured while obtaining the MRAID capabilities.", localJSONException);
    }
    return null;
  }
  
  public static final class a
  {
    private boolean rs;
    private boolean rt;
    private boolean ru;
    private boolean rv;
    private boolean rw;
    
    public dk bU()
    {
      return new dk(this, null);
    }
    
    public a k(boolean paramBoolean)
    {
      this.rs = paramBoolean;
      return this;
    }
    
    public a l(boolean paramBoolean)
    {
      this.rt = paramBoolean;
      return this;
    }
    
    public a m(boolean paramBoolean)
    {
      this.ru = paramBoolean;
      return this;
    }
    
    public a n(boolean paramBoolean)
    {
      this.rv = paramBoolean;
      return this;
    }
    
    public a o(boolean paramBoolean)
    {
      this.rw = paramBoolean;
      return this;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dk
 * JD-Core Version:    0.7.0.1
 */