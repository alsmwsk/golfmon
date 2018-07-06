package com.google.android.gms.internal;

public enum ii
{
  public static String Fk = "Error";
  public static String Fl = "status";
  private final String Fm;
  
  static
  {
    EA = new ii("SERVICE_DISABLED", 9, "ServiceDisabled");
    EB = new ii("SERVICE_UNAVAILABLE", 10, "ServiceUnavailable");
    EC = new ii("CAPTCHA", 11, "CaptchaRequired");
    ED = new ii("NETWORK_ERROR", 12, "NetworkError");
    EE = new ii("USER_CANCEL", 13, "UserCancel");
    EF = new ii("PERMISSION_DENIED", 14, "PermissionDenied");
    EG = new ii("DEVICE_MANAGEMENT_REQUIRED", 15, "DeviceManagementRequiredOrSyncDisabled");
    EH = new ii("DM_INTERNAL_ERROR", 16, "DeviceManagementInternalError");
    EI = new ii("DM_SYNC_DISABLED", 17, "DeviceManagementSyncDisabled");
    EJ = new ii("DM_ADMIN_BLOCKED", 18, "DeviceManagementAdminBlocked");
    EK = new ii("DM_ADMIN_PENDING_APPROVAL", 19, "DeviceManagementAdminPendingApproval");
    EL = new ii("DM_STALE_SYNC_REQUIRED", 20, "DeviceManagementStaleSyncRequired");
    EM = new ii("DM_DEACTIVATED", 21, "DeviceManagementDeactivated");
    EN = new ii("DM_REQUIRED", 22, "DeviceManagementRequired");
    EO = new ii("CLIENT_LOGIN_DISABLED", 23, "ClientLoginDisabled");
    EP = new ii("NEED_PERMISSION", 24, "NeedPermission");
    EQ = new ii("BAD_PASSWORD", 25, "WeakPassword");
    ER = new ii("ALREADY_HAS_GMAIL", 26, "ALREADY_HAS_GMAIL");
    ES = new ii("BAD_REQUEST", 27, "BadRequest");
    ET = new ii("BAD_USERNAME", 28, "BadUsername");
    EU = new ii("LOGIN_FAIL", 29, "LoginFail");
    EV = new ii("NOT_LOGGED_IN", 30, "NotLoggedIn");
    EW = new ii("NO_GMAIL", 31, "NoGmail");
    EX = new ii("REQUEST_DENIED", 32, "RequestDenied");
    EY = new ii("SERVER_ERROR", 33, "ServerError");
    EZ = new ii("USERNAME_UNAVAILABLE", 34, "UsernameUnavailable");
    Fa = new ii("DELETED_GMAIL", 35, "DeletedGmail");
    Fb = new ii("SOCKET_TIMEOUT", 36, "SocketTimeout");
    Fc = new ii("EXISTING_USERNAME", 37, "ExistingUsername");
    Fd = new ii("NEEDS_BROWSER", 38, "NeedsBrowser");
    Fe = new ii("GPLUS_OTHER", 39, "GPlusOther");
    Ff = new ii("GPLUS_NICKNAME", 40, "GPlusNickname");
    Fg = new ii("GPLUS_INVALID_CHAR", 41, "GPlusInvalidChar");
    Fh = new ii("GPLUS_INTERSTITIAL", 42, "GPlusInterstitial");
    Fi = new ii("GPLUS_PROFILE_ERROR", 43, "ProfileUpgradeError");
    Fj = new ii("INVALID_SCOPE", 44, "INVALID_SCOPE");
    ii[] arrayOfii = new ii[45];
    arrayOfii[0] = Er;
    arrayOfii[1] = Es;
    arrayOfii[2] = Et;
    arrayOfii[3] = Eu;
    arrayOfii[4] = Ev;
    arrayOfii[5] = Ew;
    arrayOfii[6] = Ex;
    arrayOfii[7] = Ey;
    arrayOfii[8] = Ez;
    arrayOfii[9] = EA;
    arrayOfii[10] = EB;
    arrayOfii[11] = EC;
    arrayOfii[12] = ED;
    arrayOfii[13] = EE;
    arrayOfii[14] = EF;
    arrayOfii[15] = EG;
    arrayOfii[16] = EH;
    arrayOfii[17] = EI;
    arrayOfii[18] = EJ;
    arrayOfii[19] = EK;
    arrayOfii[20] = EL;
    arrayOfii[21] = EM;
    arrayOfii[22] = EN;
    arrayOfii[23] = EO;
    arrayOfii[24] = EP;
    arrayOfii[25] = EQ;
    arrayOfii[26] = ER;
    arrayOfii[27] = ES;
    arrayOfii[28] = ET;
    arrayOfii[29] = EU;
    arrayOfii[30] = EV;
    arrayOfii[31] = EW;
    arrayOfii[32] = EX;
    arrayOfii[33] = EY;
    arrayOfii[34] = EZ;
    arrayOfii[35] = Fa;
    arrayOfii[36] = Fb;
    arrayOfii[37] = Fc;
    arrayOfii[38] = Fd;
    arrayOfii[39] = Fe;
    arrayOfii[40] = Ff;
    arrayOfii[41] = Fg;
    arrayOfii[42] = Fh;
    arrayOfii[43] = Fi;
    arrayOfii[44] = Fj;
    Fn = arrayOfii;
  }
  
  private ii(String paramString)
  {
    this.Fm = paramString;
  }
  
  public String fO()
  {
    return this.Fm;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ii
 * JD-Core Version:    0.7.0.1
 */