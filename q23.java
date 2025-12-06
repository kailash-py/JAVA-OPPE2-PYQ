/*Problem Statement
Complete the Java program that updates the vaccination status of the residents of a village
as "Partial" if only one dose has been taken, and "Complete" if both doses have been taken.
It should also print the list of senior citizens (aged 60 and above) who have been vaccinated
at least once.

• Class Citizen has / should have the following members:

Four instance variables: name, vacStatus, age, numDoses

Constructor to initialize these variables. Note that the vaccination status has to
be updated here, based on the number of doses.

Add mutator and accessor methods as needed

Overridden method toString to print the object.

• Class VaccineStream has the main method. It accepts the details of four citizens, and
invokes method geFilteredStream to filter the list based on the given constraints to
obtain the output list.

What you have to do
• Define an appropriate constructor and accessor methods in class Citizen
• Define method geFilteredStream in class VaccineStream


--- Template Code ---*/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.stream.*;

class Citizen {
private String name, vacStatus;
private int age, numDoses;

//Define an appropriate constructor and accessor methods
public Citizen(String n, int a, int doses){
    this.name=n;
    
    this.age=a;
    this.numDoses=doses;
    if (this.numDoses==1){ vacStatus= "Partial";}
    else if (this.numDoses==2){ vacStatus= "Complete";}
}


public int getAge(){
    return age;
}
public String getName(){
    return name;
}
public String getVacStatus(){
    return  vacStatus;
}

public String toString() {
    return name + ": " + vacStatus;
}
public int getNumDoses(){
    return numDoses;
}

}

public class q23 {
//Define method geFilteredStream
    public static Stream<Citizen> geFilteredStream(ArrayList<Citizen> cList){
        return cList.stream().filter(c -> c.getAge()>=60 & c.getNumDoses()>0);

    }

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<Citizen> citList = new ArrayList<Citizen>();
    Citizen c1;
    for (int i = 0; i < 4; i++) {
        c1 = new Citizen(sc.next(), sc.nextInt(), sc.nextInt());
        citList.add(c1);
    }
    
    List<Citizen> myList = geFilteredStream(citList).collect(Collectors.toList());
    
    for (Citizen c : myList) {
        System.out.println(c);
    }
    sc.close();
}


}


/*
--- Test Cases ---

Public test case 1:
Input:
Ram 12 1
Sita 60 2
Gita 65 2
Suresh 35 2

Output:
Sita: Complete
Gita: Complete

Public test case 2:
Input:
Jack 35 2
John 47 1
Lee 55 2
Sonu 67 1

Output:
Sonu: Partial*/