package com.google.android.gms.cast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import android.view.accessibility.CaptioningManager.CaptionStyle;
import com.google.android.gms.internal.in;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.li;
import com.google.android.gms.internal.ll;
import org.json.JSONException;
import org.json.JSONObject;

public final class TextTrackStyle
{
  public static final int COLOR_UNSPECIFIED = 0;
  public static final float DEFAULT_FONT_SCALE = 1.0F;
  public static final int EDGE_TYPE_DEPRESSED = 4;
  public static final int EDGE_TYPE_DROP_SHADOW = 2;
  public static final int EDGE_TYPE_NONE = 0;
  public static final int EDGE_TYPE_OUTLINE = 1;
  public static final int EDGE_TYPE_RAISED = 3;
  public static final int EDGE_TYPE_UNSPECIFIED = -1;
  public static final int FONT_FAMILY_CASUAL = 4;
  public static final int FONT_FAMILY_CURSIVE = 5;
  public static final int FONT_FAMILY_MONOSPACED_SANS_SERIF = 1;
  public static final int FONT_FAMILY_MONOSPACED_SERIF = 3;
  public static final int FONT_FAMILY_SANS_SERIF = 0;
  public static final int FONT_FAMILY_SERIF = 2;
  public static final int FONT_FAMILY_SMALL_CAPITALS = 6;
  public static final int FONT_FAMILY_UNSPECIFIED = -1;
  public static final int FONT_STYLE_BOLD = 1;
  public static final int FONT_STYLE_BOLD_ITALIC = 3;
  public static final int FONT_STYLE_ITALIC = 2;
  public static final int FONT_STYLE_NORMAL = 0;
  public static final int FONT_STYLE_UNSPECIFIED = -1;
  public static final int WINDOW_TYPE_NONE = 0;
  public static final int WINDOW_TYPE_NORMAL = 1;
  public static final int WINDOW_TYPE_ROUNDED = 2;
  public static final int WINDOW_TYPE_UNSPECIFIED = -1;
  private float GT;
  private int GU;
  private int GV;
  private int GW;
  private int GX;
  private int GY;
  private int GZ;
  private JSONObject Ga;
  private String Ha;
  private int Hb;
  private int Hc;
  private int xB;
  
  public TextTrackStyle()
  {
    clear();
  }
  
  private int aC(String paramString)
  {
    int i = 0;
    if (paramString != null)
    {
      int j = paramString.length();
      i = 0;
      if (j == 9)
      {
        int k = paramString.charAt(0);
        i = 0;
        if (k != 35) {}
      }
    }
    try
    {
      int m = Integer.parseInt(paramString.substring(1, 3), 16);
      int n = Integer.parseInt(paramString.substring(3, 5), 16);
      int i1 = Integer.parseInt(paramString.substring(5, 7), 16);
      int i2 = Color.argb(Integer.parseInt(paramString.substring(7, 9), 16), m, n, i1);
      i = i2;
      return i;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 0;
  }
  
  private void clear()
  {
    this.GT = 1.0F;
    this.GU = 0;
    this.xB = 0;
    this.GV = -1;
    this.GW = 0;
    this.GX = -1;
    this.GY = 0;
    this.GZ = 0;
    this.Ha = null;
    this.Hb = -1;
    this.Hc = -1;
    this.Ga = null;
  }
  
  public static TextTrackStyle fromSystemSettings(Context paramContext)
  {
    TextTrackStyle localTextTrackStyle = new TextTrackStyle();
    if (!ll.im()) {
      return localTextTrackStyle;
    }
    CaptioningManager localCaptioningManager = (CaptioningManager)paramContext.getSystemService("captioning");
    localTextTrackStyle.setFontScale(localCaptioningManager.getFontScale());
    CaptioningManager.CaptionStyle localCaptionStyle = localCaptioningManager.getUserStyle();
    localTextTrackStyle.setBackgroundColor(localCaptionStyle.backgroundColor);
    localTextTrackStyle.setForegroundColor(localCaptionStyle.foregroundColor);
    Typeface localTypeface;
    label120:
    boolean bool1;
    boolean bool2;
    switch (localCaptionStyle.edgeType)
    {
    default: 
      localTextTrackStyle.setEdgeType(0);
      localTextTrackStyle.setEdgeColor(localCaptionStyle.edgeColor);
      localTypeface = localCaptionStyle.getTypeface();
      if (localTypeface != null)
      {
        if (!Typeface.MONOSPACE.equals(localTypeface)) {
          break label167;
        }
        localTextTrackStyle.setFontGenericFamily(1);
        bool1 = localTypeface.isBold();
        bool2 = localTypeface.isItalic();
        if ((!bool1) || (!bool2)) {
          break label213;
        }
        localTextTrackStyle.setFontStyle(3);
      }
      break;
    }
    for (;;)
    {
      return localTextTrackStyle;
      localTextTrackStyle.setEdgeType(1);
      break;
      localTextTrackStyle.setEdgeType(2);
      break;
      label167:
      if (Typeface.SANS_SERIF.equals(localTypeface))
      {
        localTextTrackStyle.setFontGenericFamily(0);
        break label120;
      }
      if (Typeface.SERIF.equals(localTypeface))
      {
        localTextTrackStyle.setFontGenericFamily(2);
        break label120;
      }
      localTextTrackStyle.setFontGenericFamily(0);
      break label120;
      label213:
      if (bool1) {
        localTextTrackStyle.setFontStyle(1);
      } else if (bool2) {
        localTextTrackStyle.setFontStyle(2);
      } else {
        localTextTrackStyle.setFontStyle(0);
      }
    }
  }
  
  private String u(int paramInt)
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(Color.red(paramInt));
    arrayOfObject[1] = Integer.valueOf(Color.green(paramInt));
    arrayOfObject[2] = Integer.valueOf(Color.blue(paramInt));
    arrayOfObject[3] = Integer.valueOf(Color.alpha(paramInt));
    return String.format("#%02X%02X%02X%02X", arrayOfObject);
  }
  
  public void c(JSONObject paramJSONObject)
    throws JSONException
  {
    clear();
    this.GT = ((float)paramJSONObject.optDouble("fontScale", 1.0D));
    this.GU = aC(paramJSONObject.optString("foregroundColor"));
    this.xB = aC(paramJSONObject.optString("backgroundColor"));
    String str4;
    String str3;
    label127:
    String str2;
    label207:
    String str1;
    if (paramJSONObject.has("edgeType"))
    {
      str4 = paramJSONObject.getString("edgeType");
      if ("NONE".equals(str4)) {
        this.GV = 0;
      }
    }
    else
    {
      this.GW = aC(paramJSONObject.optString("edgeColor"));
      if (paramJSONObject.has("windowType"))
      {
        str3 = paramJSONObject.getString("windowType");
        if (!"NONE".equals(str3)) {
          break label328;
        }
        this.GX = 0;
      }
      this.GY = aC(paramJSONObject.optString("windowColor"));
      if (this.GX == 2) {
        this.GZ = paramJSONObject.optInt("windowRoundedCornerRadius", 0);
      }
      this.Ha = paramJSONObject.optString("fontFamily", null);
      if (paramJSONObject.has("fontGenericFamily"))
      {
        str2 = paramJSONObject.getString("fontGenericFamily");
        if (!"SANS_SERIF".equals(str2)) {
          break label366;
        }
        this.Hb = 0;
      }
      if (paramJSONObject.has("fontStyle"))
      {
        str1 = paramJSONObject.getString("fontStyle");
        if (!"NORMAL".equals(str1)) {
          break label475;
        }
        this.Hc = 0;
      }
    }
    for (;;)
    {
      this.Ga = paramJSONObject.optJSONObject("customData");
      return;
      if ("OUTLINE".equals(str4))
      {
        this.GV = 1;
        break;
      }
      if ("DROP_SHADOW".equals(str4))
      {
        this.GV = 2;
        break;
      }
      if ("RAISED".equals(str4))
      {
        this.GV = 3;
        break;
      }
      if (!"DEPRESSED".equals(str4)) {
        break;
      }
      this.GV = 4;
      break;
      label328:
      if ("NORMAL".equals(str3))
      {
        this.GX = 1;
        break label127;
      }
      if (!"ROUNDED_CORNERS".equals(str3)) {
        break label127;
      }
      this.GX = 2;
      break label127;
      label366:
      if ("MONOSPACED_SANS_SERIF".equals(str2))
      {
        this.Hb = 1;
        break label207;
      }
      if ("SERIF".equals(str2))
      {
        this.Hb = 2;
        break label207;
      }
      if ("MONOSPACED_SERIF".equals(str2))
      {
        this.Hb = 3;
        break label207;
      }
      if ("CASUAL".equals(str2))
      {
        this.Hb = 4;
        break label207;
      }
      if ("CURSIVE".equals(str2))
      {
        this.Hb = 5;
        break label207;
      }
      if (!"SMALL_CAPITALS".equals(str2)) {
        break label207;
      }
      this.Hb = 6;
      break label207;
      label475:
      if ("BOLD".equals(str1)) {
        this.Hc = 1;
      } else if ("ITALIC".equals(str1)) {
        this.Hc = 2;
      } else if ("BOLD_ITALIC".equals(str1)) {
        this.Hc = 3;
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool3;
    if (this == paramObject) {
      bool3 = bool1;
    }
    TextTrackStyle localTextTrackStyle;
    boolean bool4;
    boolean bool5;
    label52:
    boolean bool6;
    do
    {
      do
      {
        boolean bool2;
        do
        {
          return bool3;
          bool2 = paramObject instanceof TextTrackStyle;
          bool3 = false;
        } while (!bool2);
        localTextTrackStyle = (TextTrackStyle)paramObject;
        if (this.Ga != null) {
          break;
        }
        bool4 = bool1;
        if (localTextTrackStyle.Ga != null) {
          break label231;
        }
        bool5 = bool1;
        bool3 = false;
      } while (bool4 != bool5);
      if ((this.Ga == null) || (localTextTrackStyle.Ga == null)) {
        break;
      }
      bool6 = li.d(this.Ga, localTextTrackStyle.Ga);
      bool3 = false;
    } while (!bool6);
    if ((this.GT == localTextTrackStyle.GT) && (this.GU == localTextTrackStyle.GU) && (this.xB == localTextTrackStyle.xB) && (this.GV == localTextTrackStyle.GV) && (this.GW == localTextTrackStyle.GW) && (this.GX == localTextTrackStyle.GX) && (this.GZ == localTextTrackStyle.GZ) && (in.a(this.Ha, localTextTrackStyle.Ha)) && (this.Hb == localTextTrackStyle.Hb) && (this.Hc == localTextTrackStyle.Hc)) {}
    for (;;)
    {
      return bool1;
      bool4 = false;
      break;
      label231:
      bool5 = false;
      break label52;
      bool1 = false;
    }
  }
  
  public int getBackgroundColor()
  {
    return this.xB;
  }
  
  public JSONObject getCustomData()
  {
    return this.Ga;
  }
  
  public int getEdgeColor()
  {
    return this.GW;
  }
  
  public int getEdgeType()
  {
    return this.GV;
  }
  
  public String getFontFamily()
  {
    return this.Ha;
  }
  
  public int getFontGenericFamily()
  {
    return this.Hb;
  }
  
  public float getFontScale()
  {
    return this.GT;
  }
  
  public int getFontStyle()
  {
    return this.Hc;
  }
  
  public int getForegroundColor()
  {
    return this.GU;
  }
  
  public int getWindowColor()
  {
    return this.GY;
  }
  
  public int getWindowCornerRadius()
  {
    return this.GZ;
  }
  
  public int getWindowType()
  {
    return this.GX;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[12];
    arrayOfObject[0] = Float.valueOf(this.GT);
    arrayOfObject[1] = Integer.valueOf(this.GU);
    arrayOfObject[2] = Integer.valueOf(this.xB);
    arrayOfObject[3] = Integer.valueOf(this.GV);
    arrayOfObject[4] = Integer.valueOf(this.GW);
    arrayOfObject[5] = Integer.valueOf(this.GX);
    arrayOfObject[6] = Integer.valueOf(this.GY);
    arrayOfObject[7] = Integer.valueOf(this.GZ);
    arrayOfObject[8] = this.Ha;
    arrayOfObject[9] = Integer.valueOf(this.Hb);
    arrayOfObject[10] = Integer.valueOf(this.Hc);
    arrayOfObject[11] = this.Ga;
    return jv.hashCode(arrayOfObject);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.xB = paramInt;
  }
  
  public void setCustomData(JSONObject paramJSONObject)
  {
    this.Ga = paramJSONObject;
  }
  
  public void setEdgeColor(int paramInt)
  {
    this.GW = paramInt;
  }
  
  public void setEdgeType(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 4)) {
      throw new IllegalArgumentException("invalid edgeType");
    }
    this.GV = paramInt;
  }
  
  public void setFontFamily(String paramString)
  {
    this.Ha = paramString;
  }
  
  public void setFontGenericFamily(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 6)) {
      throw new IllegalArgumentException("invalid fontGenericFamily");
    }
    this.Hb = paramInt;
  }
  
  public void setFontScale(float paramFloat)
  {
    this.GT = paramFloat;
  }
  
  public void setFontStyle(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 3)) {
      throw new IllegalArgumentException("invalid fontStyle");
    }
    this.Hc = paramInt;
  }
  
  public void setForegroundColor(int paramInt)
  {
    this.GU = paramInt;
  }
  
  public void setWindowColor(int paramInt)
  {
    this.GY = paramInt;
  }
  
  public void setWindowCornerRadius(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("invalid windowCornerRadius");
    }
    this.GZ = paramInt;
  }
  
  public void setWindowType(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 2)) {
      throw new IllegalArgumentException("invalid windowType");
    }
    this.GX = paramInt;
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("fontScale", this.GT);
      if (this.GU != 0) {
        localJSONObject.put("foregroundColor", u(this.GU));
      }
      if (this.xB != 0) {
        localJSONObject.put("backgroundColor", u(this.xB));
      }
      switch (this.GV)
      {
      default: 
        if (this.GW != 0) {
          localJSONObject.put("edgeColor", u(this.GW));
        }
        switch (this.GX)
        {
        default: 
          label156:
          if (this.GY != 0) {
            localJSONObject.put("windowColor", u(this.GY));
          }
          if (this.GX == 2) {
            localJSONObject.put("windowRoundedCornerRadius", this.GZ);
          }
          if (this.Ha != null) {
            localJSONObject.put("fontFamily", this.Ha);
          }
          switch (this.Hb)
          {
          default: 
            label264:
            switch (this.Hc)
            {
            }
            break;
          }
          break;
        }
        break;
      }
      for (;;)
      {
        if (this.Ga == null) {
          break label582;
        }
        localJSONObject.put("customData", this.Ga);
        return localJSONObject;
        localJSONObject.put("edgeType", "NONE");
        break;
        localJSONObject.put("edgeType", "OUTLINE");
        break;
        localJSONObject.put("edgeType", "DROP_SHADOW");
        break;
        localJSONObject.put("edgeType", "RAISED");
        break;
        localJSONObject.put("edgeType", "DEPRESSED");
        break;
        localJSONObject.put("windowType", "NONE");
        break label156;
        localJSONObject.put("windowType", "NORMAL");
        break label156;
        localJSONObject.put("windowType", "ROUNDED_CORNERS");
        break label156;
        localJSONObject.put("fontGenericFamily", "SANS_SERIF");
        break label264;
        localJSONObject.put("fontGenericFamily", "MONOSPACED_SANS_SERIF");
        break label264;
        localJSONObject.put("fontGenericFamily", "SERIF");
        break label264;
        localJSONObject.put("fontGenericFamily", "MONOSPACED_SERIF");
        break label264;
        localJSONObject.put("fontGenericFamily", "CASUAL");
        break label264;
        localJSONObject.put("fontGenericFamily", "CURSIVE");
        break label264;
        localJSONObject.put("fontGenericFamily", "SMALL_CAPITALS");
        break label264;
        localJSONObject.put("fontStyle", "NORMAL");
        continue;
        localJSONObject.put("fontStyle", "BOLD");
        continue;
        localJSONObject.put("fontStyle", "ITALIC");
        continue;
        localJSONObject.put("fontStyle", "BOLD_ITALIC");
      }
      label582:
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.cast.TextTrackStyle
 * JD-Core Version:    0.7.0.1
 */