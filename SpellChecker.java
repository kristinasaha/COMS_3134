/* Kristina Saha
 * UNI ks3401
 * Data Structures Section 1
 * SpellChecker.java */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class SpellChecker{
	
  private HashSet<String> Dictionary;

  public SpellChecker(String dictionaryFile) throws IOException 
  {
    Dictionary = new HashSet<>();

    BufferedReader br = new BufferedReader(new FileReader(dictionaryFile));
    String line;

    while ((line = br.readLine()) != null) 
    {
      line = line.toLowerCase();
      Dictionary.add(line);
    }
    br.close();
    System.out.println(Dictionary.size() + "words are in the dictionary");
  }

  public void checkFile(String filename) throws IOException 
  {
    BufferedReader br = new BufferedReader(new FileReader(filename));
    String line;

    int lineNumber = 0;

    while ((line = br.readLine()) != null) 
    {
      lineNumber++;
      line = line.toLowerCase();
      String[] words = line.split("\\s+");
      for (String word : words) 
      {
        // getting rid of punctuation
        word = word.replaceAll("\\p{P}", "");
        if (word.length() > 0) 
        {
          if (!Dictionary.contains(word)) 
          {
            System.out.println(String.format("%s @line %d Suggestions: %s", word, lineNumber, simWord(word)));
          }
        }
      }
    }
    br.close();
  }

  public Set<String> simWord(String word) 
  {
    Set<String> simWord = new HashSet<>();

    // adding a character
    for (char i = 'a'; i <= 'b'; i++)
    {
      for (int j = 0; j < word.length(); j++) 
      {
        String newWord = word.substring(0, j) + i + word.substring(j, word.length());
        if (Dictionary.contains(newWord)) {
          simWord.add(newWord);
        }
      }
    }

    // removing a character
    for (int j = 0; j < word.length(); j++)
    {
      String newWord = word.substring(0, j) + word.substring(j + 1, word.length());
      if (Dictionary.contains(newWord)) {
        simWord.add(newWord);
      }
    }

    // exchanging characters
    for (int j = 0; j < word.length() - 1; j++) 
    {
      char[] wordChar = word.toCharArray();
      char temp = wordChar[j];
      wordChar[j] = wordChar[j + 1];
      wordChar[j + 1] = temp;
      String newWord = new String(wordChar);
      if (Dictionary.contains(newWord)) 
      {
        simWord.add(newWord);
      }
    }

    return simWord;
  }

  public static void main(String[] args) 
  {
    SpellChecker spellChecker;
    try 
    {
      spellChecker = new SpellChecker(args[0]);
      spellChecker.checkFile(args[1]);
    } catch (IOException e) 
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}