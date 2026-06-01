package exercicios.Cap2;

class Dog {
    int size;
    String bread;
    String name;

    void bark () {
    System.out.println("Ruff ! Ruff !");
    }
}

class DogTestDrive { 
    public static void main (String [] args) {
        //o código de teste de Dog entrara aqui

        Dog d = new Dog(); //cria um novo objeto

        d.size = 40;
        d.bark(); //chama para seu metodo bark
    }
}