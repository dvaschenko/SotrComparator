package Simple;

public class InsertionSort {
    // usually fastest from simple algorithms


    public int[] sort(int[] toSort){
        int inner;                                                                   // goes into array
        int outer;                                                                   // to be extracted from its position
        int[] copyToSort = new int[toSort.length];

        System.arraycopy(toSort, 0, copyToSort, 0, toSort.length);     // copy of array to sort

        for (outer = 1; outer < copyToSort.length; outer++){                        // start looping from second element
            int temp = copyToSort[outer];                                           // take this element as marker and extract him from array
            inner = outer;                                                          // inner becomes equal outer
            while ((inner > 0) && (copyToSort[inner-1] >= temp)){                   // while we do not find something smaller that our inner
                copyToSort[inner] = copyToSort[inner-1];                            // move pointer to the left and move
                --inner;                                                            // biggest elements to the right
            }
            copyToSort[inner] = temp;                                               // insert marked element into position it belong (elements on the left are
        }                                                                           // smaller and elements on the right are bigger)
                                                                                    // repit till the last element

        return copyToSort;
    }
}
