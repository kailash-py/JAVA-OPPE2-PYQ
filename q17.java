/*Exception Handling
Q1.
Complete the Java program that, given a list of four applicants for a job, raises an exception if any applicant’s age is not within the prescribed age limit. For each applicant a, if a’s age is ≥ 18 and ≤ 30, then the program should print the name of a, otherwise it should print a custom message.

Class Applicant has/should have the following members:
Instance variables name and age
Constructor to initialize these variables
Method checkAndGetName should return the name of the applicant if the age is within the given limits. Otherwise, it should throw AgeOutOfBoundsException.
Class AgeOutOfBoundsException that defines a new checked exception.
Constructor AgeOutOfBoundsException(String n) that takes the name of the applicant as argument. The constructor initializes the error message as “Age of <name of the applicant> is outside the limits”.
Class ExceptionTest has the main method. It takes the name and age of four applicants as input, and invokes the method checkAndGetName in class Applicant to produce the output as specified.
Solution:
*/
import java.util.Scanner;
import java.util.ArrayList;

class Applicant {
    String name;
    int age;
    
    Applicant(String n, int a) {
        name = n;
        age = a;
    }
    
    public String checkAndGetName() throws AgeOutOfBoundsException{
        if (age>=18 && age<=30){
            return name;
        }else {
            throw new AgeOutOfBoundsException(name);
        }
    }
}

//Define class AgeOutOfBoundsException
class AgeOutOfBoundsException extends Exception{
    public AgeOutOfBoundsException(String n){
        super("Age of " + n + " is outside the limits");
    }
}

public class q17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Applicant> aList = new ArrayList<Applicant>();
        
        for (int i = 0; i < 4; i++) {
            Applicant a = new Applicant(sc.next(), sc.nextInt());
            aList.add(a);
        }
        
        for (Applicant a : aList) {
            try {
                String name = a.checkAndGetName();
                System.out.println(name);
            }
            catch (AgeOutOfBoundsException oe) {
                System.out.println(oe.getMessage());
            }
        }
        sc.close();
    }
}