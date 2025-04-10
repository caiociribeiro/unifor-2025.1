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

    /**
     * Ordena um subvetor de i a f que ja esta ordenado de i a q
     * e de q + 1 a f.
     *
     * @param arr vetor
     * @param i   posicao do primeiro elemento do subvetor a ser ordenado
     * @param f   posicao do ultimo elemento do subvetor a ser ordenado
     * @param q   posicao que divide o subvetor em outros dois subvetores
     */
    private static void merge(int[] arr, int i, int f, int q) {
        int[] left = new int[q - i + 2];
        int[] right = new int[f - q + 1];

        for (int j = 0, k = i; j < left.length - 1; j++, k++) {
            left[j] = arr[k];
        }

        for (int j = 0, k = q + 1; j < right.length - 1; j++, k++) {
            right[j] = arr[k];
        }

        left[left.length - 1] = Integer.MAX_VALUE;
        right[right.length - 1] = Integer.MAX_VALUE;

        for (int l = 0, r = 0; i <= f; i++) {
            if (left[l] <= right[r]) {
                arr[i] = left[l];
                l++;
            } else {
                arr[i] = right[r];
                r++;
            }
        }
    }

    /**
     * @param arr vetor a ser ordenado
     * @param i   posicao inicial do subvetor a ser ordenado
     * @param f   posicao final do subvetor a ser ordenado
     */
    private static void mergesort(int[] arr, int i, int f) {
        if (i < f) {
            int q = (i + f) / 2;
            mergesort(arr, i, q);
            mergesort(arr, q + 1, f);
            merge(arr, i, f, q);
        }
    }

    /**
     * @param arr vetor a ser ordenado
     */
    public static void mergesort(int[] arr) {
        mergesort(arr, 0, arr.length - 1);
    }


    //TODO: selectionsort

    //TODO: countingsort

    /*
     *
     * Insertion-sort
     *
     */

    public static void insertionsort(int[] arr) {
        for (int j = 1; j < arr.length; j++) {
            int i = j - 1;
            int key = arr[j];
            while (i >= 0 && arr[i] > key) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = key;
        }
    }

    //TODO: bubblesort

}
