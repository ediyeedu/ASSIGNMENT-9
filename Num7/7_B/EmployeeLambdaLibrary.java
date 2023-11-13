package Lesson9_lab9_7_b;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class EmployeeLambdaLibrary {
    public static final BiFunction<List<Employee>, String, String> FULL_NAME =
            (list, startLetter) ->
                    list.stream().filter(x -> x.getSalary() > 100000)
                            .filter(x -> x.lastName.charAt(0) >= 'N' && x.lastName.charAt(0) <= 'Z')
                            .map(x -> x.getFirstName() + " " + x.getLastName())
                            .sorted()
                            .collect(Collectors.joining(", "));


}
