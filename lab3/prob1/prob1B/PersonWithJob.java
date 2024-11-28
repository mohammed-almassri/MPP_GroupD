package lesson3.labs.prob1;

/**
 * By using composition, we can restructure the PersonWithJob class
 * to contain a Person object as a member. This approach enables us to separate
 * the comparison of the Person objects from the comparison of their salaries.
 * This modular design simplifies the equality check and enhances code readability.
 */
public class PersonWithJob {

	private Person person;
	
	private double salary;
	
	public double getSalary() {
		return salary;
	}

	public Person getPerson() {
		return person;
	}

	PersonWithJob(String n, double s) {
		this.person = new Person(n);
		salary = s;
	}
	
	@Override
	public boolean equals(Object aPerson) {
		if(aPerson == null) return false; 
		if(!(aPerson instanceof PersonWithJob p)) return false;
        return this.getPerson().equals(p.getPerson()) &&
				this.getSalary()==p.getSalary();
	}
	public static void main(String[] args) {
		PersonWithJob p1 = new PersonWithJob("Joe", 30000);
		Person p2 = new Person("Joe");
		//As PersonsWithJobs, p1 should be equal to p2
		System.out.println("p1.equals(p2)? " + p1.getPerson().equals(p2));
		System.out.println("p2.equals(p1)? " + p2.equals(p1.getPerson()));
	}


}
