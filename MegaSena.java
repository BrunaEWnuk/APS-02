import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MegaSena {
    public static void main(String[] args) {
        boolean[] sorteio = new boolean[61];
        boolean[] aposta = new boolean[61];

        Scanner scanner = new Scanner(System.in);
        System.out.println("$$$$$$$$$$$$$$$$$$ - MEGA SENA - $$$$$$$$$$$$$$$$$$");
        System.out.println("$                                                 $");
        System.out.println("$                                                 $");
        System.out.println("    Você pode jogar marcando o quadro abaixo:     $");
        System.out.println("$                                                 $");
        System.out.println("$                                                 $");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("$ 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 10 $");
        System.out.println("$ 11 | 12 | 13 | 14 | 15 | 16 | 17 | 18 | 19 | 20 $");
        System.out.println("$ 21 | 22 | 23 | 24 | 25 | 26 | 27 | 28 | 29 | 30 $");
        System.out.println("$ 31 | 32 | 33 | 34 | 35 | 36 | 37 | 38 | 39 | 40 $");
        System.out.println("$ 41 | 42 | 43 | 44 | 45 | 46 | 47 | 48 | 49 | 50 $");
        System.out.println("$ 51 | 52 | 53 | 54 | 55 | 56 | 57 | 58 | 59 | 60 $");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println();

        // Aposta do usuário
        System.out.println("Informe 6 números de 1 a 60 para a aposta:");
        for (int i = 0; i < 6; i++) {
            int numAposta = scanner.nextInt();
            if (numAposta >= 1 && numAposta <= 60) {
                aposta[numAposta] = true;

            } else {
                System.out.println("Número inválido. Insira novamente.");
                i--;

            }
        }

        // Sorteando os números da Mega Sena
        Random random = new Random();
        System.out.println("Sorteando os números...");

        int[] numerosSorteados = new int[6];
        int indice = 0;

        while (indice < 6) {
            int numSorteado = random.nextInt(60) + 1;

            if (!sorteio[numSorteado]) {

                sorteio[numSorteado] = true;
                numerosSorteados[indice] = numSorteado;
                indice++;

            }
        }

        System.out.println("Números sorteados: " + Arrays.toString(numerosSorteados));

        // Convertendo os vetores 'sorteio' e 'aposta' em matrizes bidimensionais
        boolean[][] matriz_sorteio = new boolean[6][10];
        for (int i = 0; i < matriz_sorteio.length; i++) {
            for (int j = 0; j < matriz_sorteio[i].length; j++) {
                matriz_sorteio[i][j] = sorteio[(i * 10) + j + 1];
                /*
                 * Explicação do uso de 'matriz_sorteio[i][j] = sorteio[(i * 10) + j + 1]':
                 * 
                 * O 'i' representa as linhas da matriz e o 'j' a coluna da matriz;
                 * Cada linha da matriz representa um número de 1...10, 11...20, 21...30,
                 * 31...40, 41...50 e 51...60;
                 * Para percorrer a matriz com o 'i' do vetor 'sorteio' é realizado a conta:
                 * 
                 * '(i * 10)' é utilizada para realizar o deslocamento da faixa de números
                 * - Por exemplo, se 'i' for '1', o deslocamento será 10 (segunda faixa de
                 * números: 11 a 20)...
                 * O 'j' é utilizado para percorrer cada elemento dentro da linha;
                 * Por fim é utilizado o '+ 1' para corrigir as diferenças dos números do jogo
                 * que iniciam em 1
                 * dos indices dos vetores que iniciam em 0.
                 * 
                 * De forma resumida, 'sorteio[(i * 10) + j + 1]' serve para definir o indice do
                 * vetor que
                 * representa os números sorteados dentro da matriz.
                 */
            }
        }

        boolean[][] matriz_aposta = new boolean[6][10];
        for (int i = 0; i < matriz_aposta.length; i++) {
            for (int j = 0; j < matriz_aposta[i].length; j++) {
                matriz_aposta[i][j] = aposta[(i * 10) + j + 1];
            }
        }
        System.out.println();

        // Apresentando de forma organizada os valores sortados(true) dentro da matriz
        System.out.println("Sorteio:");
        System.out.println();
        for (int i = 0; i < matriz_sorteio.length; i++) {
            for (int j = 0; j < matriz_sorteio[i].length; j++) {
                System.out.print(matriz_sorteio[i][j] + "  -  ");
            }
            System.out.println();
        }

        System.out.println();
        // Apresentando de forma organizada os valores apostados(true) dentro da matriz
        System.out.println("Aposta:");
        System.out.println();
        for (int i = 0; i < matriz_aposta.length; i++) {
            for (int j = 0; j < matriz_aposta[i].length; j++) {
                System.out.print(matriz_aposta[i][j] + "  -  ");
            }
            System.out.println();
        }
        System.out.println();

        // Contabilização dos acertos
        int numAcertos = 0;
        for (int i = 1; i < aposta.length; i++) {
            if (aposta[i] && sorteio[i]) {
                numAcertos++;
            }
        }

        System.out.println("Acertos: " + numAcertos);

        // Valida se o usúario ganhou com a aposta
        if (numAcertos <= 3) {
            System.out.println("Você não ganhou nada. Tente novamente!");
        } else if (numAcertos == 4) {
            System.out.println("Você fez uma quadra!");
        } else if (numAcertos == 5) {
            System.out.println("Você fez uma quina!");
        } else if (numAcertos == 6) {
            System.out.println("Você fez uma sena!");
        }

        scanner.close();
    }
}