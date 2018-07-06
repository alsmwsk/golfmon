package com.google.android.gms.analytics;

import java.util.SortedSet;
import java.util.TreeSet;

class y
{
  private static final y zV = new y();
  private SortedSet<a> zS = new TreeSet();
  private StringBuilder zT = new StringBuilder();
  private boolean zU = false;
  
  public static y eK()
  {
    return zV;
  }
  
  public void D(boolean paramBoolean)
  {
    try
    {
      this.zU = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(a parama)
  {
    try
    {
      if (!this.zU)
      {
        this.zS.add(parama);
        this.zT.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(parama.ordinal()));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String eL()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 6;
      int j = 0;
      while (this.zS.size() > 0)
      {
        a locala = (a)this.zS.first();
        this.zS.remove(locala);
        int k = locala.ordinal();
        while (k >= i)
        {
          localStringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(j));
          i += 6;
          j = 0;
        }
        j += (1 << locala.ordinal() % 6);
      }
      if ((j > 0) || (localStringBuilder.length() == 0)) {
        localStringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(j));
      }
      this.zS.clear();
      String str = localStringBuilder.toString();
      return str;
    }
    finally {}
  }
  
  public String eM()
  {
    try
    {
      if (this.zT.length() > 0) {
        this.zT.insert(0, ".");
      }
      String str = this.zT.toString();
      this.zT = new StringBuilder();
      return str;
    }
    finally {}
  }
  
  public static enum a
  {
    static
    {
      Aa = new a("BLANK_04", 4);
      Ab = new a("BLANK_05", 5);
      Ac = new a("BLANK_06", 6);
      Ad = new a("BLANK_07", 7);
      Ae = new a("BLANK_08", 8);
      Af = new a("GET", 9);
      Ag = new a("SET", 10);
      Ah = new a("SEND", 11);
      Ai = new a("BLANK_12", 12);
      Aj = new a("BLANK_13", 13);
      Ak = new a("BLANK_14", 14);
      Al = new a("BLANK_15", 15);
      Am = new a("BLANK_16", 16);
      An = new a("BLANK_17", 17);
      Ao = new a("BLANK_18", 18);
      Ap = new a("BLANK_19", 19);
      Aq = new a("BLANK_20", 20);
      Ar = new a("BLANK_21", 21);
      As = new a("BLANK_22", 22);
      At = new a("BLANK_23", 23);
      Au = new a("BLANK_24", 24);
      Av = new a("BLANK_25", 25);
      Aw = new a("BLANK_26", 26);
      Ax = new a("BLANK_27", 27);
      Ay = new a("BLANK_28", 28);
      Az = new a("BLANK_29", 29);
      AA = new a("SET_EXCEPTION_PARSER", 30);
      AB = new a("GET_EXCEPTION_PARSER", 31);
      AC = new a("CONSTRUCT_TRANSACTION", 32);
      AD = new a("CONSTRUCT_EXCEPTION", 33);
      AE = new a("CONSTRUCT_RAW_EXCEPTION", 34);
      AF = new a("CONSTRUCT_TIMING", 35);
      AG = new a("CONSTRUCT_SOCIAL", 36);
      AH = new a("BLANK_37", 37);
      AI = new a("BLANK_38", 38);
      AJ = new a("GET_TRACKER", 39);
      AK = new a("GET_DEFAULT_TRACKER", 40);
      AL = new a("SET_DEFAULT_TRACKER", 41);
      AM = new a("SET_APP_OPT_OUT", 42);
      AN = new a("GET_APP_OPT_OUT", 43);
      AO = new a("DISPATCH", 44);
      AP = new a("SET_DISPATCH_PERIOD", 45);
      AQ = new a("BLANK_46", 46);
      AR = new a("REPORT_UNCAUGHT_EXCEPTIONS", 47);
      AS = new a("SET_AUTO_ACTIVITY_TRACKING", 48);
      AT = new a("SET_SESSION_TIMEOUT", 49);
      AU = new a("CONSTRUCT_EVENT", 50);
      AV = new a("CONSTRUCT_ITEM", 51);
      AW = new a("BLANK_52", 52);
      AX = new a("BLANK_53", 53);
      AY = new a("SET_DRY_RUN", 54);
      AZ = new a("GET_DRY_RUN", 55);
      Ba = new a("SET_LOGGER", 56);
      Bb = new a("SET_FORCE_LOCAL_DISPATCH", 57);
      Bc = new a("GET_TRACKER_NAME", 58);
      Bd = new a("CLOSE_TRACKER", 59);
      Be = new a("EASY_TRACKER_ACTIVITY_START", 60);
      Bf = new a("EASY_TRACKER_ACTIVITY_STOP", 61);
      Bg = new a("CONSTRUCT_APP_VIEW", 62);
      a[] arrayOfa = new a[63];
      arrayOfa[0] = zW;
      arrayOfa[1] = zX;
      arrayOfa[2] = zY;
      arrayOfa[3] = zZ;
      arrayOfa[4] = Aa;
      arrayOfa[5] = Ab;
      arrayOfa[6] = Ac;
      arrayOfa[7] = Ad;
      arrayOfa[8] = Ae;
      arrayOfa[9] = Af;
      arrayOfa[10] = Ag;
      arrayOfa[11] = Ah;
      arrayOfa[12] = Ai;
      arrayOfa[13] = Aj;
      arrayOfa[14] = Ak;
      arrayOfa[15] = Al;
      arrayOfa[16] = Am;
      arrayOfa[17] = An;
      arrayOfa[18] = Ao;
      arrayOfa[19] = Ap;
      arrayOfa[20] = Aq;
      arrayOfa[21] = Ar;
      arrayOfa[22] = As;
      arrayOfa[23] = At;
      arrayOfa[24] = Au;
      arrayOfa[25] = Av;
      arrayOfa[26] = Aw;
      arrayOfa[27] = Ax;
      arrayOfa[28] = Ay;
      arrayOfa[29] = Az;
      arrayOfa[30] = AA;
      arrayOfa[31] = AB;
      arrayOfa[32] = AC;
      arrayOfa[33] = AD;
      arrayOfa[34] = AE;
      arrayOfa[35] = AF;
      arrayOfa[36] = AG;
      arrayOfa[37] = AH;
      arrayOfa[38] = AI;
      arrayOfa[39] = AJ;
      arrayOfa[40] = AK;
      arrayOfa[41] = AL;
      arrayOfa[42] = AM;
      arrayOfa[43] = AN;
      arrayOfa[44] = AO;
      arrayOfa[45] = AP;
      arrayOfa[46] = AQ;
      arrayOfa[47] = AR;
      arrayOfa[48] = AS;
      arrayOfa[49] = AT;
      arrayOfa[50] = AU;
      arrayOfa[51] = AV;
      arrayOfa[52] = AW;
      arrayOfa[53] = AX;
      arrayOfa[54] = AY;
      arrayOfa[55] = AZ;
      arrayOfa[56] = Ba;
      arrayOfa[57] = Bb;
      arrayOfa[58] = Bc;
      arrayOfa[59] = Bd;
      arrayOfa[60] = Be;
      arrayOfa[61] = Bf;
      arrayOfa[62] = Bg;
      Bh = arrayOfa;
    }
    
    private a() {}
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.y
 * JD-Core Version:    0.7.0.1
 */