import javax.swing.*; //posso anche importare un singolo elemento
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

//alleggerisco creo un unico listner
//devo usare else if perche senno si crea un delay nel bottone

public class Finestra implements ActionListener {

    private final int LARGHEZZA_FINESTRA= 400;
    private final int ALTEZZA_FINESTRA= 400;

    private JFrame frame;
    private JPanel panel;
    private JTextField usernameTXF;
    private JTextField passwordTXF;
    private JButton loginBTN;
    private JButton clearBTN;

    public Finestra(){
        //creo frame
        frame = new JFrame("Finestra di login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        //componenti
        usernameTXF = new JTextField();
        usernameTXF.setMaximumSize(new Dimension(LARGHEZZA_FINESTRA - 20,20));
        passwordTXF = new JTextField();
        passwordTXF.setMaximumSize(new Dimension(LARGHEZZA_FINESTRA - 20,20));

        //creo un bottone
        loginBTN = new JButton("Esegui login");
        loginBTN.addActionListener(this);

        clearBTN = new JButton("Pulisci form");
        clearBTN.addActionListener(this);

        //aggiungi componenti al pannello
        panel.add(usernameTXF);
        panel.add(passwordTXF);
        panel.add(loginBTN);
        panel.add(clearBTN);

        frame.add(panel);

        //opzioni frame
        frame.setSize(LARGHEZZA_FINESTRA,ALTEZZA_FINESTRA);
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    //implementazione dell'action listner
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginBTN){
            //recupero dati
            String username = usernameTXF.getText();
            String password = passwordTXF.getText();
            //controllo dati
            //login
            if (username.equals("admin") && password.equals("admin")){
                JOptionPane.showMessageDialog(null, "login effettuato con successo");
            }
            else JOptionPane.showMessageDialog(null, "Errore nel login");
        }
        else if (e.getSource() == clearBTN){
            usernameTXF.setText("");
            passwordTXF.setText("");
        }

    }
}
