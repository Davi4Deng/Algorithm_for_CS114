
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/* Determine length of longest word in words.txt */

public class Starter {

        public static ArrayList<String> wordList;

	public static void main(String[] args) throws FileNotFoundException
   {
		wordList = new ArrayList<String>();
		File file = new File("words.txt"); // Use this on your machine.
		//File file = new File("../resource/asnlib/public/words.txt");

		int maxWordLength = 0;

		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()) 
                {
                    String line = scanner.next();
                    wordList.add(line);
                    int n = line.length();
                    if(n>maxWordLength) maxWordLength = n;
                }
			    scanner.close();
		    } catch (FileNotFoundException e) 
                {
                    e.printStackTrace();
                }
            System.out.println("Max length = "+maxWordLength);
        
        
            Scanner input = new Scanner(System.in);
            System.out.print("Enter a string of lower-case letters: ");
            String word = input.next();

            String result = extractWords(word);
            if (result == null) 
                {
                    System.out.println("null");
                } 
            else {
                    System.out.println(result);
                 }
	}
    public static String extractWords(String word) 
    {
    int length = word.length();
    for (int i = 1; i <= length; i++) 
    {
		String prefix = word.substring(0, i);
		if (Collections.binarySearch(wordList, prefix) >= 0) 
      {
			String suffix = word.substring(i);
			String subResult = extractWords(suffix);
			if (subResult != null) 
         {
				return prefix + " " + subResult;
			}
		}
   }
	if (Collections.binarySearch(wordList, word) >= 0) 
   {
		return word;
	} 
   else 
   {
		return null;
	}
}
}
