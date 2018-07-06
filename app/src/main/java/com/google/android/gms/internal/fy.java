package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@ey
public final class fy
{
  public final int errorCode;
  public final int orientation;
  public final long qA;
  public final cq qP;
  public final cz qQ;
  public final String qR;
  public final ct qS;
  public final List<String> qw;
  public final List<String> qx;
  public final gu se;
  public final av tL;
  public final String tO;
  public final long tV;
  public final boolean tW;
  public final long tX;
  public final List<String> tY;
  public final String ub;
  public final JSONObject vD;
  public final cr vE;
  public final ay vF;
  public final long vG;
  public final long vH;
  public final bv.a vI;
  
  public fy(av paramav, gu paramgu, List<String> paramList1, int paramInt1, List<String> paramList2, List<String> paramList3, int paramInt2, long paramLong1, String paramString1, boolean paramBoolean, cq paramcq, cz paramcz, String paramString2, cr paramcr, ct paramct, long paramLong2, ay paramay, long paramLong3, long paramLong4, long paramLong5, String paramString3, JSONObject paramJSONObject, bv.a parama)
  {
    this.tL = paramav;
    this.se = paramgu;
    List localList1;
    List localList2;
    if (paramList1 != null)
    {
      localList1 = Collections.unmodifiableList(paramList1);
      this.qw = localList1;
      this.errorCode = paramInt1;
      if (paramList2 == null) {
        break label181;
      }
      localList2 = Collections.unmodifiableList(paramList2);
      label48:
      this.qx = localList2;
      if (paramList3 == null) {
        break label187;
      }
    }
    label181:
    label187:
    for (List localList3 = Collections.unmodifiableList(paramList3);; localList3 = null)
    {
      this.tY = localList3;
      this.orientation = paramInt2;
      this.qA = paramLong1;
      this.tO = paramString1;
      this.tW = paramBoolean;
      this.qP = paramcq;
      this.qQ = paramcz;
      this.qR = paramString2;
      this.vE = paramcr;
      this.qS = paramct;
      this.tX = paramLong2;
      this.vF = paramay;
      this.tV = paramLong3;
      this.vG = paramLong4;
      this.vH = paramLong5;
      this.ub = paramString3;
      this.vD = paramJSONObject;
      this.vI = parama;
      return;
      localList1 = null;
      break;
      localList2 = null;
      break label48;
    }
  }
  
  public fy(a parama, gu paramgu, cq paramcq, cz paramcz, String paramString, ct paramct, bv.a parama1)
  {
    this(parama.vJ.tL, paramgu, parama.vK.qw, parama.errorCode, parama.vK.qx, parama.vK.tY, parama.vK.orientation, parama.vK.qA, parama.vJ.tO, parama.vK.tW, paramcq, paramcz, paramString, parama.vE, paramct, parama.vK.tX, parama.lS, parama.vK.tV, parama.vG, parama.vH, parama.vK.ub, parama.vD, parama1);
  }
  
  @ey
  public static final class a
  {
    public final int errorCode;
    public final ay lS;
    public final JSONObject vD;
    public final cr vE;
    public final long vG;
    public final long vH;
    public final fh vJ;
    public final fj vK;
    
    public a(fh paramfh, fj paramfj, cr paramcr, ay paramay, int paramInt, long paramLong1, long paramLong2, JSONObject paramJSONObject)
    {
      this.vJ = paramfh;
      this.vK = paramfj;
      this.vE = paramcr;
      this.lS = paramay;
      this.errorCode = paramInt;
      this.vG = paramLong1;
      this.vH = paramLong2;
      this.vD = paramJSONObject;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fy
 * JD-Core Version:    0.7.0.1
 */