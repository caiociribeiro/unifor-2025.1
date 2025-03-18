import java.util.concurrent.TimeUnit;

public class exercicio1 {
    public static void main(String[] args) {
        System.out.printf("metodo1\n");
        System.out.printf("%10s%20s%10s\n","n", "solucao", "tempo");
        for (int n = 0; n <= 10; n+=1) {
            metodo1(n);
        }
        System.out.printf("metodo2\n");
        System.out.printf("%10s%20s%10s\n","n", "solucao", "tempo");
        for (int n = 0; n <= 10; n+=1) {
            metodo2(n);
        }
        System.out.printf("metodo3\n");
        System.out.printf("%10s%20s%10s\n","n", "solucao", "tempo");
        for (int n = 0; n <= 10; n+=1) {
            metodo3(n);
        }
        System.out.printf("metodo4\n");
        System.out.printf("%10s%20s%10s\n","n", "solucao", "tempo");
        for (int n = 0; n <= 10; n+=1) {
            metodo4(n);
        }
        System.out.printf("metodo5\n");
        System.out.printf("%10s%20s%10s\n","n", "solucao", "tempo");
        for (int n = 0; n <= 10; n+=1) {
            metodo5(n);
        }

    }

    static void metodo1 (long n) {
        double inicio = System.currentTimeMillis();
        long valor = 0;
        long termo = n * n * n * n;
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (long i = 1; i <= 4; i++) {
            valor += termo;
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        double fim = System.currentTimeMillis();
        double tempo = fim - inicio;
        System.out.printf("%10d%20d%10.0f\n", n, valor, tempo);
    }

    static void metodo2 (long n) {
        double inicio = System.currentTimeMillis();
        long valor = 0;
        long termo = 4 * n * n * n;
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (long i = 1; i <= n; i++) {
            valor += termo;
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        double fim = System.currentTimeMillis();
        double tempo = fim - inicio;
        System.out.printf("%10d%20d%10.0f\n", n, valor, tempo);
    }

    static void metodo3 (long n) {
        double inicio = System.currentTimeMillis();
        long valor = 0;
        long termo = n * n * n;
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (long i = 1; i <= 4; i++) {
            for (long j = 1; j <= n; j++) {
                valor += termo;
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        double fim = System.currentTimeMillis();
        double tempo = fim - inicio;
        System.out.printf("%10d%20d%10.0f\n", n, valor, tempo);
    }

    static void metodo4 (long n) {
        double inicio = System.currentTimeMillis();
        long valor = 0;
        long termo = n * n;
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (long i = 1; i <= 2 * n; i++) {
            for (long j = 1; j <= 2 * n; j++) {
                valor += termo;
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        double fim = System.currentTimeMillis();
        double tempo = fim - inicio;
        System.out.printf("%10d%20d%10.0f\n", n, valor, tempo);
    }

    static void metodo5 (long n) {
        double inicio = System.currentTimeMillis();
        long valor = 0;
        long termo = 4 * n;
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (long i = 1; i <= n; i++) {
            for (long j = 1; j <= n; j++) {
                for (long k = 1; k <= n; k++) {
                    valor += termo;
                    try {
                        TimeUnit.MILLISECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        double fim = System.currentTimeMillis();
        double tempo = fim - inicio;
        System.out.printf("%10d%20d%10.0f\n", n, valor, tempo);
    }
}
