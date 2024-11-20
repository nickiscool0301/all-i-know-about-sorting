import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr = generateRandomArray(100, 1, 100);

        // Merge Sort
        MergeSort mergeSort = new MergeSort();
        long startTimeMergeSort = System.nanoTime();
        int[] res = mergeSort.mergeSort(arr);
        long endTimeMergeSort = System.nanoTime();
        System.out.println("Apply Merge Sort");
        Arrays.stream(res).forEach(e -> System.out.print(e + " "));
        System.out.println("\nTook " + (endTimeMergeSort - startTimeMergeSort) / 1000000.0 + " milli seconds");
        System.out.println("----------------------------------------------------------------------------------------------------\n");

        // QuickSort
        QuickSort quickSort = new QuickSort();
        long startTimeQuickSort = System.nanoTime();
        quickSort.quickSort(arr);
        long endTimeQuickSort = System.nanoTime();
        System.out.println("Apply Quick Sort");
        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
        System.out.println("\nTook " + (endTimeQuickSort - startTimeQuickSort) / 1000000.0 + " milli seconds");
        System.out.println("----------------------------------------------------------------------------------------------------\n");

        // Topological Sort

        int vertices = 6;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(5).add(2);
        graph.get(5).add(0);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(2).add(3);
        graph.get(3).add(1);
        TopologicalSort topologicalSort = new TopologicalSort();
        List<Integer> result = topologicalSort.topologicalSort(vertices, graph);
        System.out.println("Topological Sort: " + result);
        System.out.println("\n----------------------------------------------------------------------------------------------------\n");


    }

    public static int[] generateRandomArray(int size, int min, int max) {
        Random random = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(max - min + 1) + min;
        }

        return arr;
    }
}
