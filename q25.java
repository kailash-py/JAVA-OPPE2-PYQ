/*
        This is not a question, Practice for different Collectors Methods
 */
import java.util.*;
import java.util.stream.*;

class Employee {
    String name;
    String dept;
    int salary;

    Employee(String name, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public String getDept() { return dept; }
    public int getSalary() { return salary; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return name + " : " + dept + " : " + salary;
    }
}

public class q25 {
    public static void main(String[] args) {
        List<Employee> eList = Arrays.asList(
            new Employee("Jack", "HR", 30000),
            new Employee("Aria", "HR", 40000),
            new Employee("Nora", "IT", 50000),
            new Employee("Bella", "IT", 60000),
            new Employee("Jacob", "IT", 70000),
            new Employee("James", "HR", 80000)
        );

        // 1. toList
        List<Employee> list= eList.stream().collect(Collectors.toList());

        // 2. toSet
        Set<String>depts=eList.stream().map(Employee::getDept).collect(Collectors.toSet());

        // 3. toMap
        Map<String,Integer> nameToSalary=eList.stream().collect(Collectors.toMap(Employee::getName,Employee::getSalary));

        // 4. groupingBy
        Map<String, List<Employee>>byDept= eList.stream().collect(Collectors.groupingBy(Employee::getDept));

        // 5. groupingBy with downstream (counting)
        Map<String,Long> countByDept=eList.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.counting()));

        // 6. partitioningBy
        Map<Boolean, List<Employee>> partition = eList.stream().collect(Collectors.partitioningBy(e->e.getSalary()>50000));

        // 7. counting
        long totalEmployees= eList.stream().collect(Collectors.counting());

        // 8. summingInt
        int totalSalary = eList.stream().collect(Collectors.summingInt(Employee::getSalary));

        // 9. minBy
        Optional<Employee> minSalaryEmp = eList.stream()
            .collect(Collectors.minBy(Comparator.comparingInt(Employee::getSalary)));

        // 10. maxBy
        Optional<Employee> maxSalaryEmp = eList.stream()
            .collect(Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)));

        // 11. summarizingInt
        // IntSummaryStatistics salaryStats = eList.stream()
        //     .collect(Collectors.summarizingInt(Employee::getSalary));
        IntSummaryStatistics salaryStats=eList.stream().collect(Collectors.summarizingInt(Employee::getSalary));

        // 12. joining
        // String allNames = eList.stream()
        //     .map(Employee::getName)
        //     .collect(Collectors.joining(", "));
        String allNames = eList.stream().map(Employee::getName).collect(Collectors.joining(", "));

        // Print results
        System.out.println("toList: " + list);
        System.out.println("toSet: " + depts);
        System.out.println("toMap: " + nameToSalary);
        System.out.println("groupingBy: " + byDept);
        System.out.println("groupingBy + counting: " + countByDept);
        System.out.println("partitioningBy: " + partition);
        System.out.println("counting: " + totalEmployees);
        System.out.println("summingInt: " + totalSalary);
        System.out.println("minBy: " + minSalaryEmp.orElse(null));
        System.out.println("maxBy: " + maxSalaryEmp.orElse(null));
        System.out.println("summarizingInt: " + salaryStats);
        System.out.println("joining: " + allNames);
    }
}
