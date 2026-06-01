package exercicios.Cap01;

public class Exercise1b {
    public static void main (String [] args) {
        int x = 1;
        while ( x < 10 ) {
        // a mudança foi apenas adicionar um valor a ser somado para X
            if (x > 3) {
                System.out.println("big x");
            }

            x = x + 1;
        }
        
        System.out.println("--------------");
        
        int y = 5;
        while ( y > 1 ) {
            y = y - 1;
            if ( y < 3 ) {
                System.out.println("small y");
            }
        }
        
        System.out.println("--------------");

        int z = 5;
        while (z > 1) {
            z = z - 1;
            
            if (z < 3) {
                System.out.println ("Small Z");
            }
        }

    }
}
