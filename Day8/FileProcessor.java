package Day8;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FileProcessor {

    // Method to read integers from a file, handling NumberFormatException
    public static List<Integer> readFile(String fileName) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String line;
        while ((line = reader.readLine()) != null) {
            try {
                numbers.add(Integer.parseInt(line.trim()));
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format in file for line: " + line);
            }
        }
        reader.close();
        return numbers;
    }

    // Method to perform division on a list of integers by a given divisor
    public static List<String> divideNumbers(List<Integer> numbers, int divisor) {
        List<String> results = new ArrayList<>();
        
        for (Integer number : numbers) {
            try {
                int result = number / divisor;
                results.add(String.valueOf(result));

            } catch (ArithmeticException e) {
                results.add("Division by zero error for number " + number);
            }
        }
        return results;
    }

    // Method to write results to a file
    public static void writeFile(String fileName, List<String> results) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        for (String result : results) {
            writer.write(result);
            writer.newLine();
        }
        writer.close();
    }

    // Main method for reading, processing, and writing the results
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter divisor:");
        int divisor = scanner.nextInt(); // Get divisor from the user
        
        try {
            // Step 1: Read integers from input file
            List<Integer> numbers = readFile("input.txt.txt");

            // Step 2: Perform division on the numbers
            List<String> results = divideNumbers(numbers, divisor);

            // Step 3: Write results to output file
            writeFile("output.txt", results);

            System.out.println("Results have been written to output.txt");
        } catch (IOException e) {
            System.out.println("Error occurred while handling file: " + e.getMessage());
        }
        scanner.close();
    }
}