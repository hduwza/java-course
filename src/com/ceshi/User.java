package com.ceshi;

import java.io.*;
import java.util.ArrayList;

public class User {

    private String name;
    private String passsword;

    public User() {
        //文件路径: ./user.txt
        String folder_name = "user.txt";
        File file = new File(folder_name);
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

        this.name = arrayList.get(0);
        this.passsword = arrayList.get(1);
    }

    //更改密码
    public void changePassword(String passsword) {
        this.passsword =  passsword;

        //文件路径: ./user.txt
        String folder_name = "./user.txt";
        File folder = new File(folder_name);
        try {
            FileWriter fileWritter = new FileWriter(folder_name);
            fileWritter.write(this.name+"\r\n");
            fileWritter.write(this.passsword+"\r\n");
            fileWritter.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public String getPasssword() {
        return passsword;
    }
}

