// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) nolvt deadcode fieldsfirst splitstr(180) ansi 
// Source File Name:   LicenseDialog.java

package classguard.jad.com.zenofx.classguard.bootstrap;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.*;

// Referenced classes of package com.zenofx.classguard.bootstrap:
//            FileSelectPanel, GUIHelper, ClassGuard

public class LicenseDialog extends JDialog
    implements ActionListener
{

    private static final long serialVersionUID = 0xb84154c57050e03L;
    private JButton okButton;
    private JButton cancelButton;
    private FileSelectPanel filePanel;
    private ClassGuard classGuard;
    private String license;
    private String productName;
    private LookAndFeel oldLnF;

    public LicenseDialog(ClassGuard classguard, String s)
    {
        super((JFrame)null, "ClassGuard License Manager");
        if(System.getProperty("os.name").startsWith("Windows"))
        {
            setLocationByPlatform(true);
            try
            {
                oldLnF = UIManager.getLookAndFeel();
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            catch(Exception exception) { }
        }
        classGuard = classguard;
        productName = s;
        setModal(true);
        createContents();
    }

    private void createContents()
    {
        Container container = getContentPane();
        container.setFocusCycleRoot(true);
        GridBagConstraints gridbagconstraints = new GridBagConstraints();
        gridbagconstraints.insets = GUIHelper.INSETS;
        container.setLayout(new GridBagLayout());
        gridbagconstraints.anchor = 17;
        gridbagconstraints.gridy = 0;
        gridbagconstraints.gridx = 0;
        gridbagconstraints.gridwidth = 2;
        String s = (new StringBuilder()).append("No valid license found for ").append(productName).append(". ").append("Please contact your vendor.").toString();
        container.add(new JLabel(s), gridbagconstraints);
        gridbagconstraints.anchor = 13;
        gridbagconstraints.gridy = 1;
        gridbagconstraints.gridx = 0;
        gridbagconstraints.gridwidth = 1;
        container.add(new JLabel("System-ID"), gridbagconstraints);
        String s1;
        try
        {
            s1 = classGuard.getSystemId();
        }
        catch(IOException ioexception)
        {
            s1 = "unknown";
        }
        JTextField jtextfield = new JTextField(s1, 40);
        jtextfield.setEditable(false);
        gridbagconstraints.anchor = 17;
        gridbagconstraints.gridy = 1;
        gridbagconstraints.gridx = 1;
        container.add(jtextfield, gridbagconstraints);
        gridbagconstraints.anchor = 13;
        gridbagconstraints.gridy = 2;
        gridbagconstraints.gridx = 0;
        container.add(new JLabel("License file"), gridbagconstraints);
        filePanel = new FileSelectPanel();
        gridbagconstraints.anchor = 17;
        gridbagconstraints.gridy = 2;
        gridbagconstraints.gridx = 1;
        container.add(filePanel, gridbagconstraints);
        okButton = GUIHelper.createButton("OK");
        okButton.addActionListener(this);
        gridbagconstraints.anchor = 13;
        gridbagconstraints.gridy = 3;
        gridbagconstraints.gridx = 0;
        container.add(okButton, gridbagconstraints);
        cancelButton = GUIHelper.createButton("Cancel");
        cancelButton.addActionListener(this);
        gridbagconstraints.anchor = 17;
        gridbagconstraints.gridy = 3;
        gridbagconstraints.gridx = 1;
        container.add(cancelButton, gridbagconstraints);
        pack();
        setResizable(false);
    }

    public String getLicense()
    {
        return license;
    }

    public void actionPerformed(ActionEvent actionevent)
    {
        if(actionevent.getSource() == okButton)
        {
            java.io.File file = filePanel.getSelectedFile();
            if(file == null)
            {
                error("Please select a license file");
                return;
            }
            try
            {
                FileInputStream fileinputstream = new FileInputStream(file);
                byte abyte0[] = new byte[fileinputstream.available()];
                fileinputstream.read(abyte0);
                license = new String(abyte0, "UTF-8");
                fileinputstream.close();
            }
            catch(Exception exception)
            {
                error("Could not read license file.");
                return;
            }
            try
            {
                classGuard.initLicense(license);
            }
            catch(Exception exception1)
            {
                error("License file not valid.");
                license = null;
                return;
            }
            if(oldLnF != null)
                try
                {
                    UIManager.setLookAndFeel(oldLnF);
                }
                catch(Exception exception2) { }
            dispose();
        } else
        if(actionevent.getSource() == cancelButton)
        {
            license = null;
            dispose();
        }
    }

    private void error(String s)
    {
        JOptionPane.showMessageDialog(this, s, "Error", 0);
    }
}
