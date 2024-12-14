## Question 4

```java
import java.util.stream.Stream;

public class Main {

    private static boolean isPrime(int prime) {
        if (prime < 2) return false;
        if (prime == 2 || prime == 3) return true;
        if (prime % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(prime); i += 2) {
            if (prime % i == 0) return false;
        }
        return true;
    }

    private static int nextPrime(int prime) {
        for (int i = prime + (prime % 2 == 0 ? 1 : 2); ; i += 2) {
            if (isPrime(i)) return i;
        }
    }

    private void printFirstNPrimes(long n) {
        final Stream<Integer> primes = Stream.iterate(2, Main::nextPrime);

        primes.limit(n)
              .forEach(System.out::println);
    }

    public static void main(String[] args) {
        Main ps = new Main();
        ps.printFirstNPrimes(10);
        System.out.println("====");
        ps.printFirstNPrimes(5);
    }
}
```

## Output

```java
2
3
5
7
11
13
17
19
23
29
====
2
3
5
7
11
```
