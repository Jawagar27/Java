public class DSA_Queue {
    
    DSA_LinkedList list;

    public void enqueue(Object value){

        list.insertatlast(value);
    }

    public void DSA_Queue(){

        list.deletefirst();
    }

    public void display(){

        list.displaylist();
    }

    public static void main(String[] args) {
        DSA_Queue queue = new DSA_Queue();
        queue.enqueue(20);
        queue.display();
    }
}
