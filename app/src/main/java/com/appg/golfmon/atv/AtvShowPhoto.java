package com.appg.golfmon.atv;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.appg.golfmon.adapter.ZoomImageViewPagerAdapter;
import com.appg.golfmon.adapter.ZoomImageViewPagerAdapter.IReLoadJsonListener;
import com.appg.golfmon.util.FileUtil;
import com.appg.golfmon.util.FormatUtil;
import com.appg.golfmon.util.ImageUtil;
import com.appg.golfmon.util.JSONUtil;
import com.appg.golfmon.util.ListenerUtil;
import com.appg.golfmon.util.LogUtil;
import com.appg.golfmon.view.ZoomGImageView;
import com.appg.golfmon.view.ZoomGImageView.Callback;
import com.appg.golfmon.view.ZoomViewPager;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

public class AtvShowPhoto
  extends AtvBase
{
  public static final int TYPE_ARRAY = 200;
  public static final int TYPE_OBJECT = 100;
  public static final int TYPE_STRING = 300;
  private ZoomImageViewPagerAdapter mAdapter = null;
  private JSONArray mDataList = null;
  private ZoomViewPager mPager = null;
  private int mSelPos = 0;
  private int mType = -1;
  
  protected void configureListener()
  {
    this.mTxtTopTitleLeftBack.setOnClickListener(ListenerUtil.getFinishButtonListener(getContext()));
    this.mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public void onPageSelected(int paramAnonymousInt)
      {
        AtvShowPhoto.this.mTxtTopTitleLeftBack.setText("사진 (" + (1 + AtvShowPhoto.this.mPager.getCurrentItem()) + "/" + AtvShowPhoto.this.mAdapter.getCount() + ")");
      }
    });
  }
  
  protected void findView()
  {
    this.mPager = ((ZoomViewPager)findViewById(2131361894));
  }
  
  protected boolean getBundle()
  {
    LogUtil.intent("AtvShowPhoto", getIntent());
    this.mType = getIntent().getIntExtra("EXTRAS_TYPE", -1);
    this.mSelPos = getIntent().getIntExtra("EXTRAS_POSITION", 0);
    if (this.mType < 0) {}
    for (;;)
    {
      return false;
      if (this.mType == 200) {
        this.mDataList = JSONUtil.createArray(getIntent().getStringExtra("EXTRAS_JSON_STRING"));
      }
      while ((this.mDataList != null) && (this.mDataList.length() > 0))
      {
        return true;
        if (this.mType == 100)
        {
          this.mDataList = new JSONArray();
          JSONObject localJSONObject = JSONUtil.createObject(getIntent().getStringExtra("EXTRAS_JSON_STRING"));
          if ((localJSONObject != null) && (localJSONObject.length() > 0)) {
            this.mDataList.put(localJSONObject);
          }
        }
      }
    }
  }
  
  protected void init()
  {
    this.mTxtTopTitleLeftBack.setText("사진");
    this.mTxtTopTitleLeftBack.setVisibility(0);
    this.mAdapter = new ZoomImageViewPagerAdapter();
    try
    {
      File localFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "/골프몬");
      if (!localFile.isDirectory()) {
        localFile.mkdir();
      }
      label56:
      this.mAdapter.setOnReLoadJsonListener(new ZoomImageViewPagerAdapter.IReLoadJsonListener()
      {
        public void onReLoad(ZoomGImageView paramAnonymousZoomGImageView, JSONObject paramAnonymousJSONObject)
        {
          String str = JSONUtil.getString(paramAnonymousJSONObject, "imagePath", "");
          AtvShowPhoto.this.setImageView(paramAnonymousZoomGImageView, str, "upload_img");
        }
      });
      for (int i = 0;; i++)
      {
        if (i >= this.mDataList.length())
        {
          this.mPager.setAdapter(this.mAdapter);
          this.mPager.setCurrentItem(this.mSelPos, false);
          this.mAdapter.notifyDataSetChanged();
          this.mTxtTopTitleLeftBack.setText("사진 (" + (1 + this.mPager.getCurrentItem()) + "/" + this.mAdapter.getCount() + ")");
          return;
        }
        JSONObject localJSONObject = JSONUtil.getJSONObject(this.mDataList, i);
        String str1 = JSONUtil.getString(localJSONObject, "imagePath", "");
        String str2 = "RSupload_img" + FileUtil.getFileName(str1);
        ZoomGImageView localZoomGImageView = new ZoomGImageView(this);
        this.mAdapter.add(localZoomGImageView, str2, localJSONObject);
      }
    }
    catch (Exception localException)
    {
      break label56;
    }
  }
  
  public void setImageView(final ZoomGImageView paramZoomGImageView, String paramString1, String paramString2)
  {
    String str = "RS" + paramString2 + FileUtil.getFileName(paramString1);
    paramZoomGImageView.setScaleType(ImageView.ScaleType.CENTER);
    if (FormatUtil.isNullorEmpty(paramString1))
    {
      paramZoomGImageView.setAdjustViewBounds(true);
      paramZoomGImageView.setTag(null);
      paramZoomGImageView.setImageResource(2130837692);
      return;
    }
    paramZoomGImageView.setAdjustViewBounds(true);
    paramZoomGImageView.setTag(str);
    paramZoomGImageView.setImageResource(2130837692);
    paramZoomGImageView.setCallback(new ZoomGImageView.Callback()
    {
      public void callback(int paramAnonymousInt, Object paramAnonymousObject, Bitmap paramAnonymousBitmap)
      {
        if (paramZoomGImageView.getTag() != null)
        {
          if ((paramAnonymousInt == 1) && (paramZoomGImageView.getTag().equals(paramAnonymousObject)) && (paramAnonymousBitmap != null))
          {
            LogUtil.i("setImageView tag : " + (String)paramAnonymousObject);
            paramZoomGImageView.setAdjustViewBounds(true);
            paramZoomGImageView.setImageBitmap(paramAnonymousBitmap);
            paramZoomGImageView.setTag((String)paramAnonymousObject);
            return;
          }
          paramZoomGImageView.setAdjustViewBounds(true);
          paramZoomGImageView.setTag(null);
          paramZoomGImageView.setImageResource(2130837692);
          return;
        }
        paramZoomGImageView.setAdjustViewBounds(true);
        paramZoomGImageView.setTag(null);
        paramZoomGImageView.setImageResource(2130837692);
      }
    });
    paramZoomGImageView.setImageURLCache(ImageUtil.wrapImgUrl(paramString1, paramString2), str);
  }
  
  protected void setView()
  {
    setView(2130903064);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.atv.AtvShowPhoto
 * JD-Core Version:    0.7.0.1
 */