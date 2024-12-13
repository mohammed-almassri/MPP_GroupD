```Java
import java.util.function.Supplier;

public class MethodReferenceExample {
    public static void main(String[] args) {
        // i. Rewrite method reference as a lambda expression
        Supplier<Double> randomLambda = () -> Math.random();
        System.out.println("Random number using lambda: " + randomLambda.get());

        // ii. Use method reference in the main method
        Supplier<Double> randomMethodRef = Math::random;
        System.out.println("Random number using method reference: " + randomMethodRef.get());

        // iii. Inner class implementation
        class RandomSupplier implements Supplier<Double> {
            @Override
            public Double get() {
                return Math.random();
            }
        }

        Supplier<Double> randomInnerClass = new RandomSupplier();
        System.out.println("Random number using inner class: " + randomInnerClass.get());
    }
}
