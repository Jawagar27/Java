import java.util.*;
public class DSA_CircularQueue {
    
    Object[] circular; //object array to use for the queue
    int front = -1;
	int rear = -1;
    int index;
    int size;

    public DSA_CircularQueue(int psize){

        size = psize;
        circular = new Object[size];

    }
    
    public  void enqueue(Object val) {
        if (front == -1) {
            front = 0;
            rear = 0;
            circular[front] = val;
        }else if (rear == circular.length-1) {
            
            System.out.println("Queue is full");
        }else{
            rear++;
            circular[rear] = val;
        }
      index++;
    }

    public void dequeue() {
        
        if (rear == -1) {
            System.out.println("Nothing to dequeue, this queue is empty!");
        }else{
            for (int x = front + 1; x <= rear; x++)
            {
                circular[x-1] = circular[x];
            }
            rear = rear -1;
            index--;  
        }
    }

    public void display(){

        for (int i = 0; i < index; i++) {
            System.out.println(circular[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println("Testing the circular queue");
        DSA_CircularQueue cQueue = new DSA_CircularQueue(6);

        cQueue.enqueue(30);
        cQueue.enqueue(20);
        cQueue.enqueue(25);
        cQueue.enqueue(245);
        cQueue.enqueue(27);
        cQueue.enqueue(6);
        cQueue.display();
    System.out.println(" ");
    System.out.println("Output after a dequeue function call");
        cQueue.dequeue();
        cQueue.display();
    }
}

