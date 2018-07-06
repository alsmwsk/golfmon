package com.appg.golfmon.atv.more;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.appg.golfmon.atv.AtvBase;
import com.appg.golfmon.net.http.GFailedHandler;
import com.appg.golfmon.net.http.GJSONDecoder;
import com.appg.golfmon.net.http.GPClient;
import com.appg.golfmon.net.http.GResultHandler;
import com.appg.golfmon.util.Alert;
import com.appg.golfmon.util.JSONUtil;
import com.appg.golfmon.util.SPUtil;
import org.json.JSONObject;
import ra.genius.net.GBean;
import ra.genius.net.GExecutor;

public class AtvUserChange
  extends AtvBase
{
  private Button mBtnRequest = null;
  private Button mBtnSaveNickName = null;
  private Button mBtnSavePass = null;
  private EditText mEdtNickName = null;
  private EditText mEdtPass1 = null;
  private EditText mEdtPass2 = null;
  private EditText mEdtPassOrigin = null;
  private ImageView mImgCheckPass = null;
  private JSONObject mJsonUser = null;
  private String mStrConfirmNickName = "";
  private String mStrOriginNickName = "";
  private TextView mTxtNickName = null;
  
  private void callApi_checkNickName()
  {
    final String str = this.mEdtNickName.getText().toString();
    GPClient localGPClient = new GPClient(this);
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.setDecoder(new GJSONDecoder(3));
    localGPClient.addParameter("cmd", "Api.checkNickName");
    localGPClient.addParameter("nick_name", str);
    localGPClient.addProgress();
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvUserChange.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        if (paramAnonymousInt > 0) {
          AtvUserChange.this.mStrConfirmNickName = str;
        }
        new Alert().showAlert(AtvUserChange.this.getContext(), paramAnonymousString);
        return null;
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  private void callApi_modNickName()
  {
    GPClient localGPClient = new GPClient(this);
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.setDecoder(new GJSONDecoder(3));
    localGPClient.addParameter("cmd", "Api.modNickName");
    localGPClient.addParameter("nick_name", this.mStrConfirmNickName);
    localGPClient.addProgress();
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvUserChange.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        if (paramAnonymousInt > 0)
        {
          AtvUserChange.this.mStrOriginNickName = AtvUserChange.this.mStrConfirmNickName;
          AtvUserChange.this.mStrConfirmNickName = "";
          JSONUtil.put(AtvUserChange.this.mJsonUser, "nick_name", AtvUserChange.this.mStrOriginNickName);
          SPUtil.getInstance().setUserInfo(AtvUserChange.this.getContext(), AtvUserChange.this.mJsonUser);
          AtvUserChange.this.mTxtNickName.setText(AtvUserChange.this.mStrOriginNickName);
          AtvUserChange.this.mEdtNickName.setText("");
        }
        new Alert().showAlert(AtvUserChange.this.getContext(), paramAnonymousString);
        return null;
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  private void callApi_modPassword()
  {
    GPClient localGPClient = new GPClient(this);
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.setDecoder(new GJSONDecoder(3));
    localGPClient.addParameter("cmd", "Api.modPass");
    localGPClient.addParameter("pass", this.mEdtPassOrigin.getText().toString());
    localGPClient.addParameter("new_pass", this.mEdtPass1.getText().toString());
    localGPClient.addProgress();
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvUserChange.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        if (paramAnonymousInt > 0)
        {
          SPUtil.getInstance().setUserInfo(AtvUserChange.this.getContext(), AtvUserChange.this.mJsonUser);
          AtvUserChange.this.mEdtPass1.setText("");
          AtvUserChange.this.mEdtPass2.setText("");
          AtvUserChange.this.mEdtPassOrigin.setText("");
          AtvUserChange.this.mImgCheckPass.setVisibility(8);
        }
        new Alert().showAlert(AtvUserChange.this.getContext(), paramAnonymousString);
        return null;
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  protected void configureListener()
  {
    this.mBtnRequest.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        String str = AtvUserChange.this.mEdtNickName.getText().toString();
        if (str.length() < 2)
        {
          new Alert().showAlert(paramAnonymousView.getContext(), "닉네임을 2자이상 입력해주세요.");
          return;
        }
        if (AtvUserChange.this.mStrOriginNickName.equals(str))
        {
          new Alert().showAlert(paramAnonymousView.getContext(), "동일한 닉네임입니다.");
          return;
        }
        if (str.equals(AtvUserChange.this.mStrConfirmNickName))
        {
          new Alert().showAlert(paramAnonymousView.getContext(), "이미 중복체크가 완료되었습니다.");
          return;
        }
        AtvUserChange.this.callApi_checkNickName();
      }
    });
    this.mBtnSaveNickName.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        String str = AtvUserChange.this.mEdtNickName.getText().toString();
        if (str.length() < 2)
        {
          new Alert().showAlert(paramAnonymousView.getContext(), "닉네임을 2자이상 입력해주세요.");
          return;
        }
        if (AtvUserChange.this.mStrOriginNickName.equals(str))
        {
          new Alert().showAlert(paramAnonymousView.getContext(), "동일한 닉네임입니다.");
          return;
        }
        if (!AtvUserChange.this.mStrConfirmNickName.equals(str))
        {
          new Alert().showAlert(paramAnonymousView.getContext(), "중복 확인이 필요합니다.");
          return;
        }
        AtvUserChange.this.callApi_modNickName();
      }
    });
    this.mEdtPass1.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean)
        {
          if (AtvUserChange.this.mEdtPass1.getText().toString().length() < 6)
          {
            AtvUserChange.this.mImgCheckPass.setVisibility(0);
            AtvUserChange.this.mImgCheckPass.setImageResource(2130837617);
            return;
          }
          AtvUserChange.this.mImgCheckPass.setVisibility(8);
          return;
        }
        AtvUserChange.this.mEdtPass1.setText("");
        AtvUserChange.this.mEdtPass2.setText("");
        AtvUserChange.this.mImgCheckPass.setVisibility(8);
      }
    });
    this.mEdtPass2.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean)
        {
          if (AtvUserChange.this.mEdtPass1.getText().toString().length() < 6)
          {
            AtvUserChange.this.mImgCheckPass.setVisibility(0);
            AtvUserChange.this.mImgCheckPass.setImageResource(2130837617);
            return;
          }
          if (AtvUserChange.this.mEdtPass2.getText().toString().length() < 6)
          {
            AtvUserChange.this.mImgCheckPass.setVisibility(0);
            AtvUserChange.this.mImgCheckPass.setImageResource(2130837617);
            return;
          }
          if (AtvUserChange.this.mEdtPass1.getText().toString().equals(AtvUserChange.this.mEdtPass2.getText().toString()))
          {
            AtvUserChange.this.mImgCheckPass.setVisibility(0);
            AtvUserChange.this.mImgCheckPass.setImageResource(2130837616);
            return;
          }
          AtvUserChange.this.mImgCheckPass.setVisibility(0);
          AtvUserChange.this.mImgCheckPass.setImageResource(2130837617);
          return;
        }
        AtvUserChange.this.mEdtPass2.setText("");
        if (AtvUserChange.this.mEdtPass1.getText().toString().length() < 6)
        {
          AtvUserChange.this.mImgCheckPass.setVisibility(0);
          AtvUserChange.this.mImgCheckPass.setImageResource(2130837617);
          return;
        }
        AtvUserChange.this.mImgCheckPass.setVisibility(8);
      }
    });
    this.mBtnSavePass.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvUserChange.this.mEdtPassOrigin.requestFocus();
        String str1 = AtvUserChange.this.mEdtPassOrigin.getText().toString();
        String str2 = AtvUserChange.this.mEdtPass1.getText().toString();
        String str3 = AtvUserChange.this.mEdtPass2.getText().toString();
        if (str1.length() < 6)
        {
          new Alert().showAlert(AtvUserChange.this.getContext(), "비밀번호를 6자이상 입력해 주세요");
          return;
        }
        if ((str2.length() < 6) || (str3.length() < 6))
        {
          new Alert().showAlert(AtvUserChange.this.getContext(), "새로운 비밀번호를 6자이상 입력해 주세요");
          return;
        }
        if (!str2.equals(str3))
        {
          new Alert().showAlert(AtvUserChange.this.getContext(), "새로운 비밀번호가 일치하지 않습니다.");
          return;
        }
        AtvUserChange.this.callApi_modPassword();
      }
    });
  }
  
  protected void findView()
  {
    this.mTxtNickName = ((TextView)findViewById(2131361945));
    this.mEdtNickName = ((EditText)findViewById(2131361972));
    this.mBtnRequest = ((Button)findViewById(2131361973));
    this.mBtnSaveNickName = ((Button)findViewById(2131361974));
    this.mEdtPassOrigin = ((EditText)findViewById(2131361975));
    this.mEdtPass1 = ((EditText)findViewById(2131361976));
    this.mEdtPass2 = ((EditText)findViewById(2131361977));
    this.mBtnSavePass = ((Button)findViewById(2131361979));
    this.mImgCheckPass = ((ImageView)findViewById(2131361978));
  }
  
  protected void init()
  {
    this.mTxtTopTitleLeftBack.setVisibility(0);
    this.mTxtTopTitleLeftBack.setText("닉네임/비밀번호 변경");
    this.mJsonUser = SPUtil.getInstance().getUserInfo(this);
    this.mStrOriginNickName = JSONUtil.getString(this.mJsonUser, "nick_name", "");
    this.mTxtNickName.setText(this.mStrOriginNickName);
    this.mImgCheckPass.setVisibility(8);
  }
  
  protected void setView()
  {
    setView(2130903066);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.atv.more.AtvUserChange
 * JD-Core Version:    0.7.0.1
 */