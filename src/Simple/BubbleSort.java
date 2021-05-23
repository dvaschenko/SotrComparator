package Simple;

public class BubbleSort {
// slowest and simplest algorithm
    public int[] sort(int[] toSort) { // takes your random array
        int in;
        int out;
        int temp;
        int[] copyToSort = new int[toSort.length];

        System.arraycopy(toSort, 0, copyToSort, 0, toSort.length);  // creates copy of array to sort

        for (out = copyToSort.length-1;out > 0 ; out--) {   // outer loop, goes through all elements
            for (in = 0; in < out; in++){                   // inner loop, compares two neighbours
                if (copyToSort[in] > copyToSort[in + 1]) {  // if left is bigger
                    temp = copyToSort[in];                  // then swap them and continue
                    copyToSort[in] = copyToSort[in + 1];
                    copyToSort[in + 1] = temp;
                }
            }
        }
        return copyToSort;                                  // this is sorted copy
    }

}
