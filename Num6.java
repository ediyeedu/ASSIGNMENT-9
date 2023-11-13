package Lesson9;

import java.util.*;
import java.util.stream.Collectors;

public class Num6 {
    public static void main(String[] args) {
        List<Set<String>> sets= new ArrayList<>();
        sets.add(new HashSet<>(Arrays.asList("A", "B")));
        sets.add(new HashSet<>(Arrays.asList("D")));
        sets.add(new HashSet<>(Arrays.asList("1", "3", "5")));

//        Set<String> unionSet = union(sets);
//        System.out.println(unionSet);
        System.out.println(union(sets));

    }
    //by creating a stream pipeline that transforms a list of sets (of type String) into the union
    //of those sets. Make use of the reduce method for streams.
    public static Set<String> union(List<Set<String>> sets){
//        return sets.stream()
//                .flatMap(Set::stream)
//                .collect(Collectors.toSet());

        return sets.stream()
                .reduce(new HashSet<>(), (x,y)->{
                    x.addAll(y);
                    return x;
                });

    }
}
