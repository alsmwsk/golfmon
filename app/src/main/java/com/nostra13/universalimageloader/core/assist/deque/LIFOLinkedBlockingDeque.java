package com.nostra13.universalimageloader.core.assist.deque;

public class LIFOLinkedBlockingDeque<T>
  extends LinkedBlockingDeque<T>
{
  private static final long serialVersionUID = -4114786347960826192L;
  
  public boolean offer(T paramT)
  {
    return super.offerFirst(paramT);
  }
  
  public T remove()
  {
    return super.removeFirst();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.deque.LIFOLinkedBlockingDeque
 * JD-Core Version:    0.7.0.1
 */