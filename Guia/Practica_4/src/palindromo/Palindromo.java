package palindromo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Palindromo {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String myPath = "C:/Users/maxim/Documents/Git/P.Avanzada/Guia/Practica_4/src/palindromo/";
		PrintWriter salida = new PrintWriter(new File(myPath + "PALIN.OUT"));
		Scanner sc = new Scanner(new File(myPath + "PALIN.IN"));
		String palabra = sc.nextLine();
		boolean isPalindromo = false;
		int i, j;

		for (i = 3; i <= palabra.length(); i++) {
			for (j = 0; j <= palabra.length() - i; j++) {
				String subpal = palabra.substring(j, j + i);
				// System.out.print(subpal+" ");
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append(subpal);
				if (isPalindromo(subpal)) {
					stringBuilder.append(" palindromo");
					isPalindromo = true;
				}
				

				if (isIPalindromo(subpal)) {
					stringBuilder.append(" i-palindromo");
					isPalindromo = true;
				}

				if (isDPalindromo(subpal)) {
					stringBuilder.append(" d-palindromo");
					isPalindromo = true;
				}
				
				if (isPalindromo == true) {
					salida.println(stringBuilder.toString() + "\n");
					isPalindromo = false;
				}

			}
		}

		sc.close();
		salida.close();
	}

	private static boolean isPalindromo(String palabra) {
		int a = 0, b = palabra.length() - 1;

		while (a < b && a != b) {
			if (palabra.charAt(a) != palabra.charAt(b))
				return false;
			a++;
			b--;
		}

		return true;
	}

	private static boolean isIPalindromo(String palabra) {
		int a = 1, b = palabra.length() - 1;

		while (a < b && a != b) {
			if (palabra.charAt(a) != palabra.charAt(b))
				return false;
			a++;
			b--;
		}

		return true;
	}
	
	private static boolean isDPalindromo(String palabra) {
		int a = 0, b = palabra.length() - 2;

		while (a < b && a != b) {
			if (palabra.charAt(a) != palabra.charAt(b))
				return false;
			a++;
			b--;
		}

		return true;
	}
	
}
