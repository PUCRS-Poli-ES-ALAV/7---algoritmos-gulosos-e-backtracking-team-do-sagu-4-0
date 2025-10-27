public class Resolucao {
    //complexidade -> O(n!)

    public boolean[][] nRainhas(int n) {
        boolean[][] tabuleiro = new boolean[n][n];
        colocarRainhas(tabuleiro, 0);
        return tabuleiro;
    }

    private boolean colocarRainhas(boolean[][] tabuleiro, int coluna) {
        int n = tabuleiro.length;

        if (coluna == n) {
            return true; 
        }

        for (int linha = 0; linha < n; linha++) {
            if (podeColocar(tabuleiro, linha, coluna)) {
                tabuleiro[linha][coluna] = true;

                if (colocarRainhas(tabuleiro, coluna + 1)) {
                    return true;
                }

                tabuleiro[linha][coluna] = false; // backtrack
            }
        }

        return false;
    }

    private boolean podeColocar(boolean[][] tabuleiro, int linha, int coluna) {
        int n = tabuleiro.length;

        // Verifica linha à esquerda
        for (int i = 0; i < coluna; i++) {
            if (tabuleiro[linha][i]) {
                return false;
            }
        }

        // Verifica diagonal superior esquerda
        for (int i = linha - 1, j = coluna - 1; i >= 0 && j >= 0; i--, j--) {
            if (tabuleiro[i][j]) {
                return false;
            }
        }

        // Verifica diagonal inferior esquerda
        for (int i = linha + 1, j = coluna - 1; i < n && j >= 0; i++, j--) {
            if (tabuleiro[i][j]) {
                return false;
            }
        }

        return true;
    }
}
