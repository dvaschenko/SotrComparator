import Quick.*;
import Simple.*;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;

public class SortApp {
    public static void main(String[] args) throws IOException {
        int maxSize;
        int[] arr;

        System.out.println("""
                Welcome to SortComparator application!
                
                Hint: arrays with size of 100 000 elements are good idea to compare algorithms, arrays that are bigger may take to long time to be sorted with simple algorithms
                To get started insert array size, please:""");

        maxSize = Integer.parseInt(getString());

        arr = new int[maxSize];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10000);
        }


        System.out.println("Here is yours random array:");
        System.out.println(Arrays.toString(arr));
        System.out.println();
        System.out.println("Please, bear in mind that each time You use one of sorting methods, this array is NOT CHANGED, so you may try another sorting algorithm");

        SortApp sortApp = new SortApp();


        sortApp.sort(arr);

        while (askToContinue()) {
            sortApp.sort(arr);
            Arrays.sort(arr);
        }
    }

    public void sort(int[] arr) throws IOException {
        System.out.println("Select sorting type please, where \"simple\" is simple sort and \"quick\" is not trivial sort, Enter the first letter, please:");
        String sortType = getString();
        long start;                 // time stamp, start of sorting
        long finish;                // time stamp, end of sorting
        long length;                // sorting duration

        switch (sortType) {

            case "s" -> {
                System.out.println("Select Bubble, Insertion or Selection, please, enter the first letter:");
                String choseSorter = getString();
                char method = choseSorter.charAt(0);

                switch (method) {

                    case 'b' -> {
                        BubbleSort bubble = new BubbleSort();
                        start = System.currentTimeMillis();
                        int[] sorted = bubble.sort(arr);
                        finish = System.currentTimeMillis();
                        length = finish - start;
                        System.out.println("Here are a sorted copy of your array: " + Arrays.toString(sorted));
                        System.out.println("Sorting took " + length + " ms");
                    }
                    case 's' -> {
                        SelectionSort selection = new SelectionSort();
                        start = System.currentTimeMillis();
                        int[] sorted = selection.sort(arr);
                        finish = System.currentTimeMillis();
                        length = finish - start;
                        System.out.println("Here are a sorted copy of your array: " + Arrays.toString(sorted));
                        System.out.println("Sorting took " + length + " ms");
                    }
                    case 'i' -> {
                        InsertionSort insertion = new InsertionSort();
                        start = System.currentTimeMillis();
                        int[] sorted = insertion.sort(arr);
                        finish = System.currentTimeMillis();
                        length = finish - start;
                        System.out.println("Here are a sorted copy of your array: " + Arrays.toString(sorted));
                        System.out.println("Sorting took " + length + " ms");
                    }

                    default -> {
                        System.out.println("Do not know this method " + "*" + choseSorter + "*" + " try again, please");
                        sort(arr);
                    }
                }
            }

            case "q" -> {
                System.out.println("Select Shell, Merge or Quick, please, enter the first letter:");
                String choseSorter = getString();
                char method = choseSorter.charAt(0);
                switch (method) {
                    case 's' -> {
                        ShellSort shellSort = new ShellSort();
                        start = System.currentTimeMillis();
                        int[] sorted = shellSort.sort(arr);
                        finish = System.currentTimeMillis();
                        length = finish - start;
                        System.out.println("Here are a sorted copy of your array: " + Arrays.toString(sorted));
                        System.out.println("Sorting took " + length + " ms");
                    }
                    case 'q' -> {
                        QuickSort quickSort = new QuickSort();
                        start = System.currentTimeMillis();
                        int[] sorted = quickSort.sort(arr);
                        finish = System.currentTimeMillis();
                        length = finish - start;
                        System.out.println("Here are a sorted copy of your array: " + Arrays.toString(sorted));
                        System.out.println("Sorting took " + length + " ms");
                    }

                    case 'm' -> {
                        MergeSort mergeSort = new MergeSort();
                        start = System.currentTimeMillis();
                        int[] sorted = mergeSort.sort(arr);
                        finish = System.currentTimeMillis();
                        length = finish - start;
                        System.out.println("Here are a sorted copy of your array: " + Arrays.toString(sorted));
                        System.out.println("Sorting took " + length + " ms");
                    }

                    default -> {
                        System.out.println("Do not know this method " + "*" + choseSorter + "*" + " try again, please");
                        sort(arr);
                    }
                }
            }
            default -> {
                System.out.println("Do not know this type " + "*" + sortType + "*" + " try again, please");
                sort(arr);
            }
        }
    }

    public static boolean askToContinue() throws IOException {
        System.out.println("Would you like to continue sorting? Enter Y/N");
        String answer = getString().toLowerCase(Locale.ROOT);
        return answer.equals("y");

    }

    private static String getString() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }
}

