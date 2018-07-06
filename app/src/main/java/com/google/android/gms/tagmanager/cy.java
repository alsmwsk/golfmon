package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class cy
  extends cx
{
  private static cy atJ;
  private static final Object yT = new Object();
  private at atA;
  private volatile ar atB;
  private int atC = 1800000;
  private boolean atD = true;
  private boolean atE = false;
  private boolean atF = true;
  private au atG = new au()
  {
    public void B(boolean paramAnonymousBoolean)
    {
      cy.this.a(paramAnonymousBoolean, cy.a(cy.this));
    }
  };
  private bo atH;
  private boolean atI = false;
  private Context atz;
  private boolean connected = true;
  private Handler handler;
  
  private void ev()
  {
    this.atH = new bo(this);
    this.atH.z(this.atz);
  }
  
  private void ew()
  {
    this.handler = new Handler(this.atz.getMainLooper(), new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        if ((1 == paramAnonymousMessage.what) && (cy.ez().equals(paramAnonymousMessage.obj)))
        {
          cy.this.dispatch();
          if ((cy.b(cy.this) > 0) && (!cy.c(cy.this))) {
            cy.d(cy.this).sendMessageDelayed(cy.d(cy.this).obtainMessage(1, cy.ez()), cy.b(cy.this));
          }
        }
        return true;
      }
    });
    if (this.atC > 0) {
      this.handler.sendMessageDelayed(this.handler.obtainMessage(1, yT), this.atC);
    }
  }
  
  public static cy qN()
  {
    if (atJ == null) {
      atJ = new cy();
    }
    return atJ;
  }
  
  void C(boolean paramBoolean)
  {
    try
    {
      a(this.atI, paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  void a(Context paramContext, ar paramar)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 81	com/google/android/gms/tagmanager/cy:atz	Landroid/content/Context;
    //   6: astore 4
    //   8: aload 4
    //   10: ifnull +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 125	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   21: putfield 81	com/google/android/gms/tagmanager/cy:atz	Landroid/content/Context;
    //   24: aload_0
    //   25: getfield 127	com/google/android/gms/tagmanager/cy:atB	Lcom/google/android/gms/tagmanager/ar;
    //   28: ifnonnull -15 -> 13
    //   31: aload_0
    //   32: aload_2
    //   33: putfield 127	com/google/android/gms/tagmanager/cy:atB	Lcom/google/android/gms/tagmanager/ar;
    //   36: goto -23 -> 13
    //   39: astore_3
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_3
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	cy
    //   0	44	1	paramContext	Context
    //   0	44	2	paramar	ar
    //   39	4	3	localObject	Object
    //   6	3	4	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   2	8	39	finally
    //   16	36	39	finally
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      try
      {
        if (this.atI == paramBoolean1)
        {
          boolean bool = this.connected;
          if (bool == paramBoolean2) {
            return;
          }
        }
        if (((paramBoolean1) || (!paramBoolean2)) && (this.atC > 0)) {
          this.handler.removeMessages(1, yT);
        }
        if ((!paramBoolean1) && (paramBoolean2) && (this.atC > 0)) {
          this.handler.sendMessageDelayed(this.handler.obtainMessage(1, yT), this.atC);
        }
        localStringBuilder = new StringBuilder().append("PowerSaveMode ");
        if (paramBoolean1) {
          break label153;
        }
        if (paramBoolean2) {
          break label146;
        }
      }
      finally {}
      bh.V(str);
      this.atI = paramBoolean1;
      this.connected = paramBoolean2;
      continue;
      label146:
      String str = "terminated.";
      continue;
      label153:
      str = "initiated.";
    }
  }
  
  /* Error */
  public void dispatch()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 45	com/google/android/gms/tagmanager/cy:atE	Z
    //   6: ifne +16 -> 22
    //   9: ldc 157
    //   11: invokestatic 150	com/google/android/gms/tagmanager/bh:V	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 43	com/google/android/gms/tagmanager/cy:atD	Z
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 127	com/google/android/gms/tagmanager/cy:atB	Lcom/google/android/gms/tagmanager/ar;
    //   26: new 159	com/google/android/gms/tagmanager/cy$3
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 160	com/google/android/gms/tagmanager/cy$3:<init>	(Lcom/google/android/gms/tagmanager/cy;)V
    //   34: invokeinterface 165 2 0
    //   39: goto -20 -> 19
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	cy
    //   42	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	42	finally
    //   22	39	42	finally
  }
  
  void ey()
  {
    try
    {
      if ((!this.atI) && (this.connected) && (this.atC > 0))
      {
        this.handler.removeMessages(1, yT);
        this.handler.sendMessage(this.handler.obtainMessage(1, yT));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  at qO()
  {
    try
    {
      if (this.atA != null) {
        break label50;
      }
      if (this.atz == null) {
        throw new IllegalStateException("Cant get a store unless we have a context");
      }
    }
    finally {}
    this.atA = new cb(this.atG, this.atz);
    label50:
    if (this.handler == null) {
      ew();
    }
    this.atE = true;
    if (this.atD)
    {
      dispatch();
      this.atD = false;
    }
    if ((this.atH == null) && (this.atF)) {
      ev();
    }
    at localat = this.atA;
    return localat;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.cy
 * JD-Core Version:    0.7.0.1
 */