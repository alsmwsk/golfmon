package com.google.android.gms.appindexing;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.internal.jx;

public final class Action
  extends Thing
{
  public static final String TYPE_ADD = "http://schema.org/AddAction";
  public static final String TYPE_BOOKMARK = "http://schema.org/BookmarkAction";
  public static final String TYPE_LIKE = "http://schema.org/LikeAction";
  public static final String TYPE_LISTEN = "http://schema.org/ListenAction";
  public static final String TYPE_VIEW = "http://schema.org/ViewAction";
  public static final String TYPE_WANT = "http://schema.org/WantAction";
  public static final String TYPE_WATCH = "http://schema.org/WatchAction";
  
  private Action(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public static Action newAction(String paramString1, String paramString2, Uri paramUri)
  {
    return newAction(paramString1, paramString2, null, paramUri);
  }
  
  public static Action newAction(String paramString1, String paramString2, Uri paramUri1, Uri paramUri2)
  {
    Builder localBuilder = new Builder(paramString1);
    Thing.Builder localBuilder1 = new Thing.Builder().setName(paramString2);
    if (paramUri1 == null) {}
    for (String str = null;; str = paramUri1.toString()) {
      return localBuilder.setObject(localBuilder1.setId(str).setUrl(paramUri2).build()).build();
    }
  }
  
  public static final class Builder
    extends Thing.Builder
  {
    public Builder(String paramString)
    {
      jx.i(paramString);
      super.put("type", paramString);
    }
    
    public Action build()
    {
      jx.b(this.DJ.get("object"), "setObject is required before calling build().");
      jx.b(this.DJ.get("type"), "setType is required before calling build().");
      Bundle localBundle = (Bundle)this.DJ.getParcelable("object");
      jx.b(localBundle.get("name"), "Must call setObject() with a valid name. Example: setObject(new Thing.Builder().setName(name).setUrl(url))");
      jx.b(localBundle.get("url"), "Must call setObject() with a valid app url. Example: setObject(new Thing.Builder().setName(name).setUrl(url))");
      return new Action(this.DJ, null);
    }
    
    public Builder put(String paramString, Thing paramThing)
    {
      return (Builder)super.put(paramString, paramThing);
    }
    
    public Builder put(String paramString1, String paramString2)
    {
      return (Builder)super.put(paramString1, paramString2);
    }
    
    public Builder setName(String paramString)
    {
      return (Builder)super.put("name", paramString);
    }
    
    public Builder setObject(Thing paramThing)
    {
      jx.i(paramThing);
      return (Builder)super.put("object", paramThing);
    }
    
    public Builder setUrl(Uri paramUri)
    {
      if (paramUri != null) {
        super.put("url", paramUri.toString());
      }
      return this;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.appindexing.Action
 * JD-Core Version:    0.7.0.1
 */