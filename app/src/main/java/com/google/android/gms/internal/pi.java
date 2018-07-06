package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.Person.AgeRange;
import com.google.android.gms.plus.model.people.Person.Cover;
import com.google.android.gms.plus.model.people.Person.Cover.CoverInfo;
import com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto;
import com.google.android.gms.plus.model.people.Person.Image;
import com.google.android.gms.plus.model.people.Person.Name;
import com.google.android.gms.plus.model.people.Person.Organizations;
import com.google.android.gms.plus.model.people.Person.PlacesLived;
import com.google.android.gms.plus.model.people.Person.Urls;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class pi
  extends ks
  implements Person
{
  public static final pj CREATOR = new pj();
  private static final HashMap<String, kr.a<?, ?>> aom = new HashMap();
  String CE;
  final int CK;
  String FR;
  String OS;
  final Set<Integer> aon;
  int apA;
  String apB;
  List<h> apC;
  boolean apD;
  String apl;
  a apm;
  String apn;
  String apo;
  int app;
  b apq;
  String apr;
  c aps;
  boolean apt;
  d apu;
  String apv;
  int apw;
  List<f> apx;
  List<g> apy;
  int apz;
  int ow;
  String vf;
  
  static
  {
    aom.put("aboutMe", kr.a.l("aboutMe", 2));
    aom.put("ageRange", kr.a.a("ageRange", 3, a.class));
    aom.put("birthday", kr.a.l("birthday", 4));
    aom.put("braggingRights", kr.a.l("braggingRights", 5));
    aom.put("circledByCount", kr.a.i("circledByCount", 6));
    aom.put("cover", kr.a.a("cover", 7, b.class));
    aom.put("currentLocation", kr.a.l("currentLocation", 8));
    aom.put("displayName", kr.a.l("displayName", 9));
    aom.put("gender", kr.a.a("gender", 12, new ko().h("male", 0).h("female", 1).h("other", 2), false));
    aom.put("id", kr.a.l("id", 14));
    aom.put("image", kr.a.a("image", 15, c.class));
    aom.put("isPlusUser", kr.a.k("isPlusUser", 16));
    aom.put("language", kr.a.l("language", 18));
    aom.put("name", kr.a.a("name", 19, d.class));
    aom.put("nickname", kr.a.l("nickname", 20));
    aom.put("objectType", kr.a.a("objectType", 21, new ko().h("person", 0).h("page", 1), false));
    aom.put("organizations", kr.a.b("organizations", 22, f.class));
    aom.put("placesLived", kr.a.b("placesLived", 23, g.class));
    aom.put("plusOneCount", kr.a.i("plusOneCount", 24));
    aom.put("relationshipStatus", kr.a.a("relationshipStatus", 25, new ko().h("single", 0).h("in_a_relationship", 1).h("engaged", 2).h("married", 3).h("its_complicated", 4).h("open_relationship", 5).h("widowed", 6).h("in_domestic_partnership", 7).h("in_civil_union", 8), false));
    aom.put("tagline", kr.a.l("tagline", 26));
    aom.put("url", kr.a.l("url", 27));
    aom.put("urls", kr.a.b("urls", 28, h.class));
    aom.put("verified", kr.a.k("verified", 29));
  }
  
  public pi()
  {
    this.CK = 1;
    this.aon = new HashSet();
  }
  
  public pi(String paramString1, String paramString2, c paramc, int paramInt, String paramString3)
  {
    this.CK = 1;
    this.aon = new HashSet();
    this.OS = paramString1;
    this.aon.add(Integer.valueOf(9));
    this.CE = paramString2;
    this.aon.add(Integer.valueOf(14));
    this.aps = paramc;
    this.aon.add(Integer.valueOf(15));
    this.apw = paramInt;
    this.aon.add(Integer.valueOf(21));
    this.vf = paramString3;
    this.aon.add(Integer.valueOf(27));
  }
  
  pi(Set<Integer> paramSet, int paramInt1, String paramString1, a parama, String paramString2, String paramString3, int paramInt2, b paramb, String paramString4, String paramString5, int paramInt3, String paramString6, c paramc, boolean paramBoolean1, String paramString7, d paramd, String paramString8, int paramInt4, List<f> paramList, List<g> paramList1, int paramInt5, int paramInt6, String paramString9, String paramString10, List<h> paramList2, boolean paramBoolean2)
  {
    this.aon = paramSet;
    this.CK = paramInt1;
    this.apl = paramString1;
    this.apm = parama;
    this.apn = paramString2;
    this.apo = paramString3;
    this.app = paramInt2;
    this.apq = paramb;
    this.apr = paramString4;
    this.OS = paramString5;
    this.ow = paramInt3;
    this.CE = paramString6;
    this.aps = paramc;
    this.apt = paramBoolean1;
    this.FR = paramString7;
    this.apu = paramd;
    this.apv = paramString8;
    this.apw = paramInt4;
    this.apx = paramList;
    this.apy = paramList1;
    this.apz = paramInt5;
    this.apA = paramInt6;
    this.apB = paramString9;
    this.vf = paramString10;
    this.apC = paramList2;
    this.apD = paramBoolean2;
  }
  
  public static pi i(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    pi localpi = CREATOR.dz(localParcel);
    localParcel.recycle();
    return localpi;
  }
  
  protected boolean a(kr.a parama)
  {
    return this.aon.contains(Integer.valueOf(parama.hR()));
  }
  
  protected Object b(kr.a parama)
  {
    switch (parama.hR())
    {
    case 10: 
    case 11: 
    case 13: 
    case 17: 
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + parama.hR());
    case 2: 
      return this.apl;
    case 3: 
      return this.apm;
    case 4: 
      return this.apn;
    case 5: 
      return this.apo;
    case 6: 
      return Integer.valueOf(this.app);
    case 7: 
      return this.apq;
    case 8: 
      return this.apr;
    case 9: 
      return this.OS;
    case 12: 
      return Integer.valueOf(this.ow);
    case 14: 
      return this.CE;
    case 15: 
      return this.aps;
    case 16: 
      return Boolean.valueOf(this.apt);
    case 18: 
      return this.FR;
    case 19: 
      return this.apu;
    case 20: 
      return this.apv;
    case 21: 
      return Integer.valueOf(this.apw);
    case 22: 
      return this.apx;
    case 23: 
      return this.apy;
    case 24: 
      return Integer.valueOf(this.apz);
    case 25: 
      return Integer.valueOf(this.apA);
    case 26: 
      return this.apB;
    case 27: 
      return this.vf;
    case 28: 
      return this.apC;
    }
    return Boolean.valueOf(this.apD);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof pi)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    pi localpi = (pi)paramObject;
    Iterator localIterator = aom.values().iterator();
    while (localIterator.hasNext())
    {
      kr.a locala = (kr.a)localIterator.next();
      if (a(locala))
      {
        if (localpi.a(locala))
        {
          if (!b(locala).equals(localpi.b(locala))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (localpi.a(locala)) {
        return false;
      }
    }
    return true;
  }
  
  public String getAboutMe()
  {
    return this.apl;
  }
  
  public Person.AgeRange getAgeRange()
  {
    return this.apm;
  }
  
  public String getBirthday()
  {
    return this.apn;
  }
  
  public String getBraggingRights()
  {
    return this.apo;
  }
  
  public int getCircledByCount()
  {
    return this.app;
  }
  
  public Person.Cover getCover()
  {
    return this.apq;
  }
  
  public String getCurrentLocation()
  {
    return this.apr;
  }
  
  public String getDisplayName()
  {
    return this.OS;
  }
  
  public int getGender()
  {
    return this.ow;
  }
  
  public String getId()
  {
    return this.CE;
  }
  
  public Person.Image getImage()
  {
    return this.aps;
  }
  
  public String getLanguage()
  {
    return this.FR;
  }
  
  public Person.Name getName()
  {
    return this.apu;
  }
  
  public String getNickname()
  {
    return this.apv;
  }
  
  public int getObjectType()
  {
    return this.apw;
  }
  
  public List<Person.Organizations> getOrganizations()
  {
    return (ArrayList)this.apx;
  }
  
  public List<Person.PlacesLived> getPlacesLived()
  {
    return (ArrayList)this.apy;
  }
  
  public int getPlusOneCount()
  {
    return this.apz;
  }
  
  public int getRelationshipStatus()
  {
    return this.apA;
  }
  
  public String getTagline()
  {
    return this.apB;
  }
  
  public String getUrl()
  {
    return this.vf;
  }
  
  public List<Person.Urls> getUrls()
  {
    return (ArrayList)this.apC;
  }
  
  public HashMap<String, kr.a<?, ?>> hK()
  {
    return aom;
  }
  
  public boolean hasAboutMe()
  {
    return this.aon.contains(Integer.valueOf(2));
  }
  
  public boolean hasAgeRange()
  {
    return this.aon.contains(Integer.valueOf(3));
  }
  
  public boolean hasBirthday()
  {
    return this.aon.contains(Integer.valueOf(4));
  }
  
  public boolean hasBraggingRights()
  {
    return this.aon.contains(Integer.valueOf(5));
  }
  
  public boolean hasCircledByCount()
  {
    return this.aon.contains(Integer.valueOf(6));
  }
  
  public boolean hasCover()
  {
    return this.aon.contains(Integer.valueOf(7));
  }
  
  public boolean hasCurrentLocation()
  {
    return this.aon.contains(Integer.valueOf(8));
  }
  
  public boolean hasDisplayName()
  {
    return this.aon.contains(Integer.valueOf(9));
  }
  
  public boolean hasGender()
  {
    return this.aon.contains(Integer.valueOf(12));
  }
  
  public boolean hasId()
  {
    return this.aon.contains(Integer.valueOf(14));
  }
  
  public boolean hasImage()
  {
    return this.aon.contains(Integer.valueOf(15));
  }
  
  public boolean hasIsPlusUser()
  {
    return this.aon.contains(Integer.valueOf(16));
  }
  
  public boolean hasLanguage()
  {
    return this.aon.contains(Integer.valueOf(18));
  }
  
  public boolean hasName()
  {
    return this.aon.contains(Integer.valueOf(19));
  }
  
  public boolean hasNickname()
  {
    return this.aon.contains(Integer.valueOf(20));
  }
  
  public boolean hasObjectType()
  {
    return this.aon.contains(Integer.valueOf(21));
  }
  
  public boolean hasOrganizations()
  {
    return this.aon.contains(Integer.valueOf(22));
  }
  
  public boolean hasPlacesLived()
  {
    return this.aon.contains(Integer.valueOf(23));
  }
  
  public boolean hasPlusOneCount()
  {
    return this.aon.contains(Integer.valueOf(24));
  }
  
  public boolean hasRelationshipStatus()
  {
    return this.aon.contains(Integer.valueOf(25));
  }
  
  public boolean hasTagline()
  {
    return this.aon.contains(Integer.valueOf(26));
  }
  
  public boolean hasUrl()
  {
    return this.aon.contains(Integer.valueOf(27));
  }
  
  public boolean hasUrls()
  {
    return this.aon.contains(Integer.valueOf(28));
  }
  
  public boolean hasVerified()
  {
    return this.aon.contains(Integer.valueOf(29));
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
  
  public boolean isPlusUser()
  {
    return this.apt;
  }
  
  public boolean isVerified()
  {
    return this.apD;
  }
  
  public pi oL()
  {
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    pj.a(this, paramParcel, paramInt);
  }
  
  public static final class a
    extends ks
    implements Person.AgeRange
  {
    public static final pk CREATOR = new pk();
    private static final HashMap<String, kr.a<?, ?>> aom = new HashMap();
    final int CK;
    final Set<Integer> aon;
    int apE;
    int apF;
    
    static
    {
      aom.put("max", kr.a.i("max", 2));
      aom.put("min", kr.a.i("min", 3));
    }
    
    public a()
    {
      this.CK = 1;
      this.aon = new HashSet();
    }
    
    a(Set<Integer> paramSet, int paramInt1, int paramInt2, int paramInt3)
    {
      this.aon = paramSet;
      this.CK = paramInt1;
      this.apE = paramInt2;
      this.apF = paramInt3;
    }
    
    protected boolean a(kr.a parama)
    {
      return this.aon.contains(Integer.valueOf(parama.hR()));
    }
    
    protected Object b(kr.a parama)
    {
      switch (parama.hR())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.hR());
      case 2: 
        return Integer.valueOf(this.apE);
      }
      return Integer.valueOf(this.apF);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof a)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      a locala = (a)paramObject;
      Iterator localIterator = aom.values().iterator();
      while (localIterator.hasNext())
      {
        kr.a locala1 = (kr.a)localIterator.next();
        if (a(locala1))
        {
          if (locala.a(locala1))
          {
            if (!b(locala1).equals(locala.b(locala1))) {
              return false;
            }
          }
          else {
            return false;
          }
        }
        else if (locala.a(locala1)) {
          return false;
        }
      }
      return true;
    }
    
    public int getMax()
    {
      return this.apE;
    }
    
    public int getMin()
    {
      return this.apF;
    }
    
    public HashMap<String, kr.a<?, ?>> hK()
    {
      return aom;
    }
    
    public boolean hasMax()
    {
      return this.aon.contains(Integer.valueOf(2));
    }
    
    public boolean hasMin()
    {
      return this.aon.contains(Integer.valueOf(3));
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
    
    public a oM()
    {
      return this;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      pk.a(this, paramParcel, paramInt);
    }
  }
  
  public static final class b
    extends ks
    implements Person.Cover
  {
    public static final pl CREATOR = new pl();
    private static final HashMap<String, kr.a<?, ?>> aom = new HashMap();
    final int CK;
    final Set<Integer> aon;
    a apG;
    b apH;
    int apI;
    
    static
    {
      aom.put("coverInfo", kr.a.a("coverInfo", 2, a.class));
      aom.put("coverPhoto", kr.a.a("coverPhoto", 3, b.class));
      aom.put("layout", kr.a.a("layout", 4, new ko().h("banner", 0), false));
    }
    
    public b()
    {
      this.CK = 1;
      this.aon = new HashSet();
    }
    
    b(Set<Integer> paramSet, int paramInt1, a parama, b paramb, int paramInt2)
    {
      this.aon = paramSet;
      this.CK = paramInt1;
      this.apG = parama;
      this.apH = paramb;
      this.apI = paramInt2;
    }
    
    protected boolean a(kr.a parama)
    {
      return this.aon.contains(Integer.valueOf(parama.hR()));
    }
    
    protected Object b(kr.a parama)
    {
      switch (parama.hR())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.hR());
      case 2: 
        return this.apG;
      case 3: 
        return this.apH;
      }
      return Integer.valueOf(this.apI);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof b)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      b localb = (b)paramObject;
      Iterator localIterator = aom.values().iterator();
      while (localIterator.hasNext())
      {
        kr.a locala = (kr.a)localIterator.next();
        if (a(locala))
        {
          if (localb.a(locala))
          {
            if (!b(locala).equals(localb.b(locala))) {
              return false;
            }
          }
          else {
            return false;
          }
        }
        else if (localb.a(locala)) {
          return false;
        }
      }
      return true;
    }
    
    public Person.Cover.CoverInfo getCoverInfo()
    {
      return this.apG;
    }
    
    public Person.Cover.CoverPhoto getCoverPhoto()
    {
      return this.apH;
    }
    
    public int getLayout()
    {
      return this.apI;
    }
    
    public HashMap<String, kr.a<?, ?>> hK()
    {
      return aom;
    }
    
    public boolean hasCoverInfo()
    {
      return this.aon.contains(Integer.valueOf(2));
    }
    
    public boolean hasCoverPhoto()
    {
      return this.aon.contains(Integer.valueOf(3));
    }
    
    public boolean hasLayout()
    {
      return this.aon.contains(Integer.valueOf(4));
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
    
    public b oN()
    {
      return this;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      pl.a(this, paramParcel, paramInt);
    }
    
    public static final class a
      extends ks
      implements Person.Cover.CoverInfo
    {
      public static final pm CREATOR = new pm();
      private static final HashMap<String, kr.a<?, ?>> aom = new HashMap();
      final int CK;
      final Set<Integer> aon;
      int apJ;
      int apK;
      
      static
      {
        aom.put("leftImageOffset", kr.a.i("leftImageOffset", 2));
        aom.put("topImageOffset", kr.a.i("topImageOffset", 3));
      }
      
      public a()
      {
        this.CK = 1;
        this.aon = new HashSet();
      }
      
      a(Set<Integer> paramSet, int paramInt1, int paramInt2, int paramInt3)
      {
        this.aon = paramSet;
        this.CK = paramInt1;
        this.apJ = paramInt2;
        this.apK = paramInt3;
      }
      
      protected boolean a(kr.a parama)
      {
        return this.aon.contains(Integer.valueOf(parama.hR()));
      }
      
      protected Object b(kr.a parama)
      {
        switch (parama.hR())
        {
        default: 
          throw new IllegalStateException("Unknown safe parcelable id=" + parama.hR());
        case 2: 
          return Integer.valueOf(this.apJ);
        }
        return Integer.valueOf(this.apK);
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public boolean equals(Object paramObject)
      {
        if (!(paramObject instanceof a)) {
          return false;
        }
        if (this == paramObject) {
          return true;
        }
        a locala = (a)paramObject;
        Iterator localIterator = aom.values().iterator();
        while (localIterator.hasNext())
        {
          kr.a locala1 = (kr.a)localIterator.next();
          if (a(locala1))
          {
            if (locala.a(locala1))
            {
              if (!b(locala1).equals(locala.b(locala1))) {
                return false;
              }
            }
            else {
              return false;
            }
          }
          else if (locala.a(locala1)) {
            return false;
          }
        }
        return true;
      }
      
      public int getLeftImageOffset()
      {
        return this.apJ;
      }
      
      public int getTopImageOffset()
      {
        return this.apK;
      }
      
      public HashMap<String, kr.a<?, ?>> hK()
      {
        return aom;
      }
      
      public boolean hasLeftImageOffset()
      {
        return this.aon.contains(Integer.valueOf(2));
      }
      
      public boolean hasTopImageOffset()
      {
        return this.aon.contains(Integer.valueOf(3));
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
      
      public a oO()
      {
        return this;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        pm.a(this, paramParcel, paramInt);
      }
    }
    
    public static final class b
      extends ks
      implements Person.Cover.CoverPhoto
    {
      public static final pn CREATOR = new pn();
      private static final HashMap<String, kr.a<?, ?>> aom = new HashMap();
      final int CK;
      final Set<Integer> aon;
      int li;
      int lj;
      String vf;
      
      static
      {
        aom.put("height", kr.a.i("height", 2));
        aom.put("url", kr.a.l("url", 3));
        aom.put("width", kr.a.i("width", 4));
      }
      
      public b()
      {
        this.CK = 1;
        this.aon = new HashSet();
      }
      
      b(Set<Integer> paramSet, int paramInt1, int paramInt2, String paramString, int paramInt3)
      {
        this.aon = paramSet;
        this.CK = paramInt1;
        this.lj = paramInt2;
        this.vf = paramString;
        this.li = paramInt3;
      }
      
      protected boolean a(kr.a parama)
      {
        return this.aon.contains(Integer.valueOf(parama.hR()));
      }
      
      protected Object b(kr.a parama)
      {
        switch (parama.hR())
        {
        default: 
          throw new IllegalStateException("Unknown safe parcelable id=" + parama.hR());
        case 2: 
          return Integer.valueOf(this.lj);
        case 3: 
          return this.vf;
        }
        return Integer.valueOf(this.li);
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public boolean equals(Object paramObject)
      {
        if (!(paramObject instanceof b)) {
          return false;
        }
        if (this == paramObject) {
          return true;
        }
        b localb = (b)paramObject;
        Iterator localIterator = aom.values().iterator();
        while (localIterator.hasNext())
        {
          kr.a locala = (kr.a)localIterator.next();
          if (a(locala))
          {
            if (localb.a(locala))
            {
              if (!b(locala).equals(localb.b(locala))) {
                return false;
              }
            }
            else {
              return false;
            }
          }
          else if (localb.a(locala)) {
            return false;
          }
        }
        return true;
      }
      
      public int getHeight()
      {
        return this.lj;
      }
      
      public String getUrl()
      {
        return this.vf;
      }
      
      public int getWidth()
      {
        return this.li;
      }
      
      public HashMap<String, kr.a<?, ?>> hK()
      {
        return aom;
      }
      
      public boolean hasHeight()
      {
        return this.aon.contains(Integer.valueOf(2));
      }
      
      public boolean hasUrl()
      {
        return this.aon.contains(Integer.valueOf(3));
      }
      
      public boolean hasWidth()
      {
        return this.aon.contains(Integer.valueOf(4));
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
      
      public b oP()
      {
        return this;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        pn.a(this, paramParcel, paramInt);
      }
    }
  }
  
  public static final class c
    extends ks
    implements Person.Image
  {
    public static final po CREATOR = new po();
    private static final HashMap<String, kr.a<?, ?>> aom = new HashMap();
    final int CK;
    final Set<Integer> aon;
    String vf;
    
    static
    {
      aom.put("url", kr.a.l("url", 2));
    }
    
    public c()
    {
      this.CK = 1;
      this.aon = new HashSet();
    }
    
    public c(String paramString)
    {
      this.aon = new HashSet();
      this.CK = 1;
      this.vf = paramString;
      this.aon.add(Integer.valueOf(2));
    }
    
    c(Set<Integer> paramSet, int paramInt, String paramString)
    {
      this.aon = paramSet;
      this.CK = paramInt;
      this.vf = paramString;
    }
    
    protected boolean a(kr.a parama)
    {
      return this.aon.contains(Integer.valueOf(parama.hR()));
    }
    
    protected Object b(kr.a parama)
    {
      switch (parama.hR())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.hR());
      }
      return this.vf;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof c)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      c localc = (c)paramObject;
      Iterator localIterator = aom.values().iterator();
      while (localIterator.hasNext())
      {
        kr.a locala = (kr.a)localIterator.next();
        if (a(locala))
        {
          if (localc.a(locala))
          {
            if (!b(locala).equals(localc.b(locala))) {
              return false;
            }
          }
          else {
            return false;
          }
        }
        else if (localc.a(locala)) {
          return false;
        }
      }
      return true;
    }
    
    public String getUrl()
    {
      return this.vf;
    }
    
    public HashMap<String, kr.a<?, ?>> hK()
    {
      return aom;
    }
    
    public boolean hasUrl()
    {
      return this.aon.contains(Integer.valueOf(2));
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
    
    public c oQ()
    {
      return this;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      po.a(this, paramParcel, paramInt);
    }
  }
  
  public static final class d
    extends ks
    implements Person.Name
  {
    public static final pp CREATOR = new pp();
    private static final HashMap<String, kr.a<?, ?>> aom = new HashMap();
    final int CK;
    String aoL;
    String aoO;
    final Set<Integer> aon;
    String apL;
    String apM;
    String apN;
    String apO;
    
    static
    {
      aom.put("familyName", kr.a.l("familyName", 2));
      aom.put("formatted", kr.a.l("formatted", 3));
      aom.put("givenName", kr.a.l("givenName", 4));
      aom.put("honorificPrefix", kr.a.l("honorificPrefix", 5));
      aom.put("honorificSuffix", kr.a.l("honorificSuffix", 6));
      aom.put("middleName", kr.a.l("middleName", 7));
    }
    
    public d()
    {
      this.CK = 1;
      this.aon = new HashSet();
    }
    
    d(Set<Integer> paramSet, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    {
      this.aon = paramSet;
      this.CK = paramInt;
      this.aoL = paramString1;
      this.apL = paramString2;
      this.aoO = paramString3;
      this.apM = paramString4;
      this.apN = paramString5;
      this.apO = paramString6;
    }
    
    protected boolean a(kr.a parama)
    {
      return this.aon.contains(Integer.valueOf(parama.hR()));
    }
    
    protected Object b(kr.a parama)
    {
      switch (parama.hR())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.hR());
      case 2: 
        return this.aoL;
      case 3: 
        return this.apL;
      case 4: 
        return this.aoO;
      case 5: 
        return this.apM;
      case 6: 
        return this.apN;
      }
      return this.apO;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof d)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      d locald = (d)paramObject;
      Iterator localIterator = aom.values().iterator();
      while (localIterator.hasNext())
      {
        kr.a locala = (kr.a)localIterator.next();
        if (a(locala))
        {
          if (locald.a(locala))
          {
            if (!b(locala).equals(locald.b(locala))) {
              return false;
            }
          }
          else {
            return false;
          }
        }
        else if (locald.a(locala)) {
          return false;
        }
      }
      return true;
    }
    
    public String getFamilyName()
    {
      return this.aoL;
    }
    
    public String getFormatted()
    {
      return this.apL;
    }
    
    public String getGivenName()
    {
      return this.aoO;
    }
    
    public String getHonorificPrefix()
    {
      return this.apM;
    }
    
    public String getHonorificSuffix()
    {
      return this.apN;
    }
    
    public String getMiddleName()
    {
      return this.apO;
    }
    
    public HashMap<String, kr.a<?, ?>> hK()
    {
      return aom;
    }
    
    public boolean hasFamilyName()
    {
      return this.aon.contains(Integer.valueOf(2));
    }
    
    public boolean hasFormatted()
    {
      return this.aon.contains(Integer.valueOf(3));
    }
    
    public boolean hasGivenName()
    {
      return this.aon.contains(Integer.valueOf(4));
    }
    
    public boolean hasHonorificPrefix()
    {
      return this.aon.contains(Integer.valueOf(5));
    }
    
    public boolean hasHonorificSuffix()
    {
      return this.aon.contains(Integer.valueOf(6));
    }
    
    public boolean hasMiddleName()
    {
      return this.aon.contains(Integer.valueOf(7));
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
    
    public d oR()
    {
      return this;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      pp.a(this, paramParcel, paramInt);
    }
  }
  
  public static class e
  {
    public static int ck(String paramString)
    {
      if (paramString.equals("person")) {
        return 0;
      }
      if (paramString.equals("page")) {
        return 1;
      }
      throw new IllegalArgumentException("Unknown objectType string: " + paramString);
    }
  }
  
  public static final class f
    extends ks
    implements Person.Organizations
  {
    public static final pq CREATOR = new pq();
    private static final HashMap<String, kr.a<?, ?>> aom = new HashMap();
    final int CK;
    int Gt;
    String OH;
    String UO;
    String aoK;
    final Set<Integer> aon;
    String apP;
    String apQ;
    boolean apR;
    String apa;
    String mName;
    
    static
    {
      aom.put("department", kr.a.l("department", 2));
      aom.put("description", kr.a.l("description", 3));
      aom.put("endDate", kr.a.l("endDate", 4));
      aom.put("location", kr.a.l("location", 5));
      aom.put("name", kr.a.l("name", 6));
      aom.put("primary", kr.a.k("primary", 7));
      aom.put("startDate", kr.a.l("startDate", 8));
      aom.put("title", kr.a.l("title", 9));
      aom.put("type", kr.a.a("type", 10, new ko().h("work", 0).h("school", 1), false));
    }
    
    public f()
    {
      this.CK = 1;
      this.aon = new HashSet();
    }
    
    f(Set<Integer> paramSet, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, String paramString6, String paramString7, int paramInt2)
    {
      this.aon = paramSet;
      this.CK = paramInt1;
      this.apP = paramString1;
      this.UO = paramString2;
      this.aoK = paramString3;
      this.apQ = paramString4;
      this.mName = paramString5;
      this.apR = paramBoolean;
      this.apa = paramString6;
      this.OH = paramString7;
      this.Gt = paramInt2;
    }
    
    protected boolean a(kr.a parama)
    {
      return this.aon.contains(Integer.valueOf(parama.hR()));
    }
    
    protected Object b(kr.a parama)
    {
      switch (parama.hR())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.hR());
      case 2: 
        return this.apP;
      case 3: 
        return this.UO;
      case 4: 
        return this.aoK;
      case 5: 
        return this.apQ;
      case 6: 
        return this.mName;
      case 7: 
        return Boolean.valueOf(this.apR);
      case 8: 
        return this.apa;
      case 9: 
        return this.OH;
      }
      return Integer.valueOf(this.Gt);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof f)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      f localf = (f)paramObject;
      Iterator localIterator = aom.values().iterator();
      while (localIterator.hasNext())
      {
        kr.a locala = (kr.a)localIterator.next();
        if (a(locala))
        {
          if (localf.a(locala))
          {
            if (!b(locala).equals(localf.b(locala))) {
              return false;
            }
          }
          else {
            return false;
          }
        }
        else if (localf.a(locala)) {
          return false;
        }
      }
      return true;
    }
    
    public String getDepartment()
    {
      return this.apP;
    }
    
    public String getDescription()
    {
      return this.UO;
    }
    
    public String getEndDate()
    {
      return this.aoK;
    }
    
    public String getLocation()
    {
      return this.apQ;
    }
    
    public String getName()
    {
      return this.mName;
    }
    
    public String getStartDate()
    {
      return this.apa;
    }
    
    public String getTitle()
    {
      return this.OH;
    }
    
    public int getType()
    {
      return this.Gt;
    }
    
    public HashMap<String, kr.a<?, ?>> hK()
    {
      return aom;
    }
    
    public boolean hasDepartment()
    {
      return this.aon.contains(Integer.valueOf(2));
    }
    
    public boolean hasDescription()
    {
      return this.aon.contains(Integer.valueOf(3));
    }
    
    public boolean hasEndDate()
    {
      return this.aon.contains(Integer.valueOf(4));
    }
    
    public boolean hasLocation()
    {
      return this.aon.contains(Integer.valueOf(5));
    }
    
    public boolean hasName()
    {
      return this.aon.contains(Integer.valueOf(6));
    }
    
    public boolean hasPrimary()
    {
      return this.aon.contains(Integer.valueOf(7));
    }
    
    public boolean hasStartDate()
    {
      return this.aon.contains(Integer.valueOf(8));
    }
    
    public boolean hasTitle()
    {
      return this.aon.contains(Integer.valueOf(9));
    }
    
    public boolean hasType()
    {
      return this.aon.contains(Integer.valueOf(10));
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
    
    public boolean isPrimary()
    {
      return this.apR;
    }
    
    public f oS()
    {
      return this;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      pq.a(this, paramParcel, paramInt);
    }
  }
  
  public static final class g
    extends ks
    implements Person.PlacesLived
  {
    public static final pr CREATOR = new pr();
    private static final HashMap<String, kr.a<?, ?>> aom = new HashMap();
    final int CK;
    final Set<Integer> aon;
    boolean apR;
    String mValue;
    
    static
    {
      aom.put("primary", kr.a.k("primary", 2));
      aom.put("value", kr.a.l("value", 3));
    }
    
    public g()
    {
      this.CK = 1;
      this.aon = new HashSet();
    }
    
    g(Set<Integer> paramSet, int paramInt, boolean paramBoolean, String paramString)
    {
      this.aon = paramSet;
      this.CK = paramInt;
      this.apR = paramBoolean;
      this.mValue = paramString;
    }
    
    protected boolean a(kr.a parama)
    {
      return this.aon.contains(Integer.valueOf(parama.hR()));
    }
    
    protected Object b(kr.a parama)
    {
      switch (parama.hR())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.hR());
      case 2: 
        return Boolean.valueOf(this.apR);
      }
      return this.mValue;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof g)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      g localg = (g)paramObject;
      Iterator localIterator = aom.values().iterator();
      while (localIterator.hasNext())
      {
        kr.a locala = (kr.a)localIterator.next();
        if (a(locala))
        {
          if (localg.a(locala))
          {
            if (!b(locala).equals(localg.b(locala))) {
              return false;
            }
          }
          else {
            return false;
          }
        }
        else if (localg.a(locala)) {
          return false;
        }
      }
      return true;
    }
    
    public String getValue()
    {
      return this.mValue;
    }
    
    public HashMap<String, kr.a<?, ?>> hK()
    {
      return aom;
    }
    
    public boolean hasPrimary()
    {
      return this.aon.contains(Integer.valueOf(2));
    }
    
    public boolean hasValue()
    {
      return this.aon.contains(Integer.valueOf(3));
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
    
    public boolean isPrimary()
    {
      return this.apR;
    }
    
    public g oT()
    {
      return this;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      pr.a(this, paramParcel, paramInt);
    }
  }
  
  public static final class h
    extends ks
    implements Person.Urls
  {
    public static final ps CREATOR = new ps();
    private static final HashMap<String, kr.a<?, ?>> aom = new HashMap();
    final int CK;
    int Gt;
    String XL;
    final Set<Integer> aon;
    private final int apS = 4;
    String mValue;
    
    static
    {
      aom.put("label", kr.a.l("label", 5));
      aom.put("type", kr.a.a("type", 6, new ko().h("home", 0).h("work", 1).h("blog", 2).h("profile", 3).h("other", 4).h("otherProfile", 5).h("contributor", 6).h("website", 7), false));
      aom.put("value", kr.a.l("value", 4));
    }
    
    public h()
    {
      this.CK = 1;
      this.aon = new HashSet();
    }
    
    h(Set<Integer> paramSet, int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3)
    {
      this.aon = paramSet;
      this.CK = paramInt1;
      this.XL = paramString1;
      this.Gt = paramInt2;
      this.mValue = paramString2;
    }
    
    protected boolean a(kr.a parama)
    {
      return this.aon.contains(Integer.valueOf(parama.hR()));
    }
    
    protected Object b(kr.a parama)
    {
      switch (parama.hR())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.hR());
      case 5: 
        return this.XL;
      case 6: 
        return Integer.valueOf(this.Gt);
      }
      return this.mValue;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof h)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      h localh = (h)paramObject;
      Iterator localIterator = aom.values().iterator();
      while (localIterator.hasNext())
      {
        kr.a locala = (kr.a)localIterator.next();
        if (a(locala))
        {
          if (localh.a(locala))
          {
            if (!b(locala).equals(localh.b(locala))) {
              return false;
            }
          }
          else {
            return false;
          }
        }
        else if (localh.a(locala)) {
          return false;
        }
      }
      return true;
    }
    
    public String getLabel()
    {
      return this.XL;
    }
    
    public int getType()
    {
      return this.Gt;
    }
    
    public String getValue()
    {
      return this.mValue;
    }
    
    public HashMap<String, kr.a<?, ?>> hK()
    {
      return aom;
    }
    
    public boolean hasLabel()
    {
      return this.aon.contains(Integer.valueOf(5));
    }
    
    public boolean hasType()
    {
      return this.aon.contains(Integer.valueOf(6));
    }
    
    public boolean hasValue()
    {
      return this.aon.contains(Integer.valueOf(4));
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
    
    @Deprecated
    public int oU()
    {
      return 4;
    }
    
    public h oV()
    {
      return this;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      ps.a(this, paramParcel, paramInt);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.pi
 * JD-Core Version:    0.7.0.1
 */