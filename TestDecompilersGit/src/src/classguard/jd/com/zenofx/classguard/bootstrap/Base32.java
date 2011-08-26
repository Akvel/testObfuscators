/*     */ package classguard.jd.com.zenofx.classguard.bootstrap;
/*     */ 
/*     */ public class Base32
/*     */ {
/*     */   private static final String base32Chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567";
/*  16 */   private static final byte[] base32Lookup = { 26, 27, 28, 29, 30, 31, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25 };
/*     */ 
/*     */   public static String encode(byte[] paramArrayOfByte)
/*     */   {
/*  31 */     StringBuffer localStringBuffer = new StringBuffer((paramArrayOfByte.length * 8 + 4) / 5);
/*     */ 
/*  33 */     int k = 0;
/*  34 */     while (k < paramArrayOfByte.length)
/*     */     {
/*  39 */       int i = paramArrayOfByte[(k++)] & 0xFF;
/*  40 */       localStringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567".charAt(i >> 3));
/*  41 */       int j = (i & 0x7) << 2;
/*  42 */       if (k >= paramArrayOfByte.length) {
/*  43 */         localStringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567".charAt(j));
/*  44 */         break;
/*     */       }
/*     */ 
/*  47 */       i = paramArrayOfByte[(k++)] & 0xFF;
/*  48 */       localStringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567".charAt(j | i >> 6));
/*  49 */       localStringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567".charAt(i >> 1 & 0x1F));
/*  50 */       j = (i & 0x1) << 4;
/*  51 */       if (k >= paramArrayOfByte.length) {
/*  52 */         localStringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567".charAt(j));
/*  53 */         break;
/*     */       }
/*     */ 
/*  56 */       i = paramArrayOfByte[(k++)] & 0xFF;
/*  57 */       localStringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567".charAt(j | i >> 4));
/*  58 */       j = (i & 0xF) << 1;
/*  59 */       if (k >= paramArrayOfByte.length) {
/*  60 */         localStringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567".charAt(j));
/*  61 */         break;
/*     */       }
/*     */ 
/*  64 */       i = paramArrayOfByte[(k++)] & 0xFF;
/*  65 */       localStringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567".charAt(j | i >> 7));
/*  66 */       localStringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567".charAt(i >> 2 & 0x1F));
/*  67 */       j = (i & 0x3) << 3;
/*  68 */       if (k >= paramArrayOfByte.length) {
/*  69 */         localStringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567".charAt(j));
/*  70 */         break;
/*     */       }
/*     */ 
/*  73 */       i = paramArrayOfByte[(k++)] & 0xFF;
/*  74 */       localStringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567".charAt(j | i >> 5));
/*  75 */       localStringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567".charAt(i & 0x1F));
/*     */     }
/*     */ 
/*  79 */     return localStringBuffer.toString();
/*     */   }
/*     */ 
/*     */   public static byte[] decodeUserInput(String paramString)
/*     */     throws IllegalArgumentException
/*     */   {
/*  89 */     StringBuffer localStringBuffer = new StringBuffer(paramString);
/*     */ 
/*  92 */     int i = 0;
/*  93 */     while (i < localStringBuffer.length()) {
/*  94 */       if ((Character.isWhitespace(localStringBuffer.charAt(i))) || (localStringBuffer.charAt(i) == '-')) {
/*  95 */         localStringBuffer.deleteCharAt(i); continue;
/*     */       }
/*     */ 
/*  98 */       i++;
/*     */     }
/*     */ 
/* 101 */     return decode(localStringBuffer.toString());
/*     */   }
/*     */ 
/*     */   public static byte[] decode(String paramString)
/*     */     throws IllegalArgumentException
/*     */   {
/* 111 */     byte[] arrayOfByte = new byte[paramString.length() * 5 / 8];
/* 112 */     int i = 0; int j = 0; int k = 0;
/* 113 */     int m = 0;
/*     */ 
/* 115 */     while (k < paramString.length())
/*     */     {
/* 117 */       int n = paramString.charAt(k++) - '2';
/*     */ 
/* 119 */       if ((n < 0) || (n >= base32Lookup.length)) {
/* 120 */         throw new IllegalArgumentException();
/*     */       }
/* 122 */       int i1 = base32Lookup[n];
/* 123 */       if (i1 == -1) {
/* 124 */         throw new IllegalArgumentException();
/*     */       }
/* 126 */       switch (i) {
/*     */       case 0:
/* 128 */         m = (byte)(i1 << 3);
/* 129 */         i = 5; break;
/*     */       case 5:
/* 131 */         arrayOfByte[(j++)] = (byte)(m | i1 >> 2);
/* 132 */         m = (byte)((i1 & 0x3) << 6);
/* 133 */         i = 2; break;
/*     */       case 2:
/* 135 */         m = (byte)(m | (byte)(i1 << 1));
/* 136 */         i = 7; break;
/*     */       case 7:
/* 138 */         arrayOfByte[(j++)] = (byte)(m | i1 >> 4);
/* 139 */         m = (byte)((i1 & 0xF) << 4);
/* 140 */         i = 4; break;
/*     */       case 4:
/* 142 */         arrayOfByte[(j++)] = (byte)(m | i1 >> 1);
/* 143 */         m = (byte)((i1 & 0x1) << 7);
/* 144 */         i = 1; break;
/*     */       case 1:
/* 146 */         m = (byte)(m | (byte)(i1 << 2));
/* 147 */         i = 6; break;
/*     */       case 6:
/* 149 */         arrayOfByte[(j++)] = (byte)(m | i1 >> 3);
/* 150 */         m = (byte)((i1 & 0x7) << 5);
/* 151 */         i = 3; break;
/*     */       case 3:
/* 153 */         arrayOfByte[(j++)] = (byte)(m | i1);
/* 154 */         i = 0;
/*     */       }
/*     */     }
/* 157 */     return arrayOfByte;
/*     */   }
/*     */ }

/* Location:           C:\work5\TestDecompilers\distrib\test_ClassGuard.jar
 * Qualified Name:     com.zenofx.classguard.bootstrap.Base32
 * JD-Core Version:    0.6.0
 */