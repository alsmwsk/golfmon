package com.google.android.gms.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.VideoView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

@ey
public final class dt
  extends FrameLayout
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  private final gu mo;
  private final MediaController so;
  private final a sp;
  private final VideoView sq;
  private long sr;
  private String ss;
  
  public dt(Context paramContext, gu paramgu)
  {
    super(paramContext);
    this.mo = paramgu;
    this.sq = new VideoView(paramContext);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
    addView(this.sq, localLayoutParams);
    this.so = new MediaController(paramContext);
    this.sp = new a(this);
    this.sp.cs();
    this.sq.setOnCompletionListener(this);
    this.sq.setOnPreparedListener(this);
    this.sq.setOnErrorListener(this);
  }
  
  private static void a(gu paramgu, String paramString)
  {
    a(paramgu, paramString, new HashMap(1));
  }
  
  public static void a(gu paramgu, String paramString1, String paramString2)
  {
    int i;
    if (paramString2 == null)
    {
      i = 1;
      if (i == 0) {
        break label60;
      }
    }
    label60:
    for (int j = 2;; j = 3)
    {
      HashMap localHashMap = new HashMap(j);
      localHashMap.put("what", paramString1);
      if (i == 0) {
        localHashMap.put("extra", paramString2);
      }
      a(paramgu, "error", localHashMap);
      return;
      i = 0;
      break;
    }
  }
  
  private static void a(gu paramgu, String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap(2);
    localHashMap.put(paramString2, paramString3);
    a(paramgu, paramString1, localHashMap);
  }
  
  private static void a(gu paramgu, String paramString, Map<String, String> paramMap)
  {
    paramMap.put("event", paramString);
    paramgu.a("onVideoEvent", paramMap);
  }
  
  public void C(String paramString)
  {
    this.ss = paramString;
  }
  
  public void b(MotionEvent paramMotionEvent)
  {
    this.sq.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void cq()
  {
    if (!TextUtils.isEmpty(this.ss))
    {
      this.sq.setVideoPath(this.ss);
      return;
    }
    a(this.mo, "no_src", null);
  }
  
  public void cr()
  {
    long l = this.sq.getCurrentPosition();
    if (this.sr != l)
    {
      float f = (float)l / 1000.0F;
      a(this.mo, "timeupdate", "time", String.valueOf(f));
      this.sr = l;
    }
  }
  
  public void destroy()
  {
    this.sp.cancel();
    this.sq.stopPlayback();
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    a(this.mo, "ended");
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    a(this.mo, String.valueOf(paramInt1), String.valueOf(paramInt2));
    return true;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    float f = this.sq.getDuration() / 1000.0F;
    a(this.mo, "canplaythrough", "duration", String.valueOf(f));
  }
  
  public void pause()
  {
    this.sq.pause();
  }
  
  public void play()
  {
    this.sq.start();
  }
  
  public void s(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.sq.setMediaController(this.so);
      return;
    }
    this.so.hide();
    this.sq.setMediaController(null);
  }
  
  public void seekTo(int paramInt)
  {
    this.sq.seekTo(paramInt);
  }
  
  private static final class a
  {
    private final Runnable mv;
    private volatile boolean st = false;
    
    public a(final dt paramdt)
    {
      this.mv = new Runnable()
      {
        private final WeakReference<dt> su = new WeakReference(paramdt);
        
        public void run()
        {
          dt localdt = (dt)this.su.get();
          if ((!dt.a.a(dt.a.this)) && (localdt != null))
          {
            localdt.cr();
            dt.a.this.cs();
          }
        }
      };
    }
    
    public void cancel()
    {
      this.st = true;
      gq.wR.removeCallbacks(this.mv);
    }
    
    public void cs()
    {
      gq.wR.postDelayed(this.mv, 250L);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dt
 * JD-Core Version:    0.7.0.1
 */