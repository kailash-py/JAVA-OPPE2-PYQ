/* 0.3
 Streams
 Problem Statement
 Complete the Java program that, given a list of students, prints the list of students who are
 eligible for a scholarship. These include the students with an average CGPA > 7.5 and whose
 annual family income is less than |1,00,000. The program should also update the scholarship
 status of eligible students as b grade-1 scholarshipb  if their average CGPA is > 9.0; otherwise,
 the scholarship status should be updated as b grade-2 scholarshipb .
 b " Class Student has the following members:b  Four instance variables: name, scholarshipStatus, avgCGPA, incomeb  Aconstructor to initialize these instance variablesb  Mutator and accessor methods as neededb  Overridden method toString to print the object.
 b " Class StreamsTest has / should have the following members:b  Methodmainthataccepts the details of four students, calls method getEligibleStream
 and prints the output list.b  Method getEligibleStream that accepts a list of students, filters the students
 eligible for scholarship, and returns a stream of eligible students.b  Method updateScholarshipStatus that accepts the list of eligible students and
 update their scholarship status.
 What you have to do
 b " Define method getEligibleStream in class StreamsTest
 b " Define method updateScholarshipStatus in class StreamsTest */

 import java.util.ArrayList;
 import java.util.Scanner;
 import java.util.List;
 import java.util.stream.*;
 class Student {
     private String name, scholarshipStatus;
     private double avgCGPA, income;
     public Student(String n, double a, double i) {
         name = n;
         avgCGPA = a;
         income = i;
         
         scholarshipStatus = "not eligible";
     }
     public String toString() {
         return name + " : " + avgCGPA + " : "
                + income + " : " + scholarshipStatus;
     }
     public double getAvgCGPA() {
         return avgCGPA;
     }
     public double getIncome() {
         return income;
     }
     public void setScholarshipStatus(String ss) {
         scholarshipStatus = ss;
     }
 }
 public class q3 {
 //Define method getEligibleStream here
     public static Stream<Student> getEligibleStream (ArrayList<Student> sList){ 
         Stream<Student> sStream = sList.stream().filter((s)->(s.getAvgCGPA())>7.5 
                                     && s.getIncome()<100000);
         return sStream;
         
     }
 //Define method updateScholarshipStatus here
     public static void updateScholarshipStatus(List<Student> eList){
         for (Student s : eList){
             if (s.getAvgCGPA() > 9){
                 s.setScholarshipStatus("grade-1 scholarship");
             }else{
             s.setScholarshipStatus("grade-2 scholarship");
             }
         }
     }
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         ArrayList<Student> sList = new ArrayList<Student>();
         Student s;
         for (int i = 0; i < 4; i++) {
             s = new Student(sc.next(), sc.nextDouble(), sc.nextDouble());
             sList.add(s);
         }
         List<Student> eList =
             getEligibleStream(sList).collect(Collectors.toList());
         updateScholarshipStatus(eList);
         for (Student es : eList)
             System.out.println(es);
         sc.close();
     }
 }
 
 /*
 Public test case 1:
 Input:
 geet 9.5 80000
 preet 8 90000
 Page 14
 ravi 7 80000
 kumar 8.5 200000
 Output:
 geet : 9.5 : 80000.0 : grade-1 scholarship
 preet : 8.0 : 90000.0 : grade-2 scholarship */