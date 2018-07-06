package com.appg.golfmon.atv.event;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.appg.golfmon.atv.AtvBase;
import com.appg.golfmon.atv.AtvShowPhoto;
import com.appg.golfmon.net.http.GFailedHandler;
import com.appg.golfmon.net.http.GJSONDecoder;
import com.appg.golfmon.net.http.GPClient;
import com.appg.golfmon.net.http.GResultHandler;
import com.appg.golfmon.util.Alert;
import com.appg.golfmon.util.FileUtil;
import com.appg.golfmon.util.FormatUtil;
import com.appg.golfmon.util.ImageDownLoader;
import com.appg.golfmon.util.ImageDownLoader.Mode;
import com.appg.golfmon.util.ImageUtil;
import com.appg.golfmon.util.JSONUtil;
import com.appg.golfmon.util.ListenerUtil;
import com.appg.golfmon.util.LogUtil;
import com.appg.golfmon.util.SPUtil;
import com.appg.golfmon.view.GImageView;
import com.appg.golfmon.view.GImageView.Callback;
import com.kakao.KakaoLink;
import com.kakao.KakaoParameterException;
import com.kakao.KakaoTalkLinkMessageBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import ra.genius.net.GBean;
import ra.genius.net.GExecutor;

public class AtvEventDetail
  extends AtvBase
{
  private String LOGO_IMG_URL = "http://115.68.14.78/upload_img/";
  ImageView ivThum = null;
  private KakaoLink kakaoLink1;
  private KakaoTalkLinkMessageBuilder kakaoTalkLinkMessageBuilder1;
  private LinearLayout llUtil = null;
  private Button mBtnCall = null;
  private Button mBtnCopy = null;
  private Button mBtnKakao = null;
  private Button mBtnSMS = null;
  private JSONObject mEventInfo = null;
  private String mEventNo = null;
  private ImageDownLoader mImageDownLoader;
  private GImageView mImg1 = null;
  private GImageView mImg2 = null;
  private GImageView mImg3 = null;
  private TextView mTxtContent = null;
  private TextView mTxtTitle = null;
  TextView txtAdd = null;
  TextView txtDate = null;
  TextView txtInfo = null;
  TextView txtName = null;
  TextView txtPayWeekDay = null;
  TextView txtPayWeekEnd = null;
  
  private void callApi_getInfoOfEvent()
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("Api.getInfoOfEvent");
    localGPClient.addParameter("no", JSONUtil.getString(this.mEventInfo, "no", ""));
    localGPClient.setDecoder(new GJSONDecoder(1));
    localGPClient.addProgress();
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvEventDetail.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        AtvEventDetail.this.setResult(-1);
        if (paramAnonymousInt > 0)
        {
          AtvEventDetail.this.mEventInfo = ((JSONObject)paramAnonymousObject);
          AtvEventDetail.this.setData();
        }
        for (;;)
        {
          return null;
          Alert.toastLong(AtvEventDetail.this.getContext(), paramAnonymousString);
          AtvEventDetail.this.finish();
        }
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  private String getSharedMessage()
  {
    return "할인부킹ᆞ조인라운드 골프몬 앱을 추천합니다.\nhttp://gil.cc/84Z3".replaceAll("<999>", JSONUtil.getString(SPUtil.getInstance().getUserInfo(this), "nick_name", ""));
  }
  
  private void setData()
  {
    String str1 = JSONUtil.getString(this.mEventInfo, "golf_name", "");
    String str2 = JSONUtil.getString(this.mEventInfo, "title", "");
    this.mTxtTitle.setText(str2);
    this.mTxtContent.setText(JSONUtil.getString(this.mEventInfo, "content", ""));
    String str3 = JSONUtil.getString(this.mEventInfo, "edate", "");
    JSONUtil.getString(this.mEventInfo, "sdate", "");
    this.txtName.setText(str1);
    this.txtAdd.setText(JSONUtil.getString(this.mEventInfo, "address", ""));
    String str4;
    String str5;
    String str6;
    label148:
    String str8;
    if (JSONUtil.getString(this.mEventInfo, "golf_type", "").equals("1"))
    {
      str4 = "회원제";
      str5 = JSONUtil.getString(this.mEventInfo, "scale", "");
      if (!FormatUtil.isNullorEmpty(str5)) {
        break label631;
      }
      str6 = "";
      this.txtInfo.setText(str4 + " " + str6);
      this.txtDate.setText("기간 :  ~ " + FormatUtil.getDateConvert(str3, "yyyy-MM-dd", "M/d") + " 까지");
      if (getWindowManager().getDefaultDisplay().getWidth() <= 480)
      {
        this.txtPayWeekDay.setTextSize(12.0F);
        this.txtPayWeekEnd.setTextSize(12.0F);
      }
      this.txtPayWeekDay.setText(FormatUtil.toPriceFormat(JSONUtil.getInteger(this.mEventInfo, "pay_day", 0)));
      this.txtPayWeekEnd.setText(FormatUtil.toPriceFormat(JSONUtil.getInteger(this.mEventInfo, "pay_end", 0)));
      this.ivThum = ((ImageView)findViewById(2131361868));
      String str7 = JSONUtil.getString(this.mEventInfo, "golf_logo", "");
      if (!FormatUtil.isNullorEmpty(str7)) {
        this.mImageDownLoader.download(this.ivThum, this.LOGO_IMG_URL + str7);
      }
      str8 = JSONUtil.getString(this.mEventInfo, "img1", "");
      String str9 = JSONUtil.getString(this.mEventInfo, "img2", "");
      String str10 = JSONUtil.getString(this.mEventInfo, "img3", "");
      setImageView(this.mImg1, str8, "upload_img");
      setImageView(this.mImg2, str9, "upload_img");
      setImageView(this.mImg3, str10, "upload_img");
      if (!JSONUtil.getString(this.mEventInfo, "phone_num", "").startsWith("010")) {
        break label657;
      }
      this.mBtnSMS.setVisibility(0);
    }
    for (;;)
    {
      try
      {
        String str11 = JSONUtil.getString(this.mEventInfo, "golf_name", "") + "\n" + JSONUtil.getString(this.mEventInfo, "title", "") + "\n" + JSONUtil.getString(this.mEventInfo, "content", "") + "\n\n";
        this.kakaoTalkLinkMessageBuilder1.addText(str11);
        if (!FormatUtil.isNullorEmpty(str8)) {
          this.kakaoTalkLinkMessageBuilder1.addImage(this.LOGO_IMG_URL + str8, 320, 320);
        }
        this.kakaoTalkLinkMessageBuilder1.addAppLink("할인부킹ᆞ조인라운드 골프몬 앱을 추천합니다.");
      }
      catch (KakaoParameterException localKakaoParameterException)
      {
        label631:
        localKakaoParameterException.printStackTrace();
        label657:
        continue;
      }
      this.llUtil.setVisibility(0);
      return;
      str4 = "퍼블릭";
      break;
      str6 = str5 + "홀";
      break label148;
      this.mBtnSMS.setVisibility(8);
    }
  }
  
  protected void configureListener()
  {
    this.mTxtTopTitleLeftBack.setOnClickListener(ListenerUtil.getFinishButtonListener(getContext()));
    this.mBtnCall.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        try
        {
          AtvEventDetail.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("tel:" + JSONUtil.getString(AtvEventDetail.this.mEventInfo, "phone_num", ""))));
          return;
        }
        catch (Exception localException) {}
      }
    });
    this.mBtnSMS.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + JSONUtil.getString(AtvEventDetail.this.mEventInfo, "phone_num", "")));
        localIntent.putExtra("sms_body", JSONUtil.getString(AtvEventDetail.this.mEventInfo, "golf_name", "") + JSONUtil.getString(AtvEventDetail.this.mEventInfo, "title", "") + "\n");
        AtvEventDetail.this.startActivity(localIntent);
      }
    });
    this.mBtnKakao.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvEventDetail.this.sendKakaoTalk();
      }
    });
    this.mBtnCopy.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ((ClipboardManager)AtvEventDetail.this.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("골프몬 할인부킹", JSONUtil.getString(AtvEventDetail.this.mEventInfo, "golf_name", "") + "\n" + JSONUtil.getString(AtvEventDetail.this.mEventInfo, "title", "") + "\n" + JSONUtil.getString(AtvEventDetail.this.mEventInfo, "content", "") + "\n\n" + AtvEventDetail.this.getSharedMessage()));
        Alert.toastLong(AtvEventDetail.this.getContext(), "복사되었습니다.");
      }
    });
  }
  
  protected void findView()
  {
    this.mTxtTitle = ((TextView)findViewById(2131361872));
    this.mBtnCall = ((Button)findViewById(2131361828));
    this.mBtnSMS = ((Button)findViewById(2131361876));
    this.llUtil = ((LinearLayout)findViewById(2131361881));
    this.mBtnKakao = ((Button)findViewById(2131361882));
    this.mBtnCopy = ((Button)findViewById(2131361883));
    this.mTxtContent = ((TextView)findViewById(2131361877));
    this.mImg1 = ((GImageView)findViewById(2131361878));
    this.mImg2 = ((GImageView)findViewById(2131361879));
    this.mImg3 = ((GImageView)findViewById(2131361880));
    this.txtName = ((TextView)findViewById(2131361869));
    this.txtDate = ((TextView)findViewById(2131361873));
    this.txtAdd = ((TextView)findViewById(2131361870));
    this.txtInfo = ((TextView)findViewById(2131361871));
    this.txtPayWeekDay = ((TextView)findViewById(2131361874));
    this.txtPayWeekEnd = ((TextView)findViewById(2131361875));
    this.ivThum = ((ImageView)findViewById(2131361868));
  }
  
  protected boolean getBundle()
  {
    LogUtil.intent("AtvEventDetail", getIntent());
    this.mEventInfo = JSONUtil.createObject(getIntent(), "EXTRAS_JSON_STRING");
    this.mEventNo = JSONUtil.getString(this.mEventInfo, "no", "");
    return !FormatUtil.isNullorEmpty(this.mEventNo);
  }
  
  protected void init()
  {
    this.mTxtTopTitleLeftBack.setVisibility(0);
    this.mTxtTopTitleLeftBack.setText("할인부킹");
    this.mTxtTopTitleLeftBack.setTextColor(-2023132);
    this.mImageDownLoader = new ImageDownLoader(this);
    this.mImageDownLoader.setMode(ImageDownLoader.Mode.CORRECT);
    callApi_getInfoOfEvent();
  }
  
  void sendKakaoTalk()
  {
    try
    {
      this.kakaoLink1.sendMessage(this.kakaoTalkLinkMessageBuilder1.build(), this);
      return;
    }
    catch (KakaoParameterException localKakaoParameterException)
    {
      localKakaoParameterException.printStackTrace();
    }
  }
  
  public void setImageView(final GImageView paramGImageView, String paramString1, String paramString2)
  {
    final String str = "RS" + paramString2 + FileUtil.getFileName(paramString1);
    paramGImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    if (FormatUtil.isNullorEmpty(paramString1))
    {
      paramGImageView.setTag(null);
      paramGImageView.setVisibility(8);
    }
    for (;;)
    {
      paramGImageView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          JSONArray localJSONArray = new JSONArray();
          for (int i = 1;; i++)
          {
            if (i > 3)
            {
              if (localJSONArray.length() > 0)
              {
                Intent localIntent = new Intent(AtvEventDetail.this.getContext(), AtvShowPhoto.class);
                localIntent.putExtra("EXTRAS_TYPE", 200);
                localIntent.putExtra("EXTRAS_JSON_STRING", localJSONArray.toString());
                localIntent.putExtra("EXTRAS_POSITION", 0);
                AtvEventDetail.this.startActivity(localIntent);
              }
              return;
            }
            String str = JSONUtil.getString(AtvEventDetail.this.mEventInfo, "img" + i, "");
            if (!FormatUtil.isNullorEmpty(str))
            {
              JSONObject localJSONObject = new JSONObject();
              JSONUtil.put(localJSONObject, "imagePath", str);
              localJSONArray.put(localJSONObject);
            }
          }
        }
      });
      return;
      if (!str.equals(paramGImageView.getTag()))
      {
        paramGImageView.setTag(str);
        paramGImageView.setVisibility(8);
        paramGImageView.setCallback(new GImageView.Callback()
        {
          public void callback(int paramAnonymousInt, Object paramAnonymousObject, Bitmap paramAnonymousBitmap)
          {
            if ((!FormatUtil.isNullorEmpty((String)paramGImageView.getTag())) && (paramAnonymousInt == 1) && (str.equals((String)paramAnonymousObject)) && (paramAnonymousBitmap != null))
            {
              paramGImageView.setImageBitmap(paramAnonymousBitmap);
              paramGImageView.setVisibility(0);
              paramGImageView.setTag(paramAnonymousObject);
              paramGImageView.getLayoutParams().height = ((int)(paramAnonymousBitmap.getHeight() / paramAnonymousBitmap.getWidth() * (AtvEventDetail.this.mDeviceSize[0] - ImageUtil.dipToPixel(AtvEventDetail.this.getContext(), 30.0F))));
              return;
            }
            paramGImageView.setVisibility(8);
            paramGImageView.setTag(null);
          }
        });
        paramGImageView.setImageURLCache("http://115.68.14.78/" + paramString2 + "/" + paramString1, str);
      }
    }
  }
  
  protected void setView()
  {
    setView(2130903048);
    try
    {
      this.kakaoLink1 = KakaoLink.getKakaoLink(getApplicationContext());
      this.kakaoTalkLinkMessageBuilder1 = this.kakaoLink1.createKakaoTalkLinkMessageBuilder();
      return;
    }
    catch (KakaoParameterException localKakaoParameterException)
    {
      localKakaoParameterException.printStackTrace();
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.atv.event.AtvEventDetail
 * JD-Core Version:    0.7.0.1
 */