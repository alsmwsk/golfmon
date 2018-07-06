package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomPropertyKey
  implements SafeParcelable
{
  public static final Parcelable.Creator<CustomPropertyKey> CREATOR = new c();
  public static final int PRIVATE = 1;
  public static final int PUBLIC;
  private static final Pattern Rc = Pattern.compile("[\\w.!@$%^&*()/-]+");
  final int CK;
  final String KP;
  final int mVisibility;
  
  CustomPropertyKey(int paramInt1, String paramString, int paramInt2)
  {
    jx.b(paramString, "key");
    jx.b(Rc.matcher(paramString).matches(), "key name characters must be alphanumeric or one of .!@$%^&*()-_/");
    if ((paramInt2 == 0) || (paramInt2 == i)) {}
    for (;;)
    {
      jx.b(i, "visibility must be either PUBLIC or PRIVATE");
      this.CK = paramInt1;
      this.KP = paramString;
      this.mVisibility = paramInt2;
      return;
      i = 0;
    }
  }
  
  public CustomPropertyKey(String paramString, int paramInt)
  {
    this(1, paramString, paramInt);
  }
  
  public static CustomPropertyKey fromJson(JSONObject paramJSONObject)
    throws JSONException
  {
    return new CustomPropertyKey(paramJSONObject.getString("key"), paramJSONObject.getInt("visibility"));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null) {}
    do
    {
      return false;
      if (paramObject == this) {
        return bool;
      }
    } while (!(paramObject instanceof CustomPropertyKey));
    CustomPropertyKey localCustomPropertyKey = (CustomPropertyKey)paramObject;
    if ((localCustomPropertyKey.getKey().equals(this.KP)) && (localCustomPropertyKey.getVisibility() == this.mVisibility)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public String getKey()
  {
    return this.KP;
  }
  
  public int getVisibility()
  {
    return this.mVisibility;
  }
  
  public int hashCode()
  {
    return (this.KP + this.mVisibility).hashCode();
  }
  
  public JSONObject toJson()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("key", getKey());
    localJSONObject.put("visibility", getVisibility());
    return localJSONObject;
  }
  
  public String toString()
  {
    return "CustomPropertyKey(" + this.KP + "," + this.mVisibility + ")";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.metadata.CustomPropertyKey
 * JD-Core Version:    0.7.0.1
 */