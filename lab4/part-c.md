# Q3

```
Main.java
```

```java
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Salaried salariedEmployee = new Salaried(5000);
        System.out.println("Salaried Employee:");
        Paycheck salariedPaycheck = salariedEmployee.calcCompensation(11, 2024);
        salariedPaycheck.print();

        Hourly hourlyEmployee = new Hourly(20, 40);
        System.out.println("Hourly Employee:");
        Paycheck hourlyPaycheck = hourlyEmployee.calcCompensation(11, 2024);
        hourlyPaycheck.print();

        Commissioned commissionedEmployee = new Commissioned(0.1, 2000);

        commissionedEmployee.addOrder(new Order("O001", LocalDate.of(2024, 11, 5), 500));
        commissionedEmployee.addOrder(new Order("O002", LocalDate.of(2024, 11, 15), 1000));
        commissionedEmployee.addOrder(new Order("O003", LocalDate.of(2024, 10, 25), 1500));

        System.out.println("Commissioned Employee:");
        Paycheck commissionedPaycheck = commissionedEmployee.calcCompensation(11, 2024);
        commissionedPaycheck.print();
    }
}
```

```
Employee.java
```

```java
public abstract class Employee {
    String empId;

    public void print(){
        System.out.println("Employee ID: " + empId);
    }

    public Paycheck calcCompensation(int month, int year){
        double gross = this.calcGrossPay(month, year);
        return new Paycheck(
                gross,gross*0.23,gross*.05,gross*.01,gross*.03,gross*.075
        );
    }

    public abstract double calcGrossPay(int month, int year);
}
```

```
Hourly.java
```

```java
public class Hourly extends Employee {
    private double hourlyWage;
    private double hoursPerWeek;

    public Hourly(double hourlyWage, double hoursPerWeek) {
        this.hourlyWage = hourlyWage;
        this.hoursPerWeek = hoursPerWeek;
    }

    @Override
    public double calcGrossPay(int month, int year) {
        return hourlyWage * hoursPerWeek * 4;
    }
}
```

```
Salaried.java
```

```java
public class Salaried extends Employee {
    private double salary;

    public Salaried(double salary) {
        this.salary = salary;
    }

    @Override
    public double calcGrossPay(int month, int year) {
        return this.salary;
    }
}
```

```
Commissioned.java
```

```java
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Commissioned extends Employee {

    private double commission;
    private double baseSalary;
    private List<Order> orders;

    public Commissioned(double commission, double baseSalary) {
        this.commission = commission;
        this.baseSalary = baseSalary;
        this.orders = new ArrayList<Order>();
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public double calcGrossPay(int month, int year) {
        double ret = this.baseSalary;

        List<Order> lastMonthOrders = this.orders.stream()
                .filter((Order o) -> {
                    int orderMonth = o.getOrderDate().getMonthValue();
                    int orderYear = o.getOrderDate().getYear();
                    return orderMonth == month && orderYear == year;
                })
                .collect(Collectors.toList());

        for (Order order : lastMonthOrders) {
            ret += order.getOrderAmount() * this.commission;
        }

        return ret;
    }

}
```

```
Order.java
```

```java
import java.time.LocalDate;
import java.util.Date;

public class Order {
    private String orderNo;
    private LocalDate orderDate;
    private double orderAmount;

    public Order(String orderNo, LocalDate orderDate, double orderAmount) {
        this.orderNo = orderNo;
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public double getOrderAmount() {
        return orderAmount;
    }
}
```

```
Paycheck.java
```

```java
public class Paycheck {
    private double grossPay,fica,state,local,medicare,socialSecurity;

    public Paycheck(double grossPay, double fica, double state, double local, double medicare, double socialSecurity) {
        this.grossPay = grossPay;
        this.fica = fica;
        this.state = state;
        this.local = local;
        this.medicare = medicare;
        this.socialSecurity = socialSecurity;
    }

    public void print(){
        System.out.println("net pay: "+getNetPay());
    }

    public double getNetPay(){
        return grossPay - fica - state - medicare - socialSecurity - local;
    }
}
```
