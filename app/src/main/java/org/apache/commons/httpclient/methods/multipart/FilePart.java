package org.apache.commons.httpclient.methods.multipart;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.httpclient.util.EncodingUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FilePart
  extends PartBase
{
  public static final String DEFAULT_CHARSET = "ISO-8859-1";
  public static final String DEFAULT_CONTENT_TYPE = "application/octet-stream";
  public static final String DEFAULT_TRANSFER_ENCODING = "binary";
  protected static final String FILE_NAME = "; filename=";
  private static final byte[] FILE_NAME_BYTES;
  private static final Log LOG;
  static Class class$org$apache$commons$httpclient$methods$multipart$FilePart;
  private PartSource source;
  
  static
  {
    Class localClass;
    if (class$org$apache$commons$httpclient$methods$multipart$FilePart == null)
    {
      localClass = class$("org.apache.commons.httpclient.methods.multipart.FilePart");
      class$org$apache$commons$httpclient$methods$multipart$FilePart = localClass;
    }
    for (;;)
    {
      LOG = LogFactory.getLog(localClass);
      FILE_NAME_BYTES = EncodingUtil.getAsciiBytes("; filename=");
      return;
      localClass = class$org$apache$commons$httpclient$methods$multipart$FilePart;
    }
  }
  
  public FilePart(String paramString, File paramFile)
    throws FileNotFoundException
  {
    this(paramString, new FilePartSource(paramFile), null, null);
  }
  
  public FilePart(String paramString1, File paramFile, String paramString2, String paramString3)
    throws FileNotFoundException
  {
    this(paramString1, new FilePartSource(paramFile), paramString2, paramString3);
  }
  
  public FilePart(String paramString1, String paramString2, File paramFile)
    throws FileNotFoundException
  {
    this(paramString1, new FilePartSource(paramString2, paramFile), null, null);
  }
  
  public FilePart(String paramString1, String paramString2, File paramFile, String paramString3, String paramString4)
    throws FileNotFoundException
  {
    this(paramString1, new FilePartSource(paramString2, paramFile), paramString3, paramString4);
  }
  
  public FilePart(String paramString, PartSource paramPartSource)
  {
    this(paramString, paramPartSource, null, null);
  }
  
  public FilePart(String paramString1, PartSource paramPartSource, String paramString2, String paramString3)
  {
    super(paramString1, paramString2, paramString3, "binary");
    if (paramPartSource == null) {
      throw new IllegalArgumentException("Source may not be null");
    }
    this.source = paramPartSource;
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
  
  protected PartSource getSource()
  {
    LOG.trace("enter getSource()");
    return this.source;
  }
  
  protected long lengthOfData()
    throws IOException
  {
    LOG.trace("enter lengthOfData()");
    return this.source.getLength();
  }
  
  /* Error */
  protected void sendData(OutputStream paramOutputStream)
    throws IOException
  {
    // Byte code:
    //   0: getstatic 43	org/apache/commons/httpclient/methods/multipart/FilePart:LOG	Lorg/apache/commons/logging/Log;
    //   3: ldc 122
    //   5: invokeinterface 107 2 0
    //   10: aload_0
    //   11: invokevirtual 124	org/apache/commons/httpclient/methods/multipart/FilePart:lengthOfData	()J
    //   14: lconst_0
    //   15: lcmp
    //   16: ifne +14 -> 30
    //   19: getstatic 43	org/apache/commons/httpclient/methods/multipart/FilePart:LOG	Lorg/apache/commons/logging/Log;
    //   22: ldc 126
    //   24: invokeinterface 129 2 0
    //   29: return
    //   30: sipush 4096
    //   33: newarray byte
    //   35: astore_2
    //   36: aload_0
    //   37: getfield 81	org/apache/commons/httpclient/methods/multipart/FilePart:source	Lorg/apache/commons/httpclient/methods/multipart/PartSource;
    //   40: invokeinterface 133 1 0
    //   45: astore_3
    //   46: aload_3
    //   47: aload_2
    //   48: invokevirtual 139	java/io/InputStream:read	([B)I
    //   51: istore 5
    //   53: iload 5
    //   55: ifge +8 -> 63
    //   58: aload_3
    //   59: invokevirtual 142	java/io/InputStream:close	()V
    //   62: return
    //   63: aload_1
    //   64: aload_2
    //   65: iconst_0
    //   66: iload 5
    //   68: invokevirtual 148	java/io/OutputStream:write	([BII)V
    //   71: goto -25 -> 46
    //   74: astore 4
    //   76: aload_3
    //   77: invokevirtual 142	java/io/InputStream:close	()V
    //   80: aload 4
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	FilePart
    //   0	83	1	paramOutputStream	OutputStream
    //   35	30	2	arrayOfByte	byte[]
    //   45	32	3	localInputStream	java.io.InputStream
    //   74	7	4	localObject	java.lang.Object
    //   51	16	5	i	int
    // Exception table:
    //   from	to	target	type
    //   46	53	74	finally
    //   63	71	74	finally
  }
  
  protected void sendDispositionHeader(OutputStream paramOutputStream)
    throws IOException
  {
    LOG.trace("enter sendDispositionHeader(OutputStream out)");
    super.sendDispositionHeader(paramOutputStream);
    String str = this.source.getFileName();
    if (str != null)
    {
      paramOutputStream.write(FILE_NAME_BYTES);
      paramOutputStream.write(Part.QUOTE_BYTES);
      paramOutputStream.write(EncodingUtil.getAsciiBytes(str));
      paramOutputStream.write(Part.QUOTE_BYTES);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.methods.multipart.FilePart
 * JD-Core Version:    0.7.0.1
 */