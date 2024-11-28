package lab3.prob4;

import java.util.List;

public class Admin {
    private static Admin instance;
    private final List<Property> properties;

    public Admin(List<Property> properties) {
        this.properties = properties;
    }


    public static Admin getInstance(List<Property> properties) {
        if ( instance == null ) {
            instance = new Admin(properties);
        }
        return instance;
    }

    public double computeTotalRent() {
        double totalRent = 0;

        for ( Property p : properties ) {
            totalRent += p.computeRent();
        }

        return totalRent;
    }

    public List<Property> getPropertiesByCity(String city) {
        properties.removeIf((value) -> !value.city.equals(city));
        return properties;
    }

}
