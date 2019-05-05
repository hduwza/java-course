package com.ceshi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//班级号 学号 姓名 年龄 体重 身高

public class addStudent extends JFrame {
    private JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp7;
    private JPanel grade1, grade2;
    private JLabel jl1, jl2, jl3, jl4, jl5, jl6;
    private JLabel g1,g2,g3,g4,g5,g6,g7,g8,g9,g10;
    private JTextField jtf1, jtf2, jtf3, jtf4, jtf5, jtf6;
    private JTextField f1,f2,f3,f4,f5,f6,f7,f8,f9,f10;
    private JButton okButton = new JButton("确认");
    private JButton cancelButton = new JButton("取消");

    public addStudent() {

        this.setLayout(new GridLayout(9, 1));
        jp1 = new JPanel();
        jl1 = new JLabel("班级号:");
        jtf1 = new JTextField(20);
        jp1.add(jl1);
        jp1.add(jtf1);
        this.add(jp1);

        jp2 = new JPanel();
        jl2 = new JLabel("学号:");
        jtf2 = new JTextField(20);
        jp2.add(jl2);
        jp2.add(jtf2);
        this.add(jp2);

        jp3 = new JPanel();
        jl3 = new JLabel("姓名:");
        jtf3 = new JTextField(20);
        jp3.add(jl3);
        jp3.add(jtf3);
        this.add(jp3);

        jp4 = new JPanel();
        jl4 = new JLabel("年龄:");
        jtf4 = new JTextField(20);
        jp4.add(jl4);
        jp4.add(jtf4);
        this.add(jp4);

        jp5 = new JPanel();
        jl5 = new JLabel("体重:");
        jtf5 = new JTextField(20);
        jp5.add(jl5);
        jp5.add(jtf5);
        this.add(jp5);

        jp6 = new JPanel();
        jl6 = new JLabel("身高:");
        jtf6 = new JTextField(20);
        jp6.add(jl6);
        jp6.add(jtf6);
        this.add(jp6);

        grade1 = new JPanel();
        g1 = new JLabel("高等数学:");
        f1 = new JTextField(3);
        g2 = new JLabel("数据结构:");
        f2 = new JTextField(3);
        g3 = new JLabel("JAVA:");
        f3 = new JTextField(3);
        g4 = new JLabel("离散数学·:");
        f4 = new JTextField(3);
        g5 = new JLabel("编译原理:");
        f5 = new JTextField(3);
        grade1.add(g1);
        grade1.add(f1);
        grade1.add(g2);
        grade1.add(f2);
        grade1.add(g3);
        grade1.add(f3);
        grade1.add(g4);
        grade1.add(f4);
        grade1.add(g5);
        grade1.add(f5);
        this.add(grade1);

        grade2 = new JPanel();
        g6 = new JLabel("大学物理:");
        f6 = new JTextField(3);
        g7 = new JLabel("计算机组成原理:");
        f7 = new JTextField(3);
        g8 = new JLabel("操作系统:");
        f8 = new JTextField(3);
        g9 = new JLabel("计算机网络·:");
        f9 = new JTextField(3);
        g10 = new JLabel("线性代数:");
        f10 = new JTextField(3);
        grade2.add(g6);
        grade2.add(f6);
        grade2.add(g7);
        grade2.add(f7);
        grade2.add(g8);
        grade2.add(f8);
        grade2.add(g9);
        grade2.add(f9);
        grade2.add(g10);
        grade2.add(f10);
        this.add(grade2);

        jp7 = new JPanel();
        jp7.add(okButton);
        jp7.add(cancelButton);
        this.add(jp7);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] grade = {f1.getText(),f2.getText(),f3.getText(),f4.getText(),f5.getText(),
                        f6.getText(),f7.getText(),f8.getText(),f9.getText(),f10.getText()};

                niubi.addStudent(jtf1.getText(),jtf2.getText(),jtf3.getText(),jtf4.getText(),jtf5.getText(),jtf6.getText(),grade);
                dispose();
            }
        });


        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        this.setTitle("添加学生信息");
        this.setSize(580, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new addStudent();
    }

}
