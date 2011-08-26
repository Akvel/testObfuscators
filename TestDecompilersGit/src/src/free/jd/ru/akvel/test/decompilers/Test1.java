/*     */ package free.jd.ru.akvel.test.decompilers;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ 
/*     */ public class Test1
/*     */ {
/*  12 */   private static int fInt = -2147483648;
/*  13 */   private static byte fByte = -128;
/*  14 */   private static short fShort = -32768;
/*  15 */   private static long fLong = -9223372036854775808L;
/*  16 */   private static String fString = "Just test";
/*  17 */   public boolean b = false;
/*     */ 
/*  19 */   private static Integer fIntC = Integer.valueOf(-2147483648);
/*  20 */   private static Byte fByteC = Byte.valueOf(-128);
/*     */ 
/*  22 */   private static Short fShortC = Short.valueOf(-32768);
/*  23 */   private static Long fLongC = Long.valueOf(-9223372036854775808L);
/*  24 */   private static Boolean fBoolC = Boolean.FALSE;
/*     */   private final String a;
/*     */ 
/*     */   protected Test1()
/*     */   {
/*  33 */     this.a = "passed";
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */     throws Exception
/*     */   {
/*  66 */     fInt = (int)(fByte ^ fShort | fLong * fIntC.intValue());
/*     */ 
/*  69 */     for (int FInt = 0; FInt < 5; FInt++) {
/*  70 */       System.out.print("Test " + fString + " " + args);
/*     */     }
/*     */ 
/*  73 */     fByte = 0;
/*  74 */     while (fByte++ < 10) {
/*  75 */       if (fByte > 11) {
/*  76 */         throw new Exception("Test");
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  81 */     if (fInt == 0) {
/*  82 */       fInt += 12;
/*     */     }
/*     */ 
/*  85 */     switch (fInt) { case 1:
/*  86 */       break;
/*     */     case 2:
/*     */     case 3:
/*     */     }
/*     */      tmp170_167 = new Test1(); tmp170_167.getClass(); TestClass t = new TestClass(fInt == 0 ? 5 : 6, fByte);
/*  92 */     t.Test();
/*     */ 
/*  95 */     System.out.println("test");
/*  96 */     System.currentTimeMillis();
/*  97 */     new Date().getClass().getClass().getFields();
/*     */ 
/* 100 */     List testList = new ArrayList();
/* 101 */     testList.addAll(new ArrayList(100));
/*     */   }
/*     */ 
/*     */   public String getA()
/*     */   {
/* 114 */     return this.a;
/*     */   }
/*     */ 
/*     */   private class TestClass
/*     */   {
/*     */     private long a;
/*     */     private int b;
/*     */ 
/*     */     protected TestClass()
/*     */     {
/*  43 */       Test1.fByteC = Byte.valueOf((byte)(Test1.fByteC.byteValue() + 1));
/*  44 */       System.out.println("Here");
/*     */     }
/*     */ 
/*     */     protected TestClass(int a, byte b) {
/*  48 */       this();
/*  49 */       this.a = a;
/*  50 */       this.b = b;
/*     */     }
/*     */     @Deprecated
/*     */     private String Test() {
/*  55 */       return this.a + this.b;
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\work5\TestDecompilers\distrib\test.jar
 * Qualified Name:     ru.akvel.test.decompilers.Test1
 * JD-Core Version:    0.6.0
 */