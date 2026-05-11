import java.util.Scanner;

public class TesteFila {
   public static void main(String[] args) {
        Fila<Character> fila = new Fila<Character>();
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite seu primeiro e segundo nome:");
        String nome = teclado.nextLine().toLowerCase();
        
        for (int i = 0; i < nome.length(); i++) {
            if (nome.charAt(i) != ' ') {
                fila.enfileirar(nome.charAt(i));
            }
        }

        System.out.println("Digite um caractere para contar as ocorrências:");
        char c = teclado.nextLine().toLowerCase().charAt(0);

        System.out.println("Ocorrências de '" + c + "': " + fila.contaCaracteres(c));

        System.out.println("Testando desenfileirar:");
        while (!fila.vazia()) {
            System.out.println("Desenfileirou: " + fila.desenfileirar());
        }

        teclado.close();
   } 
}
