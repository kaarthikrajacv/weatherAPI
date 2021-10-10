package stepDefinition;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;

public class Test {

    public static void main(String[] args) {

            int[][] input = {{3,4}, {1,2}};

        Arrays.sort(input, Comparator.comparingInt(p -> p[0] * p[0] + p[1] * p[1]));

        System.out.println("Test");


        }


}
