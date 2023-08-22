import java.util.Scanner;

import com.main.Tshirt;
import com.main.util.CSVData;

public class App {
	public static void main(String[] args) throws InterruptedException {
		Tshirt tshirt = new Tshirt();
		StringBuilder outputPreference = new StringBuilder();
		Thread takeInput = new Thread(() -> {
			try (Scanner sc = new Scanner(System.in)) {
				try {
					System.out.println("Enter Colour of T-Shirt: ");
					tshirt.setColour(sc.next());
					System.out.println("Enter Gender Recommendation of T-Shirt (M,F,U): ");
					tshirt.setGenderRecommendation(sc.next().toUpperCase());
					System.out.println("Enter Size of T-Shirt (S,M,L,XL,XXL): ");
					tshirt.setSize(sc.next().toUpperCase());
					System.out.println("Enter Output Preference (Price,Rating or both): ");
					outputPreference.append(sc.next());
				} catch (IllegalArgumentException e) {
					System.out.println("Invalid Input");
				}
			}
		}, "takeInput");

		takeInput.start();
		takeInput.join();
		CSVData csv = new CSVData(tshirt, outputPreference.toString());
		csv.findData();
		csv.printData();
	}
}

