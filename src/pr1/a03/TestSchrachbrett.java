//Shari Wagner(ehem. Donath)
//Matr.Nr.: 860836
package pr1.a03;

import java.io.PrintWriter;
import java.util.Locale;
import pr1.a02.Schachbrett.Schachbrett;
import schimkat.berlin.lernhilfe2016ws.io.DirtyFileWriter;

public class TestSchrachbrett {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		printSchachbrett("./data/SchachBrettReverse.txt", true);
		printSchachbrett("./data/SchachBrett.txt", false);
	}

	public static void printSchachbrett(String filename, boolean isReverse) {
		PrintWriter out = new PrintWriter(new DirtyFileWriter(filename), true);

		if (!isReverse) {
			Schachbrett.printSchachbrett(out);
		} 
		else {
			Schachbrett.printSchachbrettReverse(out);
		}
		out.close();
	}
}