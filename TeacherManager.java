package com.company;

import java.io.*;
import java.util.Scanner;

public class TeacherManager {
    Teacher[] teaArr;


    TeacherManager() {
        this.teaArr = new Teacher[0];
        Scanner tfsc = null;
        File teaFile = new File("teacher.txt");
        if(!teaFile.exists()){
            try{
                teaFile.createNewFile();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        try{
            tfsc = new Scanner(new FileInputStream(teaFile));
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        String tempName;
        int tempTid;
        while(tfsc.hasNext()){
            tempName = tfsc.next();
            tempTid = tfsc.nextInt();tfsc.nextLine();
            this.AddTeacher(tempTid, tempName);
        }
        tfsc.close();
        System.out.println("Initialise teacher info successfully !");
        this.PrintTeacherArr();
    }

    Teacher[] CreateTeacherArr(){
        this.teaArr = new Teacher[0];
        return this.teaArr;
    }

    void PrintTeacherArr(){
        int i, emptFlag = -1;
        for(i = 0; i < this.teaArr.length; i++){
            emptFlag++;
            if(null == this.teaArr[i]){
                System.out.println("this.teaArr[" + i + "] is null");
                break;
            }
            this.teaArr[i].PrintTeacher();
        }
        if(-1 == emptFlag)
            System.out.println("--empty--");
    }
    //Search by id
    int SearchTeacher(){
        int find = -1, i;
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the tid: ");
        int tid = sc.nextInt();
        find = this.SearchTeacher(tid);

        return find;
    }
    int SearchTeacher(int tid){
        int find = -1, i;
        for(i = 0; i < this.teaArr.length; i++){
            if(tid == this.teaArr[i].GetId())
                find = i;
        }
        if(-1 != find)
            this.teaArr[find].PrintTeacher();
        else
            System.out.println("The teacher has id as "+tid+"is not existed");

        return find;
    }

    Teacher[] AddTeacher(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the tid: ");
        int tid = sc.nextInt();sc.nextLine();
        System.out.print("Input the teacher name: ");
        String name = sc.nextLine();

        return AddTeacher(tid, name);
    }

    Teacher[] AddTeacher( int tid, String name){
        int goal = SearchTeacher(tid);
        if(-1 != goal){
            System.out.println("The teacher has Id as " + tid +"has existed !");
            return this.teaArr;
        }
        else{
            int i, j;
            Teacher[] NewArr = new Teacher[this.teaArr.length + 1];
            for(i = 0; i < this.teaArr.length; i++){
                NewArr[i] = this.teaArr[i];
            }
            NewArr[i] = new Teacher(tid, name);
            this.teaArr = NewArr;
            System.out.println("Add teacher has id " + tid +" success!");

            PrintTeacherArr();

            return NewArr;
        }
    }

    Teacher[] DeleteTeacher(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the tid: ");
        int tid = sc.nextInt();
        return DeleteTeacher(tid);
    }

    Teacher[] DeleteTeacher( int tid){
        int goal = SearchTeacher(  tid);
        if(-1 == goal){
            System.out.println("Teacher has Id as" + tid +"not found !");
            return this.teaArr;
        }
        else{
            int i, j;
            Teacher[] NewArr = new Teacher[this.teaArr.length - 1];
            for(i = 0; i < goal; i++){
                NewArr[i] = this.teaArr[i];
            }
            for(i = goal, j = goal+1; i < NewArr.length && j < this.teaArr.length; i++, j++){
                NewArr[i] = this.teaArr[j];
            }

            this.teaArr = NewArr;

            System.out.println("Delete teacher has id " + tid +" success!");

            PrintTeacherArr();

            return NewArr;
        }
    }


    void ChangeTeacherInfo(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the tid: ");
        int tid = sc.nextInt();
        System.out.print("Input the teacher name: ");
        String name = sc.nextLine();
        ChangeTeacherInfo(tid, name);
    }

    void ChangeTeacherInfo( int tid, String name){
        int goal = SearchTeacher(tid);
        if(-1 == goal){
            System.out.println("Teacher has Id as" + tid +"not found !");
            return;
        }
        else{
            try {
                System.out.println("Please input new student info: ");
                int tempSid = (int)System.in.read();
                Scanner sc = new Scanner(System.in);
                String tempName = sc.nextLine();
                this.teaArr[goal].ChangeId(tempSid);
                this.teaArr[goal].ChangeName(tempName);
                System.out.println("Change info success !");
            }catch(IOException e){
                e.printStackTrace();
            }

        }
    }

    int SaveTeacherInfo() {
        try {
            FileWriter sfw = new FileWriter("teacher.txt");
            int i;
            for (i = 0; i < this.teaArr.length; i++) {
                sfw.write(this.teaArr[i].name+"\t");
                sfw.write(this.teaArr[i].tid+"\n");
            }
            System.out.print("Save teacher successfully !");
            sfw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return 1;
    }
}
