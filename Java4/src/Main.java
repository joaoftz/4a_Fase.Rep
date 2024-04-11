//import javax.swing.*;
//
//public class Main {
//    public static void main(String[] args) {
//
//        int[] idades = new int[5];
//
//        for(int i=0; i<5; i++){
//            idades[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite a " + (i+1) + "a idade:"));
//        }
//
//        String texto = "";
//        for(int idade : idades){
//           //  texto += "Idade: " + idade + ";\n";  jogar no ALERT !!!//
//           // escolher entre um ou outro //
//          // System.out.println("Idade: " + idade + ";\n");  jogar para o CONSOLE !! //
//
//        }
//        JOptionPane.showMessageDialog(null, texto);
//        System.out.println(texto);
//    }
//}//

//import javax.swing.*;
//import java.util.Arrays;
//
//public class Main {
//    public static void main(String[] args) {
//        int[] idades = {14,12,25,44,11,8};
//        Arrays.sort(idades);
//        for (int n : idades){
//            System.out.print(n + " ");
//        }
//        System.out.println("");
//        int i = Integer.parseInt(JOptionPane.showInputDialog("n:"));
//        int pos = Arrays.binarySearch(idades,i);
//        System.out.println("Valor na encontrado na posição: "+pos);
//    }
//}
