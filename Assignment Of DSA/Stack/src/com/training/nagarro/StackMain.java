package com.training.nagarro;
	import java.util.Scanner;
	public class StackMain {
		public static void main(String[] args) {
			Scanner scn=new Scanner(System.in);
			int ch;
			int item;
			Stack stack=new Stack();//Object of stack class
			while(true) {
				System.out.println("1.push");
				System.out.println("2.pop");
				System.out.println("3.peek");
				System.out.println("4.contains");
				System.out.println("5.size");
				System.out.println("6.reverse");
				System.out.println("7.traverse");
				System.out.println("8.Center");
				System.out.println("0. Quit");
				
				
				System.out.println("Enter your choice");
				ch=scn.nextInt();
				switch(ch) {
				case 1: System.out.println("Enter element to push");
				        item=scn.nextInt();
				        stack.push(item);
				break;
				case 2: System.out.println("The pop item is " +stack.pop());
				break;
				case 3: System.out.println("The peek item is " +stack.peek());
				break;
				case 4: stack.cointains();
				break;
				case 5:System.out.println("The size of stack is " +stack.size());
				break;
				case 6:stack.reverse();
				break;
				case 7:stack.traverse();
				break;
				case 8:stack.center();
				break;
				case 0:System.exit(1);
				default:System.out.println("Invalid choice");
				
				}//switch
			}//while
			

		}//main

	}//class

