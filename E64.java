// ****************************************** 
// E64 program 
// written by Kristina Saha 
// Using java for letter recognition.
// *******************************************


import java.util.Scanner; //inserting a new scanner for inputs
public class E64 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Scanner input = new Scanner(System.in); 
		 String words = input.nextLine(); 
		//finds the upper case letters in the input 
		 for (char a: words.toCharArray()){
			 if (Character.isUpperCase(a)){
				 System.out.println(a);
	
	//finds every second letter in input
	String EverySecondLetter = "";
	for (int b =0; b < words.length(); b++) {
		if (b%2 == 1){
			EverySecondLetter += words.charAt(b);
		}
	}
	System.out.print(EverySecondLetter); 
	
	//underscores every vowel in letter 
	String underscore = "";
	underscore=words.replaceAll("[aAeEiIoOuU]", "_");
	System.out.println();
	System.out.println(underscore);
	
	//counts how many vowels there are in the input
	int count = 0;
	for(int i = 0; i < words.length(); i++)
    {
        if(words.charAt(i) == 'a' || words.charAt(i) == 'A')
        {
            count++;
        }
        else if(words.charAt(i) == 'e' || words.charAt(i) == 'E')
        {
            count++;
        }
        else if(words.charAt(i) == 'i' || words.charAt(i) == 'I')
        {
            count++;
        }
        else if(words.charAt(i) == 'o' || words.charAt(i) == 'O')
        {
            count++;
    
        }
        else if(words.charAt(i) == 'u' || words.charAt(i) == 'U')
        {
            count++;
            
        }
        
    }

	System.out.println(count);
	
	//finding the position of the vowels (both uppercase and lowercase)
	
	int vLocation;
    for (int z = 0; z < words.length(); z++){
    	char ch = words.charAt(z);
        if(ch == 'a' || ch == 'e'|| ch == 'i'|| ch == 'o'|| ch == 'u'|| ch == 'A'|| ch == 'E' || ch == 'I'|| ch == 'O'|| ch == 'U'){
        	vLocation = z;
        	System.out.println(vLocation);  
        }   
         
    
		 }
		 }
		 }}}

	
