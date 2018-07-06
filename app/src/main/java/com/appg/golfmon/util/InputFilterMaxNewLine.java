package com.appg.golfmon.util;

import android.text.InputFilter;
import android.text.Spanned;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputFilterMaxNewLine
  implements InputFilter
{
  int mMax = -1;
  
  public InputFilterMaxNewLine(int paramInt)
  {
    this.mMax = paramInt;
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if (this.mMax >= 0)
    {
      String str = paramCharSequence.toString();
      if (str.contains("\n"))
      {
        int i = 0;
        Pattern localPattern = Pattern.compile("\n");
        Matcher localMatcher1 = localPattern.matcher(str);
        Matcher localMatcher2;
        if (!localMatcher1.find())
        {
          localMatcher1.reset();
          localMatcher2 = localPattern.matcher(paramSpanned);
        }
        for (;;)
        {
          if (!localMatcher2.find())
          {
            if (i <= this.mMax) {
              break label111;
            }
            return "";
            i++;
            localMatcher1.end();
            break;
          }
          i++;
          localMatcher2.end();
        }
      }
    }
    label111:
    return null;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.util.InputFilterMaxNewLine
 * JD-Core Version:    0.7.0.1
 */