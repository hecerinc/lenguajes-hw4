import compiler.Scanner;
import compiler.Token;
import java.util.List;


public class HW4 {
	public static void main(String[] args) {
		List<Token> tokens;
		String s = "$MyVariable SUM 10 DIV 20.5384";
		Scanner scanner = new Scanner();
		scanner.scan(s);
		tokens = scanner.getTokens();
		for (Token token : tokens) {
			System.out.println(token);
		}

	}
}
