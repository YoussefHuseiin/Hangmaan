package eg.edu.alexu.csd.datastructure.hangman.cs18012118;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Hangman implements IHangman {
	private String [] h =new String[9894];
	private String secretWord;
	private char[] guessingWord;
	private int maxWrong;
	public static String[] readfile() throws IOException {
		File file = new File("C:\\Users\\Jou\\Desktop\\dictionary.txt");
		FileReader dictionary =new FileReader(file);
		BufferedReader br = new BufferedReader(dictionary);
		String[] s = new String[9894];
	    String line ;
		int i=0;
	    while((line = br.readLine()) != null) {
			s[i]=line;i++;
		}
	    br.close();
	    return s;
		
		
	}
	public void setDictionary(String[] words) {
	 h =words;
		
	}
	  public String selectRandomSecretWord() {
		Random text = new Random();
		int n = text.nextInt(9894);
		try {
			h= readfile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  secretWord =h[n];
		  guessingWord= new char [secretWord.length()];
		 for(int i=0;i<secretWord.length();i++) {
			  guessingWord[i]='-'; }
		return h[n];
		
		
	}
	  public String guess(Character c) throws Exception{
		  if((secretWord != null)&&(!secretWord.matches("^[a-zA-Z]*$")&&(!secretWord.equals("")))){
			  throw new Exception("Buggy Word");
		  }
		  
		  if(c==null) {
			  return null;
		  }
			  char array[]=new char[secretWord.length()];
			  secretWord.getChars(0,secretWord.length(),array,0);
			  int v=0;
			  for(int j=0;j<secretWord.length();j++) {
				  if(Character.toLowerCase(c)==Character.toLowerCase(array[j])) {
					  guessingWord[j]=c;
					  v=1;
				  }
			  } if(v==0) {
				  maxWrong--;
			  } if (maxWrong ==0) {
				  return null;
			  }
			  String g="";
			  for(int h=0;h<guessingWord.length;h++) {
				  g+=guessingWord[h];
			  } if(!g.contains("-")) {
				  return null;
			  }
			  return g.toLowerCase();
		  }
	     public void setMaxWrongGuesses(Integer max) {
	   if (max==null || max <=0) {
		   maxWrong =1;
	  }  
	   else maxWrong = max;
	     }
}
	     
  	   

	 


