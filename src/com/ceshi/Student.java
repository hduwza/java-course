package com.ceshi;

import java.security.PrivateKey;

public class Student {
    private String class_no;
    private String id;
    private String name;
    private String age;
    private String weight;
    private String height;
    private String[] grade;

    public Student(String class_no, String id, String name, String age, String weight, String height, String[] grade) {
        this.class_no = class_no;
        this.id = id;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.grade = grade;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public void setHeight(String height) {
        this.height = height;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClass_no(String class_no) {
        this.class_no = class_no;
    }

    public void setGrade(String[] grade) {
        this.grade = grade;
    }

    public String getClass_no() {
        return class_no;
    }

    public String getId() {
        return id;
    }

    public String[] getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    @Override
    public String toString() {

        String body_info;                                               //体重
        if(Double.parseDouble(height)/Double.parseDouble(weight) < 1.13)
            body_info = "体脂率高";
        else if (Double.parseDouble(height)/Double.parseDouble(weight) >1.7 )
            body_info = "身材太瘦";
        else
            body_info = "身材合适";

        String grades = "";
        for (int index = 0; index < grade.length; index++) {
            grades += niubi.course[index] + ": " + grade[index] + "  ";
        }

        return "id: "+id+"\nname: "+name+"\nage: "+age+"\nheight: "+height+"\nweight: "+weight
                + "\n身体状况: " + body_info + "\n" + grades + "\n---------------------------------";
    }
}
/*
    public void show() {
        System.out.println("id: "+id+" name: "+name+" age: "+age+" height: "+height+" weight: "+weight);
        System.out.print("本学期修读的课程有: ");
        for(int i = 0; i < course.length; i++) {

            System.out.print(course[i] +" ");
        }
        System.out.println("");
        if(height/weight < 1.13)
            System.out.println("too heavy");
        else if (height/weight >1.7 )
            System.out.println("too thin");
        else
            System.out.println("healthy body");
    }

    @Override
    public String toString() {
        String print_course = "";                                       //课程
        for(int i = 0; i < course.length; i++)
            print_course += course[i] + " ";

        String body_info;                                               //体重
        if(height/weight < 1.13)
            body_info = "体脂率高";
        else if (height/weight >1.7 )
            body_info = "身材太瘦";
        else
            body_info = "身材合适";

        return "id: "+id+"\nname: "+name+"\nage: "+age+"\nheight: "+height+"\nweight: "+weight
                + "\n本学期修读的课程有: " + print_course
                + "\n身体状况: " + body_info;
    }
}

*/