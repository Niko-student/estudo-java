package Listas;

import java.util.*;

public class ListToArray {
    public static void main(String args []) {
        List<String> days = new ArrayList<String>();
        days.add("Segunda-feira");
        days.add("Terça-feira");
        days.add("Quarta-feira");
        days.add("Quinta-feira");
        days.add("Sexta-feira");
        days.add("Sábado");
        days.add("Domingo");
        //Convertendo ArrayList para Array
        String[] array = days.toArray(new String[days.size()]);
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Lista: " + days);
    }
}
