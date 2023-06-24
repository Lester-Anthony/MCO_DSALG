import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] filePath = {"data/almostsorted.txt", "data/random100.txt",
                             "data/random25000.txt", "data/random50000.txt",
                             "data/random75000.txt", "data/random100000.txt",
                             "data/totallyreversed.txt"};

        for(String path : filePath) {

            SortingAlgorithms sortingData = new SortingAlgorithms();
            FileReader fileReaderObject = new FileReader();
            Record[] recordData = fileReaderObject.readFile(path);
            int n = 0;
            long start, end, time;
    
            try {
                File f = new File(path);
                Scanner scanner = new Scanner(f);
                n = scanner.nextInt();
                scanner.close();
            }
    
            catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(path);
    
            start = System.currentTimeMillis();
            sortingData.insertionSort(recordData, n);
            end = System.currentTimeMillis();
            time = end - start;
            System.out.println("Insertion Sort");
            System.out.println("Elapsed Time: " + time + " milliseconds\n");
            
            start = System.currentTimeMillis();
            sortingData.selectionSort(recordData, n);
            end = System.currentTimeMillis();
            time = end - start;
            System.out.println("Selection Sort");
            System.out.println("Elapsed Time: " + time + " milliseconds\n");
            
            start = System.currentTimeMillis();
            sortingData.mergeSort(recordData, 0, n - 1);
            end = System.currentTimeMillis();
            time = end - start;
            System.out.println("Merge Sort");
            System.out.println("Elapsed Time: " + time + " milliseconds\n");
            
            start = System.currentTimeMillis();
            sortingData.bubbleSort(recordData, n);
            end = System.currentTimeMillis();
            time = end - start;
            System.out.println("Bubble Sort");
            System.out.println("Elapsed Time: " + time + " milliseconds\n");
        }
    }
}