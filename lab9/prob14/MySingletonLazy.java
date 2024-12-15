package lab9.prob14;

import java.util.Optional;

public class MySingletonLazy {
    private static Optional<MySingletonLazy> instance = Optional.ofNullable(null);

    private MySingletonLazy() {
    }

    public static MySingletonLazy getInstance() {
        instance = instance.or(() -> Optional.of(new MySingletonLazy()));
        return instance.get();
    }

    public static void main(String[] args) {
        // Testing the singleton
        MySingletonLazy obj1 = MySingletonLazy.getInstance();
        MySingletonLazy obj2 = MySingletonLazy.getInstance();

        // Confirming that both references point to the same instance
        System.out.println("Are obj1 and obj2 the same instance? " + (obj1 == obj2));
    }
}
