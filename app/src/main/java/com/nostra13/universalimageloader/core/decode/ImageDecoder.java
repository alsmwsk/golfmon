package com.nostra13.universalimageloader.core.decode;

import android.graphics.Bitmap;
import java.io.IOException;

public abstract interface ImageDecoder
{
  public abstract Bitmap decode(ImageDecodingInfo paramImageDecodingInfo)
    throws IOException;
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.decode.ImageDecoder
 * JD-Core Version:    0.7.0.1
 */