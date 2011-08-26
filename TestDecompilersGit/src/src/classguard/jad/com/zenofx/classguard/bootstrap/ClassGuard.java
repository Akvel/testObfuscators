// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) nolvt deadcode fieldsfirst splitstr(180) ansi 
// Source File Name:   ClassGuard.java

package classguard.jad.com.zenofx.classguard.bootstrap;

import java.io.*;
import java.net.*;
import java.security.*;
import java.util.jar.*;

// Referenced classes of package com.zenofx.classguard.bootstrap:
//            LicenseInterface, Base32

public class ClassGuard extends ClassLoader
{

    private static Boolean nativeInit = Boolean.valueOf(false);
    private static Boolean licenseInit = Boolean.valueOf(false);
    private static boolean initSuccess = false;
    private static final Manifest mf;
    private LicenseInterface licenseAdapter;

    public ClassGuard(ClassLoader classloader)
    {
        super(classloader);
        String s = getManifestAttribute("ClassGuard-License-Interface");
        if(s == null || s.length() == 0)
            s = "com.zenofx.classguard.bootstrap.LicenseAdapter";
        try
        {
            Class class1 = Class.forName(s, true, classloader);
            licenseAdapter = (LicenseInterface)class1.newInstance();
        }
        catch(Exception exception)
        {
            throw new RuntimeException("ClassGuard license adapter not found");
        }
    }

    static String getManifestAttribute(String s)
    {
        if(mf == null)
            return null;
        else
            return mf.getMainAttributes().getValue(s);
    }

    LicenseInterface getLicenseAdapter()
    {
        return licenseAdapter;
    }

    public void initLicense(String s)
        throws SignatureException, IOException
    {
        initNative();
        int i = s.indexOf('\n');
        if(i > 0 && s.charAt(i - 1) != '\r')
            s = s.replace("\n", "\r\n");
        i = s.lastIndexOf("Signature=");
        if(i < 0)
            throw new SignatureException("No signature in license file");
        byte abyte0[] = null;
        try
        {
            String s1 = s.substring(i + "Signature".length() + 1, s.length() - 2);
            abyte0 = Base32.decode(s1);
        }
        catch(Exception exception)
        {
            throw new SignatureException("Invalid signature in license file");
        }
        String s2 = s.substring(0, i);
        synchronized(licenseInit)
        {
            if(!initLicense(s2, abyte0))
                throw new SignatureException("Error in license file");
            licenseInit = Boolean.valueOf(true);
        }
    }

    public String getSystemId()
        throws IOException
    {
        initNative();
        return Base32.encode((new StringBuilder()).append(getUsername()).append("@").append(getHostname()).toString().getBytes("UTF-8"));
    }

    private static File copyStreamToTemp(InputStream inputstream, String s)
        throws IOException
    {
        String s1 = System.getProperty("classguard.tmpdir");
        File file = null;
        if(s1 != null && s1.length() > 0)
            file = new File(s1);
        File file1 = File.createTempFile("cg-", s, file);
        file1.deleteOnExit();
        FileOutputStream fileoutputstream = new FileOutputStream(file1);
        byte abyte0[] = new byte[512];
        for(int i = 0; (i = inputstream.read(abyte0, 0, abyte0.length)) != -1;)
            fileoutputstream.write(abyte0, 0, i);

        inputstream.close();
        fileoutputstream.close();
        return file1;
    }

    private byte[] loadFile(String s)
        throws IOException
    {
        InputStream inputstream = null;
        byte abyte0[];
        inputstream = getParent().getResourceAsStream(s);
        if(inputstream == null)
            throw new IOException((new StringBuilder()).append("Couldn't load ").append(s).toString());
        abyte0 = readStream(inputstream);
        if(inputstream != null)
            inputstream.close();
        return abyte0;
        Exception exception;
        exception;
        if(inputstream != null)
            inputstream.close();
        throw exception;
    }

    public static byte[] readStream(InputStream inputstream)
        throws IOException
    {
        byte abyte0[] = new byte[inputstream.available()];
        int j;
        for(int i = 0; i != abyte0.length; i += j)
        {
            j = inputstream.read(abyte0, i, abyte0.length - i);
            if(j < 0)
                throw new IOException("Unexpected end of stream");
        }

        return abyte0;
    }

    private native Class decryptClass(String s, byte abyte0[], int i)
        throws ClassNotFoundException;

    private final native byte[] getCryptedResource(byte abyte0[], int i);

    private native boolean initLicense(String s, byte abyte0[]);

    public final native String getAttribute(String s);

    public final native String getHostname();

    public final native String getUsername();

    public Class findClass(String s)
        throws ClassNotFoundException
    {
        String s1 = (new StringBuilder()).append(s.replace('.', '/')).append(".class").append("x").toString();
        URL url = getParent().getResource(s1);
        if(url == null)
            throw new ClassNotFoundException();
        byte abyte0[] = null;
        try
        {
            abyte0 = loadFile(s1);
        }
        catch(IOException ioexception)
        {
            throw new ClassNotFoundException("Couldn't load encrypted class", ioexception);
        }
        return findClassInternal(s, abyte0);
    }

    public Class findClassInternal(String s, byte abyte0[])
        throws ClassNotFoundException
    {
        try
        {
            initNative();
        }
        catch(Exception exception)
        {
            throw new RuntimeException("Couldn't load native ClassGuard library", exception);
        }
        try
        {
            initDefaultLicense();
        }
        catch(Exception exception1)
        {
            throw new ClassNotFoundException("Couldn't load default license", exception1);
        }
        Class class1 = decryptClass(s.replace('.', '/'), abyte0, abyte0.length);
        if(class1 == null)
            throw new ClassNotFoundException("Couldn't decrypt class");
        else
            return class1;
    }

    public URL getResource(final String name)
    {
        URL url = getParent().getResource(name);
        if(url != null)
            return url;
        final byte b[] = getCryptedResource(name);
        if(b == null)
            return null;
        final ByteArrayInputStream is = new ByteArrayInputStream(b);
        try
        {
            return new URL(null, (new StringBuilder()).append("classguard:").append(name).toString(), new URLStreamHandler() {

                final InputStream val$is;
                final String val$name;
                final byte val$b[];
                final ClassGuard this$0;

                protected URLConnection openConnection(URL url1)
                {
                    return new URLConnection(url1) {

                        final 1 this$1;

                        public void connect()
                        {
                        }

                        public InputStream getInputStream()
                        {
                            return is;
                        }

                        public String getContentType()
                        {
                            return getFileNameMap().getContentTypeFor(name);
                        }

                        public int getContentLength()
                        {
                            return b.length;
                        }

                    
                    {
                        this$1 = 1.this;
                        super(url);
                    }
                    }
;
                }

            
            {
                this$0 = ClassGuard.this;
                is = inputstream;
                name = s;
                b = abyte0;
                super();
            }
            }
);
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    public InputStream getResourceAsStream(String s)
    {
        InputStream inputstream = getParent().getResourceAsStream(s);
        if(inputstream != null)
            return inputstream;
        byte abyte0[] = getCryptedResource(s);
        if(abyte0 == null)
            return null;
        else
            return new ByteArrayInputStream(abyte0);
    }

    private byte[] getCryptedResource(String s)
    {
        s = (new StringBuilder()).append(s).append("x").toString();
        URL url = getParent().getResource(s);
        if(url != null)
            try
            {
                byte abyte0[] = loadFile(s);
                return getCryptedResource(abyte0, abyte0.length);
            }
            catch(IOException ioexception) { }
        return null;
    }

    private void initDefaultLicense()
        throws SignatureException, UnsupportedEncodingException, IOException
    {
        if(!licenseInit.booleanValue())
        {
            String s = null;
            String s1 = getManifestAttribute("ClassGuard-Product-Name");
            if(s1 != null)
                s = licenseAdapter.loadLicense(s1);
            if(s == null)
                try
                {
                    byte abyte0[] = loadFile("META-INF/default.license");
                    s = new String(abyte0, "UTF-8");
                }
                catch(IOException ioexception) { }
            if(s != null)
                synchronized(licenseInit)
                {
                    if(!licenseInit.booleanValue())
                        initLicense(s);
                }
        }
    }

    private void initNative()
        throws IOException
    {
        if(!nativeInit.booleanValue())
        {
            String s = System.getProperty("os.name").toLowerCase();
            String s1 = ".so";
            if(s.startsWith("windows"))
            {
                s1 = ".dll";
                s = "win";
            } else
            if(s.startsWith("mac os x"))
            {
                s1 = ".jnilib";
                s = "osx";
            }
            String s2 = System.getProperty("os.arch").toLowerCase();
            if(s2.charAt(0) == 'i' && s2.endsWith("86"))
                s2 = "x86";
            else
            if(s2.equals("amd64") || s2.equals("x86_64"))
                s2 = "x64";
            String s3 = (new StringBuilder()).append("lib/libcg_").append(s2).append("_").append(s).append(s1).append("x").toString();
            InputStream inputstream = getParent().getResourceAsStream(s3);
            if(inputstream == null)
                throw new IOException("Native library not found");
            File file = copyStreamToTemp(inputstream, s1);
            synchronized(nativeInit)
            {
                if(!nativeInit.booleanValue())
                {
                    System.load(file.getAbsolutePath());
                    nativeInit = Boolean.valueOf(true);
                    initSuccess = true;
                }
            }
        } else
        if(!initSuccess)
            throw new IOException("Native library not loaded");
    }

    static 
    {
        try
        {
            URL url = com/zenofx/classguard/bootstrap/ClassGuard.getProtectionDomain().getCodeSource().getLocation();
            JarInputStream jarinputstream = new JarInputStream(url.openStream());
            mf = jarinputstream.getManifest();
            jarinputstream.close();
        }
        catch(Exception exception)
        {
            throw new RuntimeException("Couldn't load ClassGuard manifest file", exception);
        }
    }
}
