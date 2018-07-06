package ra.genius.net.http;

public class GParam
{
  private String mName = "";
  private Object mValue = null;
  
  public String getName()
  {
    return this.mName;
  }
  
  public Object getValue()
  {
    return this.mValue;
  }
  
  public void set(String paramString, Object paramObject)
  {
    setName(paramString);
    setValue(paramObject);
  }
  
  public void setName(String paramString)
  {
    this.mName = paramString;
  }
  
  public void setValue(Object paramObject)
  {
    this.mValue = paramObject;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     ra.genius.net.http.GParam
 * JD-Core Version:    0.7.0.1
 */