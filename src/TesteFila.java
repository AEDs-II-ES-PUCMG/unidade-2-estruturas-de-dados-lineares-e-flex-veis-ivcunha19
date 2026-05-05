import java.util.Scanner;

public class TesteFila {
   public static void main(String[] args) {
    Fila<Character> fila = new Fila<Character>();
    char[] letra = {'i', 'v', 'o', 'v', 'i', 'l', 'l', 'a', 'n', 'i'};
    for (int i = 0; i < letra.length; i++) {
        fila.enfileirar(letra[i]);
    }
    System.out.println(fila.contaCaracteres('i'));
   } 
}
