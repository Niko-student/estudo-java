package exercicios.Cap4.batalhaNaval;

import java.util.Random;
import java.util.Scanner;

public class BatalhaNaval {

    static final int TAMANHO = 5;
    static final int TOTAL_NAVIOS = 3;

    static char[][] tabuleiro = new char[TAMANHO][TAMANHO];
    static boolean[][] navios = new boolean[TAMANHO][TAMANHO];

    static int tentativas = 0;
    static int acertos = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        inicializarTabuleiro();
        posicionarNavios();

        System.out.println("=== BATALHA NAVAL ===");
        System.out.println("Encontre os " + TOTAL_NAVIOS + " navios no tabuleiro 5x5!");
        System.out.println("Use coordenadas: linha (0-4) e coluna (0-4)\n");

        while (acertos < TOTAL_NAVIOS) {
            exibirTabuleiro();

            System.out.print("Digite a linha (0-4): ");
            int linha = lerInteiro(scanner, 0, 4);

            System.out.print("Digite a coluna (0-4): ");
            int coluna = lerInteiro(scanner, 0, 4);

            processarJogada(linha, coluna);
        }

        exibirTabuleiro();
        System.out.println("\n🎉 Parabéns! Você afundou todos os navios em " + tentativas + " tentativas!");
        scanner.close();
    }

    static void inicializarTabuleiro() {
        for (int i = 0; i < TAMANHO; i++)
            for (int j = 0; j < TAMANHO; j++)
                tabuleiro[i][j] = '~';
    }

    static void posicionarNavios() {
        Random rand = new Random();
        int posicionados = 0;

        while (posicionados < TOTAL_NAVIOS) {
            int linha = rand.nextInt(TAMANHO);
            int coluna = rand.nextInt(TAMANHO);

            if (!navios[linha][coluna]) {
                navios[linha][coluna] = true;
                posicionados++;
            }
        }
    }

    static void exibirTabuleiro() {
        System.out.println("\n  0 1 2 3 4");
        for (int i = 0; i < TAMANHO; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < TAMANHO; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void processarJogada(int linha, int coluna) {
        if (tabuleiro[linha][coluna] == 'X' || tabuleiro[linha][coluna] == 'O') {
            System.out.println("⚠️  Você já jogou nessa posição! Tente outra.\n");
            return;
        }

        tentativas++;

        if (navios[linha][coluna]) {
            tabuleiro[linha][coluna] = 'X';
            acertos++;
            System.out.println("💥 ACERTOU! Navio afundado! (" + acertos + "/" + TOTAL_NAVIOS + ")\n");
        } else {
            tabuleiro[linha][coluna] = 'O';
            System.out.println("💧 Água! Nenhum navio nessa posição.\n");
        }
    }

    static int lerInteiro(Scanner scanner, int min, int max) {
        while (true) {
            try {
                int valor = Integer.parseInt(scanner.nextLine().trim());
                if (valor >= min && valor <= max) return valor;
                System.out.print("Digite um número entre " + min + " e " + max + ": ");
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Digite um número: ");
            }
        }
    }
}
