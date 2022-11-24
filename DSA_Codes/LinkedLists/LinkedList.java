import java.util.Iterator;

public class LinkedList implements Iterable{
    
    ListNode head = null;
    ListNode tail = null;
    int index = -1;
    
    public ListNode getHead() {
        return head;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public void setHead(ListNode head) {
        this.head = head;
    }
    public ListNode getTail() {
        return tail;
    }
    public void setTail(ListNode tail) {
        this.tail = tail;
    }
    public LinkedList(){

    }
    public LinkedList(ListNode head, ListNode tail) {
        this.head = head;
        this.tail = tail;
    }

    public Iterator iterator(){

        return new LinkedListIterator(this);
       
    }

    private class LinkedListIterator implements Iterator {
    
        private ListNode iterNext;
        public LinkedListIterator(LinkedList list){
            iterNext = list.head;
        }
        
        public boolean hasNext(){

            return(iterNext != null);
        }

        public Object next(){
            Object value;
            if (iterNext == null) {
                
                value = null;

            }else{
                value = iterNext.getVal();
                iterNext = iterNext.getNext();
            }
            return value;
        }

        public void remove(){
            throw new UnsupportedOperationException("Not supported!");
        }
    }

    public boolean isEmpty(){
        boolean empty = false;
            if (head == null) {
                empty = true;
            } else {
                empty = false;
            }
        return empty;

    }

    public void insertFirst(Object val){
        ListNode newNode = new ListNode(val);
        if (isEmpty()) {
             head = tail = newNode;
            index++;
        
        }else{ //this code if there are multiple elements

            head.prev = newNode;
         newNode.next = head;
            head = newNode;
            index++;
            
        }
    }

    public void insertLast(Object val){
        ListNode newNode = new ListNode(val);

        if (isEmpty()) {
            tail = head = newNode;
            index++;
        }else if (tail.prev == null) { //only one element in the list 
            
            head.next = newNode;
            newNode.prev = head;
           
        }else{
            tail.next = newNode;
            newNode.prev = tail;
        }

        tail = newNode;

    }

    public void insertatPos(LinkedList list, int pos, Object val){

       
        ListNode newNode = new ListNode(val);
        if (pos == 0) {
            insertFirst(val);
        } else {
            ListNode currNode = list.head; //starting from the first node to iterate from the begining
           
            for (int i = 0; i < pos-1; i++) {
                currNode = currNode.next;
                 }
             newNode.next = currNode.next;
             newNode.prev = currNode.prev;
             index++;

        }
    
    }

    public void removeFirst(){

        if (isEmpty()) {
            throw new NullPointerException("No data to delete as the list is empty!");
        }else if (head.next == null) {
            
            head = null;
        }else{
            head.next.prev = null;
            head = head.next;
           
        }
    }

    public void removeLast(){

        if (tail == null) {
            throw new NullPointerException("No data to delete as the list is empty!");
        }else if (tail.prev == null) {
            
            head = tail = null;
        }else{
            tail.prev.next = null;
            tail = tail.prev;
        }
    }

    public void peekFirst(LinkedList list){
        System.out.println(list.head.val);

    }

    public void peekLast(LinkedList list){
        System.out.println(list.tail.val);

    }

    public void display(){

        ListNode current = head;
       if (head == null) {
        System.out.println("List is empty!");
       }

       while (current != null) {
        System.out.println(current.val + " ");
        current = current.next;
       }

    }

    public boolean find(Object data){

        ListNode currNode = head;
        boolean present = false;
        int pos = 0;
        while (currNode!= null) {
            if (currNode.val == data) {
                System.out.println("Data found at index - " + pos);
               return true;
            }
            currNode = currNode.next;
            pos++;
}

return false;
    }

    public void search(Object key){

        if (find(key)) {
           
        }else{
            System.out.println("data not found!");
        }
    }

    public static void main(String[] args) {
        LinkedList  list = new LinkedList();

        list.insertFirst(10);
        list.insertFirst(20);
        list.insertFirst(30);
        list.insertFirst("jawagar");

        list.display();
System.out.println(" ");
      

       list.peekFirst(list);
       list.peekLast(list);
       list.search(25);
    }
}
