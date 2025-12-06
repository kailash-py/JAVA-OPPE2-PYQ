/*Q3.
Write a Java program that accepts a string, an integer i and a character c as input.
The character at position i in the given string has to be replaced by the value of c.
If the index is more than the length of the string, then it updates the last character of the given string with the value of c. If the index i is negative, then it throws an appropriate error message.

Implement the function replace such that it does the following:
It has three parameters - a character array (for the input string), an index and a character.
If the given index is in the range of the character array, it replaces the character at the given position; otherwise, catch ArrayIndexOutOfBoundsException.
In catch block (catches ArrayIndexOutOfBoundsException), if the index is beyond the length of the character array, it updates the last character of the given character array.
If the index is negative, then it rethrows the exception to forward the exception to the caller function main.

Solution:*/

import java.util.*;

class q19 {

    // implement function replace()
    public static char[] replace(char[] arr, int i, char c){
       try {
         if (i <0){
            throw new ArrayIndexOutOfBoundsException("Index cannot be negative");

        } arr[i]=c;
     }
        catch(ArrayIndexOutOfBoundsException e){
            if(i>= arr.length){
                arr[arr.length-1]=c;
            }else{
                throw e;
            }


        }
        return arr;
    }
    
    // public static char[] replace(char[] arr, int index, char c) throws ArrayIndexOutOfBoundsException {
    //     try {
    //         if (index < 0) {
    //             // If index is negative, explicitly throw exception
    //             throw new ArrayIndexOutOfBoundsException("Index cannot be negative");
    //         }
    //         arr[index] = c; // Try replacing normally
    //     } catch (ArrayIndexOutOfBoundsException e) {
    //         if (index >= arr.length) {
    //             // If index is beyond array length, update last character
    //             arr[arr.length - 1] = c;
    //         } else {
    //             // If index is negative, rethrow to main
    //             throw e;
    //         }
    //     }
    //     return arr;
    // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        int i = sc.nextInt();
        char c = sc.next().charAt(0);
        try {
            String s2 = new String(replace(s1.toCharArray(), i, c));
            System.out.println(s2);
        } 
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}