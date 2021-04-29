package com.company;

public class SongHistoryList {
    static class Qnode {
        private String name;
        private Qnode next;
    }
    Qnode first;
    public void SongHistoryList(){
        this.first=null;
    }
    public void addSong(String songName){
        Qnode temp=new Qnode();
        if (temp == null){
            return;
        }
            temp.name=songName;
        temp.next=first;
        first=temp;
    }
    public void pop(){
        if(first==null){
            return;
        }
        first=first.next;
    }

}
