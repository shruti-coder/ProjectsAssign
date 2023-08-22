package com.training.nagarro;
	import java.util.Scanner;
	public class QueueMain {
			public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			int ch;
			int item;
			Queue queue=new Queue();//object of Queue class
			while(true) {
				System.out.println("1.enqueue");
				System.out.println("2.dequeue");
				System.out.println("3.peek");
				System.out.println("4.contains");
				System.out.println("5.size");
				System.out.println("6.reverse");
				System.out.println("7.traverse");
				System.out.println("8.Center");
				System.out.println("0. Quit");
				
				
				System.out.println("Enter your choice");
				ch=sc.nextInt();
				switch(ch) {
				case 1: System.out.println("Enter element to add");
				        item=sc.nextInt();
				        queue.enQueue(item);
				break;
				case 2: System.out.println("The deleted item is " + queue.deQueue());
				break;
				case 3: System.out.println("The peek item is " + queue.peek());
				break;
				case 4: queue.cointains();
				break;
				case 5:System.out.println("The size of queue is " + queue.size());
				break;
			/*	case 6:queue.reverse();
				break;*/
				case 7:queue.traverse();
				break;
				case 8:queue.center();
				break;
				case 0:System.exit(1);
				default:System.out.println("invalid choice");
				
				}//switch
			}//while
		}//main
	}//class
