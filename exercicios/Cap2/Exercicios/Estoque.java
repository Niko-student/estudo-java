package exercicios.Cap2.Exercicios;

import java.util.Scanner;

public class Estoque {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        
        String produtos[] = new String[2];
        int quantidades[] = new int[2];

        int soma = 0;

        System.out.println("===Estoque de produtos===");


        // CADASTRO DOS PRODUTOS
        for (int i = 0; i < produtos.length; i++ ) {
            System.out.print("Registre o produto " + (i + 1) + ": ");
            produtos[i] = teclado.nextLine();

            System.out.print("Qual a quantidade desse produto " + (i + 1) + ": ");
            quantidades[i] = teclado.nextInt();
            teclado.nextLine();

            soma += quantidades[i];
            System.out.println();
        }

        int total = soma;

        System.out.println("===Total do Estoque===");
        System.out.println("A quantidade total é: " + total);

        System.out.println();

        
        int maiorQuant = quantidades[0];
        int menorQuant = quantidades[0];
        String maiorProd = produtos[0];
        String menorProd = produtos[0];
        
        for (int i = 0; i < quantidades.length; i++) {
            if (quantidades[i] > maiorQuant) {
                maiorQuant = quantidades[i];
                maiorProd = produtos[i];
            }

            
        }
        
        System.out.println("\n===Maior Quantidade===");
        System.out.println("Maior quantidade é do " + maiorProd + ": " + maiorQuant);
        
        System.out.println("\n==Estoque Baixo===");
        for (int i = 0; i < quantidades.length; i++) {
            
            if (quantidades[i] < 5) {
                menorQuant = quantidades[i];
                menorProd = produtos[i];

                System.out.println(
                    "Precisa reabastecer " 
                    + menorProd + ": " 
                    + menorQuant);
            }

        }

        System.out.println("===Escolha Seu Item===");

        String compra = null;
        
        System.out.print("Qual produto você deseja: ");
        compra = teclado.nextLine();
        
        int quantCompra = 0;

        System.out.print("Quantas unidades você deseja: ");
        quantCompra = teclado.nextInt();
        teclado.nextLine();
        
        boolean encontrado = false;
        
        boolean vendaRealizada = false;
        
        for (int i = 0; i < produtos.length; i++) {
            
            if (!encontrado) {
                System.out.println("Item não catalogado ou fora de estoque");
            }
            
            if (compra.equals(produtos[i])) {
                encontrado = true;
                
                
                if (quantCompra <= quantidades[i]) {
                    quantidades[i] = quantidades[i] - quantCompra;
                    vendaRealizada = true;
                }else {
                    System.out.println("Quantidade inexistente");
                }
                
                if (vendaRealizada) {
                    System.out.println("Venda Realizada com Sucesso!");
                    System.out.print("A quantidade restante de " + compra + " é: " + quantidades[i]);                    
                }

            }
            
            
        }

        teclado.close();
    }
}
