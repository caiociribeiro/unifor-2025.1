import java.util.Arrays;
import java.util.Random;

public class Main {

    /**
     * gera vetor aleatorio
     *
     * @param size tamanho do vetor
     * @param min  valor minimo (incluso) a ser sorteado
     * @param max  valor maximo (incluso) a ser sorteado
     * @return vetor
     */
    static int[] randomArray(int size, int min, int max) {
        Random random = new Random();

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt((max - min) + 1) + 1;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] a = randomArray(10, 1, 1000);
        System.out.println(Arrays.toString(a));

        Sort.quicksort(a);
        System.out.println("Quicksort...");
        System.out.println(Arrays.toString(a));

        System.out.println();

        int[] b = randomArray(10, 1, 1000);
        System.out.println(Arrays.toString(b));

        Sort.heapsort(b);
        System.out.println("Heapsort...");
        System.out.println(Arrays.toString(b));
    }
}
