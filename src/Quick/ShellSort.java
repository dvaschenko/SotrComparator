package Quick;
public class ShellSort {             // to see explanations visit https://en.wikipedia.org/wiki/Quicksort
    public int[] sort(int[] toSort){
        int inner;
        int outer;
        int temp;
        int[] sorted = new int[toSort.length];

        System.arraycopy(toSort, 0, sorted, 0, toSort.length);

        int h = 1;
        while (h <= sorted.length/3)
            h = h*3 +1;

            while (h > 0){
                for (outer = h; outer < sorted.length ; outer++) {
                    temp = sorted[outer];
                    inner = outer;

                    while (inner > h-1 && sorted[inner - h] >= temp) {
                        sorted[inner] = sorted[inner - h];
                        inner -= h;
                    }
                    sorted[inner] = temp;
                }
                h = (h - 1) / 3;
            }

        return sorted;
    }

}
