package com.appg.golfmon.atv.schedule;

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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import org.json.JSONArray;
import org.json.JSONObject;
import ra.genius.net.GBean;
import ra.genius.net.GExecutor;

public class AtvListLocation
  extends AtvBase
  implements GListView.IMakeView
{
  public static final int REQ_CODE = 7894;
  private ArrayList<JSONObject> mArrayList = new ArrayList();
  private LinearLayout mBaseFee = null;
  private LinearLayout mBaseHeader = null;
  private LinearLayout mBaseName = null;
  private LinearLayout mBaseNodata = null;
  private LinearLayout mBaseRound = null;
  private Calendar mCalendar_Now = Calendar.getInstance();
  private Comparator<JSONObject> mComparator_dates = new Comparator()
  {
    public int compare(JSONObject paramAnonymousJSONObject1, JSONObject paramAnonymousJSONObject2)
    {
      return JSONUtil.getString(paramAnonymousJSONObject1, "dates", "").compareTo(JSONUtil.getString(paramAnonymousJSONObject2, "dates", ""));
    }
  };
  private Comparator<JSONObject> mComparator_fee = new Comparator()
  {
    public int compare(JSONObject paramAnonymousJSONObject1, JSONObject paramAnonymousJSONObject2)
    {
      return JSONUtil.getString(paramAnonymousJSONObject1, "greenFee", "").compareTo(JSONUtil.getString(paramAnonymousJSONObject2, "greenFee", ""));
    }
  };
  private Comparator<JSONObject> mComparator_name = new Comparator()
  {
    public int compare(JSONObject paramAnonymousJSONObject1, JSONObject paramAnonymousJSONObject2)
    {
      return JSONUtil.getString(paramAnonymousJSONObject1, "name", "").compareTo(JSONUtil.getString(paramAnonymousJSONObject2, "name", ""));
    }
  };
  private Comparator<JSONObject> mComparator_registDT = new Comparator()
  {
    public int compare(JSONObject paramAnonymousJSONObject1, JSONObject paramAnonymousJSONObject2)
    {
      return JSONUtil.getString(paramAnonymousJSONObject1, "registDT", "").compareTo(JSONUtil.getString(paramAnonymousJSONObject2, "registDT", ""));
    }
  };
  private LinearLayout mHeader = null;
  private JSONObject mInfo = null;
  private boolean mIsAll = false;
  private boolean mIsNameDoule = false;
  private GListView mList = null;
  private int mTopCnt = 0;
  private TextView mTxtHeader4 = null;
  private TextView mTxtNodata = null;
  private int mType = 0;
  
  private void callApi_getListOfTransferJoin_Location(final boolean paramBoolean)
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("ApiTransferJoin.getListOfTransferJoin_Location");
    if (this.mType == 100) {
      localGPClient.addParameter("transferJoinTypeID", Integer.valueOf(1));
    }
    for (;;)
    {
      localGPClient.addParameter("location_fk", JSONUtil.getString(this.mInfo, "no", ""));
      if (!this.mIsAll) {
        localGPClient.addParameter("dates", JSONUtil.getString(this.mInfo, "date", ""));
      }
      localGPClient.setDecoder(new GJSONDecoder(2));
      localGPClient.addProgress();
      localGPClient.addHandler(new GFailedHandler()
      {
        public void failedExecute(GBean paramAnonymousGBean)
        {
          Alert.toastLong(AtvListLocation.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
        }
      });
      localGPClient.addHandler(new GResultHandler()
      {
        public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          if (paramBoolean)
          {
            AtvListLocation.this.mArrayList.clear();
            AtvListLocation.this.mList.removeAll();
          }
          JSONArray localJSONArray;
          if (paramAnonymousInt > 0)
          {
            AtvListLocation.this.mList.removeAll();
            AtvListLocation.this.mTopCnt = JSONUtil.getInteger(paramAnonymousJSONObject, "entityCount", 0);
            AtvListLocation.this.mList.addItems(JSONUtil.getJSONArray(paramAnonymousJSONObject, "entityTop"));
            localJSONArray = (JSONArray)paramAnonymousObject;
          }
          for (int i = 0;; i++)
          {
            if ((localJSONArray == null) || (i >= localJSONArray.length()))
            {
              AtvListLocation.this.mList.addItems(AtvListLocation.this.mArrayList);
              AtvListLocation.this.setNodata();
              return null;
            }
            JSONObject localJSONObject = JSONUtil.getJSONObject(localJSONArray, i);
            AtvListLocation.this.mArrayList.add(localJSONObject);
          }
        }
      });
      GExecutor.getInstance().execute(localGPClient);
      return;
      if (this.mType == 200) {
        localGPClient.addParameter("transferJoinTypeID", Integer.valueOf(2));
      }
    }
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
      this.mList.getLayoutParams().height = -1;
      return;
    }
    this.mBaseNodata.setVisibility(0);
    this.mList.getLayoutParams().height = -2;
    this.mTxtNodata.setText("검색결과가 없습니다.");
  }
  
  private void sortList()
  {
    this.mTopCnt = -1;
    if ((this.mBaseName.isSelected()) || (this.mIsNameDoule))
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      int i = 0;
      if (i >= this.mArrayList.size())
      {
        Collections.sort(localArrayList2, this.mComparator_name);
        Collections.sort(localArrayList1, this.mComparator_name);
        Collections.sort(localArrayList3, this.mComparator_name);
        this.mList.removeAll();
        if (!this.mIsNameDoule) {
          break label267;
        }
        this.mList.addItems(localArrayList1);
        this.mList.addItems(localArrayList2);
      }
      for (;;)
      {
        this.mList.addItems(localArrayList3);
        return;
        JSONObject localJSONObject1 = (JSONObject)this.mArrayList.get(i);
        String str = JSONUtil.getString(localJSONObject1, "name", "");
        if (FormatUtil.isNullorEmpty(str)) {
          localArrayList3.add(localJSONObject1);
        }
        for (;;)
        {
          i++;
          break;
          int j = str.charAt(0);
          int k;
          if ((48 <= j) && (j <= 57))
          {
            k = 1;
            label196:
            if ((44032 > j) || (j > 55203)) {
              break label236;
            }
          }
          label236:
          for (int m = 1;; m = 0)
          {
            if (k == 0) {
              break label242;
            }
            localArrayList3.add(localJSONObject1);
            break;
            k = 0;
            break label196;
          }
          label242:
          if (m != 0) {
            localArrayList2.add(localJSONObject1);
          } else {
            localArrayList1.add(localJSONObject1);
          }
        }
        label267:
        this.mList.addItems(localArrayList2);
        this.mList.addItems(localArrayList1);
      }
    }
    if (this.mBaseRound.isSelected())
    {
      Collections.sort(this.mArrayList, this.mComparator_dates);
      this.mList.removeAll();
      this.mList.addItems(this.mArrayList);
      return;
    }
    if (this.mBaseFee.isSelected()) {
      for (int n = 0;; n++)
      {
        if (n >= this.mArrayList.size())
        {
          Collections.sort(this.mArrayList, this.mComparator_fee);
          this.mList.removeAll();
          this.mList.addItems(this.mArrayList);
          return;
        }
        int i1 = JSONUtil.getInteger((JSONObject)this.mArrayList.get(n), "greenFee");
        JSONObject localJSONObject2 = (JSONObject)this.mArrayList.get(n);
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(i1);
        JSONUtil.put(localJSONObject2, "greenFee", String.format("%07d", arrayOfObject));
      }
    }
    this.mList.removeAll();
    this.mList.addItems(this.mArrayList);
  }
  
  protected void configureListener()
  {
    this.mTxtTopTitleLeft.setOnClickListener(ListenerUtil.getFinishButtonListener(getContext()));
    this.mImgTopTitleLeft.setOnClickListener(ListenerUtil.getFinishButtonListener(getContext()));
    this.mBtnTopRight.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (!AtvListLocation.this.checkLogin(true)) {
          return;
        }
        Intent localIntent = new Intent(AtvListLocation.this.getContext(), AtvRegist.class);
        localIntent.putExtra("EXTRAS_TYPE", AtvListLocation.this.mType);
        AtvListLocation.this.startActivityForResult(localIntent, 7894);
      }
    });
    this.mBaseName.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvListLocation.this.mIsNameDoule = paramAnonymousView.isSelected();
        AtvListLocation.this.mBaseRound.setSelected(false);
        AtvListLocation.this.mBaseFee.setSelected(false);
        boolean bool1 = paramAnonymousView.isSelected();
        boolean bool2 = false;
        if (bool1) {}
        for (;;)
        {
          paramAnonymousView.setSelected(bool2);
          AtvListLocation.this.sortList();
          return;
          bool2 = true;
        }
      }
    });
    this.mBaseRound.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvListLocation.this.mIsNameDoule = false;
        AtvListLocation.this.mBaseName.setSelected(false);
        AtvListLocation.this.mBaseFee.setSelected(false);
        boolean bool1 = paramAnonymousView.isSelected();
        boolean bool2 = false;
        if (bool1) {}
        for (;;)
        {
          paramAnonymousView.setSelected(bool2);
          AtvListLocation.this.sortList();
          return;
          bool2 = true;
        }
      }
    });
    this.mBaseFee.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvListLocation.this.mIsNameDoule = false;
        AtvListLocation.this.mBaseName.setSelected(false);
        AtvListLocation.this.mBaseRound.setSelected(false);
        boolean bool1 = paramAnonymousView.isSelected();
        boolean bool2 = false;
        if (bool1) {}
        for (;;)
        {
          paramAnonymousView.setSelected(bool2);
          AtvListLocation.this.sortList();
          return;
          bool2 = true;
        }
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
    this.mHeader = ((LinearLayout)InflateUtil.inflate(getContext(), 2130903074, null));
    this.mBaseHeader.addView(this.mHeader, new LinearLayout.LayoutParams(-1, -2));
    this.mBaseName = ((LinearLayout)this.mHeader.findViewById(2131362031));
    this.mBaseRound = ((LinearLayout)this.mHeader.findViewById(2131362032));
    this.mTxtHeader4 = ((TextView)this.mHeader.findViewById(2131362034));
    this.mBaseFee = ((LinearLayout)this.mHeader.findViewById(2131362033));
  }
  
  protected boolean getBundle()
  {
    this.mInfo = JSONUtil.createObject(getIntent(), "EXTRAS_JSON_STRING");
    this.mType = getIntent().getIntExtra("EXTRAS_TYPE", 0);
    this.mIsAll = JSONUtil.getBoolean(this.mInfo, "isAll", false);
    int i = this.mType;
    boolean bool1 = false;
    if (i > 0)
    {
      boolean bool2 = FormatUtil.isNullorEmpty(this.mInfo);
      bool1 = false;
      if (!bool2) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected void init()
  {
    this.mBtnTopRight.setVisibility(0);
    this.mImgTopTitleLeft.setVisibility(0);
    this.mTxtTopTitleLeft.setVisibility(0);
    this.mTxtTopTitleCenter.setVisibility(0);
    FormatUtil.getDateStringToCalendar(JSONUtil.getString(this.mInfo, "date", ""), "yyyy-MM-dd");
    this.mTxtTopTitleLeft.setText(JSONUtil.getString(this.mInfo, "loc_name", ""));
    this.mBaseRound.setSelected(true);
    if (this.mType == 200)
    {
      this.mBtnTopRight.setText("조인등록");
      this.mImgTopTitleLeft.setImageResource(2130837656);
      if (!this.mIsAll) {
        this.mTxtTopTitleCenter.setText("라운드 조인");
      }
    }
    for (;;)
    {
      this.mList.setViewMaker(2130903087, this);
      callApi_getListOfTransferJoin_Location(true);
      return;
      this.mBtnTopRight.setText("양도등록");
      this.mImgTopTitleLeft.setImageResource(2130837658);
      if (!this.mIsAll) {
        this.mTxtTopTitleCenter.setText("Tee 양도");
      }
    }
  }
  
  public View makeView(GListView.GListAdapter paramGListAdapter, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    final JSONObject localJSONObject = (JSONObject)paramGListAdapter.getItem(paramInt);
    TextView localTextView1 = (TextView)paramView.findViewById(2131362060);
    TextView localTextView2 = (TextView)paramView.findViewById(2131361869);
    TextView localTextView3 = (TextView)paramView.findViewById(2131361873);
    TextView localTextView4 = (TextView)paramView.findViewById(2131361833);
    TextView localTextView5 = (TextView)paramView.findViewById(2131361871);
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131362062);
    Calendar localCalendar1;
    Calendar localCalendar2;
    long l;
    label181:
    label222:
    TextView localTextView6;
    label260:
    label310:
    ImageView localImageView;
    label345:
    label379:
    int j;
    label424:
    int m;
    if (paramInt < this.mTopCnt)
    {
      localLinearLayout.setBackgroundResource(2130837711);
      localCalendar1 = FormatUtil.getDateStringToCalendar(JSONUtil.getString(localJSONObject, "registDT", ""), "yyyy-MM-dd HH:mm:ss");
      localCalendar2 = FormatUtil.getDateStringToCalendar(JSONUtil.getString(localJSONObject, "dates", ""), "yyyy-MM-dd HH:mm:ss");
      l = FormatUtil.diffOfDate(JSONUtil.getString(localJSONObject, "registDT", ""));
      int i = JSONUtil.getInteger(localJSONObject, "wCount", 0);
      if (1 != i) {
        break label549;
      }
      localTextView1.setText(" 불량 정보");
      localTextView1.setTextColor(-2023132);
      localTextView4.setText(FormatUtil.toPriceFormat(JSONUtil.getInteger(localJSONObject, "greenFee", 0)));
      if ((l < 3L) && (1 != i)) {
        break label655;
      }
      localTextView4.setTextColor(-4342339);
      localTextView2.setText(JSONUtil.getString(localJSONObject, "name", ""));
      if ((l < 3L) && (1 != i)) {
        break label666;
      }
      localTextView2.setTextColor(-4342339);
      localTextView6 = (TextView)paramView.findViewById(2131362061);
      localTextView6.setText(JSONUtil.getString(localJSONObject, "nick_name", ""));
      if ((l < 3L) && (1 != i)) {
        break label677;
      }
      localTextView6.setTextColor(-4342339);
      localImageView = (ImageView)paramView.findViewById(2131362063);
      if (!FormatUtil.isNullorEmpty(JSONUtil.getString(localJSONObject, "reqID", ""))) {
        break label688;
      }
      localImageView.setVisibility(8);
      localTextView3.setText(getDate(localCalendar2));
      if ((l < 3L) && (1 != i)) {
        break label697;
      }
      localTextView3.setTextColor(-4342339);
      localTextView5.setVisibility(0);
      j = JSONUtil.getInteger(localJSONObject, "hole", 0);
      switch (j)
      {
      default: 
        if (this.mType == 200)
        {
          int k = JSONUtil.getInteger(localJSONObject, "joinTypeStr", 0);
          m = JSONUtil.getInteger(localJSONObject, "counts", 0);
          switch (k)
          {
          default: 
            localTextView5.setText("");
            label495:
            if ((l >= 3L) || (1 == i)) {
              localTextView5.setTextColor(-4342339);
            }
            break;
          }
        }
        break;
      }
    }
    for (;;)
    {
      View.OnClickListener local9 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Intent localIntent = new Intent(paramAnonymousView.getContext(), AtvDetail.class);
          localIntent.putExtra("EXTRAS_ID", JSONUtil.getInteger(localJSONObject, "transferJoinID", 0));
          AtvListLocation.this.startActivityForResult(localIntent, 7890);
        }
      };
      paramView.setOnClickListener(local9);
      return paramView;
      localLinearLayout.setBackgroundResource(2130837710);
      break;
      label549:
      if (l == 0L) {
        localTextView1.setText(" 등록 " + FormatUtil.getRegistDT(localCalendar1, this.mCalendar_Now));
      }
      for (;;)
      {
        if (l < 3L) {
          break label638;
        }
        localTextView1.setTextColor(-4342339);
        break;
        localTextView1.setText(" 등록 " + l + "일전");
      }
      label638:
      localTextView1.setTextColor(FormatUtil.getRegistDTColor(localCalendar1, this.mCalendar_Now));
      break label181;
      label655:
      localTextView4.setTextColor(-2023132);
      break label222;
      label666:
      localTextView2.setTextColor(-13421773);
      break label260;
      label677:
      localTextView6.setTextColor(-13421773);
      break label310;
      label688:
      localImageView.setVisibility(0);
      break label345;
      label697:
      localTextView3.setTextColor(FormatUtil.getDateColor(localCalendar2));
      break label379;
      j = 18;
      break label424;
      j = 27;
      break label424;
      j = 36;
      break label424;
      localTextView5.setText(j + "홀 / " + m + "명 /" + " 무관");
      break label495;
      localTextView5.setText(j + "홀 / " + "부부/커플");
      break label495;
      localTextView5.setText(j + "홀 / " + m + "명 /" + " 남자");
      break label495;
      localTextView5.setText(j + "홀 / " + m + "명 /" + " 여자");
      break label495;
      localTextView5.setText(j + "홀");
      break label495;
      localTextView5.setTextColor(-13421773);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      setResult(-1);
      callApi_getListOfTransferJoin_Location(true);
    }
  }
  
  protected void setView()
  {
    setView(2130903053);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.atv.schedule.AtvListLocation
 * JD-Core Version:    0.7.0.1
 */