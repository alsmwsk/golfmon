package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class UserAddressRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<UserAddressRequest> CREATOR = new a();
  private final int CK;
  List<CountrySpecification> afH;
  
  UserAddressRequest()
  {
    this.CK = 1;
  }
  
  UserAddressRequest(int paramInt, List<CountrySpecification> paramList)
  {
    this.CK = paramInt;
    this.afH = paramList;
  }
  
  public static Builder newBuilder()
  {
    UserAddressRequest localUserAddressRequest = new UserAddressRequest();
    localUserAddressRequest.getClass();
    return new Builder(null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return this.CK;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
  
  public final class Builder
  {
    private Builder() {}
    
    public Builder addAllowedCountrySpecification(CountrySpecification paramCountrySpecification)
    {
      if (UserAddressRequest.this.afH == null) {
        UserAddressRequest.this.afH = new ArrayList();
      }
      UserAddressRequest.this.afH.add(paramCountrySpecification);
      return this;
    }
    
    public Builder addAllowedCountrySpecifications(Collection<CountrySpecification> paramCollection)
    {
      if (UserAddressRequest.this.afH == null) {
        UserAddressRequest.this.afH = new ArrayList();
      }
      UserAddressRequest.this.afH.addAll(paramCollection);
      return this;
    }
    
    public UserAddressRequest build()
    {
      if (UserAddressRequest.this.afH != null) {
        UserAddressRequest.this.afH = Collections.unmodifiableList(UserAddressRequest.this.afH);
      }
      return UserAddressRequest.this;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.identity.intents.UserAddressRequest
 * JD-Core Version:    0.7.0.1
 */