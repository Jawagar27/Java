import java.io.Serializable;
import java.util.*;

public class DSA_LinkedList implements Serializable{
    //double ended, doubly linked list coding
    DSA_ListNode head = null;
    DSA_ListNode tail = null;

    public void insertatbeggining(Object val){

        DSA_ListNode newnode = new DSA_ListNode(val);

        if(head == null){
          tail = head = newnode; //enters the first data as the last node as the data entered first is going to be taken as the last figure
           
        }else{

            head.prev = newnode; //assigning the previous of the old head as the newnode
            newnode.next = head; //assigning the next of the newnode as the previous head
            head = newnode; //assigning the data of the newnode to the head
        }
    }
    public void insertatlast(Object val){
        DSA_ListNode newnode = new DSA_ListNode(val);

        if(head == null){
                head = tail=  newnode;
                
        }else{
            tail.next = newnode; //linking the next of the previous tail to the current last node
            newnode.prev = tail; //making new node the tail
            tail = newnode; //assigning the value
        }
        
        }


       
        public void insertatpos(int pos, int val){
            if(pos == 0){
                insertatbeggining(val);
            }else{
                DSA_ListNode newnode = new DSA_ListNode(val);
                DSA_ListNode temp = head;

                for(int i = 0; i<pos - 1; i++){
                        temp = temp.next; 
                }

                newnode.next = temp.next;
                newnode.prev = temp.prev;
            }
        }
        

        public void deletefirst(){
          
            if (head == null) {
                
                System.out.println("No items in the linked list to delete");
            } else if (head.next == null) {
                head = tail= null;
            } else {
                head.next.prev = null;
                head = head.next;//link the head to the next value in the linked list
                //make the previous null
            }
        }  

        public void deletelast(){
          
            if (isempty()) {
                
                System.out.println("No items in the linked list to delete");
            }else if (head.next == null) {
                head = null;
            } else {
                tail.prev.next = null;
                tail = tail.prev;
             

            }
        }  

        public boolean isempty() { //used to test if the linlked list is empty with no values
            boolean empty = true;
            if(head == null){
                empty = true;
            }else{
                empty = false;
            }
            return empty;
        }       
        public void displaylist(){
            DSA_ListNode current = head;
            if(head == null){
               System.out.println("list is empty");
               return;
            }
            while (current != null)  {
               System.out.println(current.value + " "); //we print the data in the node
               current = current.next;//we move the temp to the next variable
               //so that the next value is printed in the next iteration
            }
       }

      
}
