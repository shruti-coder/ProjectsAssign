package com.main.util;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.main.Tshirt;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class CSVData {
	private final File[] files;
	private final Tshirt tshirt;
	private final String sortingOrder;
	
	List<Tshirt> tshirtData=new ArrayList<>();
	
	public CSVData(Tshirt tshirt, String sortingOrder) {
		this.files =  new File("C:\\Users\\shrutiagarwal02\\eclipse-workspace\\AdvanceJava\\src\\resources").listFiles(obj -> obj.isFile() && obj.getName().endsWith("csv"));;
		this.tshirt = tshirt;
		this.sortingOrder = sortingOrder;
	}

		public void findData() {
			try {
				// de-structuring user input
				String tshirtColour = tshirt.getColour();
				String tshirtGender = tshirt.getGenderRecommendation();
				String tshirtSize = tshirt.getSize();

				// getting filtered data across all csv files in resource
				for (File file : files) {
					CSVParser parser = new CSVParserBuilder().withSeparator('|').build();
					CSVReader reader = new CSVReaderBuilder(new FileReader(file)).withCSVParser(parser).withSkipLines(1)
							.build();
					String[] nextLine;

				 // adding 
					while ((nextLine = reader.readNext()) != null) {
						if (tshirtColour.equalsIgnoreCase(nextLine[2]) && tshirtGender.equalsIgnoreCase(nextLine[3])
								&& tshirtSize.equalsIgnoreCase(nextLine[4])) {
							Tshirt currTShirt = new Tshirt();
							currTShirt.setId(nextLine[0]);
							currTShirt.setName(nextLine[1]);
							currTShirt.setColour(nextLine[2]);
							currTShirt.setGenderRecommendation(nextLine[3]);
							currTShirt.setSize(nextLine[4]);
							currTShirt.setPrice(Float.parseFloat(nextLine[5]));
							currTShirt.setRating(Float.parseFloat(nextLine[6]));
							currTShirt.setAvailability(nextLine[7]);
							
							tshirtData.add(currTShirt);
						}
					}
				}
			} catch (Exception e) {
				System.out.println("Invalid Data");
			
		}
	}
		public void printData() {
			if (!tshirtData.isEmpty()) {
				sortedTshirts(tshirtData,sortingOrder).forEach(t -> {				
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
			} else {
				System.out.println("No Match Found");
			}
		}
		
		public List<Tshirt> sortedTshirts(List<Tshirt> tshirtList,String outputPreference) {
			List<Tshirt> sortedList;
			switch (outputPreference.toLowerCase()) {

			// sorting based on rating
			case "rating":
				sortedList = tshirtList.stream().sorted(Comparator.comparingDouble(Tshirt::getRating).reversed())
						.collect(Collectors.toList()); // (TShirt t)->t.getRating()
				break;
			// sorting based on price
			case "price":
				sortedList = tshirtList.stream().sorted(Comparator.comparingDouble(Tshirt::getPrice))
						.collect(Collectors.toList());
				break;
			// sorting based on both
			case "both":
				sortedList = tshirtList.stream().sorted(Comparator.comparingDouble(Tshirt::getRating).reversed())
						.collect(Collectors.toList());
				break;
			default:
				sortedList = tshirtList;
				break;
			}
			return sortedList;
		}
}

