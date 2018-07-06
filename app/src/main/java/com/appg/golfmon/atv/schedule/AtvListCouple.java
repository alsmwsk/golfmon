package com.appg.golfmon.atv.schedule;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.appg.golfmon.GMApp;
import com.appg.golfmon.GMApp.LocationCallBack;
import com.appg.golfmon.atv.AtvBase;
import com.appg.golfmon.atv.AtvMapSelect;
import com.appg.golfmon.net.http.GFailedHandler;
import com.appg.golfmon.net.http.GJSONDecoder;
import com.appg.golfmon.net.http.GPClient;
import com.appg.golfmon.net.http.GResultHandler;
import com.appg.golfmon.util.Alert;
import com.appg.golfmon.util.Alert.OnCloseListener;
import com.appg.golfmon.util.FormatUtil;
import com.appg.golfmon.util.InflateUtil;
import com.appg.golfmon.util.JSONUtil;
import com.appg.golfmon.util.LogUtil;
import com.appg.golfmon.util.ProgressDialogUtil;
import com.appg.golfmon.util.SPUtil;
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

public class AtvListCouple
  extends AtvBase
  implements GListView.IMakeView
{
  public static final int REQ_CODE = 7893;
  private GMApp mApp = null;
  private ArrayList<JSONObject> mArrayList = new ArrayList();
  private LinearLayout mBaseFee = null;
  private LinearLayout mBaseHeader = null;
  private LinearLayout mBaseName = null;
  private LinearLayout mBaseNodata = null;
  private LinearLayout mBaseRound = null;
  private Button mBtnMyLocation = null;
  private Button mBtnTab_01 = null;
  private Button mBtnTab_02 = null;
  private Button mBtnTab_03 = null;
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
  private boolean mIsNameDoule = false;
  private int mLatitude = 37521290;
  private GListView mList = null;
  private int mLongiutde = 126973027;
  private Dialog mProgress = null;
  private int mSelTab = 0;
  private int mTopCnt = 0;
  private TextView mTxtMyLocation = null;
  private TextView mTxtNodata = null;
  private int mType = 0;
  
  private void callApi_getListOfTransferJoin_Couple(final boolean paramBoolean)
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("ApiTransferJoin.getListOfTransferJoin_Couple");
    if (this.mType == 100) {
      localGPClient.addParameter("transferJoinTypeID", Integer.valueOf(1));
    }
    for (;;)
    {
      localGPClient.addParameter("distanceTypeID", Integer.valueOf(this.mSelTab));
      localGPClient.addParameter("latitude", Integer.valueOf(this.mLatitude));
      localGPClient.addParameter("longitude", Integer.valueOf(this.mLongiutde));
      localGPClient.setDecoder(new GJSONDecoder(2));
      localGPClient.addProgress();
      localGPClient.addHandler(new GFailedHandler()
      {
        public void failedExecute(GBean paramAnonymousGBean)
        {
          Alert.toastLong(AtvListCouple.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
        }
      });
      localGPClient.addHandler(new GResultHandler()
      {
        public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          if (paramBoolean)
          {
            AtvListCouple.this.mArrayList.clear();
            AtvListCouple.this.mList.removeAll();
          }
          JSONArray localJSONArray;
          if (paramAnonymousInt > 0)
          {
            AtvListCouple.this.mList.removeAll();
            AtvListCouple.this.mTopCnt = JSONUtil.getInteger(paramAnonymousJSONObject, "entityCount", 0);
            AtvListCouple.this.mList.addItems(JSONUtil.getJSONArray(paramAnonymousJSONObject, "entityTop"));
            localJSONArray = (JSONArray)paramAnonymousObject;
          }
          for (int i = 0;; i++)
          {
            if ((localJSONArray == null) || (i >= localJSONArray.length()))
            {
              AtvListCouple.this.mList.addItems(AtvListCouple.this.mArrayList);
              AtvListCouple.this.setNodata();
              return null;
            }
            JSONObject localJSONObject = JSONUtil.getJSONObject(localJSONArray, i);
            AtvListCouple.this.mArrayList.add(localJSONObject);
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
  
  private void checkLocatinAgree()
  {
    if (SPUtil.getInstance().getAgreeLocation(this))
    {
      checkLocatinProvider();
      return;
    }
    Alert localAlert = new Alert();
    localAlert.setOnCloseListener(new Alert.OnCloseListener()
    {
      public void onClose(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, Object paramAnonymousObject)
      {
        if (1 == paramAnonymousInt)
        {
          SPUtil.getInstance().setAgreeLocation(AtvListCouple.this.getContext(), true);
          AtvListCouple.this.checkLocatinProvider();
          return;
        }
        AtvListCouple.this.setLocationFail("checkLocatinAgree");
      }
    });
    localAlert.showAlert(this, "위치 서비스 사용동의", "위치정보를 사용하는데 동의합니까?\n*동의하지 않으시면 서울시청으로 위치가 자동 지정됩니다.", false, new String[] { "동의합니다", "동의하지않습니다." });
  }
  
  private void checkLocatinProvider()
  {
    if (this.mApp.isProviderOn())
    {
      startLocation();
      return;
    }
    Alert localAlert = new Alert();
    localAlert.setOnCloseListener(new Alert.OnCloseListener()
    {
      public void onClose(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, Object paramAnonymousObject)
      {
        if (1 == paramAnonymousInt)
        {
          Intent localIntent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
          localIntent.addCategory("android.intent.category.DEFAULT");
          AtvListCouple.this.startActivityForResult(localIntent, 1597);
          return;
        }
        AtvListCouple.this.startLocation();
      }
    });
    localAlert.showAlert(this, "시스템 설정에서 위치정보서비스(Wi-Fi, 모바일네트워크)를 사용하도록 설정해주세요", false, new String[] { "설정", "취소" });
  }
  
  private String getDate(Calendar paramCalendar)
  {
    if (paramCalendar == null) {
      return "";
    }
    return FormatUtil.getDateCalendarToString(paramCalendar, "MM/dd") + "(" + FormatUtil.getDateDayOfWeek(paramCalendar, false) + ") " + FormatUtil.getDateCalendarToString(paramCalendar, "HH:mm");
  }
  
  private void setLocation(String paramString)
  {
    String[] arrayOfString = this.mApp.getAddress(this.mApp.getLocationType());
    this.mTxtMyLocation.setText("");
    for (int i = 0;; i++)
    {
      if (i >= arrayOfString.length)
      {
        int[] arrayOfInt = this.mApp.getGeoPoint(this.mApp.getLocationType());
        this.mLatitude = arrayOfInt[0];
        this.mLongiutde = arrayOfInt[1];
        callApi_getListOfTransferJoin_Couple(true);
        return;
      }
      if (!FormatUtil.isNullorEmpty(arrayOfString[i]))
      {
        if (this.mTxtMyLocation.getText().length() > 0) {
          this.mTxtMyLocation.append(" ");
        }
        this.mTxtMyLocation.append(arrayOfString[i]);
      }
    }
  }
  
  private void setLocationFail(String paramString)
  {
    Alert localAlert = new Alert();
    localAlert.setOnCloseListener(new Alert.OnCloseListener()
    {
      public void onClose(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, Object paramAnonymousObject)
      {
        if (1 == paramAnonymousInt)
        {
          Intent localIntent = new Intent(AtvListCouple.this.getContext(), AtvMapSelect.class);
          AtvListCouple.this.startActivityForResult(localIntent, 1596);
        }
      }
    });
    localAlert.showAlert(this, "위치를 가져올 수 없습니다.\n지도에서 설정하시겠습니까?", true, new String[] { "설정", "취소" });
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
  
  private void setTab(int paramInt)
  {
    this.mSelTab = paramInt;
    Button localButton1 = this.mBtnTab_01;
    boolean bool1;
    Button localButton2;
    if (this.mSelTab == 1)
    {
      bool1 = true;
      localButton1.setSelected(bool1);
      localButton2 = this.mBtnTab_02;
      if (this.mSelTab != 2) {
        break label98;
      }
    }
    label98:
    for (boolean bool2 = true;; bool2 = false)
    {
      localButton2.setSelected(bool2);
      Button localButton3 = this.mBtnTab_03;
      int i = this.mSelTab;
      boolean bool3 = false;
      if (i == 3) {
        bool3 = true;
      }
      localButton3.setSelected(bool3);
      this.mList.removeAll();
      callApi_getListOfTransferJoin_Couple(true);
      return;
      bool1 = false;
      break;
    }
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
        Collections.sort(localArrayList1, this.mComparator_name);
        Collections.sort(localArrayList2, this.mComparator_name);
        Collections.sort(localArrayList3, this.mComparator_name);
        this.mList.removeAll();
        if (!this.mIsNameDoule) {
          break label268;
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
            label197:
            if ((44032 > j) || (j > 55203)) {
              break label237;
            }
          }
          label237:
          for (int m = 1;; m = 0)
          {
            if (k == 0) {
              break label243;
            }
            localArrayList3.add(localJSONObject1);
            break;
            k = 0;
            break label197;
          }
          label243:
          if (m != 0) {
            localArrayList2.add(localJSONObject1);
          } else {
            localArrayList1.add(localJSONObject1);
          }
        }
        label268:
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
  
  private void startLocation()
  {
    LogUtil.e("aaaaaaaaaaaa startLocation 메소드");
    this.mProgress = ProgressDialogUtil.show(getContext(), this.mProgress);
    this.mApp.start();
    this.mApp.getLocation(new GMApp.LocationCallBack()
    {
      public void onResult(int paramAnonymousInt)
      {
        AtvListCouple.this.mApp.getLocation(null);
        AtvListCouple.this.mApp.stop();
        int[] arrayOfInt = AtvListCouple.this.mApp.getGeoPoint(1);
        if (paramAnonymousInt == 100) {
          if ((arrayOfInt[0] == -1) && (arrayOfInt[1] == -1)) {
            AtvListCouple.this.setLocationFail("getLocation");
          }
        }
        for (;;)
        {
          ProgressDialogUtil.dismiss(AtvListCouple.this.mProgress);
          return;
          AtvListCouple.this.callApi_getInfoOfAddressOfGeocode(arrayOfInt[0], arrayOfInt[1], 1);
          continue;
          AtvListCouple.this.setLocationFail("getLocation");
        }
      }
    });
  }
  
  public void callApi_getInfoOfAddressOfGeocode(int paramInt1, int paramInt2, final int paramInt3)
  {
    GPClient localGPClient = new GPClient(this);
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("Api.getInfoOfAddressOfGeocode");
    localGPClient.addParameter("lat", Integer.valueOf(paramInt1));
    localGPClient.addParameter("lng", Integer.valueOf(paramInt2));
    localGPClient.addProgress();
    localGPClient.setDecoder(new GJSONDecoder(2));
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        AtvListCouple.this.setLocationFail("callApi_getInfoOfAddressOfGeocode");
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        if (paramAnonymousInt > 0)
        {
          JSONArray localJSONArray = (JSONArray)paramAnonymousObject;
          AtvListCouple.this.mApp.saveAddress(localJSONArray, paramInt3);
          AtvListCouple.this.mApp.saveLocationType(paramInt3);
          AtvListCouple.this.setLocation("주소가져옴");
        }
        return null;
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  protected void configureListener()
  {
    this.mBtnTopRight.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (!AtvListCouple.this.checkLogin(true)) {
          return;
        }
        Intent localIntent = new Intent(AtvListCouple.this.getContext(), AtvRegist.class);
        localIntent.putExtra("EXTRAS_TYPE", AtvListCouple.this.mType);
        AtvListCouple.this.startActivityForResult(localIntent, 7894);
      }
    });
    this.mTxtTopTitleLeft.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvListCouple.this.setTab(0);
      }
    });
    this.mBtnTab_01.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (paramAnonymousView.isSelected())
        {
          AtvListCouple.this.setTab(0);
          return;
        }
        AtvListCouple.this.setTab(1);
      }
    });
    this.mBtnTab_02.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (paramAnonymousView.isSelected())
        {
          AtvListCouple.this.setTab(0);
          return;
        }
        AtvListCouple.this.setTab(2);
      }
    });
    this.mBtnTab_03.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (paramAnonymousView.isSelected())
        {
          AtvListCouple.this.setTab(0);
          return;
        }
        AtvListCouple.this.setTab(3);
      }
    });
    this.mBaseName.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvListCouple.this.mIsNameDoule = paramAnonymousView.isSelected();
        AtvListCouple.this.mBaseRound.setSelected(false);
        AtvListCouple.this.mBaseFee.setSelected(false);
        boolean bool1 = paramAnonymousView.isSelected();
        boolean bool2 = false;
        if (bool1) {}
        for (;;)
        {
          paramAnonymousView.setSelected(bool2);
          AtvListCouple.this.sortList();
          return;
          bool2 = true;
        }
      }
    });
    this.mBaseRound.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvListCouple.this.mIsNameDoule = false;
        AtvListCouple.this.mBaseName.setSelected(false);
        AtvListCouple.this.mBaseFee.setSelected(false);
        boolean bool1 = paramAnonymousView.isSelected();
        boolean bool2 = false;
        if (bool1) {}
        for (;;)
        {
          paramAnonymousView.setSelected(bool2);
          AtvListCouple.this.sortList();
          return;
          bool2 = true;
        }
      }
    });
    this.mBtnMyLocation.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvListCouple.this.checkLocatinAgree();
      }
    });
    this.mBaseFee.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvListCouple.this.mIsNameDoule = false;
        AtvListCouple.this.mBaseName.setSelected(false);
        AtvListCouple.this.mBaseRound.setSelected(false);
        boolean bool1 = paramAnonymousView.isSelected();
        boolean bool2 = false;
        if (bool1) {}
        for (;;)
        {
          paramAnonymousView.setSelected(bool2);
          AtvListCouple.this.sortList();
          return;
          bool2 = true;
        }
      }
    });
  }
  
  protected void findView()
  {
    this.mTxtMyLocation = ((TextView)findViewById(2131361895));
    this.mBtnMyLocation = ((Button)findViewById(2131361896));
    this.mList = ((GListView)findViewById(2131361864));
    this.mBaseNodata = ((LinearLayout)findViewById(2131361865));
    this.mTxtNodata = ((TextView)findViewById(2131361866));
    this.mBaseHeader = new LinearLayout(getContext());
    this.mList.addHeaderView(this.mBaseHeader);
    this.mHeader = ((LinearLayout)InflateUtil.inflate(getContext(), 2130903073, null));
    this.mBaseHeader.addView(this.mHeader);
    this.mBtnTab_01 = ((Button)this.mHeader.findViewById(2131362028));
    this.mBtnTab_02 = ((Button)this.mHeader.findViewById(2131362029));
    this.mBtnTab_03 = ((Button)this.mHeader.findViewById(2131362030));
    this.mBaseName = ((LinearLayout)this.mHeader.findViewById(2131362031));
    this.mBaseRound = ((LinearLayout)this.mHeader.findViewById(2131362032));
    this.mBaseFee = ((LinearLayout)this.mHeader.findViewById(2131362033));
  }
  
  protected boolean getBundle()
  {
    this.mType = getIntent().getIntExtra("EXTRAS_TYPE", 0);
    int i = this.mType;
    boolean bool = false;
    if (i > 0) {
      bool = true;
    }
    return bool;
  }
  
  protected void init()
  {
    this.mApp = ((GMApp)getApplication());
    this.mTxtTopTitleLeft.setVisibility(0);
    this.mBtnTopRight.setVisibility(0);
    if (this.mType == 200)
    {
      this.mTxtTopTitleLeft.setText("부부커플 라운드 조인");
      this.mBtnTopRight.setText("조인등록");
    }
    for (;;)
    {
      this.mList.setViewMaker(2130903087, this);
      if (!SPUtil.getInstance().getAgreeLocation(this)) {
        break;
      }
      setTab(this.mSelTab);
      setLocation("init");
      return;
      this.mTxtTopTitleLeft.setText("야간(라이트) 양도");
      this.mBtnTopRight.setText("양도등록");
    }
    this.mLatitude = 37565909;
    this.mLongiutde = 126978500;
    this.mTxtMyLocation.setText("서울시 중구 소공동");
    setTab(this.mSelTab);
  }
  
  public View makeView(GListView.GListAdapter paramGListAdapter, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    final JSONObject localJSONObject = (JSONObject)paramGListAdapter.getItem(paramInt);
    TextView localTextView1 = (TextView)paramView.findViewById(2131362060);
    TextView localTextView2 = (TextView)paramView.findViewById(2131361869);
    TextView localTextView3 = (TextView)paramView.findViewById(2131361873);
    TextView localTextView4 = (TextView)paramView.findViewById(2131361833);
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131362062);
    Calendar localCalendar1;
    Calendar localCalendar2;
    long l;
    label173:
    label212:
    label246:
    TextView localTextView5;
    label287:
    label338:
    ImageView localImageView;
    label414:
    TextView localTextView6;
    int j;
    if (paramInt < this.mTopCnt)
    {
      localLinearLayout.setBackgroundResource(2130837711);
      localCalendar1 = FormatUtil.getDateStringToCalendar(JSONUtil.getString(localJSONObject, "registDT", ""), "yyyy-MM-dd HH:mm:ss");
      localCalendar2 = FormatUtil.getDateStringToCalendar(JSONUtil.getString(localJSONObject, "dates", ""), "yyyy-MM-dd HH:mm:ss");
      l = FormatUtil.diffOfDate(JSONUtil.getString(localJSONObject, "registDT", ""));
      int i = JSONUtil.getInteger(localJSONObject, "wCount", 0);
      if (1 != i) {
        break label568;
      }
      localTextView1.setText(" 불량 정보");
      localTextView1.setTextColor(-2023132);
      localTextView2.setText(JSONUtil.getString(localJSONObject, "name", ""));
      if ((l < 3L) && (1 != i)) {
        break label674;
      }
      localTextView2.setTextColor(-4342339);
      localTextView3.setText(getDate(localCalendar2));
      if ((l < 3L) && (1 != i)) {
        break label685;
      }
      localTextView3.setTextColor(-4342339);
      localTextView4.setText(FormatUtil.toPriceFormat(JSONUtil.getInteger(localJSONObject, "greenFee", 0)));
      if ((l < 3L) && (1 != i)) {
        break label698;
      }
      localTextView4.setTextColor(-4342339);
      localTextView5 = (TextView)paramView.findViewById(2131362061);
      localTextView5.setText(JSONUtil.getString(localJSONObject, "nick_name", ""));
      if ((l < 3L) && (1 != i)) {
        break label709;
      }
      localTextView5.setTextColor(-4342339);
      localImageView = (ImageView)paramView.findViewById(2131362063);
      if ((!FormatUtil.isNullorEmpty(JSONUtil.getString(localJSONObject, "reqID", ""))) && (!JSONUtil.getString(localJSONObject, "statusTypeID", "").equals("1")) && (!JSONUtil.getString(localJSONObject, "reqID", "").equals("0"))) {
        break label720;
      }
      localImageView.setVisibility(8);
      localTextView6 = (TextView)paramView.findViewById(2131361871);
      localTextView6.setVisibility(0);
      j = JSONUtil.getInteger(localJSONObject, "hole", 0);
      switch (j)
      {
      default: 
        label472:
        if (this.mType == 200)
        {
          localTextView6.setText(j + "홀 / " + "부부/커플");
          if ((l < 3L) && (1 != i)) {
            break label779;
          }
          localTextView6.setTextColor(-4342339);
        }
        label514:
        break;
      }
    }
    for (;;)
    {
      View.OnClickListener local14 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Intent localIntent = new Intent(paramAnonymousView.getContext(), AtvDetail.class);
          localIntent.putExtra("EXTRAS_ID", JSONUtil.getInteger(localJSONObject, "transferJoinID", 0));
          AtvListCouple.this.startActivityForResult(localIntent, 7890);
        }
      };
      paramView.setOnClickListener(local14);
      return paramView;
      localLinearLayout.setBackgroundResource(2130837710);
      break;
      label568:
      if (l == 0L) {
        localTextView1.setText(" 등록 " + FormatUtil.getRegistDT(localCalendar1, this.mCalendar_Now));
      }
      for (;;)
      {
        if (l < 3L) {
          break label657;
        }
        localTextView1.setTextColor(-4342339);
        break;
        localTextView1.setText(" 등록 " + l + "일전");
      }
      label657:
      localTextView1.setTextColor(FormatUtil.getRegistDTColor(localCalendar1, this.mCalendar_Now));
      break label173;
      label674:
      localTextView2.setTextColor(-13421773);
      break label212;
      label685:
      localTextView3.setTextColor(FormatUtil.getDateColor(localCalendar2));
      break label246;
      label698:
      localTextView4.setTextColor(-2023132);
      break label287;
      label709:
      localTextView5.setTextColor(-13421773);
      break label338;
      label720:
      localImageView.setVisibility(0);
      break label414;
      j = 18;
      break label472;
      j = 27;
      break label472;
      j = 36;
      break label472;
      localTextView6.setText(j + "홀");
      break label514;
      label779:
      localTextView6.setTextColor(-13421773);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1596) {
      if (paramInt2 == -1) {
        setLocation("onActivityResult");
      }
    }
    while (paramInt2 != -1) {
      return;
    }
    setResult(-1);
    callApi_getListOfTransferJoin_Couple(true);
  }
  
  protected void setView()
  {
    setView(2130903052);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.atv.schedule.AtvListCouple
 * JD-Core Version:    0.7.0.1
 */