public class ListNode {
    //we are coding a doubleended, doubly linked list that has both next prev and head tail as well

    ListNode prev;
    ListNode next;
    Object val;
    public ListNode getPrev() {
        return prev;
    }
    public void setPrev(ListNode prev) {
        this.prev = prev;
    }
    public ListNode getNext() {
        return next;
    }
    public void setNext(ListNode next) {
        this.next = next;
    }
    public Object getVal() {
        return val;
    }
    public void setVal(Object val) {
        this.val = val;
    }

    public ListNode(){
            //default constructor

    }
    public ListNode(ListNode prev, ListNode next, Object val) {
        this.prev = prev;
        this.next = next;
        this.val = val;
    }

    public ListNode(Object value){

        this.val = value;    }

    
}
