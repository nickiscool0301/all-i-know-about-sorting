public class QuickSort {
    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int left, int right) {
        if(left >= right)  return;
        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        /*
        Explaination:
        - Why we need int smallerIndex = left ? -> Keep track of element less than pivot
        - When found num less than pivot then swap the current value with arr[smallerIndex], increase smallerIndex++
        - When reach the end, just swap in pivot with smallerIndex (since pivot is the next larger number)
         */
        int smallerIndex = left; // Pointer for the smaller element
        for (int j = left; j < right; j++) {
            if(arr[j] < pivot) {
                int temp = arr[j];
                arr[j] = arr[smallerIndex];
                arr[smallerIndex] = temp;
                smallerIndex++;

            }
        }
        int temp = arr[smallerIndex];
        arr[smallerIndex] = arr[right];
        arr[right] = temp;
        return smallerIndex;
    }
}
