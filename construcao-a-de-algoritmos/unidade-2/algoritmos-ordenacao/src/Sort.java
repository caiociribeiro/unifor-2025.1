public class Sort {

    /*
     *
     * Quicksort
     *
     */

    /**
     * Posiciona um elemento no vetor de modo que os elementos a sua esquerda sao menores ou iguais
     * a ele e os elementos a sua direita sao maiores que ele.
     *
     * @param arr vetor a ser particionado
     * @param p   posicao inicial do subvetor a ser particionado
     * @param r   posicao final do subvetor a ser particionado
     * @return posicao do elemento pivot
     */
    private static int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (arr[j] <= pivot) {
                i++;
                if (i != j) {
                    int aux = arr[i];
                    arr[i] = arr[j];
                    arr[j] = aux;
                }
            }
        }

        int aux = arr[r];
        arr[r] = arr[i + 1];
        arr[i + 1] = aux;

        return i + 1;
    }

    /**
     * @param arr vetor a ser ordenado
     * @param p   posicao inicial do subvetor a ser ordenado
     * @param r   posicao final do subvetor a ser ordenado
     */
    private static void quicksort(int[] arr, int p, int r) {
        if (p < r) {
            int q = partition(arr, p, r);
            quicksort(arr, p, q - 1);
            quicksort(arr, q + 1, r);
        }
    }

    /**
     * @param arr vetor a ser ordenado
     */
    public static void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    /*
     *
     * Heapsort
     *
     */

    /**
     * Constroi uma max-heap a partir de um vetor aleatorio.
     *
     * @param arr vetor a ser transformado em maxheap
     */
    private static void buildMaxHeap(int[] arr) {
        for (int j = arr.length / 2; j >= 0; j--) {
            maxHeapify(arr, j, arr.length);
        }
    }

    /**
     * Restaura propriedade de maxheap de uma subarvore
     *
     * @param arr vetor
     * @param i   posicao do elemento que representa a raiz da subarvore a sofrer max-heapify
     * @param n   tamanho da heap
     */
    private static void maxHeapify(int[] arr, int i, int n) {
        int l = i * 2 + 1;
        int r = i * 2 + 2;

        int largest = i;

        if (l < n) {
            if (arr[l] > arr[largest])
                largest = l;

            if (r < n && arr[r] > arr[largest]) {
                largest = r;
            }

            if (largest != i) {
                int aux = arr[i];
                arr[i] = arr[largest];
                arr[largest] = aux;

                maxHeapify(arr, largest, n);
            }
        }
    }

    /**
     * @param arr vetor a ser ordenado
     */
    public static void heapsort(int[] arr) {
        buildMaxHeap(arr);

        for (int n = arr.length, i = n - 1; i >= 1; i--) {
            int aux = arr[i];
            arr[i] = arr[0];
            arr[0] = aux;

            n--;

            maxHeapify(arr, 0, n);
        }
    }

    /*
     *
     * Mergesort
     *
     */

    
    //TODO: selectionsort

    //TODO: countingsort

    //TODO: insertionsort

    //TODO: bubblesort

}
