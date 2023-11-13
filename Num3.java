package Lesson9;

import java.util.Arrays;
import java.util.List;

public class Num3 {
    public static void main(String[] args) {
        List<String> words= Arrays.asList("Car", "Bicycle", "Bus", "Train");
        char c = 'a';
        char d = 'B';
        int len = 6;
        int count = countWords(words, c, d, len);
        System.out.println("Number of words: " + count);
        //System.out.println( Num3.countWords(words,'a','s',2));

    }
    //which counts the number of words in the input list words that have length equal to len, that
    //contain the character c, and that do not contain the character d.
    public static int countWords(List<String> words, char c, char d, int len){
      return (int)  words.stream()
                .filter(x -> x.contains(""+ c))
                .filter(x -> !x.contains(" "+ d))
                .filter(x -> x.length()==len)
                .count();

    }
}

