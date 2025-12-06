/*Q3. Write a program to clone an object e1 of class Employee by implementing the interface Cloneable. After cloning, update the department and the address of e1. Complete the program as detailed below to achieve this functionality.

Define classes Address and Department that implement the interface Cloneable, and have the following members:

In both classes, add an instance variable of String type (to store the address and the department respectively)
Implement the required constructor(s) and accessors.
Override the method clone.
Define a class Person that implements the interface Cloneable, and has the following members:

Instance variables name of type String and addr of type Address
Implement the required constructor(s) and accessors
Override the method clone
Define a class Employee that implements the interface Cloneable, extends the class Person, and has the following members:

Instance variable dept of type Department
Implement the required constructor(s) and accessors.
Override the method clone.
Define a method updateEmp to update the dept and addr of an Employee object
Solution:*/

import java.util.*;

// Class Address implements Cloneable
class Address implements Cloneable {
    private String addr;

    public Address(String addr) {
        this.addr = addr;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public Address clone() throws CloneNotSupportedException{
        return (Address)super.clone();
    }

    public String toString() {
        return addr;
    }
}

// Class Department implements Cloneable
class Department implements Cloneable {
    private String dept;

    public Department(String dept) {
        this.dept = dept;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public Department clone() throws CloneNotSupportedException{
        return (Department)super.clone();
    }

    public String toString() {
        return dept;
    }
}

// Class Person implements Cloneable
class Person implements Cloneable {
    private String name;
    private Address addr;

    public Person(String name, Address addr) {
        this.name = name;
        this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }

    @Override
    public Person clone() throws CloneNotSupportedException{
        Person clone_=(Person)super.clone();
        clone_.addr=addr.clone();
        return clone_;
    }

    public String toString() {
        return name + ", " + addr;
    }
}

// Class Employee extends Person
class Employee extends Person implements Cloneable {
    private Department dept;

    public Employee(String name, Address addr, Department dept) {
        super(name, addr);
        this.dept = dept;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public void updateEmp(String newAddr, String newDept) {
        getAddr().setAddr(newAddr);
        dept.setDept(newDept);
    }

    @Override
    public Employee clone() throws CloneNotSupportedException{
        Employee clone_= (Employee)super.clone();
        clone_.dept=dept.clone();
        return clone_;
    }

    public String toString() {
        return super.toString() + ", " + dept;
    }
}

// Main class
public class q15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();     // name
        String a1 = sc.next();    // address
        String d1 = sc.next();    // department
        String a2 = sc.next();    // new address
        String d2 = sc.next();    // new department

        try {
            Employee e1 = new Employee(n, new Address(a1), new Department(d1));
            Employee e2 = e1.clone(); // deep clone
            e1.updateEmp(a2, d2);     // update only e1
            System.out.println(e1 + ", " + e2);
        } catch (CloneNotSupportedException e) {
            System.out.println("clone() not supported");
        }
    }
}