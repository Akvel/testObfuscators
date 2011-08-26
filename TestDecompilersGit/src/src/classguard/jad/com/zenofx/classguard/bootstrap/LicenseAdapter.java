// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) nolvt deadcode fieldsfirst splitstr(180) ansi 
// Source File Name:   LicenseAdapter.java

package classguard.jad.com.zenofx.classguard.bootstrap;

import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.PrintStream;
import java.util.prefs.Preferences;
import javax.swing.JOptionPane;
import net.jsecurity.classguard.bootstrap.ClassGuard;

// Referenced classes of package com.zenofx.classguard.bootstrap:
//            LicenseDialog, LicenseInterface, ClassGuard

public class LicenseAdapter
    implements LicenseInterface
{

    public LicenseAdapter()
    {
    }

    public String loadLicense(String s)
    {
        if(s == null)
            return null;
        try
        {
            Preferences preferences = Preferences.userNodeForPackage(net/jsecurity/classguard/bootstrap/ClassGuard);
            return preferences.get(s, null);
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    public String requestLicense(com.zenofx.classguard.bootstrap.ClassGuard classguard, String s)
        throws IOException
    {
        if(GraphicsEnvironment.isHeadless())
        {
            throw new IOException("License GUI not available");
        } else
        {
            LicenseDialog licensedialog = new LicenseDialog(classguard, s);
            licensedialog.setVisible(true);
            return licensedialog.getLicense();
        }
    }

    public void storeLicense(String s, String s1)
        throws IOException
    {
        try
        {
            Preferences preferences = Preferences.userNodeForPackage(net/jsecurity/classguard/bootstrap/ClassGuard);
            preferences.put(s, s1);
            preferences.flush();
        }
        catch(Exception exception)
        {
            throw new IOException("Couldn't save license to registry");
        }
    }

    public void error(String s)
    {
        if(GraphicsEnvironment.isHeadless())
            System.err.println((new StringBuilder()).append("Error: ").append(s).toString());
        else
            JOptionPane.showMessageDialog(null, s, "Error", 0);
    }
}
