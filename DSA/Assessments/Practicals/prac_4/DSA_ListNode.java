import java.io.Serializable;

public class DSA_ListNode implements Serializable{
    Object value; //variable to hold data in the node
    DSA_ListNode prev;//reference variable to hold previous link in the node
    DSA_ListNode next;//reference variable to hold next link in the node

    DSA_ListNode(Object value){
        this.value = value;
        prev = null;
        next = null;
    }

    public Object getValue()
    {
        return value;
    }

    public void setValue(Object inValue)
    {
        value = inValue;
    }

    public DSA_ListNode getNext()
    {
        return next;
    }

    public void setNext(DSA_ListNode inNext)
    {
        next = inNext;
    }

    public DSA_ListNode getPrev()
    {
        return prev;
    }

    public void setPrev(DSA_ListNode inPrev)
    {
        prev = inPrev;
    }

    public void displayLink() { 
        System.out.print(value + " "); 
        System.out.print(" ");}
}
