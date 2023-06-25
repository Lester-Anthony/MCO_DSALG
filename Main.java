import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Array of strings containing the file paths for each file
        String[] filePath = {"data/almostsorted.txt", "data/random100.txt",
                             "data/random25000.txt", "data/random50000.txt",
                             "data/random75000.txt", "data/random100000.txt",
                             "data/totallyreversed.txt"};

        for(String path : filePath) {

            SortingAlgorithms sortingData = new SortingAlgorithms();
            FrequencyCounter frequencyData = new FrequencyCounter();

            // Creates an instance of FileReader
            FileReader fileReaderObject = new FileReader();

            // Reads the txt files and obtains an array of Record objects
            Record[] recordData = fileReaderObject.readFile(path);

            int n = 0,
                i;
            long start,
                 end,
                 time = 0;
            float insertionSortAvg = 0,
                  selectionSortAve = 0,
                  mergeSortAve = 0,
                  bubbleSortAve = 0;

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
    
            // Insertion Sort
            for(i = 0; i < 5; i++) {
                recordData = fileReaderObject.readFile(path);
                start = System.currentTimeMillis();
                sortingData.insertionSort(recordData, n);
                end = System.currentTimeMillis();
                time += end - start;
            }
            insertionSortAvg = time / 5f;
            
            System.out.print("Insertion Sort | ");
            if(frequencyData.isSorted(recordData) == true)
                System.out.println("SORTED");
            else
                System.out.println("NOT SORTED");
            System.out.println("Elapsed Time: " + insertionSortAvg + " milliseconds");
            recordData = fileReaderObject.readFile(path);
            System.out.println("Frequency Count: " + frequencyData.insertionSort(recordData, n) + "\n");
            
            
            // Selection Sort
            time = 0;
            for(i = 0; i < 5; i++) {
                recordData = fileReaderObject.readFile(path);
                start = System.currentTimeMillis();
                sortingData.selectionSort(recordData, n);
                end = System.currentTimeMillis();
                time += end - start;
            }
            selectionSortAve = time / 5f;
            
            System.out.print("Selection Sort | ");
            if(frequencyData.isSorted(recordData) == true)
                System.out.println("SORTED");
            else
                System.out.println("NOT SORTED");
            System.out.println("Elapsed Time: " + selectionSortAve + " milliseconds");
            recordData = fileReaderObject.readFile(path);
            System.out.println("Frequency Count: " + frequencyData.selectionSort(recordData, n) + "\n");
            
            
            // Merge Sort
            time = 0;
            for(i = 0; i < 5; i++) {
                recordData = fileReaderObject.readFile(path);
                start = System.currentTimeMillis();
                sortingData.mergeSort(recordData, 0, n - 1);
                end = System.currentTimeMillis();
                time += end - start;
            }
            mergeSortAve = time / 5f;
            
            System.out.print("Merge Sort | ");
            if(frequencyData.isSorted(recordData) == true)
                System.out.println("SORTED");
            else
                System.out.println("NOT SORTED");
            System.out.println("Elapsed Time: " + mergeSortAve + " milliseconds");
            recordData = fileReaderObject.readFile(path);
            System.out.println("Frequency Count: " + frequencyData.mergeSort(recordData, 0, n - 1) + "\n");
            
            // Bubble Sort
            time = 0;
            for(i = 0; i < 5; i++) {
                recordData = fileReaderObject.readFile(path);
                start = System.currentTimeMillis();
                sortingData.bubbleSort(recordData, n);
                end = System.currentTimeMillis();
                time += end - start;
            }
            bubbleSortAve = time / 5f;
            
            System.out.print("Bubble Sort | ");
            if(frequencyData.isSorted(recordData) == true)
                System.out.println("SORTED");
            else
                System.out.println("NOT SORTED");
            System.out.println("Elapsed Time: " + bubbleSortAve + " milliseconds");
            recordData = fileReaderObject.readFile(path);
            System.out.println("Frequency Count: " + frequencyData.bubbleSort(recordData, n) + "\n");
        }
    }
}