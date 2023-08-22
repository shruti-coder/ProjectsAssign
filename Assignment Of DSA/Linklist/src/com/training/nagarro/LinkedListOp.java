package com.training.nagarro;
class LinkedListOp {
	//Set the Head Node
	Node head;
	
	// Method to insert an element in Linked List
	void insert(int item) {
		// Create a new node
		Node newNode = new Node(item);
		
		// check if linked list is empty
		if (head == null) {
			// if linked list is empty, set the head to the new node
			head = newNode;
		}else {
			Node n = head;
			
			// if linked list is not empty, iterate through the last
			//element of linked list
			while(n.next != null) {
				n = n.next;
			}
			// set the last element of linked list to the new node
			n.next = newNode;
		}
	}
	
	// Method to insert at a specific position of linked list
	void insertAtPosition(int item, int p) {
		// initiate a pointer node to the head node of linked list
		Node n = head;
		// Create a new node
		Node newNode = new Node(item);
		// check if entered position is a valid position in linked list
		if(p < 1 || p > size()+1) {
			System.out.println("\nInvalid Position.\n");
			return;
		}

		int curPos = 1;
		
		// iterate to one less than the entered position of linked list
		while(curPos != p-1) {
			n = n.next;
			curPos++;
		}
		//set the new node next to node next, 
		// than set node next to the new Node
		newNode.next = n.next;
		n.next = newNode;
	}
	
	//Method to delete an item from a linked list
	void delete(int item) {
		// initiate a pointer node to the head node
		Node n = head;
		//check if head is equal to the entered item,
		// if so, change the head position to the next element
		if(n.data == item) {
			head = n.next;
			System.out.println(item + " is Deleted from Linked List.");
			return;
		}
		
		// iterate to the one short of last element of linked list
		while(n.next != null) {
			// check if the next node is equal to the item,
			// if so, set the current node to next of next node element
			if(n.next.data == item) {
				n.next = n.next.next;
				System.out.println(item + " is Deleted from Linked List.");
				return;
			}
			
			n = n.next;
		}
		
		System.out.println(item + " does not exists in Linked List.");
	}
	
	// Method to delete node at a specific position
	void deleteAtPosition(int p) {
		//Check if the entered position exists in the linked list
		if(p < 1 || p > size()) {
			System.out.println("\nInvalid Position\n");
			return;
		}
		
		// check if the entered position is of head
		if(p == 1) {
			System.out.println(head.data + " is deleted from the linked list.");
			head = head.next;
			return;
		}
		
		// Initiate a pointer node, and a counter integer
		Node n = head;
		int count = 1;
		// Iterate to the one sort of entered position
		while(count != p-1) {
			n = n.next;
			count++;
		}
		
		System.out.println(n.next.data + " is deleted from the linked list.");
		
		// check if the next of next of current node exists in the linked list,
		// if so, change the current node next to next of next node,
		// otherwise change to current node next to the null
		if(n.next.next != null) {
			n.next = n.next.next;
		}else {
			n.next = null;
		}
	}
	
	// Method to return the center element of linked list
	int center() {
		// initialize a counter variable to 1
		int count = 1;
		// initialize a pointer node with head node
		Node n = head;
		// iterate to the middle of linked list
		while(count != ((size()/2)+1)) {
			n = n.next;
			count++;
		}
		
		// return middle node
		return n.data;
	}

	// Method to reverse a linked list
	void reverse() {
		// Initiate pointer node to head, 
		// nextNode to null, & prevNode to null
		Node n = head;
		Node nextNode = null;
		Node prevNode = null;
		
		// Iterate through the end of linked list
		while(n != null) {
			// set nextNode pointer to the next node of current node
			nextNode = n.next;
			
			// set current node next to previous node
			n.next = prevNode;
			// set previous node to current node
			prevNode = n;
			// set current node pointer to the next node
			n = nextNode;
		}
		// set head to the previous node
		head = prevNode;
		
		System.out.println("\nLinked List is successfully reversed\n");
	}
	
	// Method to return the size of linked list
	int size() {
		// initialize node pointer to head,
		// and counter variable to 0
		Node n = head;
		int count = 0;
		
		// iterate to the end of linked list
		while(n != null) {
			count++;
			n = n.next;
		}
		// return the size of linked list
		return count;
	}
	
	// Method to iterate through a linked list
//	int iterator() {
//		ListIterator li = new ListIterator();
//		
//		if(li.hasNext()) {
//			return li.next();
//		}
//		
//		return -1;
//	}
//	
//	class ListIterator{
//		Node n = head;
//		
//		boolean hasNext() {
//			return n.next != null;
//		}
//		
//		int next() {
//			int item = -1;
//			
//			if(n != null) {
//				item = n.data;
//				n = n.next;
//			}
//			return item;
//		}
//	}
	
	// Method to Display the linked list
	void traverse() {
		// initialize the pointer node with head node
		Node n = head;
		// iterate to the end of linked list
		while(n != null) {
			// print current node
			System.out.print(n.data);
		
			if(n.next != null)
				System.out.print("->");
			// set the pointer node to next node
			n = n.next;
		}
		
		System.out.println("\n");
	}
}
