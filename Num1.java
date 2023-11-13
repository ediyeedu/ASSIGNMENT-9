package Lesson9;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Num1 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Bill", "Thomas", "Mary");
       String result= list.stream()
                .collect(Collectors.joining(","));
        //list.forEach(System.out::println);

        System.out.println(result);
    }
}
