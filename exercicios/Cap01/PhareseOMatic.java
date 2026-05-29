package exercicios.Cap01;

public class PhareseOMatic {
    public static void main (String[] args) {
        String[] wordListOne = {"24/7", "várias camadas", "30.000 pés", "B-to-B", "todos ganham", "front-end", "baseado na web", "difundido", "inteligente", "seis sigma", "caminho crítico", "dinâmico"};

        String[] wordListTwo = {"habilitado", "adesivo", "valor agregado", "orientado", "central", "distribuido", "agrupado"};

        String[] wordListThree = {"processo", "ponto", "solução", "arquitetura"};

        int oneLength = wordListOne.length;
        int twoLength = wordListTwo.length;
        int threeLength = wordListThree.length;

        int rand1 = (int) (Math.random() * oneLength);
        int rand2 = (int) (Math.random() * twoLength);
        int rand3 = (int) (Math.random() * threeLength);

        String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3];

        System.out.println("Precisamos de " + phrase);

    }
}
