package com.appg.golfmon.atv.user;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
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
import com.appg.golfmon.util.Alert.OnCloseListener;
import com.appg.golfmon.util.CommonUtil;
import com.appg.golfmon.util.FormatUtil;
import com.appg.golfmon.util.JSONUtil;
import com.appg.golfmon.util.ListenerUtil;
import com.appg.golfmon.util.SPUtil;
import org.json.JSONObject;
import ra.genius.net.GBean;
import ra.genius.net.GExecutor;
import ra.genius.net.http.handler.IHttpHandler;

public class AtvUserJoin
  extends AtvBase
{
  private Button mBtnAgree1 = null;
  private Button mBtnAgree2 = null;
  private Button mBtnCert = null;
  private TextView mBtnChkAgree = null;
  private Button mBtnJoin = null;
  private Button mBtnMan = null;
  private Button mBtnWoman = null;
  private String mCertNum = "";
  private String mCertPhone = "";
  private Runnable mCheckNickNameRunnable = new Runnable()
  {
    public void run()
    {
      AtvUserJoin.this.checkNickName();
    }
  };
  private TextWatcher mCheckNickNameTextWatcher = new TextWatcher()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      AtvUserJoin.this.mImgCheckNickName.setVisibility(8);
      AtvUserJoin.this.mHandler.removeCallbacks(AtvUserJoin.this.mCheckNickNameRunnable);
      AtvUserJoin.this.mHandler.postDelayed(AtvUserJoin.this.mCheckNickNameRunnable, 500L);
    }
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  private String mConfirmNickName = "";
  private EditText mEdtCert = null;
  private EditText mEdtName = null;
  private EditText mEdtNickName = null;
  private EditText mEdtPass1 = null;
  private EditText mEdtPass2 = null;
  private EditText mEdtPhone = null;
  private Handler mHandler = new Handler();
  private ImageView mImgCheckNickName = null;
  private ImageView mImgCheckPass = null;
  
  private void callApi_checkDuplicate_NickName(final String paramString)
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("Api.checkNickName");
    localGPClient.addParameter("nick_name", paramString);
    localGPClient.setDecoder(new GJSONDecoder(3));
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastShort(AtvUserJoin.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
        AtvUserJoin.this.mImgCheckNickName.setVisibility(0);
        AtvUserJoin.this.mImgCheckNickName.setImageResource(2130837617);
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        if (paramAnonymousInt > 0)
        {
          AtvUserJoin.this.mConfirmNickName = paramString;
          AtvUserJoin.this.mImgCheckNickName.setVisibility(0);
          AtvUserJoin.this.mImgCheckNickName.setImageResource(2130837616);
        }
        for (;;)
        {
          return null;
          AtvUserJoin.this.mImgCheckNickName.setVisibility(0);
          AtvUserJoin.this.mImgCheckNickName.setImageResource(2130837617);
        }
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  private void callApi_joinUser()
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addParameter("cmd", "Api.joinUser");
    localGPClient.addParameter("phone", this.mEdtPhone.getText().toString().replaceAll("\\D", ""));
    localGPClient.addParameter("password", this.mEdtPass1.getText().toString());
    localGPClient.addParameter("name", this.mEdtName.getText().toString());
    localGPClient.addParameter("nick_name", this.mConfirmNickName);
    if (this.mBtnMan.isSelected()) {}
    for (String str = "M";; str = "F")
    {
      localGPClient.addParameter("gender", str);
      localGPClient.addParameter("registrationKey", SPUtil.getInstance().getRegistPushKey(this));
      localGPClient.addProgress();
      localGPClient.setDecoder(new GJSONDecoder(3));
      localGPClient.addHandler(new GFailedHandler()
      {
        public void failedExecute(GBean paramAnonymousGBean)
        {
          Alert.toastLong(AtvUserJoin.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
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
                AtvUserJoin.this.setResult(-1);
                AtvUserJoin.this.finish();
              }
            }
          });
          localAlert.showAlert(AtvUserJoin.this.getContext(), paramAnonymousString);
          return null;
        }
      });
      GExecutor.getInstance().execute(localGPClient);
      return;
    }
  }
  
  private void callApi_privacyAgreeInfo(final int paramInt)
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.setDecoder(new GJSONDecoder(1));
    localGPClient.addParameter("cmd", "Api.privacyAgreeInfo");
    localGPClient.addProgress();
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvUserJoin.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        String str1;
        String str2;
        Alert localAlert;
        Activity localActivity;
        if (paramAnonymousInt > 0)
        {
          JSONObject localJSONObject = (JSONObject)paramAnonymousGBean.get("entity");
          if (paramInt != 1) {
            break label92;
          }
          str1 = "agree";
          str2 = JSONUtil.getString(localJSONObject, str1, "");
          localAlert = new Alert();
          localActivity = AtvUserJoin.this.getContext();
          if (paramInt != 1) {
            break label99;
          }
        }
        label92:
        label99:
        for (String str3 = "서비스 약관";; str3 = "개인정보 취급방침")
        {
          localAlert.showAlertAgree(localActivity, str3, str2, true, new String[] { "확인" });
          return null;
          str1 = "privacy";
          break;
        }
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  private void callApi_sendCert()
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addParameter("cmd", "Api.sendCert");
    localGPClient.addParameter("phone", this.mCertPhone);
    localGPClient.addParameter("cert", this.mCertNum);
    localGPClient.setDecoder(new GJSONDecoder(3));
    localGPClient.addProgress();
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvUserJoin.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
      }
    });
    localGPClient.addHandler(new IHttpHandler()
    {
      public GBean handle(GBean paramAnonymousGBean)
      {
        final int i = ((Integer)paramAnonymousGBean.get("returnCode")).intValue();
        String str = (String)paramAnonymousGBean.get("returnMessage");
        Alert localAlert = new Alert();
        localAlert.setOnCloseListener(new Alert.OnCloseListener()
        {
          public void onClose(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int, Object paramAnonymous2Object) {}
        });
        localAlert.showAlert(AtvUserJoin.this.getContext(), str);
        return null;
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  private void checkNickName()
  {
    GExecutor.getInstance().cancelAll();
    String str = this.mEdtNickName.getText().toString();
    if (this.mConfirmNickName.equals(str))
    {
      this.mImgCheckNickName.setVisibility(0);
      this.mImgCheckNickName.setImageResource(2130837616);
      return;
    }
    if (str.length() < 2)
    {
      this.mImgCheckNickName.setVisibility(0);
      this.mImgCheckNickName.setImageResource(2130837617);
      return;
    }
    callApi_checkDuplicate_NickName(str);
  }
  
  private boolean validate()
  {
    if (!FormatUtil.isPhoneNumber(this.mEdtPhone.getText().toString()))
    {
      new Alert().showAlert(getContext(), "휴대폰 번호를 입력해 주세요");
      return false;
    }
    if ((FormatUtil.isNullorEmpty(this.mEdtCert.getText().toString())) || (!this.mEdtCert.getText().toString().equals(this.mCertNum)) || (!this.mCertPhone.equals(this.mEdtPhone.getText().toString())))
    {
      new Alert().showAlert(getContext(), "인증번호를 확인해 주세요.");
      return false;
    }
    String str1 = this.mEdtPass1.getText().toString();
    String str2 = this.mEdtPass2.getText().toString();
    if ((str1.length() < 6) || (str2.length() < 6))
    {
      new Alert().showAlert(getContext(), "비밀번호를 6자이상 입력해 주세요");
      return false;
    }
    if (!str1.equals(str2))
    {
      new Alert().showAlert(getContext(), "비밀번호가 일치하지 않습니다.");
      return false;
    }
    if (FormatUtil.isNullorEmpty(this.mEdtName.getText().toString()))
    {
      new Alert().showAlert(getContext(), "이름을 입력해 주세요");
      return false;
    }
    if (this.mEdtNickName.getText().toString().length() < 2)
    {
      new Alert().showAlert(getContext(), "닉네임을 2자이상 입력해 주세요");
      return false;
    }
    if (!this.mEdtNickName.getText().toString().equals(this.mConfirmNickName))
    {
      new Alert().showAlert(getContext(), "닉네임을 사용할 수 없습니다.");
      return false;
    }
    if ((!this.mBtnMan.isSelected()) && (!this.mBtnWoman.isSelected()))
    {
      new Alert().showAlert(getContext(), "성별을 선택해 주세요");
      return false;
    }
    if (!this.mBtnChkAgree.isSelected())
    {
      new Alert().showAlert(getContext(), "약관에 동의해 주세요");
      return false;
    }
    return true;
  }
  
  protected void configureListener()
  {
    this.mEdtPass1.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean)
        {
          if (AtvUserJoin.this.mEdtPass1.getText().toString().length() < 6)
          {
            AtvUserJoin.this.mImgCheckPass.setVisibility(0);
            AtvUserJoin.this.mImgCheckPass.setImageResource(2130837617);
            return;
          }
          AtvUserJoin.this.mImgCheckPass.setVisibility(8);
          return;
        }
        AtvUserJoin.this.mEdtPass1.setText("");
        AtvUserJoin.this.mEdtPass2.setText("");
        AtvUserJoin.this.mImgCheckPass.setVisibility(8);
      }
    });
    this.mEdtPass2.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean)
        {
          if (AtvUserJoin.this.mEdtPass1.getText().toString().length() < 6)
          {
            AtvUserJoin.this.mImgCheckPass.setVisibility(0);
            AtvUserJoin.this.mImgCheckPass.setImageResource(2130837617);
            return;
          }
          if (AtvUserJoin.this.mEdtPass2.getText().toString().length() < 6)
          {
            AtvUserJoin.this.mImgCheckPass.setVisibility(0);
            AtvUserJoin.this.mImgCheckPass.setImageResource(2130837617);
            return;
          }
          if (AtvUserJoin.this.mEdtPass1.getText().toString().equals(AtvUserJoin.this.mEdtPass2.getText().toString()))
          {
            AtvUserJoin.this.mImgCheckPass.setVisibility(0);
            AtvUserJoin.this.mImgCheckPass.setImageResource(2130837616);
            return;
          }
          AtvUserJoin.this.mImgCheckPass.setVisibility(0);
          AtvUserJoin.this.mImgCheckPass.setImageResource(2130837617);
          return;
        }
        AtvUserJoin.this.mEdtPass2.setText("");
        if (AtvUserJoin.this.mEdtPass1.getText().toString().length() < 6)
        {
          AtvUserJoin.this.mImgCheckPass.setVisibility(0);
          AtvUserJoin.this.mImgCheckPass.setImageResource(2130837617);
          return;
        }
        AtvUserJoin.this.mImgCheckPass.setVisibility(8);
      }
    });
    this.mEdtNickName.addTextChangedListener(this.mCheckNickNameTextWatcher);
    this.mBtnMan.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvUserJoin.this.mBtnMan.setSelected(true);
        AtvUserJoin.this.mBtnWoman.setSelected(false);
      }
    });
    this.mBtnWoman.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvUserJoin.this.mBtnMan.setSelected(false);
        AtvUserJoin.this.mBtnWoman.setSelected(true);
      }
    });
    this.mBtnAgree1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvUserJoin.this.callApi_privacyAgreeInfo(1);
      }
    });
    this.mBtnAgree2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvUserJoin.this.callApi_privacyAgreeInfo(2);
      }
    });
    this.mBtnChkAgree.setOnClickListener(ListenerUtil.getCheckButtonListener());
    this.mBtnJoin.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (!AtvUserJoin.this.validate()) {
          return;
        }
        AtvUserJoin.this.callApi_joinUser();
      }
    });
    this.mBtnCert.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvUserJoin.this.mCertNum = String.valueOf(1000 + (int)(8999.0D * Math.random()));
        AtvUserJoin.this.mCertPhone = AtvUserJoin.this.mEdtPhone.getText().toString();
        if (!FormatUtil.isPhoneNumber(AtvUserJoin.this.mCertPhone))
        {
          new Alert().showAlert(AtvUserJoin.this.getContext(), "휴대폰 번호를 입력해 주세요");
          return;
        }
        AtvUserJoin.this.callApi_sendCert();
      }
    });
  }
  
  protected void findView()
  {
    this.mTxtTopTitleLeft.setText("회원가입");
    this.mTxtTopTitleLeft.setVisibility(0);
  }
  
  protected void init()
  {
    this.mEdtPhone = ((EditText)findViewById(2131361982));
    this.mEdtCert = ((EditText)findViewById(2131361984));
    this.mEdtPass1 = ((EditText)findViewById(2131361976));
    this.mEdtPass2 = ((EditText)findViewById(2131361977));
    this.mImgCheckPass = ((ImageView)findViewById(2131361978));
    this.mEdtName = ((EditText)findViewById(2131361985));
    this.mEdtNickName = ((EditText)findViewById(2131361972));
    this.mImgCheckNickName = ((ImageView)findViewById(2131361986));
    this.mBtnMan = ((Button)findViewById(2131361961));
    this.mBtnWoman = ((Button)findViewById(2131361962));
    this.mBtnAgree1 = ((Button)findViewById(2131361987));
    this.mBtnAgree2 = ((Button)findViewById(2131361988));
    this.mBtnChkAgree = ((TextView)findViewById(2131361989));
    this.mBtnJoin = ((Button)findViewById(2131361990));
    this.mBtnCert = ((Button)findViewById(2131361983));
    String str = CommonUtil.getPhoneNumber(this);
    if (FormatUtil.isPhoneNumber(str))
    {
      this.mEdtPhone.setText(FormatUtil.toPhoneNumber(str));
      this.mEdtPhone.clearFocus();
      this.mEdtPhone.setEnabled(false);
      this.mEdtPhone.setBackgroundColor(0);
    }
    for (;;)
    {
      this.mImgCheckPass.setVisibility(8);
      this.mImgCheckNickName.setVisibility(8);
      return;
      EditText localEditText = this.mEdtPhone;
      InputFilter[] arrayOfInputFilter = new InputFilter[1];
      arrayOfInputFilter[0] = new InputFilter.LengthFilter(11);
      localEditText.setFilters(arrayOfInputFilter);
    }
  }
  
  protected void setView()
  {
    setView(2130903068);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.atv.user.AtvUserJoin
 * JD-Core Version:    0.7.0.1
 */