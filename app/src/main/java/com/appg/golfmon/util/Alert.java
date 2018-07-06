package com.appg.golfmon.util;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.appg.golfmon.view.GListView;
import com.appg.golfmon.view.GListView.GListAdapter;
import com.appg.golfmon.view.GListView.IMakeView;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class Alert
{
  public static final int BUTTON1 = 1;
  public static final int BUTTON2 = 2;
  public static final int BUTTON3 = 3;
  public static final int CANCEL = -1;
  protected static Toast mToast;
  protected static int mToastTime;
  private String LOGO_IMG_URL = "http://115.68.14.78/upload_img/";
  private ImageDownLoader mImageDownLoader;
  protected OnCloseListener mListener = null;
  private HashMap<Integer, Boolean> mMapSelection = null;
  private int mSelection = -1;
  
  private JSONObject makeJson(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    JSONUtil.put(localJSONObject, "value", paramString1);
    JSONUtil.put(localJSONObject, "key", paramString2);
    return localJSONObject;
  }
  
  private static void toast(Context paramContext, String paramString, int paramInt)
  {
    if (mToast == null)
    {
      switch (paramInt)
      {
      }
      for (;;)
      {
        LogUtil.d("mToastTime : " + mToastTime);
        mToast = Toast.makeText(paramContext, paramString, mToastTime);
        mToast.show();
        return;
        mToastTime = 0;
        continue;
        mToastTime = 1;
      }
    }
    mToast.setText(paramString);
    mToast.show();
  }
  
  public static void toastLong(Context paramContext, int paramInt)
  {
    toast(paramContext, paramContext.getString(paramInt), 2);
  }
  
  public static void toastLong(Context paramContext, String paramString)
  {
    toast(paramContext, paramString, 2);
  }
  
  public static void toastShort(Context paramContext, int paramInt)
  {
    toast(paramContext, paramContext.getString(paramInt), 1);
  }
  
  public static void toastShort(Context paramContext, String paramString)
  {
    toast(paramContext, paramString, 1);
  }
  
  public void setOnCloseListener(OnCloseListener paramOnCloseListener)
  {
    this.mListener = paramOnCloseListener;
  }
  
  public Dialog showAlert(Context paramContext, String paramString)
  {
    return showAlert(paramContext, null, paramString, true, new String[] { "확인" });
  }
  
  public Dialog showAlert(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, String... paramVarArgs)
  {
    final Dialog localDialog = new Dialog(paramContext, 16973840);
    localDialog.setContentView(2130903040);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131361817);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131361819);
    Button localButton1 = (Button)localDialog.findViewById(2131361822);
    Button localButton2 = (Button)localDialog.findViewById(2131361824);
    View localView = localDialog.findViewById(2131361823);
    if (paramString1 == null)
    {
      localTextView1.setVisibility(8);
      if (paramString2 == null) {
        paramString2 = "";
      }
      localTextView2.setText(paramString2);
      localButton1.setVisibility(8);
      localButton2.setVisibility(8);
      localView.setVisibility(8);
      switch (paramVarArgs.length)
      {
      }
    }
    for (;;)
    {
      localDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          if (Alert.this.mListener != null) {
            Alert.this.mListener.onClose(paramAnonymousDialogInterface, -1, null);
          }
        }
      });
      localDialog.show();
      return localDialog;
      localTextView1.setVisibility(0);
      localTextView1.setText(paramString1);
      break;
      localButton1.setVisibility(0);
      localButton1.setText(paramVarArgs[1]);
      localButton1.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          localDialog.dismiss();
          if (Alert.this.mListener != null) {
            Alert.this.mListener.onClose(localDialog, 2, null);
          }
        }
      });
      localView.setVisibility(0);
      localButton2.setVisibility(0);
      localButton2.setText(paramVarArgs[0]);
      localButton2.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          localDialog.dismiss();
          if (Alert.this.mListener != null) {
            Alert.this.mListener.onClose(localDialog, 1, null);
          }
        }
      });
    }
  }
  
  public Dialog showAlert(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, String... paramVarArgs)
  {
    final Dialog localDialog = new Dialog(paramContext, 16973840);
    localDialog.setContentView(2130903040);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131361817);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131361819);
    Button localButton1 = (Button)localDialog.findViewById(2131361822);
    Button localButton2 = (Button)localDialog.findViewById(2131361824);
    View localView = localDialog.findViewById(2131361823);
    if (paramString1 == null)
    {
      localTextView1.setVisibility(8);
      if (paramString2 == null) {
        paramString2 = "";
      }
      localTextView2.setText(paramString2);
      localButton1.setVisibility(8);
      localButton2.setVisibility(8);
      localView.setVisibility(8);
      switch (paramVarArgs.length)
      {
      }
    }
    for (;;)
    {
      localDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          if (Alert.this.mListener != null) {
            Alert.this.mListener.onClose(paramAnonymousDialogInterface, -1, null);
          }
        }
      });
      localDialog.show();
      return localDialog;
      localTextView1.setVisibility(0);
      localTextView1.setText(paramString1);
      break;
      localButton1.setVisibility(0);
      localButton1.setText(paramVarArgs[1]);
      localButton1.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          localDialog.dismiss();
          if (Alert.this.mListener != null) {
            Alert.this.mListener.onClose(localDialog, 2, null);
          }
        }
      });
      localView.setVisibility(0);
      localButton2.setVisibility(0);
      localButton2.setText(paramVarArgs[0]);
      localButton2.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          localDialog.dismiss();
          if (Alert.this.mListener != null) {
            Alert.this.mListener.onClose(localDialog, 1, null);
          }
        }
      });
    }
  }
  
  public Dialog showAlert(Context paramContext, String paramString, boolean paramBoolean)
  {
    return showAlert(paramContext, null, paramString, paramBoolean, new String[] { "확인" });
  }
  
  public Dialog showAlert(Context paramContext, String paramString, boolean paramBoolean, String... paramVarArgs)
  {
    return showAlert(paramContext, null, paramString, paramBoolean, paramVarArgs);
  }
  
  public Dialog showAlertAgree(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, String... paramVarArgs)
  {
    final Dialog localDialog = new Dialog(paramContext, 16973840);
    localDialog.setContentView(2130903040);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131361817);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131361819);
    Button localButton1 = (Button)localDialog.findViewById(2131361822);
    Button localButton2 = (Button)localDialog.findViewById(2131361824);
    View localView1 = localDialog.findViewById(2131361823);
    View localView2 = localDialog.findViewById(2131361818);
    localTextView2.setGravity(51);
    if (paramString1 == null)
    {
      localTextView1.setVisibility(8);
      localView2.setVisibility(0);
      if (paramString2 == null) {
        paramString2 = "";
      }
      localTextView2.setText(paramString2);
      localButton1.setVisibility(8);
      localButton2.setVisibility(8);
      localView1.setVisibility(8);
      switch (paramVarArgs.length)
      {
      }
    }
    for (;;)
    {
      localDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          if (Alert.this.mListener != null) {
            Alert.this.mListener.onClose(paramAnonymousDialogInterface, -1, null);
          }
        }
      });
      localDialog.show();
      return localDialog;
      localTextView1.setVisibility(0);
      localTextView1.setText(paramString1);
      localView2.setVisibility(8);
      break;
      localButton1.setVisibility(0);
      localButton1.setText(paramVarArgs[1]);
      localButton1.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          localDialog.dismiss();
          if (Alert.this.mListener != null) {
            Alert.this.mListener.onClose(localDialog, 2, null);
          }
        }
      });
      localView1.setVisibility(0);
      localButton2.setVisibility(0);
      localButton2.setText(paramVarArgs[0]);
      localButton2.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          localDialog.dismiss();
          if (Alert.this.mListener != null) {
            Alert.this.mListener.onClose(localDialog, 1, null);
          }
        }
      });
    }
  }
  
  public Dialog showEditAlert(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, String... paramVarArgs)
  {
    final Dialog localDialog = new Dialog(paramContext, 16973840);
    localDialog.setContentView(2130903042);
    TextView localTextView = (TextView)localDialog.findViewById(2131361817);
    final EditText localEditText = (EditText)localDialog.findViewById(2131361819);
    Button localButton1 = (Button)localDialog.findViewById(2131361822);
    Button localButton2 = (Button)localDialog.findViewById(2131361824);
    View localView = localDialog.findViewById(2131361823);
    if (paramString1 == null)
    {
      localTextView.setVisibility(8);
      localButton1.setVisibility(8);
      localButton2.setVisibility(8);
      localView.setVisibility(8);
      switch (paramVarArgs.length)
      {
      }
    }
    for (;;)
    {
      localDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          if (Alert.this.mListener != null) {
            Alert.this.mListener.onClose(paramAnonymousDialogInterface, -1, null);
          }
        }
      });
      localDialog.show();
      return localDialog;
      localTextView.setVisibility(0);
      localTextView.setText(paramString1);
      break;
      localButton1.setVisibility(0);
      localButton1.setText(paramVarArgs[1]);
      localButton1.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          localDialog.dismiss();
          if (Alert.this.mListener != null) {
            Alert.this.mListener.onClose(localDialog, 2, null);
          }
        }
      });
      localView.setVisibility(0);
      localButton2.setVisibility(0);
      localButton2.setText(paramVarArgs[0]);
      localButton2.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          localDialog.dismiss();
          if (Alert.this.mListener != null) {
            Alert.this.mListener.onClose(localDialog, 1, localEditText.getText().toString());
          }
        }
      });
    }
  }
  
  public Dialog showEventAlert(final Context paramContext, String paramString1, final String paramString2, boolean paramBoolean)
  {
    this.mImageDownLoader = new ImageDownLoader(paramContext);
    this.mImageDownLoader.setMode(ImageDownLoader.Mode.CORRECT);
    final Dialog localDialog = new Dialog(paramContext, 16973840);
    localDialog.setCancelable(paramBoolean);
    localDialog.setContentView(2130903041);
    TextView localTextView = (TextView)localDialog.findViewById(2131361817);
    localTextView.setText("골프몬 이벤트");
    localTextView.setVisibility(0);
    Button localButton1 = (Button)localDialog.findViewById(2131361822);
    Button localButton2 = (Button)localDialog.findViewById(2131361824);
    View localView = localDialog.findViewById(2131361823);
    ImageView localImageView = (ImageView)localDialog.findViewById(2131361825);
    this.mImageDownLoader.download(localImageView, this.LOGO_IMG_URL + paramString1);
    localImageView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString2));
        paramContext.startActivity(localIntent);
        localDialog.dismiss();
      }
    });
    localView.setVisibility(8);
    localButton1.setVisibility(0);
    localButton1.setText("다시보지않기");
    localButton1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        localDialog.dismiss();
        if (Alert.this.mListener != null) {
          Alert.this.mListener.onClose(localDialog, 2, null);
        }
      }
    });
    localView.setVisibility(0);
    localButton2.setVisibility(0);
    localButton2.setText("닫기");
    localButton2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        localDialog.dismiss();
        if (Alert.this.mListener != null) {
          Alert.this.mListener.onClose(localDialog, 1, null);
        }
      }
    });
    localDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        if (Alert.this.mListener != null) {
          Alert.this.mListener.onClose(paramAnonymousDialogInterface, -1, null);
        }
      }
    });
    localDialog.show();
    return localDialog;
  }
  
  public Dialog showSelet(Context paramContext, String paramString1, int paramInt, JSONArray paramJSONArray, final String paramString2, boolean paramBoolean)
  {
    final Dialog localDialog = new Dialog(paramContext, 16973840);
    localDialog.setContentView(2130903045);
    localDialog.setCancelable(paramBoolean);
    localDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        if (Alert.this.mListener != null) {
          Alert.this.mListener.onClose(paramAnonymousDialogInterface, -1, null);
        }
      }
    });
    TextView localTextView = (TextView)localDialog.findViewById(2131361817);
    GListView localGListView = (GListView)localDialog.findViewById(2131361843);
    View localView1 = localDialog.findViewById(2131361845);
    View localView2 = localDialog.findViewById(2131361844);
    int i;
    if (paramString1 == null)
    {
      localTextView.setVisibility(8);
      localView1.setVisibility(8);
      localView2.setVisibility(8);
      this.mSelection = paramInt;
      localGListView.setHeaderDividersEnabled(true);
      localGListView.setViewMaker(2130903044, new GListView.IMakeView()
      {
        public View makeView(GListView.GListAdapter paramAnonymousGListAdapter, final int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
        {
          final JSONObject localJSONObject = (JSONObject)paramAnonymousGListAdapter.getItem(paramAnonymousInt);
          TextView localTextView = (TextView)paramAnonymousView.findViewById(2131361841);
          if (FormatUtil.isNullorEmpty(paramString2))
          {
            localTextView.setText(JSONUtil.getString(localJSONObject, "value", ""));
            if (Alert.this.mSelection != paramAnonymousInt) {
              break label102;
            }
            paramAnonymousView.setBackgroundResource(2130837758);
          }
          for (;;)
          {
            paramAnonymousView.setOnClickListener(new View.OnClickListener()
            {
              public void onClick(View paramAnonymous2View)
              {
                if (Alert.this.mListener != null) {
                  Alert.this.mListener.onClose(this.val$dialog, paramAnonymousInt, localJSONObject);
                }
              }
            });
            return paramAnonymousView;
            localTextView.setText(JSONUtil.getString(localJSONObject, paramString2, ""));
            break;
            label102:
            paramAnonymousView.setBackgroundResource(2130837710);
          }
        }
      });
      if (!FormatUtil.isNullorEmpty(paramString2)) {
        break label212;
      }
      i = 0;
      label152:
      if (i < paramJSONArray.length()) {
        break label185;
      }
    }
    for (;;)
    {
      localDialog.show();
      return localDialog;
      localTextView.setVisibility(0);
      localTextView.setText(paramString1);
      break;
      label185:
      localGListView.addItem(makeJson(JSONUtil.getString(paramJSONArray, i), String.valueOf(i)));
      i++;
      break label152;
      label212:
      localGListView.addItems(paramJSONArray);
    }
  }
  
  public Dialog showSelet(Context paramContext, String paramString1, int paramInt, String[] paramArrayOfString, String paramString2, boolean paramBoolean)
  {
    JSONArray localJSONArray = new JSONArray();
    for (int i = 0;; i++)
    {
      if (i >= paramArrayOfString.length) {
        return showSelet(paramContext, paramString1, paramInt, localJSONArray, paramString2, paramBoolean);
      }
      localJSONArray.put(makeJson(paramArrayOfString[i], String.valueOf(i)));
    }
  }
  
  @SuppressLint({"UseSparseArrays"})
  public Dialog showSeletMulti(Context paramContext, String paramString1, HashMap<Integer, Boolean> paramHashMap, final int paramInt, JSONArray paramJSONArray, final String paramString2, boolean paramBoolean)
  {
    final Dialog localDialog = new Dialog(paramContext, 16973840);
    localDialog.setContentView(2130903045);
    localDialog.setCancelable(paramBoolean);
    TextView localTextView = (TextView)localDialog.findViewById(2131361817);
    final GListView localGListView = (GListView)localDialog.findViewById(2131361843);
    Button localButton1 = (Button)localDialog.findViewById(2131361822);
    Button localButton2 = (Button)localDialog.findViewById(2131361824);
    if (paramString1 == null)
    {
      localTextView.setVisibility(8);
      localButton1.setVisibility(8);
      localButton2.setVisibility(8);
      if (paramHashMap == null) {
        break label226;
      }
    }
    label226:
    for (this.mMapSelection = paramHashMap;; this.mMapSelection = new HashMap())
    {
      localGListView.setHeaderDividersEnabled(true);
      localGListView.setViewMaker(2130903044, new GListView.IMakeView()
      {
        public View makeView(GListView.GListAdapter paramAnonymousGListAdapter, final int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
        {
          JSONObject localJSONObject = (JSONObject)paramAnonymousGListAdapter.getItem(paramAnonymousInt);
          TextView localTextView = (TextView)paramAnonymousView.findViewById(2131361841);
          ImageView localImageView = (ImageView)paramAnonymousView.findViewById(2131361842);
          localImageView.setVisibility(0);
          if (FormatUtil.isNullorEmpty(paramString2))
          {
            localTextView.setText(JSONUtil.getString(localJSONObject, "value", ""));
            if (!Alert.this.mMapSelection.containsKey(Integer.valueOf(paramAnonymousInt))) {
              break label157;
            }
            paramAnonymousView.setBackgroundResource(2130837758);
            label85:
            if (!Alert.this.mMapSelection.containsKey(Integer.valueOf(paramAnonymousInt))) {
              break label166;
            }
            paramAnonymousView.setBackgroundResource(2130837758);
            localImageView.setImageResource(2130837551);
          }
          for (;;)
          {
            paramAnonymousView.setOnClickListener(new View.OnClickListener()
            {
              public void onClick(View paramAnonymous2View)
              {
                if (Alert.this.mMapSelection.containsKey(Integer.valueOf(paramAnonymousInt))) {
                  Alert.this.mMapSelection.remove(Integer.valueOf(paramAnonymousInt));
                }
                for (;;)
                {
                  this.val$listAlert.refresh();
                  return;
                  if (Alert.this.mMapSelection.size() < this.val$maxSelect) {
                    Alert.this.mMapSelection.put(Integer.valueOf(paramAnonymousInt), Boolean.valueOf(true));
                  }
                }
              }
            });
            return paramAnonymousView;
            localTextView.setText(JSONUtil.getString(localJSONObject, paramString2, ""));
            break;
            label157:
            paramAnonymousView.setBackgroundResource(2130837710);
            break label85;
            label166:
            paramAnonymousView.setBackgroundResource(2130837710);
            localImageView.setImageResource(2130837729);
          }
        }
      });
      localGListView.addItems(paramJSONArray);
      localButton1.setVisibility(0);
      localButton1.setText("취소");
      localButton1.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (Alert.this.mListener != null) {
            Alert.this.mListener.onClose(localDialog, 2, null);
          }
        }
      });
      localButton2.setVisibility(0);
      localButton2.setText("선택");
      localButton2.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (Alert.this.mListener != null) {
            Alert.this.mListener.onClose(localDialog, 1, Alert.this.mMapSelection);
          }
        }
      });
      localDialog.show();
      return localDialog;
      localTextView.setVisibility(0);
      localTextView.setText(paramString1);
      break;
    }
  }
  
  public Dialog showSeletPhoto(Context paramContext, boolean paramBoolean)
  {
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(makeJson("촬영하기", "0"));
    localJSONArray.put(makeJson("사진선택", "1"));
    if (paramBoolean) {
      localJSONArray.put(makeJson("삭제", "2"));
    }
    return showSelet(paramContext, "선택", -1, localJSONArray, "value", true);
  }
  
  public static abstract interface OnCloseListener
  {
    public abstract void onClose(DialogInterface paramDialogInterface, int paramInt, Object paramObject);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.util.Alert
 * JD-Core Version:    0.7.0.1
 */