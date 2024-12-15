package lesson9.labs.prob12;

import lesson9.labs.prob11a.TriFunction;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdaLibrary {
    public static final Function<List<Employee>, List<String>> EMPLOYEES_AFTER = (list) ->
            list.stream()
                    .filter(e -> e.getSalary() > 100000)
                    .filter(e -> e.getLastName().charAt(0) > 'E')
                    .map(e -> e.getFirstName() + " " + e.getLastName())
                    .sorted().toList();

    public static final Function<List<Employee>, List<String>> EMPLOYEES_FULL = (list) ->
            list.stream()
                    .filter(e -> e.getSalary() > 85000)
                    .filter(e -> e.getFirstName().charAt(0) > 'R')
                    .map(e -> e.getFirstName().toUpperCase() + " " + e.getLastName().toUpperCase())
                    .sorted().toList();
}
