import java.util.Scanner;

public class InputAndOutput {
	public static void main(String args[]){
		String respuesta;
		Scanner userInput = new Scanner(System.in);
		do {
			System.out.println("¿Quiere evaluar una expresión?");
			respuesta = userInput.nextLine();
			System.out.println("Ingrese Expresión a Evaluar");
			String expression = userInput.nextLine();
			boolean result = Result.expressionIsCorrect(expression);
			if (result) {
				System.out.println("La expresión es correcta");
			} else {
				System.out.println("La expresión es incorrecta");
			}
		} while(respuesta != "n");
		userInput.close();	
	}
}
