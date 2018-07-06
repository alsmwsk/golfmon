package com.appg.golfmon.atv.event;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.appg.golfmon.atv.AtvBase;
import com.appg.golfmon.atv.AtvMain;
import com.appg.golfmon.atv.more.AtvMore;
import com.appg.golfmon.atv.schedule.AtvListAll;
import com.appg.golfmon.common.InterfaceSet.IScrollPullListener;
import com.appg.golfmon.common.InterfaceSet.TabClickListener;
import com.appg.golfmon.net.http.GFailedHandler;
import com.appg.golfmon.net.http.GJSONDecoder;
import com.appg.golfmon.net.http.GPClient;
import com.appg.golfmon.net.http.GResultHandler;
import com.appg.golfmon.util.Alert;
import com.appg.golfmon.util.FormatUtil;
import com.appg.golfmon.util.ImageDownLoader;
import com.appg.golfmon.util.ImageDownLoader.Mode;
import com.appg.golfmon.util.JSONUtil;
import com.appg.golfmon.view.GListView;
import com.appg.golfmon.view.GListView.GListAdapter;
import com.appg.golfmon.view.GListView.IMakeView;
import com.appg.golfmon.view.TabMain;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONObject;
import ra.genius.net.GBean;
import ra.genius.net.GExecutor;

public class AtvEvent
  extends AtvBase
  implements GListView.IMakeView
{
  private String LOGO_IMG_URL = "http://115.68.14.78/upload_img/";
  private int MAX_LIST = 20;
  private Button[] btnSearch;
  private String location_fk = "";
  private ArrayList<JSONObject> mArrayList = new ArrayList();
  private LinearLayout mBaseNodata = null;
  private ImageDownLoader mImageDownLoader;
  private GListView mList = null;
  private TabMain mTabMain = null;
  private TextView mTxtNodata = null;
  private int page = 0;
  
  private void callApi_getListOfEvent(final boolean paramBoolean)
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("Api.getListOfEvent");
    if (!paramBoolean) {
      localGPClient.addParameter("page_no", JSONUtil.getString(this.mList.getLastItem(), "no", ""));
    }
    localGPClient.addParameter("location_fk", this.location_fk);
    localGPClient.setDecoder(new GJSONDecoder(2));
    localGPClient.addProgress();
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvEvent.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        if (paramBoolean)
        {
          AtvEvent.this.mArrayList.clear();
          AtvEvent.this.mList.removeAll();
        }
        JSONArray localJSONArray;
        int i;
        int j;
        if (paramAnonymousInt > 0)
        {
          AtvEvent.this.mArrayList.clear();
          AtvEvent.this.mList.removeAll();
          localJSONArray = (JSONArray)paramAnonymousObject;
          i = 0;
          if ((localJSONArray != null) && (i < localJSONArray.length())) {
            break label138;
          }
          if (AtvEvent.this.mArrayList.size() <= AtvEvent.this.MAX_LIST) {
            break label213;
          }
          j = 0;
          label98:
          if (j < AtvEvent.this.MAX_LIST) {
            break label166;
          }
          AtvEvent.this.mList.setHasMore(true);
          AtvEvent.this.page = 1;
        }
        for (;;)
        {
          AtvEvent.this.setNodata();
          return null;
          label138:
          JSONObject localJSONObject = JSONUtil.getJSONObject(localJSONArray, i);
          AtvEvent.this.mArrayList.add(localJSONObject);
          i++;
          break;
          label166:
          GListView localGListView = AtvEvent.this.mList;
          JSONObject[] arrayOfJSONObject = new JSONObject[1];
          arrayOfJSONObject[0] = ((JSONObject)AtvEvent.this.mArrayList.get(j));
          localGListView.addItems(arrayOfJSONObject);
          j++;
          break label98;
          label213:
          AtvEvent.this.mList.addItems((JSONArray)paramAnonymousObject);
          AtvEvent.this.mList.setHasMore(false);
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
    return FormatUtil.getDateCalendarToString(paramCalendar, "MM/dd") + "(" + FormatUtil.getDateDayOfWeek(paramCalendar, false) + ") ";
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
  
  protected void configureListener()
  {
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
          localIntent.setClass(AtvEvent.this.getContext(), AtvMain.class);
          localIntent.setFlags(603979776);
          AtvEvent.this.startActivity(localIntent);
          AtvEvent.this.finish();
          return;
        case 1: 
          localIntent.setClass(AtvEvent.this.getContext(), AtvListAll.class);
          localIntent.setFlags(603979776);
          localIntent.putExtra("EXTRAS_TYPE", 100);
          AtvEvent.this.startActivity(localIntent);
          AtvEvent.this.finish();
          return;
        case 2: 
          localIntent.setClass(AtvEvent.this.getContext(), AtvListAll.class);
          localIntent.setFlags(603979776);
          localIntent.putExtra("EXTRAS_TYPE", 200);
          AtvEvent.this.startActivity(localIntent);
          AtvEvent.this.finish();
          return;
        case 3: 
          AtvEvent.this.location_fk = "0";
          AtvEvent.this.callApi_getListOfEvent(true);
          for (int i = 0; i < 7; i++) {
            AtvEvent.this.btnSearch[i].setSelected(false);
          }
        }
        localIntent.setClass(AtvEvent.this.getContext(), AtvMore.class);
        localIntent.setFlags(603979776);
        AtvEvent.this.startActivity(localIntent);
        AtvEvent.this.finish();
      }
    });
    this.mList.setOnScrollPullListener(new InterfaceSet.IScrollPullListener()
    {
      public void onPullDown(Context paramAnonymousContext) {}
      
      public void onPullUp(Context paramAnonymousContext)
      {
        int i;
        int j;
        int m;
        if (AtvEvent.this.mList.getHasMore())
        {
          AtvEvent localAtvEvent = AtvEvent.this;
          localAtvEvent.page = (1 + localAtvEvent.page);
          i = 1 + (-1 + AtvEvent.this.page) * AtvEvent.this.MAX_LIST;
          j = AtvEvent.this.page * AtvEvent.this.MAX_LIST;
          if (AtvEvent.this.mArrayList.size() <= j) {
            m = AtvEvent.this.mArrayList.size();
          }
        }
        else
        {
          for (int n = i;; n++)
          {
            if (n >= m)
            {
              AtvEvent.this.mList.setHasMore(false);
              return;
            }
            GListView localGListView2 = AtvEvent.this.mList;
            JSONObject[] arrayOfJSONObject2 = new JSONObject[1];
            arrayOfJSONObject2[0] = ((JSONObject)AtvEvent.this.mArrayList.get(n));
            localGListView2.addItems(arrayOfJSONObject2);
          }
        }
        for (int k = i;; k++)
        {
          if (k >= j)
          {
            AtvEvent.this.mList.setHasMore(true);
            return;
          }
          GListView localGListView1 = AtvEvent.this.mList;
          JSONObject[] arrayOfJSONObject1 = new JSONObject[1];
          arrayOfJSONObject1[0] = ((JSONObject)AtvEvent.this.mArrayList.get(k));
          localGListView1.addItems(arrayOfJSONObject1);
        }
      }
    });
  }
  
  protected void findView()
  {
    this.mList = ((GListView)findViewById(2131361864));
    this.mTabMain = ((TabMain)findViewById(2131361867));
    this.mBaseNodata = ((LinearLayout)findViewById(2131361865));
    this.mTxtNodata = ((TextView)findViewById(2131361866));
    this.btnSearch = new Button[7];
    for (int i = 0;; i++)
    {
      if (i >= 7) {
        return;
      }
      this.btnSearch[i] = ((Button)findViewById(2131361857 + i));
      this.btnSearch[i].setTag(i + 1);
      this.btnSearch[i].setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          for (int i = 0;; i++)
          {
            if (i >= 7)
            {
              paramAnonymousView.setSelected(true);
              AtvEvent.this.location_fk = ((String)paramAnonymousView.getTag());
              AtvEvent.this.mList.removeAll();
              AtvEvent.this.callApi_getListOfEvent(true);
              return;
            }
            AtvEvent.this.btnSearch[i].setSelected(false);
          }
        }
      });
    }
  }
  
  protected void init()
  {
    this.mImageDownLoader = new ImageDownLoader(this);
    this.mImageDownLoader.setMode(ImageDownLoader.Mode.CORRECT);
    this.mTxtTopTitleLeft.setVisibility(0);
    this.mTxtTopTitleLeft.setText("할인부킹");
    this.mTxtTopTitleLeftBack.setTextColor(-2023132);
    this.mTxtTopTitleLeft.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvEvent.this.location_fk = "0";
        AtvEvent.this.callApi_getListOfEvent(true);
        for (int i = 0;; i++)
        {
          if (i >= 7) {
            return;
          }
          AtvEvent.this.btnSearch[i].setSelected(false);
        }
      }
    });
    this.mTabMain.setTabOn(3);
    this.mList.setViewMaker(2130903085, this);
    callApi_getListOfEvent(true);
  }
  
  public View makeView(GListView.GListAdapter paramGListAdapter, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    final JSONObject localJSONObject = (JSONObject)paramGListAdapter.getItem(paramInt);
    ViewHolder localViewHolder = (ViewHolder)paramView.getTag();
    if (localViewHolder == null)
    {
      localViewHolder = new ViewHolder();
      localViewHolder.txtName = ((TextView)paramView.findViewById(2131361869));
      localViewHolder.txtTitle = ((TextView)paramView.findViewById(2131361872));
      localViewHolder.txtDate = ((TextView)paramView.findViewById(2131361873));
      localViewHolder.txtPayWeekDay = ((TextView)paramView.findViewById(2131361874));
      localViewHolder.txtPayWeekEnd = ((TextView)paramView.findViewById(2131361875));
      localViewHolder.ivThum = ((ImageView)paramView.findViewById(2131361868));
    }
    String str1 = JSONUtil.getString(localJSONObject, "golf_logo", "");
    if (FormatUtil.isNullorEmpty(str1)) {
      this.mImageDownLoader.download(localViewHolder.ivThum, this.LOGO_IMG_URL + "event_thumbnail_default.png");
    }
    for (;;)
    {
      String str2 = JSONUtil.getString(localJSONObject, "golf_name", "");
      String str3 = JSONUtil.getString(localJSONObject, "title", "");
      localViewHolder.txtName.setText(str2);
      localViewHolder.txtTitle.setText(str3);
      Calendar localCalendar = FormatUtil.getDateStringToCalendar(JSONUtil.getString(localJSONObject, "edate", ""), "yyyy-MM-dd");
      String str4 = "~ " + getDate(localCalendar) + "까지";
      localViewHolder.txtDate.setText(str4);
      localViewHolder.txtPayWeekDay.setText(FormatUtil.toPriceFormat(JSONUtil.getInteger(localJSONObject, "pay_day", 0)));
      localViewHolder.txtPayWeekEnd.setText(FormatUtil.toPriceFormat(JSONUtil.getInteger(localJSONObject, "pay_end", 0)));
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Intent localIntent = new Intent(AtvEvent.this.getContext(), AtvEventDetail.class);
          localIntent.putExtra("EXTRAS_JSON_STRING", localJSONObject.toString());
          AtvEvent.this.startActivity(localIntent);
        }
      });
      paramView.setTag(localViewHolder);
      return paramView;
      this.mImageDownLoader.download(localViewHolder.ivThum, this.LOGO_IMG_URL + str1);
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
    setView(2130903047);
  }
  
  class ViewHolder
  {
    ImageView ivThum;
    TextView txtDate;
    TextView txtName;
    TextView txtPayWeekDay;
    TextView txtPayWeekEnd;
    TextView txtTitle;
    
    ViewHolder() {}
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.atv.event.AtvEvent
 * JD-Core Version:    0.7.0.1
 */