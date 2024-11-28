package lab3.prob4;

import java.util.ArrayList;
import java.util.List;

public class Driver {

    public static void main(String[] args) {

        List<Property> properties = new ArrayList<>(List.of(
                new House(9000),
                new Condo(2),
                new Trailer()
        ));

        Admin admin = Admin.getInstance(properties);

        double totalRent = admin.computeTotalRent();
        System.out.println(totalRent);

        properties.addAll(List.of(
                new House("123 Abc Lane", "Austin", 1000),
                new Trailer("13 Abc Lane", "Austin"),
                new Trailer("13 Abc Lane", "San Jose"),
                new House("23 c Lane", "D.C.", 2000),
                new Trailer("12 bc Lane", "Austin")
        ));


        admin = Admin.getInstance(properties);

        List<Property> properties1 = admin.getPropertiesByCity("San Jose");

        properties1.forEach((System.out::println));
    }
}
