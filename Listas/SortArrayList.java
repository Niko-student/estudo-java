package Listas;

import java.util.*;

public class SortArrayList {
    public static void main (String args[]) {
        //Criando uma lista de números
        List<Integer> numeros = new ArrayList<Integer>();
        numeros.add(4);
        numeros.add(57);
        numeros.add(92);
        numeros.add(26);
        //Ordenando
        Collections.sort(numeros);
        for (Integer numero : numeros)
            System.out.println(numero);
    }
}
