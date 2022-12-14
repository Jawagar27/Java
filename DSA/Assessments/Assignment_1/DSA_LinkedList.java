
import java.util.*;
import java.lang.UnsupportedOperationException;
public class DSA_LinkedList implements Iterable{
/* Comp 1002 Assignment 1
     * Author - Jawagar Prabaharan
     * Curtin id - 20944793
     * LinkedList code */
    DSAListNode head;
    DSAListNode tail;

    public DSA_LinkedList()
    {
        head = null;
        tail = null;
    }

    public void insertFirst(Object newValue)
    {
        DSAListNode newNode = new DSAListNode(newValue);
        if (isEmpty())
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            newNode.setNext(head);
            head = newNode;
        }
    }

    public void insertLast(Object newValue)
    {
        DSAListNode currNode;
        DSAListNode newNode = new DSAListNode(newValue);
        if (isEmpty())
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            currNode = head;
            while (currNode.getNext() != null)
            {
                currNode = currNode.getNext();
            }
            tail = newNode;
            currNode.setNext(newNode);
            newNode.setPrev(currNode);
        }
    }

    public boolean isEmpty()
    {
        boolean returnVal;
        if (head == null)
        {
            returnVal = true;
        }
        else
        {
            returnVal = false;
        }
        return returnVal;
    }

    public Object peekFirst()
    {
        Object returnVal = null;
        if (isEmpty() == false)
        {
            returnVal = head.getValue();
        }
        return returnVal;
    }
    public Object peekLast()
    {
        DSAListNode currNode;
        Object returnVal = null;
        if (isEmpty() == false)
        {
            returnVal = tail.getValue();
        }
        return returnVal;
    }

    public Object removeFirst() throws Exception
    {
        Object nodeValue = null;
        if (isEmpty() == false)
        {
            nodeValue = head.getValue();
            head = head.getNext();
        }
        else
        {
            throw new Exception("No more items!");
        }
        return nodeValue;
    }

    public Object removeLast()
    {
        Object nodeValue = null;
        DSAListNode currNode;
        DSAListNode prevNode;
        if (isEmpty() == false)
        {
            if (head.getNext() == null)
            {
                nodeValue = head.getValue();
                head = null;
                tail = null;
            }
            else
            {
                prevNode = null;
                currNode = head;
                while (currNode.getNext() != null )
                {
                    prevNode = currNode;
                    currNode = currNode.getNext();
                }
                tail = prevNode;
                prevNode.setNext(null);
                nodeValue = currNode.getValue();
            }
        }
        return nodeValue;
    }

    public Iterator iterator()
    {
        return new MyLinkedListIterator(this);
    }

    private class MyLinkedListIterator implements Iterator
    {
        private DSAListNode iterNext;

        public  MyLinkedListIterator(DSA_LinkedList theList)
        {
            iterNext = theList.head;
        }

        public boolean hasNext()
        {
            return (iterNext != null);
        }

        public Object next()
        {
            Object value;
            if (iterNext == null)
            {
                value = null;
            }
            else
            {
                value = iterNext.getValue();
                iterNext = iterNext.getNext();
            }
            return value;
        }

        public void remove()
        {
            throw new UnsupportedOperationException("Not supported");
        }
    }

    public Integer getLength()
    {
        Integer count = 0;
        DSAListNode currNode = head;

        if (currNode != null)
        {
            count = count + 1;

            while (currNode.getNext() != null)
            {
                count = count + 1;
                currNode = currNode.getNext();
            }
        }
        return count;
    }
}

