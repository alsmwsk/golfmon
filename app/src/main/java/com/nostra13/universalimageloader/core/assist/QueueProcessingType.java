package com.nostra13.universalimageloader.core.assist;

public enum QueueProcessingType
{
  static
  {
    QueueProcessingType[] arrayOfQueueProcessingType = new QueueProcessingType[2];
    arrayOfQueueProcessingType[0] = FIFO;
    arrayOfQueueProcessingType[1] = LIFO;
    $VALUES = arrayOfQueueProcessingType;
  }
  
  private QueueProcessingType() {}
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.QueueProcessingType
 * JD-Core Version:    0.7.0.1
 */