import compiler.Scanner;
import compiler.Token;
import compiler.Parser;
import java.util.List;
// import java.util.Scanner;


public class HW4 {
	public static void main(String[] args) throws Exception {
		List<Token> tokens;
		String s; //= "MUL SUM ( ) ( $MyVariable ) ( ) SUM 10 12.20 DIV 20.5384";
		java.util.Scanner key = new java.util.Scanner(System.in);
		while(key.hasNextLine()){
				
			s = key.nextLine();
			Scanner scanner = new Scanner();
			if(!scanner.scan(s)){
				throw new Exception("Invalid string passed.");
			}
			tokens = scanner.getTokens();
			for (Token token : tokens) {
				System.out.println(token);
			}

			Parser parser = new Parser(tokens);
			parser.parse();

		}

	}
}
