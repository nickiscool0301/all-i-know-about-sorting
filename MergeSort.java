import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeSort {
    public int[] mergeSort(int[] arr) {
        if (arr.length <= 1) return arr;
        int mid = arr.length / 2;
        int[] arrLeft = Arrays.copyOfRange(arr, 0, mid);
        int[] arrRight = Arrays.copyOfRange(arr, mid, arr.length);
        arrLeft = mergeSort(arrLeft);
        arrRight= mergeSort(arrRight);
        return merge(arrLeft, arrRight);
//        return IntStream.concat(Arrays.stream(arrLeft), Arrays.stream(arrRight)).sorted().toArray();
    }

    private int[] merge(int[] arr1, int[] arr2) {
        int l1 = arr1.length;
        int l2 = arr2.length;
        int[] res = new int[l1 + l2];
        int i = 0, j = 0, z = 0;
        while(i < l1 && j < l2) {
            if(arr1[i] <= arr2[j]) {
                res[z++] = arr1[i++];
            } else res[z++] = arr2[j++];
        }
        while(i < l1) res[z++] = arr1[i++];
        while(j < l2) res[z++] = arr2[j++];
        return res;
    }
}
