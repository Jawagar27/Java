import java.util.*;
public class DSA_Stack {
    
	Object Stack[] = new Object[5];
	int top = -1;
	
	public Object[] getStack() {
		return Stack;
	}

	public void setStack(Object[] stack) {
		Stack = stack;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	
	
	public DSA_Stack() {
			
	}
	
	
	public DSA_Stack(Object[] stack, int top) {
		super();
		Stack = stack;
		this.top = top;
		
	}

	public  void push(Object x) throws IndexOutOfBoundsException{
	
		/*This nethod pushes values into the stack*/
	try {
        if(top == Stack.length-1) {
            throw new IndexOutOfBoundsException("Stack overflow!");
        }else {
            top++;
            Stack[top] = x;
        }
    } catch (IndexOutOfBoundsException e) {
        // TODO: handle exception
        System.out.println("Stack overflow!");
    }		
			
			
}
	
	public void pop() throws NullPointerException{
	//code to delete the last entered element
		Object item; //to display variable
		
		if(top == -1) {
			throw new NullPointerException("Stack underflow!");
		}else {
			item = Stack[top];
			top--;
		
			
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
			Object x = Stack[i];
			 System.out.println("Data sotred in stack index " +i+ " is: " + x);
		}
	}

    public static void main(String[] args) {
        DSA_Stack stack = new DSA_Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(35);
        stack.display();
    }
}
