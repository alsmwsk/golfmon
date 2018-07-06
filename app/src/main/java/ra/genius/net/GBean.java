package ra.genius.net;

import java.util.HashMap;
import java.util.Map.Entry;

public class GBean
{
  public static final String HTTP_STATUS_ERROR_MESSAGE = "HTTP_STATUS_ERROR_MESSAGE";
  private Exception mException = null;
  private int mHttpStatus = 200;
  private HashMap<String, Object> mResult = new HashMap();
  
  public void clear()
  {
    this.mResult.clear();
  }
  
  public Map.Entry<String, Object> entrySet()
  {
    return (Map.Entry)this.mResult.entrySet();
  }
  
  public Object get(String paramString)
  {
    return get(paramString, null);
  }
  
  public Object get(String paramString, Object paramObject)
  {
    if (has(paramString)) {
      paramObject = this.mResult.get(paramString);
    }
    return paramObject;
  }
  
  public Exception getException()
  {
    return this.mException;
  }
  
  public int getHttpStatus()
  {
    return this.mHttpStatus;
  }
  
  public boolean has(String paramString)
  {
    return this.mResult.containsKey(paramString);
  }
  
  public void put(String paramString, Object paramObject)
  {
    this.mResult.put(paramString, paramObject);
  }
  
  public void putException(Exception paramException)
  {
    this.mException = paramException;
  }
  
  public void putHttpStatus(int paramInt)
  {
    this.mHttpStatus = paramInt;
  }
  
  public Object remove(String paramString)
  {
    return this.mResult.remove(paramString);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     ra.genius.net.GBean
 * JD-Core Version:    0.7.0.1
 */