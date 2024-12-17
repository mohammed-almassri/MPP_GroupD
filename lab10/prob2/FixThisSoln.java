package lab10.prob2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FixThisSoln {

    /* This method processes the list and handles exceptions */
    List<String> processList(List<String> list) {
        return list.stream()
                .map(x -> {
                    try {
                        return doNothingIfShort(x);
                    } catch (InputTooLongException e) {
                        throw new RuntimeException(e); // Wrap checked exception as RuntimeException
                    }
                })
                .collect(Collectors.toList());
    }

    /* This method throws InputTooLongException if the string is longer than 3 */
    String doNothingIfShort(String input) throws InputTooLongException {
        if (input.length() > 3) throw new InputTooLongException();
        else return input;
    }

    public static void main(String[] args) {
        FixThisSoln ft = new FixThisSoln();

        List<String> words1 = Arrays.asList("not", "too", "big", "yet");
        System.out.println(ft.processList(words1)); // Expected output: [not, too, big, yet]

        List<String> words2 = Arrays.asList("not", "too", "big", "yeti");
        System.out.println(ft.processList(words2)); // Expected to throw a RuntimeException
    }

    /* Custom Exception for InputTooLong */
    class InputTooLongException extends Exception {
        private static final long serialVersionUID = 1L;

        public InputTooLongException() {
            super("Must be length 3 or less");
        }

        public InputTooLongException(String s) {
            super(s);
        }

        public InputTooLongException(Throwable t) {
            super(t);
        }
    }
}

