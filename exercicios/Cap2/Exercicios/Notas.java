package exercicios.Cap2.Exercicios;

import java.util.Scanner;

class SistemaNotas {

    public static void main (String[] args) {

        Scanner teclado = new Scanner(System.in);

        String[] nomes = new String[5];
        double[] notas = new double[5];

        double soma = 0;

        System.out.println("=== Cadastro de Alunos ===");

        // CADASTRO DOS ALUNOS
        for (int i = 0; i < nomes.length; i++) {

            System.out.print("Digite o nome do aluno " + (i + 1) + ": ");
            nomes[i] = teclado.nextLine();

            System.out.print("Digite a nota de " + nomes[i] + ": ");
            notas[i] = teclado.nextDouble();
            teclado.nextLine(); // limpa o ENTER

            soma += notas[i];
            System.out.println();
        }

        // MÉDIA
        double media = soma / notas.length;

        //Encontrar maior nota
        double maiorNota = notas[0];
        String melhorAluno = nomes[0];

        for (int i = 1; i < notas.length; i++) {

            if (notas[i] > maiorNota) {
                maiorNota = notas[i];
                melhorAluno = nomes[i];
            }
        }

        System.out.println("\n=== RELATÓRIO DA TURMA===");

        //EXIBIR ALUNOS E SITUAÇÃO
        for (int i = 0; i < nomes.length; i++) {

            String situacao;

            if (notas[i] >= 7) {
                situacao = "APROVADO";
            } else {
                situacao = "REPROVADO";
            }

            System.out.println(
                nomes[i] +
                " | Nota: " + notas[i] +
                " | Situação: " + situacao
            );
        }

        System.out.println("\nMédia da turma: " + media);

        System.out.println(
            "Maior nota: " +
            maiorNota +
            " (Aluno: " +
            melhorAluno +
            ")"
        );

        teclado.close();
    }
}