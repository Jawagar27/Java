

public class DSAListNode {
/* Comp 1002 Assignment 1
     * Author - Jawagar Prabaharan
     * Curtin id - 20944793
     * DSAListNode code*/
    private Object value;
    private DSAListNode next;
    private DSAListNode prev;

    public DSAListNode(Object inValue)
    {
        value = inValue;
        next = null;
        prev = null;
    }

    public Object getValue()
    {
        return value;
    }

    public void setValue(Object inValue)
    {
        value = inValue;
    }

    public DSAListNode getNext()
    {
        return next;
    }

    public void setNext(DSAListNode inNext)
    {
        next = inNext;
    }

    public DSAListNode getPrev()
    {
        return prev;
    }

    public void setPrev(DSAListNode inPrev)
    {
        prev = inPrev;
    }

}
