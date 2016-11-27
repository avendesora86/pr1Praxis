//														Shari Wagner (ehem. Donath)
//																    Matr.Nr. 860836			
package pr1.a04;

import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;
import schimkat.berlin.lernhilfe2016ws.io.DirtyFileWriter;
import schimkat.berlin.lernhilfe2016ws.io.DirtyFileReader;
import pr1.a03.Aufgabe3;

public class FirstInput {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		PrintWriter out = new PrintWriter(System.out, true);
//		scannerAusprobieren();
//		int sum = countSumOf(new Scanner("8 2 0 34 87 quatsch 5.7 1 246 5 5683"));
//		int sum1 = countSumOf("./data/testfiles/zahlen01.txt");
//		out.println("Summe: " + sum);
//		out.println("Summe: " + sum1);
		printNumbersFrom(new Scanner(new DirtyFileReader("./data/NumberFile.txt")), 8, 3, out); //Aufgabe 4b1
		copyNumberFile("./data/NumberFile.txt", 12, 1, "./data/NumberFile_copy.txt");
	}

	// Aufgabe 4a
	public static void scannerAusprobieren() {

		PrintWriter out = new PrintWriter(System.out, true);

		String intNumbers = "8 2 0 34 87 1 246 5 5683";
		String doubleNumbers = "34.2 4.8 8.3 23.6 2.6 67.223 3.76 1.4 78.23";
		String mixedNumbers = "1 6.3 5 5.5 8 2";

		Scanner intIn = new Scanner(intNumbers);
		Scanner doubleIn = new Scanner(doubleNumbers);
		Scanner mixedIn = new Scanner(mixedNumbers);

		int numberCount = 1;
		while (intIn.hasNext()) {
			if (intIn.hasNext()) {
				int i = intIn.nextInt();
				out.println(numberCount + ". Zahl: " + i);
				numberCount++;
			}
		}
		intIn.close();

		numberCount = 1;
		while (doubleIn.hasNext()) {
			if (doubleIn.hasNext()) {
				double d = doubleIn.nextDouble();
				out.println(numberCount + ". Zahl: " + d);
				numberCount++;
			}
		}
		doubleIn.close();

		numberCount = 1;
		while (mixedIn.hasNext()) {
			if (mixedIn.hasNext()) {
				double m = mixedIn.nextDouble();
				out.println(numberCount + ". Zahl: " + m);
				numberCount++;
			}
		}
		doubleIn.close();

		DirtyFileReader read = new DirtyFileReader("./data/testfiles/zahlen01.txt");
		Scanner zahlen = new Scanner(read);
		while (zahlen.hasNextDouble()) {
			if (zahlen.hasNextDouble()) {
				double z = zahlen.nextDouble();
				out.println("Testzahlen: " + z);
				continue;
			}
			String token = zahlen.next();
			out.println(token);
		}
		zahlen.close();
	}

	// public static void ausgabe (PrintWriter out, Scanner scan){
	// //hier schleife für stringausgabe/ zahl:bla oben ausgabe schreiben??
	//
	// }

	// Aufgabe 4aa

	// Befinden sich Double werte im Scanner, so werden die Nachkommastellen
	// ignoriert.
	public static int countSumOf(Scanner in) {
		int sum = 0;
		while (in.hasNext()) {
			if (in.hasNextDouble()) {
				sum += in.nextDouble();
				continue;
			}
			in.next();
		}
		in.close();
		return sum;
	}

	public static int countSumOf(String filename) {
		Scanner scanner = new Scanner(new DirtyFileReader(filename));
		return (countSumOf(scanner));
	}

	public static void printNumbersFrom(Scanner in, int width, int precision, PrintWriter out) {
		int counter = 0;
		while (in.hasNext()) {
			if (counter == 10) {
				out.println();
				counter = 0;
			}
			if (in.hasNextInt()) {
				counter++;
				out.printf("% " + width + "d", in.nextInt());
				continue;
			}
			if (in.hasNextDouble()) {
				counter++;
				out.printf("% " + width + "." + precision + "f", in.nextDouble());
				continue;
			}
			in.next();
		}
	}

	//Aufgabe 4b2
//	   Rufe printNumbersFrom auf wegen DRY. Eventuell könnte der Rückgabetyp auch boolean sein,
//	   und angeben ob der Kopiervorgang erfolgreich war. Alternativ könnte man in der Parameterliste auf 
//	   newFileName verzichten, den neuen Dateinamen selbst erzeugen, und diesen dann zurückgeben.
	public static void copyNumberFile (String filename, int width, int precision, String newFileName){
		printNumbersFrom(new Scanner(new DirtyFileReader(filename)),
				width, precision, new PrintWriter(new DirtyFileWriter(newFileName), true));
	}
}
