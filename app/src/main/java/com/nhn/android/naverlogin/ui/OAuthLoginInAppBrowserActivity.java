package com.nhn.android.naverlogin.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import com.nhn.android.naverlogin.OAuthLoginDefine;
import com.nhn.android.naverlogin.connection.NetworkState;
import com.nhn.android.naverlogin.connection.gen.OAuthQueryGenerator;
import com.nhn.android.naverlogin.data.OAuthLoginData;
import com.nhn.android.naverlogin.util.DeviceAppInfo;
import com.nhn.android.naverlogin.util.OAuthLoginUiUtil;

public class OAuthLoginInAppBrowserActivity
  extends Activity
  implements View.OnClickListener
{
  private static final String TAG = "NaverLoginOAuth|OAuthLoginInAppBrowserActivity";
  private byte[] drawableByteBottomBackGroundImg;
  private byte[] drawableByteCloseBtnImg;
  private Context mContext;
  final DownloadListener mDefaultDownloadListener = new DownloadListener()
  {
    public void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setDataAndType(Uri.parse(paramAnonymousString1), paramAnonymousString4);
      try
      {
        OAuthLoginInAppBrowserActivity.this.startActivity(localIntent);
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        try
        {
          localIntent.setData(Uri.parse(paramAnonymousString1));
          OAuthLoginInAppBrowserActivity.this.startActivity(localIntent);
          return;
        }
        catch (Exception localException) {}
      }
    }
  };
  private boolean mFixActivityPortrait = true;
  private ImageView mImgCloseButton;
  private ImageView mImgSeperator;
  public String mInOAuthUrl;
  private boolean mIsLoginActivityStarted = false;
  private LinearLayout mNaviBar;
  private OAuthLoginData mOAuthLoginData;
  private String mOAuthSdkVersion;
  private WebView mWebView;
  private String mWebViewContent;
  private ProgressBar mWebviewProgressbar;
  private LinearLayout mWholeView;
  
  private void initData()
  {
    this.mContext = this;
    if (getIntent() != null)
    {
      String str1 = getIntent().getStringExtra("ClientId");
      String str2 = getIntent().getStringExtra("ClientCallbackUrl");
      String str3 = getIntent().getStringExtra("state");
      String str4 = DeviceAppInfo.getBaseInstance().getLocaleString(this.mContext);
      String str5 = NetworkState.getNetworkState(this.mContext);
      this.mOAuthLoginData = new OAuthLoginData(str1, null, str2, str3);
      this.mInOAuthUrl = new OAuthQueryGenerator().generateRequestInitUrl(str1, this.mOAuthLoginData.getInitState(), str2, str4, str5);
      this.mOAuthSdkVersion = getIntent().getStringExtra("oauth_sdk_version");
      this.mFixActivityPortrait = OAuthLoginUiUtil.isFixActivityPortrait(this.mOAuthSdkVersion);
    }
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  private void initView(Bundle paramBundle)
  {
    requestWindowFeature(1);
    this.drawableByteBottomBackGroundImg = OAuthLoginImage.hexToByteArray("89504e470d0a1a0a0000000d494844520000000c0000003c0806000000520f5b4a0000000473424954080808087c08648800000093494441544889e596410e80200c0407d34f79f5e4ffbfe2454d00df3024252472eeb2bb6d692940479ccd0403c47e9c97025024c373bfca43b45a1d83ba1e08975408680ee0c221e84e93f6e05b434bf27590267ce1969494cda03d4c9094de4bbd39887f0f364b9a211f105dd661cad490b375a0f924404bcadf4033765cfab8cf9634d2adcb555a3f20ffd7f8e3dab569fd00dbc449301620f2800000000049454e44ae426082");
    this.drawableByteCloseBtnImg = OAuthLoginImage.hexToByteArray("89504e470d0a1a0a0000000d49484452000000260000002008060000007e640ab30000000473424954080808087c08648800000370494441545885ed97cd4beb4c14871fabb64d66504b5b53ad284a515044d18545f01f565444772a7e8b5f4b1515515cccee2e14d3b4a475bc0b5b69ec57d27b37efcbfd4116ed647e7966cee49c13f8a7ff893a5a8c77017d40b8fcdb055e8152c0e704f6e90c6056b9bfbb6cacdb84f2e513f263767c7cac2e2f2f55792c5c1eeb0a0a15c4a7512813d566524a7a7b7b01181d1d4d97ef69158e1aa8263ebf7e4e6eb4636180a3a3232584209148904824e8e9e9e1e5e5c5cf8a3d50151fcbb288c562f57c6ad408cc05585a5a4a472211bababa08854244a3514cd3e4f9f9b9199c07eae0e04099a68965590821d05ad3d1d1c1c8c848f58ed5a851283de64f4f4f4a4a89699a00388e836ddb8c8d8dfd0c2bd5f3f6f7f7959492818101a494944a5f518fc7e32d8f43b374e1817b7c7cac0b97c9647eae3c0cb0b7b7a7a494a452290f543299f4754603e5b1878787ba70e3e3e3e9ea49bbbbbb75a12ccbf2fbe2b404ab81bbbfbf57524a0cc300209fcf63db3613131369809d9d1d25a5c4b22ca4947c7c7c00904aa57c43f905ab81bbbbbb5342080f5c2e97e3eded0d804422e1811a1c1c0c041504ac06eef6f6560921104200502c16715d97502844381ca6582c0230343414182a28580ddcf5f5b58ac562df3b5791ebbab8aecbf0f0705b50d0388ff9d2ebeb2b854201ad75ddeb4f1404ccb35b5b5b5baaf270d77529140a140a055cf72b6b68adb9b9b969a7be026d1efecdcdcdef122384f84e0715452211e02b9de47239e6e6e60287d4cf8e79a03636369461182493490cc3c0755db4d664329974269349e772396cdb466b4d341ac5300caeaeae02ef5c2b300fd4fafa7a5da8ea043b3333937e7f7faf81bbb8b80804e7bb24adadad292104fdfdfd9ef04d4e4ed62d49e7e7e7ca344d4f95701c878585853f2a491ea8d5d555258420994c2284f84e9c5353534d8bf8d9d999324dd393881dc7219bcdb6846b14ca6ff3959515651806f1781cc33028168b68adeb4195cad76bf93fb2d96cdab66d1cc7416b4d2412c1300c4e4f4f7f86b5464d1bc5e5e565659a2695245a2a95f8fcfc647a7abad98a3d708b8b8b69dbb6c9e7f368ade9ececc4344d4e4e4e9a368a2d5bebeded6dd5d7d74777773700b3b3b36db5d6952e36140ad5f3a969ad7d9db1c3c3432584607e7e3e683e6adbc7f75b59a5a075af2d9f66df95ba3cb9bbeabe763e78ff96cf3ffd37f51b1081c17a70bcfc1a0000000049454e44ae426082");
    this.mWebviewProgressbar = new ProgressBar(this, null, 16842872);
    this.mWebviewProgressbar.setLayoutParams(new LinearLayout.LayoutParams(-1, 5));
    this.mWebviewProgressbar.setVisibility(8);
    this.mWebviewProgressbar.setMax(100);
    this.mWebView = new WebView(this);
    this.mWebView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0F));
    this.mWebView.getSettings().setJavaScriptEnabled(true);
    this.mWebView.setVerticalScrollbarOverlay(true);
    this.mWebView.setHorizontalScrollbarOverlay(true);
    this.mWebView.setWebViewClient(new InAppWebViewClient());
    this.mWebView.setWebChromeClient(new InAppWebChromeClient(null));
    this.mWebView.setDownloadListener(this.mDefaultDownloadListener);
    this.mWebView.addJavascriptInterface(new InAppBrowserJavascriptInterface(this), "AndroidLoginWebView");
    String str = this.mWebView.getSettings().getUserAgentString() + " " + DeviceAppInfo.getBaseInstance().getUserAgent(this);
    this.mWebView.getSettings().setUserAgentString(str);
    this.mNaviBar = new LinearLayout(this);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, (int)OAuthLoginImage.convertDpToPixel(40.0F, this.mContext));
    this.mNaviBar.setGravity(21);
    this.mNaviBar.setLayoutParams(localLayoutParams);
    this.mNaviBar.setOrientation(0);
    BitmapDrawable localBitmapDrawable1 = new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(this.drawableByteBottomBackGroundImg, 0, this.drawableByteBottomBackGroundImg.length));
    try
    {
      if (Build.VERSION.SDK_INT >= 16) {
        this.mNaviBar.setBackground(localBitmapDrawable1);
      }
      for (;;)
      {
        this.mImgSeperator = new ImageView(this);
        this.mImgSeperator.setLayoutParams(new LinearLayout.LayoutParams((int)OAuthLoginImage.convertDpToPixel(1.0F, this.mContext), -1));
        this.mImgSeperator.setBackgroundColor(Color.argb(255, 0, 0, 0));
        this.mImgSeperator.invalidate();
        this.mImgCloseButton = new ImageView(this);
        this.mImgCloseButton.setLayoutParams(new LinearLayout.LayoutParams(OAuthLoginImage.getScreenWidth((Activity)this.mContext) / 4, (int)OAuthLoginImage.convertDpToPixel(21.333334F, this.mContext)));
        BitmapDrawable localBitmapDrawable2 = new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(this.drawableByteCloseBtnImg, 0, this.drawableByteCloseBtnImg.length));
        this.mImgCloseButton.setImageDrawable(localBitmapDrawable2);
        this.mImgCloseButton.setClickable(true);
        this.mImgCloseButton.setOnClickListener(this);
        this.mNaviBar.addView(this.mImgSeperator);
        this.mNaviBar.addView(this.mImgCloseButton);
        this.mWholeView = new LinearLayout(this);
        this.mWholeView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.mWholeView.setOrientation(1);
        this.mWholeView.addView(this.mWebviewProgressbar);
        this.mWholeView.addView(this.mWebView);
        this.mWholeView.addView(this.mNaviBar);
        setContentView(this.mWholeView);
        return;
        this.mNaviBar.setBackgroundDrawable(localBitmapDrawable1);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private boolean loadBrowser(String paramString)
  {
    if ((paramString.length() <= 0) || (paramString.contentEquals("about:blank"))) {}
    do
    {
      do
      {
        return false;
        if (!paramString.startsWith("https://nid.naver.com")) {
          break;
        }
      } while ((!paramString.startsWith("https://nid.naver.com/mobile/user/help/idInquiry.nhn")) && (!paramString.startsWith("https://nid.naver.com/mobile/user/help/pwInquiry.nhn")) && (!paramString.startsWith("https://nid.naver.com/user/mobile_join.nhn")));
      return true;
    } while ((paramString.startsWith("https://nid.naver.com/nidlogin.logout")) || (paramString.startsWith("http://nid.naver.com/nidlogin.logout")) || (paramString.contains("/sso/logout.nhn")) || (paramString.contains("/sso/cross-domain.nhn")) || (paramString.contains("/sso/finalize.nhn")) || (paramString.startsWith("http://cc.naver.com")) || (paramString.startsWith("http://cr.naver.com")) || (paramString.startsWith("https://cert.vno.co.kr")) || (paramString.startsWith("https://ipin.ok-name.co.kr")) || (paramString.startsWith("https://ipin.siren24.com")));
    return true;
  }
  
  private void registerSizeChangeListener()
  {
    final LinearLayout localLinearLayout = this.mWholeView;
    localLinearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public void onGlobalLayout()
      {
        Rect localRect = new Rect();
        localLinearLayout.getWindowVisibleDisplayFrame(localRect);
        if (localLinearLayout.getRootView().getHeight() - (localRect.bottom - localRect.top) > 100)
        {
          OAuthLoginInAppBrowserActivity.this.mNaviBar.setVisibility(8);
          return;
        }
        OAuthLoginInAppBrowserActivity.this.mNaviBar.setVisibility(0);
      }
    });
  }
  
  private void runOnlyOnce()
  {
    if (getIntent() != null)
    {
      String str = getIntent().getStringExtra("agreeFormUrl");
      if (!TextUtils.isEmpty(str)) {
        this.mInOAuthUrl = str;
      }
      this.mWebViewContent = getIntent().getStringExtra("agreeFormContent");
    }
    if (TextUtils.isEmpty(this.mWebViewContent))
    {
      if (OAuthLoginDefine.DEVELOPER_VERSION) {
        Log.d("NaverLoginOAuth|OAuthLoginInAppBrowserActivity", "webview url -> " + this.mInOAuthUrl);
      }
      this.mWebView.loadUrl(this.mInOAuthUrl);
      return;
    }
    if (OAuthLoginDefine.DEVELOPER_VERSION)
    {
      Log.d("NaverLoginOAuth|OAuthLoginInAppBrowserActivity", "webview url -> " + this.mInOAuthUrl);
      Log.d("NaverLoginOAuth|OAuthLoginInAppBrowserActivity", "webview content -> " + this.mWebViewContent);
    }
    this.mWebView.loadDataWithBaseURL(this.mInOAuthUrl, this.mWebViewContent, "text/html", null, null);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.mImgCloseButton) {
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initData();
    initView(paramBundle);
    if (this.mFixActivityPortrait) {
      setRequestedOrientation(1);
    }
    registerSizeChangeListener();
    if ((paramBundle == null) || (!this.mIsLoginActivityStarted))
    {
      this.mIsLoginActivityStarted = true;
      runOnlyOnce();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.drawableByteBottomBackGroundImg = null;
    this.drawableByteCloseBtnImg = null;
    if (this.mWebView != null)
    {
      this.mWebView.stopLoading();
      if (this.mWholeView != null) {
        this.mWholeView.removeView(this.mWebView);
      }
      this.mWebView.removeAllViews();
      this.mWebView.destroy();
    }
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    if (paramBundle != null)
    {
      this.mIsLoginActivityStarted = paramBundle.getBoolean("IsLoginActivityStarted");
      this.mWebView.restoreState(paramBundle);
      this.mOAuthSdkVersion = paramBundle.getString("SdkVersionCalledFrom");
      this.mFixActivityPortrait = paramBundle.getBoolean("IsFixActivityPortrait");
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.mWebView != null) {
      this.mWebView.resumeTimers();
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("IsLoginActivityStarted", this.mIsLoginActivityStarted);
    this.mWebView.saveState(paramBundle);
    paramBundle.putString("SdkVersionCalledFrom", this.mOAuthSdkVersion);
    paramBundle.putBoolean("IsFixActivityPortrait", this.mFixActivityPortrait);
  }
  
  public class InAppBrowserJavascriptInterface
  {
    Context context;
    
    InAppBrowserJavascriptInterface(Context paramContext)
    {
      this.context = paramContext;
    }
    
    public void closeWebView()
    {
      ((Activity)this.context).finish();
    }
  }
  
  private class InAppWebChromeClient
    extends WebChromeClient
  {
    private InAppWebChromeClient() {}
    
    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      if (OAuthLoginInAppBrowserActivity.this.mWebviewProgressbar != null) {
        OAuthLoginInAppBrowserActivity.this.mWebviewProgressbar.setProgress(paramInt);
      }
    }
  }
  
  private class InAppWebViewClient
    extends WebViewClient
  {
    private String preUrl = "";
    
    public InAppWebViewClient() {}
    
    public void onFormResubmission(WebView paramWebView, Message paramMessage1, Message paramMessage2)
    {
      super.onFormResubmission(paramWebView, paramMessage1, paramMessage2);
    }
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      if (OAuthLoginInAppBrowserActivity.this.mWebviewProgressbar != null) {
        OAuthLoginInAppBrowserActivity.this.mWebviewProgressbar.setVisibility(8);
      }
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      if (OAuthLoginDefine.DEVELOPER_VERSION)
      {
        Log.d("NaverLoginOAuth|OAuthLoginInAppBrowserActivity", "[star] pre url : " + this.preUrl);
        Log.d("NaverLoginOAuth|OAuthLoginInAppBrowserActivity", "[star]     url : " + paramString);
      }
      if (OAuthWebviewUrlUtil.isFinalUrl(false, this.preUrl, paramString))
      {
        OAuthLoginInAppBrowserActivity.this.mWebView.stopLoading();
        OAuthLoginInAppBrowserActivity.this.finish();
      }
      do
      {
        return;
        if (OAuthWebviewUrlUtil.returnWhenAuthorizationDone(OAuthLoginInAppBrowserActivity.this.mContext, this.preUrl, paramString, OAuthLoginInAppBrowserActivity.this.mOAuthLoginData))
        {
          OAuthLoginInAppBrowserActivity.this.mWebView.stopLoading();
          return;
        }
        super.onPageStarted(paramWebView, paramString, paramBitmap);
      } while (OAuthLoginInAppBrowserActivity.this.mWebviewProgressbar == null);
      OAuthLoginInAppBrowserActivity.this.mWebviewProgressbar.setVisibility(0);
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      if (OAuthLoginInAppBrowserActivity.this.mWebviewProgressbar != null) {
        OAuthLoginInAppBrowserActivity.this.mWebviewProgressbar.setVisibility(8);
      }
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      if (OAuthLoginDefine.DEVELOPER_VERSION)
      {
        Log.d("NaverLoginOAuth|OAuthLoginInAppBrowserActivity", "[over] pre url : " + this.preUrl);
        Log.d("NaverLoginOAuth|OAuthLoginInAppBrowserActivity", "[over]     url : " + paramString);
      }
      if (OAuthWebviewUrlUtil.isFinalUrl(true, this.preUrl, paramString))
      {
        OAuthLoginInAppBrowserActivity.this.mWebView.stopLoading();
        OAuthLoginInAppBrowserActivity.this.finish();
      }
      while (OAuthWebviewUrlUtil.returnWhenAuthorizationDone(OAuthLoginInAppBrowserActivity.this.mContext, this.preUrl, paramString, OAuthLoginInAppBrowserActivity.this.mOAuthLoginData)) {
        return true;
      }
      if (OAuthLoginInAppBrowserActivity.this.loadBrowser(paramString))
      {
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setData(Uri.parse(paramString));
        OAuthLoginInAppBrowserActivity.this.startActivity(localIntent);
        return true;
      }
      paramWebView.loadUrl(paramString);
      this.preUrl = paramString;
      return true;
    }
  }
  
  public class OAuthLoginInAppBrowserInIntentData
  {
    public static final String INTENT_PARAM_KEY_AGREE_FORM_CONTENT = "agreeFormContent";
    public static final String INTENT_PARAM_KEY_AGREE_FORM_URL = "agreeFormUrl";
    public static final String INTENT_PARAM_KEY_APP_NAME = "app_name";
    public static final String INTENT_PARAM_KEY_CALLBACK_URL = "ClientCallbackUrl";
    public static final String INTENT_PARAM_KEY_CLIENT_ID = "ClientId";
    public static final String INTENT_PARAM_KEY_OAUTH_SDK_VERSION = "oauth_sdk_version";
    public static final String INTENT_PARAM_KEY_STATE = "state";
    
    public OAuthLoginInAppBrowserInIntentData() {}
  }
  
  public class OAuthLoginInAppBrowserOutIntentData
  {
    public static final String RESULT_CALLBACK = "RESULT_CALLBACK";
    
    public OAuthLoginInAppBrowserOutIntentData() {}
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nhn.android.naverlogin.ui.OAuthLoginInAppBrowserActivity
 * JD-Core Version:    0.7.0.1
 */