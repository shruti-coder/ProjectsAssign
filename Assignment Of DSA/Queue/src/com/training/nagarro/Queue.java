package com.training.nagarro;
	public class Queue {
		int queue[]=new int[5];//queue of size 5
		int size=5,front;
		int rear=-1;
		
		
		public void enQueue(int data) {
			if(!isFull()) {
				
			queue[rear]=data;
			rear++;
			}else {
				System.out.println("Queue is full");
			}
			
		}//enqueue
		public void cointains() {
			for(int i=0;i<=rear;i++) {
				System.out.println("The elements of the queue is "+queue[i]);
			}
		}//contains
		public int deQueue() {
			if(!isEmpty()) {
			int data=queue[front];
			front++;
			return data;
			}else {
				System.out.println("Queue id empty");
				return 0; 
			}
		}//deQueue
		public boolean isEmpty() {
			return rear==-1;
		}//isEmpty
		public boolean isFull() {
			return rear==size-1;
		}//isFull
		public int peek() {
			if(isEmpty()) {
				System.out.println("Queue is empty");
				return 0;
			}else {
				return queue[front];
			}
		}//peek
		public int size() {
			return rear+1;
		}//size
		public void center() {
			System.out.println("The center element is " +queue[size()/2]);
		}//center
		public void traverse() {
			if(!isEmpty()) {
				for(int i=size()-1;i>=0;i--) {
					System.out.print(queue[i]+ " ");
					
				}
				System.out.println();
			}
		}//traverse

	}//class
