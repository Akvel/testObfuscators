/*     */ package classguard.jd.com.zenofx.classguard.bootstrap;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.net.FileNameMap;
/*     */ import java.net.URL;
/*     */ import java.net.URLConnection;
/*     */ import java.net.URLStreamHandler;
/*     */ import java.security.CodeSource;
/*     */ import java.security.ProtectionDomain;
/*     */ import java.security.SignatureException;
/*     */ import java.util.jar.Attributes;
/*     */ import java.util.jar.JarInputStream;
/*     */ import java.util.jar.Manifest;
/*     */ 
/*     */ public class ClassGuard extends ClassLoader
/*     */ {
/*  21 */   private static Boolean nativeInit = Boolean.valueOf(false);
/*  22 */   private static Boolean licenseInit = Boolean.valueOf(false);
/*  23 */   private static boolean initSuccess = false;
/*     */   private static final Manifest mf;
/*     */   private LicenseInterface licenseAdapter;
/*     */ 
/*     */   public ClassGuard(ClassLoader paramClassLoader)
/*     */   {
/*  46 */     super(paramClassLoader);
/*     */ 
/*  48 */     String str = getManifestAttribute("ClassGuard-License-Interface");
/*  49 */     if ((str == null) || (str.length() == 0)) {
/*  50 */       str = "com.zenofx.classguard.bootstrap.LicenseAdapter";
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  55 */       Class localClass = Class.forName(str, true, paramClassLoader);
/*  56 */       this.licenseAdapter = ((LicenseInterface)localClass.newInstance());
/*     */     } catch (Exception localException) {
/*  58 */       throw new RuntimeException("ClassGuard license adapter not found");
/*     */     }
/*     */   }
/*     */ 
/*     */   static String getManifestAttribute(String paramString)
/*     */   {
/*  69 */     if (mf == null) {
/*  70 */       return null;
/*     */     }
/*     */ 
/*  73 */     return mf.getMainAttributes().getValue(paramString);
/*     */   }
/*     */ 
/*     */   LicenseInterface getLicenseAdapter()
/*     */   {
/*  82 */     return this.licenseAdapter;
/*     */   }
/*     */ 
/*     */   public void initLicense(String paramString)
/*     */     throws SignatureException, IOException
/*     */   {
/*  91 */     initNative();
/*     */ 
/*  94 */     int i = paramString.indexOf('\n');
/*  95 */     if ((i > 0) && (paramString.charAt(i - 1) != '\r')) {
/*  96 */       paramString = paramString.replace("\n", "\r\n");
/*     */     }
/*     */ 
/* 100 */     i = paramString.lastIndexOf("Signature=");
/* 101 */     if (i < 0) {
/* 102 */       throw new SignatureException("No signature in license file");
/*     */     }
/* 104 */     byte[] arrayOfByte = null;
/*     */     try {
/* 106 */       String str1 = paramString.substring(i + "Signature".length() + 1, paramString.length() - 2);
/* 107 */       arrayOfByte = Base32.decode(str1);
/*     */     }
/*     */     catch (Exception localException) {
/* 110 */       throw new SignatureException("Invalid signature in license file");
/*     */     }
/* 112 */     String str2 = paramString.substring(0, i);
/*     */ 
/* 115 */     synchronized (licenseInit) {
/* 116 */       if (!initLicense(str2, arrayOfByte)) {
/* 117 */         throw new SignatureException("Error in license file");
/*     */       }
/* 119 */       licenseInit = Boolean.valueOf(true);
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getSystemId()
/*     */     throws IOException
/*     */   {
/* 128 */     initNative();
/* 129 */     return Base32.encode((getUsername() + "@" + getHostname()).getBytes("UTF-8"));
/*     */   }
/*     */ 
/*     */   private static File copyStreamToTemp(InputStream paramInputStream, String paramString)
/*     */     throws IOException
/*     */   {
/* 139 */     String str = System.getProperty("classguard.tmpdir");
/* 140 */     File localFile1 = null;
/* 141 */     if ((str != null) && (str.length() > 0)) {
/* 142 */       localFile1 = new File(str);
/*     */     }
/*     */ 
/* 145 */     File localFile2 = File.createTempFile("cg-", paramString, localFile1);
/* 146 */     localFile2.deleteOnExit();
/* 147 */     FileOutputStream localFileOutputStream = new FileOutputStream(localFile2);
/*     */ 
/* 149 */     byte[] arrayOfByte = new byte[512];
/* 150 */     int i = 0;
/* 151 */     while ((i = paramInputStream.read(arrayOfByte, 0, arrayOfByte.length)) != -1) {
/* 152 */       localFileOutputStream.write(arrayOfByte, 0, i);
/*     */     }
/* 154 */     paramInputStream.close();
/* 155 */     localFileOutputStream.close();
/* 156 */     return localFile2;
/*     */   }
/*     */ 
/*     */   private byte[] loadFile(String paramString)
/*     */     throws IOException
/*     */   {
/* 167 */     InputStream localInputStream = null;
/*     */     try {
/* 169 */       localInputStream = getParent().getResourceAsStream(paramString);
/* 170 */       if (localInputStream == null) {
/* 171 */         throw new IOException("Couldn't load " + paramString);
/*     */       }
/* 173 */       byte[] arrayOfByte = readStream(localInputStream);
/*     */       return arrayOfByte;
/*     */     }
/*     */     finally
/*     */     {
/* 176 */       if (localInputStream != null)
/* 177 */         localInputStream.close(); 
/* 177 */     }throw localObject;
/*     */   }
/*     */ 
/*     */   public static byte[] readStream(InputStream paramInputStream)
/*     */     throws IOException
/*     */   {
/* 191 */     byte[] arrayOfByte = new byte[paramInputStream.available()];
/* 192 */     int i = 0;
/* 193 */     while (i != arrayOfByte.length) {
/* 194 */       int j = paramInputStream.read(arrayOfByte, i, arrayOfByte.length - i);
/* 195 */       if (j < 0) {
/* 196 */         throw new IOException("Unexpected end of stream");
/*     */       }
/*     */ 
/* 199 */       i += j;
/*     */     }
/*     */ 
/* 202 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */   private native Class decryptClass(String paramString, byte[] paramArrayOfByte, int paramInt)
/*     */     throws ClassNotFoundException;
/*     */ 
/*     */   private final native byte[] getCryptedResource(byte[] paramArrayOfByte, int paramInt);
/*     */ 
/*     */   private native boolean initLicense(String paramString, byte[] paramArrayOfByte);
/*     */ 
/*     */   public final native String getAttribute(String paramString);
/*     */ 
/*     */   public final native String getHostname();
/*     */ 
/*     */   public final native String getUsername();
/*     */ 
/*     */   public Class findClass(String paramString)
/*     */     throws ClassNotFoundException
/*     */   {
/* 231 */     String str = paramString.replace('.', '/') + ".class" + "x";
/*     */ 
/* 234 */     URL localURL = getParent().getResource(str);
/* 235 */     if (localURL == null) {
/* 236 */       throw new ClassNotFoundException();
/*     */     }
/* 238 */     byte[] arrayOfByte = null;
/*     */     try {
/* 240 */       arrayOfByte = loadFile(str);
/*     */     } catch (IOException localIOException) {
/* 242 */       throw new ClassNotFoundException("Couldn't load encrypted class", localIOException);
/*     */     }
/* 244 */     return findClassInternal(paramString, arrayOfByte);
/*     */   }
/*     */ 
/*     */   public Class findClassInternal(String paramString, byte[] paramArrayOfByte)
/*     */     throws ClassNotFoundException
/*     */   {
/*     */     try
/*     */     {
/* 253 */       initNative();
/*     */     }
/*     */     catch (Exception localException1) {
/* 256 */       throw new RuntimeException("Couldn't load native ClassGuard library", localException1);
/*     */     }
/*     */     try {
/* 259 */       initDefaultLicense();
/*     */     } catch (Exception localException2) {
/* 261 */       throw new ClassNotFoundException("Couldn't load default license", localException2);
/*     */     }
/* 263 */     Class localClass = decryptClass(paramString.replace('.', '/'), paramArrayOfByte, paramArrayOfByte.length);
/* 264 */     if (localClass == null) {
/* 265 */       throw new ClassNotFoundException("Couldn't decrypt class");
/*     */     }
/* 267 */     return localClass;
/*     */   }
/*     */ 
/*     */   public URL getResource(String paramString)
/*     */   {
/* 275 */     URL localURL = getParent().getResource(paramString);
/* 276 */     if (localURL != null)
/*     */     {
/* 278 */       return localURL;
/*     */     }
/*     */ 
/* 282 */     byte[] arrayOfByte = getCryptedResource(paramString);
/* 283 */     if (arrayOfByte == null) {
/* 284 */       return null;
/*     */     }
/*     */ 
/* 287 */     ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(arrayOfByte);
/*     */     try
/*     */     {
/* 290 */       return new URL(null, "classguard:" + paramString, new URLStreamHandler(localByteArrayInputStream, paramString, arrayOfByte)
/*     */       {
/*     */         protected URLConnection openConnection(URL paramURL) {
/* 293 */           return new URLConnection(paramURL)
/*     */           {
/*     */             public void connect() {
/*     */             }
/*     */ 
/*     */             public InputStream getInputStream() {
/* 299 */               return ClassGuard.1.this.val$is;
/*     */             }
/*     */ 
/*     */             public String getContentType() {
/* 303 */               return getFileNameMap().getContentTypeFor(ClassGuard.1.this.val$name);
/*     */             }
/*     */ 
/*     */             public int getContentLength() {
/* 307 */               return ClassGuard.1.this.val$b.length;
/*     */             } } ;
/*     */         } } );
/*     */     } catch (Exception localException) {
/*     */     }
/* 313 */     return null;
/*     */   }
/*     */ 
/*     */   public InputStream getResourceAsStream(String paramString)
/*     */   {
/* 324 */     InputStream localInputStream = getParent().getResourceAsStream(paramString);
/* 325 */     if (localInputStream != null)
/*     */     {
/* 327 */       return localInputStream;
/*     */     }
/*     */ 
/* 331 */     byte[] arrayOfByte = getCryptedResource(paramString);
/* 332 */     if (arrayOfByte == null) {
/* 333 */       return null;
/*     */     }
/*     */ 
/* 336 */     return new ByteArrayInputStream(arrayOfByte);
/*     */   }
/*     */ 
/*     */   private byte[] getCryptedResource(String paramString)
/*     */   {
/* 349 */     paramString = paramString + "x";
/* 350 */     URL localURL = getParent().getResource(paramString);
/* 351 */     if (localURL != null) {
/*     */       try
/*     */       {
/* 354 */         byte[] arrayOfByte = loadFile(paramString);
/* 355 */         return getCryptedResource(arrayOfByte, arrayOfByte.length);
/*     */       }
/*     */       catch (IOException localIOException)
/*     */       {
/*     */       }
/*     */     }
/* 361 */     return null;
/*     */   }
/*     */ 
/*     */   private void initDefaultLicense()
/*     */     throws SignatureException, UnsupportedEncodingException, IOException
/*     */   {
/* 371 */     if (!licenseInit.booleanValue()) {
/* 372 */       String str1 = null;
/*     */ 
/* 375 */       String str2 = getManifestAttribute("ClassGuard-Product-Name");
/* 376 */       if (str2 != null) {
/* 377 */         str1 = this.licenseAdapter.loadLicense(str2);
/*     */       }
/*     */ 
/* 381 */       if (str1 == null) {
/*     */         try {
/* 383 */           byte[] arrayOfByte = loadFile("META-INF/default.license");
/* 384 */           str1 = new String(arrayOfByte, "UTF-8");
/*     */         }
/*     */         catch (IOException localIOException)
/*     */         {
/*     */         }
/*     */       }
/*     */ 
/* 391 */       if (str1 != null)
/* 392 */         synchronized (licenseInit) {
/* 393 */           if (!licenseInit.booleanValue())
/* 394 */             initLicense(str1);
/*     */         }
/*     */     }
/*     */   }
/*     */ 
/*     */   private void initNative()
/*     */     throws IOException
/*     */   {
/* 406 */     if (!nativeInit.booleanValue()) {
/* 407 */       String str1 = System.getProperty("os.name").toLowerCase();
/* 408 */       String str2 = ".so";
/* 409 */       if (str1.startsWith("windows")) {
/* 410 */         str2 = ".dll";
/* 411 */         str1 = "win";
/*     */       }
/* 413 */       else if (str1.startsWith("mac os x")) {
/* 414 */         str2 = ".jnilib";
/* 415 */         str1 = "osx";
/*     */       }
/* 417 */       String str3 = System.getProperty("os.arch").toLowerCase();
/* 418 */       if ((str3.charAt(0) == 'i') && (str3.endsWith("86"))) {
/* 419 */         str3 = "x86";
/*     */       }
/* 421 */       else if ((str3.equals("amd64")) || (str3.equals("x86_64"))) {
/* 422 */         str3 = "x64";
/*     */       }
/*     */ 
/* 425 */       String str4 = "lib/libcg_" + str3 + "_" + str1 + str2 + "x";
/*     */ 
/* 427 */       InputStream localInputStream = getParent().getResourceAsStream(str4);
/* 428 */       if (localInputStream == null) {
/* 429 */         throw new IOException("Native library not found");
/*     */       }
/* 431 */       File localFile = copyStreamToTemp(localInputStream, str2);
/*     */ 
/* 433 */       synchronized (nativeInit) {
/* 434 */         if (!nativeInit.booleanValue()) {
/* 435 */           System.load(localFile.getAbsolutePath());
/* 436 */           nativeInit = Boolean.valueOf(true);
/* 437 */           initSuccess = true;
/*     */         }
/*     */       }
/*     */     }
/* 441 */     else if (!initSuccess) {
/* 442 */       throw new IOException("Native library not loaded");
/*     */     }
/*     */   }
/*     */ 
/*     */   static
/*     */   {
/*     */     try
/*     */     {
/*  31 */       URL localURL = ClassGuard.class.getProtectionDomain().getCodeSource().getLocation();
/*  32 */       JarInputStream localJarInputStream = new JarInputStream(localURL.openStream());
/*  33 */       mf = localJarInputStream.getManifest();
/*  34 */       localJarInputStream.close();
/*     */     } catch (Exception localException) {
/*  36 */       throw new RuntimeException("Couldn't load ClassGuard manifest file", localException);
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\work5\TestDecompilers\distrib\test_ClassGuard.jar
 * Qualified Name:     com.zenofx.classguard.bootstrap.ClassGuard
 * JD-Core Version:    0.6.0
 */