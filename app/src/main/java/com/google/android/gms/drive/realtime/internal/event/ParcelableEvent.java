package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ParcelableEvent
  implements SafeParcelable
{
  public static final Parcelable.Creator<ParcelableEvent> CREATOR = new b();
  final int CK;
  final String SJ;
  final String SM;
  final List<String> SQ;
  final boolean SR;
  final String SS;
  final TextInsertedDetails ST;
  final TextDeletedDetails SU;
  final ValuesAddedDetails SV;
  final ValuesRemovedDetails SW;
  final ValuesSetDetails SX;
  final ValueChangedDetails SY;
  final ReferenceShiftedDetails SZ;
  final ObjectChangedDetails Ta;
  final String vZ;
  
  ParcelableEvent(int paramInt, String paramString1, String paramString2, List<String> paramList, boolean paramBoolean, String paramString3, String paramString4, TextInsertedDetails paramTextInsertedDetails, TextDeletedDetails paramTextDeletedDetails, ValuesAddedDetails paramValuesAddedDetails, ValuesRemovedDetails paramValuesRemovedDetails, ValuesSetDetails paramValuesSetDetails, ValueChangedDetails paramValueChangedDetails, ReferenceShiftedDetails paramReferenceShiftedDetails, ObjectChangedDetails paramObjectChangedDetails)
  {
    this.CK = paramInt;
    this.vZ = paramString1;
    this.SJ = paramString2;
    this.SQ = paramList;
    this.SR = paramBoolean;
    this.SM = paramString3;
    this.SS = paramString4;
    this.ST = paramTextInsertedDetails;
    this.SU = paramTextDeletedDetails;
    this.SV = paramValuesAddedDetails;
    this.SW = paramValuesRemovedDetails;
    this.SX = paramValuesSetDetails;
    this.SY = paramValueChangedDetails;
    this.SZ = paramReferenceShiftedDetails;
    this.Ta = paramObjectChangedDetails;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.ParcelableEvent
 * JD-Core Version:    0.7.0.1
 */