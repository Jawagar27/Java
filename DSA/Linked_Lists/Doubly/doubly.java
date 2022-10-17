public class doubly {
//double ended, doubly linked list coding
    node1 head = null;
    node1 tail = null;

    void insertatbeggining(int val){

        node1 newnode = new node1(val);

        if(head == null){
          tail = newnode; //enters the first data as the last node as the data entered first is going to be taken as the last figure
           
        }else{

            head.prev = newnode; //assigning the previous of the old head as the newnode
            newnode.next = head; //assigning the next of the newnode as the previous head
            head = newnode; //assigning the data of the newnode to the head
        }
    }
    void insertatlast(int val){
        node1 newnode = new node1(val);

        if(head == null){
                head = tail=  newnode;
                
        }else{
            tail.next = newnode;
            newnode.prev = tail;
        }
        tail = newnode;
        }


       
        void insertatpos(int pos, int val){
            if(pos == 0){
                insertatbeggining(val);
            }else{
                node1 newnode = new node1(val);
                node1 temp = head;

                for(int i = 0; i<pos - 1; i++){
                        temp = temp.next; 
                }

                newnode.next = temp.next;
                newnode.prev = temp.prev;
            }
        }
        

        void deletefirst(){
          
            if (head == null) {
                
                System.out.println("No items in the linked list to delete");
            } else if (head.next == null) {
                tail= null;
            } else {
                head.next.prev = null;
                head = head.next;//link the head to the next value in the linked list
                //make the previous null
            }
        }  

        void deletelast(){
          
            if (head == null) {
                
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
            node1 current = head;
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
