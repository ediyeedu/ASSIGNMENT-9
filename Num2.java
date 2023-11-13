package Lesson9;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Num2 {
    public static void main(String[] args) {
        //You have a Stream of Integers called myIntStream and you need to output both the
        // maximum and minimum values. Write compact code that efficiently accomplishes this.

        Stream<Integer> myIntStream= Stream.of(1,5,3,8,2,7,4);
        IntSummaryStatistics stats= myIntStream.collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println("Minimum value: " + stats.getMin());
        System.out.println("Maximum value: " + stats.getMax());
    }
}
