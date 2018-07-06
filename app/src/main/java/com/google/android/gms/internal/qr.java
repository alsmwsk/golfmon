package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class qr<M extends qq<M>, T>
{
  protected final Class<T> ayX;
  protected final boolean ayY;
  public final int tag;
  protected final int type;
  
  private qr(int paramInt1, Class<T> paramClass, int paramInt2, boolean paramBoolean)
  {
    this.type = paramInt1;
    this.ayX = paramClass;
    this.tag = paramInt2;
    this.ayY = paramBoolean;
  }
  
  public static <M extends qq<M>, T extends qw> qr<M, T> a(int paramInt1, Class<T> paramClass, int paramInt2)
  {
    return new qr(paramInt1, paramClass, paramInt2, false);
  }
  
  private T n(List<qy> paramList)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    for (int j = 0; j < paramList.size(); j++)
    {
      qy localqy = (qy)paramList.get(j);
      if (localqy.azi.length != 0) {
        a(localqy, localArrayList);
      }
    }
    int k = localArrayList.size();
    Object localObject;
    if (k == 0) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      localObject = this.ayX.cast(Array.newInstance(this.ayX.getComponentType(), k));
      while (i < k)
      {
        Array.set(localObject, i, localArrayList.get(i));
        i++;
      }
    }
  }
  
  private T o(List<qy> paramList)
  {
    if (paramList.isEmpty()) {
      return null;
    }
    qy localqy = (qy)paramList.get(-1 + paramList.size());
    return this.ayX.cast(x(qo.p(localqy.azi)));
  }
  
  int B(Object paramObject)
  {
    if (this.ayY) {
      return C(paramObject);
    }
    return D(paramObject);
  }
  
  protected int C(Object paramObject)
  {
    int i = 0;
    int j = Array.getLength(paramObject);
    for (int k = 0; k < j; k++) {
      if (Array.get(paramObject, k) != null) {
        i += D(Array.get(paramObject, k));
      }
    }
    return i;
  }
  
  protected int D(Object paramObject)
  {
    int i = qz.hl(this.tag);
    switch (this.type)
    {
    default: 
      throw new IllegalArgumentException("Unknown type " + this.type);
    case 10: 
      return qp.b(i, (qw)paramObject);
    }
    return qp.c(i, (qw)paramObject);
  }
  
  protected void a(qy paramqy, List<Object> paramList)
  {
    paramList.add(x(qo.p(paramqy.azi)));
  }
  
  void a(Object paramObject, qp paramqp)
    throws IOException
  {
    if (this.ayY)
    {
      c(paramObject, paramqp);
      return;
    }
    b(paramObject, paramqp);
  }
  
  protected void b(Object paramObject, qp paramqp)
  {
    try
    {
      paramqp.hd(this.tag);
      switch (this.type)
      {
      default: 
        throw new IllegalArgumentException("Unknown type " + this.type);
      }
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException);
    }
    qw localqw = (qw)paramObject;
    int i = qz.hl(this.tag);
    paramqp.b(localqw);
    paramqp.x(i, 4);
    return;
    paramqp.c((qw)paramObject);
  }
  
  protected void c(Object paramObject, qp paramqp)
  {
    int i = Array.getLength(paramObject);
    for (int j = 0; j < i; j++)
    {
      Object localObject = Array.get(paramObject, j);
      if (localObject != null) {
        b(localObject, paramqp);
      }
    }
  }
  
  final T m(List<qy> paramList)
  {
    if (paramList == null) {
      return null;
    }
    if (this.ayY) {
      return n(paramList);
    }
    return o(paramList);
  }
  
  protected Object x(qo paramqo)
  {
    Class localClass;
    if (this.ayY) {
      localClass = this.ayX.getComponentType();
    }
    try
    {
      switch (this.type)
      {
      default: 
        throw new IllegalArgumentException("Unknown type " + this.type);
      }
    }
    catch (InstantiationException localInstantiationException)
    {
      for (;;)
      {
        throw new IllegalArgumentException("Error creating instance of class " + localClass, localInstantiationException);
        localClass = this.ayX;
      }
      qw localqw2 = (qw)localClass.newInstance();
      paramqo.a(localqw2, qz.hl(this.tag));
      return localqw2;
      qw localqw1 = (qw)localClass.newInstance();
      paramqo.a(localqw1);
      return localqw1;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new IllegalArgumentException("Error creating instance of class " + localClass, localIllegalAccessException);
    }
    catch (IOException localIOException)
    {
      throw new IllegalArgumentException("Error reading extension field", localIOException);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.qr
 * JD-Core Version:    0.7.0.1
 */