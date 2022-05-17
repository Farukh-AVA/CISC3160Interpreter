
package toylangugage;


public class Interpreter {

	/*
	 * Create expression
	 * 
	 * */
	 private static int calculateExpressionTree(TokenNode token_node) {
	        switch (token_node.token_Type) {
	            case INTEGER_VALUE: {
	                return token_node.isNodeNegated() ? -token_node.node_value : token_node.node_value;
	            }
	            case MULT: {
	                return calculateExpressionTree(token_node.op1) * calculateExpressionTree(token_node.op2);
	            }
	            
	            case ADD: {
	                return calculateExpressionTree(token_node.op1) + calculateExpressionTree(token_node.op2);
	            }
	            case SUBTRACT: {
	                return calculateExpressionTree(token_node.op1) - calculateExpressionTree(token_node.op2);
	            }
	            default: {
	               
	                throw new InternalError("Error");
	            }
	        }
	    }
/*
 * get the value of the expression
 * @return int 
 * */
    public static int getExpressionValue(String input) throws Exception {
        TokenNode expressionTree = Lexer.tokenListParse(Tokenizer.createsTokensFromInput(input));
        return calculateExpressionTree(expressionTree);
    }

   
}
