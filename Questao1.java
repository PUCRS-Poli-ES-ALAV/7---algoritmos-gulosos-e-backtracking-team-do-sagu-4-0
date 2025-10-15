import java.util.Arrays;

public class Questao1 {
    public static void main(String[] args) {
        int[] ui = {100, 25, 10, 5};
        moedas(ui, 2.89);
    }

    //Critério: escolher maiores moedas
    public static int [] moedas (int[] moedas, double valor) {
        Arrays.sort(moedas);
        int valorCentavos = (int) (valor * 100);
        int[] resposta = new int[moedas.length];


        for (int i = moedas.length-1; i>0; i--){
            resposta[i] = valorCentavos / moedas[i];
            valorCentavos = valorCentavos % moedas[i];
        }

        if(valorCentavos > moedas[0]){
            System.out.println("Não há troco, aceita bala?");
            return null;
        }
        System.out.println(Arrays.toString(resposta));
        return resposta;
    }
}