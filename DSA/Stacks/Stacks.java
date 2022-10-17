import java.util.*;
public class Stack {

	int n = 5;
	int Stack[] = new int[n];
	int top = -1;
	Scanner input = new Scanner(System.in);
	
	
	
	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int[] getStack() {
		return Stack;
	}

	public void setStack(int[] stack) {
		Stack = stack;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public Scanner getInput() {
		return input;
	}

	public void setInput(Scanner input) {
		this.input = input;
	}

	
	public Stack() {
			
	}
	
	
	public Stack(int n, int[] stack, int top, Scanner input) {
		super();
		this.n = n;
		Stack = stack;
		this.top = top;
		this.input = input;
	}

	public void push() {
	
		int x;
		for(int i = 0; i<= 4; i++) {
			System.out.println("Please enter the data: ");
			x= input.nextInt();
			
			if(top == n-1) {
				System.out.println("Stackoverflow");
			}else {
				top++;
				Stack[top] = x;
			}
			
		}
		
		
	}
	
	public void pop() {
	//code to delete the last entered element
		int item; //to display variable
		
		if(top == -1) {
			System.out.println("Stack underflow");
		}else {
			item = Stack[top];
			top--;
			System.out.println(item);
			
			}
	}

	public void peek() {
	//this piece of code is to print the value in top of the stack
		if(top == -1) {
			
		}else {
			System.out.println(Stack[top]);
		}
	}

	public void display() {
	//this piece of code is to print the values in the stack
		for(int i = top ; i>= 0; i--) {
			 int x = Stack[i];
			 System.out.println("Data sotred in stack index " +i+ " is: " + x);
		}
	}
}
