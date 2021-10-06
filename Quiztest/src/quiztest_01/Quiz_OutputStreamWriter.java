package quiztest_01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Quiz_OutputStreamWriter {
	
	public static void main(String[] args) {
		File file = new File("src/quiztest_01/quiz.txt");
		Scanner scan = new Scanner(System.in);
		
		try(OutputStreamWriter otr = new OutputStreamWriter(new FileOutputStream(file))){
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
