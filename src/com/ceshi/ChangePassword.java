package com.ceshi;

import javax.swing.*;

public class ChangePassword extends JFrame {
    String password;

    public ChangePassword() {
        password = JOptionPane.showInputDialog("请输入新密码");
    }

    public String getPassword() {
        return password;
    }

    public static void main(String[] args) {
        ChangePassword frame = new ChangePassword();

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        //frame.setSize(1000,300);
        frame.pack();
        frame.setVisible(true);
    }
}
