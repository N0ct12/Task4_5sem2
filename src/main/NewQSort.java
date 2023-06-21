package main;

import java.util.Arrays;
import java.util.Stack;

public class NewQSort {

//    public static final String ANSI_RED = "\u001B[31m";
//    public static final String ANSI_RESET = "\u001B[0m";
//    public static final String ANSI_GREEN = "\u001B[32m";
    static class ArrRange {
        public int low, high;

        public ArrRange(int from, int to) {
            this.low = from;
            this.high = to;
        }
    }
    public void sort(int[] arr){
        ArrRange range = new ArrRange(0, arr.length - 1);
        Stack<ArrRange> stack = new Stack<>();
        stack.push(range);
        int middle = -1;            // середина массива
        int prop;                  // опорный элемент
        int low, high;
        while (stack.size() != 0){

            range = stack.pop();

            while (range.low< range.high) {
                middle = (range.low + range.high) >> 1;
                prop = arr[middle];
                low = range.low;
                high = range.high;

                while (low <= high) {

                    while (arr[low] < prop) low++;

                    while (arr[high] > prop) high--;

                    if (low <= high) {
                        int temp = arr[low];
                        arr[low] = arr[high];
                        arr[high] = temp;
                        low++;
                        high--;
                    }
//                    System.out.println(Arrays.toString(arr));
                }
                if (low < middle) {
                    if (low < range.high) stack.push(new ArrRange(low, range.high));
                    range.high = high;
//                    System.out.println(ANSI_GREEN + Arrays.toString(arr) + ANSI_RESET);
                } else {
                    if (high > range.low) stack.push(new ArrRange(range.low, high));
                    range.low = low;
//                    System.out.println(ANSI_RED + Arrays.toString(arr) + ANSI_RESET);
                }
            }
        }
    }
}

