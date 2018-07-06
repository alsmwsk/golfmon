package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public class fp
  implements fn.a<bu>
{
  public bu c(fn paramfn, JSONObject paramJSONObject)
    throws JSONException, InterruptedException, ExecutionException
  {
    Future localFuture1 = paramfn.a(paramJSONObject, "image", true);
    Future localFuture2 = paramfn.a(paramJSONObject, "secondary_image", false);
    return new bu(paramJSONObject.getString("headline"), (Drawable)localFuture1.get(), paramJSONObject.getString("body"), (Drawable)localFuture2.get(), paramJSONObject.getString("call_to_action"), paramJSONObject.getString("attribution"));
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fp
 * JD-Core Version:    0.7.0.1
 */