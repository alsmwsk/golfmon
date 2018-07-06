package com.appg.golfmon.net.http;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.appg.golfmon.util.Alert;
import com.appg.golfmon.util.CommonUtil;
import com.appg.golfmon.util.FormatUtil;
import com.appg.golfmon.util.LogUtil;
import com.appg.golfmon.util.ProgressDialogUtil;
import com.appg.golfmon.util.SPUtil;
import java.io.File;
import ra.genius.net.GBean;
import ra.genius.net.http.GHttpClient;
import ra.genius.net.http.handler.IHttpHandler;

public class GPClient
  extends GHttpClient
  implements DialogInterface.OnCancelListener
{
  private Context mContext;
  private Dialog mDialog = null;
  private boolean mIsCancel = false;
  private String mTag = "";
  private String mUrl = "";
  
  public GPClient(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public GHttpClient addCmd(String paramString)
  {
    return addParameter("cmd", paramString);
  }
  
  public GHttpClient addParameter(String paramString, Object paramObject)
  {
    if ((paramObject instanceof Integer))
    {
      this.mUrl = (this.mUrl + paramString + "=" + (Integer)paramObject + "&");
      LogUtil.d("GHTTP params", paramString + "=" + (Integer)paramObject + "   <- Integer");
    }
    for (;;)
    {
      return super.addParameter(paramString, paramObject);
      if ((paramObject instanceof Boolean))
      {
        this.mUrl = (this.mUrl + paramString + "=" + (Boolean)paramObject + "&");
        LogUtil.d("GHTTP params", paramString + "=" + (Boolean)paramObject + "   <- Boolean");
      }
      else if ((paramObject instanceof String))
      {
        this.mUrl = (this.mUrl + paramString + "=" + (String)paramObject + "&");
        LogUtil.d("GHTTP params", paramString + "=" + (String)paramObject + "   <- String");
      }
      else if ((paramObject instanceof Double))
      {
        this.mUrl = (this.mUrl + paramString + "=" + (Double)paramObject + "&");
        LogUtil.d("GHTTP params", paramString + "=" + (Double)paramObject + "   <- Double");
      }
      else if ((paramObject instanceof Long))
      {
        this.mUrl = (this.mUrl + paramString + "=" + (Long)paramObject + "&");
        LogUtil.d("GHTTP params", paramString + "=" + (Long)paramObject + "   <- Long");
      }
      else if ((paramObject instanceof Float))
      {
        this.mUrl = (this.mUrl + paramString + "=" + (Float)paramObject + "&");
        LogUtil.d("GHTTP params", paramString + "=" + (Float)paramObject + "   <- Float");
      }
      else if ((paramObject instanceof File))
      {
        if (((File)paramObject).isFile())
        {
          this.mUrl = (this.mUrl + paramString + "=" + "파일추가입니다." + "&");
          LogUtil.d("GHTTP params", paramString + "=" + "파일추가입니다.   <- File");
        }
        else
        {
          this.mUrl = (this.mUrl + paramString + "=" + "파일없습니다." + "&");
          LogUtil.d("GHTTP params", paramString + "=" + "파일없습니다.   <- File");
        }
      }
    }
  }
  
  public void addProgress()
  {
    addProgress(this);
  }
  
  public void addProgress(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this.mDialog = ProgressDialogUtil.show(this.mContext, this.mDialog);
    this.mIsCancel = false;
    if (paramOnCancelListener != null) {
      this.mDialog.setOnCancelListener(paramOnCancelListener);
    }
  }
  
  public void cancel()
  {
    ProgressDialogUtil.dismiss(this.mDialog);
    super.cancel();
  }
  
  public void execute()
  {
    LogUtil.e("GHTTP excute", "============================================================================================================================");
    LogUtil.d("GHTTP excute 시작", this.mTag);
    if (!FormatUtil.isNullorEmpty(this.mUrl)) {
      LogUtil.e("GHTTP excute url", this.mUrl.substring(0, -1 + this.mUrl.length()));
    }
    super.execute();
    LogUtil.d("GHTTP excute 완료", this.mTag);
    ProgressDialogUtil.dismiss(this.mDialog);
    LogUtil.e("GHTTP excute url", "============================================================================================================================");
  }
  
  public Dialog getProgress()
  {
    return this.mDialog;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    Alert.toastShort(this.mContext, "사용자에 의해 취소 되었습니다.");
    this.mIsCancel = true;
    cancel();
  }
  
  public void removeProgress()
  {
    ProgressDialogUtil.dismiss(this.mDialog);
  }
  
  public void setDefault()
  {
    addParameter("deviceID", CommonUtil.getDeviceKey(this.mContext));
    addParameter("appTypeID", "1");
    addParameter("deviceTypeID", "1");
    addParameter("storeTypeID", "1");
    addParameter("appVersion", CommonUtil.getCurrentVersion(this.mContext));
    addParameter("registrationKey", SPUtil.getInstance().getRegistPushKey(this.mContext));
    addCookies(SPUtil.getInstance().getCookie(this.mContext));
    addHandler(new IHttpHandler()
    {
      public GBean handle(GBean paramAnonymousGBean)
      {
        if (GPClient.this.mIsCancel) {
          paramAnonymousGBean = null;
        }
        return paramAnonymousGBean;
      }
    });
  }
  
  public GHttpClient setUri(String paramString)
  {
    this.mUrl = (paramString + "?");
    setDefault();
    return super.setUri(paramString);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.net.http.GPClient
 * JD-Core Version:    0.7.0.1
 */