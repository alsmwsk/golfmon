package com.appg.crop;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import com.appg.golfmon.util.ProgressDialogUtil;

public class AtvCropImage
  extends Activity
  implements View.OnClickListener
{
  private CropImage ci = null;
  private int mMode = 0;
  private String mPath = null;
  private Dialog mProgress = null;
  private int mType = 0;
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(17432576, 17432577);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131361996)
    {
      if (this.mType == 0)
      {
        this.mProgress = ProgressDialogUtil.show(this, this.mProgress);
        this.ci.getCropUri(new CropImage.ImagePathCallBack()
        {
          public void onResult(String paramAnonymousString)
          {
            ProgressDialogUtil.dismiss(AtvCropImage.this.mProgress);
            Intent localIntent = AtvCropImage.this.getIntent();
            localIntent.putExtra("data", paramAnonymousString);
            AtvCropImage.this.setResult(-1, localIntent);
            System.gc();
            AtvCropImage.this.finish();
          }
        });
      }
      return;
    }
    if (paramView.getId() == 2131361998)
    {
      setResult(0, getIntent());
      System.gc();
      finish();
      return;
    }
    this.ci.rotate();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    overridePendingTransition(17432576, 17432577);
    super.onCreate(paramBundle);
    getWindow().addFlags(128);
    setContentView(2130903070);
    this.ci = ((CropImage)findViewById(2131361999));
    this.mPath = getIntent().getExtras().getString("path");
    this.mType = getIntent().getExtras().getInt("type", 0);
    this.mMode = getIntent().getExtras().getInt("mode", 100);
    if (this.mMode == 200) {
      this.ci.initModeScale();
    }
    for (;;)
    {
      this.ci.setImage(this.mPath);
      findViewById(2131361996).setOnClickListener(this);
      findViewById(2131361998).setOnClickListener(this);
      findViewById(2131361997).setOnClickListener(this);
      return;
      if (this.mMode == 300) {
        this.ci.initModeScale(320, 240);
      } else {
        this.ci.initModeFree();
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.crop.AtvCropImage
 * JD-Core Version:    0.7.0.1
 */