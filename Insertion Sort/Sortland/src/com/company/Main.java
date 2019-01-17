package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {
    private static float[] salary;
    private static int[] citizens;

    public static void main(String[] args) throws Exception {
        salary = readFromFile();
        citizens = new int[salary.length];
        for (int i = 0; i < salary.length; i ++) {
            citizens[i] = i+1;
        }

        System.out.println("Inp " + Arrays.toString(salary));

        Sort();

        System.out.println("Out " + Arrays.toString(salary));

        writeToFile();
    }

    private static void Sort () {
        for (var i = 1; i < salary.length; i++)
        {
            var j = i - 1;
            while (j >= 0 && salary[j] > salary[j+1])
            {
                SwapSalary(j+1, j);
                SwapCitizens(j+1, j);
                j--;
            }
        }
    }

    private static void SwapSalary(int i, int j)
    {
        var temp = salary[i];
        salary[i] = salary[j];
        salary[j] = temp;
    }

    private static void SwapCitizens(int i, int j)
    {
        var temp = citizens[i];
        citizens[i] = citizens[j];
        citizens[j] = temp;
    }

    //Input-output operations
    private static float[] readFromFile() throws Exception {
        var file = new File("input.txt");
        var br = new BufferedReader(new FileReader(file));

        var length = Integer.parseInt(br.readLine());

        String[] strArray = br.readLine().split(" ");
        var array = new float[strArray.length];

        for(int i = 0; i < strArray.length; i++) {
            array[i] = Float.parseFloat(strArray[i]);
        }

        return array;
    }

    private static void writeToFile() throws IOException {
        var stringCitizens = citizens[0] + " " + citizens[citizens.length/2] + " "+ citizens[citizens.length -1];

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("output.txt"), StandardCharsets.UTF_8))) {
            writer.write(stringCitizens);
        }
    }
    //Input-output operations
}
