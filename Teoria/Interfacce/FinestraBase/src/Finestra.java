import javax.swing.*; //posso anche importare un singolo elemento
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Finestra {

    private final int LARGHEZZA_FINESTRA= 400;
    private final int ALTEZZA_FINESTRA= 400;

    public Finestra(){
        //creo frame
        JFrame frame = new JFrame("Finestra di login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        //componenti
        JTextField usernameTXF = new JTextField();
        usernameTXF.setMaximumSize(new Dimension(LARGHEZZA_FINESTRA - 20,20));
        JTextField passwordTXF = new JTextField();
        passwordTXF.setMaximumSize(new Dimension(LARGHEZZA_FINESTRA - 20,20));

        //creo un bottone
        JButton loginBTN = new JButton("Esegui login");
        loginBTN.addActionListener(new ActionListener() {
            //posso creare al volo un'istanza dell'action listner
            //Ho una classe anonima attaccata al bottone che non posso recuperare
            // per programmi complessi la classe anonima non va bene appesantisce
            @Override
            public void actionPerformed(ActionEvent e) {
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
        });

        JButton clearBTN = new JButton("Pulisci form");
        clearBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usernameTXF.setText("");
                passwordTXF.setText("");
            }
        });

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


}
