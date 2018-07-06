package com.appg.golfmon.atv.user;

import android.content.DialogInterface;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.appg.golfmon.atv.AtvBase;
import com.appg.golfmon.net.http.GFailedHandler;
import com.appg.golfmon.net.http.GJSONDecoder;
import com.appg.golfmon.net.http.GPClient;
import com.appg.golfmon.util.Alert;
import com.appg.golfmon.util.Alert.OnCloseListener;
import com.appg.golfmon.util.CommonUtil;
import com.appg.golfmon.util.FormatUtil;
import com.appg.golfmon.util.ListenerUtil;
import ra.genius.net.GBean;
import ra.genius.net.GExecutor;
import ra.genius.net.http.handler.IHttpHandler;

public class AtvUserFindPwd
  extends AtvBase
{
  private Button mBtnSend = null;
  private EditText mEdtId = null;
  
  private void callApi_sendTempPass()
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addParameter("cmd", "Api.sendTempPass");
    localGPClient.addParameter("userID", this.mEdtId.getText().toString());
    localGPClient.setDecoder(new GJSONDecoder(3));
    localGPClient.addProgress();
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvUserFindPwd.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
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
          public void onClose(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int, Object paramAnonymous2Object)
          {
            if (i > 0) {
              AtvUserFindPwd.this.finish();
            }
          }
        });
        localAlert.showAlert(AtvUserFindPwd.this.getContext(), str);
        return null;
      }
    });
    GExecutor.getInstance().cancelAndExecute(localGPClient);
  }
  
  protected void configureListener()
  {
    this.mTxtTopTitleLeftBack.setOnClickListener(ListenerUtil.getFinishButtonListener(getContext()));
    this.mBtnSend.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (!FormatUtil.isPhoneNumber(AtvUserFindPwd.this.mEdtId.getText().toString()))
        {
          new Alert().showAlert(AtvUserFindPwd.this.getContext(), "휴대폰 번호를 입력해 주세요");
          return;
        }
        AtvUserFindPwd.this.callApi_sendTempPass();
      }
    });
  }
  
  protected void findView()
  {
    this.mEdtId = ((EditText)findViewById(2131361980));
    this.mBtnSend = ((Button)findViewById(2131361981));
  }
  
  protected void init()
  {
    this.mTxtTopTitleLeftBack.setVisibility(0);
    this.mTxtTopTitleLeftBack.setText("비밀번호 찾기");
    this.mEdtId.setText(CommonUtil.getPhoneNumber(this));
  }
  
  protected void setView()
  {
    setView(2130903067);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.atv.user.AtvUserFindPwd
 * JD-Core Version:    0.7.0.1
 */