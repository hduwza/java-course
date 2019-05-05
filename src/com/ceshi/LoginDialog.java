package com.ceshi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginDialog extends JDialog {
    private JTextField nameField = new JTextField(15);
    private JPasswordField passwordField = new JPasswordField(15);
    private JButton okButton = new JButton("确定");
    private JButton cancelButton = new JButton("取消");
    private JButton passwordButton = new JButton("修改密码");

    public static void main(String[] args) {
        LoginDialog frame = new LoginDialog();

        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//EXIT_ON_CLOSE

        frame.setLocationRelativeTo(null);
        //frame.setSize(1000,300);
        frame.pack();
        frame.setVisible(true);
    }


    public LoginDialog() {

        JPanel labelPanels = new JPanel();
        labelPanels.setLayout(new GridLayout(2,1));
        labelPanels.add(new JLabel("用户名 "));
        labelPanels.add(new JLabel("密码"));


        JPanel textFieldPanels = new JPanel();
        textFieldPanels.setLayout(new GridLayout(2,1));
        textFieldPanels.add(nameField);
        textFieldPanels.add(passwordField);

        JPanel buttonPanels = new JPanel();
        buttonPanels.add(okButton);
        buttonPanels.add(cancelButton);
        buttonPanels.add(passwordButton);

        JPanel dialogPanels = new JPanel();
        dialogPanels.setLayout(new BorderLayout());
        dialogPanels.add(labelPanels,BorderLayout.WEST);
        dialogPanels.add(textFieldPanels,BorderLayout.CENTER);
        dialogPanels.add(buttonPanels,BorderLayout.SOUTH);

        this.add(dialogPanels);
        pack();



        //修改密码的时间监听
        passwordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password;
                ChangePassword cp = new ChangePassword();
                do {

                    cp.setVisible(true);
                    password = cp.getPassword();
                } while (password == null);
                //cp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                User user = new User();
                user.changePassword(password);
            }
        });

        //切换到登陆界面
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String password = String.valueOf(passwordField.getPassword());
            }
        });
    }


}
