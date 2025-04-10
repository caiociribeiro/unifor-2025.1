import java.util.Random;

public class Exercicio1 {
    public static void main(String[] args) {
        int[] A = criaVetorUnimodal(15);
        imprimeVetor(A);
        int pos1 = posMaior1(A);
        System.out.printf("\n%d\n", pos1);
        int pos2 = posMaior2(A, 0, A.length - 1);
        System.out.printf("%d\n", pos2);
    }

    static int posMaior1 (int[] vetor) {
        int pos = 0;
        while (vetor[pos+1] > vetor[pos]) {
            pos = pos + 1;
        }
        return pos;
    }

    static int posMaior2 (int[] vetor, int i, int f) {
        if (i == f) return i;

        int m = (i + f) / 2;
        if (vetor[m + 1] < vetor[m])
            return posMaior2(vetor, i, m);
        return posMaior2(vetor, m + 1, f);
    }

    static void imprimeVetor (int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            if (i == 0)
                System.out.print("[ ");
            System.out.printf("%d ", vetor[i]);
            if (i == vetor.length - 1)
                System.out.print("]");
        }
    }


    static int[] criaVetorUnimodal (int n) {
        Random randomGenerator = new Random();
        int p = randomGenerator.nextInt(n-2) + 1;
        int[] vetor = new int[n];
        vetor[0] = randomGenerator.nextInt(10);
        for (int i = 1; i < n; i++) {
            vetor[i] = vetor[i-1] + randomGenerator.nextInt(10) + 1;
        }
        int a = p; int b = n-1;
        while (a < b) {
            int aux = vetor[a];
            vetor[a] = vetor[b];
            vetor[b] = aux;
            a++; b--;
        }
        return vetor;
    }

}
