/**
 * node1
 */
public class node1 {

    int data; //variable to hold data in the node
    node1 prev;//reference variable to hold previous link in the node
    node1 next;//reference variable to hold next link in the node

    node1(int value){
        this.data = value;
        prev = null;
        next = null;
    }

    public void displayLink() { 
        System.out.print(data + " "); 
        System.out.print(" ");}
}
