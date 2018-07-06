package com.appg.golfmon.atv.more;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.appg.golfmon.atv.AtvBase;
import com.appg.golfmon.atv.AtvShowPhoto;
import com.appg.golfmon.net.http.GFailedHandler;
import com.appg.golfmon.net.http.GJSONDecoder;
import com.appg.golfmon.net.http.GPClient;
import com.appg.golfmon.net.http.GResultHandler;
import com.appg.golfmon.util.Alert;
import com.appg.golfmon.util.Alert.OnCloseListener;
import com.appg.golfmon.util.FileUtil;
import com.appg.golfmon.util.FormatUtil;
import com.appg.golfmon.util.ImageDownLoader;
import com.appg.golfmon.util.ImageDownLoader.Mode;
import com.appg.golfmon.util.ImageUtil;
import com.appg.golfmon.util.InflateUtil;
import com.appg.golfmon.util.JSONUtil;
import com.appg.golfmon.util.ListenerUtil;
import com.appg.golfmon.util.LogUtil;
import com.appg.golfmon.util.SPUtil;
import com.appg.golfmon.view.GImageView;
import com.appg.golfmon.view.GImageView.Callback;
import com.appg.golfmon.view.GListView;
import com.appg.golfmon.view.GListView.GListAdapter;
import com.appg.golfmon.view.GListView.IMakeView;
import com.kakao.KakaoLink;
import com.kakao.KakaoParameterException;
import com.kakao.KakaoTalkLinkMessageBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import ra.genius.net.GBean;
import ra.genius.net.GExecutor;

public class AtvNoticeDetail
  extends AtvBase
  implements GListView.IMakeView
{
  private String LOGO_IMG_URL = "http://115.68.14.78/upload_img/";
  private EditText etComment = null;
  private KakaoLink kakaoLink1;
  private KakaoTalkLinkMessageBuilder kakaoTalkLinkMessageBuilder1;
  private LinearLayout mBaseHeader = null;
  private LinearLayout mFoot = null;
  private ScrollView mHeader = null;
  private ImageDownLoader mImageDownLoader;
  private GImageView mImg1 = null;
  private GImageView mImg2 = null;
  private GImageView mImg3 = null;
  private GListView mList = null;
  private int mMyUserNo = -10;
  private JSONObject mNoticeInfo = null;
  private String mNoticeNo = null;
  private TextView mTxtContent = null;
  private TextView mTxtTitle = null;
  private JSONObject mUserInfo = null;
  private int sortType = 0;
  private TextView txtC = null;
  private TextView txtNew = null;
  private TextView txtOld = null;
  private TextView txtSend = null;
  
  private void callApi_Comment(String paramString)
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("Api.insOfReply");
    localGPClient.addParameter("no", JSONUtil.getString(this.mNoticeInfo, "no", ""));
    localGPClient.addParameter("note", paramString);
    localGPClient.addParameter("userno", Integer.valueOf(this.mMyUserNo));
    localGPClient.addParameter("nick_name", JSONUtil.getString(this.mUserInfo, "nick_name", ""));
    localGPClient.setDecoder(new GJSONDecoder(3));
    localGPClient.addProgress();
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvNoticeDetail.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        if (paramAnonymousInt > 0) {
          AtvNoticeDetail.this.callApi_getInfoOfNotice();
        }
        new Alert().showAlert(AtvNoticeDetail.this.getContext(), paramAnonymousString);
        return null;
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  private void callApi_ReComment(JSONObject paramJSONObject, String paramString)
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("Api.insOfRReply");
    localGPClient.addParameter("no", JSONUtil.getString(paramJSONObject, "notice_fk", ""));
    localGPClient.addParameter("parent_fk", JSONUtil.getString(paramJSONObject, "parent_fk", ""));
    localGPClient.addParameter("parent_user_fk", JSONUtil.getString(paramJSONObject, "parent_user_fk", ""));
    localGPClient.addParameter("parent_user_nick", JSONUtil.getString(paramJSONObject, "parent_user_nick", ""));
    localGPClient.addParameter("note", paramString);
    localGPClient.addParameter("userno", Integer.valueOf(this.mMyUserNo));
    localGPClient.addParameter("nick_name", JSONUtil.getString(this.mUserInfo, "nick_name", ""));
    localGPClient.setDecoder(new GJSONDecoder(3));
    localGPClient.addProgress();
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvNoticeDetail.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        if (paramAnonymousInt > 0) {
          AtvNoticeDetail.this.callApi_getInfoOfNotice();
        }
        new Alert().showAlert(AtvNoticeDetail.this.getContext(), paramAnonymousString);
        return null;
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  private void callApi_deleteComment(JSONObject paramJSONObject)
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("Api.delOfReply");
    localGPClient.addParameter("no", JSONUtil.getString(paramJSONObject, "no", ""));
    localGPClient.setDecoder(new GJSONDecoder(3));
    localGPClient.addProgress();
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvNoticeDetail.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        if (paramAnonymousInt > 0) {
          AtvNoticeDetail.this.callApi_getInfoOfNotice();
        }
        new Alert().showAlert(AtvNoticeDetail.this.getContext(), paramAnonymousString);
        return null;
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  private void callApi_getInfoOfNotice()
  {
    this.mList.removeAll();
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("Api.getInfoOfNotice");
    localGPClient.addParameter("userno", Integer.valueOf(this.mMyUserNo));
    localGPClient.addParameter("no", JSONUtil.getString(this.mNoticeInfo, "no", ""));
    if (this.sortType == 0) {
      localGPClient.addParameter("sorttype", "old");
    }
    for (;;)
    {
      localGPClient.setDecoder(new GJSONDecoder(1));
      localGPClient.addProgress();
      localGPClient.addHandler(new GFailedHandler()
      {
        public void failedExecute(GBean paramAnonymousGBean)
        {
          Alert.toastLong(AtvNoticeDetail.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
        }
      });
      localGPClient.addHandler(new GResultHandler()
      {
        public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          AtvNoticeDetail.this.setResult(-1);
          if (paramAnonymousInt > 0)
          {
            AtvNoticeDetail.this.mUserInfo = JSONUtil.getJSONObject(paramAnonymousJSONObject, "entityUser");
            AtvNoticeDetail.this.mNoticeInfo = JSONUtil.getJSONObject(paramAnonymousJSONObject, "entity");
            AtvNoticeDetail.this.setData();
            AtvNoticeDetail.this.mList.addItems(JSONUtil.getJSONArray(paramAnonymousJSONObject, "entityComment"));
            AtvNoticeDetail.this.mList.refresh();
            AtvNoticeDetail.this.txtC.setText(AtvNoticeDetail.this.mList.getCount());
          }
          for (;;)
          {
            return null;
            Alert.toastLong(AtvNoticeDetail.this.getContext(), paramAnonymousString);
            AtvNoticeDetail.this.finish();
          }
        }
      });
      GExecutor.getInstance().execute(localGPClient);
      return;
      localGPClient.addParameter("sorttype", "new");
    }
  }
  
  private String getSharedMessage()
  {
    return "할인부킹ᆞ조인라운드 골프몬 앱을 추천합니다.\nhttp://gil.cc/84Z3".replaceAll("<999>", JSONUtil.getString(SPUtil.getInstance().getUserInfo(this), "nick_name", ""));
  }
  
  private void setData()
  {
    String str1 = JSONUtil.getString(this.mNoticeInfo, "title", "");
    if (this.sortType == 0)
    {
      this.txtOld.setTextColor(-13421773);
      this.txtNew.setTextColor(-7105907);
    }
    for (;;)
    {
      this.mTxtTitle.setText(str1);
      this.mTxtContent.setText(JSONUtil.getString(this.mNoticeInfo, "content", ""));
      String str2 = JSONUtil.getString(this.mNoticeInfo, "img1", "");
      String str3 = JSONUtil.getString(this.mNoticeInfo, "img2", "");
      String str4 = JSONUtil.getString(this.mNoticeInfo, "img3", "");
      setImageView(this.mImg1, str2, "upload_img");
      setImageView(this.mImg2, str3, "upload_img");
      setImageView(this.mImg3, str4, "upload_img");
      return;
      this.txtOld.setTextColor(-7105907);
      this.txtNew.setTextColor(-13421773);
    }
  }
  
  protected void configureListener()
  {
    this.mTxtTopTitleLeftBack.setOnClickListener(ListenerUtil.getFinishButtonListener(getContext()));
  }
  
  protected void findView()
  {
    this.sortType = 0;
    this.mList = ((GListView)findViewById(2131361864));
    this.mBaseHeader = new LinearLayout(getContext());
    this.mFoot = ((LinearLayout)InflateUtil.inflate(getContext(), 2130903092, null));
    this.mList.addHeaderView(this.mBaseHeader);
    this.mList.addFooterView(this.mFoot);
    this.mHeader = ((ScrollView)InflateUtil.inflate(getContext(), 2130903079, null));
    this.mBaseHeader.addView(this.mHeader);
    this.mTxtTitle = ((TextView)this.mHeader.findViewById(2131361872));
    this.mTxtContent = ((TextView)this.mHeader.findViewById(2131361877));
    this.mImg1 = ((GImageView)this.mHeader.findViewById(2131361878));
    this.mImg2 = ((GImageView)this.mHeader.findViewById(2131361879));
    this.mImg3 = ((GImageView)this.mHeader.findViewById(2131361880));
    this.txtC = ((TextView)this.mHeader.findViewById(2131361942));
    this.txtOld = ((TextView)this.mHeader.findViewById(2131361943));
    this.txtOld.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvNoticeDetail.this.sortType = 0;
        AtvNoticeDetail.this.callApi_getInfoOfNotice();
      }
    });
    this.txtNew = ((TextView)this.mHeader.findViewById(2131361944));
    this.txtNew.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvNoticeDetail.this.sortType = 1;
        AtvNoticeDetail.this.callApi_getInfoOfNotice();
      }
    });
    this.etComment = ((EditText)this.mFoot.findViewById(2131361939));
    this.txtSend = ((TextView)this.mFoot.findViewById(2131361940));
    this.txtSend.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvNoticeDetail.this.callApi_Comment(AtvNoticeDetail.this.etComment.getText().toString());
      }
    });
    getWindow().setSoftInputMode(3);
  }
  
  protected boolean getBundle()
  {
    LogUtil.intent("AtvNoticeDetail", getIntent());
    this.mMyUserNo = JSONUtil.getInteger(SPUtil.getInstance().getUserInfo(getContext()), "no", -10);
    this.mNoticeInfo = JSONUtil.createObject(getIntent(), "EXTRAS_JSON_STRING");
    this.mNoticeNo = JSONUtil.getString(this.mNoticeInfo, "no", "");
    return !FormatUtil.isNullorEmpty(this.mNoticeNo);
  }
  
  protected void init()
  {
    this.mTxtTopTitleLeftBack.setVisibility(0);
    this.mTxtTopTitleLeftBack.setText("공지사항");
    this.mImageDownLoader = new ImageDownLoader(this);
    this.mImageDownLoader.setMode(ImageDownLoader.Mode.CORRECT);
    this.mList.setViewMaker(2130903091, this);
    callApi_getInfoOfNotice();
  }
  
  public View makeView(GListView.GListAdapter paramGListAdapter, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    final JSONObject localJSONObject = (JSONObject)paramGListAdapter.getItem(paramInt);
    ImageView localImageView = (ImageView)paramView.findViewById(2131362068);
    TextView localTextView1 = (TextView)paramView.findViewById(2131361869);
    TextView localTextView2 = (TextView)paramView.findViewById(2131361873);
    TextView localTextView3 = (TextView)paramView.findViewById(2131362069);
    ImageButton localImageButton = (ImageButton)paramView.findViewById(2131362011);
    TextView localTextView4 = (TextView)paramView.findViewById(2131362070);
    TextView localTextView5 = (TextView)paramView.findViewById(2131362071);
    int i = JSONUtil.getInteger(localJSONObject, "user_fk", -70);
    if (JSONUtil.getInteger(localJSONObject, "no", -70) == JSONUtil.getInteger(localJSONObject, "parent_fk", -70))
    {
      localImageView.setVisibility(8);
      localTextView4.setVisibility(8);
      localTextView1.setText(JSONUtil.getString(localJSONObject, "nick_name", ""));
      if (this.mMyUserNo != i) {
        break label306;
      }
    }
    label306:
    for (int j = 0;; j = 4)
    {
      localImageButton.setVisibility(j);
      if ((SPUtil.getInstance().getIsOnAppAdmin(getContext())) && (SPUtil.getInstance().getUserType(getContext()).equals("2"))) {
        localImageButton.setVisibility(0);
      }
      localTextView2.setText(FormatUtil.getDateConvert(JSONUtil.getString(localJSONObject, "regist_dt", ""), "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd"));
      localTextView5.setText(JSONUtil.getString(localJSONObject, "comment", ""));
      localTextView3.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Alert localAlert = new Alert();
          localAlert.setOnCloseListener(new Alert.OnCloseListener()
          {
            public void onClose(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int, Object paramAnonymous2Object)
            {
              if (1 == paramAnonymous2Int)
              {
                AtvNoticeDetail.this.setResult(-1);
                AtvNoticeDetail.this.callApi_ReComment(this.val$json, (String)paramAnonymous2Object);
              }
            }
          });
          localAlert.showEditAlert(AtvNoticeDetail.this.getContext(), "덧글작성", "입력하시겠습니까?", true, new String[] { "전송", "취소" });
        }
      });
      localImageButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Alert localAlert = new Alert();
          localAlert.setOnCloseListener(new Alert.OnCloseListener()
          {
            public void onClose(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int, Object paramAnonymous2Object)
            {
              if (1 == paramAnonymous2Int)
              {
                AtvNoticeDetail.this.setResult(-1);
                AtvNoticeDetail.this.callApi_deleteComment(this.val$json);
              }
            }
          });
          localAlert.showAlert(AtvNoticeDetail.this.getContext(), "삭제하시겠습니까?", true, new String[] { "삭제", "취소" });
        }
      });
      return paramView;
      localImageView.setVisibility(0);
      localTextView4.setText(JSONUtil.getString(localJSONObject, "parent_user_nick", ""));
      break;
    }
  }
  
  void sendKakaoTalk()
  {
    try
    {
      this.kakaoLink1.sendMessage(this.kakaoTalkLinkMessageBuilder1.build(), this);
      return;
    }
    catch (KakaoParameterException localKakaoParameterException)
    {
      localKakaoParameterException.printStackTrace();
    }
  }
  
  public void setImageView(final GImageView paramGImageView, String paramString1, String paramString2)
  {
    final String str = "RS" + paramString2 + FileUtil.getFileName(paramString1);
    paramGImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    if (FormatUtil.isNullorEmpty(paramString1))
    {
      paramGImageView.setTag(null);
      paramGImageView.setVisibility(8);
    }
    for (;;)
    {
      paramGImageView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          JSONArray localJSONArray = new JSONArray();
          for (int i = 1;; i++)
          {
            if (i > 3)
            {
              if (localJSONArray.length() > 0)
              {
                Intent localIntent = new Intent(AtvNoticeDetail.this.getContext(), AtvShowPhoto.class);
                localIntent.putExtra("EXTRAS_TYPE", 200);
                localIntent.putExtra("EXTRAS_JSON_STRING", localJSONArray.toString());
                localIntent.putExtra("EXTRAS_POSITION", 0);
                AtvNoticeDetail.this.startActivity(localIntent);
              }
              return;
            }
            String str = JSONUtil.getString(AtvNoticeDetail.this.mNoticeInfo, "img" + i, "");
            if (!FormatUtil.isNullorEmpty(str))
            {
              JSONObject localJSONObject = new JSONObject();
              JSONUtil.put(localJSONObject, "imagePath", str);
              localJSONArray.put(localJSONObject);
            }
          }
        }
      });
      return;
      if (!str.equals(paramGImageView.getTag()))
      {
        paramGImageView.setTag(str);
        paramGImageView.setVisibility(8);
        paramGImageView.setCallback(new GImageView.Callback()
        {
          public void callback(int paramAnonymousInt, Object paramAnonymousObject, Bitmap paramAnonymousBitmap)
          {
            if ((!FormatUtil.isNullorEmpty((String)paramGImageView.getTag())) && (paramAnonymousInt == 1) && (str.equals((String)paramAnonymousObject)) && (paramAnonymousBitmap != null))
            {
              paramGImageView.setImageBitmap(paramAnonymousBitmap);
              paramGImageView.setVisibility(0);
              paramGImageView.setTag(paramAnonymousObject);
              paramGImageView.getLayoutParams().height = ((int)(paramAnonymousBitmap.getHeight() / paramAnonymousBitmap.getWidth() * (AtvNoticeDetail.this.mDeviceSize[0] - ImageUtil.dipToPixel(AtvNoticeDetail.this.getContext(), 30.0F))));
              return;
            }
            paramGImageView.setVisibility(8);
            paramGImageView.setTag(null);
          }
        });
        paramGImageView.setImageURLCache("http://115.68.14.78/" + paramString2 + "/" + paramString1, str);
      }
    }
  }
  
  protected void setView()
  {
    setView(2130903050);
    try
    {
      this.kakaoLink1 = KakaoLink.getKakaoLink(getApplicationContext());
      this.kakaoTalkLinkMessageBuilder1 = this.kakaoLink1.createKakaoTalkLinkMessageBuilder();
      return;
    }
    catch (KakaoParameterException localKakaoParameterException)
    {
      localKakaoParameterException.printStackTrace();
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.atv.more.AtvNoticeDetail
 * JD-Core Version:    0.7.0.1
 */