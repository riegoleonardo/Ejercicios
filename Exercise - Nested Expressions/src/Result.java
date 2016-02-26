import java.util.Stack;

public class Result {

	private static Stack<Character> symbolsStack = new Stack<Character>();

	public static boolean expressionIsCorrect(String expression) {
		boolean theExpressionIsRight = true;
		int i = 0;
		while ((i < expression.length()) && (theExpressionIsRight)) {
			char currentCharacter = expression.charAt(i);
			if ((currentCharacter == '{') || (currentCharacter == '[') || (currentCharacter == '(')) {
				symbolsStack.push(currentCharacter);
			} else {
				if ((currentCharacter == '}') || (currentCharacter == ']') || (currentCharacter == ')')) {
					if (symbolsStack.isEmpty()) {
						theExpressionIsRight = false;
					} else {
						char stackChar = symbolsStack.pop();
						if ((stackChar == '{') && (currentCharacter != '}')) {
							theExpressionIsRight = false;
						}
						if ((stackChar == '[') && (currentCharacter != ']')) {
							theExpressionIsRight = false;
						}
						if ((stackChar == '(') && (currentCharacter != ')')) {
							theExpressionIsRight = false;
						}
					}
				}
			}
			i++;
		}
		if (!symbolsStack.isEmpty()) {
			theExpressionIsRight = false;
		}
		return theExpressionIsRight;
	}
}
