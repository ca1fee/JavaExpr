package com.company;

import java.io.IOException;
import java.util.Scanner;

public class CourseManager {

    Course[] CreateCourseArr(){
        Course[] CourArr = new Course[0];
        return CourArr;
    }

    void PrintCourseArr(Course[] arr){
        int i;
        for(i = 0; i < arr.length; i++){
            if(null == arr[i]){
                System.out.println("arr[" + i + "] is null");
                break;
            }
            arr[i].PrintCourse();
        }
    }
    //Search by id
    int SearchCourse(Course[] arr, int cid){
        int find = -1, i;
        for(i = 0; i < arr.length; i++){
            if(cid == arr[i].GetId())
                find = i;
        }

        return find;
    }

    Course[] AddCourse(Course[] arr, int cid, String name){
        int goal = SearchCourse(arr, cid);
        if(-1 != goal){
            System.out.println("The course has Id as " + cid +"has existed !");
            return arr;
        }
        else{
            int i, j;
            Course[] NewArr = new Course[arr.length + 1];
            for(i = 0; i < arr.length; i++){
                NewArr[i] = arr[i];
            }
            NewArr[i] = new Course(cid, name);
            System.out.println("Add course has id " + cid +" success!");

            return NewArr;
        }
    }

    Course[] DeleteCourse(Course[] arr, int cid){
        int goal = SearchCourse(arr, cid);
        if(-1 == goal){
            System.out.println("Course has Id as" + cid +"not found !");
            return arr;
        }
        else{
            int i, j;
            Course[] NewArr = new Course[arr.length - 1];
            for(i = 0; i < goal; i++){
                NewArr[i] = arr[i];
            }
            for(i = goal, j = goal+1; i < NewArr.length && j < arr.length; i++, j++){
                NewArr[i] = arr[j];
            }
            System.out.println("Delete course has id " + cid +" success!");

            return NewArr;
        }
    }

    void ChangeCourseInfo(Course[] arr, int cid, String name){
        int goal = SearchCourse(arr, cid);
        if(-1 == goal){
            System.out.println("Course has Id as" + cid +"not found !");
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
