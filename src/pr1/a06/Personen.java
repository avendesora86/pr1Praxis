package pr1.a06;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;

import schimkat.berlin.lernhilfe2016ws.io.DirtyFileReader;
import schimkat.berlin.lernhilfe2016ws.io.DirtyFileWriter;
import schimkat.berlin.lernhilfe2016ws.objectPlay.PersonSet;
//import schimkat.berlin.lernhilfe2016ws.objectPlay.Person;
//import schimkat.berlin.lernhilfe2016ws.objectPlay.PersonList;
//import schimkat.berlin.lernhilfe2016ws.objectPlay.PersonSet;

public class Personen {

	public static void main(String[] args) {
		// PersonSet ps = PersonFactory.createTestPersonSet();
		// for(Person p : ps){
		// System.out.println(p.toString());
		// }
		PrintWriter out = new PrintWriter(System.out, true);
		 printPersons(createTestPersonListe(), out);
		 printPersons(createTestPersonSet(), out);
		 printPersons(createTestPersonSet(),
		 "./data/Personen.txt");
		aufgabeC(out);
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

	public static HashSet<Person> getPersonsFrom(Scanner dataSource) {
		HashSet<Person> persons = new HashSet<Person>();
		while (dataSource.hasNextLine()) {
			Person p = createPerson(new Scanner(dataSource.nextLine()));
			if (p != null) {
				persons.add(p);
			}
		}
		return persons;
	}

	public static HashSet<Person> getPersonsFrom(String filename) {
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

		HashSet<Person> SundK = new HashSet<Person>();
		HashSet<Person> KaberNichtS = new HashSet<Person>();
		HashSet<Person> TvereinigtK = new HashSet<Person>();

		HashSet<Person> s = getPersonsFrom("./data/sportfreunde.txt");
		HashSet<Person> k = getPersonsFrom("./data/kommilitonen.txt");
		HashSet<Person> t = getPersonsFrom("./data/Personen.txt");
		
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
