package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebImage
  implements SafeParcelable
{
  public static final Parcelable.Creator<WebImage> CREATOR = new b();
  private final int CK;
  private final Uri LU;
  private final int li;
  private final int lj;
  
  WebImage(int paramInt1, Uri paramUri, int paramInt2, int paramInt3)
  {
    this.CK = paramInt1;
    this.LU = paramUri;
    this.li = paramInt2;
    this.lj = paramInt3;
  }
  
  public WebImage(Uri paramUri)
    throws IllegalArgumentException
  {
    this(paramUri, 0, 0);
  }
  
  public WebImage(Uri paramUri, int paramInt1, int paramInt2)
    throws IllegalArgumentException
  {
    this(1, paramUri, paramInt1, paramInt2);
    if (paramUri == null) {
      throw new IllegalArgumentException("url cannot be null");
    }
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      throw new IllegalArgumentException("width and height must not be negative");
    }
  }
  
  public WebImage(JSONObject paramJSONObject)
    throws IllegalArgumentException
  {
    this(d(paramJSONObject), paramJSONObject.optInt("width", 0), paramJSONObject.optInt("height", 0));
  }
  
  private static Uri d(JSONObject paramJSONObject)
  {
    boolean bool = paramJSONObject.has("url");
    Object localObject = null;
    if (bool) {}
    try
    {
      Uri localUri = Uri.parse(paramJSONObject.getString("url"));
      localObject = localUri;
      return localObject;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    WebImage localWebImage;
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof WebImage))) {
        return false;
      }
      localWebImage = (WebImage)paramObject;
    } while ((jv.equal(this.LU, localWebImage.LU)) && (this.li == localWebImage.li) && (this.lj == localWebImage.lj));
    return false;
  }
  
  public int getHeight()
  {
    return this.lj;
  }
  
  public Uri getUrl()
  {
    return this.LU;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public int getWidth()
  {
    return this.li;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.LU;
    arrayOfObject[1] = Integer.valueOf(this.li);
    arrayOfObject[2] = Integer.valueOf(this.lj);
    return jv.hashCode(arrayOfObject);
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("url", this.LU.toString());
      localJSONObject.put("width", this.li);
      localJSONObject.put("height", this.lj);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  public String toString()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(this.li);
    arrayOfObject[1] = Integer.valueOf(this.lj);
    arrayOfObject[2] = this.LU.toString();
    return String.format("Image %dx%d %s", arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.WebImage
 * JD-Core Version:    0.7.0.1
 */