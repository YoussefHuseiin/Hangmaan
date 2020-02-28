package eg.edu.alexu.csd.datastructure.hangman.cs18012118;

import java.util.Scanner;

public class HangmanTest {
public static void main (String[] args) {
	Hangman test = new Hangman();
	test.setMaxWrongGuesses(15);
	String s = test.selectRandomSecretWord();
	Scanner ts = new Scanner(System.in);
	String x="";
	while(x!=null) {
		System.out.println("The character is :");
		char v = ts.next().charAt(0);
		try {
			x=test.guess(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println(x);
	} 
}
}
