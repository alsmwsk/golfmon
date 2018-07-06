package com.appg.golfmon.atv.user;

import android.content.DialogInterface;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.appg.golfmon.atv.AtvBase;
import com.appg.golfmon.net.http.GFailedHandler;
import com.appg.golfmon.net.http.GJSONDecoder;
import com.appg.golfmon.net.http.GPClient;
import com.appg.golfmon.net.http.GResultHandler;
import com.appg.golfmon.util.Alert;
import com.appg.golfmon.util.Alert.OnCloseListener;
import com.appg.golfmon.util.CommonUtil;
import com.appg.golfmon.util.FormatUtil;
import com.appg.golfmon.util.JSONUtil;
import com.appg.golfmon.util.ListenerUtil;
import com.appg.golfmon.util.SPUtil;
import org.apache.commons.httpclient.Cookie;
import org.json.JSONObject;
import ra.genius.net.GBean;
import ra.genius.net.GExecutor;

public class AtvUserLogin
  extends AtvBase
{
  private Button mBtnFindPwd = null;
  private Button mBtnJoin = null;
  private Button mBtnLogin = null;
  private EditText mEdtId = null;
  private EditText mEdtPwd = null;
  private TextView mTxtVer = null;
  
  private void callApi_login()
  {
    GPClient localGPClient = new GPClient(this);
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addProgress();
    localGPClient.addParameter("cmd", "Api.login");
    localGPClient.addParameter("userID", this.mEdtId.getText().toString());
    localGPClient.addParameter("userPass", this.mEdtPwd.getText().toString());
    String str = SPUtil.getInstance().getRegistPushKey(getContext());
    if ((str == null) || (str.length() == 0)) {
      str = "tempregistrationKey";
    }
    localGPClient.addParameter("registrationKey", str);
    localGPClient.setDecoder(new GJSONDecoder(1));
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvUserLogin.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, final int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        if (paramAnonymousInt > 0)
        {
          SPUtil.getInstance().setCookie(AtvUserLogin.this.getContext(), (Cookie[])paramAnonymousGBean.get("cookies"));
          SPUtil.getInstance().setUserInfo(AtvUserLogin.this.getContext(), (JSONObject)paramAnonymousObject);
          SPUtil.getInstance().setUserType(AtvUserLogin.this.getContext(), JSONUtil.getString((JSONObject)paramAnonymousObject, "user_type", ""));
          SPUtil.getInstance().setIsLogin(AtvUserLogin.this.getContext(), true);
          AtvUserLogin.this.setResult(-1);
        }
        Alert localAlert = new Alert();
        localAlert.setOnCloseListener(new Alert.OnCloseListener()
        {
          public void onClose(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int, Object paramAnonymous2Object)
          {
            if (paramAnonymousInt > 0) {
              AtvUserLogin.this.finish();
            }
          }
        });
        localAlert.showAlert(AtvUserLogin.this.getContext(), paramAnonymousString);
        return null;
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  private boolean validate()
  {
    if (!FormatUtil.isPhoneNumber(this.mEdtId.getText().toString()))
    {
      new Alert().showAlert(getContext(), "휴대폰 번호를 입력해 주세요");
      return false;
    }
    if (this.mEdtPwd.getText().toString().length() < 6)
    {
      new Alert().showAlert(getContext(), "비밀번호를 6자이상 입력해 주세요");
      return false;
    }
    return true;
  }
  
  protected void configureListener()
  {
    this.mBtnLogin.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (!AtvUserLogin.this.validate()) {
          return;
        }
        AtvUserLogin.this.callApi_login();
      }
    });
    this.mBtnFindPwd.setOnClickListener(ListenerUtil.getMoveButtonListener(getContext(), AtvUserFindPwd.class, false));
    this.mBtnJoin.setOnClickListener(ListenerUtil.getMoveButtonListener(getContext(), AtvUserJoin.class, false));
  }
  
  protected void findView()
  {
    this.mEdtId = ((EditText)findViewById(2131361980));
    this.mEdtPwd = ((EditText)findViewById(2131361992));
    this.mBtnLogin = ((Button)findViewById(2131361993));
    this.mBtnJoin = ((Button)findViewById(2131361990));
    this.mBtnFindPwd = ((Button)findViewById(2131361994));
    this.mTxtVer = ((TextView)findViewById(2131361991));
  }
  
  protected void init()
  {
    this.mBaseTopTitle.setVisibility(8);
    this.mEdtId.setText(CommonUtil.getPhoneNumber(this));
    this.mTxtVer.setText("Ver. " + CommonUtil.getCurrentVersion(this));
  }
  
  protected void setView()
  {
    setView(2130903069);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.atv.user.AtvUserLogin
 * JD-Core Version:    0.7.0.1
 */