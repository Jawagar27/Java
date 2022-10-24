public class DSA_Stack {
    
    DSA_LinkedList list;

    public void push(Object value){

        list.insertatbeggining(value);
    }

    public void pop(){
        list.deletelast();
    }

    public void display(){
        list.displaylist();
    }
}
