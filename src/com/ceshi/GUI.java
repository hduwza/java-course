package com.ceshi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    public GUI() {
        setLayout(new BorderLayout());
        JButton button = new JButton("按钮");

        //事件监听
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(((JButton)e.getSource()).getText());
            }
        });
        add(button);
    }
    public static void main(String[] args) {
        GUI frame = new GUI();
        frame.setTitle("学生信息管理系统");
        //Container container = frame.getContentPane();
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(300,200);
        //frame.setVisible(true);
        //JOptionPane.showMessageDialog(null,"meesgae");
    }


}
