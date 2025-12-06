/*Write a Java program that accepts as input an array of 5 integers. Instead of accepting elements in the order of indices (from 0 to 4), it accepts the array as 5 pairs of integers, where each pair is an index-value pair. The first integer in a pair represents the array index (or position), with accepted values ranging from 0 to 4. The second integer is the value at that index inside the array. Note that the input may not be in the order of the indices.

If any of the given index is out of range, then your code must throw appropriate exceptions, as shown in the test cases. If all indices are within the permissible range, then the code must print the values of the array in a single line (each value followed by a space).

Define a checked exception InvalidInputEx.

Define a class IntList having the following:

An integer array as an instance variable to store the 5 values.

A method set_value with two arguments — one for the index and the other for the value — that stores the value at the given index of the array. If an index is < 0 or > 4, handle the appropriate exception and re-throw exception InvalidInputEx (which would be handled in main). Set the original exception as cause of the new exception, and then throw the new exception.

A method getArray to return the integer array.

Solution:*/

import java.util.*;

// define user defined exception InvalidInputEx
class InvalidInputEx extends Exception{
    public InvalidInputEx(String msg){
        super(msg);
    }
}


// Define class IntList
class IntList {
    private int[] arr = new int[5];
    public void set_value(int i, int v)throws InvalidInputEx{
        try {
            arr[i]=v;
        } catch (ArrayIndexOutOfBoundsException e) {
            InvalidInputEx ie= new InvalidInputEx("Input index out of range");
            ie.initCause(e);
            throw ie;
        }

    }

   

    public int[] getArray() {
        return arr;
    }
}

class q21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntList ilist = new IntList();
        try {
            for (int i = 0; i < 5; i++) {
                int n = sc.nextInt(); // index
                int m = sc.nextInt(); // value
                ilist.set_value(n, m);
            }
        } catch (InvalidInputEx e) {
            System.out.println(e.getMessage());
            Throwable ori = e.getCause();
            System.out.println(ori.getMessage());
            return; // Exit if input was invalid
        }

        int[] i_arr = ilist.getArray();
        for (int i = 0; i < i_arr.length; i++)
            System.out.print(i_arr[i] + " ");
    }
}