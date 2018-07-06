package com.appg.crop;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import com.appg.golfmon.util.Alert;
import com.appg.golfmon.util.ImageUtil;
import com.appg.golfmon.util.LogUtil;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Crop
{
  public static final int TAKE_CROP_IMAGE_CUSTOM = 6844;
  public static final int TAKE_FROM_GALLERY = 6843;
  public static final int TAKE_PICTURE = 6842;
  private Activity mActivity = null;
  private int mCropMode = 200;
  private Uri mImgOriginUri = null;
  
  public Crop(Activity paramActivity, int paramInt)
  {
    this.mActivity = paramActivity;
    this.mCropMode = paramInt;
  }
  
  private void takeCropCustom(String paramString)
  {
    LogUtil.e("takeCropCutom path : " + paramString);
    if (ImageUtil.checkImage(paramString))
    {
      Intent localIntent = new Intent(this.mActivity, AtvCropImage.class);
      localIntent.putExtra("path", paramString);
      localIntent.putExtra("type", 0);
      localIntent.putExtra("mode", this.mCropMode);
      this.mActivity.startActivityForResult(localIntent, 6844);
      return;
    }
    Alert.toastShort(this.mActivity, "사진이 정상적으로 처리되지 않았습니다.");
  }
  
  public Bitmap getScaleBitmap(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > paramInt2) {}
    for (float f = paramInt2 / 300;; f = paramInt1 / 300)
    {
      if (f < 0.0F) {
        f = 0.0F;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = Math.round(f);
      Bitmap localBitmap = BitmapFactory.decodeFile(paramString, localOptions);
      if (paramInt3 != 0) {
        localBitmap = ImageUtil.getRotatedBitmap(localBitmap, paramInt3);
      }
      return localBitmap;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent, ICropCallBack paramICropCallBack)
  {
    if (paramInt2 == -1)
    {
      if (paramInt1 != 6842) {
        break label56;
      }
      try
      {
        if (this.mImgOriginUri == null) {
          throw new Exception();
        }
      }
      catch (Exception localException2)
      {
        Alert.toastShort(this.mActivity, "다시 시도해 주세요.");
        localException2.printStackTrace();
      }
    }
    label56:
    String str;
    int[] arrayOfInt;
    int i;
    do
    {
      do
      {
        return;
        takeCropCustom(this.mImgOriginUri.getPath());
        return;
        if (paramInt1 == 6843)
        {
          try
          {
            this.mImgOriginUri = paramIntent.getData();
            if (this.mImgOriginUri == null) {
              throw new Exception();
            }
          }
          catch (Exception localException1)
          {
            Alert.toastShort(this.mActivity, "다시 시도해 주세요.");
            localException1.printStackTrace();
            return;
          }
          takeCropCustom(ImageUtil.getRealImagePath(this.mActivity, this.mImgOriginUri));
          return;
        }
      } while (paramInt1 != 6844);
      str = paramIntent.getExtras().getString("data");
      LogUtil.d("TAKE_CROP_IMAGE imagePath : " + str);
      arrayOfInt = ImageUtil.getImageSize(str);
      if (arrayOfInt == null) {
        break;
      }
      i = ImageUtil.getPhotoOrientationDegree(str);
      LogUtil.d("TAKE_CROP_IMAGE imgWidth : " + arrayOfInt[0]);
      LogUtil.d("TAKE_CROP_IMAGE imgHeight: " + arrayOfInt[1]);
      LogUtil.d("TAKE_CROP_IMAGE degree: " + i);
    } while (paramICropCallBack == null);
    paramICropCallBack.onResult(str, arrayOfInt[0], arrayOfInt[1], i);
    return;
    Alert.toastShort(this.mActivity, "다시 시도해 주세요.");
  }
  
  public void onActivityResultNonCrop(int paramInt1, int paramInt2, Intent paramIntent, ICropCallBack paramICropCallBack)
  {
    if (paramInt2 == -1)
    {
      if (paramInt1 != 6842) {
        break label107;
      }
      try
      {
        if (this.mImgOriginUri == null) {
          throw new Exception();
        }
      }
      catch (Exception localException2)
      {
        Alert.toastShort(this.mActivity, "다시 시도해 주세요.");
        localException2.printStackTrace();
      }
    }
    label107:
    String str1;
    int[] arrayOfInt1;
    int i;
    do
    {
      do
      {
        String str2;
        int[] arrayOfInt2;
        int j;
        do
        {
          return;
          str2 = this.mImgOriginUri.getPath();
          arrayOfInt2 = ImageUtil.getImageSize(str2);
          if (arrayOfInt2 == null) {
            break;
          }
          j = ImageUtil.getPhotoOrientationDegree(str2);
        } while (paramICropCallBack == null);
        paramICropCallBack.onResult(str2, arrayOfInt2[0], arrayOfInt2[1], j);
        return;
        Alert.toastShort(this.mActivity, "다시 시도해 주세요.");
        return;
      } while (paramInt1 != 6843);
      try
      {
        this.mImgOriginUri = paramIntent.getData();
        if (this.mImgOriginUri == null) {
          throw new Exception();
        }
      }
      catch (Exception localException1)
      {
        Alert.toastShort(this.mActivity, "다시 시도해 주세요.");
        localException1.printStackTrace();
        return;
      }
      str1 = ImageUtil.getRealImagePath(this.mActivity, this.mImgOriginUri);
      arrayOfInt1 = ImageUtil.getImageSize(str1);
      if (arrayOfInt1 == null) {
        break;
      }
      i = ImageUtil.getPhotoOrientationDegree(str1);
    } while (paramICropCallBack == null);
    paramICropCallBack.onResult(str1, arrayOfInt1[0], arrayOfInt1[1], i);
    return;
    Alert.toastShort(this.mActivity, "다시 시도해 주세요.");
  }
  
  public void takeCamera()
  {
    String str = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(System.currentTimeMillis())) + ".jpg";
    this.mImgOriginUri = Uri.fromFile(new File(this.mActivity.getExternalCacheDir(), str));
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    localIntent.putExtra("output", this.mImgOriginUri);
    this.mActivity.startActivityForResult(localIntent, 6842);
  }
  
  public void takeGallery()
  {
    Intent localIntent = new Intent("android.intent.action.PICK");
    localIntent.setType("vnd.android.cursor.dir/image");
    this.mActivity.startActivityForResult(localIntent, 6843);
  }
  
  public static abstract interface ICropCallBack
  {
    public abstract void onResult(String paramString, int paramInt1, int paramInt2, int paramInt3);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.crop.Crop
 * JD-Core Version:    0.7.0.1
 */