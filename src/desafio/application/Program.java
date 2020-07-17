package desafio.application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import desafio.entities.Product;

public class Program {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		System.out.println("Enter file path: ");
		String sourceFileStr = sc.nextLine();
		
		File sourceFile = new File(sourceFileStr);
		String sourceFolderStr = sourceFile.getParent();
		
		boolean success = new File(sourceFolderStr + "\\out").mkdir();
		
		String targetFileStr = sourceFileStr + "\\out\\summary.csv";
		
		try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {
			
			String itemcsv = br.readLine();
			while (itemcsv != null) {
				String[] fileds = itemcsv.split(",");
				String name = fileds[0];
				double price = Double.parseDouble(fileds[1]);
				int quantity = Integer.parseInt(fileds[2]);
				
				list.add(new Product(name, price, quantity));
				itemcsv = br.readLine();
				
				
			}
				try(BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {
					
						for (Product item : list) {
							bw.write(item.getName() + "," + String.format("%.2f", item.total()));
							bw.newLine();
						}
						
						System.out.println("CREATED");
						
				}
				catch (IOException e) {
					System.out.println("Error writing file: " + e.getMessage());
				}
			
		}
			
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
				sc.close();
	}
}
