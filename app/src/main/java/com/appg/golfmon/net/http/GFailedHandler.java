package com.appg.golfmon.net.http;

import com.appg.golfmon.util.FormatUtil;
import com.appg.golfmon.util.LogUtil;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import ra.genius.net.GBean;
import ra.genius.net.http.handler.IHttpHandler;

public abstract class GFailedHandler
  implements IHttpHandler
{
  public abstract void failedExecute(GBean paramGBean);
  
  public GBean handle(GBean paramGBean)
  {
    Exception localException = paramGBean.getException();
    if (localException != null)
    {
      LogUtil.e("GHTTP GFailedHandler", "통신 에러");
      LogUtil.e("GHTTP GFailedHandler", localException.getMessage());
      LogUtil.w(localException);
      if ((localException instanceof ConnectException))
      {
        str = "네트워크가 활성화 되지 않았습니다.\n3G/4G 혹은 Wifi를 켜주시기 바랍니다.";
        paramGBean.put("errorMessage", str);
        failedExecute(paramGBean);
        paramGBean = null;
      }
    }
    while (paramGBean.getHttpStatus() == 200) {
      for (;;)
      {
        String str;
        return paramGBean;
        if ((localException instanceof UnknownHostException))
        {
          str = "네트워크가 활성화 되지 않았습니다.\n3G/4G 혹은 Wifi를 켜주시기 바랍니다.";
        }
        else if ((localException instanceof SocketException))
        {
          if (localException.getMessage().contains("unreachable")) {
            str = "네트워크가 활성화 되지 않았습니다.\n3G/4G 혹은 Wifi를 켜주시기 바랍니다.";
          } else {
            str = "네트워크가 불안정합니다.";
          }
        }
        else if ((localException instanceof SocketTimeoutException))
        {
          str = "네트워크가 불안정합니다. 다시 시도해 주세요.";
        }
        else
        {
          str = (String)paramGBean.get("error");
          if (FormatUtil.isNullorEmpty(str)) {
            str = localException.getMessage();
          }
        }
      }
    }
    paramGBean.put("errorMessage", "HttpStatus : " + paramGBean.getHttpStatus());
    LogUtil.e("GHTTP GFailedHandler", "HttpStatus : " + paramGBean.getHttpStatus());
    failedExecute(paramGBean);
    return null;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.net.http.GFailedHandler
 * JD-Core Version:    0.7.0.1
 */