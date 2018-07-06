package com.appg.golfmon.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import com.appg.golfmon.R.styleable;
import com.appg.golfmon.util.ImageUtil;
import com.appg.golfmon.util.JSONUtil;
import com.appg.golfmon.util.LogUtil;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class GSpinner
  extends Spinner
{
  private String hint = null;
  private String key = "key";
  private GSpinnerAdapter mAdapter = null;
  private ArrayList<JSONObject> mDataArray = new ArrayList();
  private ColorStateList textColor = null;
  private ColorStateList textColorHint = null;
  private int textSize = 15;
  
  public GSpinner(Context paramContext)
  {
    super(paramContext);
  }
  
  @SuppressLint({"NewApi"})
  public GSpinner(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public GSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initTypeFace(paramContext, paramAttributeSet);
  }
  
  public GSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initTypeFace(paramContext, paramAttributeSet);
  }
  
  @SuppressLint({"NewApi"})
  public GSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    initTypeFace(paramContext, paramAttributeSet);
  }
  
  private void addItem(JSONObject paramJSONObject)
  {
    this.mDataArray.add(paramJSONObject);
    this.mAdapter.add(JSONUtil.getString(paramJSONObject, this.key, ""));
  }
  
  private void initTypeFace(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.GSpinner);
    this.textSize = localTypedArray.getInt(0, this.textSize);
    this.textColor = localTypedArray.getColorStateList(1);
    this.textColorHint = localTypedArray.getColorStateList(2);
    this.hint = localTypedArray.getString(3);
    localTypedArray.recycle();
    LogUtil.e("this.textSize=" + this.textSize);
    LogUtil.e("this.hint=" + this.hint);
  }
  
  public void addItems(JSONArray paramJSONArray)
  {
    this.mDataArray.clear();
    if (this.mAdapter != null) {
      this.mAdapter.clear();
    }
    this.mAdapter = new GSpinnerAdapter(getContext());
    for (int i = 0;; i++)
    {
      if ((paramJSONArray == null) || (i >= paramJSONArray.length()))
      {
        if (this.hint != null) {
          this.mAdapter.add(this.hint);
        }
        setAdapter(null);
        setAdapter(this.mAdapter);
        if (this.hint != null) {
          setSelection(this.mAdapter.getCount());
        }
        return;
      }
      addItem(JSONUtil.getJSONObject(paramJSONArray, i));
    }
  }
  
  public void addItems(String[] paramArrayOfString)
  {
    this.mDataArray.clear();
    if (this.mAdapter != null) {
      this.mAdapter.clear();
    }
    this.mAdapter = new GSpinnerAdapter(getContext());
    for (int i = 0;; i++)
    {
      if ((paramArrayOfString == null) || (i >= paramArrayOfString.length))
      {
        if (this.hint != null) {
          this.mAdapter.add(this.hint);
        }
        setAdapter(this.mAdapter);
        if (this.hint != null) {
          setSelection(this.mAdapter.getCount());
        }
        return;
      }
      JSONObject localJSONObject = new JSONObject();
      JSONUtil.put(localJSONObject, this.key, paramArrayOfString[i]);
      JSONUtil.put(localJSONObject, "value", String.valueOf(i));
      addItem(localJSONObject);
    }
  }
  
  public JSONObject getItem(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = (JSONObject)this.mDataArray.get(paramInt);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      LogUtil.w(localException);
    }
    return null;
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  public JSONObject getSelectedItem()
  {
    LogUtil.e("getSelectedItemPosition() : " + getSelectedItemPosition());
    return getItem(getSelectedItemPosition());
  }
  
  public void setKey(String paramString)
  {
    this.key = paramString;
  }
  
  private class GSpinnerAdapter
    extends ArrayAdapter<String>
  {
    public GSpinnerAdapter(Context paramContext)
    {
      super(17367048);
    }
    
    public GSpinnerAdapter(Context paramContext, int paramInt)
    {
      super(paramInt);
    }
    
    public int getCount()
    {
      if (GSpinner.this.hint != null) {
        return -1 + super.getCount();
      }
      return super.getCount();
    }
    
    public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = super.getDropDownView(paramInt, paramView, paramViewGroup);
      TextView localTextView = (TextView)localView.findViewById(16908308);
      localTextView.getLayoutParams().height = ((int)ImageUtil.dipToPixel(getContext(), 40.0F));
      localTextView.setGravity(16);
      localTextView.setPadding((int)ImageUtil.dipToPixel(getContext(), 10.0F), 0, (int)ImageUtil.dipToPixel(getContext(), 10.0F), 0);
      return localView;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = super.getView(paramInt, paramView, paramViewGroup);
      TextView localTextView = (TextView)localView.findViewById(16908308);
      localTextView.setTextColor(-13421773);
      localTextView.setHintTextColor(-3291490);
      localTextView.setPadding(0, 0, 0, 0);
      localTextView.setTextSize(2, GSpinner.this.textSize);
      if ((paramInt == getCount()) && (GSpinner.this.hint != null))
      {
        localTextView.setText("");
        localTextView.setHint((CharSequence)getItem(getCount()));
      }
      return localView;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.view.GSpinner
 * JD-Core Version:    0.7.0.1
 */