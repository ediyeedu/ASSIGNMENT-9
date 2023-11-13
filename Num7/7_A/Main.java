package Lesson9_lab9_7_a;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> list = Arrays.asList(new Employee("Joe", "Davis", 120000),
                new Employee("John", "Sims", 110000),
                new Employee("Joe", "Stevens", 200000),
                new Employee("Andrew", "Reardon", 80000),
                new Employee("Joe", "Cummings", 760000),
                new Employee("Steven", "Walters", 135000),
                new Employee("Thomas", "Blake", 111000),
                new Employee("Alice", "Richards", 101000),
                new Employee("Donald", "Trump", 100000));

        //your stream pipeline here

        /*which prints, in sorted order (comma-separated, on a single line), the full names (first name + “ “ + last name)
         of all Employees in the list whose salary is greater than $100,000 and whose last name begins with any of the
         letters in the alphabet past the letter ‘M’ (so, any letters in the range ‘N’--‘Z’). Filter the lastname
         which is after M in the alphabets, that is filtered names should be in the range of N—Z*/
        list.stream().filter(x-> x.getSalary()>100000)
                .filter(x->x.lastName.charAt(0)>='N' && x.lastName.charAt(0)<='Z')
                .map(x->x.getFirstName()+ " " + x.getLastName())
                .sorted()
                .collect(Collectors.joining(", "));

        System.out.println(list);

    }
}
