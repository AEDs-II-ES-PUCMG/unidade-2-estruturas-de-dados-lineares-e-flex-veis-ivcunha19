import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Pilha<Integer> p = new Pilha<Integer>();
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite seu número de matrícula:");
        String matricula = teclado.nextLine();
        
        // Inserir dígitos sem repetição
        boolean[] presente = new boolean[10];
        for (int i = 0; i < matricula.length(); i++) {
            char c = matricula.charAt(i);
            if (Character.isDigit(c)) {
                int digito = Character.getNumericValue(c);
                if (!presente[digito]) {
                    p.empilhar(digito);
                    presente[digito] = true;
                }
            }
        }
        
        System.out.println("Conteúdo da pilha (dígitos sem repetição):");
        System.out.print(p.listaDados());

        System.out.println("Testando desempilhar:");
        while (!p.vazia()) {
            System.out.println("Desempilhou: " + p.desempilhar());
        }

        teclado.close();
    }
}
