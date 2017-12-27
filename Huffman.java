/* Kristina Saha
 * UNI ks3401
 * Data Structures Section 1
 * Huffman.java */

import java.io.BufferedReader;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Huffman {
  
public static HashMap<Character, String> huffmanCode = new HashMap<>();
public static HashMap<String, Character> huffmanString = new HashMap<>();

private static void HuffmanCmpression(CharFreq[] array) {
  
Comparator<CharFreq> comp = new Comparator<CharFreq>() {

@Override
public int compare(CharFreq t, CharFreq t1) {
if(t.f < t1.f)
return -1;
return 1;
}
};
  
PriorityQueue<CharFreq> pq = new PriorityQueue<>(11, comp);
pq.addAll(Arrays.asList(array)); // put all charcters with their frequency in Heap
  
CharFreq temp = null;
while (pq.size() >1)
{
temp = new CharFreq(Integer.MIN_VALUE, Character.MIN_VALUE);
temp.left = pq.poll();
temp.right = pq.poll();
temp.f = temp.left.f + temp.right.f;
pq.add(temp);
}
GetCompressedFreq(temp, "");
}

private static void GetCompressedFreq(CharFreq temp, String s) {
  
if(temp == null)
return;
  
if(temp.c != Character.MIN_VALUE)
{
System.out.println(temp.c + "--> " +s);
huffmanCode.put(temp.c, s);
huffmanString.put(s, temp.c);
}
else
{
GetCompressedFreq(temp.left, s+'0');
GetCompressedFreq(temp.right, s+'1');
}
  
}

static class CharFreq
{
Character c;
int f;
CharFreq left;
CharFreq right;
  
public CharFreq(int f, Character c)
{
this.c = c;
this.f = f;
this.left = this.right = null;
}
}
public static void main(String[] args) throws FileNotFoundException, IOException
{
BufferedReader br = null;
FileReader fr = null;
String filePath = "C:\\Users\\XYZ\\Desktop\\"; // This path should point to a file in your system
HashMap<Character, Integer> map = new HashMap<>();
Scanner sc = new Scanner(new InputStreamReader(System.in));
System.out.println("Enter File Name : ");
fr = new FileReader(filePath + sc.next());
br = new BufferedReader(fr);
  
//Here we are considering only lowercase and uppercase character(No Symbols)
String line;
while((line = br.readLine()) != null)
{
for(int i =0; i< line.length();i++)
{
char c = line.charAt(i);
if((c - 'a' >=0 && c - 'a' < 26) || c-'A' >= 0 && c - 'A' < 26)
{
if(map.containsKey(c))
{
int v = map.get(c);
map.put(c, v+1);
}
else
{
map.put(c, 1);
}
}
}
}
  
CharFreq[] array = new CharFreq[map.size()]; int arrayIndex =0;
for(Character c : map.keySet())
{
array[arrayIndex++] = new CharFreq(map.get(c), c);
}

//Function for Huffman Compression

HuffmanCmpression(array); 
System.out.println("");
System.out.println("Please enter huffman code to Decode :");
sc.nextLine();
String code = sc.nextLine();
String [] sArray = code.split(" ");
StringBuilder sb = new StringBuilder();
for(int i=0; i< sArray.length;i++)
{
if(huffmanString.containsKey(sArray[i]))
sb.append(huffmanString.get(sArray[i]));
else
{
System.out.println("Error in Code");
break;
}
}
System.out.println("You entered : " +sb.toString());
System.out.print("Please Enter series of Characters separated by Spaces : ");
String charS = sc.nextLine();
String [] charSArray =charS.split(" ");
for(int i=0; i< charSArray.length;i++)
{
if(huffmanCode.containsKey(charSArray[i].charAt(0)))
System.out.println("Code for Character " + charSArray[i] + " is " + huffmanCode.get(charSArray[i].charAt(0)));
else
{
System.out.println("Code for Character " + charSArray[i] + " is not Available");
}
}
}
  
}