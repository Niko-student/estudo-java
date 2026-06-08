package exercicios.Biblioteca;
import java.util.Scanner;

public class biblioteca {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Livro[] biblioteca = new Livro[0]; // array de objetos Livro
        int soma = 0;

        System.out.println("===Biblioteca===");

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Cadastrar livros");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Doar livro");
            System.out.println("4 - Devolver livro");
            System.out.println("5 - Mais exemplares");
            System.out.println("6 - Livros com menos de 5 exemplares");
            System.out.println("7 - Total de exemplares");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {

                case 1:
                    System.out.print("Quantos livros deseja cadastrar? ");
                    int qtdCadastrar = teclado.nextInt();
                    teclado.nextLine();

                    for (int i = 0; i < qtdCadastrar; i++) {
                        // Expande o array de objetos
                        Livro[] novaLista = new Livro[biblioteca.length + 1];
                        for (int j = 0; j < biblioteca.length; j++) {
                            novaLista[j] = biblioteca[j];
                        }

                        System.out.print("Nome do livro: ");
                        String nome = teclado.nextLine();
                        System.out.print("Quantidade: ");
                        int quant = teclado.nextInt();
                        teclado.nextLine();

                        // Cria o objeto e adiciona no array
                        novaLista[biblioteca.length] = new Livro(nome, quant);
                        soma += quant;
                        biblioteca = novaLista;

                        System.out.println("Livro cadastrado!");
                    }
                    break;

                case 2:
                    if (biblioteca.length == 0) {
                        System.out.println("Nenhum livro cadastrado ainda.");
                        break;
                    }
                    System.out.println("\n=> Nossos livros:");
                    for (int i = 0; i < biblioteca.length; i++) {
                        // Acessa os atributos do objeto com o ponto "."
                        System.out.println((i + 1) + " - " + biblioteca[i].nome + " ( " + biblioteca[i].quantidade + " )");
                    }
                    break;

                case 3:
                    if (biblioteca.length == 0) {
                        System.out.println("Nenhum livro cadastrado ainda.");
                        break;
                    }
                    System.out.println("\n=> Nossos livros:");
                    for (int i = 0; i < biblioteca.length; i++) {
                        System.out.println((i + 1) + " - " + biblioteca[i].nome + " ( " + biblioteca[i].quantidade + " )");
                    }

                    System.out.print("Qual livro doar: ");
                    String compra = teclado.nextLine();
                    System.out.print("Quantos deseja doar: ");
                    int quantCompra = teclado.nextInt();
                    teclado.nextLine();

                    boolean encontrado = false;

                    for (int i = 0; i < biblioteca.length; i++) {
                        if (compra.equals(biblioteca[i].nome)) {
                            encontrado = true;
                            if (quantCompra <= biblioteca[i].quantidade) {
                                biblioteca[i].quantidade -= quantCompra;
                                soma -= quantCompra;
                                System.out.println("Livro doado!");
                                System.out.println("Quantidade restante: " + biblioteca[i].quantidade);
                            } else {
                                System.out.println("Quantidade insuficiente!");
                            }
                        }
                    }

                    if (!encontrado) System.out.println("Livro não encontrado.");
                    break;

                case 4:
                    System.out.println("\n=> Nossos livros:");
                    for (int i = 0; i < biblioteca.length; i++) {
                        System.out.println((i + 1) + " - " + biblioteca[i].nome);
                    }

                    System.out.print("Qual livro devolver: ");
                    String devolver = teclado.nextLine();
                    System.out.print("Quantos devolver: ");
                    int quantDevol = teclado.nextInt();
                    teclado.nextLine();

                    boolean devolvido = false;

                    for (int i = 0; i < biblioteca.length; i++) {
                        if (devolver.equals(biblioteca[i].nome)) {
                            devolvido = true;
                            biblioteca[i].quantidade += quantDevol;
                            soma += quantDevol;
                            System.out.println("Livro devolvido!");
                            System.out.println("Quantidade atual: " + biblioteca[i].quantidade);
                        }
                    }

                    if (!devolvido) {
                        // Livro não existe, cria novo objeto e adiciona
                        Livro[] novaLista = new Livro[biblioteca.length + 1];
                        for (int i = 0; i < biblioteca.length; i++) {
                            novaLista[i] = biblioteca[i];
                        }
                        novaLista[biblioteca.length] = new Livro(devolver, quantDevol);
                        soma += quantDevol;
                        biblioteca = novaLista;
                        System.out.println("Livro não encontrado. Adicionado ao acervo!");
                    }
                    break;

                case 5:
                    if (biblioteca.length == 0) { System.out.println("Nenhum livro cadastrado."); break; }
                    Livro maisExemp = biblioteca[0];
                    for (int i = 1; i < biblioteca.length; i++) {
                        if (biblioteca[i].quantidade > maisExemp.quantidade) {
                            maisExemp = biblioteca[i]; // guarda o próprio objeto
                        }
                    }
                    System.out.println("\n===Mais Exemplares===");
                    System.out.println(maisExemp.nome + " ( " + maisExemp.quantidade + " )");
                    break;

                case 6:
                    if (biblioteca.length == 0) { System.out.println("Nenhum livro cadastrado."); break; }
                    System.out.println("\n===Livros com menos de 5 exemplares===");
                    for (int i = 0; i < biblioteca.length; i++) {
                        if (biblioteca[i].quantidade < 5) {
                            System.out.println(biblioteca[i].nome + " ( " + biblioteca[i].quantidade + " )");
                        }
                    }
                    break;

                case 7:
                    System.out.println("\nTotal de exemplares: " + soma);
                    break;

                case 0:
                    System.out.println("Encerrando... Até logo!");
                    teclado.close();
                    return;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
