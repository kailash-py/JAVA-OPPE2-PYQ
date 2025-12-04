/* 
 Java Program Description

This program accepts as input an array of 5 integers, but instead of taking the elements in the normal order of indices (from 0 to 4), it accepts the array as 5 pairs of integers.

Each pair contains:
- First integer → the array index (position), ranging from 0 to 4.
- Second integer → the value to be stored at that index in the array.

The input may not be given in the order of the indices. The program must handle incorrect indices.

Exception Handling:
- If any given index is less than 0 or greater than 4, an exception should be thrown.
- The program uses a custom checked exception named InvalidInputEx.
- The set_value method in the IntList class should catch the ArrayIndexOutOfBoundsException, wrap it in an InvalidInputEx (set the original exception as the cause), and rethrow it.
- This custom exception will be handled in the main method.

Class IntList:
- Instance Variable: An integer array of size 5 to store the values.
- Method: set_value(int index, int value) → sets the value at the given index after validating it.
- Method: getArray() → returns the integer array.

Program Flow:
1. Read 5 pairs of integers from the user (index and value).
2. For each pair, call set_value(index, value).
3. If all indices are valid, print the array values in a single line, separated by spaces.
4. If any index is invalid, catch the InvalidInputEx in main and print the error message.
Code Template */
import java.util.*;
//define user defined exception InvalidInputEx
class InvalidInputEx extends Exception{
    public InvalidInputEx(String msg){
        super(msg);
    }
}
//define the class IntList with 
//instance variable of int[]
class IntList{
    private int[] arr = new int[5];

    //and methods set_value, getArray()
    public void set_value(int index, int value) throws InvalidInputEx{
        try {
            arr[index]=value;
            
        } catch (ArrayIndexOutOfBoundsException e1) {
            InvalidInputEx e2 = new InvalidInputEx("invalid index input");
            e2.initCause(e1);
            throw e2;
        }

    }
    public int[] getArray(){
        return arr;
    }
}

class q7{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntList ilist = new IntList();
        try {
            for(int i = 0; i < 5; i++) {			
                int n = sc.nextInt();
                int m = sc.nextInt();
                ilist.set_value(n, m);
            }
        }
        catch(InvalidInputEx e) {
            System.out.println(e.getMessage());
            Throwable ori = e.getCause();
            System.out.println(ori.getMessage());
        }	
        int[] i_arr = ilist.getArray();
        for(int i = 0; i < i_arr.length; i++)
            System.out.print(i_arr[i] + " ");
    }
}

/* 
Test cases
Sample Input:
0 10
3 20
4 50
2 60
1 30

Sample Output:
10 30 60 20 50
*/