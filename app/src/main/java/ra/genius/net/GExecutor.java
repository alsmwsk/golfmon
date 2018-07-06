package ra.genius.net;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class GExecutor
{
  private static final int NEWEXECUTE = 2;
  private static final int PROCESS = 1;
  private static final int STANDBY;
  private static GExecutor mInstance = null;
  private GHandler mHandler = new GHandler(null);
  private IProcessor mPostProcessor = null;
  private IProcessor mPrevProcessor = null;
  private ConcurrentLinkedQueue<IExecute> mQueue = new ConcurrentLinkedQueue();
  private ProcessRunnable mRunnable = new ProcessRunnable(null);
  private AtomicInteger mState = new AtomicInteger(0);
  
  public static GExecutor getInstance()
  {
    if (mInstance == null) {
      mInstance = new GExecutor();
    }
    return mInstance;
  }
  
  public void add(IExecute paramIExecute)
  {
    this.mQueue.add(paramIExecute);
  }
  
  public void cancel()
  {
    if (this.mState.get() == 1) {
      this.mRunnable.cancel();
    }
  }
  
  public void cancelAll()
  {
    this.mQueue.clear();
    this.mRunnable.cancel();
  }
  
  public void cancelAndExecute(IExecute paramIExecute)
  {
    this.mQueue.clear();
    add(paramIExecute);
    switch (this.mState.get())
    {
    default: 
      return;
    case 0: 
      execute();
      return;
    }
    this.mRunnable.cancel();
  }
  
  public void clearProcessor()
  {
    this.mPrevProcessor = null;
    this.mPostProcessor = null;
  }
  
  public void execute()
  {
    if (this.mState.getAndSet(2) == 0) {
      new Thread(this.mRunnable).start();
    }
  }
  
  public void execute(IExecute paramIExecute)
  {
    add(paramIExecute);
    execute();
  }
  
  public void initialize()
  {
    cancelAll();
    clearProcessor();
  }
  
  public void setPostProcessor(IProcessor paramIProcessor)
  {
    this.mPostProcessor = paramIProcessor;
  }
  
  public void setPrevProcessor(IProcessor paramIProcessor)
  {
    this.mPrevProcessor = paramIProcessor;
  }
  
  @SuppressLint({"HandlerLeak"})
  private class GHandler
    extends Handler
  {
    public static final int POST_PROCESS = 200;
    public static final int PREV_PROCESS = 100;
    
    private GHandler() {}
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        do
        {
          return;
        } while (GExecutor.this.mPrevProcessor == null);
        GExecutor.this.mPrevProcessor.process();
        return;
      } while (GExecutor.this.mPostProcessor == null);
      GExecutor.this.mPostProcessor.process();
    }
  }
  
  private class ProcessRunnable
    implements Runnable
  {
    private IExecute mCurrentExecute = null;
    
    private ProcessRunnable() {}
    
    public void cancel()
    {
      if (this.mCurrentExecute != null) {
        this.mCurrentExecute.cancel();
      }
    }
    
    public void run()
    {
      GExecutor.this.mHandler.sendEmptyMessage(100);
      do
      {
        for (;;)
        {
          GExecutor.this.mState.set(1);
          this.mCurrentExecute = ((IExecute)GExecutor.this.mQueue.poll());
          if (this.mCurrentExecute == null) {
            break;
          }
          this.mCurrentExecute.async(true);
          this.mCurrentExecute.execute();
        }
      } while (!GExecutor.this.mState.compareAndSet(1, 0));
      this.mCurrentExecute = null;
      GExecutor.this.mHandler.sendEmptyMessage(200);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     ra.genius.net.GExecutor
 * JD-Core Version:    0.7.0.1
 */