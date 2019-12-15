package com.company;
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

                default: System.exit(0);
            }
            //System.out.println(choice);
        }


    }

    void ShowCourseMenu(CourseManager cmgr){
        while(true){
            //show the menu start
            System.out.println("--------course menu--------");
            System.out.println("1.add course");
            System.out.println("2.delete course");
            System.out.println("3.search course");
            System.out.println("4.change course");
            System.out.println("else: quit");

            //show the menu end
            //use switch to choose method start
            int Cho = 0;
            Scanner gsc = new Scanner(System.in);
            System.out.println("input to choose:");
            Cho = gsc.nextInt();
            //System.out.println(ChoCourse);
            switch (Cho){
                case 1: cmgr.AddCourse();
                        break;
                case 2: cmgr.DeleteCourse();
                        break;
                case 3: cmgr.SearchCourse();
                        break;
                case 4: cmgr.ChangeCourseInfo();

                default: return;
            }
            //use switch to choose method end
        }
    }
    void ShowTeacherMenu(TeacherManager tmgr){
        while(true){
            //show the menu start
            System.out.println("--------teacher menu--------");
            System.out.println("1.add teacher");
            System.out.println("2.delete teacher");
            System.out.println("3.search teacher");
            System.out.println("4.change teacher");
            System.out.println("else: quit");

            //show the menu end
            //use switch to choose method start
            int Cho = 0;
            Scanner gsc = new Scanner(System.in);
            System.out.println("input to choose:");
            Cho = gsc.nextInt();
            //System.out.println(ChoTeacher);
            switch (Cho){
                case 1: tmgr.AddTeacher();
                    break;
                case 2: tmgr.DeleteTeacher();
                    break;
                case 3: tmgr.SearchTeacher();
                    break;
                case 4: tmgr.ChangeTeacherInfo();

                default: return;
            }
            //use switch to choose method end
        }
    }
    void ShowStudentMenu(StudentManager smgr){
        while(true){
            //show the menu start
            System.out.println("--------student menu--------");
            System.out.println("1.add student");
            System.out.println("2.delete student");
            System.out.println("3.search student");
            System.out.println("4.change student");
            System.out.println("else: quit");

            //show the menu end
            //use switch to choose method start
            int Cho = 0;
            Scanner gsc = new Scanner(System.in);
            System.out.println("input to choose:");
            Cho = gsc.nextInt();
            //System.out.println(ChoStudent);
            switch (Cho){
                case 1: smgr.AddStudent();
                    break;
                case 2: smgr.DeleteStudent();
                    break;
                case 3: smgr.SearchStudent();
                    break;
                case 4: smgr.ChangeStudentInfo();

                default: return;
            }
            //use switch to choose method end
        }
    }
    
    void ShowGradeMenu(GradeManager gmgr){
        System.out.println("--------course menu--------");
        System.out.println("1.add course");
        System.out.println("2.delete course");
        System.out.println("3.search course");
        System.out.println("4.change course");
        System.out.println("else: quit");

        int Cho = 0;
        Scanner gsc = new Scanner(System.in);
        System.out.println("input to choose:");
        Cho = gsc.nextInt();
        switch (Cho){
            case 3:
                int grade = -1;
                int tempid;
                String tempSname, tempCname;
                System.out.print("input the student id: ");
                tempid = gsc.nextInt();
//                      System.out.print("input the student name: ");
//                      tempSname = gsc.nextLine();
                System.out.print("input the course name: ");
                tempCname = gsc.nextLine();

                grade = gmgr.SearchStudentGrade(gmgr.graArr, tempid, tempCname);

                if(-1 == grade){
                    System.out.println("Your grade has not come out !");

                }
                break;
            default: return;
        }

    }

}
