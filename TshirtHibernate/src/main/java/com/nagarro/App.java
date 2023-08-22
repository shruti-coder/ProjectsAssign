package com.nagarro;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import com.nagarro.dao.Dao;
import com.nagarro.model.Tshirt;

public class App {
	public static void main(String[] args) throws InterruptedException {
		
//		Declaration
		CSVDataLoad csv = new CSVDataLoad();
		StringBuilder outputPrefernces=new StringBuilder();
		Tshirt tshirt=new Tshirt();
		Dao dao=new Dao();
		
		
		try (Scanner in = new Scanner (System.in)) {
			Thread loadData = new Thread(() -> {
				File[] files = new File("C:\\Users\\shrutiagarwal02\\eclipse-workspace\\AdvanceJava\\src\\resources")
						.listFiles(obj -> obj.isFile() && obj.getName().endsWith("csv"));
				try {
					csv.loadData(files);
				} catch (Exception e) {
					e.printStackTrace();
				} 

			});
			Thread inputData=new Thread(()->{
				System.out.println("Enter Color");
				tshirt.setColour(in.next());
				System.out.println("Enter Size");
				tshirt.setSize(in.next().toUpperCase());
				System.out.println("Enter genderrecommendation");
				tshirt.setGenderRecommendation(in.next().toUpperCase());
				System.out.println("Enter OutputPreferences(Price,Rating or both) ");
				outputPrefernces.append(in.next());
				System.out.println(tshirt);
			});
			Thread findTshirt=new Thread(()->{
//				System.out.println(tshirt);
				List<Tshirt> tshirts=dao.getTshirt(tshirt, outputPrefernces.toString());
			tshirts.forEach(t -> {				
				System.out.println("\n__________T-Shirt__________");
				System.out.println("Id: " + t.getId());
				System.out.println("Name: " + t.getName());
				System.out.println("Color: " + t.getColour());
				System.out.println("Gender: " + t.getGenderRecommendation());
				System.out.println("Size: " + t.getSize());
				System.out.println("Price: " + t.getPrice());
				System.out.println("Rating: " + t.getRating());
				System.out.println("Availability: " + t.getAvailability());
			});
			});
			

			loadData.start();
			loadData.join();
			inputData.start();
			inputData.join();
			findTshirt.start();
		}
	}
}
