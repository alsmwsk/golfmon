package com.nostra13.universalimageloader.core.download;

import com.nostra13.universalimageloader.core.assist.FlushedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SlowNetworkImageDownloader
  implements ImageDownloader
{
  private final ImageDownloader wrappedDownloader;
  
  public SlowNetworkImageDownloader(ImageDownloader paramImageDownloader)
  {
    this.wrappedDownloader = paramImageDownloader;
  }
  
  public InputStream getStream(String paramString, Object paramObject)
    throws IOException
  {
    InputStream localInputStream = this.wrappedDownloader.getStream(paramString, paramObject);
    switch (1.$SwitchMap$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.ofUri(paramString).ordinal()])
    {
    default: 
      return localInputStream;
    }
    return new FlushedInputStream(localInputStream);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.download.SlowNetworkImageDownloader
 * JD-Core Version:    0.7.0.1
 */