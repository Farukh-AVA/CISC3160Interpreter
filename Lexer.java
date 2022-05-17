/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toylangugage;
import java.util.ArrayList;
import java.util.ListIterator;

public class Lexer {
     
    /*
     * create token node from factor..
     * */
    static TokenNode createTokenNode(Token node) throws Exception {
        switch (node.token_type) {
            
            case LEFT_PAREN: {
                TokenNode expression = createExpression(tokenIterator.next());

                if (tokenIterator.hasNext()) 
                    tokenIterator.next();

                return expression;
            }
            
            case ADD: {
                return createTokenNode(tokenIterator.next());
            }
           
            case SUBTRACT: {
                TokenNode next_expression = createTokenNode(tokenIterator.next());
                next_expression.getNegativeNode();
                return next_expression;
            }
         
            case INTEGER_VALUE: {
                return new TokenNode(node);
            }
           
            default: {
                throw new Exception();
            }
        }
    }
    /*
     * parse token 
     * */
    public static TokenNode tokenListParse(ArrayList<Token> tokenList) throws Exception {
        tokenIterator = tokenList.listIterator();
        TokenNode output = createExpression(tokenIterator.next());

        if (tokenIterator.hasNext()) 
            throw new Exception();

        return output;
    }

   /*
    * Create expression...
    * */
    static TokenNode createExpression(Token token) throws Exception {
        TokenNode current_Expression = create_term(token);

        while (tokenIterator.hasNext()) {
            token = tokenIterator.next();
          
            if (token.token_type == Token.Tokens.ADD) {
                current_Expression = new TokenNode(Token.Tokens.ADD, current_Expression, create_term(tokenIterator.next()));
            } else if (token.token_type == Token.Tokens.SUBTRACT) {
                current_Expression = new TokenNode(Token.Tokens.SUBTRACT, current_Expression, create_term(tokenIterator.next()));
            }
           
            else {
                tokenIterator.previous();
                break;
            }
        }
        return current_Expression;
    }

    
    static TokenNode create_term(Token token) throws Exception {
        TokenNode current_term = createTokenNode(token);

        while (tokenIterator.hasNext()) {
            token = tokenIterator.next();
            
            if (token.token_type == Token.Tokens.MULT) {
                current_term = new TokenNode(Token.Tokens.MULT, current_term, createTokenNode(tokenIterator.next()));
            }
           else if (token.token_type == Token.Tokens.LEFT_PAREN) {
                current_term = new TokenNode(Token.Tokens.MULT, current_term, createExpression(token));
            }
            
            else {
                tokenIterator.previous();
                break;
            }
        }
        return current_term;
    }

    // to iterate over all tokens in the token list passed from the lexer
    private static ListIterator<Token> tokenIterator;

}
