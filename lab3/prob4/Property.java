package lab3.prob4;

import java.time.LocalDateTime;

abstract class Property {

    public double id;
    public String address;
    public String city;


    public Property(String address, String city) {
        this.address = address;
        this.city = city;
        this.id = (this.address.hashCode() + LocalDateTime.now().hashCode());
    }

    public abstract double computeRent();

}
