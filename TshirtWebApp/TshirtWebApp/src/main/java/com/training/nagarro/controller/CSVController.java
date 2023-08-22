package com.training.nagarro.controller;

import java.io.File;
import java.io.FileReader;
import java.util.logging.Logger;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.training.nagarro.model.TShirt;
import com.training.nagarro.service.TShirtService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


/**
 * @author Shruti
 *
 */
@Controller
public class CSVController {
	Logger logger = Logger.getLogger(CSVController.class.getName());
	private final File[] files;
	
	@Autowired
	public TShirtService tshirtService;

	
	public CSVController() {
		String resources="C:\Users\shrutiagarwal02\Desktop\Gitlab\shruti-agarwal\TshirtWebApp\TshirtWebApp\src\main";
		this.files=new File(resources).listFiles(obj->obj.isFile() && obj.getName().endsWith("csv"));
	}
 
	
	/**
	 * @param nextLine
	 * @param currTShirt
	 */
	private void populate(String[] nextLine, TShirt currTShirt) {
		currTShirt.setId(nextLine[0]);
		currTShirt.setName(nextLine[1]);
		currTShirt.setColour(nextLine[2]);
		currTShirt.setGender(nextLine[3]);
		currTShirt.setSize(nextLine[4]);
		currTShirt.setPrice(Float.parseFloat(nextLine[5]));
		currTShirt.setRating(Float.parseFloat(nextLine[6]));
		currTShirt.setAvailability(nextLine[7]);
	}
	/**
	 * loading data into database
	 */
	public void loadData() {
		try {
			// getting filtered data across all csv files in resource
			for (File file : files) {
				CSVParser parser = new CSVParserBuilder().withSeparator('|').build();
				CSVReader reader = new CSVReaderBuilder(new FileReader(file)).withCSVParser(parser).withSkipLines(1)
						.build();
				String[] nextLine;

			 // adding 
				while ((nextLine = reader.readNext()) != null) {
						TShirt currTShirt = new TShirt();
						populate(nextLine, currTShirt);
						this.tshirtService.insertTShirt(currTShirt);
					}
				}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}
}
