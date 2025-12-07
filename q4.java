/*
Problem Statement
Complete the Java code to raise an exception when the input age is either lower than the
age to vote or is higher than the age to appear for UPSC exams or both.
Class InvalidAgeException is a user-defined exception.
Class AgeExceptionTest has the following members:
• Static method isEligibletoVote(int age) that takes an age (as a int value) and
returns true if age >= 18.
• Static method isEligibletoWriteUPSC(int age) that takes an age (as a int value)
and returns true if age <= 32.

If age < 18 then the method should throw InvalidAgeException printing the mes-
sage: Invalid age to vote. Else, if age > 32, then the method should throw

InvalidAgeException printing the message Invalid age to write UPSC.
• main method that takes as input an age, invokes methods to check if a person of that
age is eligible to vote, and invokes another method to see if the person is eligible to
write the UPSC exams. If both are satisified, then it prints Eligible to vote and
to write UPSC.
What you have to do:
• Define a user-defined exception: InvalidAgeException
• Define method isEligibletoVote inside class InputExceptionTest
• Define method isEligibletoWriteUPSC inside class InputExceptionTest


Test Cases
Public test case 1 (Input):
10
Output:
Invalid age to vote

Test Cases
Public test case 2 (Input):
33
Output:
Invalid age to write UPSC
Private test case 1 (Input):
18
Output:
Eligible to vote and to write UPSC
Private test case 2 (Input):
43
Output:
Invalid age to write UPSC


Template Code
*/
import java.util.Scanner;

// DEFINE a user-defined exception: InvalidAgeException
class InvalidAgeException extends Exception{
    public InvalidAgeException(String msg){
        super(msg);
    }
}
public class q4 {

    // DEFINE method isEligibletoVote
    public static boolean isEligibletoVote(int age)throws InvalidAgeException{
        if (age<18){
            throw new InvalidAgeException("Invalid age to vote");
        }
        else return true;
    }
    // DEFINE method isEligibletoWriteUPSC
    public static boolean isEligibletoWriteUPSC(int age)throws InvalidAgeException{
        if (age>32) {
            throw new InvalidAgeException("Invalid age to write UPSC");
        }else return true;
    }

    public static void main(String[] args) {
        int age;
        Scanner sc = new Scanner(System.in);
        age = sc.nextInt();
        try {
            isEligibletoVote(age);
            isEligibletoWriteUPSC(age);
            System.out.println("Eligible to vote and to write UPSC");
        } catch (InvalidAgeException ie) {
            System.out.println(ie.getMessage());
        }
        sc.close();
    }
}
