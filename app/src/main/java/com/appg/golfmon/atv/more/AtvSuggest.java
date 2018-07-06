package com.appg.golfmon.atv.more;

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
import com.appg.golfmon.net.http.GResultHandler;
import com.appg.golfmon.util.Alert;
import com.appg.golfmon.util.Alert.OnCloseListener;
import com.appg.golfmon.util.FormatUtil;
import com.appg.golfmon.util.ListenerUtil;
import org.json.JSONObject;
import ra.genius.net.GBean;
import ra.genius.net.GExecutor;

public class AtvSuggest
  extends AtvBase
{
  private Button mBtnSubmit = null;
  private EditText mEdtContent = null;
  private EditText mEdtTitle = null;
  
  private void callApi_insOf_report()
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addProgress();
    localGPClient.addParameter("cmd", "Api.insOf_report");
    localGPClient.addParameter("title", this.mEdtTitle.getText().toString());
    localGPClient.addParameter("contents", this.mEdtContent.getText().toString());
    localGPClient.setDecoder(new GJSONDecoder(3));
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvSuggest.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
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
              AtvSuggest.this.finish();
            }
          }
        });
        localAlert.showAlert(AtvSuggest.this.getContext(), paramAnonymousString);
        return null;
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  protected void configureListener()
  {
    this.mTxtTopTitleLeftBack.setOnClickListener(ListenerUtil.getFinishButtonListener(getContext()));
    this.mBtnSubmit.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (FormatUtil.isNullorEmpty(AtvSuggest.this.mEdtTitle.getText().toString()))
        {
          new Alert().showAlert(AtvSuggest.this.getContext(), "제목을 입력해 주세요.");
          return;
        }
        if (FormatUtil.isNullorEmpty(AtvSuggest.this.mEdtContent.getText().toString()))
        {
          new Alert().showAlert(AtvSuggest.this.getContext(), "내용을 입력해 주세요.");
          return;
        }
        AtvSuggest.this.callApi_insOf_report();
      }
    });
  }
  
  protected void findView()
  {
    this.mEdtTitle = ((EditText)findViewById(2131361971));
    this.mEdtContent = ((EditText)findViewById(2131361967));
    this.mBtnSubmit = ((Button)findViewById(2131361964));
  }
  
  protected void init()
  {
    this.mTxtTopTitleLeftBack.setVisibility(0);
    this.mTxtTopTitleLeftBack.setText("골프몬에게 바라는 점");
  }
  
  protected void setView()
  {
    setView(2130903065);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.atv.more.AtvSuggest
 * JD-Core Version:    0.7.0.1
 */