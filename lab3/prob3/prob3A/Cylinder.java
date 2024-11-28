package lab3.prob3.prob3A;

/**
 * Explanation: The use of inheritance kind of make sense if we are considering
 * cylinder as an extension of circle. However, a cylinder is not a type of circle
 * and also, it is a 3D while a circle is 2D. Hence, the use of inheritance is
 * probably not ideal from a design perspective. Using composition is a better
 * approach as shown in prob3B
 */
public class Cylinder extends Circle {
    private double height;

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public double computeVolume() {
        return computeArea() * height;
    }

    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(5.0, 10.0);
        System.out.println("Volume of a cylinder which is an extension of a circle: " + cylinder.computeVolume());
    }
}
