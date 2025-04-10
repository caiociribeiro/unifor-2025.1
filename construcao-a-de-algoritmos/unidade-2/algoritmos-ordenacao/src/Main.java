import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

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
        Scanner in = new Scanner(System.in);

        while (true) {
            int[] a = randomArray(100, 1, 1000);
            System.out.println(Arrays.toString(a));

            System.out.print("(1) Quicksort\n(2) Heapsort\n(3) Mergesort\n(4) Insertion-sort\n");
            System.out.print("Escolha: ");
            int choice = in.nextInt();
            while (choice <= 0 || choice > 4) {
                System.out.print("Invalido. Escolha: ");
                choice = in.nextInt();
            }

            long inicio = System.nanoTime();
            switch (choice) {
                case 1:
                    Sort.quicksort(a);
                    break;
                case 2:
                    Sort.heapsort(a);
                    break;
                case 3:
                    Sort.mergesort(a);
                    break;
                case 4:
                    Sort.insertionsort(a);
                    break;
            }
            long fim = System.nanoTime();

            System.out.println(Arrays.toString(a));
            System.out.printf("Executou em %d nanossegundos\n", fim - inicio);

            System.out.print("Continuar (S/N): ");
            if (in.next().equalsIgnoreCase("n")) break;

            System.out.println("\n");
        }

        in.close();
    }
}
