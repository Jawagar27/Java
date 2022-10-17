import java.util.*;
public class node2 {

    int data;
    
    node2 next;


    node2(int n){

        this.data = n;
        next = null;
    }


    public void displayLink() { 
        System.out.print(data + " "); 
        System.out.print(" ");}
}
