// ****************************************** 
// LetterPrinter program 
// written by Kristina Saha 
// Prints the specified letter in the programmed format. (Format is Letter.java)
// *******************************************

public class LetterPrinter {
 public static void main(String [] args)
{
	 Letter letter = new Letter("Mary","John");
	 letter.addLine("I am sorry we must part.");
	 letter.addLine("I wish you all the best.");
	 System.out.println(letter.getText());
}
}
