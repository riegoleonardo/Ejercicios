package ejercicioDia1;

import java.util.Scanner;

public class ClasePrincipal {
	public static void main(String args[]) {
		System.out.println("Ingrese el String");
		Scanner userInput = new Scanner(System.in);
		String frase = userInput.nextLine();
		System.out.println(frase);
		userInput.close();
	}
}
