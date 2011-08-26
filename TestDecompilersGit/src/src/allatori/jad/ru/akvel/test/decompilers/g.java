// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) nolvt deadcode fieldsfirst splitstr(180) ansi 
// Source File Name:   b

package allatori.jad.ru.akvel.test.decompilers;

import g;
import java.io.PrintStream;

// Referenced classes of package ru.akvel.test.decompilers:
//            Test1

class g
{

    private int j;
    private long g;
    final Test1 D;

    protected g(Test1 test1)
    {
        D = test1;
        super();
        Test1.L(Byte.valueOf((byte)(Test1.L().byteValue() + 1)));
        System.out.println(g.m("]qd0"));
    }

    protected g(Test1 test1, int i, byte byte0)
    {
        this(test1);
        g = i;
        j = byte0;
    }

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
}
