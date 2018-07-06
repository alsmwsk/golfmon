package org.apache.commons.httpclient.methods;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class InputStreamRequestEntity
  implements RequestEntity
{
  public static final int CONTENT_LENGTH_AUTO = -2;
  private static final Log LOG;
  static Class class$org$apache$commons$httpclient$methods$InputStreamRequestEntity;
  private byte[] buffer = null;
  private InputStream content;
  private long contentLength;
  private String contentType;
  
  static
  {
    Class localClass;
    if (class$org$apache$commons$httpclient$methods$InputStreamRequestEntity == null)
    {
      localClass = class$("org.apache.commons.httpclient.methods.InputStreamRequestEntity");
      class$org$apache$commons$httpclient$methods$InputStreamRequestEntity = localClass;
    }
    for (;;)
    {
      LOG = LogFactory.getLog(localClass);
      return;
      localClass = class$org$apache$commons$httpclient$methods$InputStreamRequestEntity;
    }
  }
  
  public InputStreamRequestEntity(InputStream paramInputStream)
  {
    this(paramInputStream, null);
  }
  
  public InputStreamRequestEntity(InputStream paramInputStream, long paramLong)
  {
    this(paramInputStream, paramLong, null);
  }
  
  public InputStreamRequestEntity(InputStream paramInputStream, long paramLong, String paramString)
  {
    if (paramInputStream == null) {
      throw new IllegalArgumentException("The content cannot be null");
    }
    this.content = paramInputStream;
    this.contentLength = paramLong;
    this.contentType = paramString;
  }
  
  public InputStreamRequestEntity(InputStream paramInputStream, String paramString)
  {
    this(paramInputStream, -2L, paramString);
  }
  
  private void bufferContent()
  {
    if (this.buffer != null) {}
    while (this.content == null) {
      return;
    }
    for (;;)
    {
      ByteArrayOutputStream localByteArrayOutputStream;
      byte[] arrayOfByte;
      int i;
      try
      {
        localByteArrayOutputStream = new ByteArrayOutputStream();
        arrayOfByte = new byte[4096];
        i = this.content.read(arrayOfByte);
        if (i < 0)
        {
          this.buffer = localByteArrayOutputStream.toByteArray();
          this.content = null;
          this.contentLength = this.buffer.length;
          return;
        }
      }
      catch (IOException localIOException)
      {
        LOG.error(localIOException.getMessage(), localIOException);
        this.buffer = null;
        this.content = null;
        this.contentLength = 0L;
        return;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  static Class class$(String paramString)
  {
    try
    {
      Class localClass = Class.forName(paramString);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new NoClassDefFoundError(localClassNotFoundException.getMessage());
    }
  }
  
  public InputStream getContent()
  {
    return this.content;
  }
  
  public long getContentLength()
  {
    if ((this.contentLength == -2L) && (this.buffer == null)) {
      bufferContent();
    }
    return this.contentLength;
  }
  
  public String getContentType()
  {
    return this.contentType;
  }
  
  public boolean isRepeatable()
  {
    return this.buffer != null;
  }
  
  public void writeRequest(OutputStream paramOutputStream)
    throws IOException
  {
    if (this.content != null)
    {
      byte[] arrayOfByte = new byte[4096];
      int i = 0;
      for (;;)
      {
        int j = this.content.read(arrayOfByte);
        if (j < 0) {
          return;
        }
        paramOutputStream.write(arrayOfByte, 0, j);
        i += j;
      }
    }
    if (this.buffer != null)
    {
      paramOutputStream.write(this.buffer);
      return;
    }
    throw new IllegalStateException("Content must be set before entity is written");
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.methods.InputStreamRequestEntity
 * JD-Core Version:    0.7.0.1
 */