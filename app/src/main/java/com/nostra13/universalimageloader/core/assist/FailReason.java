package com.nostra13.universalimageloader.core.assist;

public class FailReason
{
  private final Throwable cause;
  private final FailType type;
  
  public FailReason(FailType paramFailType, Throwable paramThrowable)
  {
    this.type = paramFailType;
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
  
  public FailType getType()
  {
    return this.type;
  }
  
  public static enum FailType
  {
    static
    {
      DECODING_ERROR = new FailType("DECODING_ERROR", 1);
      NETWORK_DENIED = new FailType("NETWORK_DENIED", 2);
      OUT_OF_MEMORY = new FailType("OUT_OF_MEMORY", 3);
      UNKNOWN = new FailType("UNKNOWN", 4);
      FailType[] arrayOfFailType = new FailType[5];
      arrayOfFailType[0] = IO_ERROR;
      arrayOfFailType[1] = DECODING_ERROR;
      arrayOfFailType[2] = NETWORK_DENIED;
      arrayOfFailType[3] = OUT_OF_MEMORY;
      arrayOfFailType[4] = UNKNOWN;
      $VALUES = arrayOfFailType;
    }
    
    private FailType() {}
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.FailReason
 * JD-Core Version:    0.7.0.1
 */