package exercicios.Biblioteca;

public class Livro {
    String nome;
    int quantidade;

    // Construtor: chamado quando você faz "new Livro(...)"
    Livro(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }
}