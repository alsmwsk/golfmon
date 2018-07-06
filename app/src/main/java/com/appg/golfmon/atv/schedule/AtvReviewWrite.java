package com.appg.golfmon.atv.schedule;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.RatingBar;
import android.widget.TextView;
import com.appg.crop.Crop;
import com.appg.crop.Crop.ICropCallBack;
import com.appg.golfmon.atv.AtvBase;
import com.appg.golfmon.net.http.GFailedHandler;
import com.appg.golfmon.net.http.GJSONDecoder;
import com.appg.golfmon.net.http.GPClient;
import com.appg.golfmon.net.http.GResultHandler;
import com.appg.golfmon.util.Alert;
import com.appg.golfmon.util.Alert.OnCloseListener;
import com.appg.golfmon.util.FileUtil;
import com.appg.golfmon.util.FormatUtil;
import com.appg.golfmon.util.ImageUtil;
import com.appg.golfmon.util.JSONUtil;
import com.appg.golfmon.util.SPUtil;
import com.appg.golfmon.view.GImageView;
import com.appg.golfmon.view.GImageView.Callback;
import org.json.JSONObject;
import ra.genius.net.GBean;
import ra.genius.net.GExecutor;

public class AtvReviewWrite
  extends AtvBase
{
  private ImageButton mBtnDelPhoto1 = null;
  private ImageButton mBtnDelPhoto2 = null;
  private ImageButton mBtnDelPhoto3 = null;
  private Button mBtnSubmit = null;
  private Crop mCrop = null;
  private EditText mEdtContent = null;
  private JSONObject mGolfInfo = null;
  private GImageView mImg1 = null;
  private GImageView mImg2 = null;
  private GImageView mImg3 = null;
  private GImageView mImgTemp = null;
  private RatingBar mRatingBar = null;
  private int mTransferJoinID = 0;
  private TextView mTxtNickName = null;
  
  private void callApi_fileUpload(String paramString, GResultHandler paramGResultHandler)
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("BaseApi.fileUpload");
    localGPClient.addParameter("file[]", ImageUtil.toFile(paramString));
    localGPClient.setDecoder(new GJSONDecoder(3));
    localGPClient.addProgress();
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastShort(AtvReviewWrite.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
      }
    });
    localGPClient.addHandler(paramGResultHandler);
    GExecutor.getInstance().execute(localGPClient);
  }
  
  private void callApi_insOfComment()
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("ApiTransferJoin.insOfComment");
    String str = JSONUtil.getString(this.mGolfInfo, "golf_fk", "");
    if (FormatUtil.isNullorEmpty(str)) {
      str = JSONUtil.getString(this.mGolfInfo, "no", "");
    }
    localGPClient.addParameter("golf_no", str);
    localGPClient.addParameter("content", this.mEdtContent.getText().toString());
    localGPClient.addParameter("grade", Float.valueOf(this.mRatingBar.getRating()));
    if (this.mTransferJoinID > 0) {
      localGPClient.addParameter("transferJoinID", Integer.valueOf(this.mTransferJoinID));
    }
    if (!FormatUtil.isNullorEmpty((String)this.mImg1.getTag())) {
      localGPClient.addParameter("imgUrl[]", (String)this.mImg1.getTag());
    }
    if (!FormatUtil.isNullorEmpty((String)this.mImg2.getTag())) {
      localGPClient.addParameter("imgUrl[]", (String)this.mImg2.getTag());
    }
    if (!FormatUtil.isNullorEmpty((String)this.mImg3.getTag())) {
      localGPClient.addParameter("imgUrl[]", (String)this.mImg3.getTag());
    }
    localGPClient.setDecoder(new GJSONDecoder(3));
    localGPClient.addProgress();
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvReviewWrite.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, final int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        Alert localAlert = new Alert();
        localAlert.setOnCloseListener(new Alert.OnCloseListener()
        {
          public void onClose(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int, Object paramAnonymous2Object)
          {
            if (paramAnonymousInt > 0)
            {
              AtvReviewWrite.this.setResult(-1);
              AtvReviewWrite.this.finish();
            }
          }
        });
        localAlert.showAlert(AtvReviewWrite.this.getContext(), paramAnonymousString);
        return null;
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  private void setImageView(final GImageView paramGImageView, final String paramString1, String paramString2, final int paramInt)
  {
    final String str = "RS" + paramString2 + FileUtil.getFileName(paramString1);
    if (FormatUtil.isNullorEmpty(paramString1))
    {
      paramGImageView.setScaleType(ImageView.ScaleType.CENTER);
      paramGImageView.setImageResource(paramInt);
      paramGImageView.setTag(null);
    }
    while (paramString1.equals(paramGImageView.getTag())) {
      return;
    }
    paramGImageView.setScaleType(ImageView.ScaleType.CENTER);
    paramGImageView.setImageResource(paramInt);
    paramGImageView.setTag(paramString1);
    paramGImageView.setCallback(new GImageView.Callback()
    {
      public void callback(int paramAnonymousInt, Object paramAnonymousObject, Bitmap paramAnonymousBitmap)
      {
        if (!FormatUtil.isNullorEmpty((String)paramGImageView.getTag()))
        {
          if ((paramAnonymousInt == 1) && (str.equals((String)paramAnonymousObject)) && (paramAnonymousBitmap != null))
          {
            paramGImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            paramGImageView.setImageBitmap(paramAnonymousBitmap);
            paramGImageView.setTag(paramString1);
            return;
          }
          paramGImageView.setScaleType(ImageView.ScaleType.CENTER);
          paramGImageView.setImageResource(paramInt);
          paramGImageView.setTag(null);
          return;
        }
        paramGImageView.setScaleType(ImageView.ScaleType.CENTER);
        paramGImageView.setImageResource(paramInt);
        paramGImageView.setTag(null);
      }
    });
    paramGImageView.setImageURLCache("http://115.68.14.78/" + paramString2 + "/" + paramString1, str);
  }
  
  protected void configureListener()
  {
    View.OnClickListener local1 = new View.OnClickListener()
    {
      public void onClick(final View paramAnonymousView)
      {
        Alert localAlert = new Alert();
        localAlert.setOnCloseListener(new Alert.OnCloseListener()
        {
          public void onClose(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int, Object paramAnonymous2Object)
          {
            switch (paramAnonymous2Int)
            {
            }
            for (;;)
            {
              paramAnonymous2DialogInterface.dismiss();
              return;
              AtvReviewWrite.this.mImgTemp = ((GImageView)paramAnonymousView);
              AtvReviewWrite.this.mCrop.takeCamera();
              continue;
              AtvReviewWrite.this.mImgTemp = ((GImageView)paramAnonymousView);
              AtvReviewWrite.this.mCrop.takeGallery();
            }
          }
        });
        localAlert.showSeletPhoto(paramAnonymousView.getContext(), false);
      }
    };
    this.mImg1.setOnClickListener(local1);
    this.mImg2.setOnClickListener(local1);
    this.mImg3.setOnClickListener(local1);
    View.OnClickListener local2 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (paramAnonymousView == AtvReviewWrite.this.mBtnDelPhoto1)
        {
          AtvReviewWrite.this.setImageView(AtvReviewWrite.this.mImg1, "", "480", 2130837754);
          AtvReviewWrite.this.mBtnDelPhoto1.setVisibility(8);
        }
        do
        {
          return;
          if (paramAnonymousView == AtvReviewWrite.this.mBtnDelPhoto2)
          {
            AtvReviewWrite.this.setImageView(AtvReviewWrite.this.mImg2, "", "480", 2130837754);
            AtvReviewWrite.this.mBtnDelPhoto2.setVisibility(8);
            return;
          }
        } while (paramAnonymousView != AtvReviewWrite.this.mBtnDelPhoto3);
        AtvReviewWrite.this.setImageView(AtvReviewWrite.this.mImg3, "", "480", 2130837754);
        AtvReviewWrite.this.mBtnDelPhoto3.setVisibility(8);
      }
    };
    this.mBtnDelPhoto1.setOnClickListener(local2);
    this.mBtnDelPhoto2.setOnClickListener(local2);
    this.mBtnDelPhoto3.setOnClickListener(local2);
    this.mBtnSubmit.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (FormatUtil.isNullorEmpty(AtvReviewWrite.this.mEdtContent.getText().toString()))
        {
          new Alert().showAlert(AtvReviewWrite.this.getContext(), "내용을 입력해 주세요.");
          return;
        }
        if (AtvReviewWrite.this.mRatingBar.getRating() == 0.0F)
        {
          new Alert().showAlert(AtvReviewWrite.this.getContext(), "별점을 선택해 주세요.");
          return;
        }
        AtvReviewWrite.this.callApi_insOfComment();
      }
    });
  }
  
  protected void findView()
  {
    this.mRatingBar = ((RatingBar)findViewById(2131361838));
    this.mTxtNickName = ((TextView)findViewById(2131361945));
    this.mEdtContent = ((EditText)findViewById(2131361967));
    this.mImg1 = ((GImageView)findViewById(2131361878));
    this.mBtnDelPhoto1 = ((ImageButton)findViewById(2131361968));
    this.mImg2 = ((GImageView)findViewById(2131361879));
    this.mBtnDelPhoto2 = ((ImageButton)findViewById(2131361969));
    this.mImg3 = ((GImageView)findViewById(2131361880));
    this.mBtnDelPhoto3 = ((ImageButton)findViewById(2131361970));
    this.mBtnSubmit = ((Button)findViewById(2131361964));
  }
  
  protected boolean getBundle()
  {
    this.mGolfInfo = JSONUtil.createObject(getIntent(), "EXTRAS_JSON_STRING");
    this.mTransferJoinID = getIntent().getIntExtra("EXTRAS_ID", 0);
    return !FormatUtil.isNullorEmpty(this.mGolfInfo);
  }
  
  protected void init()
  {
    this.mTxtTopTitleLeft2_1.setVisibility(0);
    this.mTxtTopTitleLeft2_2.setVisibility(0);
    this.mTxtTopTitleLeft2_1.setText(JSONUtil.getString(this.mGolfInfo, "name", ""));
    this.mTxtTopTitleLeft2_2.setText(JSONUtil.getString(this.mGolfInfo, "address", ""));
    this.mTxtNickName.setText(JSONUtil.getString(SPUtil.getInstance().getUserInfo(getContext()), "nick_name", ""));
    this.mCrop = new Crop(getContext(), 100);
    this.mBtnDelPhoto1.setVisibility(4);
    this.mBtnDelPhoto2.setVisibility(4);
    this.mBtnDelPhoto3.setVisibility(4);
    this.mRatingBar.setRating(4.0F);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1111)
    {
      finish();
      return;
    }
    this.mCrop.onActivityResult(paramInt1, paramInt2, paramIntent, new Crop.ICropCallBack()
    {
      public void onResult(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AtvReviewWrite.this.callApi_fileUpload(paramAnonymousString, new GResultHandler()
        {
          public GBean result(GBean paramAnonymous2GBean, Object paramAnonymous2Object, int paramAnonymous2Int, String paramAnonymous2String, JSONObject paramAnonymous2JSONObject)
          {
            if (paramAnonymous2Int > 0)
            {
              if (AtvReviewWrite.this.mImgTemp == AtvReviewWrite.this.mImg1)
              {
                AtvReviewWrite.this.setImageView(AtvReviewWrite.this.mImg1, (String)paramAnonymous2Object, "480", 2130837754);
                AtvReviewWrite.this.mBtnDelPhoto1.setVisibility(0);
              }
              for (;;)
              {
                AtvReviewWrite.this.mImgTemp = null;
                return null;
                if (AtvReviewWrite.this.mImgTemp == AtvReviewWrite.this.mImg2)
                {
                  AtvReviewWrite.this.setImageView(AtvReviewWrite.this.mImg2, (String)paramAnonymous2Object, "480", 2130837754);
                  AtvReviewWrite.this.mBtnDelPhoto2.setVisibility(0);
                }
                else if (AtvReviewWrite.this.mImgTemp == AtvReviewWrite.this.mImg3)
                {
                  AtvReviewWrite.this.setImageView(AtvReviewWrite.this.mImg3, (String)paramAnonymous2Object, "480", 2130837754);
                  AtvReviewWrite.this.mBtnDelPhoto3.setVisibility(0);
                }
              }
            }
            Alert.toastShort(AtvReviewWrite.this.getContext(), paramAnonymous2String);
            return null;
          }
        });
      }
    });
  }
  
  protected void setView()
  {
    setView(2130903063);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.atv.schedule.AtvReviewWrite
 * JD-Core Version:    0.7.0.1
 */