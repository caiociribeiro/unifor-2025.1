public class Testes {
    public static void main(String[] args) {
        calcula(100);
        metodo5(100);
    }

    static void metodo5(long n) {
        long valor = 0;
        long termo = 4 * n;

        int loop1 = 0;
        int loop2 = 0;
        int loop3 = 0;
        int termoExecutado = 0;

        loop1 += 1;
        for (long i = 1; i <= n; i++) {

            loop2 += 1;
            for (long j = 1; j <= n; j++) {

                loop3 += 1;
                for (long k = 1; k <= n; k++) {
                    valor += termo;
                    termoExecutado += 1;

                    loop3 += 1;
                }

                loop2 += 1;
            }

            loop1 += 1;
        }

        System.out.printf("%d %d %d %d\n", loop1, loop2, loop3, termoExecutado);
    }

    static void calcula(long n) {
        long x = (n + 1) * (n * (n + 1) - n);
        System.out.println(x);
    }

}
