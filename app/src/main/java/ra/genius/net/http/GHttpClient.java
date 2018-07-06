package ra.genius.net.http;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import ra.genius.net.GBean;
import ra.genius.net.GLog;
import ra.genius.net.IExecute;
import ra.genius.net.http.codec.IHttpDecoder;
import ra.genius.net.http.handler.IHttpHandler;

public class GHttpClient
  implements IExecute
{
  private boolean isAsync = false;
  private AtomicBoolean isCancelled = new AtomicBoolean(false);
  private boolean isMultiPart = false;
  private String mCharset = "UTF-8";
  private HttpClient mClient = null;
  private HttpConnectionManager mConnMgr = null;
  private int mConnectionTimeout = 20000;
  private IHttpDecoder mDecoder = null;
  private GHandler mHandler = new GHandler(null);
  private ArrayList<IHttpHandler> mHandlerList = new ArrayList();
  private PostMethod mMethod = null;
  private ArrayList<GParam> mParamList = new ArrayList();
  private HttpState mState = null;
  private int mTimeout = 30000;
  private String mUri = "";
  
  public GHttpClient()
  {
    this(false);
  }
  
  public GHttpClient(boolean paramBoolean)
  {
    async(paramBoolean);
  }
  
  private void executeHandler(GBean paramGBean)
  {
    GLog.d("EXECUTE HANDLER SIZE : " + this.mHandlerList.size());
    for (int i = 0;; i++)
    {
      if (i >= this.mHandlerList.size()) {}
      while (paramGBean == null) {
        return;
      }
      paramGBean = ((IHttpHandler)this.mHandlerList.get(i)).handle(paramGBean);
      GLog.d("HANDLER #" + (i + 1) + " EXECUTED");
    }
  }
  
  public GHttpClient addCookie(Cookie paramCookie)
  {
    addCookies(new Cookie[] { paramCookie });
    return this;
  }
  
  public GHttpClient addCookies(Cookie... paramVarArgs)
  {
    if (this.mState == null) {
      this.mState = new HttpState();
    }
    this.mState.addCookies(paramVarArgs);
    return this;
  }
  
  public GHttpClient addHandler(IHttpHandler paramIHttpHandler)
  {
    this.mHandlerList.add(paramIHttpHandler);
    return this;
  }
  
  public GHttpClient addParameter(String paramString, Object paramObject)
  {
    GParam localGParam = new GParam();
    if ((paramObject instanceof File))
    {
      this.isMultiPart = true;
      localGParam.set(paramString, paramObject);
    }
    for (;;)
    {
      this.mParamList.add(localGParam);
      return this;
      localGParam.set(paramString, String.valueOf(paramObject));
    }
  }
  
  public void async(boolean paramBoolean)
  {
    this.isAsync = paramBoolean;
  }
  
  public void cancel()
  {
    if ((this.mMethod != null) && (this.isCancelled.compareAndSet(false, true))) {
      this.mMethod.abort();
    }
  }
  
  public void execute()
  {
    for (;;)
    {
      try
      {
        if ("".equals(this.mUri))
        {
          GLog.e("URI가 설정되지 않았습니다.");
          return;
        }
        if (this.mDecoder == null)
        {
          GLog.e("DECODER가 설정되지 않았습니다.");
          continue;
        }
      }
      catch (Exception localException)
      {
        if (!this.isCancelled.get()) {
          break label744;
        }
        GLog.i("HTTP호출이 사용자에 의해 취소되었습니다.");
        return;
        if (this.mTimeout < 0)
        {
          GLog.e("타임아웃 시간을 올바르게 설정바랍니다.");
          continue;
        }
      }
      finally
      {
        if (this.mMethod != null) {
          this.mMethod.releaseConnection();
        }
      }
      this.mClient = new HttpClient();
      this.mConnMgr = this.mClient.getHttpConnectionManager();
      this.mConnMgr.getParams().setSoTimeout(this.mTimeout);
      this.mConnMgr.getParams().setConnectionTimeout(this.mConnectionTimeout);
      this.mClient.setHttpConnectionManager(this.mConnMgr);
      if (this.mState != null) {
        this.mClient.setState(this.mState);
      }
      this.mMethod = new PostMethod(this.mUri);
      int i = this.mParamList.size();
      int j = 0;
      Part[] arrayOfPart;
      int i1;
      ByteArrayOutputStream localByteArrayOutputStream;
      byte[] arrayOfByte;
      label313:
      int n;
      String str1;
      GBean localGBean2;
      if (this.isMultiPart)
      {
        arrayOfPart = new Part[i];
        i1 = 0;
        if (i1 >= i)
        {
          PostMethod localPostMethod = this.mMethod;
          MultipartRequestEntity localMultipartRequestEntity = new MultipartRequestEntity(arrayOfPart, this.mMethod.getParams());
          localPostMethod.setRequestEntity(localMultipartRequestEntity);
          int m = this.mClient.executeMethod(this.mMethod);
          Message localMessage2 = new Message();
          localByteArrayOutputStream = new ByteArrayOutputStream();
          arrayOfByte = new byte[1024];
          n = this.mMethod.getResponseBodyAsStream().read(arrayOfByte, 0, arrayOfByte.length);
          if (n > 0) {
            break label679;
          }
          str1 = new String(localByteArrayOutputStream.toByteArray(), this.mCharset);
          if (m != 200) {
            break label692;
          }
          localGBean2 = this.mDecoder.decode(str1, this.mClient.getState().getCookies());
          label385:
          if (localGBean2 == null) {
            localGBean2 = new GBean();
          }
          localGBean2.putHttpStatus(m);
          localMessage2.obj = localGBean2;
          if (!this.isAsync) {
            break label735;
          }
          this.mHandler.sendMessage(localMessage2);
        }
      }
      while (this.mMethod != null)
      {
        this.mMethod.releaseConnection();
        return;
        String str3 = ((GParam)this.mParamList.get(i1)).getName();
        Object localObject3 = ((GParam)this.mParamList.get(i1)).getValue();
        String str4;
        String str5;
        if ((localObject3 instanceof String))
        {
          str4 = (String)localObject3;
          str5 = this.mCharset;
        }
        File localFile;
        for (Object localObject4 = new StringPart(str3, str4, str5);; localObject4 = new FilePart(str3, localFile))
        {
          arrayOfPart[j] = localObject4;
          j++;
          i1++;
          break;
          localFile = (File)localObject3;
        }
        NameValuePair[] arrayOfNameValuePair = new NameValuePair[i];
        for (int k = 0;; k++)
        {
          if (k >= i)
          {
            this.mMethod.addParameters(arrayOfNameValuePair);
            this.mMethod.addRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=" + this.mCharset);
            break;
          }
          String str2 = ((GParam)this.mParamList.get(k)).getName();
          Object localObject2 = ((GParam)this.mParamList.get(k)).getValue();
          NameValuePair localNameValuePair = new NameValuePair(str2, (String)localObject2);
          arrayOfNameValuePair[j] = localNameValuePair;
          j++;
        }
        label679:
        localByteArrayOutputStream.write(arrayOfByte, 0, n);
        break label313;
        label692:
        localGBean2 = new GBean();
        localGBean2.put("HTTP_STATUS_ERROR_MESSAGE", str1);
        GLog.trace("ERROR : " + str1);
        break label385;
        label735:
        executeHandler(localGBean2);
      }
      label744:
      Message localMessage1 = new Message();
      GBean localGBean1 = new GBean();
      localGBean1.putException(localException);
      localMessage1.obj = localGBean1;
      if ((localException instanceof FileNotFoundException)) {
        GLog.e("파일을 찾을 수 없습니다.");
      }
      for (;;)
      {
        GLog.trace("HTTP 호출간 에러 발생", localException);
        if (!this.isAsync) {
          break label901;
        }
        this.mHandler.sendMessage(localMessage1);
        break;
        if ((localException instanceof IOException)) {
          GLog.e("입/출력 오류가 발생했습니다.");
        } else if ((localException instanceof HttpException)) {
          GLog.e("HTTP 오류가 발생했습니다.");
        } else if ((localException instanceof IllegalArgumentException)) {
          GLog.e("HOST정보가 잘못되었습니다.");
        } else if ((localException instanceof SocketTimeoutException)) {
          GLog.e("타임아웃이 발생했습니다.");
        } else if ((localException instanceof SocketException)) {
          GLog.e("연결이 강제종료되었습니다.");
        } else {
          GLog.e("정의되지 않은 오류가 발생했습니다.");
        }
      }
      label901:
      executeHandler(localGBean1);
    }
  }
  
  public GHttpClient setConnectionTimeout(int paramInt)
  {
    this.mConnectionTimeout = paramInt;
    return this;
  }
  
  public GHttpClient setDecoder(IHttpDecoder paramIHttpDecoder)
  {
    this.mDecoder = paramIHttpDecoder;
    return this;
  }
  
  public GHttpClient setTimeout(int paramInt)
  {
    this.mTimeout = paramInt;
    return this;
  }
  
  public GHttpClient setUri(String paramString)
  {
    this.mUri = paramString;
    return this;
  }
  
  @SuppressLint({"HandlerLeak"})
  private class GHandler
    extends Handler
  {
    private GHandler() {}
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage == null)
      {
        super.handleMessage(paramMessage);
        return;
      }
      GBean localGBean = (GBean)paramMessage.obj;
      GHttpClient.this.executeHandler(localGBean);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     ra.genius.net.http.GHttpClient
 * JD-Core Version:    0.7.0.1
 */