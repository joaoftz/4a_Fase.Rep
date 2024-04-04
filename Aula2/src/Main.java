import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.print("Nome: ");
        String nome = teclado.nextLine();
        System.out.println("Digite a primeira nota: ");
        float nota1 = teclado.nextFloat();
        System.out.println("Digite a segunda nota: ");
        float nota2 = teclado.nextFloat();
        System.out.println("Digite a terceira nota: ");
        float nota3 = teclado.nextFloat();

        float media = (nota1+nota2+nota3)/3;

        System.out.printf("A media do aluno %s foi %.1f\n", nome, media);

        if(media > 7){
           System.out.println("Passou");
        }else{
            System.out.println("Não passou");
        }

        JOptionPane.showMessageDialog(  null,  "Olá mundo!");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Digit/e sua idade: "));
        System.out.println(idade);

        System.out.println(JOptionPane.showConfirmDialog(  null,  "Tem Certeza ?"));

    }
}