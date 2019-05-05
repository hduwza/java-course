package com.ceshi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Classmates {
    private ArrayList<Student> one_class_students;

    //构造方法 通过传递一个 班级号 来查找 班级文件夹
    public Classmates(String input_class_no) {
        String folder_name = "./data/";
        File folder = new File(folder_name);
        String[] ClassList = folder.list();

        one_class_students = new ArrayList<>();

        for (int index = 0; index < ClassList.length; index++) {
            if (ClassList[index].equals(input_class_no)) {
                File classmate = new File(folder_name + ClassList[index]);
                String[] FileList = classmate.list();
                for (int file_index = 0; file_index < FileList.length; file_index++) {
                    //Mac OSX 环境下的 bUG
                    if (FileList[file_index].equals(".DS_Store") )
                        continue;

                    File file = new File(folder_name + ClassList[index] + "/" + FileList[file_index]);
                    // System.out.println(FileList[file_index]);  输出文件名
                    ArrayList<String> arrayList = new ArrayList<>();
                    try {
                        FileReader fr = new FileReader(file);
                        BufferedReader bf = new BufferedReader(fr);
                        String str;
                        while ((str = bf.readLine()) != null) {
                            arrayList.add(str);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //读取学生 信息
                    String class_no = arrayList.get(0);
                    String id = arrayList.get((1));
                    String name = arrayList.get(2);
                    String age = arrayList.get(3);
                    String weight = arrayList.get(4);
                    String height = arrayList.get(5);
                    String[] grade = new String[10];
                    for (int i = 0; i < 10; i++) {
                        grade[i] = arrayList.get(6+i);
                    }
                    Student student = new Student(class_no, id, name, age, weight, height, grade);
                    one_class_students.add(student);
                }
            }
        }
    }

    //获取所有学生信息
    public void getAllstudentsInfo() {
        for (int i = 0; i < one_class_students.size(); i++) {
            System.out.println(one_class_students.get(i));
        }
    }

    //获取随机5个学生信息
    public void  getRandom5studentsInfo() {
        int random_num = (int) (Math.random() * (one_class_students.size() - 5));
        for (int i = random_num; i < random_num + 5; i++) {
            System.out.println(one_class_students.get(i));
        }
    }

}
