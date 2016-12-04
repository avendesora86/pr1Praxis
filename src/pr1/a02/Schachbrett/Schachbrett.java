//Shari Wagner(ehem. Donath)
//Matr.Nr.: 860836

package pr1.a02.Schachbrett;

import java.io.PrintWriter;

//Aufgabe 2.b-d:

public class Schachbrett {

	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out, true);

		printSchachbrett(out);
		out.println();
		printSchachbrettReverse(out);
		out.println();
		
	}

	public static void printSchachbrett(PrintWriter out) {
		StringBuilder b = new StringBuilder();
		for (int i = 8; i >= 1; i--) {
			for (char c = 'A'; c <= 'H'; c++) {
				b.append(c);
				b.append(i);
				b.append(' ');
				out.print(b);
				b = new StringBuilder();
			}
			out.println();
		}
	}

	public static void printSchachbrettReverse(PrintWriter out) {
		StringBuilder r = new StringBuilder();
		for (int i = 1; i <= 8; i++) {
			for (char c = 'H'; c >= 'A'; c--) {
				r.append(c);
				r.append(i);
				r.append(' ');
				out.print(r);
				r = new StringBuilder();
			}
			out.println();
			
		}
	}
}
