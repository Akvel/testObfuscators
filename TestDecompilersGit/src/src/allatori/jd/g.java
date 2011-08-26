package allatori.jd;
public class g
{
  public static String m(String a)
  {
    int tmp11_10 = 1;
    tmp11_10;
    int tmp16_11 = tmp11_10;
    int j;
    int ? = tmp16_11;
    int i = 85;
    if ((j = tmp16_11.length - 1) >= 0)
    {
      int tmp38_28 = j;
      i = (char)((char)(tmp38_28 ^ i) & 0x3F);
      ?[tmp38_28] = (char)(a.charAt(j) ^ i);
      j--;
      int tmp66_56 = j;
      i = (char)((char)(tmp66_56 ^ i) & 0x3F);
      ?[tmp66_56] = (char)(a.charAt(j) ^ i);
      j--;
    }
    new char[a.length()].<init>(?);
    return new java/lang/String;
  }

  public static String L(String a)
  {
    int tmp2_1 = 1;
    int tmp3_2 = tmp2_1;
    StackTraceElement tmp24_15 = new java.lang.Exception().getStackTrace()[tmp3_2];
    String tmp32_29 = tmp24_15.getMethodName();
    tmp32_29;
    String tmp44_38 = (tmp24_15.getClassName() + tmp32_29);
    int i;
    String str = tmp44_38;
    int j = i = tmp44_38.length() - tmp2_1;
    int tmp58_55 = a.length();
    char[] arrayOfChar = new char[tmp58_55];
    int k = 85;
    int m = tmp58_55 - tmp3_2;
    break label125;
  }
}

/* Location:           C:\work5\TestDecompilers\distrib\test_Allatori.jar
 * Qualified Name:     g
 * JD-Core Version:    0.6.0
 */