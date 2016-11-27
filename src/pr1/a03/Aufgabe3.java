//Shari Wagner(ehem. Donath)
//Matr.Nr.: 860836
package pr1.a03;

import schimkat.berlin.lernhilfe2016ws.io.DirtyFileWriter;
import java.io.PrintWriter;
import java.util.Locale;

public class Aufgabe3 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		writeIntNumberFile("./data/NumberFile.txt", 1000);
		writeIntNumberFile("./data/NumberFile1.txt", 1001);
		writeMixedNumberFile("./data/MixedNumberFile.txt", 1000, 10);
	}

	public static int incrementUnevenNumber(int number) {
		// wenn numberCount ungerade dann numberCount = numberCount + 1
		if (!(number % 2 == 0)) {
			number = number + 1;
		}
		return number;
	}

	public static void writeIntNumberFile(String filename, int numberCount) {
		PrintWriter fout = new PrintWriter(new DirtyFileWriter(filename));
		numberCount = incrementUnevenNumber(numberCount);
		
		// erzeuge randomZahl und schreibe in datei fileName -> numberCount mal
		for (int i = 1; i <= numberCount; i++) {
			fout.printf("%7d ", (int) (Math.random() * numberCount));

			if (i % 10 == 0) {
				fout.println();
			}
		}
		fout.flush();
		fout.close();
	}

	public static void writeMixedNumberFile(String filename, int numberCount, int width) {
		PrintWriter fout = new PrintWriter(new DirtyFileWriter(filename));
		numberCount = incrementUnevenNumber(numberCount);
		for (int i = 1; i <= numberCount; i++) {
			
			// gibt 50/50 ganze Zahlen und Gleitkommmaz. aus
			if (Math.random() < 0.5) {
				fout.printf("%" + width + ".2f", (Math.random() * numberCount));
			} else {
				fout.printf("%" + width + "d", (int) (Math.random() * numberCount));
			}
			
			if (i % 10 == 0) {
				fout.println();
			}
		}
		fout.flush();
		fout.close();
	}
}
