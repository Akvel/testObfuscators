// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) nolvt deadcode fieldsfirst splitstr(180) ansi 
// Source File Name:   GUIHelper.java

package classguard.jad.com.zenofx.classguard.bootstrap;

import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.JButton;

public class GUIHelper
{

    public static final int GAP = 3;
    private static final Dimension BUTTON_SIZE = new Dimension(90, 25);
    public static final Insets INSETS = new Insets(3, 3, 3, 3);

    public GUIHelper()
    {
    }

    public static JButton createButton(String s)
    {
        JButton jbutton = new JButton(s);
        jbutton.setPreferredSize(BUTTON_SIZE);
        jbutton.setMinimumSize(BUTTON_SIZE);
        jbutton.setMaximumSize(BUTTON_SIZE);
        return jbutton;
    }

    public static JButton createBigButton(String s)
    {
        JButton jbutton = new JButton(s);
        return jbutton;
    }

}
