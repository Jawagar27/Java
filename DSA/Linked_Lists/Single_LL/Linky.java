import java.util.*;
public class Linky {

	Node head;
	
	public Linky() {
		
		this.head = null;
	}

	public void insertatbegining( int a) {
		//each time this function is called a new node is created
		Node node = new Node(a); //new node
	
		
		if(isempty()) { //list is already empty and the first element is entered
			head = node; 
		}else { //when there already are elements in the linked list
			 node.next = head;
			 head = node;
		}
		
	}
	
	public void insertatposition(int pos, int value) {
		if(pos == 0) {//if position is 0 then it will insert the value at the begining
			insertatbegining(value);
			return;
		}
		//orelse
		Node newnode = new Node(value); //value is passed onto the new node created
		Node currnode = head; //a new reference variable is created
		
							  //linking it to the first variable
		for(int i = 0; i<pos -1; i++) {
			currnode = currnode.next; //this will increment the location reference variable until position is reached
		}
		newnode.next = currnode.next; //newnodes reference is linked to the current nodes reference
		currnode.next = newnode;
	}
	
	public void deleteatpos(int pos) {
		Node currnode = head;
		Node prevnode = null;
		
		if(pos == 0) {
			head = head.next;
			return;
		}
		
		for(int i = 0; i<pos; i++) {
		
			prevnode = currnode;
			currnode = currnode.next;//currnode is the node we r gonna delete
		
		}
		
		prevnode.next = currnode.next; //we link the next of the deleting node
		//as the next of the current node
		
		
	}
	
	
	public void printList(Linky list) {
		
		Node currnode = list.head;
		System.out.println("LinkedList: ");
		
		//display the elements in the linked list
		
		while(currnode != null) {
			//print data at the current node
			System.out.print(currnode.data + " ");
			
			//go to the next node;
			currnode = currnode.next;
		}
	}
	
	public void deletefirst() {
		 if(head == null){
	            throw new NullPointerException("The linked list is empty nothing to delete here!");
	        }
		 
		 head = head.next;
		
	}
	
	public boolean isempty() {
		boolean empty = true;
		empty = head == null;
		return empty;
	}
	}
