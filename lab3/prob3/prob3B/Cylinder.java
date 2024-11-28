package lab3.prob3.prob3B;

/**
 * The use of composition as shown here makes more sense and appropriate
 * because a cylinder "has a" circle as its base instead of a cylinder
 * "is a" circle relationship shown through inheritance in prob3A.
 * This design is more flexible and aligns with object-oriented principles.
 */
public class Cylinder {
    private Circle baseCircle;
    private double height;

    public Cylinder(double radius, double height) {
        this.baseCircle = new Circle(radius);
        this.height = height;
    }

    public double computeVolume() {
        return baseCircle.computeArea() * height;
    }

    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(5.0, 10.0);
        System.out.println("Volume of a cylinder which has a base circle: " + cylinder.computeVolume());
    }
}
