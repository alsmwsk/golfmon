package com.appg.golfmon.atv;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.TextView;
import com.appg.golfmon.GMApp;
import com.appg.golfmon.net.http.GFailedHandler;
import com.appg.golfmon.net.http.GJSONDecoder;
import com.appg.golfmon.net.http.GPClient;
import com.appg.golfmon.net.http.GResultHandler;
import com.appg.golfmon.util.Alert;
import com.appg.golfmon.util.Alert.OnCloseListener;
import com.appg.golfmon.util.JSONUtil;
import com.appg.golfmon.util.LogUtil;
import com.appg.golfmon.util.SPUtil;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import org.json.JSONArray;
import org.json.JSONObject;
import ra.genius.net.GBean;
import ra.genius.net.GExecutor;

public class AtvMapSelect
  extends FragmentActivity
{
  public static final int REQ_CODE = 1596;
  private GMApp mApp = null;
  private LatLng mBasePoint = null;
  private int mLatitude = 0;
  private int mLongitude = 0;
  private GoogleMap mMap = null;
  private TextView mTxtTopTitleLeftBack = null;
  
  private void addMarker(LatLng paramLatLng, int paramInt)
  {
    if (this.mMap == null) {
      return;
    }
    MarkerOptions localMarkerOptions = new MarkerOptions();
    localMarkerOptions.icon(BitmapDescriptorFactory.fromResource(paramInt));
    localMarkerOptions.position(paramLatLng);
    this.mMap.addMarker(localMarkerOptions);
  }
  
  private void configureListener() {}
  
  private void findView()
  {
    this.mTxtTopTitleLeftBack = ((TextView)findViewById(2131361851));
  }
  
  private Context getContext()
  {
    return this;
  }
  
  private void init()
  {
    this.mApp = ((GMApp)getApplication());
    this.mTxtTopTitleLeftBack.setVisibility(0);
    this.mTxtTopTitleLeftBack.setText("위치설정");
    int[] arrayOfInt;
    if (SPUtil.getInstance().getAgreeLocation(this))
    {
      arrayOfInt = this.mApp.getGeoPoint(this.mApp.getLocationType());
      this.mLatitude = arrayOfInt[0];
    }
    for (this.mLongitude = arrayOfInt[1];; this.mLongitude = 126978500)
    {
      initMap();
      return;
      this.mLatitude = 37565909;
    }
  }
  
  private void initMap()
  {
    if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(this) != 0)
    {
      LogUtil.e("GooglePlayServicesUtil.isGooglePlayServicesAvailable(this):" + GooglePlayServicesUtil.isGooglePlayServicesAvailable(this));
      return;
    }
    if (this.mMap == null)
    {
      this.mMap = ((SupportMapFragment)getSupportFragmentManager().findFragmentById(2131361918)).getMap();
      this.mMap.getUiSettings().setZoomControlsEnabled(true);
      this.mMap.getUiSettings().setRotateGesturesEnabled(false);
      this.mMap.getUiSettings().setCompassEnabled(false);
      this.mMap.getUiSettings().setTiltGesturesEnabled(false);
      this.mMap.getUiSettings().setScrollGesturesEnabled(true);
      this.mMap.getUiSettings().setZoomGesturesEnabled(true);
    }
    this.mBasePoint = new LatLng(this.mLatitude / 1000000.0D, this.mLongitude / 1000000.0D);
    this.mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(this.mBasePoint, 15.0F));
    addMarker(this.mBasePoint, 2130837695);
    this.mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener()
    {
      public void onMapClick(LatLng paramAnonymousLatLng)
      {
        AtvMapSelect.this.addMarker(paramAnonymousLatLng, 2130837696);
        AtvMapSelect.this.callApi_getInfoOfAddressOfGeocode(paramAnonymousLatLng);
      }
    });
  }
  
  private void resetMarker()
  {
    if (this.mMap == null) {
      return;
    }
    this.mMap.clear();
    addMarker(this.mBasePoint, 2130837695);
  }
  
  public void callApi_getInfoOfAddressOfGeocode(final LatLng paramLatLng)
  {
    GPClient localGPClient = new GPClient(this);
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("Api.getInfoOfAddressOfGeocode");
    localGPClient.addParameter("lat", Integer.valueOf((int)(1000000.0D * paramLatLng.latitude)));
    localGPClient.addParameter("lng", Integer.valueOf((int)(1000000.0D * paramLatLng.longitude)));
    localGPClient.addProgress();
    localGPClient.setDecoder(new GJSONDecoder(2));
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        AtvMapSelect.this.resetMarker();
        Alert.toastLong(AtvMapSelect.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        final JSONArray localJSONArray = (JSONArray)paramAnonymousObject;
        String[] arrayOfString;
        String str;
        int i;
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          arrayOfString = new String[localJSONArray.length()];
          str = "";
          i = 0;
          if (i >= arrayOfString.length)
          {
            Alert localAlert = new Alert();
            localAlert.setOnCloseListener(new Alert.OnCloseListener()
            {
              public void onClose(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int, Object paramAnonymous2Object)
              {
                if (1 == paramAnonymous2Int)
                {
                  AtvMapSelect.this.mApp.saveAddress(localJSONArray, 2);
                  AtvMapSelect.this.mApp.saveLocationType(2);
                  AtvMapSelect.this.mApp.saveLocation((int)(1000000.0D * this.val$point.latitude), (int)(1000000.0D * this.val$point.longitude), 2);
                  AtvMapSelect.this.setResult(-1);
                  AtvMapSelect.this.finish();
                  return;
                }
                AtvMapSelect.this.resetMarker();
              }
            });
            localAlert.showAlert(AtvMapSelect.this.getContext(), str + "로 설정 하시겠습니까?", true, new String[] { "확인", "취소" });
          }
        }
        for (;;)
        {
          return null;
          arrayOfString[i] = JSONUtil.getString(localJSONArray, i);
          if (str.length() > 0) {
            str = str + " ";
          }
          str = str + arrayOfString[i];
          i++;
          break;
          AtvMapSelect.this.resetMarker();
          Alert.toastLong(AtvMapSelect.this.getContext(), "해당위치의 주소를 찾을 수 없습니다. 다시 시도해 주세요.");
        }
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903057);
    findView();
    init();
    configureListener();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.atv.AtvMapSelect
 * JD-Core Version:    0.7.0.1
 */