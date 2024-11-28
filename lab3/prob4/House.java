package lab3.prob4;// package lesson3.labs.prob4;

public class House extends Property {

    private double lotSize;

    public House(String address, String city, double lotSize) {
        super(address, city);
        this.lotSize = lotSize;
    }

    public House(double lotSize) {
        this("Default Address", "Default city", lotSize);
    }


    @Override
    public double computeRent() {
        return 0.1 * lotSize;
    }
}
