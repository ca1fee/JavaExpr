package com.company;

public class TeacherManager {
    Teacher[] CreateTeacherArr(){
        Teacher[] TeacArr = new Teacher[0];
        return TeacArr;
    }

    void PrintTeacherArr(Teacher[] arr){
        int i;
        for(i = 0; i < arr.length; i++){
            if(null == arr[i]){
                System.out.println("arr[" + i + "] is null");
                break;
            }
            arr[i].PrintTeacher();
        }
    }
    //Search by id
    int SearchTeacher(Teacher[] arr, int tid){
        int find = -1, i;
        for(i = 0; i < arr.length; i++){
            if(tid == arr[i].GetId())
                find = i;
        }

        return find;
    }

    Teacher[] AddTeacher(Teacher[] arr, int tid, String name){
        int goal = SearchTeacher(arr, tid);
        if(-1 != goal){
            System.out.println("The course has Id as " + tid +"has existed !");
            return arr;
        }
        else{
            int i, j;
            Teacher[] NewArr = new Teacher[arr.length + 1];
            for(i = 0; i < arr.length; i++){
                NewArr[i] = arr[i];
            }
            NewArr[i] = new Teacher(tid, name);
            System.out.println("Add course has id " + tid +" success!");

            return NewArr;
        }
    }

    Teacher[] DeleteTeacher(Teacher[] arr, int tid){
        int goal = SearchTeacher(arr, tid);
        if(-1 == goal){
            System.out.println("Teacher has Id as" + tid +"not found !");
            return arr;
        }
        else{
            int i, j;
            Teacher[] NewArr = new Teacher[arr.length - 1];
            for(i = 0; i < goal; i++){
                NewArr[i] = arr[i];
            }
            for(i = goal, j = goal+1; i < NewArr.length && j < arr.length; i++, j++){
                NewArr[i] = arr[j];
            }
            System.out.println("Delete course has id " + tid +" success!");

            return NewArr;
        }
    }

    void ChangeTeacherInfo(Teacher[] arr, int tid, String name){
        int goal = SearchTeacher(arr, tid);
        if(-1 == goal){
            System.out.println("Teacher has Id as" + tid +"not found !");
            return;
        }
        else{
            arr[goal].ChangeId(tid);
            arr[goal].ChangeName(name);
        }
    }
}
