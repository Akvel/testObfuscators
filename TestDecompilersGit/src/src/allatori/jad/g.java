// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) nolvt deadcode fieldsfirst splitstr(180) ansi 
// Source File Name:   d

package allatori.jad;


public class g
{

    public static String m(String s)
    {
        JVM INSTR new #6   <Class String>;
        JVM INSTR dup ;
        new char[s.length()];
        true;
        true;
        JVM INSTR pop2 ;
        85;
        JVM INSTR swap ;
        JVM INSTR dup ;
        JVM INSTR arraylength .length;
        1;
        JVM INSTR isub ;
        JVM INSTR dup_x2 ;
        int i;
        i;
        char ac[];
        ac;
        char c;
        c;
_L10:
        JVM INSTR iflt 83;
           goto _L1 _L2
_L1:
        ac;
          goto _L3
_L5:
        i;
          goto _L4
_L3:
        (char)(s.charAt(i) ^ c);
          goto _L5
_L4:
        JVM INSTR dup_x1 ;
        c;
        JVM INSTR ixor ;
        (char);
        0x3f;
        JVM INSTR iand ;
        (char);
        c;
        JVM INSTR castore ;
        if(--i < 0) goto _L2; else goto _L6
_L6:
        ac;
          goto _L7
_L9:
        i;
          goto _L8
_L7:
        (char)(s.charAt(i) ^ c);
          goto _L9
_L8:
        JVM INSTR dup_x1 ;
        c;
        JVM INSTR ixor ;
        (char);
        0x3f;
        JVM INSTR iand ;
        (char);
        c;
        JVM INSTR castore ;
        --i;
          goto _L10
_L2:
        ac;
        String();
        return;
    }

    public static String L(String s)
    {
        s;
        1;
        1;
        JVM INSTR dup_x2 ;
        (new Exception()).getStackTrace();
        JVM INSTR swap ;
        JVM INSTR aaload ;
        new StringBuffer();
        JVM INSTR swap ;
        JVM INSTR dup ;
        getClassName();
        JVM INSTR swap ;
        getMethodName();
        append();
        JVM INSTR swap ;
        append();
        toString();
        JVM INSTR dup_x1 ;
        length();
        JVM INSTR swap ;
        JVM INSTR isub ;
        JVM INSTR dup_x1 ;
        int i;
        i;
        String s1;
        s1;
        int j;
        j;
        length();
        JVM INSTR dup ;
        new char[];
        char ac[];
        ac;
        char c = 'U';
        JVM INSTR swap ;
        JVM INSTR isub ;
        int k;
        k;
          goto _L1
_L3:
        0x3f;
        c;
        s1.charAt(j);
        JVM INSTR dup_x1 ;
        k;
        JVM INSTR dup_x1 ;
        s;
        JVM INSTR swap ;
        charAt();
        c;
        JVM INSTR ixor ;
        JVM INSTR ixor ;
        (char);
        JVM INSTR castore ;
        JVM INSTR ixor ;
        JVM INSTR ixor ;
        JVM INSTR iand ;
        (char);
        c;
        if(--j < 0)
            j = i;
        k--;
_L1:
        ac;
        k;
        if(k >= 0) goto _L3; else goto _L2
_L2:
        JVM INSTR pop2 ;
        JVM INSTR new #6   <Class String>;
        ac;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
        return;
    }
}
