package com.nostra13.universalimageloader.core.download;

import java.io.IOException;
import java.io.InputStream;

public class NetworkDeniedImageDownloader
  implements ImageDownloader
{
  private final ImageDownloader wrappedDownloader;
  
  public NetworkDeniedImageDownloader(ImageDownloader paramImageDownloader)
  {
    this.wrappedDownloader = paramImageDownloader;
  }
  
  public InputStream getStream(String paramString, Object paramObject)
    throws IOException
  {
    switch (1.$SwitchMap$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.ofUri(paramString).ordinal()])
    {
    default: 
      return this.wrappedDownloader.getStream(paramString, paramObject);
    }
    throw new IllegalStateException();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.download.NetworkDeniedImageDownloader
 * JD-Core Version:    0.7.0.1
 */