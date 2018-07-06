package com.kakao;

import com.kakao.internal.Action;
import com.kakao.internal.KakaoTalkLinkProtocol;
import com.kakao.internal.LinkObject;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;

public class KakaoTalkLinkMessageBuilder
{
  private final String appKey;
  private final String appVer;
  private final AtomicInteger buttonType;
  private final String extra;
  private final AtomicInteger imageType;
  private final List<LinkObject> linkObjList;
  private final AtomicInteger linkType;
  private final AtomicInteger textType;
  
  KakaoTalkLinkMessageBuilder(String paramString1, String paramString2, String paramString3)
  {
    this.appKey = paramString1;
    this.appVer = paramString2;
    this.extra = paramString3;
    this.textType = new AtomicInteger(0);
    this.imageType = new AtomicInteger(0);
    this.buttonType = new AtomicInteger(0);
    this.linkType = new AtomicInteger(0);
    this.linkObjList = new ArrayList();
  }
  
  public KakaoTalkLinkMessageBuilder addAppButton(String paramString)
    throws KakaoParameterException
  {
    addAppButton(paramString, Action.newActionApp(null, null));
    return this;
  }
  
  public KakaoTalkLinkMessageBuilder addAppButton(String paramString, Action paramAction)
    throws KakaoParameterException
  {
    if (this.buttonType.getAndIncrement() == 1) {
      throw new KakaoParameterException(KakaoParameterException.ERROR_CODE.DUPLICATE_OBJECTS_USED, "buttonType already added. each type can be added once, at most.");
    }
    LinkObject localLinkObject = LinkObject.newButton(paramString, paramAction);
    this.linkObjList.add(localLinkObject);
    return this;
  }
  
  public KakaoTalkLinkMessageBuilder addAppLink(String paramString)
    throws KakaoParameterException
  {
    addAppLink(paramString, Action.newActionApp(null, null));
    return this;
  }
  
  public KakaoTalkLinkMessageBuilder addAppLink(String paramString, Action paramAction)
    throws KakaoParameterException
  {
    if (this.linkType.getAndIncrement() == 1) {
      throw new KakaoParameterException(KakaoParameterException.ERROR_CODE.DUPLICATE_OBJECTS_USED, "linkType already added. each type can be added once, at most.");
    }
    LinkObject localLinkObject = LinkObject.newLink(paramString, paramAction);
    this.linkObjList.add(localLinkObject);
    return this;
  }
  
  public KakaoTalkLinkMessageBuilder addImage(String paramString, int paramInt1, int paramInt2)
    throws KakaoParameterException
  {
    if (this.imageType.getAndIncrement() == 1) {
      throw new KakaoParameterException(KakaoParameterException.ERROR_CODE.DUPLICATE_OBJECTS_USED, "imageType already added. each type can be added once, at most.");
    }
    LinkObject localLinkObject = LinkObject.newImage(paramString, paramInt1, paramInt2);
    this.linkObjList.add(localLinkObject);
    return this;
  }
  
  public KakaoTalkLinkMessageBuilder addText(String paramString)
    throws KakaoParameterException
  {
    if (this.textType.getAndIncrement() == 1) {
      throw new KakaoParameterException(KakaoParameterException.ERROR_CODE.DUPLICATE_OBJECTS_USED, "textType already added. each type can be added once, at most.");
    }
    LinkObject localLinkObject = LinkObject.newText(paramString);
    this.linkObjList.add(localLinkObject);
    return this;
  }
  
  public KakaoTalkLinkMessageBuilder addWebButton(String paramString)
    throws KakaoParameterException
  {
    addWebButton(paramString, null);
    return this;
  }
  
  public KakaoTalkLinkMessageBuilder addWebButton(String paramString1, String paramString2)
    throws KakaoParameterException
  {
    if (this.buttonType.getAndIncrement() == 1) {
      throw new KakaoParameterException(KakaoParameterException.ERROR_CODE.DUPLICATE_OBJECTS_USED, "buttonType already added. each type can be added once, at most.");
    }
    LinkObject localLinkObject = LinkObject.newButton(paramString1, Action.newActionWeb(paramString2));
    this.linkObjList.add(localLinkObject);
    return this;
  }
  
  public KakaoTalkLinkMessageBuilder addWebLink(String paramString)
    throws KakaoParameterException
  {
    addWebLink(paramString, null);
    return this;
  }
  
  public KakaoTalkLinkMessageBuilder addWebLink(String paramString1, String paramString2)
    throws KakaoParameterException
  {
    if (this.linkType.getAndIncrement() == 1) {
      throw new KakaoParameterException(KakaoParameterException.ERROR_CODE.DUPLICATE_OBJECTS_USED, "linkType already added. each type can be added once, at most.");
    }
    LinkObject localLinkObject = LinkObject.newLink(paramString1, Action.newActionWeb(paramString2));
    this.linkObjList.add(localLinkObject);
    return this;
  }
  
  public String build()
    throws KakaoParameterException
  {
    try
    {
      if (this.linkObjList.isEmpty()) {
        throw new KakaoParameterException(KakaoParameterException.ERROR_CODE.CORE_PARAMETER_MISSING, "call addAppLink or addWebLink or addAppButton or addWebButton or addText or addImage before calling build().");
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new KakaoParameterException(KakaoParameterException.ERROR_CODE.UNSUPPORTED_ENCODING, localUnsupportedEncodingException);
      StringBuilder localStringBuilder = new StringBuilder("kakaolink://send").append("?");
      localStringBuilder.append("linkver").append("=").append(URLEncoder.encode("3.5", KakaoTalkLinkProtocol.ENCODING)).append("&");
      localStringBuilder.append("apiver").append("=").append(URLEncoder.encode("3.0", KakaoTalkLinkProtocol.ENCODING)).append("&");
      localStringBuilder.append("appkey").append("=").append(URLEncoder.encode(this.appKey, KakaoTalkLinkProtocol.ENCODING)).append("&");
      localStringBuilder.append("appver").append("=").append(URLEncoder.encode(this.appVer, KakaoTalkLinkProtocol.ENCODING)).append("&");
      localStringBuilder.append("extras").append("=").append(URLEncoder.encode(this.extra, KakaoTalkLinkProtocol.ENCODING)).append("&");
      localStringBuilder.append("objs").append("=");
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.linkObjList.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return URLEncoder.encode(localJSONArray.toString(), KakaoTalkLinkProtocol.ENCODING);
        }
        localJSONArray.put(((LinkObject)localIterator.next()).createJSONObject());
      }
    }
    catch (JSONException localJSONException)
    {
      throw new KakaoParameterException(KakaoParameterException.ERROR_CODE.JSON_PARSING_ERROR, localJSONException);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.kakao.KakaoTalkLinkMessageBuilder
 * JD-Core Version:    0.7.0.1
 */