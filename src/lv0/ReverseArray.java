package lv0;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseArray {
    public static void main(String[] args) {
        int[] reversed = reverseArray(new int[]{1, 0, 1, 1, 1, 3, 5});
        System.out.println(Arrays.toString(reversed));
    }

    public static int[] reverseArray(int[] numbers) {
        List<Integer> list = Arrays.stream(numbers)
                                   .boxed()
                                   .collect(Collectors.toList());
        Collections.reverse(list);
        return list.stream().mapToInt(i -> i).toArray();
    }
}
