package com.appg.golfmon.atv.more;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.appg.golfmon.atv.AtvBase;
import com.appg.golfmon.net.http.GFailedHandler;
import com.appg.golfmon.net.http.GJSONDecoder;
import com.appg.golfmon.net.http.GPClient;
import com.appg.golfmon.net.http.GResultHandler;
import com.appg.golfmon.util.Alert;
import com.appg.golfmon.util.Alert.OnCloseListener;
import com.appg.golfmon.util.ListenerUtil;
import com.appg.golfmon.util.SPUtil;
import com.nhn.android.naverlogin.OAuthLogin;
import com.nhn.android.naverlogin.OAuthLoginHandler;
import com.nhn.android.naverlogin.data.OAuthErrorCode;
import com.nhn.android.naverlogin.data.OAuthLoginState;
import com.nhn.android.naverlogin.ui.view.OAuthLoginButton;
import org.json.JSONObject;
import ra.genius.net.GBean;
import ra.genius.net.GExecutor;

public class AtvMyPage
  extends AtvBase
{
  private static String OAUTH_CALLBACK_INTENT;
  private static String OAUTH_CLIENT_ID = "m04IqvifnsvIdzuexVQM";
  private static String OAUTH_CLIENT_NAME;
  private static String OAUTH_CLIENT_SECRET = "lJLxRTLmWs";
  private static Context mContext;
  private static OAuthLoginHandler mOAuthLoginHandler = new OAuthLoginHandler()
  {
    public void run(boolean paramAnonymousBoolean)
    {
      if (paramAnonymousBoolean)
      {
        AtvMyPage.mOAuthLoginInstance.getAccessToken(AtvMyPage.mContext);
        AtvMyPage.mOAuthLoginInstance.getRefreshToken(AtvMyPage.mContext);
        AtvMyPage.mOAuthLoginInstance.getExpiresAt(AtvMyPage.mContext);
        AtvMyPage.mOAuthLoginInstance.getTokenType(AtvMyPage.mContext);
        AtvMyPage.rlNaverLogout.setVisibility(0);
        AtvMyPage.rlOAuthLoginImg.setVisibility(8);
        return;
      }
      String str1 = AtvMyPage.mOAuthLoginInstance.getLastErrorCode(AtvMyPage.mContext).getCode();
      String str2 = AtvMyPage.mOAuthLoginInstance.getLastErrorDesc(AtvMyPage.mContext);
      Toast.makeText(AtvMyPage.mContext, "errorCode:" + str1 + ", errorDesc:" + str2, 0).show();
    }
  };
  private static OAuthLogin mOAuthLoginInstance;
  private static RelativeLayout rlNaverLogout;
  private static RelativeLayout rlOAuthLoginImg;
  private ImageButton btnNaverLogout = null;
  private RelativeLayout mBaseChange = null;
  private ImageButton mBtnAppAdmin = null;
  private Button mBtnOut = null;
  private ImageButton mBtnPush = null;
  private OAuthLoginButton mOAuthLoginButton;
  public OAuthLoginState mOAuthLoginState;
  
  static
  {
    OAUTH_CLIENT_NAME = "네이버 아이디 로그인";
    OAUTH_CALLBACK_INTENT = "com.appg.golfmon.atv.more.AtvMyPage";
    rlOAuthLoginImg = null;
    rlNaverLogout = null;
  }
  
  private void callApi_withdrawUser()
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addProgress();
    localGPClient.addParameter("cmd", "Api.withdrawUser");
    localGPClient.setDecoder(new GJSONDecoder(3));
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvMyPage.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
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
            if (paramAnonymousInt > 0) {
              AtvMyPage.this.logout();
            }
          }
        });
        localAlert.showAlert(AtvMyPage.this.getContext(), paramAnonymousString);
        return null;
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  protected void configureListener()
  {
    this.mTxtTopTitleLeftBack.setOnClickListener(ListenerUtil.getFinishButtonListener(getContext()));
    this.mBaseChange.setOnClickListener(ListenerUtil.getMoveButtonListener(getContext(), AtvUserChange.class, false));
    this.mBtnPush.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (paramAnonymousView.isSelected()) {}
        for (boolean bool = false;; bool = true)
        {
          paramAnonymousView.setSelected(bool);
          SPUtil.getInstance().setIsOnPush(AtvMyPage.this.getContext(), paramAnonymousView.isSelected());
          return;
        }
      }
    });
    this.btnNaverLogout.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvMyPage.mOAuthLoginInstance.logout(AtvMyPage.mContext);
        AtvMyPage.rlNaverLogout.setVisibility(8);
        AtvMyPage.rlOAuthLoginImg.setVisibility(0);
      }
    });
    this.mBtnAppAdmin.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (paramAnonymousView.isSelected()) {}
        for (boolean bool = false;; bool = true)
        {
          paramAnonymousView.setSelected(bool);
          SPUtil.getInstance().setIsOnAppAdmin(AtvMyPage.this.getContext(), paramAnonymousView.isSelected());
          return;
        }
      }
    });
    this.mBtnOut.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Alert localAlert = new Alert();
        localAlert.setOnCloseListener(new Alert.OnCloseListener()
        {
          public void onClose(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int, Object paramAnonymous2Object)
          {
            if (1 == paramAnonymous2Int) {
              AtvMyPage.this.callApi_withdrawUser();
            }
          }
        });
        localAlert.showAlert(AtvMyPage.this.getContext(), "고객님께서 사용하셨던 모든 정보가 삭제됩니다.\n회원탈퇴 하시겠습니까?", true, new String[] { "탈퇴하기", "닫기" });
      }
    });
  }
  
  protected void findView()
  {
    this.mBaseChange = ((RelativeLayout)findViewById(2131361929));
    this.mBtnPush = ((ImageButton)findViewById(2131361930));
    this.mBtnAppAdmin = ((ImageButton)findViewById(2131361936));
    this.btnNaverLogout = ((ImageButton)findViewById(2131361934));
    this.mBtnOut = ((Button)findViewById(2131361937));
    this.mOAuthLoginButton = ((OAuthLoginButton)findViewById(2131361932));
    this.mOAuthLoginButton.setOAuthLoginHandler(mOAuthLoginHandler);
    rlOAuthLoginImg = (RelativeLayout)findViewById(2131361931);
    rlNaverLogout = (RelativeLayout)findViewById(2131361933);
    if (OAuthLoginState.OK.equals(OAuthLogin.getInstance().getState(this)))
    {
      rlNaverLogout.setVisibility(0);
      rlOAuthLoginImg.setVisibility(8);
      return;
    }
    rlNaverLogout.setVisibility(8);
    rlOAuthLoginImg.setVisibility(0);
  }
  
  protected void init()
  {
    this.mTxtTopTitleLeftBack.setVisibility(0);
    this.mTxtTopTitleLeftBack.setText("My page");
    this.mBtnPush.setSelected(SPUtil.getInstance().getIsOnPush(this));
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131361935);
    if (SPUtil.getInstance().getUserType(getContext()).equals("2"))
    {
      localRelativeLayout.setVisibility(0);
      this.mBtnAppAdmin.setVisibility(0);
      this.mBtnAppAdmin.setSelected(SPUtil.getInstance().getIsOnAppAdmin(this));
      return;
    }
    localRelativeLayout.setVisibility(8);
    this.mBtnAppAdmin.setVisibility(8);
  }
  
  protected void setView()
  {
    setView(2130903059);
    mContext = this;
    mOAuthLoginInstance = OAuthLogin.getInstance();
    mOAuthLoginInstance.init(getContext(), OAUTH_CLIENT_ID, OAUTH_CLIENT_SECRET, OAUTH_CLIENT_NAME, OAUTH_CALLBACK_INTENT);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.atv.more.AtvMyPage
 * JD-Core Version:    0.7.0.1
 */