//Shari Wagner(ehem. Donath)
//Matr.Nr.: 860836
package pr1.a03;

import java.io.PrintWriter;
import java.util.Locale;

public class Hypothenuse {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		PrintWriter out = new PrintWriter(System.out, true);
		testHypothenuse(8, 2, out);

	}

	public static double hypothenuse(double k1, double k2) {

		double ergebnis = Math.sqrt(Math.pow(k1, 2) + Math.pow(k2, 2));
		return ergebnis;
	}

	public static void printHypothenuse(double k1, double k2, int width, int precision, PrintWriter out) {

		out.printf("% " + width + "." + precision + "f", hypothenuse(k1, k2));
	}

	public static void testHypothenuse(int width, int precision, PrintWriter out) {

		int min = 1;
		int max = 10;
		String s= ("Hypothenuse aus den ganzzahligen Katheden zwischen 1 und 10");
		
		out.println(s);
		out.println();

		//Spalten
		for (int column = min; column <= max; column++) {
			if (column == min) {
				out.printf("%" + width + "s", " ");
			} else {
			}
			out.printf("%" + width + "d", column);
		}
		out.println();
		out.println();

		//Zeilen
		for (int k2 = min; k2 <= max; k2++) {
			// Zeilen Kathete 2
			out.printf("%" + width + "d", k2);

			for (int k1 = min; k1 <= max; k1++) {
				// Spalten Kathete 1
				printHypothenuse(k1, k2, width, precision, out);
			}
			out.println();
		}
	}
}
