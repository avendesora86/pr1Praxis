//Shari Wagner(ehem. Donath)
//Matr.Nr.: 860836

package pr1.a02.SomeFunctions;

//Aufgabe 2.a-c:

public class SomeFunctions {

	public static void main(String[] args) {
		// PrintWriter out = new PrintWriter(System.out, true);
		double a, b, test, radius;
		// b)
		a = 5;
		b = 2.5;
		test = 15;
		testeErgebnis(test, rechteckUmfang(a, b));

		a = 2;
		b = 7;
		test = 18;
		testeErgebnis(test, rechteckUmfang(a, b));
		// c)
		a = 2;
		b = 3;
		test = 6;
		testeErgebnis(test, rechteckFlaeche(a, b));

		a = 5;
		b = 7;
		test = 35;
		testeErgebnis(test, rechteckFlaeche(a, b));
		// a)
		radius = .5;
		test = Math.PI;
		testeErgebnis(test, kreisUmfang(radius));

		radius = 1.0;
		test = 2 * Math.PI;
		testeErgebnis(test, kreisUmfang(radius));

	}

	private static void testeErgebnis(double test, double methodenErgebnis) {
		System.out.println(test == methodenErgebnis);
	}

	public static double kreisUmfang(double radius) {
		return 2 * radius * Math.PI;
	}

	public static double rechteckUmfang(double a, double b) {
		return 2 * (a + b);
	}

	public static double rechteckFlaeche(double a, double b) {
		return a * b;
	}

}
