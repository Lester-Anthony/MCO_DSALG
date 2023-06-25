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
        for (int i = 1; i < n; i++) { // (n)
            Record key = arr[i]; // n-1
            int j = i - 1; // n-1
            while (j >= 0 && arr[j].getIdNumber() > key.getIdNumber()) { // (n-1) (n+1)
                arr[j + 1] = arr[j]; // (n-1) (n)
                j--; // (n-1) (n)
            }
            arr[j + 1] = key; // n-1
        }
    }

    // (n) + (n-1) + (n-1) + (n-1) (n+1) + (n-1) (n) + (n-1) (n) + (n-1) = 3n^² + 4n - 3

    public void selectionSort(Record[] arr, int n) {
        for (int i = 0; i < n; i++) { // (n+1)
            int minIndex = i; // (n)
            for (int j = i + 1; j < n; j++) { // (n) (n+1)/2
                if (arr[j].getIdNumber() < arr[minIndex].getIdNumber()) { // (n) (n+1)/2
                    minIndex = j; // (n) (n+1)/2
                }
            }
            Record temp = arr[minIndex]; // (n)
            arr[minIndex] = arr[i]; // (n)
            arr[i] = temp; // (n)
        }
    }

    // (n+1) + (n) + (n) (n+1)/2 + (n) (n+1)/2 + (n) (n+1)/2 + (n) + (n) + (n) = n^2 + 6n + 1

    public void mergeSort(Record[] arr, int p, int r) {
        if (p < r) { // 2n -1
            int q = (p + r) / 2; // n-1
            mergeSort(arr, p, q); // n-1
            mergeSort(arr, q + 1, r); // n-1
            merge(arr, p, q, r); // (7n + 11)
        }
    }

    // T(n) = log2(n)*(12n + 7)

    private void merge(Record[] arr, int p, int q, int r) { // (1)
        int leftSide = q - p + 1; // (1)
        int rightSide = r - q; // (1)

        Record[] left = new Record[leftSide]; // (1)
        Record[] right = new Record[rightSide]; // (1)

        for (int i = 0; i < leftSide; i++) { // (n/2+1)
            left[i] = arr[p + i]; // (1)
        }
        for (int j = 0; j < rightSide; j++) { // (n/2+1)
            right[j] = arr[q + 1 + j]; // (1)
        }

        int i = 0, j = 0, k = p; // (3)

        while (i < leftSide && j < rightSide) { // (n+1)
            if (left[i].getIdNumber() <= right[j].getIdNumber()) { // (n) (1)
                arr[k] = left[i]; // (n) (1)
                i++; // (n) (1)
            } else {
                arr[k] = right[j];
                j++;
            }
            k++; // (n) (1)
        }

        while (i < leftSide) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < rightSide) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
    
    // 1 + 1 + 1 + 1 + 1 + (n/2+1) + 1 + (n/2+1) + 1 + 3 + (n+1) + 4n = 7n + 11

    public void bubbleSort(Record[] arr, int n) {
        for (int i = 0; i < n; i++) { // (n+1)
            for (int j = 0; j < n - i - 1; j++) { // (n) (n+1)/2
                if (arr[j].getIdNumber() > arr[j + 1].getIdNumber()) { // (n) (n+1)/2
                    Record temp = arr[j]; // (n) (n+1)/2
                    arr[j] = arr[j + 1]; // (n) (n+1)/2
                    arr[j + 1] = temp; // (n) (n+1)/2
                }
            }
        }
    }

    // (n+1) + (n) (n+1)/2 + (n) (n+1)/2 + (n) (n+1)/2 + (n) (n+1)/2 = 2n^2 + 3n + 1

    /*
     * Define AT LEAST ONE more sorting algorithm here, apart from the
     * ones given above. Make sure that the method accepts an array of
     * records
     */
    
    public boolean isSorted(Record[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i].getIdNumber() < arr[i - 1].getIdNumber()) {
                return false;
            }
        }
        return true;
    }

}