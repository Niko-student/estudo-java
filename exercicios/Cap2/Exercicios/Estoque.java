package exercicios.Cap2.Exercicios;

import java.util.Scanner;

public class Estoque {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        
        // ARRAYS QUE ARMAZENAM OS PRODUTOS E SEUAS RESPECTIVAS QUANTIDADES
        String produtos[] = new String[4];
        int quantidades[] = new int[4];

        // VARIÁVEL USADA PARA CALCULAR O TOTAL DE ITENS EM ESTOQUE
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

        // EXIBE A QUANTIDADE TOTAL DE ITENS CADASTRADOS
        int total = soma;

        System.out.println("===Total do Estoque===");
        System.out.println("A quantidade total é: " + total);

        System.out.println();

        // VARIAVEIS USADAS PARA DESCOBRIR O PRODUTO COM MAIOR QUANTIDADE
        int maiorQuant = quantidades[0];
        int menorQuant = quantidades[0];

        String maiorProd = produtos[0];
        String menorProd = produtos[0];
        
        // BUSCAR MAIOR QUANTIDADE
        for (int i = 0; i < quantidades.length; i++) {
            if (quantidades[i] > maiorQuant) {
                maiorQuant = quantidades[i];
                maiorProd = produtos[i];
            }

            
        }
        
        System.out.println("\n===Maior Quantidade===");
        System.out.println("Maior quantidade é do " + maiorProd + ": " + maiorQuant);
        
        // VERIFICA ESTOQUE BAIXO
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

        // PROCESSO DE COMPRA
        System.out.println("\n===Escolha Seu Item===");

        String compra = null;
        
        System.out.print("Qual produto você deseja: ");
        compra = teclado.nextLine();
        
        int quantCompra = 0;

        System.out.print("Quantas unidades você deseja: ");
        quantCompra = teclado.nextInt();
        teclado.nextLine();

        // GUARDA O ÍNDICE DO PRODUTO ENCONTRADO
        int indiceProduto = -1;
        
        // CONTROLA SE O PRODUTO FOI ENCONTRADO
        boolean encontrado = false;
        
        // CONTROLA SE A VENDA FOI CONCLUIDA
        boolean vendaRealizada = false;
        
        //PROCURA O PRODUTO E REALIZA A VENDA
        for (int i = 0; i < produtos.length; i++) {
            
            
            if (compra.equals(produtos[i])) {
                
                encontrado = true;
                indiceProduto = i;

                // VERIFICA SE HÁ ESTOQUE SUFICIENTE
                if (quantCompra <= quantidades[i]) {

                    quantidades[i] = quantidades[i] - quantCompra;
                    vendaRealizada = true;

                }else {
                    System.out.println("Quantidade inexistente");
                }
                
                
            }
            
        }
        
        // PRODUTO NÃO ENCONTRADO
        if (!encontrado) {
            System.out.println("Item não catalogado ou fora de estoque");
        }

        // VENDA CONCLUIDA COM SUCESSO
        if (vendaRealizada) {
            System.out.println("Venda Realizada com Sucesso!");
            System.out.print("A quantidade restante de " + compra + " é: " + quantidades[indiceProduto]);                    
        }

        teclado.close();
    }
}
