package com.ceshi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteStudent extends JFrame {

    private JPanel jp1,jp2;
    private JLabel j1;
    private JTextField jtf;
    private JButton okButton = new JButton("确认");
    private JButton cancelButton = new JButton("取消");

    public DeleteStudent() {
        this.setTitle("删除学生个人信息");
        this.setSize(320, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setLayout(new GridLayout(3, 1));
        jp1 = new JPanel();
        j1 = new JLabel("输入删除的学生学号:");
        jtf = new JTextField(20);
        jp1.add(j1);
        jp1.add(jtf);
        this.add(jp1);

        jp2 = new JPanel();
        jp2.add(okButton);
        jp2.add(cancelButton);
        this.add(jp2);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = jtf.getText();
                niubi.deleteStudent(id);
                clearText();

            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        this.setVisible(true);
    }

    public void clearText() {
        jtf.setText("");
    }
}
