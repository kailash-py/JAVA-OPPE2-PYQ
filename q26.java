/*
        This is not a question, Practice for different Stream API Methods
 */
import java.util.*;
import java.util.stream.*;

public class q26 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Aria", "Nora", "Bella", "Jacob", "James", "Jack");

        // 1. map → transform each element
        List<Integer> lengths = names.stream().map(String::length).collect(Collectors.toList());
        System.out.println("map: " + lengths);

        // 2. flatMap → flatten nested collections
        List<List<String>> nested = Arrays.asList(
            Arrays.asList("A", "B"),
            Arrays.asList("C", "D")
        );
        List<String> flat = nested.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println("flatMap: " + flat);

        // 3. distinct → remove duplicates
        List<String> distinctNames = names.stream().distinct().collect(Collectors.toList());
        System.out.println("distinct: " + distinctNames);

        // 4. sorted → sort elements
        List<String> sortedNames = names.stream().sorted().collect(Collectors.toList());
        System.out.println("sorted: " + sortedNames);
    }
}