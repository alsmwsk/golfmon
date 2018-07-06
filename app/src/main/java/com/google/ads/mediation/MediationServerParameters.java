package com.google.ads.mediation;

import com.google.android.gms.internal.gr;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Deprecated
public abstract class MediationServerParameters
{
  protected void a() {}
  
  public void load(Map<String, String> paramMap)
    throws MediationServerParameters.MappingException
  {
    HashMap localHashMap = new HashMap();
    for (Field localField3 : getClass().getFields())
    {
      Parameter localParameter = (Parameter)localField3.getAnnotation(Parameter.class);
      if (localParameter != null) {
        localHashMap.put(localParameter.name(), localField3);
      }
    }
    if (localHashMap.isEmpty()) {
      gr.W("No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
    }
    Iterator localIterator1 = paramMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      Field localField2 = (Field)localHashMap.remove(localEntry.getKey());
      if (localField2 != null) {
        try
        {
          localField2.set(this, localEntry.getValue());
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          gr.W("Server option \"" + (String)localEntry.getKey() + "\" could not be set: Illegal Access");
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          gr.W("Server option \"" + (String)localEntry.getKey() + "\" could not be set: Bad Type");
        }
      } else {
        gr.S("Unexpected server option: " + (String)localEntry.getKey() + " = \"" + (String)localEntry.getValue() + "\"");
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator2 = localHashMap.values().iterator();
    while (localIterator2.hasNext())
    {
      Field localField1 = (Field)localIterator2.next();
      if (((Parameter)localField1.getAnnotation(Parameter.class)).required())
      {
        gr.W("Required server option missing: " + ((Parameter)localField1.getAnnotation(Parameter.class)).name());
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append(((Parameter)localField1.getAnnotation(Parameter.class)).name());
      }
    }
    if (localStringBuilder.length() > 0) {
      throw new MappingException("Required server option(s) missing: " + localStringBuilder.toString());
    }
    a();
  }
  
  public static final class MappingException
    extends Exception
  {
    public MappingException(String paramString)
    {
      super();
    }
  }
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  protected static @interface Parameter
  {
    String name();
    
    boolean required() default true;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.ads.mediation.MediationServerParameters
 * JD-Core Version:    0.7.0.1
 */