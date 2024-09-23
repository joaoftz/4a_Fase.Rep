import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CrudTela extends JFrame{
    private JTextField txtNome;
    private JTextField txtAltura;
    private JTextField txtPeso;
    private JButton cadastrarButton;
    private JButton localizarButton;
    private JButton editarButton;
    private JButton apagarButton;
    private JButton mostrarTodosButton;
    public JButton fakesButton;
    public JPanel telaPrincipal;
    private JTextArea txtTodos;

    ArrayList<dinosCrud> dinossauro = new ArrayList<dinosCrud>();

    private void mostraTodos(){
        String  s = "";
        txtTodos.setText("");
        for(dinosCrud d: dinossauro){
            s = s.concat(String.format("Nome: %s \nAltura: %f \nPeso: %f \n-----------------",d.getNome(),d.getAltura(),d.getPeso()));
            txtTodos.setText(s);
        }
    }

    public CrudTela() {

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              String nome = txtNome.getText();
              float altura = Float.parseFloat(txtAltura.getText());
              float peso = Float.parseFloat(txtPeso.getText());

             dinosCrud d = new dinosCrud(nome,altura,peso);
             dinossauro.add(d);
             mostraTodos();

            }
        });
        localizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        apagarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//            dinosCrud.remove();
            }
        });
        mostrarTodosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                

            }
        });
        fakesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dinossauro.add((new dinosCrud("Rex",500f,10f)));
                dinossauro.add((new dinosCrud("Tirano",550f,11f)));
                dinossauro.add((new dinosCrud("Mega",600f,15f)));


            }
        });
    }
}
