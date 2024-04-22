package lv0;

import java.util.Arrays;

/**
 * AverageOfArray
 */
public class AverageOfArray {
     public double solution(int[] numbers) {
        return Arrays.stream(numbers).average().orElse(0);
     }
}