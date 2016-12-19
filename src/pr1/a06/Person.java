package pr1.a06;

public class Person {

	private String vorname;
	private String nachname;
	private int geburtsjahr;

	public Person(String vorname, String nachname, int geburtsjahr) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.geburtsjahr = geburtsjahr;
	}

	public Person(Person person) {

		this(person.getVorname(), person.getNachname(), person.getGeburtsjahr());
	}
	
	public Person (schimkat.berlin.lernhilfe2016ws.objectPlay.Person person){
		this(person.getVorname(), person.getNachname(), person.getGeburtsjahr());
	}

	public String getVorname() {
		return vorname;
	}

	public String getNachname() {

		return nachname;
	}

	public int getGeburtsjahr() {

		return geburtsjahr;
	}

	public String toString() {
		return String.format("Person: %1$s %2$s - %3$d", vorname, nachname, geburtsjahr);
	}


	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + geburtsjahr;
		result = prime * result + ((nachname == null) ? 0 : nachname.hashCode());
		result = prime * result + ((vorname == null) ? 0 : vorname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (geburtsjahr != other.geburtsjahr)
			return false;
		if (nachname == null) {
			if (other.nachname != null)
				return false;
		} else if (!nachname.equals(other.nachname))
			return false;
		if (vorname == null) {
			if (other.vorname != null)
				return false;
		} else if (!vorname.equals(other.vorname))
			return false;
		return true;
	}
	
	
}
