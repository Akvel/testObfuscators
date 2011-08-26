// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) nolvt deadcode fieldsfirst splitstr(180) ansi 

package proguard.jad.ru.akvel.test.decompilers;

import java.io.PrintStream;

// Referenced classes of package ru.akvel.test.decompilers:
//            Test1

final class b
{

    private long a_longtt;
    private int a_inttt;
    private Test1 a_ru_akvel_test_decompilers_Test1tt;

    private b()
    {
        Test1.a(Byte.valueOf((byte)(Test1.a().byteValue() + 1)));
        System.out.println("Here");
    }

    protected b(int i, byte byte0)
    {
        this();
        a_longtt = i;
        a_inttt = byte0;
    }

    private String a()
    {
        return (new StringBuilder()).append(a_longtt + (long)a_inttt).toString();
    }

    static String a(b b1)
    {
        return (new StringBuilder()).append(b1.a_longtt + (long)b1.a_inttt).toString();
    }
}
