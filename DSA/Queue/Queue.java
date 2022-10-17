import java.util.*;
public class Queue {

	int n = 6;
	int front = -1;
	int rear = -1;
	int[] queue = new int [n];
	
	
	//default constructor
	Queue() {
		
	}
	//parameter constructor
	public Queue(int n, int front, int rear, int[] queue) {
		
		this.n = n;
		this.front = front;
		this.rear = rear;
		this.queue = queue;
	}

	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public int getFront() {
		return front;
	}
	public void setFront(int front) {
		this.front = front;
	}
	public int getRear() {
		return rear;
	}
	public void setRear(int rear) {
		this.rear = rear;
	}
	public int[] getQueue() {
		return queue;
	}
	public void setQueue(int[] queue) {
		this.queue = queue;
	}
	
	public void enqueue(int n) { // code for insertion of data
		
		if(rear == 5) { //if the input side the rear side is equal to the array size then no space for the input
			System.out.println("Stack overflow");
		}else if(rear == -1 && front == -1) { //if both the write and the delete head are the initial value then make it 0(1st index)
			
			rear = front = 0;
			queue[rear] = n;
		}else {// if the index is not full or is just -1 then increment and make the queue 
			rear++;
			queue[rear] = n;
			
		}
	}
	
	public void dequeue() {
		
		if(rear == -1 && front ==-1) { 
									   
		}else if(front == rear) { //if both indexes are equal
			//it is the end of data thereby no more data can be deleted so thereby values are set to -1
			rear = front = -1;
		}else { //increment and move to the next index by making the previous value garbage
			
			front++;
		}
	}
	
	public void peek() {
		
		System.out.println(queue[rear]);
		
	}

	public void display() {
		int x;
		if(front == -1 && rear == -1) {
			
		}else {
			for(int i = front; i< rear + 1; i++) {
			x = queue[i];
				System.out.println("The value on index " +i+ " is: " + x);
			}
		}
	
	}

}
