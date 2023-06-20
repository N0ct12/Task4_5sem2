import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        QuickSort q = new QuickSort(10);
        System.out.println(Arrays.toString(q.a));
        while (q.step!=5){
            q.Steps();
        }
        System.out.println(Arrays.toString(q.a));
    }
}