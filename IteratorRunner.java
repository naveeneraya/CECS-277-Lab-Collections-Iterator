/**
 * 
 */
package cecs277labcollections;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Naveene Raya Carlos Alvarenga
 * @date 10/28/2019
 *
 */
public class IteratorRunner {


	public static void main(String[] args) {
		Map<String, Integer> pAndPMap = new TreeMap<>();
		PrintWriter out = null;
		try {
		  out = new PrintWriter("console.txt");
		} catch (FileNotFoundException e1) {
			System.out.println(e1.getMessage());
			e1.printStackTrace();
		}
		
		File fin = new File("Pride and Prejudice.txt");
		Scanner in = null;
		
		try {
			in = new Scanner(fin);   // attempting to open file path
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		while (in.hasNextLine()) {    // start of looping through file
			String line;					//The current line of the ASCII text file
			line = in.nextLine();
			Scanner thisLine = new Scanner(line);
			while(thisLine.hasNext()) {
				String word = thisLine.next().toLowerCase().replaceAll("[^a-z]","");
				if(!pAndPMap.containsKey(word))
					pAndPMap.put(word, 1);
				else
					pAndPMap.put(word, pAndPMap.get(word)+1);
			}
			thisLine.close();
		}

		Iterator<String> it = pAndPMap.keySet().iterator();
		while(it.hasNext()) {
			String tempWord = it.next();
			System.out.println(tempWord + "\t" + pAndPMap.get(tempWord));
			out.println(tempWord + "\t" + pAndPMap.get(tempWord));
		}

		out.close();
		in.close();
	}
}
