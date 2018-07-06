package org.apache.commons.httpclient.methods.multipart;

import java.io.IOException;
import java.io.InputStream;

public abstract interface PartSource
{
  public abstract InputStream createInputStream()
    throws IOException;
  
  public abstract String getFileName();
  
  public abstract long getLength();
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.methods.multipart.PartSource
 * JD-Core Version:    0.7.0.1
 */