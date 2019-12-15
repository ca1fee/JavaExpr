package com.company;

import java.util.Scanner;

public class GradeManager {
    Grade[] graArr;

    Grade[] CreateGradeArr(){
        Grade[] GradArr = new Grade[0];
        return GradArr;
    }


    void PrintGradeArr(){
        PrintGradeArr(this.graArr);
    }
    void PrintGradeArr(Grade[] arr){
        int i;
        for(i = 0; i < arr.length; i++){
            if(null == arr[i]){
                System.out.println("arr[" + i + "] is null");
                break;
            }
            arr[i].PrintGrade();
        }
    }
    //Search by id
    int SearchSpecificStudentGrade(){//return the grade, when it is not exist, return -1
        int grade = -1;

        Scanner sc = new Scanner(System.in);
        System.out.print("input the course id: ");
        int tempId = sc.nextInt();sc.nextLine();//to avoid only input a int and the program jump over the next input
        System.out.print("input the student id: ");
        int tempSid = sc.nextInt();sc.nextLine();
        grade = SearchStudentGrade(this.graArr, tempId, tempSid);

        return grade;
    }

    int SearchStudentGrade(Grade[] arr,int cid, int sid){//return grade
        int find = -1, i, grade = -1;
        find = SearchGradeByCid(this.graArr, cid);
        if(-1 == find)
            return -1;


        for(i = 0; i < arr[find].sid.length; i++){
            if(arr[find].sid[i] == sid) {
                grade = arr[find].score[i];
                break;
            }
        }

        if(-1 == grade){
            System.out.println("The student"+cid+"'s grade may has not come out !");
            return -1;
        }
        else
            return grade;

    }

    int SearchGradeByCid(Grade[] arr, int cid){//return the subtitle in this.graArr
        int find = -1, i;
        for(i = 0; i < arr.length; i++){
            if(cid == arr[i].cid){
                find = i;
            }
        }

        if(-1 == find){
            System.out.println("The student"+cid+"'s grade may has not come out !");
            return -1;
        }
        else
            this.graArr[find].PrintGrade();

        return find;
    }
    int SearchGrade(){//return the subtitle in this.graArr
        Scanner sc = new Scanner(System.in);
        System.out.print("input the grade id: ");
        int tempGid = sc.nextInt();sc.nextLine();
        return SearchGradeById(tempGid);
    }
    int SearchGradeById(int gid){//return the subtitle in this.graArr
        int find = -1, i;
        for(i = 0; i < this.graArr.length; i++){
            if(gid == this.graArr[i].gid){
                find = i;
            }
        }
        if(-1 != find)
            this.graArr[find].PrintGrade();

        return find;
    }



    Grade[] AddGrade(){
        Scanner sc = new Scanner(System.in);

        System.out.print("input the grade id: ");
        int tempGid = sc.nextInt();sc.nextLine();

        System.out.print("input the course id: ");
        int tempCid = sc.nextInt();sc.nextLine();

        System.out.print("input the course name: ");
        String tempName = sc.nextLine();

        System.out.print("input the teacher id: ");
        int tempTid = sc.nextInt();sc.nextLine();

        return AddGrade(this.graArr, tempGid, tempCid, tempName, tempTid);
    }
    Grade[] AddGrade(Grade[] arr,int gid, int cid, String cName, int tid){
        int goal = SearchGradeById(gid);
        if(-1 != goal){
            System.out.println("The course has Id as " + cid +"has existed !");
            return arr;
        }
        else{
            int i, j;
            Grade[] NewArr = new Grade[arr.length + 1];
            for(i = 0; i < arr.length; i++){
                NewArr[i] = arr[i];
            }
            NewArr[i] = new Grade(gid, cid, cName, tid);
            this.graArr = NewArr;
            System.out.println("Add course has id " + cid +" success!");
            this.PrintGradeArr();

            return NewArr;
        }
    }

    Grade[]DeleteGrade(){
        Scanner sc = new Scanner(System.in);
        System.out.print("input the grade id: ");
        int tempId = sc.nextInt();

        return DeleteGrade(this.graArr, tempId);
    }

    Grade[] DeleteGrade(Grade[] arr, int  gid){
        int goal = SearchGradeById(gid);
        if(-1 == goal){
            System.out.println("Grade has name as" + gid +"not found !");
            return arr;
        }
        else{
            int i, j;
            Grade[] NewArr = new Grade[arr.length - 1];
            for(i = 0; i < goal; i++){
                NewArr[i] = arr[i];
            }
            for(i = goal, j = goal+1; i < NewArr.length && j < arr.length; i++, j++){
                NewArr[i] = arr[j];
            }
            arr = NewArr;
            System.out.println("Delete course has name " + gid +" success!");

            PrintGradeArr(arr);

            return NewArr;
        }
    }

    void ChangeGrade(){
        Scanner sc = new Scanner(System.in);
        System.out.print("input the grade id: ");
        int tempId = sc.nextInt();sc.nextLine();
        int find = SearchGradeById(tempId);

        if(-1 == find){
            System.out.println("The grade has id "+tempId+" is not exited !");
            return;
        }

        System.out.println("Please input new grade info:");

        System.out.print("input new grade id: ");
        int tempGid = sc.nextInt();sc.nextLine();
        System.out.print("input new course id: ");
        int tempCid = sc.nextInt();sc.nextLine();
        System.out.print("input new course name: ");
        String tempCname = sc.nextLine();
        System.out.print("input new teacher id: ");
        int tempTid = sc.nextInt();sc.nextLine();

        this.graArr[find].ChangeId(tempGid, tempCid, tempTid);
        this.graArr[find].ChangeCName(tempCname);

        System.out.println("Change grade has id as "+tempId+" success !");

    }

    int AddStudentGrade(){
        Scanner sc = new Scanner(System.in);
        System.out.print("input course id: ");
        int tempCid = sc.nextInt();sc.nextLine();
        System.out.print("input student id: ");
        int tempSid = sc.nextInt();sc.nextLine();
        System.out.print("input grade: ");
        int tempGrade = sc.nextInt();sc.nextLine();

        int flag = AddStudentGrade(this.graArr, tempCid, tempSid, tempGrade);

        return flag;
    }

    int AddStudentGrade(Grade[] arr,int cid, int sid, int grade){
        int find = SearchStudentGrade(arr, cid, sid);

        if(-1 != find){
            System.out.println("The grade belongs to student who's id is "+sid+" has existed !");
            return -1;
        }

        find = SearchGradeByCid(arr, cid);

        int[] pSidArr = this.graArr[find].sid;
        int[] pScoreArr = this.graArr[find].score;

        int[] NewSidArr = new int[pSidArr.length + 1];
        int[] NewScoreArr = new int[pScoreArr.length + 1];

        int i = 0;
        for(i = 0; i < pSidArr.length; i++){
            NewSidArr[i] = pSidArr[i];
            NewScoreArr[i] = pScoreArr[i];
        }
        NewSidArr[i] = sid;
        NewScoreArr[i] = grade;

        this.graArr[find].sid = NewSidArr;
        this.graArr[find].score = NewScoreArr;
        this.graArr[find].stu_cnt++;

        System.out.println("Add student grade successfully !");
        this.PrintGradeArr();

        return 1;
    }



}
