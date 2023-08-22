package com.training;
//	import java.util.Scanner;
	class Task
	{
	 String job;
	 int priority;

	 public Task(String job, int priority)
	 {
	     this.job = job;
	     this.priority = priority; 
	 }

	 public String toString() 
	 {
	     return "Job Name : "+ job +"\nPriority : "+ priority;
	 }
	}