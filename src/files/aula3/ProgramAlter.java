package files.aula3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ProgramAlter {
	public static void main(String[] args) {

		//String [] lines = new String[] {"Good morning","Good afternoom","Good night"};
		String path = "c:\\temp\\out.txt";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("escreva um txt: ");
		String txt = sc.nextLine();
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
				bw.write(txt);
				bw.newLine();
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
