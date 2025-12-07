/* 
 Cloning
 Problem Statement
 Write a Java program to create two objects t1 and t2 of type Team. t2 should be created
 from t1 using cloning such that any later changes to t2 do not affect t1.
  " Class Project implements a Cloneable interface and has/should have the following
 members: Instance variables String proj
 name and double budget Constructor to initialize the instance variables Overridden method toString() Method clone(), to be implemented
  " Class Manager implements a Cloneable interface and has/should have the following
 members: Instance variables String mngr
 name and Project proj Constructor to initialize the instance variables Overridden method toString() Method clone(), to be implemented
  " Class Team implements a Cloneable interface and has/should have the following mem
bers: Instance variables String teamName and Manager mngr Constructor to initialize the instance variables Mutator methods as needed Overridden method toString() Method clone(), to be implemented
  " Class CloneTest has the main method that takes the inputs and invokes appropriate
 methods to achieve the functionality.
 What you have to do
  " Implement method clone() in class Project
  " Implement method clone() in class Manager
  " Implement method clone() in class Team */

 import java.util.*;
 class Project implements Cloneable {
     private String proj_name;
     private double budget;
     public Project(String nm, double b) {
         proj_name = nm;
         budget = b;
     }
     public void setProjectName(String nm) {
         proj_name = nm;
     }
     public String toString() {
         return "Project: " + proj_name + ", budget: " + budget;
     }
 // 	Write code to implement clone() method
    public Project clone() throws CloneNotSupportedException{
        return (Project)super.clone();
    }
 }
 class Manager implements Cloneable {
     private String mngr_name;
     private Project proj;
     public Manager(String mn, Project p) {
         mngr_name = mn;
         proj = p;
     }
     public String toString() {
         return proj + "\n" + "Manager: " + mngr_name ;
     }
 // 	\\ Write code to implement clone() method
    public Manager clone() throws CloneNotSupportedException{
        Manager clone_ = (Manager)super.clone();
        clone_.proj=proj.clone();
        return clone_;
    }
 }
 class Team implements Cloneable {
     private String teamName;
     private Manager mngr;
     public Team(String tn, Manager m) {
         teamName = tn;
         mngr = m;
     }
     public void setTeamName(String tn) {
         teamName = tn;
     }
     public void setManager(Manager m) {
         mngr = m;
     }
     public String toString() {
     
         return teamName + "\n" + mngr ;
     }
 // 	\\ Write code to implement clone() method
    public Team clone() throws CloneNotSupportedException{
        Team clone_ = (Team)super.clone();
        clone_.mngr=mngr.clone();
        return clone_;
    }
 }
 public class q1 {
     public static void main(String[] args) throws CloneNotSupportedException {
         Scanner sc = new Scanner(System.in);
         Project p1 = new Project("AI Development", 100000);
         Manager m1 = new Manager("Madhu", p1);
         Team t1 = new Team("Alpha", m1);
         Team t2 = t1.clone();
         t2.setTeamName(sc.nextLine());
         t2.setManager(new Manager(sc.nextLine(),
                                   new Project(sc.nextLine(), sc.nextDouble())));
         System.out.println("Team t1: " + t1);
         System.out.println("Team t2: " + t2);
         sc.close();
     }
 }
 /*
 Public test case 1:
 Input:
 Beta
 Rahul
 ML Development
 150000
 Output:
 Team t1: Alpha
 Project: AI Development, budget: 100000.0
 Manager: Madhu
 Team t2: Beta
 Project: ML Development, budget: 150000.0
 Manager: Rahul
 */