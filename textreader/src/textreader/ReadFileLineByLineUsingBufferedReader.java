package textreader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileLineByLineUsingBufferedReader {

	 public static void main(String[] args) throws IOException 
	   {
	      File f1=new File("C:/Users/Nimesh Madusanka/Documents/GitHub/WE_47/complexity_measuring_tool/WebContent/uploaded-files/nimesh.txt"); //Creation of File Descriptor for input file
	      String[] words=null;  //Intialize the word Array
	      FileReader fr = new FileReader(f1);  //Creation of File Reader object
	      BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
	      String s;     
	      String input1="if";   // Input word to be searched
	      String input2 ="&&", input3 = "&";
	      String input4 ="||", input5 = "|";
	      String input6="while", input7="for";
	      String input8="catch", input9="switch";
	      
	      int count=0;   //Intialize the word to zero
	      while((s=br.readLine())!=null)   //Reading Content from the file
	      {
	         words=s.split(" ");  //Split the word using space
	          for (String word : words) 
	          {
	                 if (word.equals(input1))   //Search for the given word
	                 {
	                   count++;    //If Present increase the count by one
	                 }
	                 else if(word.equals(input2)||word.equals(input2)) {
	                	 
	                	 count++; //If Present increase the count by one
	                 }
	                 else if(word.equals(input4)||word.equals(input5)) {
	                	 
	                	 count++; //If Present increase the count by one
	                 }
	                 else if(word.equals(input6)) {
	                	 count = count + 2;
	                 }
	                 else if(word.equals(input7)) {
	                	 count = count + 2;
	                 }
	                 else if(word.equals(input8)) {
	                	 count++;
	                 }
	                 else if(word.equals(input9)) {
	                	 for(int i=0; i < 3; i++)
	                	 {
	                		 count++;
	                	 } 
	                 }
	          }
	      }
	      if(count!=0)  //Check for count not equal to zero
	      {
	         System.out.println("The Ctc value "+count+ ".");
	      }
	      else
	      {
	         System.out.println("The given word is not present in the file");
	      }
	      
	         fr.close();
	   }

}
