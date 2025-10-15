import java.util.Arrays;

public class Intervalos {

    public static void main(String[] args) {
        Dupla[] intervalos = {
            new Intervalos().new Dupla(6, 15),
            new Intervalos().new Dupla(6, 15),
            new Intervalos().new Dupla(7, 16),
            new Intervalos().new Dupla(18, 24),
            new Intervalos().new Dupla(1, 26),
            new Intervalos().new Dupla(23, 28),
            new Intervalos().new Dupla(25, 30),
            new Intervalos().new Dupla(30, 34),
        };

        boolean[] resultado = otimizaIntervalos(intervalos);

        System.out.println("Intervalos selecionados:");
        for (int i = 0; i < intervalos.length; i++) {
            Dupla d = intervalos[i];
            System.out.printf("[%d, %d] -> %s%n", d.inicio, d.fim, resultado[i]);
        }
    }

    //Solucao suboptima?
    public static boolean[] otimizaIntervalos(Dupla[] intervalos) {
        boolean[] selecionados = new boolean[intervalos.length];

        Arrays.sort(intervalos, (a, b) -> {
            int durA = a.fim - a.inicio;
            int durB = b.fim - b.inicio;
            return Integer.compare(durA, durB);
        });

        int ultimoFim = Integer.MIN_VALUE;
        int ultimoInicio = Integer.MAX_VALUE;

        for (int i = 0; i < intervalos.length; i++) {
            Dupla atual = intervalos[i];
            if (atual.inicio > ultimoFim || atual.fim < ultimoInicio) {
                //nao sobrepoe
                selecionados[i] = true;
                ultimoFim = atual.fim;
                ultimoInicio = atual.inicio;
            } else {
                //sobrepoe
                selecionados[i] = false;
            }
        }

        return selecionados;
    }

    private class Dupla {
        public int inicio;
        public int fim;

        public Dupla(int inicio, int fim) {
            this.inicio = inicio;
            this.fim = fim;
        }
    }
}
