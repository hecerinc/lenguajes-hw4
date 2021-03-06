package compiler;

public class Token {

	public enum Type {
		INTEGER, // 100
		DOUBLE, // 101
		VARIABLE, // 102
		PARAMETER_SEP, // 103
		FUNCTION, // 104
		EOI  // 105
	}


	private final Type type;
	private final String value;

	public Token(Type type, String value) {
		this.type = type;
		this.value = value;
	}

	public Type getType() {
		return type;
	}
	
	public String getValue() {
		return value;
	}

	public boolean equalsToken(Token token) {
		if (token.value.length() > 0) {
			return (type == token.type && value.equalsIgnoreCase(token.value)); 
		} else {
			return (type == token.type);
		}
	}

	public String toString() {
		StringBuilder string;
		string = new StringBuilder();
		string.append("<").append(type).append(", ").append(value).append(">");
		return string.toString();
	}

}
