package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class dj
  extends dg
{
  private static final String ID = a.aO.toString();
  private static final String aul = b.bj.toString();
  private static final String aum = b.bs.toString();
  private static final String aun = b.cE.toString();
  private static final String auo = b.cz.toString();
  private static final String aup = b.cy.toString();
  private static final String auq = b.br.toString();
  private static final String aur = b.eN.toString();
  private static final String aus = b.eQ.toString();
  private static final String aut = b.eS.toString();
  private static final List<String> auu = Arrays.asList(new String[] { "detail", "checkout", "checkout_option", "click", "add", "remove", "purchase", "refund" });
  private static final Pattern auv = Pattern.compile("dimension(\\d+)");
  private static final Pattern auw = Pattern.compile("metric(\\d+)");
  private static Map<String, String> aux;
  private static Map<String, String> auy;
  private final DataLayer aqn;
  private final df auA;
  private final Set<String> auz;
  
  public dj(Context paramContext, DataLayer paramDataLayer)
  {
    this(paramContext, paramDataLayer, new df(paramContext));
  }
  
  dj(Context paramContext, DataLayer paramDataLayer, df paramdf)
  {
    super(ID, new String[0]);
    this.aqn = paramDataLayer;
    this.auA = paramdf;
    this.auz = new HashSet();
    this.auz.add("");
    this.auz.add("0");
    this.auz.add("false");
  }
  
  private Promotion L(Map<String, String> paramMap)
  {
    Promotion localPromotion = new Promotion();
    String str1 = (String)paramMap.get("id");
    if (str1 != null) {
      localPromotion.setId(String.valueOf(str1));
    }
    String str2 = (String)paramMap.get("name");
    if (str2 != null) {
      localPromotion.setName(String.valueOf(str2));
    }
    String str3 = (String)paramMap.get("creative");
    if (str3 != null) {
      localPromotion.setCreative(String.valueOf(str3));
    }
    String str4 = (String)paramMap.get("position");
    if (str4 != null) {
      localPromotion.setPosition(String.valueOf(str4));
    }
    return localPromotion;
  }
  
  private Product M(Map<String, Object> paramMap)
  {
    Product localProduct = new Product();
    Object localObject1 = paramMap.get("id");
    if (localObject1 != null) {
      localProduct.setId(String.valueOf(localObject1));
    }
    Object localObject2 = paramMap.get("name");
    if (localObject2 != null) {
      localProduct.setName(String.valueOf(localObject2));
    }
    Object localObject3 = paramMap.get("brand");
    if (localObject3 != null) {
      localProduct.setBrand(String.valueOf(localObject3));
    }
    Object localObject4 = paramMap.get("category");
    if (localObject4 != null) {
      localProduct.setCategory(String.valueOf(localObject4));
    }
    Object localObject5 = paramMap.get("variant");
    if (localObject5 != null) {
      localProduct.setVariant(String.valueOf(localObject5));
    }
    Object localObject6 = paramMap.get("coupon");
    if (localObject6 != null) {
      localProduct.setCouponCode(String.valueOf(localObject6));
    }
    Object localObject7 = paramMap.get("position");
    if (localObject7 != null) {
      localProduct.setPosition(z(localObject7).intValue());
    }
    Object localObject8 = paramMap.get("price");
    if (localObject8 != null) {
      localProduct.setPrice(y(localObject8).doubleValue());
    }
    Object localObject9 = paramMap.get("quantity");
    if (localObject9 != null) {
      localProduct.setQuantity(z(localObject9).intValue());
    }
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Matcher localMatcher1 = auv.matcher(str);
      if (localMatcher1.matches())
      {
        try
        {
          int j = Integer.parseInt(localMatcher1.group(1));
          localProduct.setCustomDimension(j, String.valueOf(paramMap.get(str)));
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          bh.W("illegal number in custom dimension value: " + str);
        }
      }
      else
      {
        Matcher localMatcher2 = auw.matcher(str);
        if (localMatcher2.matches()) {
          try
          {
            int i = Integer.parseInt(localMatcher2.group(1));
            localProduct.setCustomMetric(i, z(paramMap.get(str)).intValue());
          }
          catch (NumberFormatException localNumberFormatException1)
          {
            bh.W("illegal number in custom metric value: " + str);
          }
        }
      }
    }
    return localProduct;
  }
  
  private Map<String, String> N(Map<String, d.a> paramMap)
  {
    d.a locala = (d.a)paramMap.get(aus);
    if (locala != null) {
      return c(locala);
    }
    if (aux == null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("transactionId", "&ti");
      localHashMap.put("transactionAffiliation", "&ta");
      localHashMap.put("transactionTax", "&tt");
      localHashMap.put("transactionShipping", "&ts");
      localHashMap.put("transactionTotal", "&tr");
      localHashMap.put("transactionCurrency", "&cu");
      aux = localHashMap;
    }
    return aux;
  }
  
  private Map<String, String> O(Map<String, d.a> paramMap)
  {
    d.a locala = (d.a)paramMap.get(aut);
    if (locala != null) {
      return c(locala);
    }
    if (auy == null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("name", "&in");
      localHashMap.put("sku", "&ic");
      localHashMap.put("category", "&iv");
      localHashMap.put("price", "&ip");
      localHashMap.put("quantity", "&iq");
      localHashMap.put("currency", "&cu");
      auy = localHashMap;
    }
    return auy;
  }
  
  private void a(Tracker paramTracker, Map<String, d.a> paramMap)
  {
    String str = de("transactionId");
    if (str == null) {
      bh.T("Cannot find transactionId in data layer.");
    }
    for (;;)
    {
      return;
      LinkedList localLinkedList = new LinkedList();
      try
      {
        Map localMap1 = p((d.a)paramMap.get(auq));
        localMap1.put("&t", "transaction");
        Iterator localIterator1 = N(paramMap).entrySet().iterator();
        while (localIterator1.hasNext())
        {
          Map.Entry localEntry2 = (Map.Entry)localIterator1.next();
          b(localMap1, (String)localEntry2.getValue(), de((String)localEntry2.getKey()));
        }
        localLinkedList.add(localMap1);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        bh.b("Unable to send transaction", localIllegalArgumentException);
        return;
      }
      List localList = df("transactionProducts");
      if (localList != null)
      {
        Iterator localIterator2 = localList.iterator();
        while (localIterator2.hasNext())
        {
          Map localMap2 = (Map)localIterator2.next();
          if (localMap2.get("name") == null)
          {
            bh.T("Unable to send transaction item hit due to missing 'name' field.");
            return;
          }
          Map localMap3 = p((d.a)paramMap.get(auq));
          localMap3.put("&t", "item");
          localMap3.put("&ti", str);
          Iterator localIterator4 = O(paramMap).entrySet().iterator();
          while (localIterator4.hasNext())
          {
            Map.Entry localEntry1 = (Map.Entry)localIterator4.next();
            b(localMap3, (String)localEntry1.getValue(), (String)localMap2.get(localEntry1.getKey()));
          }
          localLinkedList.add(localMap3);
        }
      }
      Iterator localIterator3 = localLinkedList.iterator();
      while (localIterator3.hasNext()) {
        paramTracker.send((Map)localIterator3.next());
      }
    }
  }
  
  private void b(Tracker paramTracker, Map<String, d.a> paramMap)
  {
    HitBuilders.ScreenViewBuilder localScreenViewBuilder = new HitBuilders.ScreenViewBuilder();
    Map localMap1 = p((d.a)paramMap.get(auq));
    localScreenViewBuilder.setAll(localMap1);
    Object localObject4;
    if (f(paramMap, auo))
    {
      localObject4 = this.aqn.get("ecommerce");
      if (!(localObject4 instanceof Map)) {
        break label756;
      }
    }
    label685:
    label744:
    label750:
    label756:
    for (Map localMap7 = (Map)localObject4;; localMap7 = null)
    {
      Map localMap2 = localMap7;
      for (;;)
      {
        List localList1;
        if (localMap2 != null)
        {
          String str1 = (String)localMap1.get("&cu");
          if (str1 == null) {
            str1 = (String)localMap2.get("currencyCode");
          }
          if (str1 != null) {
            localScreenViewBuilder.set("&cu", str1);
          }
          Object localObject2 = localMap2.get("impressions");
          if ((localObject2 instanceof List))
          {
            Iterator localIterator4 = ((List)localObject2).iterator();
            for (;;)
            {
              if (localIterator4.hasNext())
              {
                Map localMap6 = (Map)localIterator4.next();
                try
                {
                  localScreenViewBuilder.addImpression(M(localMap6), (String)localMap6.get("list"));
                }
                catch (RuntimeException localRuntimeException4)
                {
                  bh.T("Failed to extract a product from DataLayer. " + localRuntimeException4.getMessage());
                }
                continue;
                Object localObject1 = di.o((d.a)paramMap.get(aup));
                if (!(localObject1 instanceof Map)) {
                  break label750;
                }
                localMap2 = (Map)localObject1;
                break;
              }
            }
          }
          if (localMap2.containsKey("promoClick")) {
            localList1 = (List)((Map)localMap2.get("promoClick")).get("promotions");
          }
        }
        for (;;)
        {
          if (localList1 != null)
          {
            Iterator localIterator3 = localList1.iterator();
            for (;;)
            {
              if (localIterator3.hasNext())
              {
                Map localMap5 = (Map)localIterator3.next();
                try
                {
                  localScreenViewBuilder.addPromotion(L(localMap5));
                }
                catch (RuntimeException localRuntimeException3)
                {
                  bh.T("Failed to extract a promotion from DataLayer. " + localRuntimeException3.getMessage());
                }
                continue;
                if (!localMap2.containsKey("promoView")) {
                  break label744;
                }
                localList1 = (List)((Map)localMap2.get("promoView")).get("promotions");
                break;
              }
            }
            if (localMap2.containsKey("promoClick")) {
              localScreenViewBuilder.set("&promoa", "click");
            }
          }
          String str2;
          Map localMap3;
          for (int i = 0;; i = 1)
          {
            if (i == 0) {
              break label685;
            }
            Iterator localIterator1 = auu.iterator();
            do
            {
              if (!localIterator1.hasNext()) {
                break;
              }
              str2 = (String)localIterator1.next();
            } while (!localMap2.containsKey(str2));
            localMap3 = (Map)localMap2.get(str2);
            List localList2 = (List)localMap3.get("products");
            if (localList2 == null) {
              break;
            }
            Iterator localIterator2 = localList2.iterator();
            while (localIterator2.hasNext())
            {
              Map localMap4 = (Map)localIterator2.next();
              try
              {
                localScreenViewBuilder.addProduct(M(localMap4));
              }
              catch (RuntimeException localRuntimeException2)
              {
                bh.T("Failed to extract a product from DataLayer. " + localRuntimeException2.getMessage());
              }
            }
            localScreenViewBuilder.set("&promoa", "view");
          }
          for (;;)
          {
            try
            {
              if (!localMap3.containsKey("actionField")) {
                continue;
              }
              localObject3 = c(str2, (Map)localMap3.get("actionField"));
              localScreenViewBuilder.setProductAction((ProductAction)localObject3);
            }
            catch (RuntimeException localRuntimeException1)
            {
              Object localObject3;
              ProductAction localProductAction;
              bh.T("Failed to extract a product action from DataLayer. " + localRuntimeException1.getMessage());
              continue;
            }
            paramTracker.send(localScreenViewBuilder.build());
            return;
            localProductAction = new ProductAction(str2);
            localObject3 = localProductAction;
          }
          localList1 = null;
        }
        localMap2 = null;
      }
    }
  }
  
  private void b(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if (paramString2 != null) {
      paramMap.put(paramString1, paramString2);
    }
  }
  
  private ProductAction c(String paramString, Map<String, Object> paramMap)
  {
    ProductAction localProductAction = new ProductAction(paramString);
    Object localObject1 = paramMap.get("id");
    if (localObject1 != null) {
      localProductAction.setTransactionId(String.valueOf(localObject1));
    }
    Object localObject2 = paramMap.get("affiliation");
    if (localObject2 != null) {
      localProductAction.setTransactionAffiliation(String.valueOf(localObject2));
    }
    Object localObject3 = paramMap.get("coupon");
    if (localObject3 != null) {
      localProductAction.setTransactionCouponCode(String.valueOf(localObject3));
    }
    Object localObject4 = paramMap.get("list");
    if (localObject4 != null) {
      localProductAction.setProductActionList(String.valueOf(localObject4));
    }
    Object localObject5 = paramMap.get("option");
    if (localObject5 != null) {
      localProductAction.setCheckoutOptions(String.valueOf(localObject5));
    }
    Object localObject6 = paramMap.get("revenue");
    if (localObject6 != null) {
      localProductAction.setTransactionRevenue(y(localObject6).doubleValue());
    }
    Object localObject7 = paramMap.get("tax");
    if (localObject7 != null) {
      localProductAction.setTransactionTax(y(localObject7).doubleValue());
    }
    Object localObject8 = paramMap.get("shipping");
    if (localObject8 != null) {
      localProductAction.setTransactionShipping(y(localObject8).doubleValue());
    }
    Object localObject9 = paramMap.get("step");
    if (localObject9 != null) {
      localProductAction.setCheckoutStep(z(localObject9).intValue());
    }
    return localProductAction;
  }
  
  private Map<String, String> c(d.a parama)
  {
    Object localObject = di.o(parama);
    if (!(localObject instanceof Map)) {
      return null;
    }
    Map localMap = (Map)localObject;
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Iterator localIterator = localMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localLinkedHashMap.put(localEntry.getKey().toString(), localEntry.getValue().toString());
    }
    return localLinkedHashMap;
  }
  
  private String de(String paramString)
  {
    Object localObject = this.aqn.get(paramString);
    if (localObject == null) {
      return null;
    }
    return localObject.toString();
  }
  
  private List<Map<String, String>> df(String paramString)
  {
    Object localObject = this.aqn.get(paramString);
    if (localObject == null) {
      return null;
    }
    if (!(localObject instanceof List)) {
      throw new IllegalArgumentException("transactionProducts should be of type List.");
    }
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext()) {
      if (!(localIterator.next() instanceof Map)) {
        throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
      }
    }
    return (List)localObject;
  }
  
  private boolean f(Map<String, d.a> paramMap, String paramString)
  {
    d.a locala = (d.a)paramMap.get(paramString);
    if (locala == null) {
      return false;
    }
    return di.n(locala).booleanValue();
  }
  
  private Map<String, String> p(d.a parama)
  {
    if (parama == null) {
      return new HashMap();
    }
    Map localMap = c(parama);
    if (localMap == null) {
      return new HashMap();
    }
    String str = (String)localMap.get("&aip");
    if ((str != null) && (this.auz.contains(str.toLowerCase()))) {
      localMap.remove("&aip");
    }
    return localMap;
  }
  
  private Double y(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      try
      {
        Double localDouble = Double.valueOf((String)paramObject);
        return localDouble;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new RuntimeException("Cannot convert the object to Double: " + localNumberFormatException.getMessage());
      }
    }
    if ((paramObject instanceof Integer)) {
      return Double.valueOf(((Integer)paramObject).doubleValue());
    }
    if ((paramObject instanceof Double)) {
      return (Double)paramObject;
    }
    throw new RuntimeException("Cannot convert the object to Double: " + paramObject.toString());
  }
  
  private Integer z(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      try
      {
        Integer localInteger = Integer.valueOf((String)paramObject);
        return localInteger;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new RuntimeException("Cannot convert the object to Integer: " + localNumberFormatException.getMessage());
      }
    }
    if ((paramObject instanceof Double)) {
      return Integer.valueOf(((Double)paramObject).intValue());
    }
    if ((paramObject instanceof Integer)) {
      return (Integer)paramObject;
    }
    throw new RuntimeException("Cannot convert the object to Integer: " + paramObject.toString());
  }
  
  public void D(Map<String, d.a> paramMap)
  {
    Tracker localTracker = this.auA.cW("_GTM_DEFAULT_TRACKER_");
    localTracker.enableAdvertisingIdCollection(f(paramMap, "collect_adid"));
    if (f(paramMap, aun))
    {
      b(localTracker, paramMap);
      return;
    }
    if (f(paramMap, aum))
    {
      localTracker.send(p((d.a)paramMap.get(auq)));
      return;
    }
    if (f(paramMap, aur))
    {
      a(localTracker, paramMap);
      return;
    }
    bh.W("Ignoring unknown tag.");
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.dj
 * JD-Core Version:    0.7.0.1
 */