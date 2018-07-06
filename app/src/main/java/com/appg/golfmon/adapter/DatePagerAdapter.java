package com.appg.golfmon.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.appg.golfmon.common.InterfaceSet.OnClickJsonListener;
import com.appg.golfmon.util.FormatUtil;
import com.appg.golfmon.util.JSONUtil;
import com.appg.golfmon.util.LogUtil;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONObject;

public class DatePagerAdapter
  extends PagerAdapter
{
  private InterfaceSet.OnClickJsonListener mListener = null;
  private ArrayList<DataSet> mViewList = new ArrayList();
  
  public void add(View paramView)
  {
    DataSet localDataSet = new DataSet();
    localDataSet.view = paramView;
    this.mViewList.add(localDataSet);
  }
  
  public void clear()
  {
    this.mViewList.clear();
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    LogUtil.i("destroyItem     =     " + paramInt);
    ((ViewPager)paramView).removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return this.mViewList.size();
  }
  
  public DataSet getItem(int paramInt)
  {
    if ((getCount() > 0) && (paramInt < getCount())) {
      return (DataSet)this.mViewList.get(paramInt);
    }
    return null;
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    LogUtil.d("instantiateItem     =     " + paramInt);
    View localView = ((DataSet)this.mViewList.get(paramInt)).view;
    if (localView.getParent() != null) {
      destroyItem(paramView, paramInt, localView);
    }
    ((ViewPager)paramView).addView(localView, 0);
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void remove(ViewPager paramViewPager, int paramInt)
  {
    int i = paramViewPager.getCurrentItem();
    LogUtil.d("setPos : " + i);
    this.mViewList.remove(paramInt);
    notifyDataSetChanged();
    paramViewPager.setCurrentItem(i - 1, false);
  }
  
  public void setListener(InterfaceSet.OnClickJsonListener paramOnClickJsonListener)
  {
    this.mListener = paramOnClickJsonListener;
  }
  
  public void setView(int paramInt)
  {
    DataSet localDataSet = getItem(paramInt);
    TextView[] arrayOfTextView1 = new TextView[4];
    arrayOfTextView1[0] = ((TextView)localDataSet.view.findViewById(2131362038));
    arrayOfTextView1[1] = ((TextView)localDataSet.view.findViewById(2131362039));
    arrayOfTextView1[2] = ((TextView)localDataSet.view.findViewById(2131362040));
    arrayOfTextView1[3] = ((TextView)localDataSet.view.findViewById(2131362041));
    int i = 0;
    LinearLayout[] arrayOfLinearLayout;
    if (i >= arrayOfTextView1.length)
    {
      arrayOfLinearLayout = new LinearLayout[7];
      arrayOfLinearLayout[0] = ((LinearLayout)localDataSet.view.findViewById(2131362042));
      arrayOfLinearLayout[1] = ((LinearLayout)localDataSet.view.findViewById(2131362047));
      arrayOfLinearLayout[2] = ((LinearLayout)localDataSet.view.findViewById(2131362048));
      arrayOfLinearLayout[3] = ((LinearLayout)localDataSet.view.findViewById(2131362049));
      arrayOfLinearLayout[4] = ((LinearLayout)localDataSet.view.findViewById(2131362050));
      arrayOfLinearLayout[5] = ((LinearLayout)localDataSet.view.findViewById(2131362051));
      arrayOfLinearLayout[6] = ((LinearLayout)localDataSet.view.findViewById(2131362052));
    }
    TextView[] arrayOfTextView2;
    JSONObject localJSONObject1;
    int k;
    for (int j = 0;; j++)
    {
      if (j >= arrayOfLinearLayout.length)
      {
        return;
        Calendar localCalendar = FormatUtil.getDateStringToCalendar(localDataSet.date[i], "yyyy-MM-dd");
        arrayOfTextView1[i].setText(FormatUtil.getDateCalendarToString(localCalendar, "M/d") + "(" + FormatUtil.getDateDayOfWeek(localCalendar, false) + ")");
        arrayOfTextView1[i].setTextColor(FormatUtil.getDateColor(localCalendar));
        i++;
        break;
      }
      arrayOfTextView2 = new TextView[4];
      arrayOfTextView2[0] = ((TextView)arrayOfLinearLayout[j].findViewById(2131362043));
      arrayOfTextView2[1] = ((TextView)arrayOfLinearLayout[j].findViewById(2131362044));
      arrayOfTextView2[2] = ((TextView)arrayOfLinearLayout[j].findViewById(2131362045));
      arrayOfTextView2[3] = ((TextView)arrayOfLinearLayout[j].findViewById(2131362046));
      localJSONObject1 = JSONUtil.getJSONObject(localDataSet.array, j);
      k = 0;
      if (k < 4) {
        break label391;
      }
    }
    label391:
    int m = JSONUtil.getInteger(localJSONObject1, "count" + (k + 1));
    if (m != 0)
    {
      arrayOfTextView2[k].setText(String.valueOf(m));
      arrayOfTextView2[k].setTextColor(arrayOfTextView1[k].getTextColors());
      arrayOfTextView2[k].setBackgroundResource(2130837721);
      arrayOfTextView2[k].setEnabled(true);
      final JSONObject localJSONObject2 = new JSONObject();
      JSONUtil.put(localJSONObject2, "date", localDataSet.date[k]);
      JSONUtil.put(localJSONObject2, "loc_name", JSONUtil.getString(localJSONObject1, "loc_name", ""));
      JSONUtil.put(localJSONObject2, "no", JSONUtil.getString(localJSONObject1, "no", ""));
      arrayOfTextView2[k].setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (DatePagerAdapter.this.mListener != null) {
            DatePagerAdapter.this.mListener.onClick(paramAnonymousView, 0, localJSONObject2);
          }
        }
      });
    }
    for (;;)
    {
      k++;
      break;
      arrayOfTextView2[k].setText(String.valueOf(m));
      arrayOfTextView2[k].setTextColor(-3291490);
      arrayOfTextView2[k].setBackgroundColor(0);
      arrayOfTextView2[k].setEnabled(false);
    }
  }
  
  public class DataSet
  {
    public JSONArray array;
    public String[] date;
    public View view;
    
    public DataSet() {}
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.adapter.DatePagerAdapter
 * JD-Core Version:    0.7.0.1
 */