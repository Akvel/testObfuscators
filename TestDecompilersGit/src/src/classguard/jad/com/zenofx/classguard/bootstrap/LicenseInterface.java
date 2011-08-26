// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) nolvt deadcode fieldsfirst splitstr(180) ansi 
// Source File Name:   LicenseInterface.java

package classguard.jad.com.zenofx.classguard.bootstrap;

import java.io.IOException;

// Referenced classes of package com.zenofx.classguard.bootstrap:
//            ClassGuard

public interface LicenseInterface
{

    public abstract void error(String s);

    public abstract String loadLicense(String s);

    public abstract String requestLicense(ClassGuard classguard, String s)
        throws IOException;

    public abstract void storeLicense(String s, String s1)
        throws IOException;
}
