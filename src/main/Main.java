package main;

import java.io.PrintStream;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

import utils.*;

public class Main {

    public static class CmdParams {
        public String inputFile;
        public String outputFile;
        public boolean size;
        public int length = 0;
        public boolean error;
        public boolean help;
        public boolean window;
    }

    public static CmdParams parseArgs(String[] args) {
        CmdParams params = new CmdParams();
        if (args.length > 0) {
            if (args[0].equals("--help")) {
                params.help = true;
                return params;
            }
            if (args[0].equals("--window")) {
                params.window = true;
                return params;
            }
            if (args[0].equals("-s")) {
                params.size = true;
                if(args[1]!=null){
                    params.length = Integer.parseInt(args[1]);
                }
            }
            if (args.length < 2) {
                params.help = true;
                params.error = true;
                return params;
            }
            params.inputFile = args[1];
            if (args.length > 2) {
                params.outputFile = args[2];
            }
        } else {
            params.help = true;
            params.error = true;
        }
        return params;
    }
    public static void winMain() throws Exception {

        Locale.setDefault(Locale.ROOT);
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);
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
        Scanner scan = new Scanner(System.in);
        CmdParams params = parseArgs(args);
        if (params.help) {
            PrintStream out = params.error ? System.err : System.out;
            out.println("Usage:");
            out.println("  <cmd> args <input-file> (<output-file>)");
            out.println("    -s     //size");
            out.println("  <cmd> --help");
            out.println("  <cmd> --window  // show window");
            System.exit(params.error ? 1 : 0);
        }
        if (params.window) {
            winMain();
        } else {
            if (params.length == 0) {
                System.err.printf("Can't read array from \"%s\"%n", params.inputFile);
                System.exit(2);
            }
            int[] arr = new int[params.length];
            NewQSort qSort = new NewQSort();
            for (int i = 0; i < arr.length; i++) arr[i] = (int) (Math.random() * 100);
            PrintStream out = (params.outputFile != null) ? new PrintStream(params.outputFile) : System.out;
            out.println("Изначальный массив: "+Arrays.toString(arr));
            qSort.sort(arr);
            out.println("Отсортированный массив: "+Arrays.toString(arr));
            out.close();
        }
    }
}