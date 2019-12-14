package com.company;

import java.io.IOException;
import java.util.Scanner;

public class StudentManager {
    Student[] CreateStudentArr(){
        Student[] StudArr = new Student[0];
        return StudArr;
    }

    void PrintStudentArr(Student[] arr){
        int i;
        for(i = 0; i < arr.length; i++){
            if(null == arr[i]){
                System.out.println("arr[" + i + "] is null");
                break;
            }
            arr[i].PrintStudent();
        }
    }
    //Search by id
    int SearchStudent(Student[] arr, int sid){
        int find = -1, i;
        for(i = 0; i < arr.length; i++){
            if(sid == arr[i].GetId())
                find = i;
        }

        return find;
    }


    Student[] AddStudent(Student[] arr, int sid, String name){
        int goal = SearchStudent(arr, sid);
        if(-1 != goal){
            System.out.println("The course has Id as " + sid +"has existed !");
            return arr;
        }
        else{
            int i, j;
            Student[] NewArr = new Student[arr.length + 1];
            for(i = 0; i < arr.length; i++){
                NewArr[i] = arr[i];
            }
            NewArr[i] = new Student(sid, name);
            System.out.println("Add course has id " + sid +" success!");

            return NewArr;
        }
    }

    Student[] DeleteStudent(Student[] arr, int sid){
        int goal = SearchStudent(arr, sid);
        if(-1 == goal){
            System.out.println("Student has Id as" + sid +"not found !");
            return arr;
        }
        else{
            int i, j;
            Student[] NewArr = new Student[arr.length - 1];
            for(i = 0; i < goal; i++){
                NewArr[i] = arr[i];
            }
            for(i = goal, j = goal+1; i < NewArr.length && j < arr.length; i++, j++){
                NewArr[i] = arr[j];
            }
            System.out.println("Delete course has id " + sid +" success!");

            return NewArr;
        }
    }

    void ChangeStudentInfo(Student[] arr, int sid){
        int goal = SearchStudent(arr, sid);
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
                arr[goal].ChangeId(tempSid);
                arr[goal].ChangeName(tempName);
                System.out.println("Change info success !");
            }catch(IOException e){
                e.printStackTrace();
            }

        }
    }
}
