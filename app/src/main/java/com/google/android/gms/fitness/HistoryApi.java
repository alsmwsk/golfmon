package com.google.android.gms.fitness;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DataReadResult;
import com.google.android.gms.internal.jx;
import java.util.concurrent.TimeUnit;

public abstract interface HistoryApi
{
  public abstract PendingResult<Status> deleteData(GoogleApiClient paramGoogleApiClient, DataDeleteRequest paramDataDeleteRequest);
  
  public abstract PendingResult<Status> insertData(GoogleApiClient paramGoogleApiClient, DataSet paramDataSet);
  
  public abstract PendingResult<DataReadResult> readData(GoogleApiClient paramGoogleApiClient, DataReadRequest paramDataReadRequest);
  
  public static class ViewIntentBuilder
  {
    private long LW;
    private final DataType TM;
    private DataSource TN;
    private long TO;
    private String TP;
    private final Context mContext;
    
    public ViewIntentBuilder(Context paramContext, DataType paramDataType)
    {
      this.mContext = paramContext;
      this.TM = paramDataType;
    }
    
    private Intent i(Intent paramIntent)
    {
      if (this.TP == null) {}
      Intent localIntent;
      ResolveInfo localResolveInfo;
      do
      {
        return paramIntent;
        localIntent = new Intent(paramIntent).setPackage(this.TP);
        localResolveInfo = this.mContext.getPackageManager().resolveActivity(localIntent, 0);
      } while (localResolveInfo == null);
      String str = localResolveInfo.activityInfo.name;
      localIntent.setComponent(new ComponentName(this.TP, str));
      return localIntent;
    }
    
    public Intent build()
    {
      boolean bool1 = true;
      boolean bool2;
      if (this.LW > 0L)
      {
        bool2 = bool1;
        jx.a(bool2, "Start time must be set");
        if (this.TO <= this.LW) {
          break label105;
        }
      }
      for (;;)
      {
        jx.a(bool1, "End time must be set and after start time");
        Intent localIntent = new Intent("vnd.google.fitness.VIEW");
        localIntent.setType(DataType.getMimeType(this.TN.getDataType()));
        localIntent.putExtra("vnd.google.fitness.start_time", this.LW);
        localIntent.putExtra("vnd.google.fitness.end_time", this.TO);
        c.a(this.TN, localIntent, "vnd.google.fitness.data_source");
        return i(localIntent);
        bool2 = false;
        break;
        label105:
        bool1 = false;
      }
    }
    
    public ViewIntentBuilder setDataSource(DataSource paramDataSource)
    {
      boolean bool = paramDataSource.getDataType().equals(this.TM);
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramDataSource;
      arrayOfObject[1] = this.TM;
      jx.b(bool, "Data source %s is not for the data type %s", arrayOfObject);
      this.TN = paramDataSource;
      return this;
    }
    
    public ViewIntentBuilder setPreferredApplication(String paramString)
    {
      this.TP = paramString;
      return this;
    }
    
    public ViewIntentBuilder setTimeInterval(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      this.LW = paramTimeUnit.toMillis(paramLong1);
      this.TO = paramTimeUnit.toMillis(paramLong2);
      return this;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.HistoryApi
 * JD-Core Version:    0.7.0.1
 */