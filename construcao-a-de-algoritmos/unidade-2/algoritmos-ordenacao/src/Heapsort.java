import java.util.Arrays;
import java.util.Random;

public class Heapsort {

    /**
     * Constroi uma max-heap a partir de um vetor aleatorio
     */
    static void buildMaxHeap(int[] arr) {
        for (int j = (arr.length - 1) / 2; j >= 1; j--) {
            maxHeapify(arr, j, arr.length - 1);
        }
    }

    /**
     * Restaura propriedade de maxheap de uma subarvore
     *
     * @param arr vetor
     * @param i   raiz da subavore atual
     * @param n   tamanho da heap
     */
    static void maxHeapify(int[] arr, int i, int n) {
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

    static void heapsort(int[] arr) {
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


    public static int[] geraArrayAleatoria(int size, int min, int max) {
        int[] arr = new int[size + 1];
        Random random = new Random();

        for (int i = 1; i <= size; i++) {
            arr[i] = random.nextInt((max - min) + 1) + 1;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = geraArrayAleatoria(10, 1, 100);
        System.out.println(Arrays.toString(arr));

        heapsort(arr);
        System.out.println(Arrays.toString(arr));

    }

}
