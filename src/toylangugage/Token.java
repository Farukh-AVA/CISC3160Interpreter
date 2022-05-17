/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toylangugage;

/**
 *
 * @author faruk
 */
public class Token {
    
   
    /*
     * Constructor with no value 
     * */
     public Token(Tokens type) {
         this.token_type = type;
         this.token_value =0;
     }
/*
 * Constructor....
 * */
    public Token(Tokens token_type, int token_value) {
        this.token_type = token_type;
        this.token_value = token_value;
    }

   /*
    * 
    * Token type enum
    * */

    public enum Tokens {
        INTEGER_VALUE,
        ADD,
        SUBTRACT,
        MULT,
        LEFT_PAREN,
        RIGHT_PAREN
    }

    public final Tokens token_type;
    public final int token_value;
}
