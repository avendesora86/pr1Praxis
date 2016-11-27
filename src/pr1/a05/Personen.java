package pr1.a05;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.function.Predicate;

import schimkat.berlin.lernhilfe2016ws.io.DirtyFileReader;
import schimkat.berlin.lernhilfe2016ws.io.DirtyFileWriter;
import schimkat.berlin.lernhilfe2016ws.objectPlay.Person;
import schimkat.berlin.lernhilfe2016ws.objectPlay.PersonList;
import schimkat.berlin.lernhilfe2016ws.objectPlay.PersonSet;

public class Personen {

	public static void main(String[] args) {
		// PersonSet ps = PersonFactory.createTestPersonSet();
		// for(Person p : ps){
		// System.out.println(p.toString());
		// }
		PrintWriter out = new PrintWriter(System.out, true);
		// printPersons(PersonFactory.createTestPersonliste(), out);
		// printPersons(PersonFactory.createTestPersonSet(), out);
		// printPersons(PersonFactory.createTestPersonSet(),
		// "./data/Personen.txt");
		aufgabeC(out);



	}

	public static void printPersons(PersonList persons, PrintWriter out) {
		for (Person p : persons) {
			out.println(p.toString());
		}
	}

	public static void printPersons(PersonSet persons, PrintWriter out) {
		for (Person p : persons) {
			out.println(p.toString());
		}
	}

	public static void printPersons(PersonSet persons, String fileName) {
		printPersons(persons, new PrintWriter(new DirtyFileWriter(fileName), true));
	}

	public static Person createPerson(Scanner dataSource) {
		String Vorname = "", Nachname = "";
		int Geburtsjahr = 0;

		Vorname = dataSource.next();
		Nachname = dataSource.next();
		Geburtsjahr = dataSource.nextInt();

		Person p;
		if (!(Vorname.equals("")) && !(Nachname.equals("")) && (Geburtsjahr != 0)) {
			p = new Person(Vorname, Nachname, Geburtsjahr);
			return p;
		}
		return null;
	}

	public static PersonSet getPersonsFrom(Scanner dataSource) {
		PersonSet persons = new PersonSet();
		while (dataSource.hasNextLine()) {
			Person p = createPerson(new Scanner(dataSource.nextLine()));
			if (p != null) {
				persons.add(p);
			}
		}
		return persons;
	}

	public static PersonSet getPersonsFrom(String filename) {
		// DirtyFileReader dfr = new DirtyFileReader(filename);
		// Scanner scanner = new Scanner(dfr);
		// PersonSet persons = getPersonsFrom(scanner);
		//
		// return persons;
		return getPersonsFrom(new Scanner(new DirtyFileReader(filename)));
	}

	public static void aufgabeC(PrintWriter out) {
		for (Person p : getPersonsFrom("./data/kommilitonen.txt")) {
			out.println(p);
		}

		PersonSet SundK = new PersonSet();
		PersonSet KaberNichtS = new PersonSet();
		PersonSet TvereinigtK = new PersonSet();

		PersonSet s = getPersonsFrom("./data/sportfreunde.txt");
		PersonSet k = getPersonsFrom("./data/kommilitonen.txt");
		PersonSet t = getPersonsFrom("./data/Personen.txt");
		
		SundK = s;
		SundK.retainAll(k);
		
		KaberNichtS = k;
		KaberNichtS.removeAll(s);
		
		TvereinigtK.addAll(t);
		TvereinigtK.addAll(k);
		
		printPersons(SundK, new PrintWriter(new DirtyFileWriter("./data/listen/SundK.txt"), true));
		printPersons(KaberNichtS, new PrintWriter(new DirtyFileWriter("./data/listen/KaberNichtS.txt"), true));
		printPersons(TvereinigtK, new PrintWriter(new DirtyFileWriter("./data/listen/TvereinigtK.txt"), true));
	}
}
