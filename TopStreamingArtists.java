package com.company;
import java.util.HashSet;


public class TopStreamingArtists {

    Artist head; // first data
    //node
    static class Artist {
        private String name;
        private int appearTime;
        private Artist next;
        //constructor
        Artist(String name ,int appearTime) {
            this.name = name;
            this.appearTime=appearTime;
            this.next = null;
        }
        Artist(String name){

            this.name = name;

            this.next = null;
        }

        public void setName(String name){
            this.name=name;
        }
        public void setAppearTime(int appearTime){
            this.appearTime=appearTime;
        }
        public int getAppearTime(){
            return appearTime;
        }
        public String getName(){
            return this.name;
        }

        public String toString(){
            return this.name+" "+this.appearTime;
        }
    }//end node class

    //insert to the last
    public static TopStreamingArtists insert(TopStreamingArtists list,String name,int time) {

        Artist new_Artist = new Artist(name,time);
        // if empty make input as head
        if(list.head==null){
            list.head= new_Artist;
        }
        else{
            //traverse till last
            // insert the new node
            Artist last= list.head;
            while(last.next!=null){
                last=last.next;
            }
            last.next= new_Artist;
        }
        return list;
    }//end of insert method

    public static void printList(TopStreamingArtists list){
        Artist currentArtist=list.head;
        while (currentArtist != null) {
            if (currentArtist.next == null) {
                System.out.println(currentArtist);
            } else {
                System.out.println(currentArtist);
            }
            currentArtist = currentArtist.next;
        }
    }//end print

    public static void ascendingSorting(TopStreamingArtists list){
        Artist currentArtist = list.head;
                Artist index=null;
        String temp;
        if(list.head==null){
            return;
        }else{
            while(currentArtist!=null){
                index=currentArtist.next;
                while(index!=null){
                    if(currentArtist.name.compareToIgnoreCase(index.name)>0){
                        temp= currentArtist.name;
                        currentArtist.name=index.name;
                        index.name=temp;
                    }
                    index = index.next;
                }
                currentArtist=currentArtist.next;
            }
        }
    }

    //remove Duplicate method
    static void removeDuplicate(TopStreamingArtists list){



    }

}









