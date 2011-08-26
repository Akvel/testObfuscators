// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) nolvt deadcode fieldsfirst splitstr(180) ansi 
// Source File Name:   FileSelectPanel.java

package classguard.jad.com.zenofx.classguard.bootstrap;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

// Referenced classes of package com.zenofx.classguard.bootstrap:
//            GUIHelper

public class FileSelectPanel extends JPanel
    implements ActionListener
{

    private static final long serialVersionUID = 0x33d74c39e122902aL;
    private JTextField fileField;
    private JFileChooser fc;
    private File selectedFile;

    public FileSelectPanel()
    {
        fc = new JFileChooser();
        setLayout(new BoxLayout(this, 0));
        JButton jbutton = GUIHelper.createButton("File");
        jbutton.addActionListener(this);
        fileField = new JTextField(30);
        fileField.setEditable(false);
        add(fileField);
        add(jbutton);
    }

    public void actionPerformed(ActionEvent actionevent)
    {
        int i = fc.showOpenDialog(this);
        if(i == 0)
        {
            selectedFile = fc.getSelectedFile();
            fileField.setText(selectedFile.getName());
        }
    }

    public File getSelectedFile()
    {
        return selectedFile;
    }
}
