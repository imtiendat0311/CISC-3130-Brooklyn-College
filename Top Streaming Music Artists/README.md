# [A1] Top Streaming Artists
### Learning Objectives
* Review prerequisite Java programming knowledge by putting together a small project
* Review the of the Java array type, scaling to 2D arrays
* Review of Java OOP concepts with creating classes, and instantiating them
* Create custom linked list class with appropriate members and methods
* Compare the operations for working with the array type and linked list
### Problem Description
A record label executive received text files that contain the top streamed music artists during certain weeks. <br>Each file represents one track by an artist. One track means one song. An artist's name might appear multiple times. The data comes from Spotify Charts.

In order for their in house IT to be able to process the information, they need someone to help process it.

Each text file is a comma separated value (CSV) file that has a few columns like the following table 3:

Position | Track Name|Artist|Streams|URL
------- | ---------------- | -------------- |------|-----
1	| One Dance |	Drake, WizKid, Kyla	| 100 |	…
2 |	Lean On |	Major Lazer, MØ, DJ Snake | 99 | …
3	| Sunflower - Spider-Man: Into the Spider-Verse |	Post Malone, Swae Lee |	98 |	…
...|...|...|...|...

* **Who appears on the top streamed list?**

First, the exec wants to know which artists appears on the list and how many times they appear. Prepare an output file with contents of your nested array so that the record label executive can see this report. Note on data links: These links are provided merely for quick access to data files. You may choose to download any date or country from Spotify Charts of interest. Best practice with any type of data work is to provide a note on whichever data you select and rationale for doing so.

   * Link to Data Extract 1: Week ending Jan 23, 2020 (Global)
   * Link to Data Extract 2: Week ending Jan 23, 2020 (US)
   
Not knowing data structures yet, it seems the way to proceed quickly at building is with Java arrays. Read in the text file and then save the CSV file format into a nested Java array like myList below. If an artist appears multiple times, then that artist probably should only appear once in your nested array.

```java
/* Java nested array syntax */

int cols = 4;  // arbitrary number represents columns to create
int rows = 10; // arbitrary number represents rows to create;
String[][] myList = new String[rows][cols];

int[][] arr = { { 1, 2 }, { 3, 4 } };
System.out.println("arr[0][0] = " + arr[0][0]);

```
Will you limit to just the artist name? Perhaps you should discuss your decision with your class colleagues.

* ***Who are the music artists (in alphabetical order)?***

It just so happens that this imaginary VIP client has a thing for alphabetized lists and wants to see the artist names in alphabetical order. Since you learned about linked lists in class, you should know how to create one.

You can probably take the array from part 1, which is hopefully a truncated version of the raw data, and insert artist names into a sorted linked list.

You may use the example classes below to start with to design a sorted list of TopStreamingArtists. You may also create your own classes. The classes work like templates because they offer a blueprint, where you can reuse the object oriented structure by creating objects from those classes.

```java
/* A node represents an artist */
 class Artist {
    private String name;
    private Artist next;
   // add constructors
 }

/* The List TopStreamingArtists is composed of a series of artist names */
 class TopStreamingArtists {
    private Artist first;
    public void TopStreamingArtists(){
      first = null;
    }
    public boolean isEmpty(){
     return (first == null);
    }
 } 
 ```
<br> Using the linked list structure you've designed and created, you can resume with the data processing in order to provide another report to the insert an artist name to the TopStreamingArtists linked list.

```java
public static void main(String [ ] args) {
    TopStreamingArtists artistNames = new TopStreamingArtists();
    artistNames.insert("Stage Name");
    artistNames.displayList();
}
```
<br>Make sure to print out the report for the exec showing the data in ascending order by Artist name.
