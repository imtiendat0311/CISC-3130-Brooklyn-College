# How To Do This

### Java Main 

I want to create a array2D to import data of csv file into it but array in JAVA is not resize able so i need to count how many row csv have then -2 to remove header

I use this method to do so by keep reading newline then increment the row value this method will return number of row

```
java
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
        }
  ```
After got number of row i create a 2d array 

```java
String[][] spotify2D= new String[row-2][5];
```

Use input method to input data into 2d Array

```java
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
        
```
 I want to create a 2 seprate array that containt a unique list of artist name and frequency of artist name 
 
 To do so, i need to count how many unique name in the 2d list 
 
 I use this method
 
 ```java
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
 ```
 Then i create a Int Array and a String Array
  Int array is store how many time artist appear in the list
  String array is store artist name
```java
 String[]spotifyNameUnique=new String[rowUnique];
 int[]spotifyCountUnique=new int[rowUnique];
```
I create a getList name method to add unique name into a String array that i just create
```java
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
    }
```
Then i create a method that can count how many time a parameter occur in the list

And use for loop go from i=0 to i=array.length-1, 

calling method that i just create passing array2d and element of String array with index of i 

and finally adding the result of method into Int Array

```java
public static void main(String args[]){
        for(int g=0;g<rowUnique;g++){
            spotifyCountUnique[g]=getFrequence(spotify2D,spotifyNameUnique[g]);
        }
        }
            public static int getFrequence(String[][]data,String name){
        int count=0;
        for(int i=0;i<data.length;i++){
            if(name.equals(data[i][2])){
                count++;
            }
        }
   return count; }
```

### That IS THE END OF PROBLEM 1 
--------------------------------------

creating a  linkedlist store TopStreamingArtists object
and use for loop from i=0 to i=array.length-1 to adding element of String and Int array with index of i into the list 
```java
TopStreamingArtists list = new TopStreamingArtists();
for (int i=0;i<rowUnique;i++) {
            TopStreamingArtists.insert(list, spotifyNameUnique[i],spotifyCountUnique[i]);
}
```
calling sort method then finish 
```java     
TopStreamingArtists.ascendingSorting(list);
```


### Custome LinkedList

node of linkedlist
```java
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
}
```        
insert method
```java
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
```

use normally bubble sort to sort the linkedlist from small to large 

```java
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
```
