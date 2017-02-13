package compiler;

import java.util.*;
import compiler.Token.Type;
import java.util.regex.Pattern;

public class Scanner {

	// 9 states
	private final int ERR = Integer.MAX_VALUE;
	private final int[][] transitionMatrix;
	private List<Token> tokens;

	public Scanner() {
		tokens = new ArrayList<Token>();
		transitionMatrix =  new int[][]{
			{0, 1, ERR, ERR, 4, 6, 7, 8, ERR},
			{100, 1, 2, ERR, ERR, ERR, ERR, ERR, ERR},
			{ERR, 3, ERR, ERR, ERR, ERR, ERR, ERR, ERR},
			{101, 3, ERR, ERR, ERR, ERR, ERR, ERR, ERR},
			{ERR, ERR, ERR, 5, ERR, ERR, ERR, ERR, ERR},
			{102, 5, ERR, 5, ERR, ERR, ERR, ERR, ERR},
			{103, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR},
			{104, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR},
			{105, ERR, ERR, ERR, ERR, ERR, ERR, ERR, ERR}
		};
	}
	public boolean scan(String string) {
		char c;
		int state, index;
		StringBuilder value;        
		state = 0;
		index = 0;
		tokens = new ArrayList<Token>();
		string = string + " ";
		while (index < string.length()) {
			value = new StringBuilder();
			do {
				c = string.charAt(index);
				index++;
				state = transitionMatrix[state][filter(c)];
				if (state > 0 && state < 100) {
					value.append(c);
				}
			} while (index < string.length() && state < 100);
			/*
			 * The token is recognized by the system.
			 */
			switch (state) {
				case 0:
					return true;
				case ERR:
					value.append(c);
					System.out.println("LEXICAL ERROR: the string \'" + value.toString() + "\' is not a valid element in the language.");
					return false;
				case 100:
					tokens.add(new Token(Type.INTEGER, value.toString()));
					break;
				case 101:
					tokens.add(new Token(Type.DOUBLE, value.toString()));
					break; 
				case 102:
					tokens.add(new Token(Type.VARIABLE, value.toString()));
					break;
				case 103:
					tokens.add(new Token(Type.PARAMETER_SEP, value.toString()));
					break;
				case 104:
					tokens.add(new Token(Type.FUNCTION, value.toString()));
					break;
				case 105:
					tokens.add(new Token(Type.EOI, value.toString()));
					break;
			}
			index--;
			state = 0;
		}
		return true;
	}
	public List<Token> getTokens() {
		return tokens;
	}

	private int filter(char c){
		if(Pattern.matches("[ \t]", Character.toString(c)))
			return 0;
		if(Pattern.matches("[0-9]", Character.toString(c)))
			return 1;
		if(Pattern.matches("\\.", Character.toString(c)))
			return 2;
		if(Pattern.matches("[a-zA-Z]", Character.toString(c)))
			return 3;
		if(Pattern.matches("\\$", Character.toString(c)))
			return 4;
		if(Pattern.matches(",", Character.toString(c)))
			return 5;
		if(Pattern.matches("SUM|SUB|DIV|MUL", Character.toString(c)))
			return 6;
		if(Pattern.matches(";", Character.toString(c)))
			return 7;
		return 8;
	}

}


