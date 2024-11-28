package lab3.prob4;// package lesson3.labs.prob4;

public class Condo extends Property {

    private int numberOfFloors;

    public Condo(String address, String city, int numberOfFloors) {
        super(address, city);
        this.numberOfFloors = numberOfFloors;
    }

    public Condo(int numberOfFloors) {
        this("Default Address", "Default city", numberOfFloors);
    }

    @Override
    public double computeRent() {
        return 500 * numberOfFloors;
    }
}
