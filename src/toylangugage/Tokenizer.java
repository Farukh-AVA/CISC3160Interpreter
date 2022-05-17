/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toylangugage;

import java.util.ArrayList;
import java.util.HashMap;
/*
 * 
 * Tokenizer class to create token from input expression...
 * */
public class Tokenizer {
	
	  /*
	   * calculate token and return token list...
	   * */

	    public static ArrayList<Token> createsTokensFromInput(String expression) throws Exception {
	        ArrayList<Token> tokens_Array = new ArrayList<>();
	        

	        for (int i = 0; i < expression.length(); i++) {
	            char chr = expression.charAt(i);
	            
	            if (Character.isDigit(chr) || chr == '.') {
	                int j;
	               
	                if(chr=='0'&& expression.length()!=2)
	                {
	                	throw new Exception();
	                }
	                for (j = i; j < expression.length(); j++) {
	                    char current_char = expression.charAt(j);
	                    if (current_char == '.') {
	                         throw new Exception();
	                        
	                    }
	                    else if (!Character.isDigit(current_char)) break;
	                }
	                
	                String value_string = "0" + expression.substring(i, j);
	               
	                Token value_token = new Token(Token.Tokens.INTEGER_VALUE, Integer.parseInt(value_string));
	                tokens_Array.add(value_token);
	                
	                i = j - 1;
	            }
	            
	            else if (operationSet.containsKey(chr)) {
	                Token token_operator = new Token(operationSet.get(chr));
	                tokens_Array.add(token_operator);
	            }
	  
	            else if (!Character.isWhitespace(chr)) throw new Exception();
	        }
	        return tokens_Array;
	    }
	    
	    /*
	     * operation set hashmap
	     * */
	    private static final HashMap<Character, Token.Tokens> operationSet = new HashMap<>();
	    /*
	     * inserting value into hashMap
	     * */
	    static {
	        operationSet.put('+', Token.Tokens.ADD);
	        operationSet.put('-', Token.Tokens.SUBTRACT);
	        operationSet.put('*', Token.Tokens.MULT);
	       
	        operationSet.put('(', Token.Tokens.LEFT_PAREN);
	        operationSet.put(')', Token.Tokens.RIGHT_PAREN);
	    }
	    
	   
}
