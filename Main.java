import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SortingAlgorithms sortingData = new SortingAlgorithms();
        FileReader fileReaderObject = new FileReader();
        Record[] recordData = fileReaderObject.readFile("data/random25000.txt");
        int n = 0;
        long start, end, time;

        try {
            File f = new File("data/random25000.txt");
            Scanner scanner = new Scanner(f);
            n = scanner.nextInt();
            scanner.close();
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        start = System.currentTimeMillis();
        sortingData.insertionSort(recordData, n);
        end = System.currentTimeMillis();
        time = end - start;
        System.out.println("Elapsed time: " + time + " milliseconds");

        start = System.currentTimeMillis();
        sortingData.selectionSort(recordData, n);
        end = System.currentTimeMillis();
        time = end - start;
        System.out.println("Elapsed time: " + time + " milliseconds");

        start = System.currentTimeMillis();
        sortingData.mergeSort(recordData, 0, n - 1);
        end = System.currentTimeMillis();
        time = end - start;
        System.out.println("Elapsed time: " + time + " milliseconds");

        start = System.currentTimeMillis();
        sortingData.bubbleSort(recordData, n);
        end = System.currentTimeMillis();
        time = end - start;
        System.out.println("Elapsed time: " + time + " milliseconds");
    }
}