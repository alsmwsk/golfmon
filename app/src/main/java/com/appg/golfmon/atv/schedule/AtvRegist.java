package com.appg.golfmon.atv.schedule;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TimePicker;
import com.appg.golfmon.atv.AtvBase;
import com.appg.golfmon.atv.more.AtvMyRegist;
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
import com.appg.golfmon.view.GSpinner;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.json.JSONArray;
import org.json.JSONObject;
import ra.genius.net.GBean;
import ra.genius.net.GExecutor;

public class AtvRegist
  extends AtvBase
{
  public static final int REQ_CODE = 7894;
  private final String APPID = "naver.com.cafesample";
  private final String CAFE_URL = "golfdcclub";
  private TableRow mBaseHole = null;
  private TableRow mBasePeople1 = null;
  private TableRow mBasePeople2 = null;
  private Button mBtn18H = null;
  private Button mBtn27H = null;
  private Button mBtn36H = null;
  private Button mBtnCouple = null;
  private Button mBtnDate = null;
  private Button mBtnMan = null;
  private Button mBtnNaverSubmit = null;
  private Button mBtnNone = null;
  private Button mBtnSubmit = null;
  private Button mBtnTime = null;
  private Button mBtnWoman = null;
  private Calendar mCalendar = null;
  private Calendar mCalendarNow = null;
  private EditText mEdtDescription = null;
  private EditText mEdtFee = null;
  private EditText mEdtPeople = null;
  private boolean mIsNext = false;
  private GSpinner mSpinnerGolf = null;
  private GSpinner mSpinnerLocation = null;
  private JSONObject mTransferJoinInfo = null;
  private TextView mTxtGolf = null;
  private TextView mTxtID = null;
  private TextView mTxtLocation = null;
  private TextView mTxtNickName = null;
  private int mType = 0;
  
  private void callApi_getListOfGolfForLocation(String paramString)
  {
    GPClient localGPClient = new GPClient(this);
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.setDecoder(new GJSONDecoder(2));
    localGPClient.addParameter("cmd", "Api.getListOfGolfForLocation");
    localGPClient.addParameter("loc_no", paramString);
    if (this.mType == 100) {
      localGPClient.addParameter("transferJoinTypeID", Integer.valueOf(1));
    }
    for (;;)
    {
      localGPClient.addProgress();
      localGPClient.addHandler(new GFailedHandler()
      {
        public void failedExecute(GBean paramAnonymousGBean)
        {
          Alert.toastLong(AtvRegist.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
        }
      });
      localGPClient.addHandler(new GResultHandler()
      {
        public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          if (paramAnonymousInt > 0)
          {
            JSONArray localJSONArray = (JSONArray)paramAnonymousObject;
            AtvRegist.this.mSpinnerGolf.setKey("name");
            AtvRegist.this.mSpinnerGolf.addItems(localJSONArray);
          }
          for (;;)
          {
            return null;
            AtvRegist.this.mSpinnerGolf.setKey("name");
            AtvRegist.this.mSpinnerGolf.addItems(new JSONArray());
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
        Alert.toastLong(AtvRegist.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        if (paramAnonymousInt > 0)
        {
          JSONArray localJSONArray = (JSONArray)paramAnonymousObject;
          AtvRegist.this.mSpinnerLocation.setKey("loc_name");
          AtvRegist.this.mSpinnerLocation.addItems(localJSONArray);
          AtvRegist.this.mSpinnerLocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
          {
            public void onItemSelected(AdapterView<?> paramAnonymous2AdapterView, View paramAnonymous2View, int paramAnonymous2Int, long paramAnonymous2Long)
            {
              JSONObject localJSONObject = AtvRegist.this.mSpinnerLocation.getSelectedItem();
              LogUtil.json(localJSONObject);
              AtvRegist.this.callApi_getListOfGolfForLocation(JSONUtil.getString(localJSONObject, "no", ""));
            }
            
            public void onNothingSelected(AdapterView<?> paramAnonymous2AdapterView) {}
          });
        }
        for (;;)
        {
          return null;
          AtvRegist.this.mSpinnerLocation.addItems(new JSONArray());
        }
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  private void callApi_insOf_transfer_join()
  {
    GPClient localGPClient = new GPClient(getContext());
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("ApiTransferJoin.insOf_transfer_join");
    if (!FormatUtil.isNullorEmpty(this.mTransferJoinInfo))
    {
      localGPClient.addParameter("transferJoinID", JSONUtil.getString(this.mTransferJoinInfo, "transferJoinID", ""));
      localGPClient.addParameter("location_fk", JSONUtil.getString(this.mTransferJoinInfo, "location_fk", ""));
      localGPClient.addParameter("golf_fk", JSONUtil.getString(this.mTransferJoinInfo, "golf_fk", ""));
      localGPClient.addParameter("dates", this.mBtnDate.getText().toString() + " " + this.mBtnTime.getText().toString());
    }
    try
    {
      float f = Float.parseFloat(this.mEdtFee.getText().toString());
      i = (int)(f * 10000.0F);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 0;
      }
    }
    localGPClient.addParameter("greenFee", Integer.valueOf(i));
    if (this.mType == 100)
    {
      localGPClient.addParameter("transferJoinTypeID", Integer.valueOf(1));
      label213:
      if (!this.mBtn18H.isSelected()) {
        break label493;
      }
      localGPClient.addParameter("hole", "0");
    }
    for (;;)
    {
      localGPClient.addParameter("contents", this.mEdtDescription.getText().toString());
      localGPClient.setDecoder(new GJSONDecoder(3));
      localGPClient.addProgress();
      localGPClient.addHandler(new GFailedHandler()
      {
        public void failedExecute(GBean paramAnonymousGBean)
        {
          Alert.toastLong(AtvRegist.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
        }
      });
      localGPClient.addHandler(new GResultHandler()
      {
        public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, final int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          Alert localAlert = new Alert();
          localAlert.setOnCloseListener(new Alert.OnCloseListener()
          {
            public void onClose(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int, Object paramAnonymous2Object)
            {
              if (paramAnonymousInt == -20) {
                if (1 != paramAnonymous2Int)
                {
                  localIntent2 = new Intent(AtvRegist.this.getContext(), AtvMyRegist.class);
                  localIntent2.putExtra("type", AtvRegist.this.mType);
                  if (FormatUtil.isNullorEmpty(AtvRegist.this.mTransferJoinInfo)) {
                    break label133;
                  }
                  localIntent2.putExtra("golf_fk", JSONUtil.getString(AtvRegist.this.mTransferJoinInfo, "golf_fk", ""));
                  localIntent2.putExtra("dates", AtvRegist.this.mBtnDate.getText().toString());
                  AtvRegist.this.startActivity(localIntent2);
                }
              }
              label133:
              while (paramAnonymousInt <= 0) {
                for (;;)
                {
                  Intent localIntent2;
                  return;
                  localIntent2.putExtra("golf_fk", JSONUtil.getString(AtvRegist.this.mSpinnerGolf.getSelectedItem(), "no", ""));
                }
              }
              if (!FormatUtil.isNullorEmpty(AtvRegist.this.mTransferJoinInfo))
              {
                AtvRegist.this.setResult(-1);
                AtvRegist.this.finish();
                return;
              }
              Intent localIntent1 = new Intent(AtvRegist.this.getContext(), AtvDetail.class);
              localIntent1.putExtra("EXTRAS_ID", paramAnonymousInt);
              AtvRegist.this.startActivityForResult(localIntent1, 7890);
            }
          });
          if (paramAnonymousInt == -20) {
            localAlert.showAlert(AtvRegist.this.getContext(), paramAnonymousString, false, new String[] { "닫기", "등록내용보기" });
          }
          for (;;)
          {
            return null;
            localAlert.showAlert(AtvRegist.this.getContext(), paramAnonymousString);
          }
        }
      });
      GExecutor.getInstance().execute(localGPClient);
      return;
      localGPClient.addParameter("location_fk", JSONUtil.getString(this.mSpinnerLocation.getSelectedItem(), "no", ""));
      localGPClient.addParameter("golf_fk", JSONUtil.getString(this.mSpinnerGolf.getSelectedItem(), "no", ""));
      break;
      if (this.mType != 200) {
        break label213;
      }
      localGPClient.addParameter("transferJoinTypeID", Integer.valueOf(2));
      localGPClient.addParameter("counts", this.mEdtPeople.getText().toString());
      if (this.mBtnNone.isSelected())
      {
        localGPClient.addParameter("joinTypeStr", "1");
        break label213;
      }
      if (this.mBtnCouple.isSelected())
      {
        localGPClient.addParameter("joinTypeStr", "2");
        break label213;
      }
      if (this.mBtnMan.isSelected())
      {
        localGPClient.addParameter("joinTypeStr", "3");
        break label213;
      }
      if (!this.mBtnWoman.isSelected()) {
        break label213;
      }
      localGPClient.addParameter("joinTypeStr", "4");
      break label213;
      label493:
      if (this.mBtn27H.isSelected()) {
        localGPClient.addParameter("hole", "1");
      } else if (this.mBtn36H.isSelected()) {
        localGPClient.addParameter("hole", "2");
      }
    }
  }
  
  private String getCafeID(int paramInt)
  {
    String str1;
    if (this.mType == 100)
    {
      if (paramInt < 16) {
        break label35;
      }
      str1 = "108";
    }
    label35:
    String str2;
    do
    {
      return str1;
      if (this.mBtnCouple.isSelected()) {
        return "75";
      }
      if (getIsEmer())
      {
        if (this.mType == 200) {
          return "27";
        }
        return "68";
      }
      str1 = "58";
      String[] arrayOfString = { "98", "99", "85", "100", "101", "131", "102" };
      str2 = JSONUtil.getString(this.mSpinnerLocation.getSelectedItem(), "loc_name", "");
      if (this.mType == 200)
      {
        arrayOfString[0] = "91";
        arrayOfString[1] = "92";
        arrayOfString[2] = "93";
        arrayOfString[3] = "94";
        arrayOfString[4] = "128";
        arrayOfString[5] = "114";
        arrayOfString[6] = "95";
      }
      if (str2.equals("강원")) {
        return arrayOfString[0];
      }
      if (str2.equals("경기북부")) {
        return arrayOfString[1];
      }
      if (str2.equals("경기남부")) {
        return arrayOfString[2];
      }
      if (str2.equals("충청")) {
        return arrayOfString[3];
      }
      if (str2.equals("호남")) {
        return arrayOfString[4];
      }
      if (str2.equals("영남")) {
        return arrayOfString[5];
      }
    } while (!str2.equals("제주"));
    return str2;
  }
  
  private boolean getIsEmer()
  {
    String str1 = this.mBtnDate.getText().toString();
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    int i = localGregorianCalendar.get(1);
    int j = 1 + localGregorianCalendar.get(2);
    int k = localGregorianCalendar.get(5);
    Object[] arrayOfObject1 = new Object[3];
    arrayOfObject1[0] = Integer.valueOf(i);
    arrayOfObject1[1] = Integer.valueOf(j);
    arrayOfObject1[2] = Integer.valueOf(k);
    if (String.format("%d-%02d-%02d", arrayOfObject1).equals(str1)) {
      return true;
    }
    int m = localGregorianCalendar.getActualMaximum(5);
    Object[] arrayOfObject2 = new Object[3];
    arrayOfObject2[0] = Integer.valueOf(i);
    arrayOfObject2[1] = Integer.valueOf(j);
    arrayOfObject2[2] = Integer.valueOf(k + 1);
    String str2 = String.format("%d-%02d-%02d", arrayOfObject2);
    Object[] arrayOfObject4;
    if (k == m)
    {
      if (j != 12) {
        break label194;
      }
      arrayOfObject4 = new Object[1];
      arrayOfObject4[0] = Integer.valueOf(i + 1);
    }
    label194:
    Object[] arrayOfObject3;
    for (str2 = String.format("%d-01-01", arrayOfObject4); str1.equals(str2); str2 = String.format("%d-%02d-01", arrayOfObject3))
    {
      return true;
      arrayOfObject3 = new Object[2];
      arrayOfObject3[0] = Integer.valueOf(i);
      arrayOfObject3[1] = Integer.valueOf(j + 1);
    }
    return false;
  }
  
  private void setData()
  {
    int i = 1;
    this.mCalendar = FormatUtil.getDateStringToCalendar(JSONUtil.getString(this.mTransferJoinInfo, "dates", ""), "yyyy-MM-dd HH:mm:ss");
    this.mTxtLocation.setText(JSONUtil.getString(this.mTransferJoinInfo, "loc_name", ""));
    this.mTxtGolf.setText(JSONUtil.getString(this.mTransferJoinInfo, "name", ""));
    this.mBtnTime.setText(FormatUtil.getDateCalendarToString(this.mCalendar, "HH:mm"));
    this.mBtnDate.setText(FormatUtil.getDateCalendarToString(this.mCalendar, "yyyy-MM-dd"));
    int j = JSONUtil.getInteger(this.mTransferJoinInfo, "joinTypeStr", -1);
    int k = JSONUtil.getInteger(this.mTransferJoinInfo, "hole", 0);
    float f = JSONUtil.getInteger(this.mTransferJoinInfo, "greenFee", 0) / 10000.0F;
    label192:
    label213:
    label234:
    label255:
    Button localButton7;
    if (f == 0.0F)
    {
      this.mEdtFee.setText(String.valueOf(0));
      this.mEdtDescription.setText(JSONUtil.getString(this.mTransferJoinInfo, "contents", ""));
      Button localButton1 = this.mBtn18H;
      if (k != 0) {
        break label437;
      }
      int m = i;
      localButton1.setSelected(m);
      Button localButton2 = this.mBtn27H;
      if (k != i) {
        break label443;
      }
      int i1 = i;
      localButton2.setSelected(i1);
      Button localButton3 = this.mBtn36H;
      if (k != 2) {
        break label449;
      }
      int i3 = i;
      localButton3.setSelected(i3);
      Button localButton4 = this.mBtnNone;
      if (j != i) {
        break label455;
      }
      int i5 = i;
      localButton4.setSelected(i5);
      Button localButton5 = this.mBtnCouple;
      if (j != 2) {
        break label461;
      }
      int i7 = i;
      label276:
      localButton5.setSelected(i7);
      Button localButton6 = this.mBtnMan;
      if (j != 3) {
        break label467;
      }
      int i9 = i;
      label297:
      localButton6.setSelected(i9);
      localButton7 = this.mBtnWoman;
      if (j != 4) {
        break label473;
      }
    }
    for (;;)
    {
      localButton7.setSelected(i);
      this.mEdtPeople.setText(JSONUtil.getString(this.mTransferJoinInfo, "counts", ""));
      return;
      if (JSONUtil.getInteger(this.mTransferJoinInfo, "greenFee", 0) % 10000.0F == 0.0F)
      {
        EditText localEditText2 = this.mEdtFee;
        Object[] arrayOfObject2 = new Object[i];
        arrayOfObject2[0] = Float.valueOf(f);
        localEditText2.setText(String.format("%.0f", arrayOfObject2));
        break;
      }
      EditText localEditText1 = this.mEdtFee;
      Object[] arrayOfObject1 = new Object[i];
      arrayOfObject1[0] = Float.valueOf(f);
      localEditText1.setText(String.format("%.1f", arrayOfObject1));
      break;
      label437:
      int n = 0;
      break label192;
      label443:
      int i2 = 0;
      break label213;
      label449:
      int i4 = 0;
      break label234;
      label455:
      int i6 = 0;
      break label255;
      label461:
      int i8 = 0;
      break label276;
      label467:
      int i10 = 0;
      break label297;
      label473:
      i = 0;
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
  
  private void showPickerDate()
  {
    DatePickerDialog localDatePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener()
    {
      public void onDateSet(DatePicker paramAnonymousDatePicker, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (Build.VERSION.SDK_INT < 11)
        {
          AtvRegist.this.mIsNext = false;
          Calendar localCalendar = (Calendar)AtvRegist.this.mCalendarNow.clone();
          localCalendar.set(11, 0);
          localCalendar.set(12, 0);
          localCalendar.set(13, 0);
          localCalendar.set(14, 0);
          if (localCalendar.get(1) > paramAnonymousInt1)
          {
            new Alert().showAlert(AtvRegist.this.getContext(), "날짜를 다시 선택해 주세요.");
            return;
          }
          if (localCalendar.get(2) > paramAnonymousInt2)
          {
            new Alert().showAlert(AtvRegist.this.getContext(), "날짜를 다시 선택해 주세요.");
            return;
          }
          if (localCalendar.get(5) > paramAnonymousInt3)
          {
            new Alert().showAlert(AtvRegist.this.getContext(), "날짜를 다시 선택해 주세요.");
            return;
          }
        }
        AtvRegist.this.mIsNext = true;
        AtvRegist.this.mCalendar.set(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AtvRegist.this.mBtnDate.setText(FormatUtil.getDateCalendarToString(AtvRegist.this.mCalendar, "yyyy-MM-dd"));
      }
    }, this.mCalendar.get(1), this.mCalendar.get(2), this.mCalendar.get(5));
    localDatePickerDialog.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        LogUtil.e("datePickerDialog.setOnDismissListener");
        if (AtvRegist.this.mIsNext) {
          AtvRegist.this.showPickerTime();
        }
      }
    });
    if (Build.VERSION.SDK_INT >= 11) {
      setMindate(localDatePickerDialog);
    }
    localDatePickerDialog.show();
  }
  
  private void showPickerTime()
  {
    new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener()
    {
      public void onTimeSet(TimePicker paramAnonymousTimePicker, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AtvRegist.this.mCalendar.set(11, paramAnonymousInt1);
        AtvRegist.this.mCalendar.set(12, paramAnonymousInt2);
        AtvRegist.this.mBtnTime.setText(FormatUtil.getDateCalendarToString(AtvRegist.this.mCalendar, "HH:mm"));
      }
    }, this.mCalendar.get(11), this.mCalendar.get(12), true).show();
  }
  
  private boolean validateBasic()
  {
    if (FormatUtil.isNullorEmpty(this.mBtnDate.getText().toString()))
    {
      new Alert().showAlert(getContext(), "날짜를 선택해 주세요");
      return false;
    }
    if (FormatUtil.isNullorEmpty(this.mBtnTime.getText().toString()))
    {
      new Alert().showAlert(getContext(), "티업시간을 선택해 주세요");
      return false;
    }
    if (FormatUtil.isNullorEmpty(this.mEdtFee.getText().toString()))
    {
      new Alert().showAlert(getContext(), "그린피를 입력해 주세요.");
      return false;
    }
    try
    {
      float f2 = Float.parseFloat(this.mEdtFee.getText().toString());
      f1 = f2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        float f1 = 0.0F;
      }
    }
    if ((f1 < 1.0D) || (f1 >= 1000.0D))
    {
      new Alert().showAlert(getContext(), "그린피를 정확히 입력해 주세요.(단위:만원)");
      return false;
    }
    if ((this.mType == 100) && (FormatUtil.isNullorEmpty(this.mEdtDescription.getText().toString())))
    {
      new Alert().showAlert(getContext(), "내용을 입력해 주세요");
      return false;
    }
    return true;
  }
  
  private boolean validateJoin()
  {
    if (FormatUtil.isNullorEmpty(this.mEdtPeople.getText().toString()))
    {
      new Alert().showAlert(getContext(), "요청인원을 입력 주세요");
      return false;
    }
    try
    {
      int j = Integer.parseInt(this.mEdtPeople.getText().toString());
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 0;
      }
    }
    if (i <= 0)
    {
      new Alert().showAlert(getContext(), "요청인원을 정확히 입력해 주세요.");
      return false;
    }
    this.mEdtPeople.setText(String.valueOf(i));
    if ((!this.mBtnNone.isSelected()) && (!this.mBtnCouple.isSelected()) && (!this.mBtnMan.isSelected()) && (!this.mBtnWoman.isSelected()))
    {
      new Alert().showAlert(getContext(), "요청인원을 선택해 주세요.");
      return false;
    }
    if (FormatUtil.isNullorEmpty(this.mEdtDescription.getText().toString()))
    {
      new Alert().showAlert(getContext(), "내용을 입력해 주세요");
      return false;
    }
    return true;
  }
  
  private boolean validateRegist()
  {
    if (this.mSpinnerLocation.getSelectedItem() == null)
    {
      new Alert().showAlert(getContext(), "지역을 선택해 주세요");
      return false;
    }
    if (this.mSpinnerGolf.getSelectedItem() == null)
    {
      new Alert().showAlert(getContext(), "골프장을 선택해 주세요");
      return false;
    }
    return true;
  }
  
  protected void configureListener()
  {
    this.mBtnDate.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvRegist.this.showPickerDate();
      }
    });
    this.mBtnTime.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvRegist.this.showPickerTime();
      }
    });
    this.mBtn18H.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvRegist.this.mBtn18H.setSelected(true);
        AtvRegist.this.mBtn27H.setSelected(false);
        AtvRegist.this.mBtn36H.setSelected(false);
      }
    });
    this.mBtn27H.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvRegist.this.mBtn27H.setSelected(true);
        AtvRegist.this.mBtn18H.setSelected(false);
        AtvRegist.this.mBtn36H.setSelected(false);
      }
    });
    this.mBtn36H.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvRegist.this.mBtn36H.setSelected(true);
        AtvRegist.this.mBtn27H.setSelected(false);
        AtvRegist.this.mBtn18H.setSelected(false);
      }
    });
    this.mBtnNone.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvRegist.this.mBtnNone.setSelected(true);
        AtvRegist.this.mBtnCouple.setSelected(false);
        AtvRegist.this.mBtnMan.setSelected(false);
        AtvRegist.this.mBtnWoman.setSelected(false);
      }
    });
    this.mBtnCouple.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvRegist.this.mBtnNone.setSelected(false);
        AtvRegist.this.mBtnCouple.setSelected(true);
        AtvRegist.this.mBtnMan.setSelected(false);
        AtvRegist.this.mBtnWoman.setSelected(false);
      }
    });
    this.mBtnMan.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvRegist.this.mBtnNone.setSelected(false);
        AtvRegist.this.mBtnCouple.setSelected(false);
        AtvRegist.this.mBtnMan.setSelected(true);
        AtvRegist.this.mBtnWoman.setSelected(false);
      }
    });
    this.mBtnWoman.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AtvRegist.this.mBtnNone.setSelected(false);
        AtvRegist.this.mBtnCouple.setSelected(false);
        AtvRegist.this.mBtnMan.setSelected(false);
        AtvRegist.this.mBtnWoman.setSelected(true);
      }
    });
    this.mBtnSubmit.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if ((FormatUtil.isNullorEmpty(AtvRegist.this.mTransferJoinInfo)) && (!AtvRegist.this.validateRegist())) {}
        while ((!AtvRegist.this.validateBasic()) || ((AtvRegist.this.mType == 200) && (!AtvRegist.this.validateJoin()))) {
          return;
        }
        AtvRegist.this.callApi_insOf_transfer_join();
      }
    });
    this.mBtnNaverSubmit.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (!AtvRegist.this.validateBasic()) {
          return;
        }
        String str1 = SPUtil.getInstance().getCafeHeader(AtvRegist.this.getContext());
        JSONObject localJSONObject = AtvRegist.this.mSpinnerGolf.getSelectedItem();
        String str2 = FormatUtil.getDateDayOfWeek(AtvRegist.this.mCalendar, false);
        String str3 = AtvRegist.this.mBtnDate.getText().toString().replace("-0", "/").replace("-", "/");
        String str4 = str3.substring(5, str3.length());
        int i = Integer.parseInt(AtvRegist.this.mBtnTime.getText().toString().substring(0, 2));
        String str5;
        String str6;
        String str7;
        label260:
        String str8;
        if (AtvRegist.this.mType == 100) {
          if (i >= 16)
          {
            str5 = "[야간양도] ";
            str6 = str5 + str4 + "(" + str2 + ") " + JSONUtil.getString(localJSONObject, "name", "") + " " + AtvRegist.this.mBtnTime.getText().toString();
            if (AtvRegist.this.mType != 200) {
              break label836;
            }
            if (!AtvRegist.this.mBtnCouple.isSelected()) {
              break label667;
            }
            str7 = str6 + " 부부나 커플초대";
            str8 = "18홀";
            if (!AtvRegist.this.mBtn27H.isSelected()) {
              break label884;
            }
            str8 = "27홀";
            label281:
            str9 = new StringBuilder(String.valueOf(str1)).append("골프장 : ").append(JSONUtil.getString(localJSONObject, "name", "")).append("\n").toString() + "티업 일시 : " + str4 + "(" + str2 + ") " + AtvRegist.this.mBtnTime.getText().toString() + " (" + str8 + ")" + "\n";
            if (AtvRegist.this.mType == 200) {
              if (!AtvRegist.this.mBtnCouple.isSelected()) {
                break label904;
              }
            }
          }
        }
        String str10;
        label904:
        for (String str9 = str9 + "성별 : 부부/커플\n";; str9 = str9 + "요청인원 : " + AtvRegist.this.mEdtPeople.getText().toString() + "명 (성별무관)" + "\n")
        {
          str10 = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(str9)).append("그린피 : ").append(AtvRegist.this.mEdtFee.getText().toString()).append("만원").append("\n").toString())).append("전화번호 : ").append(AtvRegist.this.mTxtID.getText().toString()).append("\n\n").toString() + AtvRegist.this.mEdtDescription.getText().toString();
          if (!AtvRegist.this.getCafeID(i).equals("제주")) {
            break label959;
          }
          new Alert().showAlert(AtvRegist.this.getContext(), "제주 게시판이 존재하지않습니다.", true, new String[] { "확인" });
          return;
          if ((str2.equals("토")) || (str2.equals("일")))
          {
            str5 = "[주말] ";
            break;
          }
          str5 = "[주중] ";
          break;
          if (i >= 16)
          {
            str5 = "[야간조인] ";
            break;
          }
          str5 = "[조인] ";
          break;
          label667:
          String str11 = AtvRegist.this.mEdtPeople.getText().toString();
          String str12;
          if (str11.equals("1")) {
            str12 = str6 + " 한분";
          }
          for (;;)
          {
            str7 = str12 + " 초대합니다.";
            break;
            if (str11.equals("2")) {
              str12 = str6 + " 두분";
            } else if (str11.equals("3")) {
              str12 = str6 + " 세분";
            } else {
              str12 = str6 + str11;
            }
          }
          label836:
          str7 = str6 + " " + AtvRegist.this.mEdtFee.getText().toString() + "만원 할인양도";
          break label260;
          label884:
          if (!AtvRegist.this.mBtn36H.isSelected()) {
            break label281;
          }
          str8 = "36홀";
          break label281;
        }
        label959:
        new NaverCafe(AtvRegist.this, "naver.com.cafesample").write("golfdcclub", AtvRegist.this.getCafeID(i), str7, str10);
      }
    });
  }
  
  protected void findView()
  {
    this.mTxtNickName = ((TextView)findViewById(2131361945));
    this.mTxtID = ((TextView)findViewById(2131361946));
    this.mSpinnerLocation = ((GSpinner)findViewById(2131361900));
    this.mTxtLocation = ((TextView)findViewById(2131361947));
    this.mSpinnerGolf = ((GSpinner)findViewById(2131361949));
    this.mTxtGolf = ((TextView)findViewById(2131361948));
    this.mBtnDate = ((Button)findViewById(2131361902));
    this.mBtnTime = ((Button)findViewById(2131361950));
    this.mEdtFee = ((EditText)findViewById(2131361951));
    this.mBasePeople1 = ((TableRow)findViewById(2131361956));
    this.mEdtPeople = ((EditText)findViewById(2131361957));
    this.mBasePeople2 = ((TableRow)findViewById(2131361958));
    this.mBtnNone = ((Button)findViewById(2131361959));
    this.mBtnCouple = ((Button)findViewById(2131361960));
    this.mBtnMan = ((Button)findViewById(2131361961));
    this.mBtnWoman = ((Button)findViewById(2131361962));
    this.mEdtDescription = ((EditText)findViewById(2131361963));
    this.mBtnSubmit = ((Button)findViewById(2131361964));
    this.mBtnNaverSubmit = ((Button)findViewById(2131361965));
    if ((SPUtil.getInstance().getUserType(getContext()).equals("3")) || (SPUtil.getInstance().getUserType(getContext()).equals("2"))) {
      this.mBtnNaverSubmit.setVisibility(0);
    }
    for (;;)
    {
      this.mBaseHole = ((TableRow)findViewById(2131361952));
      this.mBtn18H = ((Button)findViewById(2131361953));
      this.mBtn27H = ((Button)findViewById(2131361954));
      this.mBtn36H = ((Button)findViewById(2131361955));
      return;
      this.mBtnNaverSubmit.setVisibility(8);
    }
  }
  
  protected boolean getBundle()
  {
    LogUtil.intent(getIntent());
    this.mTransferJoinInfo = JSONUtil.createObject(getIntent(), "EXTRAS_JSON_STRING");
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
    this.mCalendar = Calendar.getInstance();
    this.mCalendar.set(11, 9);
    this.mCalendar.set(12, 0);
    this.mCalendar.set(13, 0);
    this.mCalendar.set(14, 0);
    this.mCalendarNow = ((Calendar)this.mCalendar.clone());
    JSONObject localJSONObject = SPUtil.getInstance().getUserInfo(this);
    LogUtil.json(localJSONObject);
    this.mTxtID.setText(FormatUtil.toPhoneNumber(JSONUtil.getString(localJSONObject, "phone", "")));
    this.mTxtNickName.setText(JSONUtil.getString(localJSONObject, "nick_name", "") + "(" + JSONUtil.getString(localJSONObject, "name", "") + ")");
    this.mSpinnerLocation.addItems(new JSONArray());
    if (!FormatUtil.isNullorEmpty(this.mTransferJoinInfo))
    {
      if (this.mType == 200)
      {
        this.mTxtTopTitleLeft.setText("조인 수정");
        this.mBasePeople1.setVisibility(0);
        this.mBasePeople2.setVisibility(0);
        this.mBtnNone.setSelected(true);
      }
      for (;;)
      {
        this.mBtn18H.setSelected(true);
        this.mTxtLocation.setVisibility(0);
        this.mTxtGolf.setVisibility(0);
        this.mSpinnerLocation.setVisibility(8);
        this.mSpinnerGolf.setVisibility(8);
        this.mBtnSubmit.setText("수정하기");
        this.mBtnNaverSubmit.setVisibility(8);
        setData();
        return;
        this.mTxtTopTitleLeft.setText("양도 수정");
      }
    }
    if (this.mType == 200)
    {
      this.mTxtTopTitleLeft.setText("조인 등록");
      this.mBasePeople1.setVisibility(0);
      this.mBasePeople2.setVisibility(0);
      this.mBtnNone.setSelected(true);
    }
    for (;;)
    {
      this.mBtn18H.setSelected(true);
      this.mBtnSubmit.setText("등록하기");
      this.mBtnNaverSubmit.setText("네이버카페에 등록하기");
      this.mTxtLocation.setVisibility(8);
      this.mTxtGolf.setVisibility(8);
      this.mSpinnerLocation.setVisibility(0);
      this.mSpinnerGolf.setVisibility(0);
      callApi_getListOfLocation();
      return;
      this.mTxtTopTitleLeft.setText("양도 등록");
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    setResult(-1);
    finish();
  }
  
  protected void setView()
  {
    setView(2130903061);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.atv.schedule.AtvRegist
 * JD-Core Version:    0.7.0.1
 */