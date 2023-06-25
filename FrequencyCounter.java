public class FrequencyCounter {
    
    public long insertionSort(Record[] arr, int n) {
        long count = 0;

        count++;
        for (int i = 1; i < n; i++) {    
            count++;                                    
            Record key = arr[i];                                                  
            count++;                                    
            int j = i - 1;                                                             
            count++;                                    
            while (j >= 0 && arr[j].getIdNumber() > key.getIdNumber()) {               
                count++;                                    
                arr[j + 1] = arr[j];
                count++;                                    
                j--;
            }
            count++;                                    
            arr[j + 1] = key;
        }

        return count;
    }

    public long selectionSort(Record[] arr, int n) {
        long count = 0;

        count++;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            count++;
            for (int j = i + 1; j < n; j++) {
                count++;
                if (arr[j].getIdNumber() < arr[minIndex].getIdNumber()) {
                    count++;
                    minIndex = j;
                }
            }
            count++;
            Record temp = arr[minIndex];
            count++;
            arr[minIndex] = arr[i];
            count++;
            arr[i] = temp;
        }

        return count;
    }

    public long mergeSort(Record[] arr, int p, int r) {
        long count = 0;
        count++;
        if (p < r) {
            count++;
            int q = (p + r) / 2;
            count++;
            count += mergeSort(arr, p, q);
            count++;
            count += mergeSort(arr, q + 1, r);
            count++;
            merge(arr, p, q, r);
        }
        return count;
    }

    private long merge(Record[] arr, int p, int q, int r) {
        long count = 0;

        count++;
        int leftSide = q - p + 1;
        count++;
        int rightSide = r - q;
        
        count++;
        Record[] left = new Record[leftSide];
        count++;
        Record[] right = new Record[rightSide];
        
        count++;
        for (int i = 0; i < leftSide; i++) {
            count++;
            left[i] = arr[p + i];
        }
        count++;
        for (int j = 0; j < rightSide; j++) {
            count++;
            right[j] = arr[q + 1 + j];
        }
        
        count++;
        int i = 0, j = 0, k = p;
        
        count++;
        while (i < leftSide && j < rightSide) {
            count++;
            if (left[i].getIdNumber() <= right[j].getIdNumber()) {
                count++;
                arr[k] = left[i];
                count++;
                i++;
            } 
            else {
                count++;
                arr[k] = right[j];
                count++;
                j++;
            }
            count++;
            k++;
        }
        
        count++;
        while (i < leftSide) {
            count++;
            arr[k] = left[i];
            count++;
            i++;
            count++;
            k++;
        }
        
        count++;
        while (j < rightSide) {
            count++;
            arr[k] = right[j];
            count++;
            j++;
            count++;
            k++;
        }

        return count;
    }
    
    public long bubbleSort(Record[] arr, int n) {
        long count = 0;

        count++;
        for (int i = 0; i < n - 1; i++) {
            count++;
            for (int j = 0; j < n - i - 1; j++) {
                count++;
                if (arr[j].getIdNumber() > arr[j + 1].getIdNumber()) {
                    count++;
                    Record temp = arr[j];
                    count++;
                    arr[j] = arr[j + 1];
                    count++;
                    arr[j + 1] = temp;
                }
            }
        }
        return count;
    }

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
