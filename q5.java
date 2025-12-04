/* 11. Employee e1 does a set of projects. Employee e2 also does all the projects did by e1
except the first project, in place of which e2 does another project. Write a program that
defines two classes Employee and Test. Create copy of e1, say it as e2 in such a way
that changing the values of instance variables of either e2 or e1 should not affect the
other one. The code takes name of e2 and new project done by e2 as input. Complete
the program as specified below.

• Class Employee that implements Cloneable interface and has the following mem-
bers:
– Private instance variables String name and String[] projects to store name and
projects respectively
 
– Define accessor methods getName( ) and getProject( ) to get name of em-
ployee and project at specific index.

– Define mutator methods setName( ) and setProject( ) to set name of em-
ployee and project at specific index.

– Override the method clone( )
• Class Test that has the method main which does the following:
– Two objects of Employee e1 and e2 are created. e2 is created using e1.clone()
– Input to update name of e2 and second item bought by e2 are taken Names
of e1, e2 and first project done by e1 and e2 are printed.

Template Code */
// Define class Employee here
import java.util.*;
class Employee implements Cloneable{
    
    private String name;
    private String[] projects;
    
    public Employee(String n, String[] p){
        this.name=n;
        this.projects=p;
    }
    public String getName( ){
        return this.name;
    }
    
    public String getProject(int idx ) {
        return this.projects[idx];
    }
    public void setName( String n) {
        this.name=n;
    }
    public void setProject(int idx, String p){
        this.projects[idx]= p;
    }
    public Employee clone() throws CloneNotSupportedException{
        Employee emp_clone= (Employee)super.clone();
        emp_clone.projects= projects.clone();
        return emp_clone;
    }
}
public class q5 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner sc = new Scanner(System.in);
        String[] proj = {"PJ1", "PJ2", "PJ3"};
        Employee e1 = new Employee("Surya", proj);
        Employee e2 = e1.clone();
        e2.setName(sc.next());
        e2.setProject(0, sc.next());
        System.out.println(e1.getName() + ": " + e1.getProject(0));
        System.out.println(e2.getName() + ": " + e2.getProject(0));
    }
}
