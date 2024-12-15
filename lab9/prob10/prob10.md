# Q10

### A

**_What happens when the following code is executed?_**

```java
public static void main(String[] args) {
IntStream ones = IntStream.generate(() -> 1).distinct();
ones.forEach(System.out::println);
}
```

#### answer

The `forEach()` method will print the value 1 to the console and then the program will hang indefinitely. this is because the `distinct()` method is an intermediate operation that will keep track of the elements that have been seen so far and will not allow duplicates to pass through. Since the `generate()` method will keep generating the value 1, the `distinct()` method will keep track of the value 1 and will not allow it to pass through. This will cause the `forEach()` method to hang indefinitely.

#### fix:

```java
IntStream ones = IntStream.generate(() -> 1).distinct().limit(1);
```

the `limit(1)` method will limit the stream to only one element and the `forEach()` method will print the value 1 to the console and then the program will terminate.

---

### B

**_You have a Stream of Strings called stringStream consisting of the values “Bill”,
“Thomas”, and “Mary”. Write the one line of code necessary to print this stream to the
console so that the output looks like this:
Bill, Thomas, Mary_**

#### answer

```java
stringStream.collect(Collectors.joining(", "));
```

---

### C

**_You have a Stream of Integers called myIntStream and you need to output both the
maximum and minimum values somehow, making use of this stream only once. Write
compact code that efficiently accomplishes this._**

#### answer

```java
    int[] minMax = myIntStream
                .collect(() -> new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE },
                        (a, b) -> {
                            a[0] = Math.min(a[0], b);
                            a[1] = Math.max(a[1], b);
                        },
                        (a, b) -> {
                            a[0] = Math.min(a[0], b[0]);
                            a[1] = Math.max(a[1], b[1]);
                        });

        System.out.println("Min: " + minMax[0]);
        System.out.println("Max: " + minMax[1]);
```
