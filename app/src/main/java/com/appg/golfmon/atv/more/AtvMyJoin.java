package com.appg.golfmon.atv.more;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.appg.golfmon.atv.AtvBase;
import com.appg.golfmon.atv.schedule.AtvDetail;
import com.appg.golfmon.atv.schedule.AtvReviewWrite;
import com.appg.golfmon.net.http.GFailedHandler;
import com.appg.golfmon.net.http.GJSONDecoder;
import com.appg.golfmon.net.http.GPClient;
import com.appg.golfmon.net.http.GResultHandler;
import com.appg.golfmon.util.Alert;
import com.appg.golfmon.util.Alert.OnCloseListener;
import com.appg.golfmon.util.FormatUtil;
import com.appg.golfmon.util.InflateUtil;
import com.appg.golfmon.util.JSONUtil;
import com.appg.golfmon.util.ListenerUtil;
import com.appg.golfmon.util.SPUtil;
import com.appg.golfmon.view.GListView;
import com.appg.golfmon.view.GListView.GListAdapter;
import com.appg.golfmon.view.GListView.IMakeView;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONObject;
import ra.genius.net.GBean;
import ra.genius.net.GExecutor;

public class AtvMyJoin
  extends AtvBase
  implements GListView.IMakeView
{
  private LinearLayout mBaseHeader = null;
  private LinearLayout mBaseNodata = null;
  private Button mBtnTabJoin = null;
  private Button mBtnTabTransfer = null;
  private LinearLayout mHeader = null;
  private ImageView mImgGood = null;
  private GListView mList = null;
  private int mMyUserNo = -100;
  private int mSelTab = 100;
  private TextView mTxtNodata = null;
  
  private void callApi_cancelTransferJoin(final JSONObject paramJSONObject)
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("ApiTransferJoin.cancelTransferJoin");
    localGPClient.addParameter("transferJoinID", Integer.valueOf(JSONUtil.getInteger(paramJSONObject, "transferJoinID", 0)));
    localGPClient.setDecoder(new GJSONDecoder(3));
    localGPClient.addProgress();
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvMyJoin.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        if (paramAnonymousInt > 0) {
          AtvMyJoin.this.mList.remove(paramJSONObject);
        }
        AtvMyJoin.this.setNodata();
        new Alert().showAlert(AtvMyJoin.this.getContext(), paramAnonymousString);
        return null;
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  private void callApi_getListOfTransferJoin_MyJoin(final boolean paramBoolean)
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("ApiTransferJoin.getListOfTransferJoin_MyJoin");
    if (this.mSelTab == 100) {
      localGPClient.addParameter("transferJoinTypeID", Integer.valueOf(1));
    }
    for (;;)
    {
      localGPClient.setDecoder(new GJSONDecoder(2));
      localGPClient.addProgress();
      localGPClient.addHandler(new GFailedHandler()
      {
        public void failedExecute(GBean paramAnonymousGBean)
        {
          Alert.toastLong(AtvMyJoin.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
        }
      });
      localGPClient.addHandler(new GResultHandler()
      {
        public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          if (paramBoolean) {
            AtvMyJoin.this.mList.removeAll();
          }
          if (paramAnonymousInt > 0) {
            AtvMyJoin.this.mList.addItems((JSONArray)paramAnonymousObject);
          }
          AtvMyJoin.this.setNodata();
          return null;
        }
      });
      GExecutor.getInstance().execute(localGPClient);
      return;
      if (this.mSelTab == 200) {
        localGPClient.addParameter("transferJoinTypeID", Integer.valueOf(2));
      }
    }
  }
  
  private void callApi_updateUserGood(JSONObject paramJSONObject)
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("ApiTransferJoin.updateUserGood");
    localGPClient.addParameter("to_user_fk", JSONUtil.getString(paramJSONObject, "user_fk", ""));
    localGPClient.setDecoder(new GJSONDecoder(3));
    localGPClient.addProgress();
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvMyJoin.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        if (paramAnonymousInt > 0) {
          AtvMyJoin.this.callApi_getListOfTransferJoin_MyJoin(true);
        }
        new Alert().showAlert(AtvMyJoin.this.getContext(), paramAnonymousString);
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
  
  private void setNodata()
  {
    if (this.mList.getCountAll() > 0)
    {
      this.mBaseNodata.setVisibility(8);
      this.mImgGood.setVisibility(0);
      this.mList.getLayoutParams().height = -1;
      return;
    }
    this.mBaseNodata.setVisibility(0);
    this.mImgGood.setVisibility(8);
    this.mList.getLayoutParams().height = -2;
    this.mTxtNodata.setText("검색결과가 없습니다.");
  }
  
  private void setTabJoin()
  {
    this.mSelTab = 200;
    this.mBtnTabTransfer.setSelected(false);
    this.mBtnTabJoin.setSelected(true);
    this.mBaseNodata.setVisibility(8);
    this.mImgGood.setVisibility(8);
    this.mList.removeAll();
    callApi_getListOfTransferJoin_MyJoin(true);
  }
  
  private void setTabTransfer()
  {
    this.mSelTab = 100;
    this.mBtnTabTransfer.setSelected(true);
    this.mBtnTabJoin.setSelected(false);
    this.mBaseNodata.setVisibility(8);
    this.mImgGood.setVisibility(8);
    this.mList.removeAll();
    callApi_getListOfTransferJoin_MyJoin(true);
  }
  
  protected void configureListener()
  {
    this.mTxtTopTitleLeftBack.setOnClickListener(ListenerUtil.getFinishButtonListener(getContext()));
    this.mBtnTabTransfer.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvMyJoin.this.setTabTransfer();
      }
    });
    this.mBtnTabJoin.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvMyJoin.this.setTabJoin();
      }
    });
  }
  
  protected void findView()
  {
    this.mBtnTabTransfer = ((Button)findViewById(2131361897));
    this.mBtnTabJoin = ((Button)findViewById(2131361898));
    this.mList = ((GListView)findViewById(2131361864));
    this.mBaseNodata = ((LinearLayout)findViewById(2131361865));
    this.mTxtNodata = ((TextView)findViewById(2131361866));
    this.mImgGood = ((ImageView)findViewById(2131361899));
    this.mBaseHeader = new LinearLayout(getContext());
    this.mList.addHeaderView(this.mBaseHeader);
    this.mHeader = ((LinearLayout)InflateUtil.inflate(getContext(), 2130903076, null));
    this.mBaseHeader.addView(this.mHeader, new LinearLayout.LayoutParams(-1, -2));
  }
  
  protected void init()
  {
    this.mMyUserNo = JSONUtil.getInteger(SPUtil.getInstance().getUserInfo(this), "no", -100);
    this.mTxtTopTitleLeftBack.setVisibility(0);
    this.mTxtTopTitleLeftBack.setText("내가 요청한 양도/조인");
    this.mList.setViewMaker(2130903089, this);
    setTabTransfer();
  }
  
  public View makeView(GListView.GListAdapter paramGListAdapter, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    final JSONObject localJSONObject = (JSONObject)paramGListAdapter.getItem(paramInt);
    TextView localTextView1 = (TextView)paramView.findViewById(2131361869);
    TextView localTextView2 = (TextView)paramView.findViewById(2131362064);
    TextView localTextView3 = (TextView)paramView.findViewById(2131361873);
    TextView localTextView4 = (TextView)paramView.findViewById(2131361945);
    ImageView localImageView = (ImageView)paramView.findViewById(2131361917);
    TextView localTextView5 = (TextView)paramView.findViewById(2131362065);
    final Calendar localCalendar = FormatUtil.getDateStringToCalendar(JSONUtil.getString(localJSONObject, "dates", ""), "yyyy-MM-dd HH:mm:ss");
    final int i = JSONUtil.getInteger(localJSONObject, "user_fk", 0);
    int j = JSONUtil.getInteger(localJSONObject, "reqTypeID", 0);
    final boolean bool;
    int k;
    label153:
    String str3;
    label187:
    int m;
    label204:
    int n;
    if (JSONUtil.getInteger(localJSONObject, "isGood", 0) == 1)
    {
      bool = true;
      if (JSONUtil.getInteger(localJSONObject, "isApply", 0) != 2) {
        break label360;
      }
      k = 1;
      final String str1 = JSONUtil.getString(localJSONObject, "name", "");
      final String str2 = JSONUtil.getString(localJSONObject, "nick_name", "");
      if (k == 0) {
        break label366;
      }
      str3 = "마감";
      localTextView2.setText(str3);
      if (k == 0) {
        break label374;
      }
      m = 2130837506;
      localTextView2.setBackgroundResource(m);
      localTextView1.setText(str1);
      localTextView4.setText("등록자 : " + str2);
      localTextView3.setText(getDate(localCalendar));
      localTextView3.setTextColor(FormatUtil.getDateColor(localCalendar));
      if (!bool) {
        break label382;
      }
      n = 0;
      label270:
      localImageView.setVisibility(n);
      localTextView4.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Alert localAlert = new Alert();
          if (AtvMyJoin.this.mMyUserNo == i)
          {
            localAlert.showAlert(AtvMyJoin.this.getContext(), "본인을 좋아요 할 수 없습니다.");
            return;
          }
          localAlert.setOnCloseListener(new Alert.OnCloseListener()
          {
            public void onClose(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int, Object paramAnonymous2Object)
            {
              if (1 == paramAnonymous2Int) {
                AtvMyJoin.this.callApi_updateUserGood(this.val$json);
              }
            }
          });
          if (!bool)
          {
            localAlert.showAlert(AtvMyJoin.this.getContext(), str2 + "님을 좋아요하시겠습니까?", true, new String[] { "좋아요", "닫기" });
            return;
          }
          localAlert.showAlert(AtvMyJoin.this.getContext(), str2 + "님 좋아요를 취소하시겠습니까?", true, new String[] { "확인", "닫기" });
        }
      });
      if (j != 1) {
        break label389;
      }
      localTextView5.setVisibility(8);
      localTextView5.setText("요청취소");
      localTextView5.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          String str = str1 + " " + FormatUtil.getDateCalendarToString(localCalendar, "yyyy.MM.dd HH:00") + "을 요청취소하시겠습니까?";
          Alert localAlert = new Alert();
          localAlert.setOnCloseListener(new Alert.OnCloseListener()
          {
            public void onClose(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int, Object paramAnonymous2Object)
            {
              if (1 == paramAnonymous2Int) {
                AtvMyJoin.this.callApi_cancelTransferJoin(this.val$json);
              }
            }
          });
          localAlert.showAlert(AtvMyJoin.this.getContext(), str, true, new String[] { "요청취소", "닫기" });
        }
      });
    }
    for (;;)
    {
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Intent localIntent = new Intent(paramAnonymousView.getContext(), AtvDetail.class);
          localIntent.putExtra("EXTRAS_ID", JSONUtil.getInteger(localJSONObject, "transferJoinID", 0));
          AtvMyJoin.this.startActivityForResult(localIntent, 7890);
        }
      });
      return paramView;
      bool = false;
      break;
      label360:
      k = 0;
      break label153;
      label366:
      str3 = "진행중";
      break label187;
      label374:
      m = 2130837508;
      break label204;
      label382:
      n = 8;
      break label270;
      label389:
      if (j == 2)
      {
        localTextView5.setVisibility(0);
        localTextView5.setText("후기작성");
        localTextView5.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            Intent localIntent = new Intent(paramAnonymousView.getContext(), AtvReviewWrite.class);
            localIntent.putExtra("EXTRAS_JSON_STRING", localJSONObject.toString());
            AtvMyJoin.this.startActivityForResult(localIntent, 1000);
          }
        });
      }
      else
      {
        localTextView5.setVisibility(4);
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      callApi_getListOfTransferJoin_MyJoin(true);
    }
  }
  
  protected void setView()
  {
    setView(2130903054);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.atv.more.AtvMyJoin
 * JD-Core Version:    0.7.0.1
 */