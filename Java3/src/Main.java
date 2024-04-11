
import javax.swing.JOptionPane;

public class Main {


    public static void main(String[] args) {


        int numero, maior = -1;

        for (int i = 1; i <= 5; i++) {
            System.out.println("Digite um número");
            numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero"));

            if(numero>maior){
                maior = numero;
            }

        }

        System.out.println("Maior: " +maior);


    }

}

//public class Main {
//    public static void main(String[] args) {
//
//
//
//
//
//


//        String nome, nomeUsuario;
//        nome = JOptionPane.showInputDialog("Nome");
//        nomeUsuario = JOptionPane.showInputDialog("nomeUsuario");
//
//        if(nome.equals(nomeUsuario)){
//            System.out.println("Iguais");
//        }else{
//            System.out.println("Diferentes");
//        }

//    }
//}