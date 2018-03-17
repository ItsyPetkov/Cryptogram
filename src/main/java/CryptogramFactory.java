package main.java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class CryptogramFactory {
    
    public String[] phrase;
    
    public CryptogramFactory(){
        phrase = new String[30];
		RNG();
    }
    
    public int RNG(){
		Random random = new Random();
		int n = random.nextInt(30);
		readPhrasesFromFile(n);
		return n;
	}

	private String readPhrasesFromFile(int sentence) {
		try {
			int j = 0;
			Scanner scanner = null;
			FileReader fr = new FileReader("phrases.txt");
			BufferedReader br = new BufferedReader(fr);
			String input = br.readLine();
			while (input != null) {
				scanner = new Scanner(input);
				String phrase = scanner.nextLine();
				this.phrase[j] = phrase;
				input = br.readLine();
				j++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found!");// alter if needed
		} catch (IOException e) {
			System.out.println("Something went wrong while reading from file!");// alter if needed
		}

		return phrase[sentence];
	}

	public String toString() {
		return phrase[RNG()];
	}
}
