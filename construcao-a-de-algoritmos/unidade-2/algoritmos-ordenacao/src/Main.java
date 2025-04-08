import java.util.Arrays;
import java.util.Random;

public class Main {

    /**
     * gera vetor aleatorio
     *
     * @param size          tamanho do vetor
     * @param min           valor minimo a ser sorteado
     * @param max           valor maximo a ser sorteado
     * @param oneBasedIndex flag que define o tipo de indexacao do vetor. True para 1-based, false para 0-based.
     * @return vetor
     */
    static int[] randomArray(int size, int min, int max, boolean oneBasedIndex) {
        Random random = new Random();

        int[] arr = oneBasedIndex ? new int[size + 1] : new int[size];

        int last = oneBasedIndex ? size : size - 1;

        for (int i = oneBasedIndex ? 1 : 0; i <= last; i++) {
            arr[i] = random.nextInt((max - min) + 1) + 1;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] a = randomArray(10, 1, 1000, false);
        System.out.println(Arrays.toString(a));

        Sort.quicksort(a, 0, a.length - 1);
        System.out.println("Quicksort...");
        System.out.println(Arrays.toString(a));

        System.out.println();

        int[] b = randomArray(10, 1, 1000, true);
        System.out.println(Arrays.toString(b));

        Sort.heapsort(b);
        System.out.println("Heapsort...");
        System.out.println(Arrays.toString(b));
    }
}
