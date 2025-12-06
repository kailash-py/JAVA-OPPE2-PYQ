/*Q2.
Complete the Java program to create two objects a1 and a2 of type Airplane. a2 should be created from a1 using cloning such that any later changes to a2 do not affect a1.

• Class Airplane implements Cloneable interface and has/should have the following members:

– Instance variables String company, eng of type Engine, and
String model
– Constructor to initialize the instance variables
– Mutator methods as needed
– Overridden method toString()
– Implement method clone() that achieves deep copy using cloning

• Class Engine implements Cloneable interface and has/should have the following members:

– Instance variables String name and int numEngines
– Constructor to initialize the instance variables
– Mutator methods as needed
– Overridden method toString()
– Implement method clone()

• Class AirplaneCloneTest contains the main method that takes the inputs and invokes appropriate methods to achieve the functionality.

What you have to do

• Implement method clone() in class Airplane

• Implement method clone() in class Engine

Solution:*/

import java.util.Scanner;

class Airplane implements Cloneable {
    private String company;
    private String model;
    private Engine eng;

    public Airplane(String c, String m, Engine e) {
        company = c;
        model = m;
        eng = e;
    }

    public String toString() {
        return company + ": " + model + eng;
    }

    public void setEngine(String n, int num) {
        eng.setName(n);
        eng.setNumEngines(num);
    }

    public void setModel(String m) {
        model = m;
    }

    // ✅ Deep clone
    public Airplane clone() throws CloneNotSupportedException{
        Airplane clone_= (Airplane)super.clone();
        clone_.eng= eng.clone();
        return clone_;
    }
}

class Engine implements Cloneable {
    private String name;
    private int numEngines;

    public Engine(String n, int num) {
        name = n;
        numEngines = num;
    }

    public void setName(String n) {
        name = n;
    }

    public void setNumEngines(int n) {
        numEngines = n;
    }

    public String toString() {
        return "[" + name + ", " + numEngines + "]";
    }

    // ✅ Deep clone for Engine
    public Engine clone() throws CloneNotSupportedException{
        return (Engine)super.clone();
    }
}

public class q14 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner sc = new Scanner(System.in);

        // Create object a1
        Airplane a1 = new Airplane(
            sc.nextLine(),     // company
            sc.next(),         // model
            new Engine(sc.next(), sc.nextInt()) // engine name, number
        );

        // Clone a1 to a2
        Airplane a2 = a1.clone();

        sc.nextLine(); // consume newline
        a2.setModel(sc.next());               // update model of a2
        a2.setEngine(sc.next(), sc.nextInt()); // update engine of a2

        System.out.println(a1); // a1 should be unchanged
        System.out.println(a2); // a2 reflects new model and engine

        sc.close();
    }
}