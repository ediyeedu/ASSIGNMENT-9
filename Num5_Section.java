package Lesson9;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Num5_Section {
    //which extracts a substream from the input stream consisting of all elements from position m to position n,
    //inclusive; you must use only Stream operations to do this. You can assume 0 <= m <= n.
        public static Stream<String> streamSection(Stream<String> stream, int m, int n) {
// Implement the code
            List<String> result = stream
              .skip(m)
                    .limit(n+1)
                    .collect(Collectors.toList());
            return result.stream();

        }
        public static void main(String[] args) {
            // Make three calls for the streamSection() method with different inputs
            // use nextStream() method to supply the Stream input as a first argument in
           // streamSection() method
            Stream<String> result1 =streamSection(nextStream(),0,3);
            result1.forEach(System.out::println);

            Stream<String> result2 =streamSection(nextStream(),2,5);
            result2.forEach(System.out::println);


        }
        //support method for the main method -- for testing
        private static Stream<String> nextStream() {
            return Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg", "hhh",
                    "iii").stream();
        }

}
