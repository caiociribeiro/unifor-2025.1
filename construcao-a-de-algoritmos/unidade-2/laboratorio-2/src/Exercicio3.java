import java.util.Random;

public class Exercicio3 {

    public static void main(String[] args) {
        int n = 20;
        Crianca[] criancas = new Crianca[n];
        for (int i = 0; i < criancas.length; i++) {
            criancas[i] = new Crianca();
        }
        imprime(criancas);
        //organizaTurno(criancas);
        organizaIdade(criancas);
        imprime(criancas);
    }

    static void troca(Crianca[] A, int i, int j) {
        Crianca aux = A[i];
        A[i] = A[j];
        A[j] = aux;
    }

    static void organizaTurno(Crianca[] A) {
        for (int i = A.length - 1, t = i; i >= 0; i--) {
            if (A[i].turno == 'T') {
                troca(A, i, t);
                t--;
            }
        }
    }

    static void organizaIdade(Crianca[] A) {
        // j - ponteiro da idade 11 a 13
        // k - ponteiro da idade de 14 a 16
        for (int i = A.length - 1, j = i, k = i; i >= 0; i--) {
            // se o elemento atual pertence ao grupo de 14 a 16, faz a troca com o elemento no ponteiro k
            if (A[i].idade >= 6 && A[i].idade <= 10) {
                troca(A, i, k);
                // se o ponteiro j nao estiver na mesma posicao de k
                // com certeza o elemento trocado era um elemento da idade 11 a 13
                // portanto faz a troca
                if (j < k) {
                    troca(A, i, j);
                }
                k--;
                j--;
            } else if (A[i].idade >= 11 && A[i].idade <= 13) {
                troca(A, i, j);
                j--;
            }
        }
    }

    static void imprime(Crianca[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.printf("%15s%7d%7c\n", A[i].nome, A[i].idade, A[i].turno);
        }
        System.out.print("\n\n\n");
    }

    static class Crianca {
        public String nome;
        public int idade;
        public char turno;

        public Crianca() {
            Random randomGenerator = new Random();
            nome = "";
            nome += (char) ('A' + randomGenerator.nextInt(26));
            for (int i = 2; i <= 10; i++) {
                nome += (char) ('a' + randomGenerator.nextInt(26));
            }
            idade = 6 + randomGenerator.nextInt(11);
            turno = (randomGenerator.nextInt(2) == 0) ? 'M' : 'T';
        }
    }
}
