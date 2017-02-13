package compiler;

import compiler.Token;
import compiler.Token.Type;
import java.util.List;

public class Parser {

	private Token token;
	private int current_token;
	private List<Token> tokens;

	// Constructor
	public Parser(List<Token> tokens) {
		current_token = 0;
		this.tokens = tokens;
		token = this.tokens.get(0);
	}

	public void parse() throws Exception {
		statement();
		System.out.println("The input is a well formed expresssion.");
	}

	private void getNextToken() throws Exception {
		if(current_token == tokens.size())
			throw new Exception("Insufficient tokens passed.");
		token = tokens.get(current_token);
	}

	private boolean match(Type expectedToken) throws Exception {
		getNextToken();
		System.out.println(token.toString());
		if(token.equalsToken(expectedToken)){
			current_token++;
			// token = getNextToken();
			return true;
		}
		else{
			throw new Exception("Invalid string passed");
		}
		//return false;
	}

	// Metodos
	private void statement() throws Exception {
		expression();
		match(Type.EOI);
	}
	private void expression() throws Exception {
		if(token.equalsToken(Type.FUNCTION)){
			func();
		}
		else{
			factor();
		}
	}
	private void func() throws Exception {
		match(Type.FUNCTION);
		match(Type.PARENS);
		param();
		match(Type.PARAMETER_SEP);
		param();
		match(Type.PARENS);
	}
	private void factor() throws Exception {
		switch(token.getType()){
			case VARIABLE:
				match(Type.VARIABLE);
			break;
			case INTEGER:
				match(Type.INTEGER);
			break;
			case DOUBLE:
				match(Type.DOUBLE);
			break;
			default: // TODO: Change this
				throw new Exception("Invalid string passed");
		}
	}
	private void param() throws Exception {
		getNextToken();
		if(token.equalsToken(Type.FUNCTION)){
			func();
		}
		else{
			factor();
		}
	}
	
}
