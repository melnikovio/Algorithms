package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {
    private static long[] array;
    private static int[] evidence;

    public static void main(String[] args) throws Exception {
        array = readFromFile();

        System.out.println("Inp " + Arrays.toString(array));

        Sort();

        System.out.println("Out " + Arrays.toString(array));

        writeToFile();
    }

    private static void Sort () {
        evidence = new int[array.length];

        evidence[0] = 1;

        for (var i = 1; i < array.length; i++)
        {
            var j = i - 1;
            while (j >= 0 && array[j] > array[j+1])
            {
                Swap(j+1, j);
                j--;
            }
            evidence[i] = j+2;
        }
    }

    private static void Swap(int i, int j)
    {
        var temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    //Input-output operations
    private static long[] readFromFile() throws Exception {
        var file = new File("input.txt");
        var br = new BufferedReader(new FileReader(file));

        var length = Integer.parseInt(br.readLine());

        String[] strArray = br.readLine().split(" ");
        long[] array = new long[strArray.length];

        for(int i = 0; i < strArray.length; i++) {
            array[i] = Long.parseLong(strArray[i]);
        }

        return array;
    }

    private static void writeToFile() throws IOException {
        var stringArray = Arrays.toString(array).replace("[","").replace("]","").replace(",", "");
        var stringEvidence = Arrays.toString(evidence).replace("[","").replace("]","").replace(",", "");

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("output.txt"), StandardCharsets.UTF_8))) {
            writer.write(stringArray);
            writer.write(stringEvidence);
        }
    }
    //Input-output operations
}
