package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        CourseManager cmgr = new CourseManager();
        TeacherManager tmgr = new TeacherManager();
        StudentManager smgr = new StudentManager();
        GradeManager gmgr = new GradeManager();

        cmgr.couArr = cmgr.CreateCourseArr();
        tmgr.teaArr = tmgr.CreateTeacherArr();
        smgr.stuArr = smgr.CreateStudentArr();
        gmgr.graArr = gmgr.CreateGradeArr();

        Menu mn = new Menu();
        mn.ShowMenu(cmgr, tmgr, smgr, gmgr);

//        CourseTest ct = new CourseTest();
//        TeacherTest tt = new TeacherTest();
//        StudentTest st = new StudentTest();
//        GradeTest gt = new GradeTest();
//
//        ct.Test();System.out.println();
//        tt.test();System.out.println();
//        st.test();System.out.println();
//        gt.test();System.out.println();
//
//        Menu mn = new Menu();
//        mn.ShowMenu();

    }
}
