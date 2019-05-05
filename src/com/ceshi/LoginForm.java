package com.ceshi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JPanel jp1, jp2, jp3;
    private JPanel jb1, jb2;
    private JLabel j11, j12;
    private JTextField jtf;
    private JPasswordField jpf;
    private JButton okButton = new JButton("确认");
    private JButton cancelButton = new JButton("取消");
    private JButton changePassword = new JButton("修改密码");

    public static void main(String[] args) {
        new LoginForm();
    }

    public LoginForm() {
        this.setTitle("用户登录");
        this.setSize(320, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setLayout(new GridLayout(3, 1));
        jp1 = new JPanel();
        j11 = new JLabel("用户名:");
        jtf = new JTextField(20);
        jp1.add(j11);
        jp1.add(jtf);
        this.add(jp1);

        jp2 = new JPanel();
        j12 = new JLabel("密码:");
        jpf = new JPasswordField(20);
        jp2.add(j12);
        jp2.add(jpf);
        this.add(jp2);

        jp3 = new JPanel();
        jp3.add(okButton);
        jp3.add(cancelButton);
        jp3.add(changePassword);
        this.add(jp3);


        //时间监听

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //修改密码的时间监听
        changePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password;
                PasswordChange cp = new PasswordChange();

                //cp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

            }
        });

        //主界面
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = jtf.getText();// 取得用户名
                String key = new String(jpf.getPassword());// 取得密码
                User user = new User();
                String correct_key = user.getPasssword();
                if (id.equals("admin") && key.equals(correct_key)) {// 判断是否登录成功
                    // 如果登录成功
                    setVisible(false);// 本窗口隐藏,
                    new MainFrame().setVisible(true);// 新窗口显示
                    dispose();//本窗口销毁,释放内存资源
                } else {
                    //如果登录失败  弹出提示
                    JOptionPane.showMessageDialog(null, "用户名或者密码错误.", "通知", JOptionPane.ERROR_MESSAGE);
                    clearText();//清空文本框 密码框的输入
                }
            }
        });

            this.setVisible(true);

    }

    public void clearText() {//清空文本框, 密码框的输入

        jpf.setText("");
    }
}
