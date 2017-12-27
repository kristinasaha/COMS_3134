//Kristina Saha UNI ks3401//
// Data Structures , Programming Problem 1//

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SymbolBalance {
	
	private File theFile;
	private FileReader fr;
	private static BufferedReader br;
	
	public SymbolBalance(String file) throws FileNotFoundException{
		theFile = new File(file);
		fr = new FileReader(theFile);
		br = new BufferedReader(fr);
	}	
	public static BufferedReader getbr(){
		return br;
			}
	
	// ^^ code above taken from stackoverflow  
	
	    public void pattern(String k) {
	    	MyStack<String> a = new MyStack<String>();
	        
	        for(int i = 0; i < k.length(); i++){
	            if(k.substring(i, i+1).equals(')')){
	                if(!a.isEmpty() && a.peek().equals('(')){ // "(" and ")" should always be a pair at the beginning and end
	                    a.pop();
	                }  
	                else{
	                	System.out.println("unbalanced" + k.substring(i, i+1)); }}  // if the parentheses are not pairs, then the program will print that it is unbalanced
	           
	                else if(k.substring(i, i+1).equals(']')){
	            	if(!a.isEmpty() && a.peek().equals('[')){ // "[" and "]" should always be a pair at the beginning and end 
	                    a.pop();}
	                else{
	                	System.out.println("unbalanced" + k.substring(i, i+1)); }	// if the brackets are not pairs, then the program will print that it is unbalanced  
	                
	            }
	            
	            else if(k.substring(i, i+1).equals('}')){
	            	if(!a.isEmpty() && a.peek().equals('{')){ //"{" and "}" should always be a pair at the beginning and end
	                    a.pop();}
	                else{
	                	System.out.println("unbalanced" + k.substring(i, i+1)); }	// if the squiggly brackets are not pairs, then the program will print that it is unbalanced  
	                
	            }
	            
	            else{
	                a.push(k.substring(i, i+1)); 
	            }
	        }
	        
	    }
	    
	    public static void main (String args[]) throws IOException { //throws an IO Exception if there is a mistake
	    	SymbolBalance reader = new SymbolBalance(args[0]); //reads the file
	    	
	    	while (SymbolBalance.getbr().ready()){
	    		String line= SymbolBalance.getbr().readLine();
	    		reader.pattern(line);
	    	}
	    	
	    }
	}

	

