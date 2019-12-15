package com.company;

import java.io.IOException;
import java.util.Scanner;

public class CourseManager {

    Course[] couArr;

    Course[] CreateCourseArr(){
        this.couArr = new Course[0];
        return this.couArr;
    }

    void PrintCourseArr(){
        int i, emptFlag = -1;
        for(i = 0; i < this.couArr.length; i++){
            emptFlag++;
            if(null == this.couArr[i]){
                System.out.println("this.couArr[" + i + "] is null");
                break;
            }
            this.couArr[i].PrintCourse();
        }
        if(-1 == emptFlag)
            System.out.println("--empty--");
    }
    //Search by id
    int SearchCourse(){
        int find = -1, i;
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the cid: ");
        int cid = sc.nextInt();
        find = this.SearchCourse(cid);

        return find;
    }
    int SearchCourse(int cid){
        int find = -1, i;
        for(i = 0; i < this.couArr.length; i++){
            if(cid == this.couArr[i].GetId())
                find = i;
        }
        if(-1 != find)
            this.couArr[find].PrintCourse();
        else
            System.out.println("The course has id as "+cid+"is not existed");

        return find;
    }

    Course[] AddCourse(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the cid: ");
        int cid = sc.nextInt();sc.nextLine();
        System.out.print("Input the course name: ");
        String name = sc.nextLine();

        return AddCourse(cid, name);
    }

    Course[] AddCourse( int cid, String name){
        int goal = SearchCourse(cid);
        if(-1 != goal){
            System.out.println("The course has Id as " + cid +"has existed !");
            return this.couArr;
        }
        else{
            int i, j;
            Course[] NewArr = new Course[this.couArr.length + 1];
            for(i = 0; i < this.couArr.length; i++){
                NewArr[i] = this.couArr[i];
            }
            NewArr[i] = new Course(cid, name);
            this.couArr = NewArr;
            System.out.println("Add course has id " + cid +" success!");

            PrintCourseArr();

            return NewArr;
        }
    }

    Course[] DeleteCourse(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the cid: ");
        int cid = sc.nextInt();
        return DeleteCourse(cid);
    }

    Course[] DeleteCourse( int cid){
        int goal = SearchCourse(  cid);
        if(-1 == goal){
            System.out.println("Course has Id as" + cid +"not found !");
            return this.couArr;
        }
        else{
            int i, j;
            Course[] NewArr = new Course[this.couArr.length - 1];
            for(i = 0; i < goal; i++){
                NewArr[i] = this.couArr[i];
            }
            for(i = goal, j = goal+1; i < NewArr.length && j < this.couArr.length; i++, j++){
                NewArr[i] = this.couArr[j];
            }

            this.couArr = NewArr;

            System.out.println("Delete course has id " + cid +" success!");

            PrintCourseArr();

            return NewArr;
        }
    }


    void ChangeCourseInfo(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the cid: ");
        int cid = sc.nextInt();
        System.out.print("Input the course name: ");
        String name = sc.nextLine();
        ChangeCourseInfo(cid, name);
    }

    void ChangeCourseInfo( int cid, String name){
        int goal = SearchCourse(cid);
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
                this.couArr[goal].ChangeId(tempSid);
                this.couArr[goal].ChangeName(tempName);
                System.out.println("Change info success !");
            }catch(IOException e){
                e.printStackTrace();
            }

        }
    }
}
