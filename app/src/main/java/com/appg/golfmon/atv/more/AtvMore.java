package com.appg.golfmon.atv.more;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.appg.golfmon.atv.AtvBase;
import com.appg.golfmon.atv.AtvMain;
import com.appg.golfmon.atv.event.AtvEvent;
import com.appg.golfmon.atv.schedule.AtvListAll;
import com.appg.golfmon.common.InterfaceSet.TabClickListener;
import com.appg.golfmon.net.http.GFailedHandler;
import com.appg.golfmon.net.http.GJSONDecoder;
import com.appg.golfmon.net.http.GPClient;
import com.appg.golfmon.net.http.GResultHandler;
import com.appg.golfmon.util.Alert;
import com.appg.golfmon.util.Alert.OnCloseListener;
import com.appg.golfmon.util.JSONUtil;
import com.appg.golfmon.util.ListenerUtil;
import com.appg.golfmon.util.SPUtil;
import com.appg.golfmon.view.TabMain;
import com.kakao.KakaoLink;
import com.kakao.KakaoParameterException;
import com.kakao.KakaoTalkLinkMessageBuilder;
import org.json.JSONObject;
import ra.genius.net.GBean;
import ra.genius.net.GExecutor;

public class AtvMore
  extends AtvBase
{
  private KakaoLink kakaoLink;
  private KakaoTalkLinkMessageBuilder kakaoTalkLinkMessageBuilder;
  private RelativeLayout mBase_01 = null;
  private RelativeLayout mBase_02 = null;
  private RelativeLayout mBase_03 = null;
  private RelativeLayout mBase_04 = null;
  private RelativeLayout mBase_05 = null;
  private RelativeLayout mBase_06 = null;
  private RelativeLayout mBase_07 = null;
  private Button mBtnCall = null;
  private ImageButton mBtnFacebook = null;
  private ImageButton mBtnKakao = null;
  private ImageButton mBtnSms = null;
  private ImageButton mBtnTwitter = null;
  private String mCallCenter = "";
  private TabMain mTabMain = null;
  
  private void call()
  {
    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("tel:" + this.mCallCenter.replaceAll("-", ""))));
  }
  
  private void callApi_reqBookingManager(boolean paramBoolean)
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("ApiTransferJoin.reqBookingManager");
    if (paramBoolean) {
      localGPClient.addParameter("retry", Integer.valueOf(1));
    }
    for (;;)
    {
      localGPClient.setDecoder(new GJSONDecoder(3));
      localGPClient.addProgress();
      localGPClient.addHandler(new GFailedHandler()
      {
        public void failedExecute(GBean paramAnonymousGBean)
        {
          Alert.toastLong(AtvMore.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
        }
      });
      localGPClient.addHandler(new GResultHandler()
      {
        public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          Alert localAlert = new Alert();
          if ((paramAnonymousInt > 0) || (paramAnonymousInt == -10))
          {
            if (paramAnonymousInt > 0)
            {
              JSONObject localJSONObject = SPUtil.getInstance().getUserInfo(AtvMore.this.getContext());
              JSONUtil.put(localJSONObject, "statusTypeID", "1");
              SPUtil.getInstance().setUserInfo(AtvMore.this.getContext(), localJSONObject);
            }
            localAlert.setOnCloseListener(new Alert.OnCloseListener()
            {
              public void onClose(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int, Object paramAnonymous2Object)
              {
                if (1 == paramAnonymous2Int) {
                  AtvMore.this.call();
                }
              }
            });
            localAlert.showAlert(AtvMore.this.getContext(), paramAnonymousString, true, new String[] { "고객센터 연결", "닫기" });
          }
          for (;;)
          {
            return null;
            if (paramAnonymousInt == -20)
            {
              localAlert.setOnCloseListener(new Alert.OnCloseListener()
              {
                public void onClose(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int, Object paramAnonymous2Object)
                {
                  if (1 == paramAnonymous2Int) {
                    AtvMore.this.callApi_reqBookingManager(true);
                  }
                }
              });
              localAlert.showAlert(AtvMore.this.getContext(), paramAnonymousString, true, new String[] { "연장신청하기", "닫기" });
            }
            else
            {
              localAlert.showAlert(AtvMore.this.getContext(), paramAnonymousString);
            }
          }
        }
      });
      GExecutor.getInstance().execute(localGPClient);
      return;
      localGPClient.addParameter("retry", Integer.valueOf(0));
    }
  }
  
  private String getSharedMessage()
  {
    return "할인부킹ᆞ조인라운드 골프몬 앱을 추천합니다.\nhttp://gil.cc/84Z3".replaceAll("<999>", JSONUtil.getString(SPUtil.getInstance().getUserInfo(this), "nick_name", ""));
  }
  
  protected void configureListener()
  {
    this.mTabMain.setOnTabListener(new InterfaceSet.TabClickListener()
    {
      public void onClick(View paramAnonymousView, int paramAnonymousInt)
      {
        Intent localIntent = new Intent();
        switch (paramAnonymousInt)
        {
        default: 
          return;
        case 0: 
          localIntent.setClass(AtvMore.this.getContext(), AtvMain.class);
          localIntent.setFlags(603979776);
          AtvMore.this.startActivity(localIntent);
          AtvMore.this.finish();
          return;
        case 1: 
          localIntent.setClass(AtvMore.this.getContext(), AtvListAll.class);
          localIntent.setFlags(603979776);
          localIntent.putExtra("EXTRAS_TYPE", 100);
          AtvMore.this.startActivity(localIntent);
          AtvMore.this.finish();
          return;
        case 2: 
          localIntent.setClass(AtvMore.this.getContext(), AtvListAll.class);
          localIntent.setFlags(603979776);
          localIntent.putExtra("EXTRAS_TYPE", 200);
          AtvMore.this.startActivity(localIntent);
          AtvMore.this.finish();
          return;
        }
        localIntent.setClass(AtvMore.this.getContext(), AtvEvent.class);
        localIntent.setFlags(603979776);
        AtvMore.this.startActivity(localIntent);
        AtvMore.this.finish();
      }
    });
    this.mBase_01.setOnClickListener(ListenerUtil.getMoveButtonListener(getContext(), AtvNotice.class, false));
    this.mBase_02.setOnClickListener(ListenerUtil.getMoveButtonListener(getContext(), AtvFAQ.class, false));
    this.mBase_04.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (!AtvMore.this.checkLogin(true)) {
          return;
        }
        AtvMore.this.startActivity(new Intent(AtvMore.this.getContext(), AtvSuggest.class));
      }
    });
    this.mBase_05.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (!AtvMore.this.checkLogin(true)) {
          return;
        }
        AtvMore.this.startActivity(new Intent(AtvMore.this.getContext(), AtvMyPage.class));
      }
    });
    this.mBase_06.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (!AtvMore.this.checkLogin(true)) {
          return;
        }
        AtvMore.this.startActivity(new Intent(AtvMore.this.getContext(), AtvMyRegist.class));
      }
    });
    this.mBase_07.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (!AtvMore.this.checkLogin(true)) {
          return;
        }
        AtvMore.this.startActivity(new Intent(AtvMore.this.getContext(), AtvMyJoin.class));
      }
    });
    this.mBase_03.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (!AtvMore.this.checkLogin(true)) {
          return;
        }
        if (JSONUtil.getInteger(SPUtil.getInstance().getUserInfo(AtvMore.this.getContext()), "statusTypeID", 0) == 0)
        {
          Alert localAlert = new Alert();
          localAlert.setOnCloseListener(new Alert.OnCloseListener()
          {
            public void onClose(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int, Object paramAnonymous2Object)
            {
              if (1 == paramAnonymous2Int) {
                AtvMore.this.callApi_reqBookingManager(false);
              }
            }
          });
          localAlert.showAlert(AtvMore.this.getContext(), "부킹메니로 등록하시면 등급에 따라 1일 등록가능횟수가 늘어납니다.\n자세한 문의는 고객센터(" + AtvMore.this.mCallCenter + ")로 문의하시기 바랍니다.", true, new String[] { "부킹매니저 가입신청" });
          return;
        }
        AtvMore.this.callApi_reqBookingManager(false);
      }
    });
    this.mBtnCall.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvMore.this.call();
      }
    });
    this.mBtnFacebook.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvMore.this.sendFacebook();
      }
    });
    this.mBtnKakao.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        try
        {
          AtvMore.this.sendKakaoTalk();
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    });
    this.mBtnSms.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvMore.this.sendSms();
      }
    });
    this.mBtnTwitter.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvMore.this.sendTwitter();
      }
    });
  }
  
  protected void findView()
  {
    this.mBase_01 = ((RelativeLayout)findViewById(2131361919));
    this.mBase_02 = ((RelativeLayout)findViewById(2131361920));
    this.mBase_03 = ((RelativeLayout)findViewById(2131361921));
    this.mBase_04 = ((RelativeLayout)findViewById(2131361922));
    this.mBase_05 = ((RelativeLayout)findViewById(2131361923));
    this.mBase_06 = ((RelativeLayout)findViewById(2131361924));
    this.mBase_07 = ((RelativeLayout)findViewById(2131361925));
    this.mBtnCall = ((Button)findViewById(2131361828));
    this.mBtnFacebook = ((ImageButton)findViewById(2131361926));
    this.mBtnKakao = ((ImageButton)findViewById(2131361882));
    this.mBtnTwitter = ((ImageButton)findViewById(2131361927));
    this.mBtnSms = ((ImageButton)findViewById(2131361928));
    this.mTabMain = ((TabMain)findViewById(2131361867));
  }
  
  protected void init()
  {
    this.mTxtTopTitleLeft.setVisibility(0);
    this.mTxtTopTitleLeft.setText("더보기");
    this.mTabMain.setTabOn(4);
    this.mCallCenter = SPUtil.getInstance().readString(getContext(), "spu.sys", "CALL_CENTER", "070-7013-4400");
    this.mBtnCall.setText(this.mCallCenter);
  }
  
  public void onBackPressed()
  {
    Intent localIntent = new Intent(getContext(), AtvMain.class);
    localIntent.setFlags(603979776);
    startActivity(localIntent);
    super.onBackPressed();
  }
  
  public void sendFacebook()
  {
    startActivity(new Intent("android.intent.action.VIEW", Uri.parse(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf("http://www.facebook.com/dialog/feed?")).append("app_id=607776569292718").toString())).append("&link=").append(Uri.encode("http://www.facebook.com/")).toString())).append("&name=골프몬").toString())).append("&caption=").append(Uri.encode(new StringBuilder("[골프몬]").append(getSharedMessage()).append(SPUtil.getInstance().readString(this, "spu.sys", "INSTALL_URL", "")).toString())).toString() + "&redirect_uri=http://www.facebook.com")));
  }
  
  void sendKakaoTalk()
  {
    try
    {
      this.kakaoLink.sendMessage(this.kakaoTalkLinkMessageBuilder.build(), this);
      return;
    }
    catch (KakaoParameterException localKakaoParameterException)
    {
      localKakaoParameterException.printStackTrace();
    }
  }
  
  public void sendSms()
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.putExtra("sms_body", getSharedMessage());
    localIntent.setType("vnd.android-dir/mms-sms");
    startActivity(localIntent);
  }
  
  public void sendTwitter()
  {
    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://twitter.com/intent/tweet?text=" + Uri.encode(new StringBuilder("[골프몬]").append(getSharedMessage()).append(SPUtil.getInstance().readString(this, "spu.sys", "INSTALL_URL", "")).toString()) + "&url=")));
  }
  
  protected void setView()
  {
    setView(2130903058);
    try
    {
      this.kakaoLink = KakaoLink.getKakaoLink(getApplicationContext());
      this.kakaoTalkLinkMessageBuilder = this.kakaoLink.createKakaoTalkLinkMessageBuilder();
      this.kakaoTalkLinkMessageBuilder.addText("할인부킹ᆞ조인라운드 골프몬 앱을 추천합니다.");
      this.kakaoTalkLinkMessageBuilder.addAppLink("앱으로 이동");
      return;
    }
    catch (KakaoParameterException localKakaoParameterException)
    {
      localKakaoParameterException.printStackTrace();
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.atv.more.AtvMore
 * JD-Core Version:    0.7.0.1
 */