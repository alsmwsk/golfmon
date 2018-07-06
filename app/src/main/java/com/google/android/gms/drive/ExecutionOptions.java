package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.internal.r;
import com.google.android.gms.internal.jv;

public final class ExecutionOptions
{
  public static final int CONFLICT_STRATEGY_KEEP_REMOTE = 1;
  public static final int CONFLICT_STRATEGY_OVERWRITE_REMOTE = 0;
  public static final int MAX_TRACKING_TAG_STRING_LENGTH = 65536;
  private final int OA;
  private final String Oy;
  private final boolean Oz;
  
  public ExecutionOptions(String paramString, boolean paramBoolean, int paramInt)
  {
    this.Oy = paramString;
    this.Oz = paramBoolean;
    this.OA = paramInt;
  }
  
  public static void a(GoogleApiClient paramGoogleApiClient, ExecutionOptions paramExecutionOptions)
  {
    r localr = (r)paramGoogleApiClient.a(Drive.DQ);
    if ((paramExecutionOptions.iw()) && (!localr.iJ())) {
      throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to be notified on completion");
    }
  }
  
  public static boolean ba(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean bb(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean bj(String paramString)
  {
    return (paramString != null) && (!paramString.isEmpty()) && (paramString.length() <= 65536);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if ((paramObject == null) || (paramObject.getClass() != getClass())) {
      bool = false;
    }
    ExecutionOptions localExecutionOptions;
    do
    {
      do
      {
        return bool;
      } while (paramObject == this);
      localExecutionOptions = (ExecutionOptions)paramObject;
    } while ((jv.equal(this.Oy, localExecutionOptions.Oy)) && (this.OA == localExecutionOptions.OA) && (this.Oz == localExecutionOptions.Oz));
    return false;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.Oy;
    arrayOfObject[1] = Integer.valueOf(this.OA);
    arrayOfObject[2] = Boolean.valueOf(this.Oz);
    return jv.hashCode(arrayOfObject);
  }
  
  public String iv()
  {
    return this.Oy;
  }
  
  public boolean iw()
  {
    return this.Oz;
  }
  
  public int ix()
  {
    return this.OA;
  }
  
  public static final class Builder
  {
    private int OA = 0;
    private String Oy;
    private boolean Oz;
    
    public ExecutionOptions build()
    {
      if ((this.OA == 1) && (!this.Oz)) {
        throw new IllegalStateException("Cannot use CONFLICT_STRATEGY_KEEP_REMOTE without requesting completion notifications");
      }
      return new ExecutionOptions(this.Oy, this.Oz, this.OA);
    }
    
    public Builder setConflictStrategy(int paramInt)
    {
      if (!ExecutionOptions.bb(paramInt)) {
        throw new IllegalArgumentException("Unrecognized value for conflict strategy: " + paramInt);
      }
      this.OA = paramInt;
      return this;
    }
    
    public Builder setNotifyOnCompletion(boolean paramBoolean)
    {
      this.Oz = paramBoolean;
      return this;
    }
    
    public Builder setTrackingTag(String paramString)
    {
      if (!ExecutionOptions.bj(paramString))
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(65536);
        throw new IllegalArgumentException(String.format("trackingTag must not be null nor empty, and the length must be <= the maximum length (%s)", arrayOfObject));
      }
      this.Oy = paramString;
      return this;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.ExecutionOptions
 * JD-Core Version:    0.7.0.1
 */