/*Naresh (aka Customer c1) buys a set of items from a shop. Suresh (aka Customer c2) also buys all items bought by Naresh except the first item, in place of which Suresh buys another item. Write a program that defines two classes Items and Customer, and clones the object of class Customer to model the scenario given above. Classes Items and Customer should be cloneable, and must have the functionality to clone (deep copy) c2 from c1.

You are given as input the number of items bought by Naresh, the names of the items, and the new item that Suresh will be buying. The code to change the first item and the name in the second customer object after the cloning has been provided in the given code. You should complete the program as specified below.

Define a class Items that implements interface Cloneable, and has the following members:
A public instance variable item of type String[] to store the item names

Constructor(s) and accessors to, respectively, initialize and access the instance variable

Override the method clone()

Override the method toString() so that the format of the output is in accordance with those in the test cases

Define a class Customer that implements interface Cloneable, and has the following members:
Instance variable name of type String to store the name of the customer

Instance variable of type Items to store the items purchased by the customer

Implement the constructor(s), the accessor getItems() to return the object of Items, and the mutator setName(String s) to update the name of the customer

Override the method clone()

Override the method toString() so that the format of the output is in accordance with those in the test cases

Solution:*/

import java.util.*;

class Items implements  Cloneable{
    public String[] item;
    public Items(String[] item){
        this.item=item;
    }


    // Clone method (deep copy)
    public Items clone() throws CloneNotSupportedException{
        Items clone_= (Items)super.clone();
        clone_.item=item.clone();
        return clone_;
    }

    // toString() for Items
    public String toString() {
        return String.join(" ", item);
    }
}

class Customer implements Cloneable {
    private String name;
    private Items items;

    // Constructor
    public Customer(String name, Items items) {
        this.name = name;
        this.items = items;
    }

    // Getter for Items
    public Items getItems() {
        return items;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Clone method (deep copy)
    public Customer clone() throws CloneNotSupportedException{
        Customer cloned_ = (Customer)super.clone();
        cloned_.items=items.clone();
        return cloned_;
    }

    // toString() for Customer
    public String toString() {
        return name + " " + items.toString();
    }
}

public class q16 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of items
        String[] itm = new String[n];
        for (int i = 0; i < n; i++) {
            itm[i] = sc.next(); // reading item names
        }

        // Create original customer c1
        Customer c1 = new Customer("naresh", new Items(itm));

        // Clone c1 to create c2
        Customer c2 = c1.clone();

        // Modify c2's first item and name
        c2.getItems().item[0] = sc.next(); // update first item
        c2.setName("suresh");

        // Output
        System.out.println(c1);
        System.out.println(c2);
    }
}