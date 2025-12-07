/* 
Cloning
Q1.
In an athletic meet, the athletes from each school should register for 1 relay event and 2 individual events. Complete the Java program that does the following: create a dummy athlete object, create object a1 of type Athlete by cloning the dummy athlete object, create another object a2 of type Athlete by cloning a1, and then update the chest number, and individual events of a1 and a2.

Class Athlete has/should have the following functionality:

Implements the interface Cloneable
Instance variables
String athleteChestNum to store the athlete chest number
ArrayList<String> events whose first element is the relay
event which is common for all the athletes, the second element is the
first individual event and the third element is the second
individual event
Constructor to initialize the instance variables
Mutator methods to update athleteChestNum and the individual events
Overridden method toString()
Implement method clone()
Class AthleteCloneTest contains the main method that takes the inputs and invokes appropriate methods to achieve the functionality.

*/

import java.util.*;
import jdk.jfr.Event;
// import java.util.Scanner;

class Athlete implements Cloneable {
    private String athleteChestNum;
    private ArrayList<String> events;

    public Athlete() {
        athleteChestNum = "000";
        events = new ArrayList<String>();
        events.add("Relay");       // index 0
        events.add("Ind Evt 1");   // index 1
        events.add("Ind Evt 2");   // index 2
    }

    // Mutator method to set chest number
    public void setAthleteChestNum(String num) {
        this.athleteChestNum = num;
    }

    // Mutator to update individual event 1 (index 1)
    public void setIndividualEvt1(String evt1) {
        events.set(1, evt1);
    }

    // Mutator to update individual event 2 (index 2)
    public void setIndividualEvt2(String evt2) {
        events.set(2, evt2);
    }

    // Deep cloning method
    public Athlete clone() throws CloneNotSupportedException{
        Athlete clone_ = (Athlete)super.clone();
        clone_.events= (ArrayList<String>) events.clone();
        return clone_;
    }


    // Print object
    public String toString() {
        return athleteChestNum + " " + events;
    }
}

public class q13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Athlete dummyAthlete = new Athlete();

        try {
            Athlete a1 = (Athlete) dummyAthlete.clone();
            a1.setAthleteChestNum(sc.next());
            a1.setIndividualEvt1(sc.next());
            a1.setIndividualEvt2(sc.next());

            Athlete a2 = (Athlete) a1.clone();
            a2.setAthleteChestNum(sc.next());
            a2.setIndividualEvt1(sc.next());
            a2.setIndividualEvt2(sc.next());

            System.out.println("a1 " + a1);
            System.out.println("a2 " + a2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}