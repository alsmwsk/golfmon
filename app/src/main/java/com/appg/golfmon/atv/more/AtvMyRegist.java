package com.appg.golfmon.atv.more;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.appg.golfmon.atv.AtvBase;
import com.appg.golfmon.atv.schedule.AtvDetail;
import com.appg.golfmon.atv.schedule.AtvRegist;
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
import com.appg.golfmon.view.GListView;
import com.appg.golfmon.view.GListView.GListAdapter;
import com.appg.golfmon.view.GListView.IMakeView;
import com.appg.golfmon.view.GSpinner;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import ra.genius.net.GBean;
import ra.genius.net.GExecutor;

public class AtvMyRegist
  extends AtvBase
  implements GListView.IMakeView
{
  private Button btn3 = null;
  private Button btnAll = null;
  private Button btnDate = null;
  private Button btnDone = null;
  private Button btnIng = null;
  private ImageButton btnReq = null;
  private String dates = "";
  private String golf_fk = "";
  private ArrayList<JSONObject> mArrayList = new ArrayList();
  private LinearLayout mBaseBtns = null;
  private LinearLayout mBaseHeader = null;
  private LinearLayout mBaseName = null;
  private LinearLayout mBaseNodata = null;
  private LinearLayout mBaseRound = null;
  private ImageButton mBtnAll = null;
  private Button mBtnConfirm = null;
  private Button mBtnDelete = null;
  private Button mBtnTabJoin = null;
  private Button mBtnTabTransfer = null;
  protected Button mBtnTopRight = null;
  private Calendar mCalendar = null;
  private Calendar mCalendarNow = null;
  private Comparator<JSONObject> mComparator_dates = new Comparator()
  {
    public int compare(JSONObject paramAnonymousJSONObject1, JSONObject paramAnonymousJSONObject2)
    {
      return JSONUtil.getString(paramAnonymousJSONObject1, "dates", "").compareTo(JSONUtil.getString(paramAnonymousJSONObject2, "dates", ""));
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
  private GListView mList = null;
  private HashMap<Integer, JSONObject> mMapSel = new HashMap();
  private int mSelTab = 100;
  private TextView mTxtNodata = null;
  private ArrayList<JSONObject> modiArray = new ArrayList();
  private GSpinner spinnerLocation = null;
  private GSpinner spinnerStatus = null;
  private TextView txtNoti = null;
  private int type = 100;
  
  private void callApi_deleteTransferJoinList()
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("ApiTransferJoin.deleteTransferJoinList");
    Iterator localIterator;
    if (this.mSelTab == 100)
    {
      localGPClient.addParameter("transferJoinTypeID", Integer.valueOf(1));
      localIterator = this.mMapSel.keySet().iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        localGPClient.setDecoder(new GJSONDecoder(2));
        localGPClient.addProgress();
        localGPClient.addHandler(new GFailedHandler()
        {
          public void failedExecute(GBean paramAnonymousGBean)
          {
            Alert.toastLong(AtvMyRegist.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
          }
        });
        localGPClient.addHandler(new GResultHandler()
        {
          public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
          {
            if (paramAnonymousInt > 0)
            {
              AtvMyRegist.this.mBtnAll.setSelected(false);
              AtvMyRegist.this.mMapSel.clear();
              AtvMyRegist.this.callApi_getListOfTransferJoin_My(true);
            }
            new Alert().showAlert(AtvMyRegist.this.getContext(), paramAnonymousString);
            return null;
          }
        });
        GExecutor.getInstance().execute(localGPClient);
        return;
        if (this.mSelTab != 200) {
          break;
        }
        localGPClient.addParameter("transferJoinTypeID", Integer.valueOf(2));
        break;
      }
      localGPClient.addParameter("transferJoinID[]", (Integer)localIterator.next());
    }
  }
  
  private void callApi_finishTransferJoinList()
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("ApiTransferJoin.finishTransferJoinList");
    Iterator localIterator;
    if (this.mSelTab == 100)
    {
      localGPClient.addParameter("transferJoinTypeID", Integer.valueOf(1));
      localIterator = this.mMapSel.keySet().iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        localGPClient.setDecoder(new GJSONDecoder(2));
        localGPClient.addProgress();
        localGPClient.addHandler(new GFailedHandler()
        {
          public void failedExecute(GBean paramAnonymousGBean)
          {
            Alert.toastLong(AtvMyRegist.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
          }
        });
        localGPClient.addHandler(new GResultHandler()
        {
          public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
          {
            if (paramAnonymousInt > 0)
            {
              AtvMyRegist.this.mBtnAll.setSelected(false);
              AtvMyRegist.this.mMapSel.clear();
              AtvMyRegist.this.callApi_getListOfTransferJoin_My(true);
            }
            new Alert().showAlert(AtvMyRegist.this.getContext(), paramAnonymousString);
            return null;
          }
        });
        GExecutor.getInstance().execute(localGPClient);
        return;
        if (this.mSelTab != 200) {
          break;
        }
        localGPClient.addParameter("transferJoinTypeID", Integer.valueOf(2));
        break;
      }
      localGPClient.addParameter("transferJoinID[]", (Integer)localIterator.next());
    }
  }
  
  private void callApi_getListOfLocation()
  {
    GPClient localGPClient = new GPClient(this);
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.setDecoder(new GJSONDecoder(2));
    localGPClient.addParameter("cmd", "Api.getListOfLocation");
    localGPClient.addProgress();
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvMyRegist.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        if (paramAnonymousInt > 0)
        {
          JSONArray localJSONArray = (JSONArray)paramAnonymousObject;
          AtvMyRegist.this.spinnerLocation.setKey("loc_name");
          AtvMyRegist.this.spinnerLocation.addItems(localJSONArray);
          AtvMyRegist.this.spinnerLocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
          {
            public void onItemSelected(AdapterView<?> paramAnonymous2AdapterView, View paramAnonymous2View, int paramAnonymous2Int, long paramAnonymous2Long)
            {
              JSONObject localJSONObject1 = AtvMyRegist.this.spinnerLocation.getSelectedItem();
              LogUtil.json(localJSONObject1);
              String str = JSONUtil.getString(localJSONObject1, "no");
              AtvMyRegist.this.mList.removeAll();
              ArrayList localArrayList = new ArrayList();
              for (int i = 0;; i++)
              {
                if (i >= AtvMyRegist.this.mArrayList.size())
                {
                  AtvMyRegist.this.mList.addItems(localArrayList);
                  return;
                }
                JSONObject localJSONObject2 = (JSONObject)AtvMyRegist.this.mArrayList.get(i);
                if (JSONUtil.getString(localJSONObject2, "no", "").equals(str)) {
                  localArrayList.add(localJSONObject2);
                }
              }
            }
            
            public void onNothingSelected(AdapterView<?> paramAnonymous2AdapterView) {}
          });
        }
        for (;;)
        {
          return null;
          AtvMyRegist.this.spinnerLocation.addItems(new JSONArray());
        }
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  private void callApi_getListOfTransferJoin_My(final boolean paramBoolean)
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("ApiTransferJoin.getListOfTransferJoin_My");
    if (this.mSelTab == 100) {
      localGPClient.addParameter("transferJoinTypeID", Integer.valueOf(1));
    }
    for (;;)
    {
      localGPClient.addParameter("golf_fk", this.golf_fk);
      localGPClient.addParameter("dates", this.dates);
      localGPClient.setDecoder(new GJSONDecoder(2));
      localGPClient.addProgress();
      localGPClient.addHandler(new GFailedHandler()
      {
        public void failedExecute(GBean paramAnonymousGBean)
        {
          Alert.toastLong(AtvMyRegist.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
        }
      });
      localGPClient.addHandler(new GResultHandler()
      {
        public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          if (paramBoolean)
          {
            AtvMyRegist.this.modiArray.clear();
            AtvMyRegist.this.mArrayList.clear();
            AtvMyRegist.this.mList.removeAll();
            AtvMyRegist.this.mMapSel.clear();
            AtvMyRegist.this.mBtnAll.setSelected(false);
          }
          JSONArray localJSONArray;
          if (paramAnonymousInt > 0)
          {
            AtvMyRegist.this.modiArray.clear();
            AtvMyRegist.this.mArrayList.clear();
            localJSONArray = (JSONArray)paramAnonymousObject;
          }
          for (int i = 0;; i++)
          {
            if ((localJSONArray == null) || (i >= localJSONArray.length()))
            {
              AtvMyRegist.this.mList.removeAll();
              AtvMyRegist.this.mList.addItems(AtvMyRegist.this.mArrayList);
              AtvMyRegist.this.setNodata();
              return null;
            }
            JSONObject localJSONObject = JSONUtil.getJSONObject(localJSONArray, i);
            AtvMyRegist.this.mArrayList.add(localJSONObject);
            AtvMyRegist.this.modiArray.add(localJSONObject);
          }
        }
      });
      GExecutor.getInstance().execute(localGPClient);
      return;
      if (this.mSelTab == 200) {
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
  
  private void setList()
  {
    boolean bool = this.btnReq.isSelected();
    this.modiArray.clear();
    int n;
    if (this.btnAll.isSelected())
    {
      this.txtNoti.setVisibility(8);
      this.mList.removeAll();
      if (bool)
      {
        n = 0;
        if (n >= this.mArrayList.size()) {
          this.mList.addItems(this.modiArray);
        }
      }
    }
    label317:
    label457:
    int i;
    for (;;)
    {
      this.mList.getAdapter().notifyDataSetChanged();
      return;
      JSONObject localJSONObject5 = (JSONObject)this.mArrayList.get(n);
      if (!JSONUtil.getString(localJSONObject5, "reqCounts", "").equals("0")) {
        this.modiArray.add(localJSONObject5);
      }
      n++;
      break;
      for (int m = 0;; m++)
      {
        if (m >= this.mArrayList.size())
        {
          this.mList.addItems(this.mArrayList);
          break;
        }
        JSONObject localJSONObject4 = (JSONObject)this.mArrayList.get(m);
        this.modiArray.add(localJSONObject4);
      }
      if (this.btnIng.isSelected())
      {
        this.txtNoti.setVisibility(8);
        this.mList.removeAll();
        int k = 0;
        if (k >= this.mArrayList.size())
        {
          this.mList.addItems(this.modiArray);
        }
        else
        {
          JSONObject localJSONObject3 = (JSONObject)this.mArrayList.get(k);
          if (JSONUtil.getString(localJSONObject3, "isApply", "").equals("1"))
          {
            if (!bool) {
              break label317;
            }
            if (!JSONUtil.getString(localJSONObject3, "reqCounts", "").equals("0")) {
              this.modiArray.add(localJSONObject3);
            }
          }
          for (;;)
          {
            k++;
            break;
            this.modiArray.add(localJSONObject3);
          }
        }
      }
      else if (this.btnDone.isSelected())
      {
        this.txtNoti.setVisibility(8);
        this.mList.removeAll();
        int j = 0;
        if (j >= this.mArrayList.size())
        {
          this.mList.addItems(this.modiArray);
        }
        else
        {
          JSONObject localJSONObject2 = (JSONObject)this.mArrayList.get(j);
          if (JSONUtil.getString(localJSONObject2, "isApply", "").equals("2"))
          {
            if (!bool) {
              break label457;
            }
            if (!JSONUtil.getString(localJSONObject2, "reqCounts", "").equals("0")) {
              this.modiArray.add(localJSONObject2);
            }
          }
          for (;;)
          {
            j++;
            break;
            this.modiArray.add(localJSONObject2);
          }
        }
      }
      else if (this.btn3.isSelected())
      {
        this.txtNoti.setVisibility(0);
        this.mList.removeAll();
        i = 0;
        if (i < this.mArrayList.size()) {
          break label522;
        }
        this.mList.addItems(this.modiArray);
      }
    }
    label522:
    JSONObject localJSONObject1 = (JSONObject)this.mArrayList.get(i);
    String str = JSONUtil.getString(localJSONObject1, "isApply", "");
    long l = FormatUtil.diffOfDate(JSONUtil.getString(localJSONObject1, "registDT", ""));
    if ((str.equals("1")) && (l >= 3L))
    {
      if (!bool) {
        break label616;
      }
      if (!JSONUtil.getString(localJSONObject1, "reqCounts", "").equals("0")) {
        this.modiArray.add(localJSONObject1);
      }
    }
    for (;;)
    {
      i++;
      break;
      label616:
      this.modiArray.add(localJSONObject1);
    }
  }
  
  @SuppressLint({"NewApi"})
  private void setMindate(DatePickerDialog paramDatePickerDialog)
  {
    Calendar localCalendar = (Calendar)this.mCalendarNow.clone();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    long l = localCalendar.getTimeInMillis();
    paramDatePickerDialog.getDatePicker().setMinDate(l);
  }
  
  private void setNodata()
  {
    if (this.mList.getCountAll() > 0)
    {
      this.mBaseNodata.setVisibility(8);
      this.mList.getLayoutParams().height = -1;
      this.mBaseBtns.setVisibility(0);
      this.mBtnAll.setVisibility(0);
      return;
    }
    this.mBaseNodata.setVisibility(0);
    this.mList.getLayoutParams().height = -2;
    this.mBaseBtns.setVisibility(8);
    this.mBtnAll.setVisibility(4);
    this.mTxtNodata.setText("검색결과가 없습니다.");
  }
  
  private void setTabJoin()
  {
    this.mSelTab = 200;
    this.mBtnTopRight.setText("조인등록");
    this.mBtnTabTransfer.setSelected(false);
    this.mBtnTabJoin.setSelected(true);
    this.mMapSel.clear();
    this.mBtnAll.setSelected(false);
    this.mBtnAll.setVisibility(4);
    this.mList.removeAll();
    this.mBaseBtns.setVisibility(8);
    this.mBaseNodata.setVisibility(8);
    callApi_getListOfTransferJoin_My(true);
  }
  
  private void setTabTransfer()
  {
    this.mSelTab = 100;
    this.mBtnTopRight.setVisibility(0);
    this.mBtnTopRight.setText("양도등록");
    this.mBtnTabTransfer.setSelected(true);
    this.mBtnTabJoin.setSelected(false);
    this.mMapSel.clear();
    this.mBtnAll.setSelected(false);
    this.mBtnAll.setVisibility(4);
    this.mList.removeAll();
    this.mBaseBtns.setVisibility(8);
    this.mBaseNodata.setVisibility(8);
    callApi_getListOfTransferJoin_My(true);
  }
  
  private void showPickerDate()
  {
    DatePickerDialog localDatePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener()
    {
      public void onDateSet(DatePicker paramAnonymousDatePicker, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (Build.VERSION.SDK_INT < 11)
        {
          Calendar localCalendar = (Calendar)AtvMyRegist.this.mCalendarNow.clone();
          localCalendar.set(11, 0);
          localCalendar.set(12, 0);
          localCalendar.set(13, 0);
          localCalendar.set(14, 0);
          if (localCalendar.get(1) > paramAnonymousInt1)
          {
            new Alert().showAlert(AtvMyRegist.this.getContext(), "날짜를 다시 선택해 주세요.");
            return;
          }
          if (localCalendar.get(2) > paramAnonymousInt2)
          {
            new Alert().showAlert(AtvMyRegist.this.getContext(), "날짜를 다시 선택해 주세요.");
            return;
          }
          if (localCalendar.get(5) > paramAnonymousInt3)
          {
            new Alert().showAlert(AtvMyRegist.this.getContext(), "날짜를 다시 선택해 주세요.");
            return;
          }
        }
        AtvMyRegist.this.mCalendar.set(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
      }
    }, this.mCalendar.get(1), this.mCalendar.get(2), this.mCalendar.get(5));
    localDatePickerDialog.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        LogUtil.e("datePickerDialog.setOnDismissListener");
      }
    });
    if (Build.VERSION.SDK_INT >= 11) {
      setMindate(localDatePickerDialog);
    }
    localDatePickerDialog.show();
  }
  
  private void sortList()
  {
    if ((this.mBaseName.isSelected()) || (this.mIsNameDoule))
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      int i = 0;
      if (i >= this.modiArray.size())
      {
        Collections.sort(localArrayList2, this.mComparator_name);
        Collections.sort(localArrayList1, this.mComparator_name);
        Collections.sort(localArrayList3, this.mComparator_name);
        this.mList.removeAll();
        if (!this.mIsNameDoule) {
          break label262;
        }
        this.mList.addItems(localArrayList1);
        this.mList.addItems(localArrayList2);
      }
      for (;;)
      {
        this.mList.addItems(localArrayList3);
        return;
        JSONObject localJSONObject = (JSONObject)this.modiArray.get(i);
        String str = JSONUtil.getString(localJSONObject, "name", "");
        if (FormatUtil.isNullorEmpty(str)) {
          localArrayList3.add(localJSONObject);
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
            label191:
            if ((44032 > j) || (j > 55203)) {
              break label231;
            }
          }
          label231:
          for (int m = 1;; m = 0)
          {
            if (k == 0) {
              break label237;
            }
            localArrayList3.add(localJSONObject);
            break;
            k = 0;
            break label191;
          }
          label237:
          if (m != 0) {
            localArrayList2.add(localJSONObject);
          } else {
            localArrayList1.add(localJSONObject);
          }
        }
        label262:
        this.mList.addItems(localArrayList2);
        this.mList.addItems(localArrayList1);
      }
    }
    if (this.mBaseRound.isSelected())
    {
      Collections.sort(this.modiArray, this.mComparator_dates);
      this.mList.removeAll();
      this.mList.addItems(this.modiArray);
      return;
    }
    this.mList.removeAll();
    this.mList.addItems(this.modiArray);
  }
  
  protected void configureListener()
  {
    this.mBtnTopRight.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (!AtvMyRegist.this.checkLogin(true)) {
          return;
        }
        Intent localIntent = new Intent(AtvMyRegist.this.getContext(), AtvRegist.class);
        localIntent.putExtra("EXTRAS_TYPE", AtvMyRegist.this.mSelTab);
        AtvMyRegist.this.startActivityForResult(localIntent, 7894);
      }
    });
    this.mBaseName.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvMyRegist.this.mIsNameDoule = paramAnonymousView.isSelected();
        AtvMyRegist.this.mBaseRound.setSelected(false);
        boolean bool1 = paramAnonymousView.isSelected();
        boolean bool2 = false;
        if (bool1) {}
        for (;;)
        {
          paramAnonymousView.setSelected(bool2);
          AtvMyRegist.this.sortList();
          return;
          bool2 = true;
        }
      }
    });
    this.mBaseRound.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvMyRegist.this.mIsNameDoule = false;
        AtvMyRegist.this.mBaseName.setSelected(false);
        boolean bool1 = paramAnonymousView.isSelected();
        boolean bool2 = false;
        if (bool1) {}
        for (;;)
        {
          paramAnonymousView.setSelected(bool2);
          AtvMyRegist.this.sortList();
          return;
          bool2 = true;
        }
      }
    });
    this.btnDate.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvMyRegist.this.showPickerDate();
      }
    });
    this.btnAll.setSelected(true);
    this.btnAll.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView.setSelected(true);
        AtvMyRegist.this.btnIng.setSelected(false);
        AtvMyRegist.this.btnDone.setSelected(false);
        AtvMyRegist.this.btn3.setSelected(false);
        AtvMyRegist.this.setList();
      }
    });
    this.btnIng.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView.setSelected(true);
        AtvMyRegist.this.btnAll.setSelected(false);
        AtvMyRegist.this.btnDone.setSelected(false);
        AtvMyRegist.this.btn3.setSelected(false);
        AtvMyRegist.this.setList();
      }
    });
    this.btnDone.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView.setSelected(true);
        AtvMyRegist.this.btnIng.setSelected(false);
        AtvMyRegist.this.btnAll.setSelected(false);
        AtvMyRegist.this.btn3.setSelected(false);
        AtvMyRegist.this.setList();
      }
    });
    this.btn3.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView.setSelected(true);
        AtvMyRegist.this.btnIng.setSelected(false);
        AtvMyRegist.this.btnAll.setSelected(false);
        AtvMyRegist.this.btnDone.setSelected(false);
        AtvMyRegist.this.setList();
      }
    });
    this.btnReq.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (paramAnonymousView.isSelected()) {}
        for (boolean bool = false;; bool = true)
        {
          paramAnonymousView.setSelected(bool);
          AtvMyRegist.this.setList();
          return;
        }
      }
    });
    this.mTxtTopTitleLeftBack.setOnClickListener(ListenerUtil.getFinishButtonListener(getContext()));
    this.mBtnTabTransfer.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvMyRegist.this.setTabTransfer();
      }
    });
    this.mBtnTabJoin.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvMyRegist.this.setTabJoin();
      }
    });
    this.mBtnAll.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ImageButton localImageButton;
        if (AtvMyRegist.this.mMapSel.size() == AtvMyRegist.this.mList.getCountAll())
        {
          AtvMyRegist.this.mMapSel.clear();
          AtvMyRegist.this.mList.refresh();
          localImageButton = AtvMyRegist.this.mBtnAll;
          if (AtvMyRegist.this.mMapSel.size() != AtvMyRegist.this.mList.getCountAll()) {
            break label143;
          }
        }
        label143:
        for (boolean bool = true;; bool = false)
        {
          localImageButton.setSelected(bool);
          return;
          for (int i = 0; i < AtvMyRegist.this.mList.getCountAll(); i++)
          {
            JSONObject localJSONObject = AtvMyRegist.this.mList.getItem(i);
            AtvMyRegist.this.mMapSel.put(Integer.valueOf(JSONUtil.getInteger(localJSONObject, "transferJoinID", -i)), localJSONObject);
          }
          break;
        }
      }
    });
    this.mBtnDelete.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (AtvMyRegist.this.mMapSel.size() == 0)
        {
          new Alert().showAlert(AtvMyRegist.this.getContext(), "삭제처리하실 리스트를 체크 후 터치해 주세요.");
          return;
        }
        AtvMyRegist.this.callApi_deleteTransferJoinList();
      }
    });
    this.mBtnConfirm.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (AtvMyRegist.this.mMapSel.size() == 0)
        {
          new Alert().showAlert(AtvMyRegist.this.getContext(), "마감처리하실 리스트를 체크 후 터치해 주세요.");
          return;
        }
        AtvMyRegist.this.callApi_finishTransferJoinList();
      }
    });
  }
  
  protected void findView()
  {
    this.mBtnTopRight = ((Button)findViewById(2131361854));
    this.txtNoti = ((TextView)findViewById(2131361910));
    this.mBtnTabTransfer = ((Button)findViewById(2131361897));
    this.mBtnTabJoin = ((Button)findViewById(2131361898));
    this.mList = ((GListView)findViewById(2131361864));
    this.mBaseNodata = ((LinearLayout)findViewById(2131361865));
    this.mTxtNodata = ((TextView)findViewById(2131361866));
    this.mBaseHeader = new LinearLayout(getContext());
    this.mList.addHeaderView(this.mBaseHeader);
    this.mHeader = ((LinearLayout)InflateUtil.inflate(getContext(), 2130903077, null));
    this.mBaseHeader.addView(this.mHeader, new LinearLayout.LayoutParams(-1, -2));
    this.mBtnAll = ((ImageButton)this.mHeader.findViewById(2131361903));
    this.mBaseBtns = ((LinearLayout)findViewById(2131361907));
    this.mBtnDelete = ((Button)findViewById(2131361908));
    this.mBtnConfirm = ((Button)findViewById(2131361909));
    this.spinnerLocation = ((GSpinner)findViewById(2131361900));
    this.spinnerStatus = ((GSpinner)findViewById(2131361901));
    this.btnDate = ((Button)findViewById(2131361902));
    this.mBaseName = ((LinearLayout)this.mHeader.findViewById(2131362031));
    this.mBaseRound = ((LinearLayout)this.mHeader.findViewById(2131362032));
    this.btnAll = ((Button)findViewById(2131361903));
    this.btnIng = ((Button)findViewById(2131361905));
    this.btnDone = ((Button)findViewById(2131361904));
    this.btn3 = ((Button)findViewById(2131361858));
    this.btnReq = ((ImageButton)findViewById(2131361906));
  }
  
  public void finish()
  {
    if (this.mMapSel != null) {
      this.mMapSel.clear();
    }
    super.finish();
  }
  
  protected void init()
  {
    this.mCalendar = Calendar.getInstance();
    this.mCalendar.set(11, 9);
    this.mCalendar.set(12, 0);
    this.mCalendar.set(13, 0);
    this.mCalendar.set(14, 0);
    this.mCalendarNow = ((Calendar)this.mCalendar.clone());
    this.mTxtTopTitleLeftBack.setVisibility(0);
    this.mTxtTopTitleLeftBack.setText("나의 양도/조인");
    this.mList.setViewMaker(2130903090, this);
    this.mBtnAll.setVisibility(4);
    if (this.type == 100) {
      setTabTransfer();
    }
    for (;;)
    {
      this.spinnerLocation.addItems(new JSONArray());
      String[] arrayOfString = { "전체", "진행중", "마감" };
      this.spinnerStatus.addItems(arrayOfString);
      return;
      setTabJoin();
    }
  }
  
  public View makeView(GListView.GListAdapter paramGListAdapter, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    final JSONObject localJSONObject = (JSONObject)paramGListAdapter.getItem(paramInt);
    ImageButton localImageButton = (ImageButton)paramView.findViewById(2131362066);
    TextView localTextView1 = (TextView)paramView.findViewById(2131361869);
    TextView localTextView2 = (TextView)paramView.findViewById(2131362064);
    TextView localTextView3 = (TextView)paramView.findViewById(2131361873);
    TextView localTextView4 = (TextView)paramView.findViewById(2131362067);
    TextView localTextView5 = (TextView)paramView.findViewById(2131361833);
    TextView localTextView6 = (TextView)paramView.findViewById(2131362060);
    Calendar localCalendar1 = FormatUtil.getDateStringToCalendar(JSONUtil.getString(localJSONObject, "registDT", ""), "yyyy-MM-dd HH:mm:ss");
    Calendar localCalendar2 = FormatUtil.getDateStringToCalendar(JSONUtil.getString(localJSONObject, "dates", ""), "yyyy-MM-dd HH:mm:ss");
    long l = FormatUtil.diffOfDate(JSONUtil.getString(localJSONObject, "registDT", ""));
    label199:
    final int i;
    int j;
    int k;
    label238:
    String str;
    label248:
    int m;
    if (l == 0L)
    {
      localTextView6.setText("/ 등록 " + FormatUtil.getRegistDT(localCalendar1, this.mCalendarNow));
      if (l < 3L) {
        break label537;
      }
      localTextView6.setTextColor(-4342339);
      i = JSONUtil.getInteger(localJSONObject, "transferJoinID", -paramInt);
      j = JSONUtil.getInteger(localJSONObject, "reqCounts", 0);
      if (JSONUtil.getInteger(localJSONObject, "isApply", 0) != 2) {
        break label554;
      }
      k = 1;
      if (k == 0) {
        break label560;
      }
      str = "마감";
      localTextView2.setText(str);
      if (k == 0) {
        break label568;
      }
      m = 2130837506;
      label265:
      localTextView2.setBackgroundResource(m);
      localTextView1.setText(JSONUtil.getString(localJSONObject, "name", ""));
      if (l < 3L) {
        break label576;
      }
      localTextView1.setTextColor(-4342339);
      label304:
      if (this.mSelTab != 200) {
        break label587;
      }
      localTextView4.setText("조인요청 : " + FormatUtil.toPriceFormat(j) + "명");
      label347:
      if (l < 3L) {
        break label623;
      }
      localTextView4.setTextColor(-4342339);
      label364:
      localTextView3.setText(getDate(localCalendar2));
      localTextView3.setTextColor(FormatUtil.getDateColor(localCalendar2));
      if (l < 3L) {
        break label634;
      }
      localTextView3.setTextColor(-4342339);
      label402:
      localTextView5.setText(FormatUtil.toPriceFormat(JSONUtil.getInteger(localJSONObject, "readCount", 0)));
      if (l < 3L) {
        break label645;
      }
      localTextView5.setTextColor(-4342339);
      label437:
      if (!this.mMapSel.containsKey(Integer.valueOf(i))) {
        break label656;
      }
    }
    label645:
    label656:
    for (int n = 2130837551;; n = 2130837729)
    {
      localImageButton.setImageResource(n);
      View.OnClickListener local22 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          ImageButton localImageButton;
          if (AtvMyRegist.this.mMapSel.containsKey(Integer.valueOf(i)))
          {
            AtvMyRegist.this.mMapSel.remove(Integer.valueOf(i));
            AtvMyRegist.this.mList.refresh();
            localImageButton = AtvMyRegist.this.mBtnAll;
            if (AtvMyRegist.this.mMapSel.size() != AtvMyRegist.this.mList.getCountAll()) {
              break label114;
            }
          }
          label114:
          for (boolean bool = true;; bool = false)
          {
            localImageButton.setSelected(bool);
            return;
            AtvMyRegist.this.mMapSel.put(Integer.valueOf(i), localJSONObject);
            break;
          }
        }
      };
      localImageButton.setOnClickListener(local22);
      View.OnClickListener local23 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Intent localIntent = new Intent(paramAnonymousView.getContext(), AtvDetail.class);
          localIntent.putExtra("EXTRAS_ID", JSONUtil.getInteger(localJSONObject, "transferJoinID", 0));
          AtvMyRegist.this.startActivityForResult(localIntent, 7890);
        }
      };
      paramView.setOnClickListener(local23);
      return paramView;
      localTextView6.setText("/ 등록 " + l + "일전");
      break;
      label537:
      localTextView6.setTextColor(FormatUtil.getRegistDTColor(localCalendar1, this.mCalendarNow));
      break label199;
      label554:
      k = 0;
      break label238;
      label560:
      str = "진행중";
      break label248;
      label568:
      m = 2130837508;
      break label265;
      label576:
      localTextView1.setTextColor(-13421773);
      break label304;
      label587:
      localTextView4.setText("양도요청 : " + FormatUtil.toPriceFormat(j) + "명");
      break label347;
      label623:
      localTextView4.setTextColor(-13421773);
      break label364;
      label634:
      localTextView3.setTextColor(-13421773);
      break label402;
      localTextView5.setTextColor(-13421773);
      break label437;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      callApi_getListOfTransferJoin_My(true);
    }
  }
  
  protected void setView()
  {
    setView(2130903055);
    if (getIntent().getExtras() != null)
    {
      this.type = getIntent().getExtras().getInt("type");
      this.golf_fk = getIntent().getExtras().getString("golf_fk");
      this.dates = getIntent().getExtras().getString("dates");
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.atv.more.AtvMyRegist
 * JD-Core Version:    0.7.0.1
 */