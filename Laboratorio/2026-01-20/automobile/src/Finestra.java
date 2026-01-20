import javax.swing.*; //posso anche importare un singolo elemento
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//alleggerisco creo un unico listner
//devo usare else if perche senno si crea un delay nel bottone

public class Finestra implements ActionListener {
    private Gestore gest;

    private final int LARGHEZZA_FINESTRA= 800;
    private final int ALTEZZA_FINESTRA= 600;

    private JFrame frame;
    private JPanel panelContainer;
    private JTextField marcaTXF;
    private JTextField modelloTXF;
    private JTextField annoTXF;
    private JTextField prezzoTXF;
    private JButton addBTN;
    private JButton clearBTN;
    private  JButton addConfermaBTN;

    Finestra(Gestore gestore){
        //attributo necessario
        gest=gestore;

        //creo frame
        frame = new JFrame("Gestione Automobili");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelContainer = new JPanel();
        panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.Y_AXIS));

        //componenti
        marcaTXF = new JTextField();
        marcaTXF.setMaximumSize(new Dimension(LARGHEZZA_FINESTRA - 20,20));
        modelloTXF = new JTextField();
        modelloTXF.setMaximumSize(new Dimension(LARGHEZZA_FINESTRA - 20,20));
        prezzoTXF = new JTextField();
        prezzoTXF.setMaximumSize(new Dimension(LARGHEZZA_FINESTRA - 20,20));
        annoTXF = new JTextField();
        annoTXF.setMaximumSize(new Dimension(LARGHEZZA_FINESTRA - 20,20));

        //bottoni
        addBTN = new JButton("Aggiungi automobile");
        addBTN.addActionListener(this);
        clearBTN = new JButton("Elimina auto");
        clearBTN.addActionListener(this);
        addConfermaBTN = new JButton("Conferma");
        addConfermaBTN.addActionListener(this);

        //aggiungi componenti al pannello
        panelContainer.add(addBTN);
        panelContainer.add(clearBTN);
        frame.add(panelContainer);

        //opzioni frame
        frame.setSize(LARGHEZZA_FINESTRA,ALTEZZA_FINESTRA);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.pack();
    }

    //implementazione dell'action listner
    @Override
    public void actionPerformed(ActionEvent e) {
        //AGGIUNGI: inserimento dati
        if (e.getSource() == addBTN){
            JPanel panelAggiungi = new JPanel();
            panelAggiungi.setLayout(new BoxLayout(panelAggiungi, BoxLayout.Y_AXIS));

            panelAggiungi.add(marcaTXF);
            panelAggiungi.add(modelloTXF);
            panelAggiungi.add(annoTXF);
            panelAggiungi.add(prezzoTXF);
            panelAggiungi.add(addConfermaBTN);

            frame.add(panelAggiungi);
            frame.setSize(LARGHEZZA_FINESTRA,ALTEZZA_FINESTRA);
            frame.setVisible(true);
            frame.setResizable(false);

        }
        //creazione e agiunta auto
        else if (e.getSource() == addConfermaBTN) {
            //recupero dati
            String marca = marcaTXF.getText();
            String modello = modelloTXF.getText();
            String anno = annoTXF.getText();
            String prezzo = prezzoTXF.getText();
            //controllo dati
            //login
            try {
                gest.createAuto(marca,modello,Integer.parseInt(anno),Float.parseFloat(prezzo));
                JOptionPane.showMessageDialog(null, "Automobile aggiunta con successo");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Errore: "+ex.getMessage());
            }

        } else if (e.getSource() == clearBTN){
            marcaTXF.setText("");
            modelloTXF.setText("");
        }

    }
}
