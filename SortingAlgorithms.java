/* This file contains implementations of sorting algorithms.
 * You are NOT allowed to modify any of the given method headers.
 */

public class SortingAlgorithms {

    /*
     * You may define additional helper functions here if you need to.
     * Make sure the helper functions have the private access modifier, as
     * they will only be used in this class.
     */

    public void insertionSort(Record[] arr, int n) {
        // TODO: Implement this sorting algorithm here.
        Record[] sortedArr = new Record[n];
        int i, key, j;
        for (i = 1; i < n; i++) {
            key = arr[i].getIdNumber();
            j = i - 1;
    
            // Move elements of arr[0..i-1],
            // that are greater than key,
            // to one position ahead of their
            // current position
            while (j >= 0 && arr[j].getIdNumber() > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            sortedArr[j + 1].getIdNumber = key;
        }
    }

    public void selectionSort(Record[] arr, int n) {
        // TODO: Implement this sorting algorithm here.
        
    }

    public void mergeSort(Record[] arr, int p, int r) {
        // TODO: Implement this sorting algorithm here.

    }

    /*
     * Define AT LEAST ONE more sorting algorithm here, apart from the
     * ones given above. Make sure that the method accepts an array of
     * records
     */
    public void bubbleSort(Record[] arr, int p, int r) {

    }

}