/*    */ package classguard.jd.com.zenofx.classguard.bootstrap;
/*    */ 
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Insets;
/*    */ import javax.swing.JButton;
/*    */ 
/*    */ public class GUIHelper
/*    */ {
/*    */   public static final int GAP = 3;
/* 19 */   private static final Dimension BUTTON_SIZE = new Dimension(90, 25);
/*    */ 
/* 44 */   public static final Insets INSETS = new Insets(3, 3, 3, 3);
/*    */ 
/*    */   public static JButton createButton(String paramString)
/*    */   {
/* 27 */     JButton localJButton = new JButton(paramString);
/* 28 */     localJButton.setPreferredSize(BUTTON_SIZE);
/* 29 */     localJButton.setMinimumSize(BUTTON_SIZE);
/* 30 */     localJButton.setMaximumSize(BUTTON_SIZE);
/* 31 */     return localJButton;
/*    */   }
/*    */ 
/*    */   public static JButton createBigButton(String paramString)
/*    */   {
/* 40 */     JButton localJButton = new JButton(paramString);
/* 41 */     return localJButton;
/*    */   }
/*    */ }

/* Location:           C:\work5\TestDecompilers\distrib\test_ClassGuard.jar
 * Qualified Name:     com.zenofx.classguard.bootstrap.GUIHelper
 * JD-Core Version:    0.6.0
 */