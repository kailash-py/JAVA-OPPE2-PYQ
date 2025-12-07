/*Session 1 Type 2 Cloning
Problem Statement
Write a Java program that, given as input, details of an original book, represented by Book
b1. The details include the book’s title, author’s name, and author’s age. Subsequently,
the program should clone the original book to create a new book, denoted as Book b2. The
cloning process should ensure that modifications to the details of either b1 or b2 do not affect
the other.Finally, the program displays the details of both the original and cloned books.
Complete the program as specified below.

• Class Author implements Cloneable interface and has/should have the following mem-
bers:

– Private instance variables String name and int age
– A constructor to initialize the instance variables
– Accessor and Mutator methods for the name and age
– Method toString to print in the format shown in the test cases
– Implement the clone() method

• Class Book implements Cloneable interface and has/should have the following mem-
bers:

– Private instance variables String title and an instance of the Author class.
– A constructor to initialize instance variables,taking the book’s title and an
Author object.
– Method toString to print in the format shown in the test cases
– Mutator method to set new author
– Implement the clone() method
• Class CloningTest contains the main method that takes the inputs in the order of
book’s title, author’s name and age and invokes appropriate methods to achieve the
functionality
What you have to do
• Define method clone in class Book
• Define method clone in class Author
Template Code */
import java.util.*;
class Author implements Cloneable {
    private String name;
    private int age;

    public Author(String n, int a) {
        name = n;
        age = a;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Author: " + name + " (Age: " + age + ")";
    }
    // define method clone
    public Author clone() throws CloneNotSupportedException{
        return (Author)super.clone();
    }

}

class Book implements Cloneable {
    private String title;
    private Author author;

    public Book(String t, Author a) {
        title = t;
        author = a;
    }

    public void setAuthor(Author author) {
        this.author.setName(author.getName());
        this.author.setAge(author.getAge());
    }

    public String toString() {
        return "Book: " + title + "\n" + author;
    }
    // define method clone
    public Book clone() throws CloneNotSupportedException{
        Book clone_ = (Book)super.clone();
        clone_.author= author.clone();
        return clone_;
    }
}

public class q11 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner sc = new Scanner(System.in);
        Book b1 = new Book(sc.next(), new Author(sc.next(), sc.nextInt()));
        Book b2 = b1.clone();

        b2.setAuthor(new Author(sc.next(), sc.nextInt()));
        System.out.println("Original Book:\n" + b1);
        System.out.println("Cloned Book:\n" + b2);
        sc.close();
    }
}

/*
 * /
 * Public test case 1:
 * Input:
 * Programming_Java
 * Alice 25
 * Bob 28
 * Output:
 * Original Book:
 * Book: Programming_Java
 * Author: Alice (Age: 25)
 * Cloned Book:
 * Book: Programming_Java
 * Author: Bob (Age: 28)
 * Public test case 2:
 * Input:
 * History_of_Science
 * Isaac 35
 * Elena 29
 * Output:
 * Original Book:
 * Book: History_of_Science
 * Author: Isaac (Age: 35)
 * Cloned Book:
 * Book: History_of_Science
 * Author: Elena (Age: 29)
 */