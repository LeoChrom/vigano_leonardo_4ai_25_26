import java.util.Stack;

public class Rastrelliera {
    private Stack<Disco> torre1 = null;
    private Stack<Disco> torre2 = null;
    private Stack<Disco> torre3 = null;
    private int mosse;
    private int numDischi;

    Rastrelliera(int dischi){
        setNumDischi(dischi);
        mosse=0;

        torre1= new Stack<>();
        for (int i = 1; i <=numDischi ; i++) {
            torre1.push(new Disco(i));
        }
        torre2 = new Stack<>();
        torre3 = new Stack<>();
    }

    private void setNumDischi(int dischi) {
        if(dischi>1 && dischi<=8){
            numDischi=dischi;
        }
        else throw new IllegalArgumentException("! - Num dischi non valido");
    }

    public int getNumDischi() {
        return numDischi;
    }

    public int getMosse() {
        return mosse;
    }

    /**
     * ottieni torre:
     * restituisce la torre di dischi richiesta
     * @return torre richiesta
     */
    public Stack<Disco> otTorre(int ntorre){
        switch (ntorre){
            case 1:
                return torre1;
            case 2:
                return torre2;
            case 3:
                return torre3;
            default:
                throw new IllegalArgumentException("! - Ci sono tre torri");
        }

    }

    public void spostaDisco(int orig, int dest){
        if (orig!=dest && orig>0 && orig<=3 && dest>0 && dest<=3){
            Stack<Disco> torreOrig = null;
            switch (orig){
                case 1:
                    torreOrig=torre1;
                    break;
                case 2:
                    torreOrig=torre2;
                    break;
                case 3:
                    torreOrig=torre3;
                    break;
            }

            Stack<Disco> torreDest = null;
            switch (dest){
                case 1:
                    torreDest=torre1;
                    break;
                case 2:
                    torreDest=torre2;
                    break;
                case 3:
                    torreDest=torre3;
                    break;
            }

            if (torreDest.empty() || torreOrig.peek().getDimensione()<torreDest.peek().getDimensione() ){
                Disco disco = torreOrig.pop();
                torreDest.push(disco);
                mosse++;
            }
            else throw new IllegalArgumentException("! - Mossa non valida");
        }

        else throw new IllegalArgumentException("! - valori origine e dest non validi. Devono essere val diversi e compresi tra 1 e 3");
    }

    public boolean chkVincita(){
        if (!torre2.empty() && torre2.peek().getDimensione()==1 && torre2.size()==numDischi) return true;
        else if (!torre3.empty() && torre3.peek().getDimensione()==1 && torre3.size()==numDischi) return true;
        else return false;
    }


}
