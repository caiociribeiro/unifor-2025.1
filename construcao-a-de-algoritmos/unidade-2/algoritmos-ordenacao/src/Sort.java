public class Sort {

    // Quicksort

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

    // Heapsort

    /**
     * Constroi uma max-heap a partir de um vetor aleatorio.
     *
     * @param arr vetor a ser transformado em maxheap
     */
    private static void buildMaxHeap(int[] arr) {
        for (int j = (arr.length - 1) / 2; j >= 1; j--) {
            maxHeapify(arr, j, arr.length - 1);
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
        int l = i * 2;
        int r = i * 2 + 1;
        if (l <= n) {
            int largest = arr[l] > arr[i] ? l : i;
            if (r <= n) {
                largest = arr[r] > arr[largest] ? r : largest;
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
        int n = arr.length - 1;
        for (int i = n; i >= 2; i--) {
            int aux = arr[i];
            arr[i] = arr[1];
            arr[1] = aux;

            n--;

            maxHeapify(arr, 1, n);
        }
    }

    //TODO: mergesort

}
