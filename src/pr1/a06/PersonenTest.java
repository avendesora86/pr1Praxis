package pr1.a06;

import java.io.PrintWriter;

//import schimkat.berlin.lernhilfe2016ws.objectPlay.Person;

public class PersonenTest {

	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out, true);
		
		Person person = new Person("Benjamin", "Blümchen", 1986);
		Person person1 = new Person(person);
		Person person2 = new Person(schimkat.berlin.lernhilfe2016ws.objectPlay.PersonFactory.createTestPersons()[0]);
		
		out.println(person);
		out.println(person1);		
		out.println(person2);
	}

}
