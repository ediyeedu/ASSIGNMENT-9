package Lesson9;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Num4 {
    public static void main(String[] args) {
           Num4.printSquares(4);

    }
    //which creates an IntStream using the iterate method. The method prints to the console the first
    //num squares. For instance, if num = 4, then your method would output 1, 4, 9, 16. Note: You
    //will need to come up with a function to be used in the second argument of iterate
    public static void printSquares(int num){
//        Stream<Integer> reu= Stream.iterate(1,i->i+1);
//                reu.limit(num)
//                .map(i-> i*i)
//                .forEach(System.out::println);

                IntStream.iterate(1,i->i+1)
                        .limit(num)
                        .map(i->i*i)
                        .forEach(System.out::println);

    }
}
