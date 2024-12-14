# Q5

```java

public class EmployeeInfoBetter {
	static enum SortMethod {BYNAME, BYSALARY};


	static class Pair<T,U>{
		T key;
		U value;

		public Pair(T key, U value) {
			this.key = key;
			this.value = value;
		}
	}


	Map<SortMethod,Pair<Function<Employee,Comparable>,Function<Employee,Comparable>>> map = new HashMap<>(); //that is one long type

	EmployeeInfoBetter(){
		map.put(SortMethod.BYNAME, new Pair<>(Employee::getName, Employee::getSalary));
		map.put(SortMethod.BYSALARY, new Pair<>(Employee::getSalary, Employee::getName));
	}

	public void sort(List<Employee> emps, final SortMethod method) {
			Pair<Function<Employee,Comparable>,Function<Employee,Comparable>> pair = map.get(method);
			Collections.sort(emps, Comparator.comparing(pair.key).thenComparing(pair.value));
	}



	public static void main(String[] args) {
		List<Employee> emps = new ArrayList<>();
		emps.add(new Employee("Joe", 100000));
		emps.add(new Employee("Tim", 50000));
		emps.add(new Employee("Rick", 50000));
		emps.add(new Employee("Andy", 60000));
		emps.add(new Employee("Tim", 10000));
		EmployeeInfoBetter ei = new EmployeeInfoBetter();
		ei.sort(emps, EmployeeInfoBetter.SortMethod.BYNAME);
		System.out.println(emps);
		//same instance
		ei.sort(emps, EmployeeInfoBetter.SortMethod.BYSALARY);
		//System.out.println(emps);
	}
}

```
