package com.appg.golfmon.atv.schedule;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.appg.golfmon.adapter.DatePagerAdapter;
import com.appg.golfmon.adapter.DatePagerAdapter.DataSet;
import com.appg.golfmon.atv.AtvBase;
import com.appg.golfmon.atv.AtvMain;
import com.appg.golfmon.atv.event.AtvEvent;
import com.appg.golfmon.atv.more.AtvMore;
import com.appg.golfmon.common.InterfaceSet.OnClickJsonListener;
import com.appg.golfmon.common.InterfaceSet.TabClickListener;
import com.appg.golfmon.net.http.GFailedHandler;
import com.appg.golfmon.net.http.GJSONDecoder;
import com.appg.golfmon.net.http.GPClient;
import com.appg.golfmon.net.http.GResultHandler;
import com.appg.golfmon.util.Alert;
import com.appg.golfmon.util.FormatUtil;
import com.appg.golfmon.util.InflateUtil;
import com.appg.golfmon.util.JSONUtil;
import com.appg.golfmon.util.ListenerUtil;
import com.appg.golfmon.util.LogUtil;
import com.appg.golfmon.view.TabMain;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONObject;
import ra.genius.net.GBean;
import ra.genius.net.GExecutor;

public class AtvListAll
  extends AtvBase
{
  public static final int REQ_CODE = 7891;
  private DatePagerAdapter mAdapter = null;
  private LinearLayout mBaseCouple = null;
  private LinearLayout mBaseUrgent = null;
  private Calendar mCalendar = Calendar.getInstance();
  private ImageView mImgPrev = null;
  private String mNowDT = "";
  private ViewPager mPager = null;
  private TabMain mTabMain = null;
  private TextView[] mTxtTiteLocation = new TextView[7];
  private TextView mTxtTitleCouple = null;
  private TextView mTxtTitleUrgent = null;
  private int mType = 0;
  
  private void callApi_getListOfTransferJoin_Count(final int paramInt)
  {
    this.mPager.setOnPageChangeListener(null);
    this.mCalendar.add(5, paramInt);
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("ApiTransferJoin.getListOfTransferJoin_Count");
    if (this.mType == 100) {
      localGPClient.addParameter("transferJoinTypeID", Integer.valueOf(1));
    }
    for (;;)
    {
      localGPClient.addParameter("startDT", FormatUtil.getDateCalendarToString(this.mCalendar, "yyyy-MM-dd"));
      localGPClient.setDecoder(new GJSONDecoder(3));
      localGPClient.addProgress();
      localGPClient.addHandler(new GFailedHandler()
      {
        public void failedExecute(GBean paramAnonymousGBean)
        {
          Alert.toastLong(AtvListAll.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
          AtvListAll.this.mCalendar.add(5, -paramInt);
          if (AtvListAll.this.mNowDT.equals(FormatUtil.getDateCalendarToString(AtvListAll.this.mCalendar, "yyyy-MM-dd"))) {
            AtvListAll.this.mPager.setCurrentItem(0, false);
          }
          for (;;)
          {
            AtvListAll.this.mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
            {
              public void onPageScrollStateChanged(int paramAnonymous2Int) {}
              
              public void onPageScrolled(int paramAnonymous2Int1, float paramAnonymous2Float, int paramAnonymous2Int2) {}
              
              public void onPageSelected(int paramAnonymous2Int)
              {
                if (paramAnonymous2Int == 0) {
                  if (!AtvListAll.this.mNowDT.equals(FormatUtil.getDateCalendarToString(AtvListAll.this.mCalendar, "yyyy-MM-dd"))) {
                    AtvListAll.this.callApi_getListOfTransferJoin_Count(-4);
                  }
                }
                while (paramAnonymous2Int != 2) {
                  return;
                }
                AtvListAll.this.callApi_getListOfTransferJoin_Count(4);
              }
            });
            return;
            AtvListAll.this.mPager.setCurrentItem(1, false);
          }
        }
      });
      localGPClient.addHandler(new GResultHandler()
      {
        public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          JSONArray localJSONArray;
          int i;
          int k;
          if (paramAnonymousInt > 0)
          {
            localJSONArray = JSONUtil.getJSONArray(paramAnonymousJSONObject, "entityDate");
            i = 0;
            if (i < 3) {
              break label113;
            }
            k = 0;
            label25:
            if (k < AtvListAll.this.mTxtTiteLocation.length) {
              break label225;
            }
            AtvListAll.this.mImgPrev.setVisibility(0);
            if (!AtvListAll.this.mNowDT.equals(FormatUtil.getDateCalendarToString(AtvListAll.this.mCalendar, "yyyy-MM-dd"))) {
              break label301;
            }
            if (paramInt >= 0) {
              break label274;
            }
            AtvListAll.this.mPager.setCurrentItem(1, false);
          }
          for (;;)
          {
            AtvListAll.this.mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
            {
              public void onPageScrollStateChanged(int paramAnonymous2Int) {}
              
              public void onPageScrolled(int paramAnonymous2Int1, float paramAnonymous2Float, int paramAnonymous2Int2) {}
              
              public void onPageSelected(int paramAnonymous2Int)
              {
                if (paramAnonymous2Int == 0)
                {
                  if (!AtvListAll.this.mNowDT.equals(FormatUtil.getDateCalendarToString(AtvListAll.this.mCalendar, "yyyy-MM-dd")))
                  {
                    AtvListAll.this.callApi_getListOfTransferJoin_Count(-4);
                    AtvListAll.this.mImgPrev.setVisibility(0);
                    return;
                  }
                  AtvListAll.this.mImgPrev.setVisibility(8);
                  return;
                }
                if (paramAnonymous2Int == 2)
                {
                  AtvListAll.this.callApi_getListOfTransferJoin_Count(4);
                  AtvListAll.this.mImgPrev.setVisibility(0);
                  return;
                }
                AtvListAll.this.mImgPrev.setVisibility(0);
              }
            });
            return null;
            label113:
            String[] arrayOfString = new String[4];
            for (int j = 0;; j++)
            {
              if (j >= 4)
              {
                AtvListAll.this.mAdapter.getItem(i).date = arrayOfString;
                AtvListAll.this.mAdapter.getItem(i).array = JSONUtil.getJSONArray(paramAnonymousJSONObject, "entity" + (i + 1));
                AtvListAll.this.mAdapter.setView(i);
                i++;
                break;
              }
              arrayOfString[j] = JSONUtil.getString(localJSONArray, j + i * 4);
            }
            label225:
            JSONObject localJSONObject = JSONUtil.getJSONObject(AtvListAll.this.mAdapter.getItem(0).array, k);
            AtvListAll.this.mTxtTiteLocation[k].setText(JSONUtil.getString(localJSONObject, "loc_name", ""));
            k++;
            break label25;
            label274:
            AtvListAll.this.mPager.setCurrentItem(0, false);
            AtvListAll.this.mImgPrev.setVisibility(8);
            continue;
            label301:
            AtvListAll.this.mPager.setCurrentItem(1, false);
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
  
  protected void configureListener()
  {
    this.mBtnTopRight.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (!AtvListAll.this.checkLogin(true)) {
          return;
        }
        Intent localIntent = new Intent(AtvListAll.this.getContext(), AtvRegist.class);
        localIntent.putExtra("EXTRAS_TYPE", AtvListAll.this.mType);
        AtvListAll.this.startActivityForResult(localIntent, 7894);
      }
    });
    this.mBaseUrgent.setOnClickListener(ListenerUtil.getTypeMoveButtonListener(getContext(), AtvListEmer.class, this.mType, 7892, false));
    this.mBaseCouple.setOnClickListener(ListenerUtil.getTypeMoveButtonListener(getContext(), AtvListCouple.class, this.mType, 7893, false));
    this.mTabMain.setOnTabListener(new InterfaceSet.TabClickListener()
    {
      public void onClick(View paramAnonymousView, int paramAnonymousInt)
      {
        Intent localIntent = new Intent();
        switch (paramAnonymousInt)
        {
        default: 
          return;
        case 0: 
          localIntent.setClass(AtvListAll.this.getContext(), AtvMain.class);
          localIntent.setFlags(603979776);
          AtvListAll.this.startActivity(localIntent);
          AtvListAll.this.finish();
          return;
        case 1: 
          if (100 != AtvListAll.this.mType)
          {
            localIntent.setClass(AtvListAll.this.getContext(), AtvListAll.class);
            localIntent.setFlags(67108864);
            localIntent.putExtra("EXTRAS_TYPE", 100);
            AtvListAll.this.startActivity(localIntent);
            AtvListAll.this.finish();
            return;
          }
          AtvListAll.this.callApi_getListOfTransferJoin_Count(0);
          return;
        case 2: 
          if (200 != AtvListAll.this.mType)
          {
            localIntent.setClass(AtvListAll.this.getContext(), AtvListAll.class);
            localIntent.setFlags(67108864);
            localIntent.putExtra("EXTRAS_TYPE", 200);
            AtvListAll.this.startActivity(localIntent);
            AtvListAll.this.finish();
            return;
          }
          AtvListAll.this.callApi_getListOfTransferJoin_Count(0);
          return;
        case 3: 
          localIntent.setClass(AtvListAll.this.getContext(), AtvEvent.class);
          localIntent.setFlags(603979776);
          AtvListAll.this.startActivity(localIntent);
          AtvListAll.this.finish();
          return;
        }
        localIntent.setClass(AtvListAll.this.getContext(), AtvMore.class);
        localIntent.setFlags(603979776);
        AtvListAll.this.startActivity(localIntent);
      }
    });
    this.mAdapter.setListener(new InterfaceSet.OnClickJsonListener()
    {
      public void onClick(View paramAnonymousView, int paramAnonymousInt, JSONObject paramAnonymousJSONObject)
      {
        LogUtil.json(paramAnonymousJSONObject);
        Intent localIntent = new Intent(AtvListAll.this.getContext(), AtvListLocation.class);
        localIntent.putExtra("EXTRAS_JSON_STRING", paramAnonymousJSONObject.toString());
        localIntent.putExtra("EXTRAS_TYPE", AtvListAll.this.mType);
        AtvListAll.this.startActivityForResult(localIntent, 7894);
      }
    });
  }
  
  protected void findView()
  {
    this.mBaseUrgent = ((LinearLayout)findViewById(2131361884));
    this.mTxtTitleUrgent = ((TextView)this.mBaseUrgent.findViewById(2131361872));
    this.mBaseCouple = ((LinearLayout)findViewById(2131361885));
    this.mTxtTitleCouple = ((TextView)this.mBaseCouple.findViewById(2131361872));
    this.mTxtTiteLocation[0] = ((TextView)findViewById(2131361887));
    this.mTxtTiteLocation[1] = ((TextView)findViewById(2131361888));
    this.mTxtTiteLocation[2] = ((TextView)findViewById(2131361889));
    this.mTxtTiteLocation[3] = ((TextView)findViewById(2131361890));
    this.mTxtTiteLocation[4] = ((TextView)findViewById(2131361891));
    this.mTxtTiteLocation[5] = ((TextView)findViewById(2131361892));
    this.mTxtTiteLocation[6] = ((TextView)findViewById(2131361893));
    this.mImgPrev = ((ImageView)findViewById(2131361886));
    this.mPager = ((ViewPager)findViewById(2131361894));
    this.mTabMain = ((TabMain)findViewById(2131361867));
    if (this.mCalendar.get(11) >= 18) {
      this.mCalendar.add(5, 2);
    }
    for (;;)
    {
      this.mNowDT = FormatUtil.getDateCalendarToString(this.mCalendar, "yyyy-MM-dd");
      callApi_getListOfTransferJoin_Count(0);
      return;
      this.mCalendar.add(5, 1);
    }
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
    this.mTxtTopTitleLeft.setVisibility(0);
    this.mBtnTopRight.setVisibility(0);
    if (this.mType == 200)
    {
      this.mTxtTopTitleLeft.setText("라운드 조인");
      this.mBtnTopRight.setText("조인등록");
      this.mBaseUrgent.setVisibility(0);
      this.mBaseCouple.setVisibility(0);
      this.mTxtTitleUrgent.setText("긴급조인");
      this.mTxtTitleCouple.setText("부부커플");
      this.mTabMain.setTabOn(2);
    }
    for (;;)
    {
      this.mPager.setOffscreenPageLimit(3);
      this.mAdapter = new DatePagerAdapter();
      this.mAdapter.add(InflateUtil.inflate(getContext(), 2130903081, null));
      this.mAdapter.add(InflateUtil.inflate(getContext(), 2130903081, null));
      this.mAdapter.add(InflateUtil.inflate(getContext(), 2130903081, null));
      this.mPager.setAdapter(this.mAdapter);
      return;
      this.mTxtTopTitleLeft.setText("Tee 양도");
      this.mBtnTopRight.setText("양도등록");
      this.mBaseUrgent.setVisibility(0);
      this.mBaseCouple.setVisibility(0);
      this.mTxtTitleUrgent.setText("긴급양도");
      this.mTxtTitleCouple.setText("야간(라이트)");
      Drawable localDrawable = getContext().getResources().getDrawable(2130837625);
      localDrawable.setBounds(0, 0, 30, 30);
      ((TextView)this.mBaseCouple.findViewById(2131361872)).setCompoundDrawables(localDrawable, null, null, null);
      this.mTabMain.setTabOn(1);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      callApi_getListOfTransferJoin_Count(0);
    }
  }
  
  public void onBackPressed()
  {
    Intent localIntent = new Intent(getContext(), AtvMain.class);
    localIntent.setFlags(603979776);
    startActivity(localIntent);
    super.onBackPressed();
  }
  
  protected void setView()
  {
    setView(2130903051);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.atv.schedule.AtvListAll
 * JD-Core Version:    0.7.0.1
 */