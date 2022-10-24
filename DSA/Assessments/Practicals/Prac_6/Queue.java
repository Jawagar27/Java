public class Queue {
    /* Comp 1002 Assignment 1
     * Author - Jawagar Prabaharan
     * Curtin id - 20944793
     * Queue code */
    private DSA_LinkedList DSAQueue = new DSA_LinkedList();

    public void enqueue(Object pVal)
    {
        DSAQueue.insertLast(pVal);
    }

    public Object dequeue()
    {
        Object returnVal = null;
        try
        {
            DSAQueue.peekFirst();
            returnVal = DSAQueue.removeFirst();
        }
        catch (Exception e)
        {
            returnVal = "Nothing to dequeue!";
        }
        return returnVal;
    }

    public boolean isEmpty()
    {
        boolean result = false;
        if (DSAQueue.isEmpty())
        {
            result = true;
        }
        return result;
    }
}
