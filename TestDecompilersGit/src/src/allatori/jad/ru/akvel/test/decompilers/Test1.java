// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) nolvt deadcode fieldsfirst splitstr(180) ansi 
// Source File Name:   b

package allatori.jad.ru.akvel.test.decompilers;


// Referenced classes of package ru.akvel.test.decompilers:
//            g

public class Test1
{
    private class g
    {

        private int j;
        private long g;
        final Test1 D;

        static String L(g g1)
        {
            return g1.L();
        }

        /**
         * @deprecated Method L is deprecated
         */

        private String L()
        {
            return (new StringBuilder()).append(g + (long)j).toString();
        }

        protected g()
        {
            D = Test1.this;
            super();
            Test1.L(Byte.valueOf((byte)(Test1.L().byteValue() + 1)));
            System.out.println(g.m("]qd0"));
        }

        protected g(int k, byte byte0)
        {
            this(Test1.this);
            g = k;
            j = byte0;
        }
    }


    private static Boolean G;
    private static byte d = -128;
    private final String i = "passed";
    private static Byte B = Byte.valueOf((byte)-128);
    private static short m = -32768;
    private static Long I = Long.valueOf(0x8000000000000000L);
    private static Integer e = Integer.valueOf(0x80000000);
    private static Short H = Short.valueOf((short)-32768);
    private static String j = "Just test";
    private static int g = 0x80000000;
    private static long D = 0x8000000000000000L;
    public boolean b;

    public String getA()
    {
        return i;
    }

    protected Test1()
    {
        b = false;
    }

    static Byte L()
    {
        return B;
    }

    static void L(Byte byte1)
    {
        B = byte1;
    }

    public static void main(String args[])
        throws Exception
    {
        System.out.println(g.m("\023;9:>;=:2;1:6;5:*;):.;-:\";!:&;%:\032;\031:\036;\035:\022;\021:\026;\025:\n\022\t9\r8\0169\0018\0029\0058\006998:9=8>918295869)8*9-8.9!8\"9%8&9\031;0:\0358\0369\0218\0229\026;\026" +
":\t8\n:\r8\0169\002;\002:\006;\006::;::>8>:2;295869)8)\023.8.9!8\"9&8%9\0328\0329\0368\0369\0228\0219\025;\0269\n8\t9\0168\r9\001;\0029\0058\006998::\027;>918295;5:);*9-;.9!;!:%8%9" +
"\031;\032:\035;\0359\0218\0219\0258\0269\t8\n9\016\022\r9\0018\0029\0058\0059:89:>8=:2819686:)8):.8-9\"8!:&8&9\0318\0329\035;4:\0218\0229\0258\0269\t8\n9\r8\0169\0018\0029\0058\006" +
"998:9=8>918295869)8*9-8-\023\"8M{cmuzXlSvS8\\`\021Y^uTlYk@8e{Km]z@lMk\005n\0257*8^\\PW>:\033;295869)8*9-8.9!8\"9%8&9\0318\0329\0358\0369\0218\0229\0258\0269\t8\n9\r8\0169\002\022\001" +
"9\0058\006998:9=8vmeh(6:oan'yfullakh6avh8&9\0318\0329\0358\0369\021;8:\0258\0269\t8\n9\r8\0169\0018\0029\0058\006998:9=8>918295869)8*9-8.9!8!\023&;%:\032;\031:\036;\035:\022;\021:\026" +
";\025:\n;\t:\016;\r:\002;\001:\006;\005::;9:>;=:2;1:_"
));
        g = (int)((long)(d ^ m) | D * (long)e.intValue());
        int k = 0;
          goto _L1
_L3:
        System.out.print((new StringBuilder(g.m("Euaeu"))).append(j).append(g.m("u")).append(args).toString());
        ++k;
_L1:
        5;
        JVM INSTR icmplt 41;
           goto _L2 _L3
_L2:
        d = 0;
        d;
          goto _L4
_L6:
        if(d > 11)
            throw new Exception(g.m("Aqe!"));
        d;
_L4:
        JVM INSTR dup ;
        1;
        JVM INSTR iadd ;
        (byte);
        d;
        10;
        JVM INSTR icmplt 98;
           goto _L5 _L6
_L5:
        if(g == 0)
            g += 12;
        g g1;
        switch(g)
        {
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        default:
            ru.akvel.test.decompilers.g.L(g1 = new g(new Test1(), g != 0 ? 6 : 5, d));
            break;
        }
        System.out.println(g.m("aqe!"));
        System.currentTimeMillis();
        (new Date()).getClass().getClass().getFields();
        (new ArrayList()).addAll(new ArrayList(100));
        return;
    }

    static 
    {
        G = Boolean.FALSE;
    }
}
