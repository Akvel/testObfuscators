/*    */ package classguard.jd.com.zenofx.classguard.bootstrap;
/*    */ 
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.io.File;
/*    */ import javax.swing.BoxLayout;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JFileChooser;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JTextField;
/*    */ 
/*    */ public class FileSelectPanel extends JPanel
/*    */   implements ActionListener
/*    */ {
/*    */   private static final long serialVersionUID = 3735538227401101354L;
/*    */   private JTextField fileField;
/* 23 */   private JFileChooser fc = new JFileChooser();
/*    */   private File selectedFile;
/*    */ 
/*    */   public FileSelectPanel()
/*    */   {
/* 31 */     setLayout(new BoxLayout(this, 0));
/* 32 */     JButton localJButton = GUIHelper.createButton("File");
/* 33 */     localJButton.addActionListener(this);
/* 34 */     this.fileField = new JTextField(30);
/* 35 */     this.fileField.setEditable(false);
/* 36 */     add(this.fileField);
/* 37 */     add(localJButton);
/*    */   }
/*    */ 
/*    */   public void actionPerformed(ActionEvent paramActionEvent)
/*    */   {
/* 44 */     int i = this.fc.showOpenDialog(this);
/* 45 */     if (i == 0) {
/* 46 */       this.selectedFile = this.fc.getSelectedFile();
/* 47 */       this.fileField.setText(this.selectedFile.getName());
/*    */     }
/*    */   }
/*    */ 
/*    */   public File getSelectedFile()
/*    */   {
/* 55 */     return this.selectedFile;
/*    */   }
/*    */ }

/* Location:           C:\work5\TestDecompilers\distrib\test_ClassGuard.jar
 * Qualified Name:     com.zenofx.classguard.bootstrap.FileSelectPanel
 * JD-Core Version:    0.6.0
 */