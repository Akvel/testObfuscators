/*    */ package classguard.jd.com.zenofx.classguard.bootstrap;
/*    */ 
/*    */ import java.awt.GraphicsEnvironment;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ import java.util.prefs.Preferences;
/*    */ import javax.swing.JOptionPane;
/*    */ 
/*    */ public class LicenseAdapter
/*    */   implements LicenseInterface
/*    */ {
/*    */   public String loadLicense(String paramString)
/*    */   {
/* 21 */     if (paramString == null) {
/* 22 */       return null;
/*    */     }
/*    */ 
/*    */     try
/*    */     {
/* 27 */       Preferences localPreferences = Preferences.userNodeForPackage(net.jsecurity.classguard.bootstrap.ClassGuard.class);
/* 28 */       return localPreferences.get(paramString, null);
/*    */     }
/*    */     catch (Exception localException) {
/*    */     }
/* 32 */     return null;
/*    */   }
/*    */ 
/*    */   public String requestLicense(ClassGuard paramClassGuard, String paramString)
/*    */     throws IOException
/*    */   {
/* 41 */     if (GraphicsEnvironment.isHeadless()) {
/* 42 */       throw new IOException("License GUI not available");
/*    */     }
/*    */ 
/* 45 */     LicenseDialog localLicenseDialog = new LicenseDialog(paramClassGuard, paramString);
/*    */ 
/* 48 */     localLicenseDialog.setVisible(true);
/*    */ 
/* 50 */     return localLicenseDialog.getLicense();
/*    */   }
/*    */ 
/*    */   public void storeLicense(String paramString1, String paramString2)
/*    */     throws IOException
/*    */   {
/*    */     try
/*    */     {
/* 59 */       Preferences localPreferences = Preferences.userNodeForPackage(net.jsecurity.classguard.bootstrap.ClassGuard.class);
/* 60 */       localPreferences.put(paramString1, paramString2);
/* 61 */       localPreferences.flush();
/*    */     } catch (Exception localException) {
/* 63 */       throw new IOException("Couldn't save license to registry");
/*    */     }
/*    */   }
/*    */ 
/*    */   public void error(String paramString)
/*    */   {
/* 72 */     if (GraphicsEnvironment.isHeadless()) {
/* 73 */       System.err.println("Error: " + paramString);
/*    */     }
/*    */     else
/* 76 */       JOptionPane.showMessageDialog(null, paramString, "Error", 0);
/*    */   }
/*    */ }

/* Location:           C:\work5\TestDecompilers\distrib\test_ClassGuard.jar
 * Qualified Name:     com.zenofx.classguard.bootstrap.LicenseAdapter
 * JD-Core Version:    0.6.0
 */