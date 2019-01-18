package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {
    private static int[] array;
    private static Writer writer;

    public static void main(String[] args) throws Exception {
        array = readFromFile();

        System.out.println("Inp " + Arrays.toString(array));

        Sort();

        System.out.println("Out " + Arrays.toString(array));

        var stringArray = Arrays.toString(array).replace("[","").replace("]","").replace(",", "");

        writeToFile("No more swaps needed.\n");
        writeToFile(stringArray);

        writer.close();
    }

    private static void Sort () {
        for (var i = 1; i < array.length; i++)
        {
            var j = i - 1;
            while (j >= 0 && array[j] > array[j+1])
            {
                Swap(j+1, j);
                j--;
            }
        }
    }

    private static void Swap(int i, int j)
    {
        var temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        writeToFile("Swap elements at indices " + (i+1) + " and " + (j+1) +".\n");
    }

    //Input-output operations
    private static int[] readFromFile() throws Exception {
        var file = new File("input.txt");
        var br = new BufferedReader(new FileReader(file));

        var length = Integer.parseInt(br.readLine());

        String[] strArray = br.readLine().split(" ");
        var array = new int[strArray.length];

        for(int i = 0; i < strArray.length; i++) {
            array[i] = Integer.parseInt(strArray[i]);
        }

        return array;
    }

    private static void writeToFile(String value)  {
        if (writer == null) {
            try {
                writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream("output.txt"), StandardCharsets.UTF_8));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        try {
            writer.write(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Input-output operations
}
