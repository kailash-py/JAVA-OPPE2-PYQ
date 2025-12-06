/*Problem Statement

Write a program that, given a list of students belonging to a set of schools, 
finds the highest scoring girl student studying in government schools using Java Streams.
Class School has the following members:
name variable stores the name of the school.

govt_school variable is true if the school is a government school, else it is false.
isGovt() method returns the value of variable govt_school.

Class Student has the following members:
roll_num is a unique string identifier for each student.
girl is a boolean variable which stores true if it is a girl, else false.

marks stores the marks of the student.
myschool is a School object storing the student’s school details.
Method isGirl() returns the value of variable girl.
Method getSchool() returns the myschool object for that student.
Method compareTo() compares two students based on their marks.

Class SClass has the following members:
main method does the following:

It initializes three school objects: "SPBB" (Govt), "PSBB" (Private), "BSPP" (Govt).
It takes as input details of 6 students (Name/Roll, isGirl, School Name, Marks).
It passes the list to findStudent method.

findStudent(ArrayList<Student> sList) method should convert sList into a stream, 
find the highest scoring student among all the girls studying in government schools,
 and store the value inside an Optional variable named highest_score_girl.
Assume that roll_num is unique among all the schools. Further, there is either none or only one highest scoring girl in the list.

What you have to do

Define method compareTo in class Student.

Define method findStudent in class SClass.


---Template Code---*/


import java.util.*;

class School {
    private String name;
    private boolean govt_school;

    public School(String name, boolean govt) {
        this.name = name;
        this.govt_school = govt;
    }

    public boolean isGovt() {
        return govt_school;
    }
}

class Student implements Comparable<Student> {
    private String roll_num;
    private boolean girl;
    private int marks;
    private School myschool;

    public Student(String r, boolean g, School s, int m) {
        roll_num = r;
        girl = g;
        myschool = s;
        marks = m;
    }

    public boolean isGirl() {
        return girl;
    }

    public School getSchool() {
        return myschool;
    }
    
    public String toString() {
        return roll_num;
    }

    // Define compareTo method
    public int compareTo(Student other) {
        // if (this.marks>other.marks) return 1;
        // else if (this.marks<other.marks) return -1;
        // else return 0;
        return this.marks-other.marks;
    }
}

public class q22 {
    
    // Define findStudent method
    public static Optional<Student> findStudent(ArrayList<Student> sList) {
        return sList.stream().filter(s -> s.isGirl() && s.getSchool().isGovt()).max((s1,s2)->s1.compareTo(s2));
        // return sList.stream().filter(s-> s.isGirl() && s.getSchool().isGovt()).max(Student::compareTo);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        School s1 = new School("SPBB", true);
        School s2 = new School("PSBB", false);
        School s3 = new School("BSPP", true);
        
        // Map to easily retrieve school objects by name
        Map<String, School> schools = new HashMap<>();
        schools.put("SPBB", s1);
        schools.put("PSBB", s2);
        schools.put("BSPP", s3);

        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            String name = sc.next();
            boolean isGirl = sc.nextBoolean();
            String sName = sc.next();
            int marks = sc.nextInt();
            
            students.add(new Student(name, isGirl, schools.get(sName), marks));
        }

        Optional<Student> highest_score_girl = findStudent(students);

        if (highest_score_girl.isPresent()) {
            System.out.println(highest_score_girl.get());
        } else {
            System.out.println("No student found");
        }
        sc.close();
    }
}

/*
Public test case 1:

Input:
Riya true SPBB 85
Arun false SPBB 90
Tina true PSBB 95
Meera true BSPP 88
John false BSPP 82
Sita true SPBB 80

Output:
Meera

Public test case 2:

Input:
Alice true PSBB 90
Bob false SPBB 85
Charlie false BSPP 88
Diana true PSBB 92
Eve true PSBB 89
Frank false SPBB 70

Output:
No student found

Private test case 1:

Input:
S1 true SPBB 50
S2 true BSPP 60
S3 true SPBB 40
S4 true PSBB 99
S5 false BSPP 80
S6 true BSPP 55

Output:
S2
*/