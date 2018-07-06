package com.appg.golfmon.atv;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.TextView;
import com.appg.golfmon.util.Alert;
import com.appg.golfmon.util.FormatUtil;
import com.appg.golfmon.util.JSONUtil;
import com.appg.golfmon.util.ListenerUtil;
import com.appg.golfmon.util.LogUtil;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import org.json.JSONObject;

public class AtvMapShow
  extends FragmentActivity
{
  public static final int REQ_CODE = 1596;
  private LatLng mBasePoint = null;
  private JSONObject mGolfInfo = null;
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
    localMarkerOptions.title(JSONUtil.getString(this.mGolfInfo, "address", ""));
    this.mMap.addMarker(localMarkerOptions);
  }
  
  private void configureListener()
  {
    this.mTxtTopTitleLeftBack.setOnClickListener(ListenerUtil.getFinishButtonListener(this));
  }
  
  private void findView()
  {
    this.mTxtTopTitleLeftBack = ((TextView)findViewById(2131361851));
  }
  
  private void init()
  {
    this.mTxtTopTitleLeftBack.setVisibility(0);
    this.mTxtTopTitleLeftBack.setText(JSONUtil.getString(this.mGolfInfo, "name", ""));
    this.mLatitude = JSONUtil.getInteger(this.mGolfInfo, "latitude", 0);
    this.mLongitude = JSONUtil.getInteger(this.mGolfInfo, "longitude", 0);
    initMap();
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
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903057);
    this.mGolfInfo = JSONUtil.createObject(getIntent(), "EXTRAS_JSON_STRING");
    if (FormatUtil.isNullorEmpty(this.mGolfInfo))
    {
      Alert.toastShort(this, "다시 시도해 주세요.");
      finish();
      return;
    }
    findView();
    init();
    configureListener();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.atv.AtvMapShow
 * JD-Core Version:    0.7.0.1
 */