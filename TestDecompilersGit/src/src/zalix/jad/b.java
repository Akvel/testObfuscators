// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) nolvt deadcode fieldsfirst splitstr(180) ansi 
// Source File Name:   b.java

package zalix.jad;

import java.io.PrintStream;
import java.util.*;

public class b
{

    private static int a;
    private static byte b;
    private static short c;
    private static long d;
    private static String e;
    public boolean f;
    private static Integer g;
    private static Byte h;
    private static Short i;
    private static Long j;
    private static Boolean k;
    private final String l;
    public static boolean m;
    private static final String z[];

    protected b()
    {
        f = false;
        l = z[0];
    }

    public static void main(String args[])
        throws Exception
    {
        int i1;
        boolean flag;
        flag = m;
        a = (int)((long)(b ^ c) | d * (long)g.intValue());
        i1 = 0;
        if(!flag) goto _L2; else goto _L1
_L1:
        d.a;
        JVM INSTR ifeq 49;
           goto _L3 _L4
_L3:
        break MISSING_BLOCK_LABEL_44;
_L4:
        break MISSING_BLOCK_LABEL_49;
        throw ;
        d.a = false;
        break MISSING_BLOCK_LABEL_53;
        throw ;
        d.a = true;
_L6:
        System.out.print((new StringBuilder(z[2])).append(e).append(" ").append(args).toString());
        i1++;
_L2:
        if(i1 < 5) goto _L6; else goto _L5
_L5:
        b = 0;
        break MISSING_BLOCK_LABEL_101;
        throw ;
        throw ;
label0:
        {
            if(flag || b++ < 10)
            {
                if(b > 11)
                    throw new Exception(z[1]);
                continue; /* Loop/switch isn't completed */
            }
            try
            {
                if(a == 0)
                    a += 12;
                break label0;
            }
            catch(Exception ee) { }
        }
        try
        {
            switch(a)
            {
            }
            break MISSING_BLOCK_LABEL_200;
        }
        catch(Exception ee) { }
        throw ;
        c c1 = new c(new b(), a != 0 ? 6 : 5, b);
        c.a(c1);
        System.out.println(z[3]);
        System.currentTimeMillis();
        (new Date()).getClass().getClass().getFields();
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(new ArrayList(100));
        return;
    }

    public String a()
    {
        return l;
    }

    static Byte b()
    {
        return h;
    }

    static void a(Byte byte1)
    {
        h = byte1;
    }

    static 
    {
        String as[] = new String[4];
        as;
        as;
        0;
        ">4Ha+*";
        -1;
          goto _L1
_L8:
        JVM INSTR aastore ;
        JVM INSTR dup ;
        true;
        "\0320Hf";
        false;
          goto _L1
_L9:
        JVM INSTR aastore ;
        JVM INSTR dup ;
        2;
        "\0320Hfn";
        true;
          goto _L1
_L10:
        JVM INSTR aastore ;
        JVM INSTR dup ;
        3;
        ":0Hf";
        2;
          goto _L1
_L11:
        JVM INSTR aastore ;
        z;
          goto _L2
_L1:
        JVM INSTR swap ;
        toCharArray();
        JVM INSTR dup ;
        JVM INSTR arraylength .length;
        JVM INSTR swap ;
        int i1 = 0;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        1;
        JVM INSTR icmpgt 138;
           goto _L3 _L4
_L3:
        JVM INSTR dup ;
        i1;
_L6:
        JVM INSTR dup2 ;
        JVM INSTR caload ;
        byte byte0;
        switch(i1 % 5)
        {
        case 0: // '\0'
            byte0 = 0x4e;
            break;

        case 1: // '\001'
            byte0 = 85;
            break;

        case 2: // '\002'
            byte0 = 59;
            break;

        case 3: // '\003'
            byte0 = 18;
            break;

        default:
            byte0 = 78;
            break;
        }
        byte0;
        JVM INSTR ixor ;
        (char);
        JVM INSTR castore ;
        i1++;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        JVM INSTR ifne 138;
           goto _L5 _L4
_L5:
        JVM INSTR dup2 ;
        JVM INSTR swap ;
          goto _L6
_L4:
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        i1;
        JVM INSTR icmpgt 62;
           goto _L7 _L3
_L7:
        JVM INSTR new #190 <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
        intern();
        JVM INSTR swap ;
        JVM INSTR pop ;
        JVM INSTR swap ;
        char ac[];
        byte byte1;
        JVM INSTR tableswitch 0 2: default 13
    //                   0 22
    //                   1 31
    //                   2 40;
           goto _L8 _L9 _L10 _L11
_L21:
        ac = "\004 Hfn:0Hf".toCharArray();
          goto _L12
_L14:
        ac;
          goto _L13
_L12:
        ac.length;
          goto _L14
_L13:
        i1 = 0;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        1;
        JVM INSTR icmpgt 278;
           goto _L15 _L16
_L15:
        JVM INSTR dup ;
        i1;
_L18:
        JVM INSTR dup2 ;
        JVM INSTR caload ;
        switch(i1 % 5)
        {
        case 0: // '\0'
            byte1 = 0x4e;
            break;

        case 1: // '\001'
            byte1 = 85;
            break;

        case 2: // '\002'
            byte1 = 59;
            break;

        case 3: // '\003'
            byte1 = 18;
            break;

        default:
            byte1 = 78;
            break;
        }
        byte1;
        JVM INSTR ixor ;
        (char);
        JVM INSTR castore ;
        i1++;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        JVM INSTR ifne 278;
           goto _L17 _L16
_L17:
        JVM INSTR dup2 ;
        JVM INSTR swap ;
          goto _L18
_L16:
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        i1;
        JVM INSTR icmpgt 202;
           goto _L19 _L15
_L19:
        JVM INSTR new #190 <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
        intern();
        JVM INSTR swap ;
        JVM INSTR pop ;
        JVM INSTR swap ;
        JVM INSTR pop ;
          goto _L20
_L2:
        a = 0x80000000;
        b = -128;
        c = -32768;
        d = 0x8000000000000000L;
        -1;
          goto _L21
_L20:
        e;
        g = Integer.valueOf(0x80000000);
        h = Byte.valueOf((byte)-128);
        i = Short.valueOf((short)-32768);
        j = Long.valueOf(0x8000000000000000L);
        k = Boolean.FALSE;
    }
}
