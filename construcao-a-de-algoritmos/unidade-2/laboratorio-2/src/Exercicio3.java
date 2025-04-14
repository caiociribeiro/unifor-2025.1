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

    static void organizaTurno(Crianca[] A) {
        for (int i = A.length - 1, t = i; i >= 0; i--) {
            if (A[i].turno == 'T') {
                Crianca aux = A[i];
                A[i] = A[t];
                A[t] = aux;
                t--;
            }
        }
    }

    static void organizaIdade(Crianca[] A) {
        for (int i = A.length - 1, j = i, k = i; i >= 0; i--) {
            if (A[i].idade >= 6 && A[i].idade <= 10) {
                Crianca aux = A[i];
                A[i] = A[k];
                A[k] = aux;
                if (j < k) {
                    aux = A[i];
                    A[i] = A[j];
                    A[j] = aux;
                }
                k--;
                j--;
            } else if (A[i].idade >= 11 && A[i].idade <= 13) {
                Crianca aux = A[i];
                A[i] = A[j];
                A[j] = aux;
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
