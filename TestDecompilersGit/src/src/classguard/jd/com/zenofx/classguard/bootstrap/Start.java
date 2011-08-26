/*    */ package classguard.jd.com.zenofx.classguard.bootstrap;
/*    */ 
/*    */ import java.lang.reflect.Method;
/*    */ 
/*    */ public class Start
/*    */ {
/*    */   public static void main(String[] paramArrayOfString)
/*    */     throws Exception
/*    */   {
/* 17 */     ClassGuard localClassGuard = new ClassGuard(Start.class.getClassLoader());
/*    */ 
/* 20 */     String str1 = ClassGuard.getManifestAttribute("ClassGuard-Main-Class");
/* 21 */     str1 = System.getProperty("classguard.main.class", str1);
/*    */ 
/* 23 */     Class localClass = null;
/* 24 */     LicenseInterface localLicenseInterface = localClassGuard.getLicenseAdapter();
/*    */     try
/*    */     {
/* 27 */       str1 = str1.replace('/', '.');
/*    */       try
/*    */       {
/* 30 */         localClass = Class.forName(str1, true, localClassGuard);
/*    */       }
/*    */       catch (ClassNotFoundException localClassNotFoundException) {
/* 33 */         String str2 = ClassGuard.getManifestAttribute("ClassGuard-Product-Name");
/* 34 */         if (str2 == null)
/*    */         {
/* 36 */           localLicenseInterface.error("Start class " + str1 + " not found.");
/* 37 */           System.exit(1);
/*    */         }
/*    */         else
/*    */         {
/* 41 */           String str3 = localLicenseInterface.requestLicense(localClassGuard, str2);
/* 42 */           if (str3 == null)
/*    */           {
/* 44 */             System.exit(1);
/*    */           }
/* 46 */           localLicenseInterface.storeLicense(str2, str3);
/*    */         }
/* 48 */         localClass = Class.forName(str1, true, localClassGuard);
/*    */       }
/*    */     }
/*    */     catch (Throwable localThrowable)
/*    */     {
/* 53 */       localLicenseInterface.error(localThrowable.getMessage());
/* 54 */       System.exit(1);
/*    */     }
/*    */ 
/* 57 */     Method localMethod = localClass.getDeclaredMethod("main", new Class[] { paramArrayOfString.getClass() });
/* 58 */     localMethod.invoke(null, new Object[] { paramArrayOfString });
/*    */   }
/*    */ }

/* Location:           C:\work5\TestDecompilers\distrib\test_ClassGuard.jar
 * Qualified Name:     com.zenofx.classguard.bootstrap.Start
 * JD-Core Version:    0.6.0
 */