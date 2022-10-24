public class DSAStack {
    DSA_LinkedList list;

    public void push(Object value){

        list.insertFirst(value);
    }

    public void pop(){
        list.removeLast();
    }

    public boolean isEmpty(){
        boolean empty = false;
        if (list.head == null && list.tail == null) {
            empty = true;
        }else{
            empty = false;
        }

        return empty;
    }
}
