package Lesson9;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Human {  //NUMBER-10
    String name;
    int age;
    String gender;

    public Human(String name){
        this.name = name;
    }
    public Human(String name,int age){
        this.name = name;
        this.age = age;
    }

    public Human(String name,int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    @Override
    public String toString() {
        return "Human [name=" + name + ", age=" + age + ", gender=" + gender + "]";
    }
}

 class ConstructorReference {
    public static void main(String args[]){
        Human[] list = { new Human("Joe",35,"Male"), new Human("Jane",45,"Female"),
                new Human("John",30,"Male")};

        // Query 1  : Print only Female candidates names
        List<Human> humans = Arrays.asList(list);

        humans.stream()
                .filter(x-> "Female".equals(x.getGender()))
                .map(Human::getName)
                .forEach(System.out::println);

        // Query 2 : Create an object by choosing suitable Interface to the specified constructors(Totally 3 constructors)
        // using forth type of Method Reference ClassName::new. Then print the object status
        List<Human> humanList = Arrays.asList(list);
        Function<String, Human> createWithName = Human::new;
        BiFunction<String, Integer, Human> createWithNameAndAge = Human::new;
        TriFunction<String, Integer, String, Human> createWithNameAgeAndGender = Human::new;

        Human newHuman1 = createWithName.apply("Alice");
        Human newHuman2 = createWithNameAndAge.apply("Bob", 25);
        Human newHuman3 = createWithNameAgeAndGender.apply("Charlie", 40, "Male");

        System.out.println(newHuman1);
        System.out.println(newHuman2);
        System.out.println(newHuman3);
        System.out.println(humanList);


        // Query 3 : Count the male candidates whose age is more than 30
        List<Human> humans1 = Arrays.asList(list);
        long countMaleAgeAbove30= humans1.stream()
                .filter( x-> "Male".equals(x.getGender()))
                .filter(x-> x.getAge()>30)
                .map(Human::getName)
                .count();
                //.forEach(System.out::println);
        System.out.println("Number of male candidates over 30: " + countMaleAgeAbove30);

    }
}

@FunctionalInterface
interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}
