import java.util.Arrays;
import java.util.Random;

public class Quicksort {

    static int partition(int[] arr, int p, int r) {
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

    static void quicksort(int[] arr, int p, int r) {
        if (p < r) {
            int q = partition(arr, p, r);
            quicksort(arr, p, q - 1);
            quicksort(arr, q + 1, r);
        }
    }

    static int[] geraArrayAleatoria(int size, int min, int max) {
        int[] arr = new int[size];
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt((max - min) + 1) + 1;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = geraArrayAleatoria(100, 1, 1000);

        System.out.println(Arrays.toString(arr));

        quicksort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }
}
