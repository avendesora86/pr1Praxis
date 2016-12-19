package pr1.a07;

import pr1.a06.Person;
import schimkat.berlin.lernhilfe2016ws.io.DirtyFileReader;
import schimkat.berlin.lernhilfe2016ws.io.DirtyFileWriter;
import schimkat.berlin.lernhilfe2016ws.objectPlay.PersonSet;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
//import schimkat.berlin.lernhilfe2016ws.objectPlay.Person;
//import schimkat.berlin.lernhilfe2016ws.objectPlay.PersonList;
//import schimkat.berlin.lernhilfe2016ws.objectPlay.PersonSet;

public class Personen {

	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out, true);
		// PersonSet ps = PersonFactory.createTestPersonSet();
		// for(Person p : ps){
		// System.out.println(p.toString());
		// }

//		ArrayList<Person> persons = createTestPersonListe();
//		persons.forEach(p -> System.out.println(p));
//		persons.sort(new YearComparator());
//		System.out.println();
//		persons.forEach(p -> System.out.println(p));

		ArrayList<Person> persons = createTestPersonListe();
		persons.forEach(p -> out.println(p));
		persons.sort(new NameComparator());
		out.println();
		persons.forEach(p -> out.println(p));
//		PrintWriter out = new PrintWriter(System.out, true);
//		 printPersons(createTestPersonListe(), out);
//		 printPersons(createTestPersonSet(), out);
//		 printPersons(createTestPersonSet(),
//		 "./data/Personen.txt");
//		aufgabeC(out);
	}

	public static void printPersons(ArrayList<Person> persons, PrintWriter out) {
		for (Person p : persons) {
			out.println(p.toString());
		}
	}

	public static void printPersons(HashSet<Person> persons, PrintWriter out) {
		for (Person p : persons) {
			out.println(p.toString());
		}
	}

	public static void printPersons(HashSet<Person> persons, String fileName) {
		printPersons(persons, new PrintWriter(new DirtyFileWriter(fileName), true));
	}

	public static Person createPerson(Scanner dataSource) {
		String vorname = "", nachname = "";
		int geburtsjahr = 0;

		vorname = dataSource.next();
		nachname = dataSource.next();
		geburtsjahr = dataSource.nextInt();

		Person p;
		if (!(vorname.equals("")) && !(nachname.equals("")) && (geburtsjahr != 0)) {
			p = new Person(vorname, nachname, geburtsjahr);
			return p;
		}
		return null;
	}

	public static ArrayList<Person> getPersonsFrom(Scanner dataSource) {
		ArrayList<Person> persons = new ArrayList<Person>();
		while (dataSource.hasNextLine()) {
			Person p = createPerson(new Scanner(dataSource.nextLine()));
			if (p != null) {
				persons.add(p);
			}
		}
		return persons;
	}

	public static ArrayList<Person> getPersonsFrom(String filename) {
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

		ArrayList<Person> SundK = new ArrayList<Person>();
		ArrayList<Person> KaberNichtS = new ArrayList<Person>();
		ArrayList<Person> TvereinigtK = new ArrayList<Person>();

		ArrayList<Person> s = getPersonsFrom("./data/sportfreunde.txt");
		ArrayList<Person> k = getPersonsFrom("./data/kommilitonen.txt");
		ArrayList<Person> t = getPersonsFrom("./data/Personen.txt");

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
	
	public static ArrayList<Person> createTestPersonListe(){
		ArrayList<Person> result = new ArrayList<Person>();
		schimkat.berlin.lernhilfe2016ws.objectPlay.Person[] persons =
				schimkat.berlin.lernhilfe2016ws.objectPlay.PersonFactory.createTestPersons();
		for (int i = 0; i<persons.length; i++){
			result.add(new Person (persons[i]));
		}
		return result;
	}
	
	public static HashSet<Person> createTestPersonSet(){
		HashSet<Person> result = new HashSet<Person>();
		PersonSet persons =
				schimkat.berlin.lernhilfe2016ws.objectPlay.PersonFactory.createTestPersonSet();
		for (schimkat.berlin.lernhilfe2016ws.objectPlay.Person p : persons){
			result.add(new Person (p));
		}
		return result;
	}
	
}
