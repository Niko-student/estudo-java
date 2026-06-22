package Listas;

import java.util.*;

public class ArrayToList {
    public static void main(String args[]) {
        //Criando uma Array
        String[] colors = {"azul", "verde", "vermelho", "amarelo"};
        System.out.println("Array: " + Arrays.toString(colors));
        //Convertendo Array para Lista
        List<String> list = new ArrayList<String>();
        for (String color : colors) {
            list.add(color);
        }
        System.out.println("Lista: " + list);
    }
}
