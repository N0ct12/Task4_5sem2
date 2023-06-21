package main;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Locale;
import utils.*;

public class Main {
    public static void winMain() throws Exception {
        Locale.setDefault(Locale.ROOT);
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Table().setVisible(true);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
    public static void main(String[] args) throws Exception {
        winMain();
//        int[] arr = new int[10];
//        for (int i = 0; i < arr.length; i++) arr[i] = (int) (Math.random() * 100);
//        System.out.println(Arrays.toString(arr));
//        NewQSort qSort = new NewQSort();
//        qSort.sort(arr);
//        System.out.println(Arrays.toString(arr));
    }
}