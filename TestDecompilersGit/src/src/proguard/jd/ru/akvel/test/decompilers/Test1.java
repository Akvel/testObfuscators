package proguard.jd.ru.akvel.test.decompilers;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test1
{
  private static int jdField_a_of_type_Int = -2147483648;
  private static byte jdField_a_of_type_Byte = -128;
  private static short jdField_a_of_type_Short = -32768;
  private static long jdField_a_of_type_Long = -9223372036854775808L;
  private static String jdField_a_of_type_JavaLangString = "Just test";
  private boolean jdField_a_of_type_Boolean;
  private static Integer jdField_a_of_type_JavaLangInteger = Integer.valueOf(-2147483648);
  private static Byte jdField_a_of_type_JavaLangByte = Byte.valueOf(-128);
  private static Short jdField_a_of_type_JavaLangShort;
  private static Long jdField_a_of_type_JavaLangLong;
  private static Boolean jdField_a_of_type_JavaLangBoolean;
  private final String b = "passed";

  public static void main(String[] paramArrayOfString)
  {
    jdField_a_of_type_Int = (int)(jdField_a_of_type_Byte ^ jdField_a_of_type_Short | jdField_a_of_type_Long * jdField_a_of_type_JavaLangInteger.intValue());
    for (int i = 0; i < 5; i++)
      System.out.print("Test " + jdField_a_of_type_JavaLangString + " " + paramArrayOfString);
    jdField_a_of_type_Byte = 0;
    while (jdField_a_of_type_Byte++ < 10)
    {
      if (jdField_a_of_type_Byte <= 11)
        continue;
      throw new Exception("Test");
    }
    if (jdField_a_of_type_Int == 0)
      jdField_a_of_type_Int += 12;
    new Test1().getClass();
    b.a(new b(jdField_a_of_type_Int == 0 ? 5 : 6, jdField_a_of_type_Byte));
    System.out.println("test");
    new Date().getClass().getClass().getFields();
    new ArrayList().addAll(new ArrayList(100));
  }

  private String a()
  {
    return this.b;
  }
}

/* Location:           C:\work5\TestDecompilers\distrib\test_proguard.jar
 * Qualified Name:     ru.akvel.test.decompilers.Test1
 * JD-Core Version:    0.6.0
 */