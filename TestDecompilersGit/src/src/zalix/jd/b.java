package zalix.jd;

public class b
{
  private static int a;
  private static byte b;
  private static short c;
  private static long d;
  private static String e;
  public boolean f = false;
  private static Integer g;
  private static Byte h;
  private static Short i;
  private static Long j;
  private static Boolean k;
  private final String l = z[0];
  public static boolean m;
  private static final String[] z;

  static
  {
    // Byte code:
    //   0: iconst_4
    //   1: anewarray 190	java/lang/String
    //   4: dup
    //   5: iconst_0
    //   6: ldc 87
    //   8: bipush 255
    //   10: goto +37 -> 47
    //   13: aastore
    //   14: dup
    //   15: iconst_1
    //   16: ldc 131
    //   18: iconst_0
    //   19: goto +28 -> 47
    //   22: aastore
    //   23: dup
    //   24: iconst_2
    //   25: ldc 108
    //   27: iconst_1
    //   28: goto +19 -> 47
    //   31: aastore
    //   32: dup
    //   33: iconst_3
    //   34: ldc 146
    //   36: iconst_2
    //   37: goto +10 -> 47
    //   40: aastore
    //   41: putstatic 206	b:z	[Ljava/lang/String;
    //   44: goto +140 -> 184
    //   47: swap
    //   48: invokevirtual 196	java/lang/String:toCharArray	()[C
    //   51: dup
    //   52: arraylength
    //   53: swap
    //   54: iconst_0
    //   55: istore_0
    //   56: swap
    //   57: dup_x1
    //   58: iconst_1
    //   59: if_icmpgt +79 -> 138
    //   62: dup
    //   63: iload_0
    //   64: dup2
    //   65: caload
    //   66: iload_0
    //   67: iconst_5
    //   68: irem
    //   69: tableswitch	default:+51 -> 120, 0:+31->100, 1:+36->105, 2:+41->110, 3:+46->115
    //   101: astore_3
    //   102: goto +20 -> 122
    //   105: bipush 85
    //   107: goto +15 -> 122
    //   110: bipush 59
    //   112: goto +10 -> 122
    //   115: bipush 18
    //   117: goto +5 -> 122
    //   120: bipush 78
    //   122: ixor
    //   123: i2c
    //   124: castore
    //   125: iinc 0 1
    //   128: swap
    //   129: dup_x1
    //   130: ifne +8 -> 138
    //   133: dup2
    //   134: swap
    //   135: goto -71 -> 64
    //   138: swap
    //   139: dup_x1
    //   140: iload_0
    //   141: if_icmpgt -79 -> 62
    //   144: new 190	java/lang/String
    //   147: dup_x1
    //   148: swap
    //   149: invokespecial 200	java/lang/String:<init>	([C)V
    //   152: invokevirtual 204	java/lang/String:intern	()Ljava/lang/String;
    //   155: swap
    //   156: pop
    //   157: swap
    //   158: tableswitch	default:+-145 -> 13, 0:+-136->22, 1:+-127->31, 2:+-118->40
    //   185: nop
    //   186: fneg
    //   187: swap
    //   188: invokevirtual 196	java/lang/String:toCharArray	()[C
    //   191: dup
    //   192: arraylength
    //   193: swap
    //   194: iconst_0
    //   195: istore_0
    //   196: swap
    //   197: dup_x1
    //   198: iconst_1
    //   199: if_icmpgt +79 -> 278
    //   202: dup
    //   203: iload_0
    //   204: dup2
    //   205: caload
    //   206: iload_0
    //   207: iconst_5
    //   208: irem
    //   209: tableswitch	default:+51 -> 260, 0:+31->240, 1:+36->245, 2:+41->250, 3:+46->255
    //   241: astore_3
    //   242: goto +20 -> 262
    //   245: bipush 85
    //   247: goto +15 -> 262
    //   250: bipush 59
    //   252: goto +10 -> 262
    //   255: bipush 18
    //   257: goto +5 -> 262
    //   260: bipush 78
    //   262: ixor
    //   263: i2c
    //   264: castore
    //   265: iinc 0 1
    //   268: swap
    //   269: dup_x1
    //   270: ifne +8 -> 278
    //   273: dup2
    //   274: swap
    //   275: goto -71 -> 204
    //   278: swap
    //   279: dup_x1
    //   280: iload_0
    //   281: if_icmpgt -79 -> 202
    //   284: new 190	java/lang/String
    //   287: dup_x1
    //   288: swap
    //   289: invokespecial 200	java/lang/String:<init>	([C)V
    //   292: invokevirtual 204	java/lang/String:intern	()Ljava/lang/String;
    //   295: swap
    //   296: pop
    //   297: swap
    //   298: pop
    //   299: goto +32 -> 331
    //   302: ldc 31
    //   304: putstatic 32	b:a	I
    //   307: bipush 128
    //   309: putstatic 34	b:b	B
    //   312: sipush -32768
    //   315: putstatic 36	b:c	S
    //   318: ldc2_w 38
    //   321: putstatic 40	b:d	J
    //   324: ldc 42
    //   326: bipush 255
    //   328: goto -141 -> 187
    //   331: putstatic 44	b:e	Ljava/lang/String;
    //   334: ldc 31
    //   336: invokestatic 46	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   339: putstatic 52	b:g	Ljava/lang/Integer;
    //   342: bipush 128
    //   344: invokestatic 54	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   347: putstatic 59	b:h	Ljava/lang/Byte;
    //   350: sipush -32768
    //   353: invokestatic 61	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   356: putstatic 66	b:i	Ljava/lang/Short;
    //   359: ldc2_w 38
    //   362: invokestatic 68	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   365: putstatic 73	b:j	Ljava/lang/Long;
    //   368: getstatic 75	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   371: putstatic 80	b:k	Ljava/lang/Boolean;
    //   374: return
  }

  // ERROR //
  public static void main(String[] paramArrayOfString)
    throws java.lang.Exception
  {
    // Byte code:
    //   0: getstatic 185	b:m	Z
    //   3: istore_3
    //   4: getstatic 34	b:b	B
    //   7: getstatic 36	b:c	S
    //   10: ixor
    //   11: i2l
    //   12: getstatic 40	b:d	J
    //   15: getstatic 52	b:g	Ljava/lang/Integer;
    //   18: invokevirtual 96	java/lang/Integer:intValue	()I
    //   21: i2l
    //   22: lmul
    //   23: lor
    //   24: l2i
    //   25: putstatic 32	b:a	I
    //   28: iconst_0
    //   29: istore_1
    //   30: iload_3
    //   31: ifeq +61 -> 92
    //   34: getstatic 188	d:a	Z
    //   37: ifeq +12 -> 49
    //   40: goto +4 -> 44
    //   43: athrow
    //   44: iconst_0
    //   45: goto +5 -> 50
    //   48: athrow
    //   49: iconst_1
    //   50: putstatic 188	d:a	Z
    //   53: getstatic 100	java/lang/System:out	Ljava/io/PrintStream;
    //   56: new 106	java/lang/StringBuilder
    //   59: dup
    //   60: getstatic 206	b:z	[Ljava/lang/String;
    //   63: iconst_2
    //   64: aaload
    //   65: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   68: getstatic 44	b:e	Ljava/lang/String;
    //   71: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc 117
    //   76: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_0
    //   80: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokevirtual 126	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   89: iinc 1 1
    //   92: iload_1
    //   93: iconst_5
    //   94: if_icmplt -41 -> 53
    //   97: iconst_0
    //   98: putstatic 34	b:b	B
    //   101: iload_3
    //   102: ifeq +32 -> 134
    //   105: goto +4 -> 109
    //   108: athrow
    //   109: getstatic 34	b:b	B
    //   112: bipush 11
    //   114: if_icmple +20 -> 134
    //   117: goto +4 -> 121
    //   120: athrow
    //   121: new 94	java/lang/Exception
    //   124: dup
    //   125: getstatic 206	b:z	[Ljava/lang/String;
    //   128: iconst_1
    //   129: aaload
    //   130: invokespecial 133	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   133: athrow
    //   134: getstatic 34	b:b	B
    //   137: dup
    //   138: iconst_1
    //   139: iadd
    //   140: i2b
    //   141: putstatic 34	b:b	B
    //   144: bipush 10
    //   146: if_icmplt -37 -> 109
    //   149: getstatic 32	b:a	I
    //   152: ifne +16 -> 168
    //   155: getstatic 32	b:a	I
    //   158: bipush 12
    //   160: iadd
    //   161: putstatic 32	b:a	I
    //   164: goto +4 -> 168
    //   167: athrow
    //   168: getstatic 32	b:a	I
    //   171: tableswitch	default:+29 -> 200, 1:+25->196, 2:+29->200, 3:+29->200
    //   197: nop
    //   198: iconst_1
    //   199: athrow
    //   200: new 134	c
    //   203: dup
    //   204: new 1	b
    //   207: dup
    //   208: invokespecial 135	b:<init>	()V
    //   211: dup
    //   212: invokevirtual 136	java/lang/Object:getClass	()Ljava/lang/Class;
    //   215: pop
    //   216: getstatic 32	b:a	I
    //   219: ifne +8 -> 227
    //   222: iconst_5
    //   223: goto +6 -> 229
    //   226: athrow
    //   227: bipush 6
    //   229: getstatic 34	b:b	B
    //   232: invokespecial 140	c:<init>	(Lb;IB)V
    //   235: astore_1
    //   236: aload_1
    //   237: invokestatic 143	c:a	(Lc;)Ljava/lang/String;
    //   240: pop
    //   241: getstatic 100	java/lang/System:out	Ljava/io/PrintStream;
    //   244: getstatic 206	b:z	[Ljava/lang/String;
    //   247: iconst_3
    //   248: aaload
    //   249: invokevirtual 148	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   252: invokestatic 151	java/lang/System:currentTimeMillis	()J
    //   255: pop2
    //   256: new 155	java/util/Date
    //   259: dup
    //   260: invokespecial 157	java/util/Date:<init>	()V
    //   263: invokevirtual 136	java/lang/Object:getClass	()Ljava/lang/Class;
    //   266: invokevirtual 136	java/lang/Object:getClass	()Ljava/lang/Class;
    //   269: invokevirtual 158	java/lang/Class:getFields	()[Ljava/lang/reflect/Field;
    //   272: pop
    //   273: new 164	java/util/ArrayList
    //   276: dup
    //   277: invokespecial 166	java/util/ArrayList:<init>	()V
    //   280: astore_2
    //   281: aload_2
    //   282: new 164	java/util/ArrayList
    //   285: dup
    //   286: bipush 100
    //   288: invokespecial 167	java/util/ArrayList:<init>	(I)V
    //   291: invokeinterface 170 2 0
    //   296: pop
    //   297: return
    //
    // Exception table:
    //   from	to	target	type
    //   30	40	43	java/lang/Exception
    //   37	48	48	java/lang/Exception
    //   92	105	108	java/lang/Exception
    //   97	117	120	java/lang/Exception
    //   149	164	167	java/lang/Exception
    //   168	199	199	java/lang/Exception
    //   200	226	226	java/lang/Exception
  }

  public String a()
  {
    return this.l;
  }

  static Byte b()
  {
    return h;
  }

  static void a(Byte paramByte)
  {
    h = paramByte;
  }
}

/* Location:           C:\work5\TestDecompilers\distrib\test_Zelix.jar
 * Qualified Name:     b
 * JD-Core Version:    0.6.0
 */