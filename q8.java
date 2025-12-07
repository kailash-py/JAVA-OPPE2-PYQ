/*The program stores a list of Employee objects,  
each of which has name, department and salary as instance variables.  

A user can query the list to find the Employees  
who belong to a specific department  
and have salary greater than or equal to the input salary.  

Complete the program as specified.  

Define a class Employee as follows:  
Add the instance variables to represent name, department and salary.  
Implement the required constructor(s) and accessors.  
Override the method toString()  
so that the format of the output is in accordance with those in the test cases.  

Define a function query that takes a list of employees,  
a department and a salary as input.  
It returns a stream comprising the Employee objects  
that have the same department  
and have salary greater than or equal to the given salary.  


Input:
IT 30000

Output:
Nora : IT : 50000
Bella : IT : 60000
Jacob : IT : 70000


Input:
HR 50000

Output:
James : HR : 80000

Code Template:
*/

import java.util.*;
import java.util.stream.*;
//define class Employee
class Employee{
    String name;
    String department    ;
    double salary;
    public Employee(
                    String name,
                    String department,
                    double salary
                    ){
                        this.department=department;
                        this.name=name;
                        this.salary=salary;
                    }
    public String getName(){
        return name;
    }
    public String getDept(){
        return department;
    }
    public double getsalary(){
        return salary;
    }
    @Override
    public String toString() {
        return (this.name + " : " + this.department + " : " + this.salary);}


}

class q8{
    //define method query
    public static Stream<Employee> query(ArrayList<Employee> eList, String d, double s){
        return eList.stream()
                                .filter(e-> (e.getDept().equals(d) 
                                && e.getsalary()>=s ));
        

    }

    
 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var eList = new ArrayList<Employee>();
        eList.add(new Employee("Jack", "HR", 30000));
        eList.add(new Employee("Aria", "HR", 40000));
        eList.add(new Employee("Nora", "IT", 50000));
        eList.add(new Employee("Bella", "IT", 60000));
        eList.add(new Employee("Jacob", "IT", 70000));
        eList.add(new Employee("James", "HR", 80000));
        String d = sc.next();       //read department
        double s = sc.nextDouble();    //read salary
		
        var st = query(eList, d, s);
        st.forEach(n -> System.out.println(n + " "));
        // sc.close()
    }
}