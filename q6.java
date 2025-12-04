/* Write a Java program that reads name, age, and chronicCondition of patients.
Print patients whose age < 30 and chronicCondition is "Diabetes".

Class Patient:
- Private variables: String name, int age, String chronicCondition
- Constructor to initialize variables
- toString() method to print in required format
- Getters for age and chronicCondition
- Method patientProcessor(ArrayList<Patient>) returns filtered stream:
    age < 30 and chronicCondition = "Diabetes"

Class StreamTest:
- main method:
    1. Read patient data in order: name, age, chronicCondition
    2. Store in ArrayList<Patient>
    3. Call patientProcessor to filter required patients
    4. Display the filtered patients


What you have to do
Define method patientProcessor in class Patient.
*/

import java.util.*;
import java.util.stream.*;

class Patient {
    private String name;
    private int age;
    private String chronicCondition;

    public Patient(String n, int a, String cC) {
        name = n;
        age = a;
        chronicCondition = cC;
    }

    @Override
    public String toString() {
        return name + " - " + age;
    }

    public int getage() {
        return age;
    }

    public String getchronicCondition() {
        return chronicCondition;
    }

    //Write processor method here to filter patients - Method patientProcessor(ArrayList<Patient>) returns filtered stream:
    // age < 30 and chronicCondition = "Diabetes"
    public static Stream<Patient> patientProcessor(ArrayList<Patient> patients){
        return patients.stream()
                            .filter(p -> p.getage()<30 && p.getchronicCondition().equals("Diabetes"));
        
    } 
}

public class q6 {
    public static void main(String[] args) {
        ArrayList<Patient> Patients = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            Patient obj = new Patient(sc.next(), sc.nextInt(), sc.next());
            Patients.add(obj);
        }

        //Call processor method here to filter patients and print them
        Patient.patientProcessor(Patients).forEach(System.out::println);
        sc.close();
    }
}
