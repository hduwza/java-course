package com.ceshi;



import javax.swing.*;
import java.io.*;
import java.sql.SQLOutput;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

//项目分析：
// 1. 学生类 √
// 2. 实现 以班级号为文件夹 学号为文件 的 增加学生信息 的功能 √
// 3. 实现 获得所有同学信息 的功能 √
// 4. 实现 获取随机5个学生信息 的功能 √
// 5. 实现 查找学生是否在表内 的功能 √
// 6. update 增加学生的10科成绩 完善函数 √
// 7. 实现 班级类 √
// 8. 实现 获取班级信息 的函数 √
// 9. 实现 增 √   删 √    改 √
// 班级号 学号 姓名 年龄 体重 身高

public class niubi {

    // 十门课 数组
    public static String[] course = {"高等数学","数据结构","JAVA","离散数学","编译原理","大学物理","计算机组成原理",
            "操作系统","计算机网络","线性代数"};

    //添加学生
    public static void addStudent(String class_no, String id, String name, String age, String weight, String height, String[] grade) {


        String folder = "./data/";
        File dir = new File(folder + class_no);

        //如果这个学生的班级号还没有出现过，就新建一个班级号文件夹
        if (!dir.exists())
            dir.mkdir();

        //创建在班级号文件夹下的 以学号为名 的txt文件
        File file = new File(folder + class_no + "/" + id + ".txt");
        //创建文件 必须需要 try-catch块
        try {
            if(!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        //写入 学生文件 信息
        try {
            FileWriter fileWritter = new FileWriter(folder + class_no + "/" + file.getName());
            fileWritter.write(class_no+"\r\n");
            fileWritter.write(id+"\r\n");
            fileWritter.write(name+"\r\n");
            fileWritter.write(age+"\r\n");
            fileWritter.write(weight+"\r\n");
            fileWritter.write(height+"\r\n");
            for (int i = 0; i < 10; i++) {
                fileWritter.write(grade[i]+"\r\n");
            }
            fileWritter.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取所有学生信息
    public static ArrayList<Student> getAllstudentsInfo() {
        String folder_name = "./data/";
        File folder = new File(folder_name);
        String[] ClassList = folder.list();
        ArrayList<Student> Students = new ArrayList<>();

        //外循环： 每个班级号文件夹
        for (int index = 0; index < ClassList.length; index++) {
            // System.out.println(ClassList[index]);  输出文件夹名
            // Mac OSX 环境下的 bUG
            if (ClassList[index].equals(".DS_Store") )
                continue;
            File dir = new File(folder_name + ClassList[index]);
            String[] FileList = dir.list();
            // System.out.println();
            //内循环： 每个班级号文件夹中 的 学生txt文件
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
                Students.add(student);

            }

        }
        return Students;
    }

    //获取所有学生信息 只输出数据 没有返回数组
    public static void getAllstudentsInfow_output() {
        ArrayList<Student>  students = getAllstudentsInfo();

        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }
    }

    //获取随机5个学生信息
    public static void getRandom5studentsInfo() {
        //储存 学生信息文件 的地址
        ArrayList<String> arrayList = new ArrayList<>();
        String folder_name = "./data/";
        File folder = new File(folder_name);
        String[] ClassList = folder.list();

        //外循环： 每个班级号文件夹
        for (int index = 0; index < ClassList.length; index++) {
            // System.out.println(ClassList[index]);  输出文件夹名
            if (ClassList[index].equals(".DS_Store") )
                continue;
            File dir = new File(folder_name + ClassList[index]);
            String[] FileList = dir.list();

            //内循环： 每个班级号文件夹中 的 学生txt文件
            for (int file_index = 0; file_index < FileList.length; file_index++) {
                // File file = new File(folder_name + ClassList[index] + "/" + FileList[file_index]);
                // System.out.println(FileList[file_index]);  输出文件名
                if (FileList[file_index].equals(".DS_Store") )
                    continue;
                arrayList.add(folder_name + ClassList[index] + "/" + FileList[file_index]);
            }
        }


        int random_num = (int) (Math.random() * (arrayList.size() - 5));
        //遍历 数组
        for (int index = random_num; index < random_num + 5; index++) {
            //储存学生信息 的数组
            ArrayList<String> arrayList_student = new ArrayList<>();
            File file = new File(arrayList.get(index));
            try {
                FileReader fr = new FileReader(file);
                BufferedReader bf = new BufferedReader(fr);
                String str;
                while ((str = bf.readLine()) != null) {
                    arrayList_student.add(str);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 输出 txt文件 信息
            System.out.println("班级： " + arrayList_student.get(0));
            System.out.println("学号： " + arrayList_student.get(1));
            System.out.println("姓名： " + arrayList_student.get(2));
            System.out.println("年龄： " + arrayList_student.get(3));
            System.out.println("体重： " + arrayList_student.get(4));
            System.out.println("身高： " + arrayList_student.get(5));
            for (int i = 0; i < 10; i++) {
                System.out.print(course[i] +":" + arrayList_student.get(6+i) + "  ");
            }
            System.out.println("");
            System.out.println("--------------------------------------");
        }
    }

    //查找学生是否在表内
    public static void findStudent() {
        System.out.print("输入要查找的学生学号： ");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        //获得学生名单
        ArrayList<Student> list = getAllstudentsInfo();
        //查找
        int flag = 1;
        for (int index = 0; index < list.size(); index++) {

            if (list.get(index).getId().equals(id)) {     // 字符串不能用 == 比较
                System.out.println(list.get(index));
                System.out.println("-----------------------------");
                flag = 0;
                break;
            }
        }
        if (flag == 1)
            System.out.println("查无此人");
    }

    //查询学生是否在表内 返回 boolean 类型
    public static boolean findStudent(String id) {
        //获得学生名单
        ArrayList<Student> list = getAllstudentsInfo();
        //查找
        for (int index = 0; index < list.size(); index++) {

            if (list.get(index).getId().equals(id)) {     // 字符串不能用 == 比较
                return true;

            }
        }
        return false;
    }

    //获取一个班级的学生信息
    public static void getOneclass() {
        System.out.print("输入要查找的班级号： ");
        Scanner scanner = new Scanner(System.in);
        String class_no = scanner.nextLine();

        //查找是否有这个班级号文件夹
        String folder_name = "./data/";
        File folder = new File(folder_name);
        String[] ClassList = folder.list();
        //查找是否成功的标记
        int flag = 1;

        for (int index = 0; index < ClassList.length; index++) {

            if (ClassList[index].equals(class_no)) {
                Classmates classmates = new Classmates(class_no);
                classmates.getAllstudentsInfo();
                flag = 0;
                break;
            }

        }
        if (flag == 1) {
            System.out.println("查无此班");
        }

    }

    //删除学生 信息
    public static void deleteStudent(String id) {

        if (findStudent(id)) {
            String folder_name = "./data/";
            File folder = new File(folder_name);
            String[] ClassList = folder.list();

            for (int index = 0; index < ClassList.length; index++) {
                // Mac OSX 环境下的 bUG
                if (ClassList[index].equals(".DS_Store") )
                    continue;
                File dir = new File(folder_name + ClassList[index]);
                String[] FileList = dir.list();

                for (int file_index = 0; file_index < FileList.length; file_index++) {
                    ;
                    if (FileList[file_index].equals(id+".txt")) {
                        File file = new File(folder_name + ClassList[index] + "/" + FileList[file_index]);
                        file.delete();
                    }


                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "没有这个学生.", "通知", JOptionPane.ERROR_MESSAGE);
        }

    }

    //改动学生 信息
    public static void change() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入学生学号: ");
        String input_id = scanner.nextLine();
        System.out.print("请问需要改动学生的哪一门成绩: ");
        String change_course = scanner.nextLine();
        System.out.print("改为多少分: ");
        String new_grade = scanner.nextLine();
        //这门课在course中的索引
        int index;
        for (index = 0; index < course.length; index++) {
            if (course[index].equals(change_course))
                break;
        }


        if (findStudent(input_id)) {

            String folder_name = "./data/";
            File folder = new File(folder_name);
            String[] ClassList = folder.list();
            ArrayList<String> arrayList = new ArrayList<>();

            for (int i = 0; i < ClassList.length; i++) {
                // Mac OSX 环境下的 bUG
                if (ClassList[i].equals(".DS_Store"))
                    continue;
                File dir = new File(folder_name + ClassList[i]);
                String[] FileList = dir.list();

                for (int file_index = 0; file_index < FileList.length; file_index++) {

                    if (FileList[file_index].equals(input_id + ".txt")) {
                        File file = new File(folder_name + ClassList[i] + "/" + FileList[file_index]);
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

                        //读取要改动的 学生 的信息
                        String class_no = arrayList.get(0);
                        String id = arrayList.get((1));
                        String name = arrayList.get(2);
                        String age = arrayList.get(3);
                        String weight = arrayList.get(4);
                        String height = arrayList.get(5);
                        String[] grade = new String[10];
                        for (int j = 0; j < 10; j++) {
                            grade[j] = arrayList.get(6+j);
                        }
                        //改动成绩
                        grade[index] = new_grade;

                        //写入
                        try {
                            FileWriter fileWritter = new FileWriter(file);
                            fileWritter.write(class_no+"\r\n");
                            fileWritter.write(id+"\r\n");
                            fileWritter.write(name+"\r\n");
                            fileWritter.write(age+"\r\n");
                            fileWritter.write(weight+"\r\n");
                            fileWritter.write(height+"\r\n");
                            for (int k = 0; k < 10; k++) {
                                fileWritter.write(grade[k]+"\r\n");
                            }
                            fileWritter.close();
                        }catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            System.out.println("没有这个学生");
        }
    }

    public static void main(String[] args) {
            //ArrayList<Student> students = getAllstudentsInfo();
            //getAllstudentsInfow_output();
            //getRandom5studentsInfo();
            //addStudent();
            //findStudent();
            //getOneclass();
            //deleteStudent();
            //change();
        ArrayList<Student> students =  niubi.getAllstudentsInfo();
        for ( Student student : students) {
            System.out.println(student);
        }
        }

}








/*
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入学号：");
        String id = scanner.nextLine();
        System.out.print("输入姓名：");
        String name= scanner.nextLine();
        System.out.print("输入年龄：");
        int age = scanner.nextInt();
        System.out.print("输入体重：");
        double weight = scanner.nextDouble();
        System.out.print("输入身高：");
        double height = scanner.nextDouble();
        System.out.print("这学期修的课程有几门：");
        int i = scanner.nextInt();

        String[] course = new String[i];
        String s = scanner.nextLine();
        for (int n = 0; n < i; n++) {
            course[n] = scanner.nextLine();

        }
        Student student = new Student(id,name,age,weight,height,course);

        System.out.println(student.toString());
 */

