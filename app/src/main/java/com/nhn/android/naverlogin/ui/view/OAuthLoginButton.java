package com.nhn.android.naverlogin.ui.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.nhn.android.naverlogin.OAuthLogin;
import com.nhn.android.naverlogin.OAuthLoginHandler;

public class OAuthLoginButton
  extends ImageButton
{
  private static OAuthLoginHandler mOAuthLoginHandler;
  private int mBgDrawableResId = -1;
  private Context mContext;
  
  public OAuthLoginButton(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public OAuthLoginButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public OAuthLoginButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mBgDrawableResId = -1;
    this.mContext = paramContext;
    setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        OAuthLogin.getInstance().startOauthLoginActivity((Activity)OAuthLoginButton.this.mContext, OAuthLoginButton.mOAuthLoginHandler);
      }
    });
  }
  
  /* Error */
  private void setBgType()
  {
    // Byte code:
    //   0: iconst_m1
    //   1: aload_0
    //   2: getfield 16	com/nhn/android/naverlogin/ui/view/OAuthLoginButton:mBgDrawableResId	I
    //   5: if_icmpeq +38 -> 43
    //   8: aload_0
    //   9: invokevirtual 50	com/nhn/android/naverlogin/ui/view/OAuthLoginButton:getResources	()Landroid/content/res/Resources;
    //   12: aload_0
    //   13: getfield 16	com/nhn/android/naverlogin/ui/view/OAuthLoginButton:mBgDrawableResId	I
    //   16: invokevirtual 56	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   19: astore 14
    //   21: getstatic 61	android/os/Build$VERSION:SDK_INT	I
    //   24: bipush 16
    //   26: if_icmplt +10 -> 36
    //   29: aload_0
    //   30: aload 14
    //   32: invokevirtual 65	com/nhn/android/naverlogin/ui/view/OAuthLoginButton:setBackground	(Landroid/graphics/drawable/Drawable;)V
    //   35: return
    //   36: aload_0
    //   37: aload 14
    //   39: invokevirtual 68	com/nhn/android/naverlogin/ui/view/OAuthLoginButton:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   42: return
    //   43: invokestatic 74	com/nhn/android/naverlogin/ui/OAuthLoginImage:getDrawableByteStrLoginBtnImg	()Ljava/lang/String;
    //   46: invokestatic 78	com/nhn/android/naverlogin/ui/OAuthLoginImage:hexToByteArray	(Ljava/lang/String;)[B
    //   49: astore_1
    //   50: aload_1
    //   51: iconst_0
    //   52: aload_1
    //   53: arraylength
    //   54: invokestatic 84	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   57: astore 13
    //   59: aload 13
    //   61: astore 4
    //   63: aload_0
    //   64: invokevirtual 88	com/nhn/android/naverlogin/ui/view/OAuthLoginButton:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   67: getfield 93	android/view/ViewGroup$LayoutParams:height	I
    //   70: istore 8
    //   72: iload 8
    //   74: ifle +91 -> 165
    //   77: iload 8
    //   79: i2d
    //   80: aload 4
    //   82: invokevirtual 99	android/graphics/Bitmap:getHeight	()I
    //   85: i2d
    //   86: ddiv
    //   87: aload 4
    //   89: invokevirtual 102	android/graphics/Bitmap:getWidth	()I
    //   92: i2d
    //   93: dmul
    //   94: d2i
    //   95: istore 9
    //   97: new 104	android/graphics/drawable/BitmapDrawable
    //   100: dup
    //   101: aload_0
    //   102: invokevirtual 50	com/nhn/android/naverlogin/ui/view/OAuthLoginButton:getResources	()Landroid/content/res/Resources;
    //   105: aload 4
    //   107: iload 9
    //   109: iload 8
    //   111: iconst_1
    //   112: invokestatic 108	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   115: invokespecial 111	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   118: astore 6
    //   120: getstatic 61	android/os/Build$VERSION:SDK_INT	I
    //   123: bipush 16
    //   125: if_icmplt +137 -> 262
    //   128: aload_0
    //   129: aload 6
    //   131: invokevirtual 65	com/nhn/android/naverlogin/ui/view/OAuthLoginButton:setBackground	(Landroid/graphics/drawable/Drawable;)V
    //   134: return
    //   135: astore 7
    //   137: aload 7
    //   139: invokevirtual 114	java/lang/Exception:printStackTrace	()V
    //   142: return
    //   143: astore_2
    //   144: new 116	android/graphics/BitmapFactory$Options
    //   147: dup
    //   148: invokespecial 118	android/graphics/BitmapFactory$Options:<init>	()V
    //   151: astore_3
    //   152: aload_1
    //   153: iconst_0
    //   154: aload_1
    //   155: arraylength
    //   156: aload_3
    //   157: invokestatic 121	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   160: astore 4
    //   162: goto -99 -> 63
    //   165: aload_0
    //   166: invokevirtual 88	com/nhn/android/naverlogin/ui/view/OAuthLoginButton:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   169: getfield 124	android/view/ViewGroup$LayoutParams:width	I
    //   172: istore 9
    //   174: iload 9
    //   176: ifle +26 -> 202
    //   179: iload 9
    //   181: i2d
    //   182: aload 4
    //   184: invokevirtual 102	android/graphics/Bitmap:getWidth	()I
    //   187: i2d
    //   188: ddiv
    //   189: aload 4
    //   191: invokevirtual 99	android/graphics/Bitmap:getHeight	()I
    //   194: i2d
    //   195: dmul
    //   196: d2i
    //   197: istore 8
    //   199: goto -102 -> 97
    //   202: bipush 80
    //   204: istore 8
    //   206: iload 8
    //   208: i2d
    //   209: aload 4
    //   211: invokevirtual 99	android/graphics/Bitmap:getHeight	()I
    //   214: i2d
    //   215: ddiv
    //   216: dstore 10
    //   218: aload 4
    //   220: invokevirtual 102	android/graphics/Bitmap:getWidth	()I
    //   223: istore 12
    //   225: dload 10
    //   227: iload 12
    //   229: i2d
    //   230: dmul
    //   231: d2i
    //   232: istore 9
    //   234: goto -137 -> 97
    //   237: astore 5
    //   239: new 104	android/graphics/drawable/BitmapDrawable
    //   242: dup
    //   243: aload_0
    //   244: invokevirtual 50	com/nhn/android/naverlogin/ui/view/OAuthLoginButton:getResources	()Landroid/content/res/Resources;
    //   247: aload 4
    //   249: invokespecial 111	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   252: astore 6
    //   254: aload 5
    //   256: invokevirtual 114	java/lang/Exception:printStackTrace	()V
    //   259: goto -139 -> 120
    //   262: aload_0
    //   263: aload 6
    //   265: invokevirtual 68	com/nhn/android/naverlogin/ui/view/OAuthLoginButton:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   268: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	this	OAuthLoginButton
    //   49	106	1	arrayOfByte	byte[]
    //   143	1	2	localException1	java.lang.Exception
    //   151	6	3	localOptions	android.graphics.BitmapFactory.Options
    //   61	187	4	localBitmap1	android.graphics.Bitmap
    //   237	18	5	localException2	java.lang.Exception
    //   118	146	6	localBitmapDrawable	android.graphics.drawable.BitmapDrawable
    //   135	3	7	localException3	java.lang.Exception
    //   70	137	8	i	int
    //   95	138	9	j	int
    //   216	10	10	d	double
    //   223	5	12	k	int
    //   57	3	13	localBitmap2	android.graphics.Bitmap
    //   19	19	14	localDrawable	android.graphics.drawable.Drawable
    // Exception table:
    //   from	to	target	type
    //   120	134	135	java/lang/Exception
    //   262	268	135	java/lang/Exception
    //   50	59	143	java/lang/Exception
    //   63	72	237	java/lang/Exception
    //   77	97	237	java/lang/Exception
    //   97	120	237	java/lang/Exception
    //   165	174	237	java/lang/Exception
    //   179	199	237	java/lang/Exception
    //   206	225	237	java/lang/Exception
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (isInEditMode()) {
      return;
    }
    setBgType();
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setBgResourceId(int paramInt)
  {
    this.mBgDrawableResId = paramInt;
  }
  
  @Deprecated
  public void setBgType(String paramString1, String paramString2)
  {
    setBgType();
  }
  
  public void setOAuthLoginHandler(OAuthLoginHandler paramOAuthLoginHandler)
  {
    mOAuthLoginHandler = paramOAuthLoginHandler;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nhn.android.naverlogin.ui.view.OAuthLoginButton
 * JD-Core Version:    0.7.0.1
 */