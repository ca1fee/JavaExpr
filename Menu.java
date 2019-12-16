package com.company;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public void ShowMenu(CourseManager cmgr, TeacherManager tmgr, StudentManager smgr, GradeManager gmgr){
        while(true){
            System.out.println("---------menu-----------");

            System.out.println("1.Course");
            System.out.println("2.Teacher");
            System.out.println("3.Student");
            System.out.println("4.Grade");
            System.out.println("else.exit");

            System.out.println("\t\tinput number to chose your status~");


            int choice = 0;
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            switch (choice){
                case 1: ShowCourseMenu(cmgr);
                        break;
                case 2: ShowTeacherMenu(tmgr);
                        break;
                case 3: ShowStudentMenu(smgr);
                        break;
                case 4: ShowGradeMenu(cmgr, gmgr);
                        break;

                default: System.exit(0);
            }
            //System.out.println(choice);
        }


    }

    void ShowCourseMenu(CourseManager cmgr){
        while(true){
            //show the menu start
            System.out.println("--------course menu--------");
            System.out.println("0.print course");
            System.out.println("1.add course");
            System.out.println("2.delete course");
            System.out.println("3.search course");
            System.out.println("4.change course");
            System.out.println("else: quit");

            //show the menu end
            //use switch to choose method start
            int Cho = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("input to choose:");
            Cho = sc.nextInt();
            //System.out.println(ChoCourse);
            switch (Cho){
                case 0: cmgr.PrintCourseArr();
                        break;
                case 1: cmgr.AddCourse();
                        break;
                case 2: cmgr.DeleteCourse();
                        break;
                case 3: cmgr.SearchCourse();
                        break;
                case 4: cmgr.ChangeCourseInfo();

                default:cmgr.SaveCourseInfo();
                        return;
            }
            //use switch to choose method end
        }
    }
    void ShowTeacherMenu(TeacherManager tmgr){
        while(true){
            //show the menu start
            System.out.println("--------teacher menu--------");
            System.out.println("0.print teacher");
            System.out.println("1.add teacher");
            System.out.println("2.delete teacher");
            System.out.println("3.search teacher");
            System.out.println("4.change teacher");
            System.out.println("else: quit");

            //show the menu end
            //use switch to choose method start
            int Cho = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("input to choose:");
            Cho = sc.nextInt();
            //System.out.println(ChoTeacher);
            switch (Cho){
                case 0: tmgr.PrintTeacherArr();
                        break;
                case 1: tmgr.AddTeacher();
                    break;
                case 2: tmgr.DeleteTeacher();
                    break;
                case 3: tmgr.SearchTeacher();
                    break;
                case 4: tmgr.ChangeTeacherInfo();

                default:tmgr.SaveTeacherInfo();
                        return;
            }
            //use switch to choose method end
        }
    }
    void ShowStudentMenu(StudentManager smgr){
        while(true){
            //show the menu start
            System.out.println("--------student menu--------");
            System.out.println("0.print course");
            System.out.println("1.add student");
            System.out.println("2.delete student");
            System.out.println("3.search student");
            System.out.println("4.change student");
            System.out.println("else: quit and save");

            //show the menu end
            //use switch to choose method start
            int Cho = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("input to choose:");
            Cho = sc.nextInt();
            //System.out.println(ChoStudent);
            switch (Cho){
                case 0: smgr.PrintStudentArr();
                        break;
                case 1: smgr.AddStudent();
                        break;
                case 2: smgr.DeleteStudent();
                        break;
                case 3: smgr.SearchStudent();
                        break;
                case 4: smgr.ChangeStudentInfo();
                        break;

                default:smgr.SaveStudentInfo();
                        return;
            }
            //use switch to choose method end
        }
    }
    
    void ShowGradeMenu(CourseManager cmgr, GradeManager gmgr){

        while(true){
            System.out.println("--------grade menu--------");
            System.out.println("0.print grade");
            System.out.println("1.add grade");
            System.out.println("2.delete grade");
            System.out.println("3.search grade");
            System.out.println("4.change grade");
            System.out.println("5.search student grade");
            System.out.println("6.add student grade");

            System.out.println("else: quit");

            int Cho = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("input to choose:");
            Cho = sc.nextInt();sc.nextLine();
            switch (Cho){
                case 0: gmgr.PrintGradeArr();
                        break;
                case 1: gmgr.AddGrade();
                        break;
                case 2: gmgr.DeleteGrade();
                        break;
                case 3: gmgr.SearchGrade();
                        break;
                case 4: gmgr.ChangeGrade();
                        break;
                case 5: gmgr.SearchSpecificStudentGrade();
                        break;
                case 6: gmgr.AddStudentGrade();
                        break;
                default:gmgr.SaveGradeInfo();
                        return;
            }
        }


    }

}
