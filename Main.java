package com.company;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) {
        String filename="/Users/datnguyen/IdeaProjects/homework1/src/com/company/spotify.csv";
       int row= countRow(filename);
        String[][] spotify2D= new String[row-2][5];
        input2d(filename,spotify2D,200,5);
        int rowUnique=countUnique(spotify2D);
        String[]spotifyNameUnique=new String[rowUnique];
        int[]spotifyCountUnique=new int[rowUnique];
        getListName(spotify2D,spotifyNameUnique);
        for(int g=0;g<rowUnique;g++){
            spotifyCountUnique[g]=getFrequence(spotify2D,spotifyNameUnique[g]);
        }
        for(int f=0;f<rowUnique;f++){
            System.out.println(spotifyNameUnique[f]+" "+spotifyCountUnique[f]);
        }
        System.out.println("");
        System.out.println(".......Creating_LinkedList.......");
       TopStreamingArtists list = new TopStreamingArtists();

        System.out.println(".......Importing_Into_LinkedList.......");
        for (int i=0;i<rowUnique;i++) {
            TopStreamingArtists.insert(list, spotifyNameUnique[i],spotifyCountUnique[i]);
        }

       System.out.println(".......Sorting.......");
        TopStreamingArtists.ascendingSorting(list);
        System.out.println(".......Printing.......");
        TopStreamingArtists.printList(list);
        } //main

        // input into array2d
        public static void input2d(String filename, String[][] data_2D,int row,int col){
        try{
            BufferedReader br= new BufferedReader(new FileReader(filename));
            String newline;
            int i=0;
            br.readLine();
            br.readLine();
            while((newline=br.readLine())!=null){

                String[]split=newline.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
               for(int j=0;j<split.length;j++){
                   String data=split[j].replace("\"","");
                   data_2D[i][j]=data;
               }
               i++;
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        }//end of input method


        //count  row
        public static int countRow(String filename){
        int row=0;
        try{
            BufferedReader br= new BufferedReader(new FileReader(filename));
            String line;
            while((line= br.readLine())!=null){
                row++;
            }
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
            return row;
        }//end of count method
    public static int countUnique(String[][]data){
        int count=0;
        for(int i=0;i<data.length;i++){
            if(i==0){
                count++;
            }else{
                boolean flag=true;
               for(int j=0;j<i;j++){
                   if(data[j][2].equals(data[i][2])){
                       flag=false;
                   }
               }
               if(flag){
                   count++;
               }
            }
        }
        return count;
    }
    public static void getListName(String[][]data,String[]name){
        int i=0;
        for(int j=0;j<data.length;j++){
        if(j==0){
           name[i]= data[j][2];
           i++;
        }
        else{
            boolean flag=true;
            for(int k=0;k<j;k++){
                if(data[k][2].equals(data[j][2])){
                    flag=false;
                    break;
                }
            }
            if(flag){
                name[i]=data[j][2];
                i++;
            }
            }
        }
    }//end get list

    public static int getFrequence(String[][]data,String name){
        int count=0;
        for(int i=0;i<data.length;i++){
            if(name.equals(data[i][2])){
                count++;
            }
        }
   return count; }

}
