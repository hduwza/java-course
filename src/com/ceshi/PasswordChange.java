package com.ceshi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordChange extends JFrame {
    private JPanel jp1, jp2;
    private JLabel jl;
    private JTextField jtf;
    private JButton okButton = new JButton("确认");
    private JButton cancelButton = new JButton("取消");

    String password;

    public static void main(String[] args) {
        PasswordChange frame = new PasswordChange();
        frame.setVisible(true);
    }

    public PasswordChange() {
        this.setTitle("修改密码");
        this.setSize(300, 200);
        this.setLocationRelativeTo(null);
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //password = JOptionPane.showInputDialog("请输入新密码");

        this.setLayout(new GridLayout(2, 1));
        jp1 = new JPanel();
        jl = new JLabel("新密码:");
        jtf = new JTextField(20);
        jp1.add(jl);
        jp1.add(jtf);
        this.add(jp1);

        jp2 = new JPanel();
        jp2.add(okButton);
        jp2.add(cancelButton);
        this.add(jp2);


        //事件监听
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                password = jtf.getText();
                User user = new User();
                user.changePassword(password);
                dispose();
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

    public String getPassword() {
        return password;
    }




}
