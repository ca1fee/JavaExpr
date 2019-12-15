package com.company;

import java.io.IOException;
import java.util.Scanner;

public class StudentManager {
    Student[] stuArr;

    Student[] CreateStudentArr(){
        this.stuArr = new Student[0];
        return this.stuArr;
    }

    void PrintStudentArr(){
        int i, emptFlag = -1;
        for(i = 0; i < this.stuArr.length; i++){
            emptFlag++;
            if(null == this.stuArr[i]){
                System.out.println("this.stuArr[" + i + "] is null");
                break;
            }
            this.stuArr[i].PrintStudent();
        }
        if(-1 == emptFlag)
            System.out.println("--empty--");
    }
    //Search by id
    int SearchStudent(){
        int find = -1, i;
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the sid: ");
        int sid = sc.nextInt();
        find = this.SearchStudent(sid);

        return find;
    }
    int SearchStudent(int sid){
        int find = -1, i;
        for(i = 0; i < this.stuArr.length; i++){
            if(sid == this.stuArr[i].GetId())
                find = i;
        }
        if(-1 != find)
            this.stuArr[find].PrintStudent();
        else
            System.out.println("The student has id as "+sid+"is not existed");

        return find;
    }

    Student[] AddStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the sid: ");
        int sid = sc.nextInt();sc.nextLine();
        System.out.print("Input the student name: ");
        String name = sc.nextLine();

        return AddStudent(sid, name);
    }

    Student[] AddStudent( int sid, String name){
        int goal = SearchStudent(sid);
        if(-1 != goal){
            System.out.println("The student has Id as " + sid +"has existed !");
            return this.stuArr;
        }
        else{
            int i, j;
            Student[] NewArr = new Student[this.stuArr.length + 1];
            for(i = 0; i < this.stuArr.length; i++){
                NewArr[i] = this.stuArr[i];
            }
            NewArr[i] = new Student(sid, name);
            this.stuArr = NewArr;
            System.out.println("Add student has id " + sid +" success!");

            PrintStudentArr();

            return NewArr;
        }
    }

    Student[] DeleteStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the sid: ");
        int sid = sc.nextInt();
        return DeleteStudent(sid);
    }

    Student[] DeleteStudent( int sid){
        int goal = SearchStudent(  sid);
        if(-1 == goal){
            System.out.println("Student has Id as" + sid +"not found !");
            return this.stuArr;
        }
        else{
            int i, j;
            Student[] NewArr = new Student[this.stuArr.length - 1];
            for(i = 0; i < goal; i++){
                NewArr[i] = this.stuArr[i];
            }
            for(i = goal, j = goal+1; i < NewArr.length && j < this.stuArr.length; i++, j++){
                NewArr[i] = this.stuArr[j];
            }

            this.stuArr = NewArr;

            System.out.println("Delete student has id " + sid +" success!");

            PrintStudentArr();

            return NewArr;
        }
    }


    void ChangeStudentInfo(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the sid: ");
        int sid = sc.nextInt();
        System.out.print("Input the student name: ");
        String name = sc.nextLine();
        ChangeStudentInfo(sid, name);
    }

    void ChangeStudentInfo( int sid, String name){
        int goal = SearchStudent(sid);
        if(-1 == goal){
            System.out.println("Student has Id as" + sid +"not found !");
            return;
        }
        else{
            try {
                System.out.println("Please input new student info: ");
                int tempSid = (int)System.in.read();
                Scanner sc = new Scanner(System.in);
                String tempName = sc.nextLine();
                this.stuArr[goal].ChangeId(tempSid);
                this.stuArr[goal].ChangeName(tempName);
                System.out.println("Change info success !");
            }catch(IOException e){
                e.printStackTrace();
            }

        }
    }
}
