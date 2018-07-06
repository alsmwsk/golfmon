package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class pd
  extends ks
  implements ItemScope
{
  public static final pe CREATOR = new pe();
  private static final HashMap<String, kr.a<?, ?>> aom = new HashMap();
  String CE;
  final int CK;
  String UO;
  double agg;
  double agh;
  String aoA;
  pd aoB;
  String aoC;
  String aoD;
  List<pd> aoE;
  String aoF;
  String aoG;
  String aoH;
  String aoI;
  String aoJ;
  String aoK;
  String aoL;
  String aoM;
  pd aoN;
  String aoO;
  String aoP;
  String aoQ;
  pd aoR;
  pd aoS;
  pd aoT;
  List<pd> aoU;
  String aoV;
  String aoW;
  String aoX;
  String aoY;
  pd aoZ;
  final Set<Integer> aon;
  pd aoo;
  List<String> aop;
  pd aoq;
  String aor;
  String aos;
  String aot;
  List<pd> aou;
  int aov;
  List<pd> aow;
  pd aox;
  List<pd> aoy;
  String aoz;
  String apa;
  String apb;
  String apc;
  pd apd;
  String ape;
  String apf;
  String apg;
  String aph;
  String mName;
  String ov;
  String vc;
  String vf;
  
  static
  {
    aom.put("about", kr.a.a("about", 2, pd.class));
    aom.put("additionalName", kr.a.m("additionalName", 3));
    aom.put("address", kr.a.a("address", 4, pd.class));
    aom.put("addressCountry", kr.a.l("addressCountry", 5));
    aom.put("addressLocality", kr.a.l("addressLocality", 6));
    aom.put("addressRegion", kr.a.l("addressRegion", 7));
    aom.put("associated_media", kr.a.b("associated_media", 8, pd.class));
    aom.put("attendeeCount", kr.a.i("attendeeCount", 9));
    aom.put("attendees", kr.a.b("attendees", 10, pd.class));
    aom.put("audio", kr.a.a("audio", 11, pd.class));
    aom.put("author", kr.a.b("author", 12, pd.class));
    aom.put("bestRating", kr.a.l("bestRating", 13));
    aom.put("birthDate", kr.a.l("birthDate", 14));
    aom.put("byArtist", kr.a.a("byArtist", 15, pd.class));
    aom.put("caption", kr.a.l("caption", 16));
    aom.put("contentSize", kr.a.l("contentSize", 17));
    aom.put("contentUrl", kr.a.l("contentUrl", 18));
    aom.put("contributor", kr.a.b("contributor", 19, pd.class));
    aom.put("dateCreated", kr.a.l("dateCreated", 20));
    aom.put("dateModified", kr.a.l("dateModified", 21));
    aom.put("datePublished", kr.a.l("datePublished", 22));
    aom.put("description", kr.a.l("description", 23));
    aom.put("duration", kr.a.l("duration", 24));
    aom.put("embedUrl", kr.a.l("embedUrl", 25));
    aom.put("endDate", kr.a.l("endDate", 26));
    aom.put("familyName", kr.a.l("familyName", 27));
    aom.put("gender", kr.a.l("gender", 28));
    aom.put("geo", kr.a.a("geo", 29, pd.class));
    aom.put("givenName", kr.a.l("givenName", 30));
    aom.put("height", kr.a.l("height", 31));
    aom.put("id", kr.a.l("id", 32));
    aom.put("image", kr.a.l("image", 33));
    aom.put("inAlbum", kr.a.a("inAlbum", 34, pd.class));
    aom.put("latitude", kr.a.j("latitude", 36));
    aom.put("location", kr.a.a("location", 37, pd.class));
    aom.put("longitude", kr.a.j("longitude", 38));
    aom.put("name", kr.a.l("name", 39));
    aom.put("partOfTVSeries", kr.a.a("partOfTVSeries", 40, pd.class));
    aom.put("performers", kr.a.b("performers", 41, pd.class));
    aom.put("playerType", kr.a.l("playerType", 42));
    aom.put("postOfficeBoxNumber", kr.a.l("postOfficeBoxNumber", 43));
    aom.put("postalCode", kr.a.l("postalCode", 44));
    aom.put("ratingValue", kr.a.l("ratingValue", 45));
    aom.put("reviewRating", kr.a.a("reviewRating", 46, pd.class));
    aom.put("startDate", kr.a.l("startDate", 47));
    aom.put("streetAddress", kr.a.l("streetAddress", 48));
    aom.put("text", kr.a.l("text", 49));
    aom.put("thumbnail", kr.a.a("thumbnail", 50, pd.class));
    aom.put("thumbnailUrl", kr.a.l("thumbnailUrl", 51));
    aom.put("tickerSymbol", kr.a.l("tickerSymbol", 52));
    aom.put("type", kr.a.l("type", 53));
    aom.put("url", kr.a.l("url", 54));
    aom.put("width", kr.a.l("width", 55));
    aom.put("worstRating", kr.a.l("worstRating", 56));
  }
  
  public pd()
  {
    this.CK = 1;
    this.aon = new HashSet();
  }
  
  pd(Set<Integer> paramSet, int paramInt1, pd parampd1, List<String> paramList, pd parampd2, String paramString1, String paramString2, String paramString3, List<pd> paramList1, int paramInt2, List<pd> paramList2, pd parampd3, List<pd> paramList3, String paramString4, String paramString5, pd parampd4, String paramString6, String paramString7, String paramString8, List<pd> paramList4, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, pd parampd5, String paramString18, String paramString19, String paramString20, String paramString21, pd parampd6, double paramDouble1, pd parampd7, double paramDouble2, String paramString22, pd parampd8, List<pd> paramList5, String paramString23, String paramString24, String paramString25, String paramString26, pd parampd9, String paramString27, String paramString28, String paramString29, pd parampd10, String paramString30, String paramString31, String paramString32, String paramString33, String paramString34, String paramString35)
  {
    this.aon = paramSet;
    this.CK = paramInt1;
    this.aoo = parampd1;
    this.aop = paramList;
    this.aoq = parampd2;
    this.aor = paramString1;
    this.aos = paramString2;
    this.aot = paramString3;
    this.aou = paramList1;
    this.aov = paramInt2;
    this.aow = paramList2;
    this.aox = parampd3;
    this.aoy = paramList3;
    this.aoz = paramString4;
    this.aoA = paramString5;
    this.aoB = parampd4;
    this.aoC = paramString6;
    this.aoD = paramString7;
    this.ov = paramString8;
    this.aoE = paramList4;
    this.aoF = paramString9;
    this.aoG = paramString10;
    this.aoH = paramString11;
    this.UO = paramString12;
    this.aoI = paramString13;
    this.aoJ = paramString14;
    this.aoK = paramString15;
    this.aoL = paramString16;
    this.aoM = paramString17;
    this.aoN = parampd5;
    this.aoO = paramString18;
    this.aoP = paramString19;
    this.CE = paramString20;
    this.aoQ = paramString21;
    this.aoR = parampd6;
    this.agg = paramDouble1;
    this.aoS = parampd7;
    this.agh = paramDouble2;
    this.mName = paramString22;
    this.aoT = parampd8;
    this.aoU = paramList5;
    this.aoV = paramString23;
    this.aoW = paramString24;
    this.aoX = paramString25;
    this.aoY = paramString26;
    this.aoZ = parampd9;
    this.apa = paramString27;
    this.apb = paramString28;
    this.apc = paramString29;
    this.apd = parampd10;
    this.ape = paramString30;
    this.apf = paramString31;
    this.vc = paramString32;
    this.vf = paramString33;
    this.apg = paramString34;
    this.aph = paramString35;
  }
  
  public pd(Set<Integer> paramSet, pd parampd1, List<String> paramList, pd parampd2, String paramString1, String paramString2, String paramString3, List<pd> paramList1, int paramInt, List<pd> paramList2, pd parampd3, List<pd> paramList3, String paramString4, String paramString5, pd parampd4, String paramString6, String paramString7, String paramString8, List<pd> paramList4, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, pd parampd5, String paramString18, String paramString19, String paramString20, String paramString21, pd parampd6, double paramDouble1, pd parampd7, double paramDouble2, String paramString22, pd parampd8, List<pd> paramList5, String paramString23, String paramString24, String paramString25, String paramString26, pd parampd9, String paramString27, String paramString28, String paramString29, pd parampd10, String paramString30, String paramString31, String paramString32, String paramString33, String paramString34, String paramString35)
  {
    this.aon = paramSet;
    this.CK = 1;
    this.aoo = parampd1;
    this.aop = paramList;
    this.aoq = parampd2;
    this.aor = paramString1;
    this.aos = paramString2;
    this.aot = paramString3;
    this.aou = paramList1;
    this.aov = paramInt;
    this.aow = paramList2;
    this.aox = parampd3;
    this.aoy = paramList3;
    this.aoz = paramString4;
    this.aoA = paramString5;
    this.aoB = parampd4;
    this.aoC = paramString6;
    this.aoD = paramString7;
    this.ov = paramString8;
    this.aoE = paramList4;
    this.aoF = paramString9;
    this.aoG = paramString10;
    this.aoH = paramString11;
    this.UO = paramString12;
    this.aoI = paramString13;
    this.aoJ = paramString14;
    this.aoK = paramString15;
    this.aoL = paramString16;
    this.aoM = paramString17;
    this.aoN = parampd5;
    this.aoO = paramString18;
    this.aoP = paramString19;
    this.CE = paramString20;
    this.aoQ = paramString21;
    this.aoR = parampd6;
    this.agg = paramDouble1;
    this.aoS = parampd7;
    this.agh = paramDouble2;
    this.mName = paramString22;
    this.aoT = parampd8;
    this.aoU = paramList5;
    this.aoV = paramString23;
    this.aoW = paramString24;
    this.aoX = paramString25;
    this.aoY = paramString26;
    this.aoZ = parampd9;
    this.apa = paramString27;
    this.apb = paramString28;
    this.apc = paramString29;
    this.apd = parampd10;
    this.ape = paramString30;
    this.apf = paramString31;
    this.vc = paramString32;
    this.vf = paramString33;
    this.apg = paramString34;
    this.aph = paramString35;
  }
  
  protected boolean a(kr.a parama)
  {
    return this.aon.contains(Integer.valueOf(parama.hR()));
  }
  
  protected Object b(kr.a parama)
  {
    switch (parama.hR())
    {
    case 35: 
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + parama.hR());
    case 2: 
      return this.aoo;
    case 3: 
      return this.aop;
    case 4: 
      return this.aoq;
    case 5: 
      return this.aor;
    case 6: 
      return this.aos;
    case 7: 
      return this.aot;
    case 8: 
      return this.aou;
    case 9: 
      return Integer.valueOf(this.aov);
    case 10: 
      return this.aow;
    case 11: 
      return this.aox;
    case 12: 
      return this.aoy;
    case 13: 
      return this.aoz;
    case 14: 
      return this.aoA;
    case 15: 
      return this.aoB;
    case 16: 
      return this.aoC;
    case 17: 
      return this.aoD;
    case 18: 
      return this.ov;
    case 19: 
      return this.aoE;
    case 20: 
      return this.aoF;
    case 21: 
      return this.aoG;
    case 22: 
      return this.aoH;
    case 23: 
      return this.UO;
    case 24: 
      return this.aoI;
    case 25: 
      return this.aoJ;
    case 26: 
      return this.aoK;
    case 27: 
      return this.aoL;
    case 28: 
      return this.aoM;
    case 29: 
      return this.aoN;
    case 30: 
      return this.aoO;
    case 31: 
      return this.aoP;
    case 32: 
      return this.CE;
    case 33: 
      return this.aoQ;
    case 34: 
      return this.aoR;
    case 36: 
      return Double.valueOf(this.agg);
    case 37: 
      return this.aoS;
    case 38: 
      return Double.valueOf(this.agh);
    case 39: 
      return this.mName;
    case 40: 
      return this.aoT;
    case 41: 
      return this.aoU;
    case 42: 
      return this.aoV;
    case 43: 
      return this.aoW;
    case 44: 
      return this.aoX;
    case 45: 
      return this.aoY;
    case 46: 
      return this.aoZ;
    case 47: 
      return this.apa;
    case 48: 
      return this.apb;
    case 49: 
      return this.apc;
    case 50: 
      return this.apd;
    case 51: 
      return this.ape;
    case 52: 
      return this.apf;
    case 53: 
      return this.vc;
    case 54: 
      return this.vf;
    case 55: 
      return this.apg;
    }
    return this.aph;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof pd)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    pd localpd = (pd)paramObject;
    Iterator localIterator = aom.values().iterator();
    while (localIterator.hasNext())
    {
      kr.a locala = (kr.a)localIterator.next();
      if (a(locala))
      {
        if (localpd.a(locala))
        {
          if (!b(locala).equals(localpd.b(locala))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (localpd.a(locala)) {
        return false;
      }
    }
    return true;
  }
  
  public ItemScope getAbout()
  {
    return this.aoo;
  }
  
  public List<String> getAdditionalName()
  {
    return this.aop;
  }
  
  public ItemScope getAddress()
  {
    return this.aoq;
  }
  
  public String getAddressCountry()
  {
    return this.aor;
  }
  
  public String getAddressLocality()
  {
    return this.aos;
  }
  
  public String getAddressRegion()
  {
    return this.aot;
  }
  
  public List<ItemScope> getAssociated_media()
  {
    return (ArrayList)this.aou;
  }
  
  public int getAttendeeCount()
  {
    return this.aov;
  }
  
  public List<ItemScope> getAttendees()
  {
    return (ArrayList)this.aow;
  }
  
  public ItemScope getAudio()
  {
    return this.aox;
  }
  
  public List<ItemScope> getAuthor()
  {
    return (ArrayList)this.aoy;
  }
  
  public String getBestRating()
  {
    return this.aoz;
  }
  
  public String getBirthDate()
  {
    return this.aoA;
  }
  
  public ItemScope getByArtist()
  {
    return this.aoB;
  }
  
  public String getCaption()
  {
    return this.aoC;
  }
  
  public String getContentSize()
  {
    return this.aoD;
  }
  
  public String getContentUrl()
  {
    return this.ov;
  }
  
  public List<ItemScope> getContributor()
  {
    return (ArrayList)this.aoE;
  }
  
  public String getDateCreated()
  {
    return this.aoF;
  }
  
  public String getDateModified()
  {
    return this.aoG;
  }
  
  public String getDatePublished()
  {
    return this.aoH;
  }
  
  public String getDescription()
  {
    return this.UO;
  }
  
  public String getDuration()
  {
    return this.aoI;
  }
  
  public String getEmbedUrl()
  {
    return this.aoJ;
  }
  
  public String getEndDate()
  {
    return this.aoK;
  }
  
  public String getFamilyName()
  {
    return this.aoL;
  }
  
  public String getGender()
  {
    return this.aoM;
  }
  
  public ItemScope getGeo()
  {
    return this.aoN;
  }
  
  public String getGivenName()
  {
    return this.aoO;
  }
  
  public String getHeight()
  {
    return this.aoP;
  }
  
  public String getId()
  {
    return this.CE;
  }
  
  public String getImage()
  {
    return this.aoQ;
  }
  
  public ItemScope getInAlbum()
  {
    return this.aoR;
  }
  
  public double getLatitude()
  {
    return this.agg;
  }
  
  public ItemScope getLocation()
  {
    return this.aoS;
  }
  
  public double getLongitude()
  {
    return this.agh;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public ItemScope getPartOfTVSeries()
  {
    return this.aoT;
  }
  
  public List<ItemScope> getPerformers()
  {
    return (ArrayList)this.aoU;
  }
  
  public String getPlayerType()
  {
    return this.aoV;
  }
  
  public String getPostOfficeBoxNumber()
  {
    return this.aoW;
  }
  
  public String getPostalCode()
  {
    return this.aoX;
  }
  
  public String getRatingValue()
  {
    return this.aoY;
  }
  
  public ItemScope getReviewRating()
  {
    return this.aoZ;
  }
  
  public String getStartDate()
  {
    return this.apa;
  }
  
  public String getStreetAddress()
  {
    return this.apb;
  }
  
  public String getText()
  {
    return this.apc;
  }
  
  public ItemScope getThumbnail()
  {
    return this.apd;
  }
  
  public String getThumbnailUrl()
  {
    return this.ape;
  }
  
  public String getTickerSymbol()
  {
    return this.apf;
  }
  
  public String getType()
  {
    return this.vc;
  }
  
  public String getUrl()
  {
    return this.vf;
  }
  
  public String getWidth()
  {
    return this.apg;
  }
  
  public String getWorstRating()
  {
    return this.aph;
  }
  
  public HashMap<String, kr.a<?, ?>> hK()
  {
    return aom;
  }
  
  public boolean hasAbout()
  {
    return this.aon.contains(Integer.valueOf(2));
  }
  
  public boolean hasAdditionalName()
  {
    return this.aon.contains(Integer.valueOf(3));
  }
  
  public boolean hasAddress()
  {
    return this.aon.contains(Integer.valueOf(4));
  }
  
  public boolean hasAddressCountry()
  {
    return this.aon.contains(Integer.valueOf(5));
  }
  
  public boolean hasAddressLocality()
  {
    return this.aon.contains(Integer.valueOf(6));
  }
  
  public boolean hasAddressRegion()
  {
    return this.aon.contains(Integer.valueOf(7));
  }
  
  public boolean hasAssociated_media()
  {
    return this.aon.contains(Integer.valueOf(8));
  }
  
  public boolean hasAttendeeCount()
  {
    return this.aon.contains(Integer.valueOf(9));
  }
  
  public boolean hasAttendees()
  {
    return this.aon.contains(Integer.valueOf(10));
  }
  
  public boolean hasAudio()
  {
    return this.aon.contains(Integer.valueOf(11));
  }
  
  public boolean hasAuthor()
  {
    return this.aon.contains(Integer.valueOf(12));
  }
  
  public boolean hasBestRating()
  {
    return this.aon.contains(Integer.valueOf(13));
  }
  
  public boolean hasBirthDate()
  {
    return this.aon.contains(Integer.valueOf(14));
  }
  
  public boolean hasByArtist()
  {
    return this.aon.contains(Integer.valueOf(15));
  }
  
  public boolean hasCaption()
  {
    return this.aon.contains(Integer.valueOf(16));
  }
  
  public boolean hasContentSize()
  {
    return this.aon.contains(Integer.valueOf(17));
  }
  
  public boolean hasContentUrl()
  {
    return this.aon.contains(Integer.valueOf(18));
  }
  
  public boolean hasContributor()
  {
    return this.aon.contains(Integer.valueOf(19));
  }
  
  public boolean hasDateCreated()
  {
    return this.aon.contains(Integer.valueOf(20));
  }
  
  public boolean hasDateModified()
  {
    return this.aon.contains(Integer.valueOf(21));
  }
  
  public boolean hasDatePublished()
  {
    return this.aon.contains(Integer.valueOf(22));
  }
  
  public boolean hasDescription()
  {
    return this.aon.contains(Integer.valueOf(23));
  }
  
  public boolean hasDuration()
  {
    return this.aon.contains(Integer.valueOf(24));
  }
  
  public boolean hasEmbedUrl()
  {
    return this.aon.contains(Integer.valueOf(25));
  }
  
  public boolean hasEndDate()
  {
    return this.aon.contains(Integer.valueOf(26));
  }
  
  public boolean hasFamilyName()
  {
    return this.aon.contains(Integer.valueOf(27));
  }
  
  public boolean hasGender()
  {
    return this.aon.contains(Integer.valueOf(28));
  }
  
  public boolean hasGeo()
  {
    return this.aon.contains(Integer.valueOf(29));
  }
  
  public boolean hasGivenName()
  {
    return this.aon.contains(Integer.valueOf(30));
  }
  
  public boolean hasHeight()
  {
    return this.aon.contains(Integer.valueOf(31));
  }
  
  public boolean hasId()
  {
    return this.aon.contains(Integer.valueOf(32));
  }
  
  public boolean hasImage()
  {
    return this.aon.contains(Integer.valueOf(33));
  }
  
  public boolean hasInAlbum()
  {
    return this.aon.contains(Integer.valueOf(34));
  }
  
  public boolean hasLatitude()
  {
    return this.aon.contains(Integer.valueOf(36));
  }
  
  public boolean hasLocation()
  {
    return this.aon.contains(Integer.valueOf(37));
  }
  
  public boolean hasLongitude()
  {
    return this.aon.contains(Integer.valueOf(38));
  }
  
  public boolean hasName()
  {
    return this.aon.contains(Integer.valueOf(39));
  }
  
  public boolean hasPartOfTVSeries()
  {
    return this.aon.contains(Integer.valueOf(40));
  }
  
  public boolean hasPerformers()
  {
    return this.aon.contains(Integer.valueOf(41));
  }
  
  public boolean hasPlayerType()
  {
    return this.aon.contains(Integer.valueOf(42));
  }
  
  public boolean hasPostOfficeBoxNumber()
  {
    return this.aon.contains(Integer.valueOf(43));
  }
  
  public boolean hasPostalCode()
  {
    return this.aon.contains(Integer.valueOf(44));
  }
  
  public boolean hasRatingValue()
  {
    return this.aon.contains(Integer.valueOf(45));
  }
  
  public boolean hasReviewRating()
  {
    return this.aon.contains(Integer.valueOf(46));
  }
  
  public boolean hasStartDate()
  {
    return this.aon.contains(Integer.valueOf(47));
  }
  
  public boolean hasStreetAddress()
  {
    return this.aon.contains(Integer.valueOf(48));
  }
  
  public boolean hasText()
  {
    return this.aon.contains(Integer.valueOf(49));
  }
  
  public boolean hasThumbnail()
  {
    return this.aon.contains(Integer.valueOf(50));
  }
  
  public boolean hasThumbnailUrl()
  {
    return this.aon.contains(Integer.valueOf(51));
  }
  
  public boolean hasTickerSymbol()
  {
    return this.aon.contains(Integer.valueOf(52));
  }
  
  public boolean hasType()
  {
    return this.aon.contains(Integer.valueOf(53));
  }
  
  public boolean hasUrl()
  {
    return this.aon.contains(Integer.valueOf(54));
  }
  
  public boolean hasWidth()
  {
    return this.aon.contains(Integer.valueOf(55));
  }
  
  public boolean hasWorstRating()
  {
    return this.aon.contains(Integer.valueOf(56));
  }
  
  public int hashCode()
  {
    Iterator localIterator = aom.values().iterator();
    int i = 0;
    kr.a locala;
    if (localIterator.hasNext())
    {
      locala = (kr.a)localIterator.next();
      if (!a(locala)) {
        break label66;
      }
    }
    label66:
    for (int j = i + locala.hR() + b(locala).hashCode();; j = i)
    {
      i = j;
      break;
      return i;
    }
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public pd oI()
  {
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    pe.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.pd
 * JD-Core Version:    0.7.0.1
 */