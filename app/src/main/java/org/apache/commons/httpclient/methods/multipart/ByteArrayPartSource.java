package org.apache.commons.httpclient.methods.multipart;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteArrayPartSource
  implements PartSource
{
  private byte[] bytes;
  private String fileName;
  
  public ByteArrayPartSource(String paramString, byte[] paramArrayOfByte)
  {
    this.fileName = paramString;
    this.bytes = paramArrayOfByte;
  }
  
  public InputStream createInputStream()
    throws IOException
  {
    return new ByteArrayInputStream(this.bytes);
  }
  
  public String getFileName()
  {
    return this.fileName;
  }
  
  public long getLength()
  {
    return this.bytes.length;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.methods.multipart.ByteArrayPartSource
 * JD-Core Version:    0.7.0.1
 */