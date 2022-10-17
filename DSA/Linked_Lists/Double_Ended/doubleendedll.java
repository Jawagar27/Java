import java.util.*;
public class doubleendedll {

    node2 head = null;
    node2 tail = null;
    
    void insertatbeggining(int n){

        node2 currnNode = new node2(n);
            if(head == null){
                //when the linkedlist is empty and the first data is entered  

                head = tail = currnNode; //link both the head and the tail to the first element
                //adding the data to the tail of the list as 
               
                
            }else{ 

                currnNode.next = head; //we make the previous head as the next of the current variable 
                                        //thereby pushing it as the next value

                head = currnNode; //then we reassign the head making the new value the first value
               
            }
        }

        void insertatlast(int n){
            //this is used to 
        node2 newNode = new node2(n);
         
            if(head == null){
                //when the linkedlist is empty and the first data is entered  

                head = tail = newNode;
               
                
            }else{ 
             tail.next = newNode; //the tail is then changed 
             tail = newNode; //assigning new value to the new tail
        }
}   
    public int deletefirst(){

    int temp = head.data;
    if (head == null) {
        throw new NullPointerException("There is no data to delete in the linked lists");
    }
    else if(head.next == null){//if there is only one data in the linked list
        tail = null;
        head = head.next;
}else{
    head = head.next;
}

return temp;
}

public void displaylist(){
     node2 current = head;
     if(head == null){
        System.out.println("list is empty");
        return;
     }
     while (current != null)  {
        System.out.println(current.data + " "); //we print the data in the node
        current = current.next;//we move the temp to the next variable
        //so that the next value is printed in the next iteration
     }
}
}
