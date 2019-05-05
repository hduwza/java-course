package com.ceshi;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JMenuBar menuBar = new JMenuBar();
    private JMenu newMenu = new JMenu("添加");
    private JMenu viewMenu = new JMenu("查询");
    private JMenu changeMenu = new JMenu("修改");
    private JMenu deleteMenu = new JMenu("删除");

    private JMenuItem[] newItem = { new JMenuItem("添加学生信息")};
    private JMenuItem[] viewItem = { new JMenuItem("全体学生"), new JMenuItem("随机5个")};
    private JMenuItem[] changeItem = {new JMenuItem("修改学生信息")};
    private JMenuItem[] deleteItem = {new JMenuItem("删除学生信息")};

    public MainFrame() {
        // 监听函数 ..

        for (int i = 0; i < viewItem.length; i++) {
            viewMenu.add(viewItem[i]);
        }
        newMenu.add(newItem[0]);
        changeMenu.add(changeItem[0]);
        deleteMenu.add(deleteItem[0]);

        menuBar.add(newMenu);
        menuBar.add(viewMenu);
        menuBar.add(changeMenu);
        menuBar.add(deleteMenu);
        setJMenuBar(menuBar);

        this.setTitle("主页面");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500,200);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        newItem[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent newstudent = new addStudent();
            }
        });

        viewItem[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GetAllStudents allStudents = new GetAllStudents();
            }
        });

        viewItem[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Get5Students fivestudents = new Get5Students();
            }
        });

        changeItem[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangeStudent student = new ChangeStudent();
            }
        });

        deleteItem[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteStudent student = new DeleteStudent();
            }
        });
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
    }

}
