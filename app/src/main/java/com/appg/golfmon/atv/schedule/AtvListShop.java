package com.appg.golfmon.atv.schedule;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.appg.golfmon.atv.AtvBase;
import com.appg.golfmon.net.http.GFailedHandler;
import com.appg.golfmon.net.http.GJSONDecoder;
import com.appg.golfmon.net.http.GPClient;
import com.appg.golfmon.net.http.GResultHandler;
import com.appg.golfmon.util.Alert;
import com.appg.golfmon.util.FormatUtil;
import com.appg.golfmon.util.InflateUtil;
import com.appg.golfmon.util.JSONUtil;
import com.appg.golfmon.util.ListenerUtil;
import com.appg.golfmon.view.GListView;
import com.appg.golfmon.view.GListView.GListAdapter;
import com.appg.golfmon.view.GListView.IMakeView;
import java.util.Calendar;
import org.json.JSONObject;
import ra.genius.net.GBean;
import ra.genius.net.GExecutor;

public class AtvListShop
  extends AtvBase
  implements GListView.IMakeView
{
  private LinearLayout mBaseHeader = null;
  private LinearLayout mBaseNodata = null;
  private Button mBtnTabJoin = null;
  private Button mBtnTabTransfer = null;
  private Calendar mCalendar_Now = Calendar.getInstance();
  private String mGolfNo = null;
  private String mGolfTitle = null;
  private LinearLayout mHeader = null;
  private GListView mList = null;
  private int mSelTab = 100;
  private TextView mTxtHeader4 = null;
  private TextView mTxtLocation = null;
  private TextView mTxtNodata = null;
  private TextView mTxtScore = null;
  
  private void callApi_getInfoOfGolf(final boolean paramBoolean)
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("ApiTransferJoin.getInfoOfGolf");
    localGPClient.addParameter("golf_fk", this.mGolfNo);
    localGPClient.setDecoder(new GJSONDecoder(3));
    localGPClient.addProgress();
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvListShop.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        if (paramBoolean) {
          AtvListShop.this.mList.removeAll();
        }
        if (paramAnonymousInt > 0)
        {
          if (AtvListShop.this.mSelTab != 100) {
            break label73;
          }
          AtvListShop.this.mList.addItems(JSONUtil.getJSONArray(paramAnonymousJSONObject, "entityTransfer"));
        }
        for (;;)
        {
          AtvListShop.this.setData(JSONUtil.getJSONObject(paramAnonymousJSONObject, "entityGolf"));
          AtvListShop.this.setNodata();
          return null;
          label73:
          if (AtvListShop.this.mSelTab == 200) {
            AtvListShop.this.mList.addItems(JSONUtil.getJSONArray(paramAnonymousJSONObject, "entityJoin"));
          }
        }
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
  
  private void setData(JSONObject paramJSONObject)
  {
    this.mTxtTopTitleLeftBack.setText(JSONUtil.getString(paramJSONObject, "name", ""));
    this.mTxtLocation.setText(JSONUtil.getString(paramJSONObject, "address", ""));
    this.mTxtLocation.setVisibility(0);
    if (JSONUtil.getInteger(paramJSONObject, "is_primium", 0) == 1)
    {
      this.mTxtTopTitleGrade.setText("회");
      this.mTxtTopTitleGrade.setBackgroundResource(2130837509);
      this.mTxtTopTitleGrade.setVisibility(0);
    }
    for (;;)
    {
      double d = JSONUtil.getDouble(paramJSONObject, "grade", 0.0D);
      TextView localTextView = this.mTxtScore;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Double.valueOf(d);
      localTextView.setText(String.format("%1.1f", arrayOfObject));
      return;
      this.mTxtTopTitleGrade.setText("퍼");
      this.mTxtTopTitleGrade.setBackgroundResource(2130837510);
      this.mTxtTopTitleGrade.setVisibility(0);
    }
  }
  
  private void setNodata()
  {
    if (this.mList.getCountAll() > 0)
    {
      this.mBaseNodata.setVisibility(8);
      this.mList.getLayoutParams().height = -1;
      return;
    }
    this.mBaseNodata.setVisibility(0);
    this.mList.getLayoutParams().height = -2;
    this.mTxtNodata.setText("검색결과가 없습니다.");
  }
  
  private void setTabJoin()
  {
    this.mSelTab = 200;
    this.mBtnTabTransfer.setSelected(false);
    this.mBtnTabJoin.setSelected(true);
    this.mTxtHeader4.setText("유형");
    this.mList.removeAll();
    this.mBaseNodata.setVisibility(8);
    callApi_getInfoOfGolf(true);
  }
  
  private void setTabTransfer()
  {
    this.mSelTab = 100;
    this.mBtnTabTransfer.setSelected(true);
    this.mBtnTabJoin.setSelected(false);
    this.mTxtHeader4.setText("조회수");
    this.mList.removeAll();
    this.mBaseNodata.setVisibility(8);
    callApi_getInfoOfGolf(true);
  }
  
  protected void configureListener()
  {
    this.mTxtTopTitleLeftBack.setOnClickListener(ListenerUtil.getFinishButtonListener(getContext()));
    this.mBtnTabTransfer.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvListShop.this.setTabTransfer();
      }
    });
    this.mBtnTabJoin.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvListShop.this.setTabJoin();
      }
    });
  }
  
  protected void findView()
  {
    this.mList = ((GListView)findViewById(2131361864));
    this.mBaseNodata = ((LinearLayout)findViewById(2131361865));
    this.mTxtNodata = ((TextView)findViewById(2131361866));
    this.mBaseHeader = new LinearLayout(getContext());
    this.mList.addHeaderView(this.mBaseHeader);
    this.mHeader = ((LinearLayout)InflateUtil.inflate(getContext(), 2130903078, null));
    this.mBaseHeader.addView(this.mHeader, new LinearLayout.LayoutParams(-1, -2));
    this.mTxtLocation = ((TextView)this.mHeader.findViewById(2131361947));
    this.mTxtScore = ((TextView)this.mHeader.findViewById(2131362036));
    this.mBtnTabTransfer = ((Button)this.mHeader.findViewById(2131361897));
    this.mBtnTabJoin = ((Button)this.mHeader.findViewById(2131361898));
    this.mTxtHeader4 = ((TextView)this.mHeader.findViewById(2131362034));
  }
  
  protected boolean getBundle()
  {
    this.mSelTab = getIntent().getIntExtra("EXTRAS_TYPE", 100);
    this.mGolfTitle = getIntent().getStringExtra("EXTRAS_TITLE");
    this.mGolfNo = getIntent().getStringExtra("EXTRAS_ID");
    if (this.mGolfTitle == null) {
      this.mGolfTitle = "";
    }
    return !FormatUtil.isNullorEmpty(this.mGolfNo);
  }
  
  protected void init()
  {
    this.mTxtTopTitleLeftBack.setVisibility(0);
    this.mTxtTopTitleLeftBack.setText(this.mGolfTitle);
    this.mList.setViewMaker(2130903093, this);
    if (this.mSelTab == 100) {
      setTabTransfer();
    }
    while (this.mSelTab != 200) {
      return;
    }
    setTabJoin();
  }
  
  public View makeView(GListView.GListAdapter paramGListAdapter, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    final JSONObject localJSONObject = (JSONObject)paramGListAdapter.getItem(paramInt);
    TextView localTextView1 = (TextView)paramView.findViewById(2131362060);
    TextView localTextView2 = (TextView)paramView.findViewById(2131361873);
    TextView localTextView3 = (TextView)paramView.findViewById(2131361945);
    TextView localTextView4 = (TextView)paramView.findViewById(2131361833);
    Calendar localCalendar1 = FormatUtil.getDateStringToCalendar(JSONUtil.getString(localJSONObject, "registDT", ""), "yyyy-MM-dd HH:mm:ss");
    Calendar localCalendar2 = FormatUtil.getDateStringToCalendar(JSONUtil.getString(localJSONObject, "dates", ""), "yyyy-MM-dd HH:mm:ss");
    localTextView1.setText(FormatUtil.getRegistDT(localCalendar1, this.mCalendar_Now));
    localTextView1.setTextColor(FormatUtil.getRegistDTColor(localCalendar1, this.mCalendar_Now));
    double d = JSONUtil.getDouble(localJSONObject, "greenFee", 0.0D);
    if (d % 10000.0D == 0.0D)
    {
      localTextView3.setText((int)(d / 10000.0D) + "만원");
      localTextView2.setText(getDate(localCalendar2));
      localTextView2.setTextColor(FormatUtil.getDateColor(localCalendar2));
      if (this.mSelTab != 200) {
        break label346;
      }
      switch (JSONUtil.getInteger(localJSONObject, "joinTypeStr", 0))
      {
      default: 
        localTextView4.setText("");
      }
    }
    for (;;)
    {
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Intent localIntent = new Intent(paramAnonymousView.getContext(), AtvDetail.class);
          localIntent.putExtra("EXTRAS_ID", JSONUtil.getInteger(localJSONObject, "transferJoinID", 0));
          AtvListShop.this.startActivityForResult(localIntent, 7890);
        }
      });
      return paramView;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Double.valueOf(d / 10000.0D);
      localTextView3.setText(String.format("%1.1f만원", arrayOfObject));
      break;
      localTextView4.setText("무관");
      continue;
      localTextView4.setText("부부/커플");
      continue;
      localTextView4.setText("남자");
      continue;
      localTextView4.setText("여자");
      continue;
      label346:
      localTextView4.setText(FormatUtil.toPriceFormat(JSONUtil.getInteger(localJSONObject, "readCount", 0)));
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      callApi_getInfoOfGolf(true);
    }
  }
  
  protected void setView()
  {
    setView(2130903050);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.atv.schedule.AtvListShop
 * JD-Core Version:    0.7.0.1
 */