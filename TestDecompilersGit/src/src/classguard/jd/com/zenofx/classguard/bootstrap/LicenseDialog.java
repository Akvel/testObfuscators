/*     */ package classguard.jd.com.zenofx.classguard.bootstrap;
/*     */ 
/*     */ import java.awt.Container;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.GridBagLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.LookAndFeel;
/*     */ import javax.swing.UIManager;
/*     */ 
/*     */ public class LicenseDialog extends JDialog
/*     */   implements ActionListener
/*     */ {
/*     */   private static final long serialVersionUID = 829811648964660739L;
/*     */   private JButton okButton;
/*     */   private JButton cancelButton;
/*     */   private FileSelectPanel filePanel;
/*     */   private ClassGuard classGuard;
/*     */   private String license;
/*     */   private String productName;
/*     */   private LookAndFeel oldLnF;
/*     */ 
/*     */   public LicenseDialog(ClassGuard paramClassGuard, String paramString)
/*     */   {
/*  44 */     super((JFrame)null, "ClassGuard License Manager");
/*     */ 
/*  47 */     if (System.getProperty("os.name").startsWith("Windows")) {
/*  48 */       setLocationByPlatform(true);
/*     */       try {
/*  50 */         this.oldLnF = UIManager.getLookAndFeel();
/*  51 */         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
/*     */       }
/*     */       catch (Exception localException) {
/*     */       }
/*     */     }
/*  56 */     this.classGuard = paramClassGuard;
/*  57 */     this.productName = paramString;
/*     */ 
/*  59 */     setModal(true);
/*  60 */     createContents(); } 
/*  67 */   private void createContents() { Container localContainer = getContentPane();
/*  68 */     localContainer.setFocusCycleRoot(true);
/*     */ 
/*  70 */     GridBagConstraints localGridBagConstraints = new GridBagConstraints();
/*  71 */     localGridBagConstraints.insets = GUIHelper.INSETS;
/*     */ 
/*  73 */     localContainer.setLayout(new GridBagLayout());
/*     */ 
/*  75 */     localGridBagConstraints.anchor = 17;
/*  76 */     localGridBagConstraints.gridy = 0;
/*  77 */     localGridBagConstraints.gridx = 0;
/*  78 */     localGridBagConstraints.gridwidth = 2;
/*  79 */     String str1 = "No valid license found for " + this.productName + ". " + "Please contact your vendor.";
/*     */ 
/*  81 */     localContainer.add(new JLabel(str1), localGridBagConstraints);
/*     */ 
/*  83 */     localGridBagConstraints.anchor = 13;
/*  84 */     localGridBagConstraints.gridy = 1;
/*  85 */     localGridBagConstraints.gridx = 0;
/*  86 */     localGridBagConstraints.gridwidth = 1;
/*  87 */     localContainer.add(new JLabel("System-ID"), localGridBagConstraints);
/*     */     String str2;
/*     */     try { str2 = this.classGuard.getSystemId();
/*     */     } catch (IOException localIOException) {
/*  93 */       str2 = "unknown";
/*     */     }
/*  95 */     JTextField localJTextField = new JTextField(str2, 40);
/*  96 */     localJTextField.setEditable(false);
/*  97 */     localGridBagConstraints.anchor = 17;
/*  98 */     localGridBagConstraints.gridy = 1;
/*  99 */     localGridBagConstraints.gridx = 1;
/* 100 */     localContainer.add(localJTextField, localGridBagConstraints);
/*     */ 
/* 102 */     localGridBagConstraints.anchor = 13;
/* 103 */     localGridBagConstraints.gridy = 2;
/* 104 */     localGridBagConstraints.gridx = 0;
/* 105 */     localContainer.add(new JLabel("License file"), localGridBagConstraints);
/*     */ 
/* 107 */     this.filePanel = new FileSelectPanel();
/* 108 */     localGridBagConstraints.anchor = 17;
/* 109 */     localGridBagConstraints.gridy = 2;
/* 110 */     localGridBagConstraints.gridx = 1;
/* 111 */     localContainer.add(this.filePanel, localGridBagConstraints);
/*     */ 
/* 113 */     this.okButton = GUIHelper.createButton("OK");
/* 114 */     this.okButton.addActionListener(this);
/* 115 */     localGridBagConstraints.anchor = 13;
/* 116 */     localGridBagConstraints.gridy = 3;
/* 117 */     localGridBagConstraints.gridx = 0;
/* 118 */     localContainer.add(this.okButton, localGridBagConstraints);
/*     */ 
/* 120 */     this.cancelButton = GUIHelper.createButton("Cancel");
/* 121 */     this.cancelButton.addActionListener(this);
/* 122 */     localGridBagConstraints.anchor = 17;
/* 123 */     localGridBagConstraints.gridy = 3;
/* 124 */     localGridBagConstraints.gridx = 1;
/* 125 */     localContainer.add(this.cancelButton, localGridBagConstraints);
/*     */ 
/* 128 */     pack();
/* 129 */     setResizable(false);
/*     */   }
/*     */ 
/*     */   public String getLicense()
/*     */   {
/* 136 */     return this.license;
/*     */   }
/*     */ 
/*     */   public void actionPerformed(ActionEvent paramActionEvent)
/*     */   {
/* 143 */     if (paramActionEvent.getSource() == this.okButton) {
/* 144 */       File localFile = this.filePanel.getSelectedFile();
/* 145 */       if (localFile == null) {
/* 146 */         error("Please select a license file");
/* 147 */         return;
/*     */       }
/*     */       try
/*     */       {
/* 151 */         FileInputStream localFileInputStream = new FileInputStream(localFile);
/* 152 */         byte[] arrayOfByte = new byte[localFileInputStream.available()];
/* 153 */         localFileInputStream.read(arrayOfByte);
/* 154 */         this.license = new String(arrayOfByte, "UTF-8");
/* 155 */         localFileInputStream.close();
/*     */       }
/*     */       catch (Exception localException1) {
/* 158 */         error("Could not read license file.");
/* 159 */         return;
/*     */       }
/*     */ 
/*     */       try
/*     */       {
/* 164 */         this.classGuard.initLicense(this.license);
/*     */       } catch (Exception localException2) {
/* 166 */         error("License file not valid.");
/* 167 */         this.license = null;
/* 168 */         return;
/*     */       }
/*     */ 
/* 171 */       if (this.oldLnF != null)
/*     */         try {
/* 173 */           UIManager.setLookAndFeel(this.oldLnF);
/*     */         }
/*     */         catch (Exception localException3)
/*     */         {
/*     */         }
/* 178 */       dispose();
/*     */     }
/* 180 */     else if (paramActionEvent.getSource() == this.cancelButton) {
/* 181 */       this.license = null;
/* 182 */       dispose();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void error(String paramString)
/*     */   {
/* 190 */     JOptionPane.showMessageDialog(this, paramString, "Error", 0);
/*     */   }
/*     */ }

/* Location:           C:\work5\TestDecompilers\distrib\test_ClassGuard.jar
 * Qualified Name:     com.zenofx.classguard.bootstrap.LicenseDialog
 * JD-Core Version:    0.6.0
 */