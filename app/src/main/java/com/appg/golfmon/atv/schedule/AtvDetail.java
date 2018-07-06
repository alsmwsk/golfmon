package com.appg.golfmon.atv.schedule;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TableRow;
import android.widget.TextView;
import com.appg.golfmon.atv.AtvBase;
import com.appg.golfmon.atv.AtvMapShow;
import com.appg.golfmon.atv.AtvShowPhoto;
import com.appg.golfmon.atv.more.AtvMyRegist;
import com.appg.golfmon.net.http.GFailedHandler;
import com.appg.golfmon.net.http.GJSONDecoder;
import com.appg.golfmon.net.http.GPClient;
import com.appg.golfmon.net.http.GResultHandler;
import com.appg.golfmon.util.Alert;
import com.appg.golfmon.util.Alert.OnCloseListener;
import com.appg.golfmon.util.FormatUtil;
import com.appg.golfmon.util.ImageDownLoader;
import com.appg.golfmon.util.ImageDownLoader.Mode;
import com.appg.golfmon.util.InflateUtil;
import com.appg.golfmon.util.JSONUtil;
import com.appg.golfmon.util.ListenerUtil;
import com.appg.golfmon.util.LogUtil;
import com.appg.golfmon.util.SPUtil;
import com.appg.golfmon.view.GImageView;
import com.appg.golfmon.view.GListView;
import com.appg.golfmon.view.GListView.GListAdapter;
import com.appg.golfmon.view.GListView.IMakeView;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONObject;
import ra.genius.net.GBean;
import ra.genius.net.GExecutor;

public class AtvDetail
  extends AtvBase
  implements GListView.IMakeView
{
  public static final int REQ_CODE = 7890;
  public static final String YAR_INSTALL_URL = "market://details?id=co.sorf.apps.voya";
  public static final String YAR_PACKAGE_NAME = "co.sorf.apps.voya";
  private String LOGO_IMG_URL = "http://115.68.14.78/upload_img/";
  private Button btnYar1 = null;
  private Button btnYar2 = null;
  private ImageView ivThum = null;
  private LinearLayout llSMS = null;
  private LinearLayout mBaseBtns = null;
  private LinearLayout mBaseGoodCount = null;
  private LinearLayout mBaseHeader = null;
  private LinearLayout mBasePeople = null;
  private LinearLayout mBaseRequest = null;
  private Button mBtnDel = null;
  private Button mBtnModify = null;
  private LinearLayout mBtnRequest = null;
  private Button mBtnWarn = null;
  private LinearLayout mBtnWriteRounding = null;
  private JSONObject mGolfInfo = null;
  private LinearLayout mHeader = null;
  private ImageDownLoader mImageDownLoader;
  private ImageView mImgGoodCount = null;
  private boolean mIsOwner = false;
  private View mLineRequest2 = null;
  private View mLineRequest3 = null;
  private GListView mList = null;
  private JSONObject mMPointInfo = null;
  private int mMyUserNo = -10;
  private JSONArray mReqArray = null;
  private int mTransferJoinID = 0;
  private JSONObject mTransferJoinInfo = null;
  private int mTransferJoinTypeID = 0;
  private TextView mTxtApplyMessage = null;
  private TextView mTxtCouple = null;
  private TextView mTxtDescription = null;
  private TextView mTxtFee = null;
  private TextView mTxtGolf = null;
  private TextView mTxtGoodCount = null;
  private TextView mTxtID = null;
  private TextView mTxtLocation = null;
  private TextView mTxtNickName = null;
  private TextView mTxtPeople = null;
  private TextView mTxtRequestJoin = null;
  private TextView mTxtRequestTrasfer = null;
  private TextView mTxtSubTitleRequest = null;
  private TextView mTxtSubTitleRounding = null;
  private TextView mTxtTeeUp = null;
  private JSONObject mUserInfo = null;
  private TextView txtCount = null;
  private TextView txtHole = null;
  private TextView txtName = null;
  
  private void callApi_cancelTransferJoin()
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("ApiTransferJoin.cancelTransferJoin");
    localGPClient.addParameter("transferJoinID", Integer.valueOf(this.mTransferJoinID));
    localGPClient.setDecoder(new GJSONDecoder(3));
    localGPClient.addProgress();
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvDetail.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        if (paramAnonymousInt > 0)
        {
          AtvDetail.this.setResult(-1);
          AtvDetail.this.mReqArray = JSONUtil.getJSONArray(paramAnonymousJSONObject, "entityReq");
          AtvDetail.this.setDataRequest();
        }
        new Alert().showAlert(AtvDetail.this.getContext(), paramAnonymousString);
        return null;
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  private void callApi_deleteComment(JSONObject paramJSONObject)
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("ApiTransferJoin.deleteComment");
    localGPClient.addParameter("no", JSONUtil.getString(paramJSONObject, "no", ""));
    localGPClient.setDecoder(new GJSONDecoder(3));
    localGPClient.addProgress();
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvDetail.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        if (paramAnonymousInt > 0) {
          AtvDetail.this.callApi_getInfoOfTransferJoin();
        }
        new Alert().showAlert(AtvDetail.this.getContext(), paramAnonymousString);
        return null;
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  private void callApi_deleteTransferJoin()
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("ApiTransferJoin.deleteTransferJoin");
    localGPClient.addParameter("transferJoinID", Integer.valueOf(this.mTransferJoinID));
    localGPClient.setDecoder(new GJSONDecoder(3));
    localGPClient.addProgress();
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvDetail.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
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
            if ((paramAnonymousInt > 0) || (paramAnonymousInt == -10))
            {
              AtvDetail.this.setResult(-1);
              AtvDetail.this.finish();
            }
          }
        });
        localAlert.showAlert(AtvDetail.this.getContext(), paramAnonymousString);
        return null;
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  private void callApi_finishTransferJoin()
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("ApiTransferJoin.finishTransferJoin");
    localGPClient.addParameter("transferJoinID", Integer.valueOf(this.mTransferJoinID));
    localGPClient.setDecoder(new GJSONDecoder(3));
    localGPClient.addProgress();
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvDetail.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
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
              AtvDetail.this.setResult(-1);
              AtvDetail.this.finish();
            }
          }
        });
        localAlert.showAlert(AtvDetail.this.getContext(), paramAnonymousString);
        return null;
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  private void callApi_getInfoOfTransferJoin()
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("ApiTransferJoin.getInfoOfTransferJoin");
    localGPClient.addParameter("transferJoinID", Integer.valueOf(this.mTransferJoinID));
    localGPClient.setDecoder(new GJSONDecoder(1));
    localGPClient.addProgress();
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvDetail.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        if (paramAnonymousInt > 0)
        {
          AtvDetail.this.mMPointInfo = JSONUtil.getJSONObject(paramAnonymousJSONObject, "entityMP");
          AtvDetail.this.mUserInfo = JSONUtil.getJSONObject(paramAnonymousJSONObject, "entityUser");
          AtvDetail.this.mGolfInfo = JSONUtil.getJSONObject(paramAnonymousJSONObject, "entityGolf");
          AtvDetail.this.mTransferJoinInfo = ((JSONObject)paramAnonymousObject);
          AtvDetail.this.mReqArray = JSONUtil.getJSONArray(paramAnonymousJSONObject, "entityReq");
          AtvDetail.this.setDataInfo();
          AtvDetail.this.mList.removeAll();
          AtvDetail.this.mList.addItems(JSONUtil.getJSONArray(paramAnonymousJSONObject, "entityComment"));
        }
        for (;;)
        {
          return null;
          AtvDetail.this.finish();
        }
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  private void callApi_reqTransferJoin()
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("ApiTransferJoin.reqTransferJoin");
    localGPClient.addParameter("transferJoinID", Integer.valueOf(this.mTransferJoinID));
    localGPClient.setDecoder(new GJSONDecoder(3));
    localGPClient.addProgress();
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvDetail.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        if (paramAnonymousInt > 0)
        {
          AtvDetail.this.mReqArray = JSONUtil.getJSONArray(paramAnonymousJSONObject, "entityReq");
          AtvDetail.this.setResult(-1);
          AtvDetail.this.setDataRequest();
        }
        new Alert().showAlert(AtvDetail.this.getContext(), paramAnonymousString);
        return null;
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  private void callApi_updateReqTransferJoin(int paramInt1, final int paramInt2)
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("ApiTransferJoin.updateReqTransferJoin");
    localGPClient.addParameter("transferJoinID", Integer.valueOf(this.mTransferJoinID));
    localGPClient.addParameter("reqID", Integer.valueOf(paramInt1));
    localGPClient.addParameter("reqTypeID", Integer.valueOf(paramInt2));
    localGPClient.setDecoder(new GJSONDecoder(3));
    localGPClient.addProgress();
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvDetail.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        if (paramAnonymousInt > 0)
        {
          AtvDetail.this.mReqArray = JSONUtil.getJSONArray(paramAnonymousJSONObject, "entityReq");
          AtvDetail.this.setDataRequest();
          if ((AtvDetail.this.mTransferJoinTypeID == 2) && (paramInt2 == 2))
          {
            Alert localAlert = new Alert();
            localAlert.setOnCloseListener(new Alert.OnCloseListener()
            {
              public void onClose(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int, Object paramAnonymous2Object)
              {
                if (1 == paramAnonymous2Int) {
                  AtvDetail.this.callApi_finishTransferJoin();
                }
              }
            });
            localAlert.showAlert(AtvDetail.this.getContext(), "조인이 수락되었습니다. 성원이 되었으면 아래를 클릭해 주세요.", true, new String[] { "조인마감", "계속조인" });
          }
        }
        for (;;)
        {
          return null;
          new Alert().showAlert(AtvDetail.this.getContext(), paramAnonymousString);
          continue;
          new Alert().showAlert(AtvDetail.this.getContext(), paramAnonymousString);
        }
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  private void callApi_updateWCounts()
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("ApiTransferJoin.updateWCounts");
    localGPClient.addParameter("transferJoinID", Integer.valueOf(this.mTransferJoinID));
    localGPClient.setDecoder(new GJSONDecoder(3));
    localGPClient.addProgress();
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvDetail.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        if (paramAnonymousInt > 0) {
          AtvDetail.this.callApi_getInfoOfTransferJoin();
        }
        new Alert().showAlert(AtvDetail.this.getContext(), paramAnonymousString);
        return null;
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  private String getDate(Calendar paramCalendar)
  {
    if (paramCalendar == null) {
      return "";
    }
    return FormatUtil.getDateCalendarToString(paramCalendar, "MM/dd") + "(" + FormatUtil.getDateDayOfWeek(paramCalendar, false) + ") " + FormatUtil.getDateCalendarToString(paramCalendar, "HH:mm");
  }
  
  private void setDataInfo()
  {
    this.mHeader.setVisibility(0);
    this.mTxtTopTitleLeftBack.setVisibility(0);
    this.mTxtTopTitleRegistDT.setVisibility(0);
    this.mTxtTopTitleRegistDT.setText("등록일시\n");
    Calendar localCalendar1 = FormatUtil.getDateStringToCalendar(JSONUtil.getString(this.mTransferJoinInfo, "registDT", ""), "yyyy-MM-dd HH:mm:ss");
    this.mTxtTopTitleRegistDT.append(FormatUtil.getDateCalendarToString(localCalendar1, "yyyy/MM/dd"));
    this.mTxtTopTitleRegistDT.append("(" + FormatUtil.getDateDayOfWeek(localCalendar1, false) + ") ");
    this.mTxtTopTitleRegistDT.append(FormatUtil.getDateCalendarToString(localCalendar1, "HH:mm"));
    this.mTransferJoinTypeID = JSONUtil.getInteger(this.mTransferJoinInfo, "transferJoinTypeID", 0);
    boolean bool;
    int i;
    int k;
    label291:
    label327:
    LinearLayout localLinearLayout;
    label377:
    int m;
    label422:
    label498:
    double d;
    if (JSONUtil.getInteger(this.mUserInfo, "no", -200) == this.mMyUserNo)
    {
      bool = true;
      this.mIsOwner = bool;
      this.mTxtID.setText(FormatUtil.toPhoneNumber(JSONUtil.getString(this.mUserInfo, "phone", "")));
      this.mTxtNickName.setText("등록자 : " + JSONUtil.getString(this.mUserInfo, "nick_name", ""));
      i = JSONUtil.getInteger(this.mUserInfo, "wCount", 0);
      int j = JSONUtil.getInteger(this.mUserInfo, "mStatusTypeID", 0);
      k = JSONUtil.getInteger(this.mUserInfo, "uStatusTypeID", 0);
      if (j != 2) {
        break label891;
      }
      this.mBaseGoodCount.setVisibility(0);
      JSONUtil.getInteger(this.mMPointInfo, "grade", 0);
      this.mImgGoodCount.setImageResource(2130837635);
      this.mTxtGoodCount.setVisibility(8);
      this.mTxtGoodCount.setText(FormatUtil.toPriceFormat(i));
      if (k != 2) {
        break label902;
      }
      this.mBtnWarn.setVisibility(8);
      localLinearLayout = (LinearLayout)this.mHeader.findViewById(2131362009);
      if ((!this.mIsOwner) || (i != 1)) {
        break label948;
      }
      ((TextView)localLinearLayout.findViewById(2131362010)).setText("불량정보로 신고되었습니다. 유효한 정보로 수정하시면 신고내역이 초기화됩니다.");
      localLinearLayout.setVisibility(0);
      if (this.mTransferJoinTypeID != 1) {
        break label972;
      }
      this.mTxtTopTitleLeftBack.setText("Tee 양도");
      this.mTxtSubTitleRequest.setText("양도 요청 List");
      this.mTxtRequestTrasfer.setVisibility(0);
      this.mTxtRequestJoin.setVisibility(8);
      if ((!this.mIsOwner) && ((!SPUtil.getInstance().getIsOnAppAdmin(getContext())) || (!SPUtil.getInstance().getUserType(getContext()).equals("2")))) {
        break label1012;
      }
      this.mBaseBtns.setVisibility(0);
      this.mLineRequest3.setVisibility(8);
      this.mTxtRequestTrasfer.setText("양도 마감");
      this.mTxtRequestJoin.setText("조인 마감");
      this.txtCount.setText("조회수:" + JSONUtil.getString(this.mTransferJoinInfo, "readCount", ""));
      this.txtName.setText(JSONUtil.getString(this.mTransferJoinInfo, "name", ""));
      this.mTxtGolf.setText(JSONUtil.getString(this.mTransferJoinInfo, "name", ""));
      Calendar localCalendar2 = FormatUtil.getDateStringToCalendar(JSONUtil.getString(this.mTransferJoinInfo, "dates", ""), "yyyy-MM-dd HH:mm:ss");
      this.mTxtTeeUp.setText(getDate(localCalendar2));
      m = JSONUtil.getInteger(this.mTransferJoinInfo, "hole", 0);
      switch (m)
      {
      default: 
        label648:
        this.txtHole.setText(m + "홀");
        this.mTxtLocation.setText(JSONUtil.getString(this.mTransferJoinInfo, "address", ""));
        this.mTxtLocation.setPaintFlags(0x8 | this.mTxtLocation.getPaintFlags());
        d = JSONUtil.getDouble(this.mTransferJoinInfo, "greenFee", 0.0D);
        if (d % 10000.0D == 0.0D)
        {
          this.mTxtFee.setText((int)(d / 10000.0D) + "만원");
          label770:
          if (this.mTransferJoinTypeID != 1) {
            break label1114;
          }
          this.mBasePeople.setVisibility(8);
        }
        break;
      }
    }
    for (;;)
    {
      this.mTxtDescription.setText(JSONUtil.getString(this.mTransferJoinInfo, "contents", ""));
      this.ivThum = ((ImageView)findViewById(2131361868));
      String str = JSONUtil.getString(this.mTransferJoinInfo, "logo_img", "");
      if (!FormatUtil.isNullorEmpty(str)) {
        this.mImageDownLoader.download(this.ivThum, this.LOGO_IMG_URL + str);
      }
      setDataRequest();
      setDataScore();
      return;
      bool = false;
      break;
      label891:
      this.mBaseGoodCount.setVisibility(4);
      break label291;
      label902:
      if (k != 0) {
        break label327;
      }
      if (1 == JSONUtil.getInteger(this.mUserInfo, "isWarning", 0))
      {
        this.mBtnWarn.setText("불량정보 신고취소");
        break label327;
      }
      this.mBtnWarn.setText("불량정보신고");
      break label327;
      label948:
      if (i >= 1)
      {
        localLinearLayout.setVisibility(0);
        break label377;
      }
      localLinearLayout.setVisibility(8);
      break label377;
      label972:
      this.mTxtTopTitleLeftBack.setText("라운드 조인");
      this.mTxtSubTitleRequest.setText("조인 요청 List");
      this.mTxtRequestTrasfer.setVisibility(8);
      this.mTxtRequestJoin.setVisibility(0);
      break label422;
      label1012:
      this.mBaseBtns.setVisibility(8);
      this.mLineRequest3.setVisibility(0);
      this.mTxtRequestTrasfer.setText("양도 요청");
      this.mTxtRequestJoin.setText("조인 요청");
      break label498;
      m = 18;
      break label648;
      m = 27;
      break label648;
      m = 36;
      break label648;
      TextView localTextView = this.mTxtFee;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Double.valueOf(d / 10000.0D);
      localTextView.setText(String.format("%.1f만원", arrayOfObject));
      break label770;
      label1114:
      this.mBasePeople.setVisibility(0);
      this.mTxtPeople.setText("요청인원 : " + FormatUtil.toPriceFormat(JSONUtil.getInteger(this.mTransferJoinInfo, "counts", 0)) + "명");
      switch (JSONUtil.getInteger(this.mTransferJoinInfo, "joinTypeStr", 0))
      {
      default: 
        this.mTxtCouple.setText("");
        break;
      case 1: 
        this.mTxtCouple.setText("남녀무관");
        break;
      case 2: 
        this.mTxtCouple.setText("부부/커플");
        break;
      case 3: 
        this.mTxtCouple.setText("남자");
        break;
      case 4: 
        this.mTxtCouple.setText("여자");
      }
    }
  }
  
  private void setDataRequest()
  {
    this.mBaseRequest.removeAllViews();
    this.mTxtApplyMessage.setVisibility(8);
    this.mBtnRequest.setVisibility(8);
    int i = 0;
    if ((this.mReqArray == null) || (i >= this.mReqArray.length()))
    {
      if (this.mBaseRequest.getChildCount() <= 0) {
        break label208;
      }
      this.mTxtSubTitleRequest.setVisibility(0);
      this.mLineRequest2.setVisibility(0);
      this.mLineRequest3.setVisibility(0);
      this.mBaseRequest.getChildAt(-1 + this.mBaseRequest.getChildCount()).findViewById(2131362057).setVisibility(8);
      if (this.mIsOwner) {
        break label197;
      }
      this.mLineRequest3.setVisibility(8);
      this.mBtnRequest.setVisibility(8);
    }
    for (;;)
    {
      if ("2".equals(JSONUtil.getString(this.mTransferJoinInfo, "isApply", "")))
      {
        this.mBtnRequest.setVisibility(8);
        this.mTxtApplyMessage.setVisibility(0);
        this.mBtnModify.setVisibility(0);
      }
      return;
      setDataRequest(JSONUtil.getJSONObject(this.mReqArray, i));
      i++;
      break;
      label197:
      this.mBtnRequest.setVisibility(0);
      continue;
      label208:
      this.mTxtSubTitleRequest.setVisibility(8);
      this.mLineRequest2.setVisibility(8);
      this.mLineRequest3.setVisibility(8);
      this.mBtnRequest.setVisibility(0);
    }
  }
  
  private void setDataRequest(JSONObject paramJSONObject)
  {
    LogUtil.json("req", paramJSONObject);
    final int i = JSONUtil.getInteger(paramJSONObject, "user_fk", -30);
    if ((!this.mIsOwner) && (i != this.mMyUserNo)) {
      return;
    }
    final int j = JSONUtil.getInteger(paramJSONObject, "reqID", 0);
    int k = JSONUtil.getInteger(paramJSONObject, "reqTypeID", 0);
    JSONUtil.getString(paramJSONObject, "nick_name", "");
    String str1 = JSONUtil.getString(paramJSONObject, "name", "");
    final String str2 = FormatUtil.toPhoneNumber(JSONUtil.getString(paramJSONObject, "phone", ""));
    String str3 = FormatUtil.getDateConvert(JSONUtil.getString(paramJSONObject, "registDT", ""), "yyyy-MM-dd HH:mm:ss", "MM/dd HH:mm");
    String str4 = String.format("%s %s (%s)", new Object[] { str3, str1, str2 });
    if (i == this.mMyUserNo) {
      str4 = String.format("%s 요청되었습니다.", new Object[] { str3 });
    }
    final String str5 = str4;
    View localView = InflateUtil.inflate(getContext(), 2130903083, null);
    TextView localTextView = (TextView)localView.findViewById(2131362053);
    Button localButton = (Button)localView.findViewById(2131362056);
    localView.findViewById(2131362057).setVisibility(0);
    if (k == 3)
    {
      localTextView.setText(str5);
      localTextView.setPaintFlags(0x10 | localTextView.getPaintFlags());
      localTextView.setTextColor(-6776680);
      localButton.setVisibility(8);
      if (i != this.mMyUserNo)
      {
        View.OnClickListener local12 = new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            try
            {
              AtvDetail.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("tel:" + str2.replaceAll("\\D", ""))));
              return;
            }
            catch (Exception localException) {}
          }
        };
        localTextView.setOnClickListener(local12);
      }
      this.mBaseRequest.addView(localView);
      return;
    }
    SpannableString localSpannableString = new SpannableString(str5);
    localSpannableString.setSpan(new StyleSpan(1), 0, localSpannableString.length(), 33);
    localTextView.setText(localSpannableString);
    localTextView.setTextColor(-13421773);
    localTextView.setHighlightColor(-13421773);
    localButton.setVisibility(0);
    if (i != this.mMyUserNo) {
      localButton.setText("거절");
    }
    for (;;)
    {
      View.OnClickListener local11 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (i != AtvDetail.this.mMyUserNo)
          {
            Alert localAlert1 = new Alert();
            localAlert1.setOnCloseListener(new Alert.OnCloseListener()
            {
              public void onClose(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int, Object paramAnonymous2Object)
              {
                if (1 == paramAnonymous2Int) {
                  AtvDetail.this.callApi_updateReqTransferJoin(this.val$reqID, 3);
                }
              }
            });
            if (AtvDetail.this.mTransferJoinTypeID == 1)
            {
              localAlert1.showAlert(AtvDetail.this.getContext(), str5 + "님 양도를 거절하시겠습니까?", false, new String[] { "거절", "닫기" });
              return;
            }
            localAlert1.showAlert(AtvDetail.this.getContext(), str5 + "님 조인을 거절하시겠습니까?", false, new String[] { "거절", "닫기" });
            return;
          }
          Alert localAlert2 = new Alert();
          localAlert2.setOnCloseListener(new Alert.OnCloseListener()
          {
            public void onClose(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int, Object paramAnonymous2Object)
            {
              if (1 == paramAnonymous2Int) {
                AtvDetail.this.callApi_cancelTransferJoin();
              }
            }
          });
          if (AtvDetail.this.mTransferJoinTypeID == 1)
          {
            localAlert2.showAlert(AtvDetail.this.getContext(), "양도요청을 취소하시겠습니까?", false, new String[] { "요청취소", "닫기" });
            return;
          }
          localAlert2.showAlert(AtvDetail.this.getContext(), "조인요청을 취소하시겠습니까?", false, new String[] { "요청취소", "닫기" });
        }
      };
      localButton.setOnClickListener(local11);
      break;
      localButton.setText("취소");
    }
  }
  
  private int setDataScore(View paramView, int paramInt1, int paramInt2)
  {
    SeekBar localSeekBar = (SeekBar)paramView.findViewById(2131361832);
    TextView localTextView = (TextView)paramView.findViewById(2131361833);
    localSeekBar.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    localSeekBar.setMax(100);
    int i = 0;
    if (paramInt2 == 0) {
      localSeekBar.setProgress(0);
    }
    for (;;)
    {
      localTextView.setText(FormatUtil.toPriceFormat(paramInt1));
      return i;
      i = (int)(100.0F * (paramInt1 / paramInt2));
      localSeekBar.setProgress(i);
    }
  }
  
  private void setDataScore()
  {
    Button localButton = (Button)this.mHeader.findViewById(2131362037);
    TextView localTextView1 = (TextView)this.mHeader.findViewById(2131361829);
    TextView localTextView2 = (TextView)this.mHeader.findViewById(2131361830);
    TableRow[] arrayOfTableRow = new TableRow[5];
    arrayOfTableRow[4] = ((TableRow)this.mHeader.findViewById(2131361831));
    arrayOfTableRow[3] = ((TableRow)this.mHeader.findViewById(2131361834));
    arrayOfTableRow[2] = ((TableRow)this.mHeader.findViewById(2131361835));
    arrayOfTableRow[1] = ((TableRow)this.mHeader.findViewById(2131361836));
    arrayOfTableRow[0] = ((TableRow)this.mHeader.findViewById(2131361837));
    int i = JSONUtil.getInteger(this.mGolfInfo, "comm_cnt", 0);
    int j = 0;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Double.valueOf(JSONUtil.getDouble(this.mGolfInfo, "grade", 0.0D));
    localTextView1.setText(String.format("%.1f", arrayOfObject));
    localTextView2.setText(FormatUtil.toPriceFormat(i) + "명");
    int k = 0;
    if (k >= arrayOfTableRow.length) {
      if (j <= 0) {}
    }
    for (int n = 0;; n++)
    {
      if (n >= arrayOfTableRow.length)
      {
        localButton.setVisibility(0);
        localButton.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            Intent localIntent = new Intent(paramAnonymousView.getContext(), AtvReviewAll.class);
            localIntent.putExtra("EXTRAS_JSON_STRING", AtvDetail.this.mGolfInfo.toString());
            localIntent.putExtra("EXTRAS_ID", JSONUtil.getInteger(AtvDetail.this.mGolfInfo, "no", -1));
            AtvDetail.this.startActivityForResult(localIntent, 1000);
          }
        });
        return;
        int m = setDataScore(arrayOfTableRow[k], JSONUtil.getInteger(this.mGolfInfo, "counts" + (k + 1), 0), i);
        if (j < m) {
          j = m;
        }
        k++;
        break;
      }
      ((SeekBar)arrayOfTableRow[n].findViewById(2131361832)).setMax(j);
    }
  }
  
  private void setTopListDOWN()
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("ApiTransferJoin.setTopListDOWN");
    localGPClient.addParameter("transferJoinID", Integer.valueOf(this.mTransferJoinID));
    localGPClient.setDecoder(new GJSONDecoder(1));
    localGPClient.addProgress();
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvDetail.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        Alert.toastLong(AtvDetail.this.getContext(), paramAnonymousString);
        return null;
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  private void setTopListUP()
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("ApiTransferJoin.setTopListUP");
    localGPClient.addParameter("transferJoinID", Integer.valueOf(this.mTransferJoinID));
    localGPClient.addParameter("user_fk", Integer.valueOf(JSONUtil.getInteger(this.mUserInfo, "no", -200)));
    localGPClient.setDecoder(new GJSONDecoder(1));
    localGPClient.addProgress();
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvDetail.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        Alert.toastLong(AtvDetail.this.getContext(), paramAnonymousString);
        return null;
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  private void showPhoto(JSONObject paramJSONObject, int paramInt)
  {
    JSONArray localJSONArray = new JSONArray();
    for (int i = 1;; i++)
    {
      if (i > 3)
      {
        if (localJSONArray.length() > 0)
        {
          Intent localIntent = new Intent(getContext(), AtvShowPhoto.class);
          localIntent.putExtra("EXTRAS_TYPE", 200);
          localIntent.putExtra("EXTRAS_JSON_STRING", localJSONArray.toString());
          localIntent.putExtra("EXTRAS_POSITION", paramInt);
          startActivity(localIntent);
        }
        return;
      }
      String str = JSONUtil.getString(paramJSONObject, "imgUrl" + i, "");
      if (!FormatUtil.isNullorEmpty(str))
      {
        JSONObject localJSONObject = new JSONObject();
        JSONUtil.put(localJSONObject, "imagePath", str);
        localJSONArray.put(localJSONObject);
      }
    }
  }
  
  protected void configureListener()
  {
    this.mTxtTopTitleLeftBack.setOnClickListener(ListenerUtil.getFinishButtonListener(getContext()));
    this.mBtnRequest.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (!AtvDetail.this.checkLogin(true)) {
          return;
        }
        if ((AtvDetail.this.mIsOwner) || ((SPUtil.getInstance().getIsOnAppAdmin(AtvDetail.this.getContext())) && (SPUtil.getInstance().getUserType(AtvDetail.this.getContext()).equals("2"))))
        {
          Alert localAlert1 = new Alert();
          localAlert1.setOnCloseListener(new Alert.OnCloseListener()
          {
            public void onClose(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int, Object paramAnonymous2Object)
            {
              if (1 == paramAnonymous2Int) {
                AtvDetail.this.callApi_finishTransferJoin();
              }
            }
          });
          if (AtvDetail.this.mTransferJoinTypeID == 1)
          {
            localAlert1.showAlert(AtvDetail.this.getContext(), "해당 양도를 마감하시겠습니까?", true, new String[] { "양도마감", "취소" });
            return;
          }
          localAlert1.showAlert(AtvDetail.this.getContext(), "해당 조인를 마감하시겠습니까?", true, new String[] { "조인마감", "취소" });
          return;
        }
        String[] arrayOfString = AtvDetail.this.mTxtTopTitleRegistDT.getText().toString().split("\n");
        String str = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf("")).append(AtvDetail.this.mTxtGolf.getText().toString()).toString())).append(" ").append(arrayOfString[1]).toString())).append("\n").append(AtvDetail.this.mTxtNickName.getText().toString()).toString() + " " + JSONUtil.getString(AtvDetail.this.mUserInfo, "phone", "");
        Alert localAlert2 = new Alert();
        localAlert2.setOnCloseListener(new Alert.OnCloseListener()
        {
          public void onClose(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int, Object paramAnonymous2Object)
          {
            if (1 == paramAnonymous2Int) {
              AtvDetail.this.callApi_reqTransferJoin();
            }
          }
        });
        if (AtvDetail.this.mTransferJoinTypeID == 1)
        {
          localAlert2.showAlert(AtvDetail.this.getContext(), str, true, new String[] { "양도요청", "취소" });
          return;
        }
        localAlert2.showAlert(AtvDetail.this.getContext(), str, true, new String[] { "조인요청", "취소" });
      }
    });
    this.mBtnDel.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Alert localAlert = new Alert();
        localAlert.setOnCloseListener(new Alert.OnCloseListener()
        {
          public void onClose(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int, Object paramAnonymous2Object)
          {
            if (1 == paramAnonymous2Int) {
              AtvDetail.this.callApi_deleteTransferJoin();
            }
          }
        });
        if (AtvDetail.this.mTransferJoinTypeID == 1)
        {
          localAlert.showAlert(AtvDetail.this.getContext(), "해당 양도를 삭제하시겠습니까?", false, new String[] { "삭제", "닫기" });
          return;
        }
        localAlert.showAlert(AtvDetail.this.getContext(), "해당 조인을 삭제하시겠습니까?", false, new String[] { "삭제", "닫기" });
      }
    });
    this.mBtnModify.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(paramAnonymousView.getContext(), AtvRegist.class);
        localIntent.putExtra("EXTRAS_JSON_STRING", AtvDetail.this.mTransferJoinInfo.toString());
        if (AtvDetail.this.mTransferJoinTypeID == 1) {}
        for (int i = 100;; i = 200)
        {
          localIntent.putExtra("EXTRAS_TYPE", i);
          AtvDetail.this.startActivityForResult(localIntent, 7894);
          return;
        }
      }
    });
    this.mBtnWriteRounding.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (!AtvDetail.this.checkLogin(true)) {
          return;
        }
        Intent localIntent = new Intent(paramAnonymousView.getContext(), AtvReviewWrite.class);
        localIntent.putExtra("EXTRAS_JSON_STRING", AtvDetail.this.mGolfInfo.toString());
        localIntent.putExtra("EXTRAS_ID", JSONUtil.getInteger(AtvDetail.this.mGolfInfo, "no", -1));
        AtvDetail.this.startActivityForResult(localIntent, 1000);
      }
    });
    this.llSMS.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (AtvDetail.this.mTransferJoinTypeID == 1) {}
        for (String str1 = "" + "<양도> ";; str1 = "" + "<조인> ")
        {
          String str2 = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(str1)).append(AtvDetail.this.mTxtGolf.getText().toString()).toString())).append(" ").append(AtvDetail.this.mTxtFee.getText().toString()).toString())).append(" ").append(AtvDetail.this.mTxtTeeUp.getText().toString()).toString())).append("\n").append(AtvDetail.this.mTxtNickName.getText().toString()).toString())).append(" ").append(JSONUtil.getString(AtvDetail.this.mUserInfo, "phone", "")).toString() + "\n\n<골프몬 앱>\n다운 http://gil.cc/84Z3";
          Intent localIntent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:"));
          localIntent.putExtra("sms_body", str2);
          AtvDetail.this.startActivity(localIntent);
          return;
        }
      }
    });
    this.mTxtID.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        try
        {
          Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("tel:" + JSONUtil.getString(AtvDetail.this.mUserInfo, "phone", "").replaceAll("\\D", "")));
          AtvDetail.this.startActivity(localIntent);
          return;
        }
        catch (Exception localException) {}
      }
    });
    this.mTxtLocation.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (AtvDetail.this.mGolfInfo != null)
        {
          Intent localIntent = new Intent(AtvDetail.this.getContext(), AtvMapShow.class);
          localIntent.putExtra("EXTRAS_JSON_STRING", AtvDetail.this.mGolfInfo.toString());
          AtvDetail.this.startActivity(localIntent);
        }
      }
    });
    this.btnYar1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvDetail.this.startYardage();
      }
    });
    this.btnYar2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvDetail.this.startYardage();
      }
    });
    this.mBtnWarn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Alert localAlert = new Alert();
        localAlert.setOnCloseListener(new Alert.OnCloseListener()
        {
          public void onClose(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int, Object paramAnonymous2Object)
          {
            if (1 == paramAnonymous2Int) {
              AtvDetail.this.callApi_updateWCounts();
            }
          }
        });
        if (AtvDetail.this.mBtnWarn.getText().toString().equals("불량정보신고"))
        {
          localAlert.showAlert(AtvDetail.this.getContext(), "불량정보로 신고하시겠습니까? 신고시 담당매니저에게 메세지가 발송됩니다.", false, new String[] { "신고", "닫기" });
          return;
        }
        localAlert.showAlert(AtvDetail.this.getContext(), "불량정보신고를 취소하시겠습니까?", false, new String[] { "신고취소", "닫기" });
      }
    });
  }
  
  protected void findView()
  {
    this.mList = ((GListView)findViewById(2131361864));
    this.mBaseHeader = new LinearLayout(getContext());
    this.mList.addHeaderView(this.mBaseHeader);
    this.mHeader = ((LinearLayout)InflateUtil.inflate(getContext(), 2130903072, null));
    this.mBaseHeader.addView(this.mHeader);
    this.mTxtNickName = ((TextView)this.mHeader.findViewById(2131361945));
    this.mBaseGoodCount = ((LinearLayout)this.mHeader.findViewById(2131362013));
    this.mTxtGoodCount = ((TextView)this.mHeader.findViewById(2131362015));
    this.mImgGoodCount = ((ImageView)this.mHeader.findViewById(2131362014));
    this.mTxtID = ((TextView)this.mHeader.findViewById(2131361946));
    this.mTxtGolf = ((TextView)this.mHeader.findViewById(2131361948));
    this.txtName = ((TextView)this.mHeader.findViewById(2131361869));
    this.mTxtTeeUp = ((TextView)this.mHeader.findViewById(2131362001));
    this.mTxtLocation = ((TextView)this.mHeader.findViewById(2131361947));
    this.mTxtFee = ((TextView)this.mHeader.findViewById(2131362002));
    this.mBasePeople = ((LinearLayout)this.mHeader.findViewById(2131362003));
    this.mTxtPeople = ((TextView)this.mHeader.findViewById(2131362004));
    this.mTxtCouple = ((TextView)this.mHeader.findViewById(2131362005));
    this.txtCount = ((TextView)this.mHeader.findViewById(2131361833));
    this.txtHole = ((TextView)this.mHeader.findViewById(2131362007));
    this.mBaseBtns = ((LinearLayout)this.mHeader.findViewById(2131361907));
    this.mBtnWarn = ((Button)this.mHeader.findViewById(2131362008));
    this.mBtnDel = ((Button)this.mHeader.findViewById(2131362011));
    this.mBtnModify = ((Button)this.mHeader.findViewById(2131362012));
    this.mTxtDescription = ((TextView)this.mHeader.findViewById(2131362016));
    this.mTxtSubTitleRequest = ((TextView)this.mHeader.findViewById(2131362018));
    this.mBaseRequest = ((LinearLayout)this.mHeader.findViewById(2131362020));
    this.mLineRequest2 = this.mHeader.findViewById(2131362019);
    this.mLineRequest3 = this.mHeader.findViewById(2131362021);
    this.mBtnRequest = ((LinearLayout)this.mHeader.findViewById(2131361973));
    this.mTxtApplyMessage = ((TextView)this.mHeader.findViewById(2131362025));
    this.mTxtRequestTrasfer = ((TextView)this.mHeader.findViewById(2131362022));
    this.mTxtRequestJoin = ((TextView)this.mHeader.findViewById(2131362023));
    this.mTxtSubTitleRounding = ((TextView)this.mHeader.findViewById(2131362026));
    this.mBtnWriteRounding = ((LinearLayout)this.mHeader.findViewById(2131361966));
    this.btnYar1 = ((Button)this.mHeader.findViewById(2131362000));
    this.btnYar2 = ((Button)this.mHeader.findViewById(2131362027));
    this.ivThum = ((ImageView)this.mHeader.findViewById(2131361868));
    this.llSMS = ((LinearLayout)this.mHeader.findViewById(2131362024));
  }
  
  protected boolean getBundle()
  {
    LogUtil.intent("AtvDetailJoin", getIntent());
    this.mMyUserNo = JSONUtil.getInteger(SPUtil.getInstance().getUserInfo(getContext()), "no", -10);
    this.mTransferJoinID = getIntent().getIntExtra("EXTRAS_ID", 0);
    try
    {
      if (this.mTransferJoinID <= 0) {
        this.mTransferJoinID = Integer.parseInt(getIntent().getStringExtra("transferJoinID"));
      }
      label71:
      int i = this.mTransferJoinID;
      boolean bool = false;
      if (i > 0) {
        bool = true;
      }
      return bool;
    }
    catch (Exception localException)
    {
      break label71;
    }
  }
  
  public void gotoPlayStore()
  {
    Alert localAlert = new Alert();
    localAlert.setOnCloseListener(new Alert.OnCloseListener()
    {
      public void onClose(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, Object paramAnonymousObject)
      {
        if (1 == paramAnonymousInt)
        {
          Intent localIntent = new Intent("android.intent.action.VIEW");
          localIntent.setData(Uri.parse("market://details?id=co.sorf.apps.voya"));
          AtvDetail.this.getContext().startActivity(localIntent);
        }
      }
    });
    localAlert.showAlert(this, "골프야디지 설치 화면으로 이동합니다.", false, new String[] { "이동", "취소" });
  }
  
  protected void init()
  {
    this.mBasePeople.setVisibility(0);
    this.mTxtSubTitleRequest.setText("조인 요청 List");
    SpannableString localSpannableString = new SpannableString("라운딩 후기를 작성해 주세요~! (50P 증정)");
    localSpannableString.setSpan(new StyleSpan(1), 0, 6, 33);
    localSpannableString.setSpan(new StyleSpan(1), 19, 22, 33);
    localSpannableString.setSpan(new ForegroundColorSpan(-2023132), 19, 22, 33);
    this.mTxtSubTitleRounding.setText(localSpannableString);
    this.mList.setViewMaker(2130903084, this);
    this.mHeader.setVisibility(8);
    this.mImageDownLoader = new ImageDownLoader(this);
    this.mImageDownLoader.setMode(ImageDownLoader.Mode.CORRECT);
    callApi_getInfoOfTransferJoin();
  }
  
  public boolean isAppInstalled(String paramString)
  {
    try
    {
      PackageInfo localPackageInfo = getContext().getPackageManager().getPackageInfo(paramString, 0);
      boolean bool = false;
      if (localPackageInfo != null) {
        bool = true;
      }
      return bool;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return false;
  }
  
  public View makeView(GListView.GListAdapter paramGListAdapter, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    final JSONObject localJSONObject = (JSONObject)paramGListAdapter.getItem(paramInt);
    TextView localTextView1 = (TextView)paramView.findViewById(2131361945);
    ImageButton localImageButton = (ImageButton)paramView.findViewById(2131362011);
    RatingBar localRatingBar = (RatingBar)paramView.findViewById(2131361838);
    TextView localTextView2 = (TextView)paramView.findViewById(2131361873);
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131362058);
    GImageView localGImageView1 = (GImageView)paramView.findViewById(2131361878);
    GImageView localGImageView2 = (GImageView)paramView.findViewById(2131361879);
    GImageView localGImageView3 = (GImageView)paramView.findViewById(2131361880);
    TextView localTextView3 = (TextView)paramView.findViewById(2131361877);
    int i = JSONUtil.getInteger(localJSONObject, "user_fk", -70);
    localTextView1.setText(JSONUtil.getString(localJSONObject, "nick_name", ""));
    int j;
    final String str1;
    final String str2;
    final String str3;
    if (this.mMyUserNo == i)
    {
      j = 0;
      localImageButton.setVisibility(j);
      if ((SPUtil.getInstance().getIsOnAppAdmin(getContext())) && (SPUtil.getInstance().getUserType(getContext()).equals("2"))) {
        localImageButton.setVisibility(0);
      }
      localRatingBar.setRating(JSONUtil.getInteger(localJSONObject, "grade", 0));
      localTextView2.setText(FormatUtil.getDateConvert(JSONUtil.getString(localJSONObject, "regist_dt", ""), "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd"));
      str1 = JSONUtil.getString(localJSONObject, "imgUrl1", "");
      str2 = JSONUtil.getString(localJSONObject, "imgUrl2", "");
      str3 = JSONUtil.getString(localJSONObject, "imgUrl3", "");
      if ((!FormatUtil.isNullorEmpty(str1)) || (!FormatUtil.isNullorEmpty(str2)) || (!FormatUtil.isNullorEmpty(str3))) {
        break label352;
      }
      localLinearLayout.setVisibility(8);
    }
    for (;;)
    {
      localTextView3.setText(JSONUtil.getString(localJSONObject, "content", ""));
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
                AtvDetail.this.setResult(-1);
                AtvDetail.this.callApi_deleteComment(this.val$json);
              }
            }
          });
          localAlert.showAlert(AtvDetail.this.getContext(), "라운딩 후기를 삭제하시겠습니까?", true, new String[] { "삭제", "취소" });
        }
      });
      return paramView;
      j = 4;
      break;
      label352:
      localLinearLayout.setVisibility(0);
      localGImageView1.setImageViewUser(str1, "480", 2130837692);
      localGImageView2.setImageViewUser(str2, "480", 2130837692);
      localGImageView3.setImageViewUser(str3, "480", 2130837692);
      localGImageView1.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (!FormatUtil.isNullorEmpty(str1)) {
            AtvDetail.this.showPhoto(localJSONObject, 0);
          }
        }
      });
      localGImageView2.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (!FormatUtil.isNullorEmpty(str2)) {
            AtvDetail.this.showPhoto(localJSONObject, 1);
          }
        }
      });
      localGImageView3.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (!FormatUtil.isNullorEmpty(str3)) {
            AtvDetail.this.showPhoto(localJSONObject, 2);
          }
        }
      });
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1111)
    {
      this.mMyUserNo = JSONUtil.getInteger(SPUtil.getInstance().getUserInfo(getContext()), "no", -10);
      if (JSONUtil.getInteger(this.mUserInfo, "no", -200) != this.mMyUserNo) {
        break label73;
      }
    }
    label73:
    for (boolean bool = true;; bool = false)
    {
      this.mIsOwner = bool;
      if (paramInt2 == -1)
      {
        setResult(-1);
        callApi_getInfoOfTransferJoin();
      }
      return;
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    paramMenu.add(0, 0, 0, "내가 등록한 양도/조인").setIcon(17301563);
    if ((SPUtil.getInstance().getIsOnAppAdmin(getContext())) && (SPUtil.getInstance().getUserType(getContext()).equals("2")))
    {
      paramMenu.add(0, 1, 0, "최상단 설정").setIcon(17301582);
      paramMenu.add(0, 2, 0, "최상단 해제").setIcon(17301564);
    }
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      setTopListUP();
      continue;
      setTopListDOWN();
      continue;
      startActivity(new Intent(getContext(), AtvMyRegist.class));
    }
  }
  
  protected void setView()
  {
    setView(2130903050);
  }
  
  public void startYardage()
  {
    if (isAppInstalled("co.sorf.apps.voya"))
    {
      Intent localIntent = getContext().getPackageManager().getLaunchIntentForPackage("co.sorf.apps.voya");
      getContext().startActivity(localIntent);
      return;
    }
    gotoPlayStore();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.atv.schedule.AtvDetail
 * JD-Core Version:    0.7.0.1
 */