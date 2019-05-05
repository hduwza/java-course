package com.ceshi;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GetAllStudents extends JFrame {

    public GetAllStudents() {

        //从文件读取学生信息
        ArrayList<Student> students =  niubi.getAllstudentsInfo();

        //表行
        Object[][] cellData = new Object[students.size()][16];
        //Object[][] cellData = {{"row1-col1", "row1-col2"},{"row2-col1", "row2-col2"}};
        //表头
        String[] columnNames = {"班级号", "学号", "姓名", "年龄", "体重", "身高","高等数学","数据结构","JAVA","离散数学","编译原理","大学物理","计算机组成原理",
                "操作系统","计算机网络","线性代数"};
        //String[] columnNames = {"col1", "col2"};


        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            String class_no = student.getClass_no();
            String name = student.getName();
            String id = student.getId();
            String age = student.getAge();
            String weight = student.getWeight();
            String height = student.getHeight();
            String[] grade = student.getGrade();

            cellData[i][0] = class_no;
            cellData[i][1] = id;
            cellData[i][2] = name;
            cellData[i][3] = age;
            cellData[i][4] = weight;
            cellData[i][5] = height;
            for (int index = 0; index < 10; index++) {
                cellData[i][6+index] = grade[index];
            }
        }


        //建表
        JTable table = new JTable(cellData, columnNames);

        JPanel panel = new JPanel(new BorderLayout());

        panel.add(table.getTableHeader(), BorderLayout.NORTH);
        // 把 表格内容 添加到容器中心
        panel.add(table, BorderLayout.CENTER);

        this.setContentPane(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(900,400);
        this.setVisible(true);


    }

    public static void main(String[] args) {
        new GetAllStudents();
    }
}
