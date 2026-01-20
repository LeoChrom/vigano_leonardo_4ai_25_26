import javax.swing.*; //posso anche importare un singolo elemento
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//alleggerisco creo un unico listner
//devo usare else if perche senno si crea un delay nel bottone

public class Finestra implements ActionListener {

    private final int LARGHEZZA_FINESTRA= 800;
    private final int ALTEZZA_FINESTRA= 600;

    private JFrame frame;
    private JPanel panel;
    private JTextField marcaTXF;
    private JTextField modelloTXF;
    private JButton addBTN;
    private JButton clearBTN;

    public Finestra(){
        //creo frame
        frame = new JFrame("Gestione Automobili");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        //componenti
        marcaTXF = new JTextField();
        marcaTXF.setMaximumSize(new Dimension(LARGHEZZA_FINESTRA - 20,20));
        modelloTXF = new JTextField();
        modelloTXF.setMaximumSize(new Dimension(LARGHEZZA_FINESTRA - 20,20));

        //creo un bottone
        addBTN = new JButton("Aggiungi automobile");
        addBTN.addActionListener(this);

        clearBTN = new JButton("Pulisci form");
        clearBTN.addActionListener(this);

        //aggiungi componenti al pannello
        panel.add(marcaTXF);
        panel.add(modelloTXF);
        panel.add(addBTN);
        panel.add(clearBTN);

        frame.add(panel);

        //opzioni frame
        frame.setSize(LARGHEZZA_FINESTRA,ALTEZZA_FINESTRA);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    //implementazione dell'action listner
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBTN){
            //recupero dati
            String username = marcaTXF.getText();
            String password = modelloTXF.getText();
            //controllo dati
            //login
            if (username.equals("admin") && password.equals("admin")){
                JOptionPane.showMessageDialog(null, "login effettuato con successo");
            }
            else JOptionPane.showMessageDialog(null, "Errore nel login");
        }
        else if (e.getSource() == clearBTN){
            marcaTXF.setText("");
            modelloTXF.setText("");
        }

    }
}
