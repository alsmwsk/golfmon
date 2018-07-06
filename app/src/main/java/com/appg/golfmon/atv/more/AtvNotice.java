package com.appg.golfmon.atv.more;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.appg.golfmon.atv.AtvBase;
import com.appg.golfmon.common.InterfaceSet.IScrollPullListener;
import com.appg.golfmon.net.http.GFailedHandler;
import com.appg.golfmon.net.http.GJSONDecoder;
import com.appg.golfmon.net.http.GPClient;
import com.appg.golfmon.net.http.GResultHandler;
import com.appg.golfmon.util.Alert;
import com.appg.golfmon.util.FormatUtil;
import com.appg.golfmon.util.JSONUtil;
import com.appg.golfmon.util.ListenerUtil;
import com.appg.golfmon.view.GListView;
import com.appg.golfmon.view.GListView.GListAdapter;
import com.appg.golfmon.view.GListView.IMakeView;
import org.json.JSONArray;
import org.json.JSONObject;
import ra.genius.net.GBean;
import ra.genius.net.GExecutor;

public class AtvNotice
  extends AtvBase
  implements GListView.IMakeView
{
  private GListView mList = null;
  private String mRequestNo = "";
  private int mSelPos = -1;
  
  private void callApi_getListOfNotice(final boolean paramBoolean)
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("Api.getListOfMonthly");
    if (!paramBoolean) {
      localGPClient.addParameter("page_no", JSONUtil.getString(this.mList.getLastItem(), "no", ""));
    }
    localGPClient.setDecoder(new GJSONDecoder(2));
    localGPClient.addProgress();
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvNotice.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        if (paramBoolean) {
          AtvNotice.this.mList.removeAll();
        }
        if (paramAnonymousInt > 0)
        {
          AtvNotice.this.mList.addItems((JSONArray)paramAnonymousObject);
          AtvNotice.this.mList.setHasMore(JSONUtil.getBoolean(paramAnonymousJSONObject, "isNextPage", false));
          if (FormatUtil.isNullorEmpty(AtvNotice.this.mRequestNo)) {}
        }
        for (int i = 0;; i++)
        {
          if (i >= AtvNotice.this.mList.getCountAll()) {}
          for (;;)
          {
            AtvNotice.this.mRequestNo = "";
            AtvNotice.this.setNodata();
            return null;
            String str = JSONUtil.getString(AtvNotice.this.mList.getItem(i), "no", "");
            if (!AtvNotice.this.mRequestNo.equals(str)) {
              break;
            }
            AtvNotice.this.mSelPos = i;
            AtvNotice.this.mList.refresh();
            AtvNotice.this.mList.setSelection(AtvNotice.this.mSelPos);
          }
        }
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  private void setNodata()
  {
    this.mList.getCountAll();
  }
  
  protected void configureListener()
  {
    this.mTxtTopTitleLeftBack.setOnClickListener(ListenerUtil.getFinishButtonListener(getContext()));
    this.mList.setOnScrollPullListener(new InterfaceSet.IScrollPullListener()
    {
      public void onPullDown(Context paramAnonymousContext) {}
      
      public void onPullUp(Context paramAnonymousContext)
      {
        if (AtvNotice.this.mList.getHasMore()) {
          AtvNotice.this.callApi_getListOfNotice(false);
        }
      }
    });
  }
  
  protected void findView()
  {
    this.mList = ((GListView)findViewById(2131361864));
  }
  
  protected boolean getBundle()
  {
    this.mRequestNo = getIntent().getStringExtra("EXTRAS_ID");
    if (this.mRequestNo == null) {
      this.mRequestNo = "";
    }
    return true;
  }
  
  protected void init()
  {
    this.mTxtTopTitleLeftBack.setVisibility(0);
    this.mTxtTopTitleLeftBack.setText("공지사항");
    callApi_getListOfNotice(true);
    this.mList.setViewMaker(2130903097, this);
  }
  
  public View makeView(GListView.GListAdapter paramGListAdapter, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    final JSONObject localJSONObject = (JSONObject)paramGListAdapter.getItem(paramInt);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131362080);
    TextView localTextView = (TextView)paramView.findViewById(2131361872);
    ((TextView)paramView.findViewById(2131362082)).setText("  " + JSONUtil.getString(localJSONObject, "t1count", ""));
    localTextView.setText(JSONUtil.getString(localJSONObject, "title", ""));
    String str = new StringBuilder("  ").append(FormatUtil.getDateConvert(JSONUtil.getString(localJSONObject, "regist_dt", ""), "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd")).toString() + "  조회수:" + JSONUtil.getString(localJSONObject, "read_count", "");
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-10066330), 0, str.length(), 33);
    localSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(20), 0, str.length(), 33);
    localTextView.append(localSpannableStringBuilder);
    localRelativeLayout.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(AtvNotice.this.getContext(), AtvNoticeDetail.class);
        localIntent.putExtra("EXTRAS_JSON_STRING", localJSONObject.toString());
        AtvNotice.this.startActivity(localIntent);
      }
    });
    return paramView;
  }
  
  protected void setView()
  {
    setView(2130903050);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.atv.more.AtvNotice
 * JD-Core Version:    0.7.0.1
 */