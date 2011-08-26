// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) nolvt deadcode fieldsfirst splitstr(180) ansi 
// Source File Name:   Base32.java

package classguard.jad.com.zenofx.classguard.bootstrap;


public class Base32
{

    private static final String base32Chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567";
    private static final byte base32Lookup[] = {
        26, 27, 28, 29, 30, 31, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 
        5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
        15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
        25, -1, -1, -1, -1, -1, -1, 0, 1, 2, 
        3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 
        13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 
        23, 24, 25
    };

    public Base32()
    {
    }

    public static String encode(byte abyte0[])
    {
        StringBuffer stringbuffer = new StringBuffer((abyte0.length * 8 + 4) / 5);
        int k = 0;
        do
        {
            if(k >= abyte0.length)
                break;
            int i = abyte0[k++] & 0xff;
            stringbuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567".charAt(i >> 3));
            int j = (i & 7) << 2;
            if(k >= abyte0.length)
            {
                stringbuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567".charAt(j));
                break;
            }
            i = abyte0[k++] & 0xff;
            stringbuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567".charAt(j | i >> 6));
            stringbuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567".charAt(i >> 1 & 0x1f));
            j = (i & 1) << 4;
            if(k >= abyte0.length)
            {
                stringbuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567".charAt(j));
                break;
            }
            i = abyte0[k++] & 0xff;
            stringbuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567".charAt(j | i >> 4));
            j = (i & 0xf) << 1;
            if(k >= abyte0.length)
            {
                stringbuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567".charAt(j));
                break;
            }
            i = abyte0[k++] & 0xff;
            stringbuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567".charAt(j | i >> 7));
            stringbuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567".charAt(i >> 2 & 0x1f));
            j = (i & 3) << 3;
            if(k >= abyte0.length)
            {
                stringbuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567".charAt(j));
                break;
            }
            i = abyte0[k++] & 0xff;
            stringbuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567".charAt(j | i >> 5));
            stringbuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567".charAt(i & 0x1f));
        } while(true);
        return stringbuffer.toString();
    }

    public static byte[] decodeUserInput(String s)
        throws IllegalArgumentException
    {
        StringBuffer stringbuffer = new StringBuffer(s);
        for(int i = 0; i < stringbuffer.length();)
            if(Character.isWhitespace(stringbuffer.charAt(i)) || stringbuffer.charAt(i) == '-')
                stringbuffer.deleteCharAt(i);
            else
                i++;

        return decode(stringbuffer.toString());
    }

    public static byte[] decode(String s)
        throws IllegalArgumentException
    {
        byte abyte0[] = new byte[(s.length() * 5) / 8];
        int i = 0;
        int j = 0;
        int k = 0;
        byte byte0 = 0;
        do
            if(k < s.length())
            {
                int l = s.charAt(k++) - 50;
                if(l < 0 || l >= base32Lookup.length)
                    throw new IllegalArgumentException();
                byte byte1 = base32Lookup[l];
                if(byte1 == -1)
                    throw new IllegalArgumentException();
                switch(i)
                {
                case 0: // '\0'
                    byte0 = (byte)(byte1 << 3);
                    i = 5;
                    break;

                case 5: // '\005'
                    abyte0[j++] = (byte)(byte0 | byte1 >> 2);
                    byte0 = (byte)((byte1 & 3) << 6);
                    i = 2;
                    break;

                case 2: // '\002'
                    byte0 |= (byte)(byte1 << 1);
                    i = 7;
                    break;

                case 7: // '\007'
                    abyte0[j++] = (byte)(byte0 | byte1 >> 4);
                    byte0 = (byte)((byte1 & 0xf) << 4);
                    i = 4;
                    break;

                case 4: // '\004'
                    abyte0[j++] = (byte)(byte0 | byte1 >> 1);
                    byte0 = (byte)((byte1 & 1) << 7);
                    i = 1;
                    break;

                case 1: // '\001'
                    byte0 |= (byte)(byte1 << 2);
                    i = 6;
                    break;

                case 6: // '\006'
                    abyte0[j++] = (byte)(byte0 | byte1 >> 3);
                    byte0 = (byte)((byte1 & 7) << 5);
                    i = 3;
                    break;

                case 3: // '\003'
                    abyte0[j++] = (byte)(byte0 | byte1);
                    i = 0;
                    break;
                }
            } else
            {
                return abyte0;
            }
        while(true);
    }

}
