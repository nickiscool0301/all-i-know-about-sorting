import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 1, 9, 7, 3, 2};
        MergeSort mergeSort = new MergeSort();
        int[] res = mergeSort.mergeSort(arr);
        Arrays.stream(res).forEach(e -> System.out.print(e + ", "));
    }
}
