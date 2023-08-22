package com.training.nagarro;
public class Stack {
	int stack[] =new int[5];//stack of 5 element
	int top=-1;
	int size=5;
	
	
	public void push(int data) {
		if(!isFull()) {
			top++;
			stack[top]=data;
			
			System.out.println("[" +data +"] pushed sucessfully");
			
		}else {
			System.out.println("stack is full");

		}
	}//push
	
	public int pop() {
		if(!isEmpty()) {
			int data=stack[top];
			top--;
			stack[top]=0;
			return data;
			
		}else {
			System.out.println("There is nothing in the stack");
			return 0;
	
		}
	}//pop
	public int peek() {
		int data=stack[top-1];
		return data;
	}//peek
	public void cointains() {
		for(int i: stack) {
			System.out.print("The Stack contains elements are : "+ i + " ");
		}
	}//contains
	public int size() {
		return top+1;
	}//size
	public boolean isEmpty() {
		return (top==-1);
	}//isEmpty
	public boolean isFull() {
		return (size-1==top);
	}//isFull
	public void insertAtBottom(int item) {
		if(isEmpty()) {
			push(item);
		}else {
			int top=pop();
			insertAtBottom(item);
			push(top);
		}
	}
	public void reverse() {
		if(!isEmpty()) {
			int top=pop();
			reverse();
			insertAtBottom(top);
		}
	}
	
	public void traverse() {
		if(!isEmpty()) {
			for(int i=top;i>=0;i--) {
				System.out.print(stack[i] +" ");
				
			}
			System.out.println();
		}
	
	}//traverse
	public void center() {
		System.out.println("The center element is: " +stack[size()/2]);
		
	}//center


}//class