package com.company;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        String[] myfile = {"week1.txt","week2.txt"};
        WeeklyQueue allWeek= new WeeklyQueue();
        for(int i=0;i< myfile.length;i++){
            MyQueue dataExtract=new MyQueue(myfile[i]);
            WeeklyQueue.enqueue(allWeek,dataExtract);
        }


    }
}
