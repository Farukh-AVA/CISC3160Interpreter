/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toylangugage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
/*
 * Main class to run the interpreter and show the result to console....
 * */
public class Main {
    static Scanner scanner = new Scanner(System.in);
  
   
    public static HashMap<String, Integer> Varaibles_value = new HashMap<String, Integer>();
    

    public static void main(String[] args) throws Exception {
    	boolean isNegative=false;
    	try {
  	      File myObj = new File("input.txt");
  	      Scanner myReader = new Scanner(myObj);
  	      while (myReader.hasNextLine()) {
  	        String data = myReader.nextLine();
  	        if(data.charAt(data.length()-1)==';')
              {
              String varaible=data.substring(0, data.indexOf('='));  
              data=data.substring(data.indexOf('=')+1,data.length()-1); 
              if(data.length()>=4)
              {
              if(data.charAt(1)=='-'&&data.charAt(2)=='-'&&data.charAt(3)=='-')
              {
            	  isNegative=true;  
              }
              }
              if (data.equals("exit")) System.exit(0);
              else if (data.equals("")) System.out.println(0);
              else {
                  try {
                  	if(Varaibles_value.isEmpty())
                  	{
                  		if(isNegative)
                  		{
                      System.out.println(varaible+" = "+(-Interpreter.getExpressionValue(data)));
                      Varaibles_value.put(varaible, -Interpreter.getExpressionValue(data));
                  		}
                  		else
                  		{
                  			System.out.println(varaible+" = "+(Interpreter.getExpressionValue(data)));
                            Varaibles_value.put(varaible, Interpreter.getExpressionValue(data));
                  		}
                  		
                  	}
                  	else
                  	{
                  		String newInput="";
                  	  for(int i=0; i<data.length(); i++)
                  	  {
                  		  String currentValue="";
                  		  currentValue=currentValue+data.charAt(i);
                  		 
                  		  if(Varaibles_value.containsKey(currentValue+" "))
                  		  {
                  			  currentValue= Varaibles_value.get(currentValue+" ").toString();
                  			 
                  		  }
                  		 
                  		  newInput=newInput+currentValue;
                  	  }
                  	 
                  	if(isNegative)
              		{
                  System.out.println(varaible+" = "+(-Interpreter.getExpressionValue(newInput)));
                  Varaibles_value.put(varaible, -Interpreter.getExpressionValue(newInput));
              		}
              		else
              		{
              			System.out.println(varaible+" = "+(Interpreter.getExpressionValue(newInput)));
                        Varaibles_value.put(varaible, Interpreter.getExpressionValue(newInput));	
              		}
                  	}
                  } catch (Exception ignored) {
                      System.out.println("Error");
                      
                      break;
                  }
              }
              }
              else
              {
              	System.out.println("Error");
              	break;
              }
          }
  	      
  	      myReader.close();
  	    } catch (FileNotFoundException e) {
  	      System.out.println("An error occurred.");
  	      e.printStackTrace();
  	    }
     
    
    }
}
