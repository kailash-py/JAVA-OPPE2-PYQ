/*Problem Statement
Complete the Java code given below that takes as input a list of Employee objects and filters
the list based on rating and salary of employees. The program should print the details of
employees who have rating greater than 6 and salary lesser than 20,000, in the descending
order of their rating.

• Class Employee has the following members.

Instance variables: name, salary and rating

Constructor to initialize the instance variables

Accessor and mutator methods as needed

Overridden toString() method to display the employee details in a specific format.

• Class MClass has the main() method that accepts a list of Employee objects, and
invokes the method getFilteredList to filter based on the given constraints.

Method getFilteredList does the following. It accepts a list of Employee objects, eList.
The list eList should be converted into a Stream object, and a filter applied.
Here the filter should extract the employees with rating greater than 6 and salary lesser than 20,000,
and put them into a new list fList. Then it should use Collections.sort() to sort the fList
in descending order of the rating of the employees.

What you have to do
• Complete the method getFilteredList in class MClass.

--- Template Code ---*/

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private double salary;
    private int rating;

    public Employee(String n, double s, int r) {
        name = n;
        salary = s;
        rating = r;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getRating() {
        return rating;
    }

    public String toString() {
        return "name = " + name + ", salary = " + salary + ", rating = " + rating;
    }

}

public class q24 {
    public static List<Employee> getFilteredList(LinkedList<Employee> eList) {
        List<Employee> fList = null;

        // Convert the eList into stream, then apply the filter.
        // After filtering collect the stream to appropriate collection fList.
        // Use Collections.sort() to sort fList.
        fList = eList.stream()
                            .filter(e -> e.getRating() > 6 && e.getSalary() < 20000)
                            .collect(Collectors.toList());

    Collections.sort(fList, (e1, e2) -> (e2.getRating() - e1.getRating()));
    return fList;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Employee> el = new LinkedList<Employee>();
        for (int i = 0; i < 4; i++)
            el.add(new Employee(sc.next(), sc.nextDouble(), sc.nextInt()));

        List<Employee> fList = getFilteredList(el);
        for (Employee e : fList)
            System.out.println(e);
    }

}

/*--- Test Cases ---

Public test case 1:
Input:
riya 10000 9
deep 20000 8
anuska 19000 7
kalam 1500 8

Output:
name = riya, salary = 10000.0, rating = 9
name = kalam, salary = 1500.0, rating = 8
name = anuska, salary = 19000.0, rating = 7

Public test case 2:
Input:
rajiv 17000 6
arun 19500 7
radha 15000 8
riya 20000 8

Output:
name = radha, salary = 15000.0, rating = 8
name = arun, salary = 19500.0, rating = 7    
*/