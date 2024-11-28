package lab3.prob4;// package lesson3.labs.prob4;

public class Trailer extends Property {

    public Trailer(String address, String city) {
        super(address, city);
    }

    public Trailer() {
        this("Default Address", "Default city");
    }

    @Override
    public double computeRent() {
        return 500;
    }
}
