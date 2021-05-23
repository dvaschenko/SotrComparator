package Simple;

public class SelectionSort {

    public int[] sort(int[] toSort){
        int outer;
        int inner;
        int min;
        int temp;
        int[] copyToSort = new int[toSort.length];

        System.arraycopy(toSort, 0, copyToSort, 0, toSort.length);      //copy of array to sort

        for (outer = 0; outer < copyToSort.length-1; outer++) {                       // in an outer loop, take first element (position 0)
            min = outer;                                                              // let this element be minimal
            for (inner = outer+1; inner < copyToSort.length; inner++)                 // in an inner loop compare min with each of the rest of elements
                if(copyToSort[inner] < copyToSort[min])                               // if one of them is smaller
                    min = inner;                                                      // then smaller is minimal
                    temp = copyToSort[outer];                                         // and swap them
                    copyToSort[outer] = copyToSort[min];
                    copyToSort[min] = temp;
        }                                                                             // after first outer loop we have the smallest element at first position,
        return copyToSort;                                                            // and continue the same from [1],[2] ... [last]
    }
}
