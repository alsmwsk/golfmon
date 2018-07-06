package com.appg.golfmon.atv.more;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

public class AtvFAQ
  extends AtvBase
  implements GListView.IMakeView
{
  private GListView mList = null;
  private int mSelPos = -1;
  
  private void callApi_getListOfFaq(final boolean paramBoolean)
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("Api.getListOfFaq");
    if (!paramBoolean) {
      localGPClient.addParameter("page_no", JSONUtil.getString(this.mList.getLastItem(), "no", ""));
    }
    localGPClient.setDecoder(new GJSONDecoder(2));
    localGPClient.addProgress();
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvFAQ.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        if (paramBoolean) {
          AtvFAQ.this.mList.removeAll();
        }
        if (paramAnonymousInt > 0)
        {
          AtvFAQ.this.mList.addItems((JSONArray)paramAnonymousObject);
          AtvFAQ.this.mList.setHasMore(JSONUtil.getBoolean(paramAnonymousJSONObject, "isNextPage", false));
        }
        AtvFAQ.this.setNodata();
        return null;
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
        if (AtvFAQ.this.mList.getHasMore()) {
          AtvFAQ.this.callApi_getListOfFaq(false);
        }
      }
    });
  }
  
  protected void findView()
  {
    this.mList = ((GListView)findViewById(2131361864));
  }
  
  protected void init()
  {
    this.mTxtTopTitleLeftBack.setVisibility(0);
    this.mTxtTopTitleLeftBack.setText("도움말");
    callApi_getListOfFaq(true);
    this.mList.setViewMaker(2130903096, this);
  }
  
  public View makeView(GListView.GListAdapter paramGListAdapter, final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    JSONObject localJSONObject = (JSONObject)paramGListAdapter.getItem(paramInt);
    LinearLayout localLinearLayout1 = (LinearLayout)paramView.findViewById(2131362080);
    ImageView localImageView1 = (ImageView)paramView.findViewById(2131362081);
    TextView localTextView1 = (TextView)paramView.findViewById(2131361872);
    TextView localTextView2 = (TextView)paramView.findViewById(2131361873);
    ImageView localImageView2 = (ImageView)paramView.findViewById(2131362082);
    LinearLayout localLinearLayout2 = (LinearLayout)paramView.findViewById(2131362083);
    ImageView localImageView3 = (ImageView)paramView.findViewById(2131362084);
    TextView localTextView3 = (TextView)paramView.findViewById(2131361877);
    localImageView1.setVisibility(0);
    localImageView3.setVisibility(0);
    localTextView1.setText(JSONUtil.getString(localJSONObject, "title", ""));
    localTextView2.setText(FormatUtil.getDateConvert(JSONUtil.getString(localJSONObject, "regist_dt", ""), "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd"));
    localTextView3.setText(JSONUtil.getString(localJSONObject, "content", ""));
    int i;
    if (this.mSelPos == paramInt)
    {
      i = 2130837627;
      localImageView2.setImageResource(i);
      if (this.mSelPos != paramInt) {
        break label219;
      }
    }
    label219:
    for (int j = 0;; j = 8)
    {
      localLinearLayout2.setVisibility(j);
      localLinearLayout1.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          AtvFAQ localAtvFAQ = AtvFAQ.this;
          if (AtvFAQ.this.mSelPos == paramInt) {}
          for (int i = -1;; i = paramInt)
          {
            localAtvFAQ.mSelPos = i;
            AtvFAQ.this.mList.refresh();
            return;
          }
        }
      });
      return paramView;
      i = 2130837626;
      break;
    }
  }
  
  protected void setView()
  {
    setView(2130903050);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.atv.more.AtvFAQ
 * JD-Core Version:    0.7.0.1
 */