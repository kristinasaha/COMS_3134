import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem2 {
		private static Scanner scanner;
	
	public static void main(String[] args) throws FileNotFoundException
	{
		
		//create a string AvlTree
		AvlTree<String> myAvlTree = new AvlTree<String>();
		
		Integer count = 0;
		String tempString;
		
		scanner = new Scanner(new File("frank.txt"));

		while(scanner.hasNextLine()){
			count++;
			tempString = null;
			tempString = scanner.nextLine();
			String tempStringLowerCase = tempString.toLowerCase();
			String[] words =  tempStringLowerCase.split("\\s+");
			
			for(int x = 0; x < words.length; x++)
			{
				String tempStringFromArray = words[x];
				String tempStringNoPunctuation = tempStringFromArray.replaceAll("[^A-Za-z0-9]", "");
				if(!tempStringNoPunctuation.equals(""))
				{
					myAvlTree.insert(tempStringNoPunctuation);
				}
			}
		}
		
		myAvlTree.printTree();
	}
}