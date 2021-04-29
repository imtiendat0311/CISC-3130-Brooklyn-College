package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyQueue {
    //queue node
    static class Qnode{
        private String name;
        private Qnode next;
        public Qnode(String name){
            this.name=name;
            this.next=null;
        }
    }//node
    MyQueue list;

    //field
    Qnode front, rear;
    public MyQueue(){
        this.front=this.rear=null;
    }
    public MyQueue(String filename) throws IOException {

        this.front=this.rear=null;
        list=new MyQueue();
        //bufferedbreader to read file
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while((line=br.readLine())!=null){
            String[] split=line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            for(int i=0;i<split.length;i++){
                enqueue(list,split[i]);
            }
        }

    }

    //enqueue
    public static void enqueue(MyQueue list,String name){
       Qnode temp = new Qnode(name);
        if(list.rear==null){
            list.front=list.rear=temp;
       }
        list.rear.next=temp;
        list.rear=temp;
    }

    //dequeue
    public static void dequeue(MyQueue list){
        if(list.front==null){
            return;
        }
        Qnode temp=list.front;
        list.front=list.front.next;
        if(list.front==null){
            list.rear=null;
        }
    }
}
