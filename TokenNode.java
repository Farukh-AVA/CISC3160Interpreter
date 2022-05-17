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
public class TokenNode {
    
    public void getNegativeNode() {
        is_negative = !is_negative;
    }

    
    public boolean isNodeNegated() {
        return is_negative;
    }
    
    TokenNode(Token token) {
        this.token_Type = Token.Tokens.INTEGER_VALUE;
        this.node_value = token.token_value;
        op1 = op2 = null;
    }

    
    TokenNode(Token.Tokens token_Type, TokenNode op1, TokenNode op2) {
        this.token_Type = token_Type;
        this.op1 = op1;
        this.op2 = op2;
        this.node_value =0;
    }
    
   
    private boolean is_negative = false; // check whether the value of node is negated or not...
    public final Token.Tokens token_Type;// token type
    public final TokenNode op1, op2;// operand1 and operand2 for token node..
    public int node_value; // node value..
   

}
