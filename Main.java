public class Main {
    public static void main(String[] args) {
        Resolucao resolucao = new Resolucao();
        boolean[][] resultado = resolucao.nRainhas(8);
        if (resultado != null) {
            for (boolean[] linha : resultado) {
                for (boolean posicao : linha) {
                    System.out.print(posicao ? "R " : ". ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Solução não encontrada.");
        }
    }
}
