package com.nagarro;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.nagarro.dao.Dao;
import com.nagarro.model.Tshirt;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

public class CSVDataLoad {
	Dao d = new Dao();

	public void loadData(File[] files) throws CsvValidationException, NumberFormatException, IOException {
		for (File file : files) {
			CSVParser parser = new CSVParserBuilder().withSeparator('|').build();
			CSVReader reader = new CSVReaderBuilder(new FileReader(file)).withCSVParser(parser).withSkipLines(1)
					.build();
			String[] nextLine;

			// adding
			while ((nextLine = reader.readNext()) != null) {
				Tshirt currTShirt = new Tshirt();
				currTShirt.setId(nextLine[0]);
				currTShirt.setName(nextLine[1]);
				currTShirt.setColour(nextLine[2]);
				currTShirt.setGenderRecommendation(nextLine[3]);
				currTShirt.setSize(nextLine[4]);
				currTShirt.setPrice(Float.parseFloat(nextLine[5]));
				currTShirt.setRating(Float.parseFloat(nextLine[6]));
				currTShirt.setAvailability(nextLine[7]);
				d.insertTshirt(currTShirt);
			}
		}

	}
}