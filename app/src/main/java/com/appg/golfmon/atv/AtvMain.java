package com.appg.golfmon.atv;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import com.appg.golfmon.adapter.DatePagerAdapter;
import com.appg.golfmon.adapter.DatePagerAdapter.DataSet;
import com.appg.golfmon.atv.event.AtvEvent;
import com.appg.golfmon.atv.event.AtvEventDetail;
import com.appg.golfmon.atv.more.AtvMore;
import com.appg.golfmon.atv.more.AtvMyPage;
import com.appg.golfmon.atv.more.AtvNotice;
import com.appg.golfmon.atv.schedule.AtvDetail;
import com.appg.golfmon.atv.schedule.AtvListAll;
import com.appg.golfmon.atv.schedule.AtvListCouple;
import com.appg.golfmon.atv.schedule.AtvListEmer;
import com.appg.golfmon.atv.schedule.AtvListLocation;
import com.appg.golfmon.atv.schedule.AtvReviewAll;
import com.appg.golfmon.atv.user.AtvUserLogin;
import com.appg.golfmon.common.InterfaceSet.OnClickJsonListener;
import com.appg.golfmon.common.InterfaceSet.TabClickListener;
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
import com.appg.golfmon.util.LogUtil;
import com.appg.golfmon.util.SPUtil;
import com.appg.golfmon.view.TabMain;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONObject;
import ra.genius.net.GBean;
import ra.genius.net.GExecutor;

public class AtvMain
  extends AtvBase
{
  private boolean IS_READY_KILL = false;
  private DatePagerAdapter mAdapter = null;
  private JSONArray mBannerArray = null;
  private LinearLayout mBaseCouple = null;
  private LinearLayout mBaseRounding = null;
  private LinearLayout mBaseUrgent = null;
  private Button mBtnRight = null;
  private Button mBtnTabJoin = null;
  private Button mBtnTabTransfer = null;
  private Calendar mCalendar = Calendar.getInstance();
  private JSONArray mCommentArray = null;
  private JSONObject mEventInfo = null;
  private Handler mFinishStopHandler = new Handler();
  private Runnable mFinishStopRunnable = new Runnable()
  {
    public void run()
    {
      AtvMain.this.IS_READY_KILL = false;
    }
  };
  private Toast mFinishStopToast = null;
  private ImageView mImgPrev = null;
  private ImageView mImgRecommand = null;
  private JSONObject mNoticeInfo = null;
  private String mNowDT = "";
  private ViewPager mPager = null;
  private int mSelTab = 100;
  private TabMain mTabMain = null;
  private TextView mTxtNotice = null;
  private TextView mTxtRight = null;
  private TextView[] mTxtTiteLocation = new TextView[7];
  private TextView mTxtTitleCouple = null;
  private TextView mTxtTitleUrgent = null;
  private int mType = 100;
  private ViewFlipper mViewFlipperEvent = null;
  
  private void callApi_getInfoOfEvent()
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("Api.getInfoOfEvent");
    localGPClient.addParameter("no", "760");
    localGPClient.setDecoder(new GJSONDecoder(1));
    localGPClient.addProgress();
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvMain.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        AtvMain.this.setResult(-1);
        if (paramAnonymousInt > 0)
        {
          AtvMain.this.mEventInfo = ((JSONObject)paramAnonymousObject);
          final int i = Integer.parseInt(JSONUtil.getString(AtvMain.this.mEventInfo, "phone_num", ""));
          SPUtil.getInstance().setCafeHeader(AtvMain.this.getContext(), JSONUtil.getString(AtvMain.this.mEventInfo, "title", ""));
          if ((JSONUtil.getString(AtvMain.this.mEventInfo, "is_banner", "").equals("1")) && (i > SPUtil.getInstance().getIsOffEvent(AtvMain.this.getContext())))
          {
            Alert localAlert = new Alert();
            localAlert.setOnCloseListener(new Alert.OnCloseListener()
            {
              public void onClose(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int, Object paramAnonymous2Object)
              {
                if (1 != paramAnonymous2Int) {
                  SPUtil.getInstance().setIsOffEvent(AtvMain.this.getContext(), i);
                }
              }
            });
            localAlert.showEventAlert(AtvMain.this.getContext(), JSONUtil.getString(AtvMain.this.mEventInfo, "img1", ""), JSONUtil.getString(AtvMain.this.mEventInfo, "content", ""), false);
          }
        }
        for (;;)
        {
          return null;
          Alert.toastLong(AtvMain.this.getContext(), paramAnonymousString);
          AtvMain.this.finish();
        }
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
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
          Alert.toastLong(AtvMain.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
          AtvMain.this.mCalendar.add(5, -paramInt);
          if (AtvMain.this.mNowDT.equals(FormatUtil.getDateCalendarToString(AtvMain.this.mCalendar, "yyyy-MM-dd"))) {
            AtvMain.this.mPager.setCurrentItem(0, false);
          }
          for (;;)
          {
            AtvMain.this.mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
            {
              public void onPageScrollStateChanged(int paramAnonymous2Int) {}
              
              public void onPageScrolled(int paramAnonymous2Int1, float paramAnonymous2Float, int paramAnonymous2Int2) {}
              
              public void onPageSelected(int paramAnonymous2Int)
              {
                if (paramAnonymous2Int == 0) {
                  if (!AtvMain.this.mNowDT.equals(FormatUtil.getDateCalendarToString(AtvMain.this.mCalendar, "yyyy-MM-dd"))) {
                    AtvMain.this.callApi_getListOfTransferJoin_Count(-4);
                  }
                }
                while (paramAnonymous2Int != 2) {
                  return;
                }
                AtvMain.this.callApi_getListOfTransferJoin_Count(4);
              }
            });
            return;
            AtvMain.this.mPager.setCurrentItem(1, false);
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
            if (k < AtvMain.this.mTxtTiteLocation.length) {
              break label225;
            }
            AtvMain.this.mImgPrev.setVisibility(0);
            if (!AtvMain.this.mNowDT.equals(FormatUtil.getDateCalendarToString(AtvMain.this.mCalendar, "yyyy-MM-dd"))) {
              break label301;
            }
            if (paramInt >= 0) {
              break label274;
            }
            AtvMain.this.mPager.setCurrentItem(1, false);
          }
          for (;;)
          {
            AtvMain.this.mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
            {
              public void onPageScrollStateChanged(int paramAnonymous2Int) {}
              
              public void onPageScrolled(int paramAnonymous2Int1, float paramAnonymous2Float, int paramAnonymous2Int2) {}
              
              public void onPageSelected(int paramAnonymous2Int)
              {
                if (paramAnonymous2Int == 0)
                {
                  if (!AtvMain.this.mNowDT.equals(FormatUtil.getDateCalendarToString(AtvMain.this.mCalendar, "yyyy-MM-dd")))
                  {
                    AtvMain.this.callApi_getListOfTransferJoin_Count(-4);
                    AtvMain.this.mImgPrev.setVisibility(0);
                    return;
                  }
                  AtvMain.this.mImgPrev.setVisibility(8);
                  return;
                }
                if (paramAnonymous2Int == 2)
                {
                  AtvMain.this.callApi_getListOfTransferJoin_Count(4);
                  AtvMain.this.mImgPrev.setVisibility(0);
                  return;
                }
                AtvMain.this.mImgPrev.setVisibility(0);
              }
            });
            return null;
            label113:
            String[] arrayOfString = new String[4];
            for (int j = 0;; j++)
            {
              if (j >= 4)
              {
                AtvMain.this.mAdapter.getItem(i).date = arrayOfString;
                AtvMain.this.mAdapter.getItem(i).array = JSONUtil.getJSONArray(paramAnonymousJSONObject, "entity" + (i + 1));
                AtvMain.this.mAdapter.setView(i);
                i++;
                break;
              }
              arrayOfString[j] = JSONUtil.getString(localJSONArray, j + i * 4);
            }
            label225:
            JSONObject localJSONObject = JSONUtil.getJSONObject(AtvMain.this.mAdapter.getItem(0).array, k);
            AtvMain.this.mTxtTiteLocation[k].setText(JSONUtil.getString(localJSONObject, "loc_name", ""));
            k++;
            break label25;
            label274:
            AtvMain.this.mPager.setCurrentItem(0, false);
            AtvMain.this.mImgPrev.setVisibility(8);
            continue;
            label301:
            AtvMain.this.mPager.setCurrentItem(1, false);
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
  
  private void callApi_getMainCount()
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("ApiTransferJoin.getMainCount");
    localGPClient.setDecoder(new GJSONDecoder(3));
    localGPClient.addProgress();
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvMain.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        JSONObject localJSONObject;
        if (paramAnonymousInt > 0)
        {
          AtvMain.this.mNoticeInfo = JSONUtil.getJSONObject(paramAnonymousJSONObject, "entityNotice");
          AtvMain.this.mBannerArray = JSONUtil.getJSONArray(paramAnonymousJSONObject, "entityBanner");
          AtvMain.this.mCommentArray = JSONUtil.getJSONArray(paramAnonymousJSONObject, "entityComment");
          AtvMain.this.setBanner(AtvMain.this.mBannerArray);
          AtvMain.this.setNotice();
          AtvMain.this.setRounding(AtvMain.this.mCommentArray);
          localJSONObject = JSONUtil.getJSONObject(paramAnonymousJSONObject, "entityUser");
          if (!FormatUtil.isNullorEmpty(localJSONObject)) {
            break label107;
          }
          AtvMain.this.logout();
        }
        for (;;)
        {
          return null;
          label107:
          SPUtil.getInstance().setUserInfo(AtvMain.this.getContext(), localJSONObject);
          AtvMain.this.setTopRight();
        }
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  private void checkPush()
  {
    if ("1".equals(getIntent().getStringExtra("pushTypeID")))
    {
      Intent localIntent1 = new Intent(getContext(), AtvDetail.class);
      localIntent1.putExtras(getIntent().getExtras());
      startActivityForResult(localIntent1, 1000);
    }
    do
    {
      return;
      if ("4".equals(getIntent().getStringExtra("pushTypeID")))
      {
        Intent localIntent2 = new Intent(getContext(), AtvEvent.class);
        localIntent2.putExtras(getIntent().getExtras());
        startActivityForResult(localIntent2, 1000);
        return;
      }
    } while (!"5".equals(getIntent().getStringExtra("pushTypeID")));
    Intent localIntent3 = new Intent(getContext(), AtvNotice.class);
    localIntent3.putExtras(getIntent().getExtras());
    startActivityForResult(localIntent3, 1000);
  }
  
  private void setBanner(JSONArray paramJSONArray)
  {
    this.mViewFlipperEvent.stopFlipping();
    this.mViewFlipperEvent.removeAllViews();
    for (int i = 0;; i++)
    {
      if ((paramJSONArray == null) || (i >= paramJSONArray.length()))
      {
        if (this.mViewFlipperEvent.getChildCount() > 0) {
          this.mViewFlipperEvent.startFlipping();
        }
        return;
      }
      setBanner(JSONUtil.getJSONObject(paramJSONArray, i));
    }
  }
  
  private void setBanner(final JSONObject paramJSONObject)
  {
    View localView = InflateUtil.inflate(getContext(), 2130903094, null);
    this.mViewFlipperEvent.addView(localView);
    TextView localTextView1 = (TextView)localView.findViewById(2131362073);
    TextView localTextView2 = (TextView)localView.findViewById(2131362074);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    String str = JSONUtil.getString(paramJSONObject, "name", "");
    if (!FormatUtil.isNullorEmpty(str))
    {
      SpannableString localSpannableString = new SpannableString(str);
      localSpannableString.setSpan(new StyleSpan(1), 0, localSpannableString.length(), 33);
      localSpannableStringBuilder.append(localSpannableString);
      localSpannableStringBuilder.append("  ");
    }
    localSpannableStringBuilder.append(JSONUtil.getString(paramJSONObject, "title", ""));
    localTextView1.setText(localSpannableStringBuilder);
    localTextView2.setText(FormatUtil.getDateConvert(JSONUtil.getString(paramJSONObject, "edate", ""), "yyyy-MM-dd", "~MM/dd"));
    localView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(AtvMain.this.getContext(), AtvEventDetail.class);
        localIntent.putExtra("EXTRAS_JSON_STRING", paramJSONObject.toString());
        AtvMain.this.startActivity(localIntent);
      }
    });
  }
  
  private void setItem(View paramView, final int paramInt1, final String paramString, int paramInt2)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131361872);
    TextView localTextView2 = (TextView)paramView.findViewById(2131361833);
    localTextView1.setText(paramString);
    localTextView2.setText(FormatUtil.toPriceFormat(paramInt2));
    switch (paramInt1)
    {
    default: 
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          JSONObject localJSONObject = new JSONObject();
          JSONUtil.put(localJSONObject, "date", FormatUtil.getDateCalendarToString(Calendar.getInstance(), "yyyy-MM-dd"));
          JSONUtil.put(localJSONObject, "loc_name", paramString);
          JSONUtil.put(localJSONObject, "no", String.valueOf(-1 + paramInt1));
          JSONUtil.put(localJSONObject, "isAll", Boolean.valueOf(true));
          Intent localIntent = new Intent(AtvMain.this.getContext(), AtvListLocation.class);
          localIntent.putExtra("EXTRAS_JSON_STRING", localJSONObject.toString());
          localIntent.putExtra("EXTRAS_TYPE", AtvMain.this.mSelTab);
          AtvMain.this.startActivityForResult(localIntent, 7894);
        }
      });
      return;
    case 0: 
      paramView.setOnClickListener(ListenerUtil.getTypeMoveButtonListener(getContext(), AtvListAll.class, this.mSelTab, 7891, false));
      return;
    case 1: 
      paramView.setOnClickListener(ListenerUtil.getTypeMoveButtonListener(getContext(), AtvListEmer.class, this.mSelTab, 7892, false));
      return;
    }
    paramView.setOnClickListener(ListenerUtil.getTypeMoveButtonListener(getContext(), AtvListCouple.class, this.mSelTab, 7893, false));
  }
  
  private void setNotice()
  {
    this.mTxtNotice.setText(JSONUtil.getString(this.mNoticeInfo, "title", ""));
    this.mTxtNotice.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(paramAnonymousView.getContext(), AtvNotice.class);
        localIntent.putExtra("EXTRAS_ID", JSONUtil.getString(AtvMain.this.mNoticeInfo, "no", ""));
        AtvMain.this.startActivity(localIntent);
      }
    });
  }
  
  private void setRounding(JSONArray paramJSONArray)
  {
    this.mBaseRounding.removeAllViews();
    for (int i = 0;; i++)
    {
      if (i >= paramJSONArray.length()) {
        return;
      }
      setRounding(JSONUtil.getJSONObject(paramJSONArray, i), i, false);
    }
  }
  
  private void setRounding(final JSONObject paramJSONObject, int paramInt, boolean paramBoolean)
  {
    View localView1 = InflateUtil.inflate(getContext(), 2130903095, null);
    this.mBaseRounding.addView(localView1);
    ImageView localImageView = (ImageView)localView1.findViewById(2131362077);
    TextView localTextView1 = (TextView)localView1.findViewById(2131361869);
    TextView localTextView2 = (TextView)localView1.findViewById(2131362078);
    TextView localTextView3 = (TextView)localView1.findViewById(2131362079);
    TextView localTextView4 = (TextView)localView1.findViewById(2131362036);
    View localView2 = localView1.findViewById(2131362057);
    int i;
    if (paramBoolean)
    {
      i = 8;
      localView2.setVisibility(i);
      localImageView.setVisibility(0);
      switch (paramInt)
      {
      default: 
        localImageView.setVisibility(4);
        label158:
        localTextView1.setText(JSONUtil.getString(paramJSONObject, "name", ""));
        if (JSONUtil.getInteger(paramJSONObject, "golf_type", 0) == 1)
        {
          localTextView2.setText("회");
          localTextView2.setBackgroundResource(2130837509);
        }
        break;
      }
    }
    for (;;)
    {
      localTextView3.setText(FormatUtil.toPriceFormat(JSONUtil.getInteger(paramJSONObject, "counts", 0)));
      double d = JSONUtil.getDouble(paramJSONObject, "grade", 0.0D);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Double.valueOf(d);
      localTextView4.setText(String.format("%1.1f", arrayOfObject));
      localView1.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Intent localIntent = new Intent(paramAnonymousView.getContext(), AtvReviewAll.class);
          localIntent.putExtra("EXTRAS_JSON_STRING", paramJSONObject.toString());
          localIntent.putExtra("EXTRAS_ID", JSONUtil.getInteger(paramJSONObject, "no", -1));
          AtvMain.this.startActivityForResult(localIntent, 1000);
        }
      });
      return;
      i = 0;
      break;
      localImageView.setImageResource(2130837645);
      break label158;
      localImageView.setImageResource(2130837646);
      break label158;
      localImageView.setImageResource(2130837647);
      break label158;
      localImageView.setImageResource(2130837648);
      break label158;
      localImageView.setImageResource(2130837649);
      break label158;
      localTextView2.setText("퍼");
      localTextView2.setBackgroundResource(2130837510);
    }
  }
  
  private void setTabJoin()
  {
    this.mType = 200;
    SPUtil.getInstance().setHome(getContext(), this.mType);
    this.mSelTab = 200;
    this.mBtnTabTransfer.setSelected(false);
    this.mBtnTabJoin.setSelected(true);
    this.mTxtTopTitleLeft.setText("라운드 조인");
    this.mBtnTopRight.setText("조인등록");
    this.mBaseUrgent.setVisibility(0);
    this.mBaseCouple.setVisibility(0);
    Drawable localDrawable = getContext().getResources().getDrawable(2130837623);
    localDrawable.setBounds(0, 0, 30, 30);
    ((TextView)this.mBaseCouple.findViewById(2131361872)).setCompoundDrawables(localDrawable, null, null, null);
    this.mTxtTitleUrgent.setText("긴급조인");
    this.mTxtTitleCouple.setText("부부커플");
    callApi_getListOfTransferJoin_Count(0);
    this.mBaseUrgent.setOnClickListener(ListenerUtil.getTypeMoveButtonListener(getContext(), AtvListEmer.class, 200, 7892, false));
    this.mBaseCouple.setOnClickListener(ListenerUtil.getTypeMoveButtonListener(getContext(), AtvListCouple.class, 200, 7893, false));
  }
  
  private void setTabTransfer()
  {
    this.mType = 100;
    SPUtil.getInstance().setHome(getContext(), this.mType);
    this.mSelTab = 100;
    this.mBtnTabTransfer.setSelected(true);
    this.mBtnTabJoin.setSelected(false);
    this.mTxtTopTitleLeft.setText("Tee 양도");
    this.mBtnTopRight.setText("양도등록");
    this.mBaseUrgent.setVisibility(0);
    this.mBaseCouple.setVisibility(0);
    Drawable localDrawable = getContext().getResources().getDrawable(2130837625);
    localDrawable.setBounds(0, 0, 30, 30);
    ((TextView)this.mBaseCouple.findViewById(2131361872)).setCompoundDrawables(localDrawable, null, null, null);
    this.mTxtTitleUrgent.setText("긴급양도");
    this.mTxtTitleCouple.setText("야간(라이트)");
    callApi_getListOfTransferJoin_Count(0);
    this.mBaseUrgent.setOnClickListener(ListenerUtil.getTypeMoveButtonListener(getContext(), AtvListEmer.class, 100, 7892, false));
    this.mBaseCouple.setOnClickListener(ListenerUtil.getTypeMoveButtonListener(getContext(), AtvListCouple.class, 100, 7893, false));
  }
  
  private void setTopRight()
  {
    if (SPUtil.getInstance().getIsLogin(this))
    {
      this.mBtnRight.setVisibility(4);
      this.mTxtRight.setVisibility(0);
      this.mTxtRight.setText(JSONUtil.getString(SPUtil.getInstance().getUserInfo(this), "nick_name", "") + "  " + FormatUtil.toPriceFormat(JSONUtil.getInteger(SPUtil.getInstance().getUserInfo(this), "points", 0)) + "P");
      this.mTxtRight.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          AtvMain.this.startActivity(new Intent(AtvMain.this.getContext(), AtvMyPage.class));
        }
      });
      return;
    }
    this.mBtnRight.setText("로그인");
    this.mBtnRight.setVisibility(0);
    this.mTxtRight.setVisibility(8);
  }
  
  protected void configureListener()
  {
    this.mBtnTabTransfer.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvMain.this.setTabTransfer();
      }
    });
    this.mBtnTabJoin.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvMain.this.setTabJoin();
      }
    });
    this.mBtnRight.setOnClickListener(ListenerUtil.getMoveButtonListener(getContext(), AtvUserLogin.class, 4452, false));
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
          AtvMain.this.callApi_getMainCount();
          return;
        case 1: 
          localIntent.setClass(AtvMain.this.getContext(), AtvListAll.class);
          localIntent.setFlags(603979776);
          localIntent.putExtra("EXTRAS_TYPE", 100);
          AtvMain.this.startActivity(localIntent);
          return;
        case 2: 
          localIntent.setClass(AtvMain.this.getContext(), AtvListAll.class);
          localIntent.setFlags(603979776);
          localIntent.putExtra("EXTRAS_TYPE", 200);
          AtvMain.this.startActivity(localIntent);
          return;
        case 3: 
          localIntent.setClass(AtvMain.this.getContext(), AtvEvent.class);
          localIntent.setFlags(603979776);
          AtvMain.this.startActivity(localIntent);
          return;
        }
        localIntent.setClass(AtvMain.this.getContext(), AtvMore.class);
        localIntent.setFlags(603979776);
        AtvMain.this.startActivity(localIntent);
      }
    });
    this.mImgRecommand.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent();
        localIntent.setClass(AtvMain.this.getContext(), AtvMore.class);
        localIntent.setFlags(603979776);
        AtvMain.this.startActivity(localIntent);
      }
    });
    this.mAdapter.setListener(new InterfaceSet.OnClickJsonListener()
    {
      public void onClick(View paramAnonymousView, int paramAnonymousInt, JSONObject paramAnonymousJSONObject)
      {
        LogUtil.json(paramAnonymousJSONObject);
        Intent localIntent = new Intent(AtvMain.this.getContext(), AtvListLocation.class);
        localIntent.putExtra("EXTRAS_JSON_STRING", paramAnonymousJSONObject.toString());
        localIntent.putExtra("EXTRAS_TYPE", AtvMain.this.mType);
        AtvMain.this.startActivityForResult(localIntent, 7894);
      }
    });
    this.mBaseUrgent.setOnClickListener(ListenerUtil.getTypeMoveButtonListener(getContext(), AtvListEmer.class, this.mSelTab, 7892, false));
    this.mBaseCouple.setOnClickListener(ListenerUtil.getTypeMoveButtonListener(getContext(), AtvListCouple.class, this.mSelTab, 7893, false));
  }
  
  protected void findView()
  {
    this.mType = SPUtil.getInstance().getHome(getContext());
    this.mBtnRight = ((Button)findViewById(2131361912));
    this.mTxtRight = ((TextView)findViewById(2131361913));
    this.mViewFlipperEvent = ((ViewFlipper)findViewById(2131361914));
    this.mBtnTabTransfer = ((Button)findViewById(2131361897));
    this.mBtnTabJoin = ((Button)findViewById(2131361898));
    this.mImgRecommand = ((ImageView)findViewById(2131361917));
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
      this.mTxtNotice = ((TextView)findViewById(2131361915));
      this.mBaseRounding = ((LinearLayout)findViewById(2131361916));
      this.mTabMain = ((TabMain)findViewById(2131361867));
      return;
      this.mCalendar.add(5, 1);
    }
  }
  
  protected void init()
  {
    this.mBaseTopTitle.setVisibility(8);
    setTopRight();
    this.mViewFlipperEvent.setFlipInterval(10000);
    this.mTabMain.setTabOn(0);
    if (this.mType == 100) {
      setTabTransfer();
    }
    for (;;)
    {
      callApi_getMainCount();
      checkPush();
      this.mPager.setOffscreenPageLimit(3);
      this.mAdapter = new DatePagerAdapter();
      this.mAdapter.add(InflateUtil.inflate(getContext(), 2130903081, null));
      this.mAdapter.add(InflateUtil.inflate(getContext(), 2130903081, null));
      this.mAdapter.add(InflateUtil.inflate(getContext(), 2130903081, null));
      this.mPager.setAdapter(this.mAdapter);
      callApi_getInfoOfEvent();
      return;
      setTabJoin();
    }
  }
  
  public void logout()
  {
    SPUtil.getInstance().logOut(this);
    setTopRight();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      callApi_getMainCount();
    }
  }
  
  public void onBackPressed()
  {
    if (this.IS_READY_KILL)
    {
      if (this.mFinishStopToast != null) {
        this.mFinishStopToast.cancel();
      }
      this.mFinishStopHandler.removeCallbacks(this.mFinishStopRunnable);
      this.IS_READY_KILL = false;
      finish();
      return;
    }
    this.IS_READY_KILL = true;
    this.mFinishStopHandler.removeCallbacks(this.mFinishStopRunnable);
    this.mFinishStopHandler.postDelayed(this.mFinishStopRunnable, 2000L);
    if (this.mFinishStopToast == null) {
      this.mFinishStopToast = Toast.makeText(this, getString(2131099690), 0);
    }
    this.mFinishStopToast.show();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    if ("LOGOUT".equals(paramIntent.getAction()))
    {
      logout();
      return;
    }
    callApi_getMainCount();
  }
  
  protected void onResume()
  {
    super.onResume();
    setTopRight();
  }
  
  protected void setView()
  {
    setView(2130903056);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.atv.AtvMain
 * JD-Core Version:    0.7.0.1
 */