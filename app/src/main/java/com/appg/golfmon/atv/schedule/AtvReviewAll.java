package com.appg.golfmon.atv.schedule;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TableRow;
import android.widget.TextView;
import com.appg.golfmon.atv.AtvBase;
import com.appg.golfmon.atv.AtvShowPhoto;
import com.appg.golfmon.net.http.GFailedHandler;
import com.appg.golfmon.net.http.GJSONDecoder;
import com.appg.golfmon.net.http.GPClient;
import com.appg.golfmon.net.http.GResultHandler;
import com.appg.golfmon.util.Alert;
import com.appg.golfmon.util.Alert.OnCloseListener;
import com.appg.golfmon.util.FormatUtil;
import com.appg.golfmon.util.JSONUtil;
import com.appg.golfmon.util.LogUtil;
import com.appg.golfmon.util.SPUtil;
import com.appg.golfmon.view.GImageView;
import com.appg.golfmon.view.GListView;
import com.appg.golfmon.view.GListView.GListAdapter;
import com.appg.golfmon.view.GListView.IMakeView;
import org.json.JSONArray;
import org.json.JSONObject;
import ra.genius.net.GBean;
import ra.genius.net.GExecutor;

public class AtvReviewAll
  extends AtvBase
  implements GListView.IMakeView
{
  private LinearLayout mBtnWriteRounding = null;
  private JSONObject mGolfInfo = null;
  private int mGolfNo = 0;
  private GListView mList = null;
  private int mMyUserNo = -10;
  
  private void callApi_deleteComment(JSONObject paramJSONObject)
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("ApiTransferJoin.deleteComment");
    localGPClient.addParameter("no", JSONUtil.getString(paramJSONObject, "no", ""));
    localGPClient.setDecoder(new GJSONDecoder(3));
    localGPClient.addProgress();
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvReviewAll.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        if (paramAnonymousInt > 0)
        {
          AtvReviewAll.this.callApi_getInfoOfGolf(true, null);
          AtvReviewAll.this.setResult(-1);
        }
        new Alert().showAlert(AtvReviewAll.this.getContext(), paramAnonymousString);
        return null;
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  private void callApi_getInfoOfGolf(final boolean paramBoolean, GResultHandler paramGResultHandler)
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("ApiTransferJoin.getInfoOfGolf");
    localGPClient.addParameter("golf_fk", Integer.valueOf(this.mGolfNo));
    localGPClient.setDecoder(new GJSONDecoder(3));
    localGPClient.addProgress();
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvReviewAll.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        if (paramBoolean) {
          AtvReviewAll.this.mList.removeAll();
        }
        if (paramAnonymousInt > 0)
        {
          if (paramBoolean)
          {
            AtvReviewAll.this.mGolfInfo = JSONUtil.getJSONObject(paramAnonymousJSONObject, "entityGolf");
            AtvReviewAll.this.setDataScore();
          }
          AtvReviewAll.this.mList.addItems(JSONUtil.getJSONArray(paramAnonymousJSONObject, "entityComment"));
        }
        return paramAnonymousGBean;
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  private void checkPush()
  {
    if ("2".equals(getIntent().getStringExtra("pushTypeID")))
    {
      Intent localIntent = new Intent(getContext(), AtvReviewWrite.class);
      localIntent.putExtra("EXTRAS_JSON_STRING", this.mGolfInfo.toString());
      startActivityForResult(localIntent, 1000);
    }
  }
  
  private int setDataScore(View paramView, int paramInt1, int paramInt2)
  {
    SeekBar localSeekBar = (SeekBar)paramView.findViewById(2131361832);
    TextView localTextView = (TextView)paramView.findViewById(2131361833);
    localSeekBar.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    localSeekBar.setMax(100);
    int i = 0;
    if (paramInt2 == 0) {
      localSeekBar.setProgress(0);
    }
    for (;;)
    {
      localTextView.setText(FormatUtil.toPriceFormat(paramInt1));
      return i;
      i = (int)(100.0F * (paramInt1 / paramInt2));
      localSeekBar.setProgress(i);
    }
  }
  
  private void setDataScore()
  {
    this.mTxtTopTitleLeft2_1.setVisibility(0);
    this.mTxtTopTitleLeft2_2.setVisibility(0);
    this.mTxtTopTitleLeft2_1.setText(JSONUtil.getString(this.mGolfInfo, "name", ""));
    this.mTxtTopTitleLeft2_2.setText(JSONUtil.getString(this.mGolfInfo, "address", ""));
    TextView localTextView1 = (TextView)findViewById(2131361829);
    TextView localTextView2 = (TextView)findViewById(2131361830);
    TableRow[] arrayOfTableRow = new TableRow[5];
    arrayOfTableRow[4] = ((TableRow)findViewById(2131361831));
    arrayOfTableRow[3] = ((TableRow)findViewById(2131361834));
    arrayOfTableRow[2] = ((TableRow)findViewById(2131361835));
    arrayOfTableRow[1] = ((TableRow)findViewById(2131361836));
    arrayOfTableRow[0] = ((TableRow)findViewById(2131361837));
    int i = JSONUtil.getInteger(this.mGolfInfo, "comm_cnt", 0);
    int j = 0;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Double.valueOf(JSONUtil.getDouble(this.mGolfInfo, "grade", 0.0D));
    localTextView1.setText(String.format("%1.1f", arrayOfObject));
    localTextView2.setText(FormatUtil.toPriceFormat(i) + "명");
    int k = 0;
    if (k >= arrayOfTableRow.length) {
      if (j <= 0) {}
    }
    for (int n = 0;; n++)
    {
      if (n >= arrayOfTableRow.length)
      {
        return;
        int m = setDataScore(arrayOfTableRow[k], JSONUtil.getInteger(this.mGolfInfo, "counts" + (k + 1), 0), i);
        if (j < m) {
          j = m;
        }
        k++;
        break;
      }
      SeekBar localSeekBar = (SeekBar)arrayOfTableRow[n].findViewById(2131361832);
      localSeekBar.setMax(j);
      localSeekBar.invalidate();
    }
  }
  
  private void showPhoto(JSONObject paramJSONObject, int paramInt)
  {
    JSONArray localJSONArray = new JSONArray();
    for (int i = 1;; i++)
    {
      if (i > 3)
      {
        if (localJSONArray.length() > 0)
        {
          Intent localIntent = new Intent(getContext(), AtvShowPhoto.class);
          localIntent.putExtra("EXTRAS_TYPE", 200);
          localIntent.putExtra("EXTRAS_JSON_STRING", localJSONArray.toString());
          localIntent.putExtra("EXTRAS_POSITION", paramInt);
          startActivity(localIntent);
        }
        return;
      }
      String str = JSONUtil.getString(paramJSONObject, "imgUrl" + i, "");
      if (!FormatUtil.isNullorEmpty(str))
      {
        JSONObject localJSONObject = new JSONObject();
        JSONUtil.put(localJSONObject, "imagePath", str);
        localJSONArray.put(localJSONObject);
      }
    }
  }
  
  protected void configureListener()
  {
    this.mBtnWriteRounding.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (!AtvReviewAll.this.checkLogin(true)) {
          return;
        }
        Intent localIntent = new Intent(paramAnonymousView.getContext(), AtvReviewWrite.class);
        localIntent.putExtra("EXTRAS_JSON_STRING", AtvReviewAll.this.mGolfInfo.toString());
        AtvReviewAll.this.startActivityForResult(localIntent, 1000);
      }
    });
  }
  
  protected void findView()
  {
    this.mBtnWriteRounding = ((LinearLayout)findViewById(2131361966));
    this.mList = ((GListView)findViewById(2131361864));
    setDataScore();
  }
  
  protected boolean getBundle()
  {
    LogUtil.intent("AtvReviewAll", getIntent());
    this.mMyUserNo = JSONUtil.getInteger(SPUtil.getInstance().getUserInfo(getContext()), "no", -10);
    this.mGolfInfo = JSONUtil.createObject(getIntent(), "EXTRAS_JSON_STRING");
    this.mGolfNo = getIntent().getIntExtra("EXTRAS_ID", -1);
    try
    {
      if (this.mGolfNo <= 0) {
        this.mGolfNo = Integer.parseInt(getIntent().getStringExtra("golf_fk"));
      }
      label82:
      return this.mGolfNo > 0;
    }
    catch (Exception localException)
    {
      break label82;
    }
  }
  
  protected void init()
  {
    this.mList.setViewMaker(2130903084, this);
    setDataScore();
    callApi_getInfoOfGolf(true, new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        if (paramAnonymousInt > 0) {
          AtvReviewAll.this.checkPush();
        }
        return null;
      }
    });
  }
  
  public View makeView(GListView.GListAdapter paramGListAdapter, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    final JSONObject localJSONObject = (JSONObject)paramGListAdapter.getItem(paramInt);
    TextView localTextView1 = (TextView)paramView.findViewById(2131361945);
    ImageButton localImageButton = (ImageButton)paramView.findViewById(2131362011);
    RatingBar localRatingBar = (RatingBar)paramView.findViewById(2131361838);
    TextView localTextView2 = (TextView)paramView.findViewById(2131361873);
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131362058);
    GImageView localGImageView1 = (GImageView)paramView.findViewById(2131361878);
    GImageView localGImageView2 = (GImageView)paramView.findViewById(2131361879);
    GImageView localGImageView3 = (GImageView)paramView.findViewById(2131361880);
    TextView localTextView3 = (TextView)paramView.findViewById(2131361877);
    int i = JSONUtil.getInteger(localJSONObject, "user_fk", -70);
    localTextView1.setText(JSONUtil.getString(localJSONObject, "nick_name", ""));
    int j;
    final String str1;
    final String str2;
    final String str3;
    if (this.mMyUserNo == i)
    {
      j = 0;
      localImageButton.setVisibility(j);
      localRatingBar.setRating(JSONUtil.getInteger(localJSONObject, "grade", 0));
      localTextView2.setText(FormatUtil.getDateConvert(JSONUtil.getString(localJSONObject, "regist_dt", ""), "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd"));
      str1 = JSONUtil.getString(localJSONObject, "imgUrl1", "");
      str2 = JSONUtil.getString(localJSONObject, "imgUrl2", "");
      str3 = JSONUtil.getString(localJSONObject, "imgUrl3", "");
      if ((!FormatUtil.isNullorEmpty(str1)) || (!FormatUtil.isNullorEmpty(str2)) || (!FormatUtil.isNullorEmpty(str3))) {
        break label308;
      }
      localLinearLayout.setVisibility(8);
    }
    for (;;)
    {
      localTextView3.setText(JSONUtil.getString(localJSONObject, "content", ""));
      localImageButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Alert localAlert = new Alert();
          localAlert.setOnCloseListener(new Alert.OnCloseListener()
          {
            public void onClose(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int, Object paramAnonymous2Object)
            {
              if (1 == paramAnonymous2Int) {
                AtvReviewAll.this.callApi_deleteComment(this.val$json);
              }
            }
          });
          localAlert.showAlert(AtvReviewAll.this.getContext(), "라운딩 후기를 삭제하시겠습니까?", true, new String[] { "삭제", "취소" });
        }
      });
      return paramView;
      j = 4;
      break;
      label308:
      localLinearLayout.setVisibility(0);
      localGImageView1.setImageViewUser(str1, "480", 2130837692);
      localGImageView2.setImageViewUser(str2, "480", 2130837692);
      localGImageView3.setImageViewUser(str3, "480", 2130837692);
      localGImageView1.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (!FormatUtil.isNullorEmpty(str1)) {
            AtvReviewAll.this.showPhoto(localJSONObject, 0);
          }
        }
      });
      localGImageView2.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (!FormatUtil.isNullorEmpty(str2)) {
            AtvReviewAll.this.showPhoto(localJSONObject, 1);
          }
        }
      });
      localGImageView3.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (!FormatUtil.isNullorEmpty(str3)) {
            AtvReviewAll.this.showPhoto(localJSONObject, 2);
          }
        }
      });
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      setResult(-1);
      callApi_getInfoOfGolf(true, null);
    }
  }
  
  protected void setView()
  {
    setView(2130903062);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.atv.schedule.AtvReviewAll
 * JD-Core Version:    0.7.0.1
 */