package Simple;

public class MergeSort {

    public int[] sort (int[] toSort){

        int[] copyToSort = new int[toSort.length];

        System.arraycopy(toSort, 0, copyToSort, 0, toSort.length);

        recMergeSort(copyToSort,0,toSort.length-1);

        return copyToSort;
    }

    private void recMergeSort(int[] copyToSort, int lowerBound, int upperBound){
        if (lowerBound == upperBound) {
            return;
        }
        else {
            int mid = (lowerBound + upperBound) / 2;

            recMergeSort(copyToSort, lowerBound, mid);
            recMergeSort(copyToSort, mid + 1, upperBound);

            merge(copyToSort,lowerBound, mid+1, upperBound);
        }
    }

    private void merge(int[] copyToSort, int lowPtr, int highPtr, int upperBound){
        int[] workSpace = new int[copyToSort.length];
        int j = 0;
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound +1;

        while (lowPtr <= mid && highPtr <= upperBound) {
            if (copyToSort[lowPtr] < copyToSort[highPtr]) {
                workSpace[j++] = copyToSort[lowPtr++];
            } else {
                workSpace[j++] = copyToSort[highPtr++];
            }
        }

            while (lowPtr <= mid){
                workSpace[j++] = copyToSort[lowPtr++];
            }

            while (highPtr <= upperBound) {
                workSpace[j++] = copyToSort[highPtr++];
            }

            for (j=0; j < n; j++) {
                copyToSort[lowerBound + j] = workSpace[j];
            }
    }
}