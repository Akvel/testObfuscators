// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) nolvt deadcode fieldsfirst splitstr(180) ansi 
// Source File Name:   c.java

package zalix.jad;

import java.io.PrintStream;

class c
{

    private long b;
    private int c;
    final b d;
    private static final String z;

    protected c(b b1)
    {
        boolean flag = b.m;
        d = b1;
        super();
        b.a(Byte.valueOf((byte)(b.b().byteValue() + 1)));
        System.out.println(z);
        if(d.a)
            b.m = !flag;
    }

    protected c(b b1, int i, byte byte0)
    {
        this(b1);
        b = i;
        c = byte0;
    }

    /**
     * @deprecated Method a is deprecated
     */

    private String a()
    {
        return (new StringBuilder()).append(b + (long)c).toString();
    }

    static String a(c c1)
    {
        return c1.a();
    }

    static 
    {
        "*k\013]";
        -1;
          goto _L1
_L7:
        z;
        break MISSING_BLOCK_LABEL_126;
_L1:
        JVM INSTR swap ;
        toCharArray();
        JVM INSTR dup ;
        JVM INSTR arraylength .length;
        JVM INSTR swap ;
        int i = 0;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        1;
        JVM INSTR icmpgt 102;
           goto _L2 _L3
_L2:
        JVM INSTR dup ;
        i;
_L5:
        JVM INSTR dup2 ;
        JVM INSTR caload ;
        byte byte0;
        switch(i % 5)
        {
        case 0: // '\0'
            byte0 = 0x62;
            break;

        case 1: // '\001'
            byte0 = 14;
            break;

        case 2: // '\002'
            byte0 = 121;
            break;

        case 3: // '\003'
            byte0 = 56;
            break;

        default:
            byte0 = 100;
            break;
        }
        byte0;
        JVM INSTR ixor ;
        (char);
        JVM INSTR castore ;
        i++;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        JVM INSTR ifne 102;
           goto _L4 _L3
_L4:
        JVM INSTR dup2 ;
        JVM INSTR swap ;
          goto _L5
_L3:
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        i;
        JVM INSTR icmpgt 28;
           goto _L6 _L2
_L6:
        JVM INSTR new #87  <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
        intern();
        JVM INSTR swap ;
        JVM INSTR pop ;
        JVM INSTR swap ;
        JVM INSTR pop ;
          goto _L7
    }
}
