package com.company;
import java.util.Scanner;

public class Menu {
    public void ShowMenu(){
        System.out.println("---------menu-----------");

        System.out.println("1.Course");
        System.out.println("2.Teacher");
        System.out.println("3.Student");
        System.out.println("4.Grade");
        System.out.println("\t\tinput number to chose~");

        //mgr.CourseManager cmgr = mgr.new CourseManager();

        int choice = 0;
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();
        switch (choice){
            //case 1: this.ShowCourseMenu(cmgr);

        }
        //System.out.println(choice);
    }

    void ShowCourseMenu(CourseManager cmng){
        //show the menu start
        System.out.println("--------course menu--------");
        System.out.println("1.create course array");
        System.out.println("2.show course array");
        System.out.println("3.search course");
        System.out.println("4.add course");
        System.out.println("5.delete course");
        System.out.println("6.change course");
        System.out.println("-1.back");
        //show the menu end
        //use switch to choose method start
        int ChoCourse = 0;
        Scanner csc = new Scanner(System.in);
        System.out.println("input to choose:");
        ChoCourse = csc.nextInt();
        //System.out.println(ChoCourse);
        switch (ChoCourse){
            //case 1: mng.CourseManager
        }

        //use switch to choose method end
    }
    void ShowTeacherMenu(Teacher[] TeacArr){

    }
    void ShowStudentMenu(Student[] StudArr){

    }
    void ShowGradeMenu(Grade[] GradArr){

    }

}
