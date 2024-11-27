package prob2A;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Olatunji Oye");
        System.out.println("Student Name: " + student.getName());
        System.out.println("GradeReport belongs to: " + student.getGradeReport().getStudent().getName());
    }
}