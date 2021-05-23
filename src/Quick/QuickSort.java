package Quick;

public class QuickSort {   // to see explanations visit https://en.wikipedia.org/wiki/Quicksort

    public int[] sort(int[] toSort) {
        int[] copyToSort = new int[toSort.length];

        System.arraycopy(toSort, 0, copyToSort, 0, toSort.length);

        recQickSort(copyToSort, 0, toSort.length -1);

        return copyToSort;
    }
    private void recQickSort(int[] copyToSort, int left, int right){
        if ((right - left) <= 0) {
            return;
        }
        else {
            int pivot = copyToSort[right];

            int partition = partitionIt (copyToSort, left, right, pivot);
            recQickSort(copyToSort, left, partition -1);
            recQickSort(copyToSort, partition + 1, right);
        }
    }
    private int partitionIt (int[] copyToSort, int left, int right, int pivot) {
        int leftPtr = left -1;
        int rightPtr = right;
        while (true) {
            while (copyToSort[++leftPtr] < pivot)
            ;
            while (rightPtr > 0 && copyToSort[--rightPtr] > pivot )
            ;
            if(leftPtr >= rightPtr)
                break;
            else swap(copyToSort,leftPtr, rightPtr);
        }
        swap(copyToSort,leftPtr, right);

        return leftPtr;
    }
    private void swap(int[] copyToSort, int dex1, int dex2){
        int temp;
        temp = copyToSort[dex1];
        copyToSort[dex1] = copyToSort[dex2];
        copyToSort[dex2] = temp;
    }
}
