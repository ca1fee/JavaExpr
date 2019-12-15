package com.company;

public class GradeManager {
    Grade[] graArr;

    Grade[] CreateGradeArr(){
        Grade[] GradArr = new Grade[0];
        return GradArr;
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
    int SearchStudentGrade(Grade[] arr, int sid, String cName){
        int find = -1, i;
        find = SearchGrade(arr, cName);
        if(-1 == find)
            return -1;

        for(i = 0; i < arr[find].sid.length; i++){
            if(arr[find].sid[i] == sid)
                break;
        }

        arr[find].PrintGrade();

        return arr[find].score[i];
    }

    int SearchGrade(Grade[] arr, String cName){
        int find = -1, i;
        for(i = 0; i < arr.length; i++){
            if(cName == arr[i].cName){
                find = i;
            }
        }

        return find;
    }

    Grade[] AddGrade(Grade[] arr,int gid, int cid, String cName, int tid){
        int goal = SearchGrade(arr, cName);
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
            System.out.println("Add course has id " + cid +" success!");

            return NewArr;
        }
    }

    Grade[] DeleteGrade(Grade[] arr, String cName){
        int goal = SearchGrade(arr, cName);
        if(-1 == goal){
            System.out.println("Grade has name as" + cName +"not found !");
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
            System.out.println("Delete course has name " + cName +" success!");

            PrintGradeArr(arr);

            return NewArr;
        }
    }

//    void ChangeGradeInfo(Grade[] arr, int cid, String name){
//        int goal = SearchGrade(arr, cid);
//        if(-1 == goal){
//            System.out.println("Grade has Id as" + cid +"not found !");
//            return;
//        }
//        else{
//            arr[goal].ChangeId(cid);
//            arr[goal].Changename(name);
//        }
//    }

}
