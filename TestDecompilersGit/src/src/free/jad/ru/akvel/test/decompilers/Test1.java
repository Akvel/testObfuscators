// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) nolvt deadcode fieldsfirst splitstr(180) ansi 
// Source File Name:   Test1.java

package free.jad.ru.akvel.test.decompilers;

import java.io.PrintStream;
import java.util.*;

public class Test1
{
    private class TestClass
    {

        private long a;
        private int b;
        final Test1 this$0;

        /**
         * @deprecated Method Test is deprecated
         */

        private String Test()
        {
            return (new StringBuilder()).append(a + (long)b).toString();
        }


        protected TestClass()
        {
            this$0 = Test1.this;
            super();
            Test1.fByteC = Byte.valueOf((byte)(Test1.fByteC.byteValue() + 1));
            System.out.println("Here");
        }

        protected TestClass(int i, byte byte0)
        {
            this();
            a = i;
            b = byte0;
        }
    }


    private static int fInt = 0x80000000;
    private static byte fByte = -128;
    private static short fShort = -32768;
    private static long fLong = 0x8000000000000000L;
    private static String fString = "Just test";
    public boolean b;
    private static Integer fIntC = Integer.valueOf(0x80000000);
    private static Byte fByteC = Byte.valueOf((byte)-128);
    private static Short fShortC = Short.valueOf((short)-32768);
    private static Long fLongC = Long.valueOf(0x8000000000000000L);
    private static Boolean fBoolC;
    private final String a = "passed";

    protected Test1()
    {
        b = false;
    }

    public static void main(String args[])
        throws Exception
    {
        fInt = (int)((long)(fByte ^ fShort) | fLong * (long)fIntC.intValue());
        for(int i = 0; i < 5; i++)
            System.out.print((new StringBuilder("Test ")).append(fString).append(" ").append(args).toString());

        for(fByte = 0; fByte++ < 10;)
            if(fByte > 11)
                throw new Exception("Test");

        if(fInt == 0)
            fInt += 12;
        TestClass testclass;
        switch(fInt)
        {
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        default:
            testclass = (new Test1()). new TestClass(fInt != 0 ? 6 : 5, fByte);
            break;
        }
        testclass.Test();
        System.out.println("test");
        System.currentTimeMillis();
        (new Date()).getClass().getClass().getFields();
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(new ArrayList(100));
    }

    public String getA()
    {
        return a;
    }

    static 
    {
        fBoolC = Boolean.FALSE;
    }


}
