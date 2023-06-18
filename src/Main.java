import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.Stack;
public class Main {
    public static void main(String[] args) {
        QuickSort q = new QuickSort(10);
        System.out.println(Arrays.toString(q.a));
        while (q.step!=5){
            q.NextStep();
        }
        System.out.println(Arrays.toString(q.a));
    }
}