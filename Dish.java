package Lesson9;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Dish {  // NUMBER-9

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public enum Type {MEAT, FISH, OTHER}

    @Override
    public String toString() {
        return name;
    }

    public static final List<Dish> menu =
            Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
                    new Dish("beef", false, 700, Dish.Type.MEAT),
                    new Dish("chicken", false, 400, Dish.Type.MEAT),
                    new Dish("french fries", true, 530, Dish.Type.OTHER),
                    new Dish("rice", true, 350, Dish.Type.OTHER),
                    new Dish("season fruit", true, 120, Dish.Type.OTHER),
                    new Dish("pizza", true, 550, Dish.Type.OTHER),
                    new Dish("prawns", false, 400, Dish.Type.FISH),
                    new Dish("salmon", false, 450, Dish.Type.FISH));


    //implement some static methods to decide the following with help of Optional, anyMatch(),
    //allMatch(), noneMatch(),findAny(), findFirst() operations from stream.

    //a. Is there any Vegetarian meal available ( return type boolean)
    public static boolean anyVegetarian() {
        return menu.stream().anyMatch(Dish::isVegetarian);
    }

    //b. Is there any healthy menu have calories less than 1000 ( return type boolean)
    public static boolean anyMenuLessCalories() {
        return menu.stream().anyMatch(dish -> dish.calories < 1000);
    }

    //c. Is there any unhealthy menu have calories greater than 1000 ( return type boolean)
    public static boolean anyMenuGreaterCalories() {
        return menu.stream().anyMatch(dish -> dish.calories > 1000);
    }

    //d. find and return the first item for the type of MEAT( return type Optional<Dish>)
    public static Optional<Dish> firstItemMeat() {
        return menu.stream().filter(dish -> dish.type.equals("MEAT")).findFirst();
    }

    //e. calculateTotalCalories() in the menu using reduce. (return int)
    public static int calculateTotalCalories() {
        //return menu.stream().map(Dish::getCalories).reduce(0,Integer::sum);
        return menu.stream().mapToInt(Dish::getCalories).sum();
    }

    //f. calculateTotalCaloriesMethodReference()in the menu using MethodReferences. (return int)
    public static int calculateTotalCaloriesMethodReference() {
        return menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);
    }

    //e. Implement a main method to test.
    public static void main(String[] args) {
        System.out.println("Is there any Vegetarian meal available? " + anyVegetarian());
        System.out.println("Is there any healthy menu with calories less than 1000? " + anyMenuLessCalories());
        System.out.println("Is there any unhealthy menu with calories greater than 1000? " + anyMenuGreaterCalories());
        System.out.println("First item of type MEAT: " + firstItemMeat());
        System.out.println("Total calories in the menu: " + calculateTotalCalories());
        System.out.println("Total calories in the menu using Method Reference: " + calculateTotalCaloriesMethodReference());


        // Use allMatch to check if all dishes are vegetarian
        boolean allVegetarian = menu.stream().allMatch(Dish::isVegetarian);
        System.out.println("Are all dishes vegetarian? " + allVegetarian);

        // Use noneMatch to check if there are no dishes with more than 1000 calories
        boolean noneUnhealthy = menu.stream().noneMatch(dish -> dish.getCalories() > 1000);
        System.out.println("Are there no unhealthy dishes? " + noneUnhealthy);
    }
}
