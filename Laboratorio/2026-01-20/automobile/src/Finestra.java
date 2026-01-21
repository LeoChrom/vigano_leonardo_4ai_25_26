import javax.swing.*; //posso anche importare un singolo elemento
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Arrays;

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
    private JButton delBTN;
    private JButton mostraBTN;
    private  JButton addConfermaBTN;
    private JButton chiudiTabBTN;
    private JTable tabellaAuto;
    private  JScrollPane containerTabella;

    Finestra(Gestore gestore){
        //attributo necessario
        gest=gestore;

        //creazione frame
        frame = new JFrame("Gestione Automobili");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelContainer = new JPanel();
        panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.Y_AXIS));

        //INIZIALIZZAZIONE TEXTFIELD
        marcaTXF = new JTextField();
        marcaTXF.setMaximumSize(new Dimension(LARGHEZZA_FINESTRA - 20,20));
        marcaTXF.setText("Marca");
        marcaTXF.addFocusListener(
                new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        marcaTXF.setText("");
                    }
                }
        );

        modelloTXF = new JTextField();
        modelloTXF.setMaximumSize(new Dimension(LARGHEZZA_FINESTRA - 20,20));
        modelloTXF.setText("Modello");
        modelloTXF.addFocusListener(
                new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        modelloTXF.setText("");
                    }
                }
        );

        prezzoTXF = new JTextField();
        prezzoTXF.setMaximumSize(new Dimension(LARGHEZZA_FINESTRA - 20,20));
        prezzoTXF.setText("Prezzo");
        prezzoTXF.addFocusListener(
                new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        prezzoTXF.setText("");
                    }
                }
        );

        annoTXF = new JTextField();
        annoTXF.setMaximumSize(new Dimension(LARGHEZZA_FINESTRA - 20,20));
        annoTXF.setText("Anno");
        annoTXF.addFocusListener(
                new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        annoTXF.setText("");
                    }
                }
        );

        //inizializzazione bottoni
        addBTN = new JButton("Aggiungi automobile");
        addBTN.addActionListener(this);
        delBTN = new JButton("Elimina auto");
        delBTN.addActionListener(this);
        addConfermaBTN = new JButton("Conferma");
        addConfermaBTN.addActionListener(this);
        mostraBTN = new JButton("Visualizza tutte le auto");
        mostraBTN.addActionListener(this);
        chiudiTabBTN = new JButton("Chiudi tabella");
        chiudiTabBTN.addActionListener(this);

        //tabella auto



        String[] colonneTabella = {"Targa", "Marca", "Modello", "Prezzo"};
        String[][] dati = {};
        DefaultTableModel modelloTabella = new DefaultTableModel(dati, colonneTabella);
        tabellaAuto = new JTable(modelloTabella);
        tabellaAuto.setEnabled(false);
        containerTabella = new JScrollPane(tabellaAuto);


        //aggiunta componenti al pannello
        panelContainer.add(addBTN);
        panelContainer.add(delBTN);
        panelContainer.add(mostraBTN);
        panelContainer.add(marcaTXF);
        panelContainer.add(modelloTXF);
        panelContainer.add(annoTXF);
        panelContainer.add(prezzoTXF);
        panelContainer.add(addConfermaBTN);
        panelContainer.add(containerTabella);
        panelContainer.add(chiudiTabBTN);
        frame.add(panelContainer);

        //controls per aggiunta auto
        marcaTXF.setVisible(false);
        modelloTXF.setVisible(false);
        annoTXF.setVisible(false);
        prezzoTXF.setVisible(false);
        addConfermaBTN.setVisible(false);

        //tabella
        containerTabella.setVisible(false);
        chiudiTabBTN.setVisible(false);


        //opzioni frame
        frame.setSize(LARGHEZZA_FINESTRA,ALTEZZA_FINESTRA);
        frame.setVisible(true);
        frame.setResizable(true);
    }

    //ACTION LISTNER
    @Override
    public void actionPerformed(ActionEvent e) {
        //AGGIUNGI: inserimento dati
        if (e.getSource() == addBTN){
            addBTN.setEnabled(false);
            delBTN.setEnabled(false);
            mostraBTN.setEnabled(false);

            marcaTXF.setVisible(true);
            modelloTXF.setVisible(true);
            annoTXF.setVisible(true);
            prezzoTXF.setVisible(true);
            addConfermaBTN.setVisible(true);
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
                JOptionPane.showMessageDialog(null, "Automobile aggiunta con successo ^_^");
                marcaTXF.setVisible(false);
                modelloTXF.setVisible(false);
                annoTXF.setVisible(false);
                prezzoTXF.setVisible(false);
                addConfermaBTN.setVisible(false);

                addBTN.setEnabled(true);
                mostraBTN.setEnabled(true);
                delBTN.setEnabled(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Errore: "+ex.getMessage());
            }

        } else if (e.getSource() == delBTN) {
            marcaTXF.setText("");
            modelloTXF.setText("");
        } else if (e.getSource() == mostraBTN) {
            DefaultTableModel model = (DefaultTableModel) tabellaAuto.getModel();

            Object[][] datiTabella = new Object[gest.getAuto().size()][4];

            for (int i = 0; i < gest.getAuto().size(); i++) {
                Automobile a = gest.getAuto().get(i);
                datiTabella[i][0] = a.getMarca();
                datiTabella[i][1] = a.getModello();
                datiTabella[i][2] = a.getAnno();
                datiTabella[i][3] = a.getPrezzo();
            }

            for (Object[] riga : datiTabella) model.addRow(riga);

            containerTabella.setVisible(true);
            chiudiTabBTN.setVisible(true);

            addBTN.setEnabled(false);
            delBTN.setEnabled(false);
            mostraBTN.setEnabled(false);

        } else if (e.getSource()== chiudiTabBTN) {
            containerTabella.setVisible(false);
            chiudiTabBTN.setVisible(false);

            addBTN.setEnabled(true);
            delBTN.setEnabled(true);
            mostraBTN.setEnabled(true);
        }

    }
}
