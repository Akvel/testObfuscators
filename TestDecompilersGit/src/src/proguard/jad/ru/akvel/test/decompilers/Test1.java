// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) nolvt deadcode fieldsfirst splitstr(180) ansi 

package proguard.jad.ru.akvel.test.decompilers;

import java.io.PrintStream;
import java.util.*;

// Referenced classes of package ru.akvel.test.decompilers:
//            b

public class Test1
{

    private static int a_int_statictt = 0x80000000;
    private static byte a_byte_statictt = -128;
    private static short a_short_statictt = -32768;
    private static long a_long_statictt = 0x8000000000000000L;
    private static String a_java_lang_String_statictt = "Just test";
    private boolean a_booleantt;
    private static Integer a_java_lang_Integer_statictt = Integer.valueOf(0x80000000);
    private static Byte a_java_lang_Byte_statictt = Byte.valueOf((byte)-128);
    private static Short a_java_lang_Short_statictt;
    private static Long a_java_lang_Long_statictt;
    private static Boolean a_java_lang_Boolean_statictt;
    private final String b = "passed";

    protected Test1()
    {
    }

    public static void main(String args[])
    {
        a_int_statictt = (int)((long)(a_byte_statictt ^ a_short_statictt) | a_long_statictt * (long)a_java_lang_Integer_statictt.intValue());
        for(int i = 0; i < 5; i++)
            System.out.print((new StringBuilder("Test ")).append(a_java_lang_String_statictt).append(" ").append(args).toString());

        for(a_byte_statictt = 0; a_byte_statictt++ < 10;)
            if(a_byte_statictt > 11)
                throw new Exception("Test");

        if(a_int_statictt == 0)
            a_int_statictt += 12;
        int  = a_int_statictt;
        (new Test1()).getClass();
        ru.akvel.test.decompilers.b.a(new b(a_int_statictt != 0 ? 6 : 5, a_byte_statictt));
        System.out.println("test");
        (new Date()).getClass().getClass().getFields();
        (new ArrayList()).addAll(new ArrayList(100));
    }

    private String a()
    {
        return b;
    }

    static Byte a()
    {
        return a_java_lang_Byte_statictt;
    }

    static void a(Byte byte1)
    {
        a_java_lang_Byte_statictt = byte1;
    }

    static 
    {
        Boolean  = Boolean.FALSE;
    }
}
