package lab9.prob9;

import java.util.stream.IntStream;

import static java.lang.Math.sqrt;

public class Main {
    public static void main(String[] args) {
        printSquares(8);
    }

    /**
     * Implement a method
     * which creates an IntStream using the iterate method. The method prints to the console the
     * first num squares. For instance, if num = 4, then your method would output 1, 4, 9, 16. Note:
     * You will need to come up with a function to be used in the second argument of iterate. Do
     * not use the map or filter operations on Stream.
     */

    public static void printSquares(int num) {

        IntStream.iterate(1, n -> n + (2 * (int) sqrt(n) + 1))
                .limit(num)
                .forEach(System.out::println);

    }
}
