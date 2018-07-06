package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.c.f;
import com.google.android.gms.internal.c.i;
import com.google.android.gms.internal.c.j;
import com.google.android.gms.internal.d.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container
{
  private final String aqm;
  private final DataLayer aqn;
  private ct aqo;
  private Map<String, FunctionCallMacroCallback> aqp = new HashMap();
  private Map<String, FunctionCallTagCallback> aqq = new HashMap();
  private volatile long aqr;
  private volatile String aqs = "";
  private final Context mContext;
  
  Container(Context paramContext, DataLayer paramDataLayer, String paramString, long paramLong, c.j paramj)
  {
    this.mContext = paramContext;
    this.aqn = paramDataLayer;
    this.aqm = paramString;
    this.aqr = paramLong;
    a(paramj.gs);
    if (paramj.gr != null) {
      a(paramj.gr);
    }
  }
  
  Container(Context paramContext, DataLayer paramDataLayer, String paramString, long paramLong, cr.c paramc)
  {
    this.mContext = paramContext;
    this.aqn = paramDataLayer;
    this.aqm = paramString;
    this.aqr = paramLong;
    a(paramc);
  }
  
  private void a(c.f paramf)
  {
    if (paramf == null) {
      throw new NullPointerException();
    }
    try
    {
      cr.c localc = cr.b(paramf);
      a(localc);
      return;
    }
    catch (cr.g localg)
    {
      bh.T("Not loading resource: " + paramf + " because it is invalid: " + localg.toString());
    }
  }
  
  private void a(cr.c paramc)
  {
    this.aqs = paramc.getVersion();
    ag localag = cs(this.aqs);
    a(new ct(this.mContext, paramc, this.aqn, new a(null), new b(null), localag));
  }
  
  private void a(ct paramct)
  {
    try
    {
      this.aqo = paramct;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void a(c.i[] paramArrayOfi)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfi.length;
    for (int j = 0; j < i; j++) {
      localArrayList.add(paramArrayOfi[j]);
    }
    pk().l(localArrayList);
  }
  
  private ct pk()
  {
    try
    {
      ct localct = this.aqo;
      return localct;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  FunctionCallMacroCallback cp(String paramString)
  {
    synchronized (this.aqp)
    {
      FunctionCallMacroCallback localFunctionCallMacroCallback = (FunctionCallMacroCallback)this.aqp.get(paramString);
      return localFunctionCallMacroCallback;
    }
  }
  
  FunctionCallTagCallback cq(String paramString)
  {
    synchronized (this.aqq)
    {
      FunctionCallTagCallback localFunctionCallTagCallback = (FunctionCallTagCallback)this.aqq.get(paramString);
      return localFunctionCallTagCallback;
    }
  }
  
  void cr(String paramString)
  {
    pk().cr(paramString);
  }
  
  ag cs(String paramString)
  {
    if (ce.qa().qb().equals(ce.a.ass)) {}
    return new br();
  }
  
  public boolean getBoolean(String paramString)
  {
    ct localct = pk();
    if (localct == null)
    {
      bh.T("getBoolean called for closed container.");
      return di.qY().booleanValue();
    }
    try
    {
      boolean bool = di.n((d.a)localct.cT(paramString).getObject()).booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
      bh.T("Calling getBoolean() threw an exception: " + localException.getMessage() + " Returning default value.");
    }
    return di.qY().booleanValue();
  }
  
  public String getContainerId()
  {
    return this.aqm;
  }
  
  public double getDouble(String paramString)
  {
    ct localct = pk();
    if (localct == null)
    {
      bh.T("getDouble called for closed container.");
      return di.qX().doubleValue();
    }
    try
    {
      double d = di.m((d.a)localct.cT(paramString).getObject()).doubleValue();
      return d;
    }
    catch (Exception localException)
    {
      bh.T("Calling getDouble() threw an exception: " + localException.getMessage() + " Returning default value.");
    }
    return di.qX().doubleValue();
  }
  
  public long getLastRefreshTime()
  {
    return this.aqr;
  }
  
  public long getLong(String paramString)
  {
    ct localct = pk();
    if (localct == null)
    {
      bh.T("getLong called for closed container.");
      return di.qW().longValue();
    }
    try
    {
      long l = di.l((d.a)localct.cT(paramString).getObject()).longValue();
      return l;
    }
    catch (Exception localException)
    {
      bh.T("Calling getLong() threw an exception: " + localException.getMessage() + " Returning default value.");
    }
    return di.qW().longValue();
  }
  
  public String getString(String paramString)
  {
    ct localct = pk();
    if (localct == null)
    {
      bh.T("getString called for closed container.");
      return di.ra();
    }
    try
    {
      String str = di.j((d.a)localct.cT(paramString).getObject());
      return str;
    }
    catch (Exception localException)
    {
      bh.T("Calling getString() threw an exception: " + localException.getMessage() + " Returning default value.");
    }
    return di.ra();
  }
  
  public boolean isDefault()
  {
    return getLastRefreshTime() == 0L;
  }
  
  String pj()
  {
    return this.aqs;
  }
  
  public void registerFunctionCallMacroCallback(String paramString, FunctionCallMacroCallback paramFunctionCallMacroCallback)
  {
    if (paramFunctionCallMacroCallback == null) {
      throw new NullPointerException("Macro handler must be non-null");
    }
    synchronized (this.aqp)
    {
      this.aqp.put(paramString, paramFunctionCallMacroCallback);
      return;
    }
  }
  
  public void registerFunctionCallTagCallback(String paramString, FunctionCallTagCallback paramFunctionCallTagCallback)
  {
    if (paramFunctionCallTagCallback == null) {
      throw new NullPointerException("Tag callback must be non-null");
    }
    synchronized (this.aqq)
    {
      this.aqq.put(paramString, paramFunctionCallTagCallback);
      return;
    }
  }
  
  void release()
  {
    this.aqo = null;
  }
  
  public void unregisterFunctionCallMacroCallback(String paramString)
  {
    synchronized (this.aqp)
    {
      this.aqp.remove(paramString);
      return;
    }
  }
  
  public void unregisterFunctionCallTagCallback(String paramString)
  {
    synchronized (this.aqq)
    {
      this.aqq.remove(paramString);
      return;
    }
  }
  
  public static abstract interface FunctionCallMacroCallback
  {
    public abstract Object getValue(String paramString, Map<String, Object> paramMap);
  }
  
  public static abstract interface FunctionCallTagCallback
  {
    public abstract void execute(String paramString, Map<String, Object> paramMap);
  }
  
  private class a
    implements s.a
  {
    private a() {}
    
    public Object b(String paramString, Map<String, Object> paramMap)
    {
      Container.FunctionCallMacroCallback localFunctionCallMacroCallback = Container.this.cp(paramString);
      if (localFunctionCallMacroCallback == null) {
        return null;
      }
      return localFunctionCallMacroCallback.getValue(paramString, paramMap);
    }
  }
  
  private class b
    implements s.a
  {
    private b() {}
    
    public Object b(String paramString, Map<String, Object> paramMap)
    {
      Container.FunctionCallTagCallback localFunctionCallTagCallback = Container.this.cq(paramString);
      if (localFunctionCallTagCallback != null) {
        localFunctionCallTagCallback.execute(paramString, paramMap);
      }
      return di.ra();
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.Container
 * JD-Core Version:    0.7.0.1
 */