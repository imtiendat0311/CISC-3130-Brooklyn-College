package com.company;

public class WeeklyQueue {
    static class Qnode {
        private MyQueue name;
        private Qnode next;

        public Qnode(MyQueue name) {
                this.name=name;
                this.next=null;
        }
    }
    Qnode front, rear;
    public WeeklyQueue(){
        this.front=this.rear=null;
    }

    public static void enqueue(WeeklyQueue list,MyQueue name){
        Qnode temp = new Qnode(name);
        if(list.rear==null){
            list.front=list.rear=temp;
        }
        list.rear.next=temp;
        list.rear=temp;
    }//end queue

    public static void dequeue(WeeklyQueue list){
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
