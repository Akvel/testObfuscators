package classguard.jd.com.zenofx.classguard.bootstrap;

import java.io.IOException;

public abstract interface LicenseInterface
{
  public abstract void error(String paramString);

  public abstract String loadLicense(String paramString);

  public abstract String requestLicense(ClassGuard paramClassGuard, String paramString)
    throws IOException;

  public abstract void storeLicense(String paramString1, String paramString2)
    throws IOException;
}

/* Location:           C:\work5\TestDecompilers\distrib\test_ClassGuard.jar
 * Qualified Name:     com.zenofx.classguard.bootstrap.LicenseInterface
 * JD-Core Version:    0.6.0
 */