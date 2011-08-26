package proguard.jd.ru.akvel.test.decompilers;

import java.io.PrintStream;

final class b
{
  private long jdField_a_of_type_Long;
  private int jdField_a_of_type_Int;

  private b()
  {
    Test1.a(Byte.valueOf((byte)(Test1.a().byteValue() + 1)));
    System.out.println("Here");
  }

  protected b(int paramInt, byte paramByte)
  {
    this();
    this.jdField_a_of_type_Long = paramInt;
    this.jdField_a_of_type_Int = paramByte;
  }

  private String a()
  {
    return this.jdField_a_of_type_Long + this.jdField_a_of_type_Int;
  }
}

/* Location:           C:\work5\TestDecompilers\distrib\test_proguard.jar
 * Qualified Name:     ru.akvel.test.decompilers.b
 * JD-Core Version:    0.6.0
 */