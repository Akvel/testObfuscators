// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) nolvt deadcode fieldsfirst splitstr(180) ansi 
// Source File Name:   Start.java

package classguard.jad.com.zenofx.classguard.bootstrap;

import java.lang.reflect.Method;

// Referenced classes of package com.zenofx.classguard.bootstrap:
//            ClassGuard, LicenseInterface

public class Start
{

    public Start()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        ClassGuard classguard = new ClassGuard(com/zenofx/classguard/bootstrap/Start.getClassLoader());
        ClassGuard  = classguard;
        String s = ClassGuard.getManifestAttribute("ClassGuard-Main-Class");
        s = System.getProperty("classguard.main.class", s);
        Class class1 = null;
        LicenseInterface licenseinterface = classguard.getLicenseAdapter();
        try
        {
            s = s.replace('/', '.');
            try
            {
                class1 = Class.forName(s, true, classguard);
            }
            catch(ClassNotFoundException classnotfoundexception)
            {
                ClassGuard 1 = classguard;
                String s1 = ClassGuard.getManifestAttribute("ClassGuard-Product-Name");
                if(s1 == null)
                {
                    licenseinterface.error((new StringBuilder()).append("Start class ").append(s).append(" not found.").toString());
                    System.exit(1);
                } else
                {
                    String s2 = licenseinterface.requestLicense(classguard, s1);
                    if(s2 == null)
                        System.exit(1);
                    licenseinterface.storeLicense(s1, s2);
                }
                class1 = Class.forName(s, true, classguard);
            }
        }
        catch(Throwable throwable)
        {
            licenseinterface.error(throwable.getMessage());
            System.exit(1);
        }
        Method method = class1.getDeclaredMethod("main", new Class[] {
            args.getClass()
        });
        method.invoke(null, new Object[] {
            args
        });
    }
}
