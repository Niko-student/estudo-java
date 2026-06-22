package Listas;

import java.util.*;

public class ListExample {
    public static void main(String args[]) {
        //Criando uma lista
        List<String> letras = new ArrayList<String>();
        //Adicionando elementos
        letras.add("a");
        letras.add("b");
        letras.add("c");
        //get()
        System.out.println("Elemento no índice 1: " + letras.get(1));
        //set()
        letras.set(2, "d");
        for (String letra : letras)
            System.out.println(letra);
    }
}
