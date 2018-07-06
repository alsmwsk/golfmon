package org.apache.commons.httpclient.methods;

import java.io.IOException;
import java.io.OutputStream;

public abstract interface RequestEntity
{
  public abstract long getContentLength();
  
  public abstract String getContentType();
  
  public abstract boolean isRepeatable();
  
  public abstract void writeRequest(OutputStream paramOutputStream)
    throws IOException;
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.methods.RequestEntity
 * JD-Core Version:    0.7.0.1
 */