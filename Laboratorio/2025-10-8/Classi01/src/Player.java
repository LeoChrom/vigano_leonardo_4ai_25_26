import java.util.ArrayList;
import java.util.List;

public class Player {
    private static List<String> raccoltaID =  new ArrayList<>(); //static crea la stessa lista per ogni oggetto
    //LA STESSA LISTA PER TUTTI; IN COMUNE
    //PROVA AD USARE GENERATE

    private String nome;
    private String nickname;
    private String id;

    public Player(){
        nome = "SuperMario";
    }

    public void setNome(String n){
        n=n.trim();
        if (n.length() < 4){
            throw new IllegalArgumentException("! - Inserisci almento 4 caratteri");
        }
        if(n.matches("[a-zA-Z]+")){

        }
        else throw new IllegalArgumentException("! - Caratteri non ammessi, solo lettere");
        nome = n;
    }

    public String getNome (){
        return nome;
    }

/*
    public void setNickname(String n){
        n=n.trim();
        if (n.length() < 4){
            throw new IllegalArgumentException("! - Inserisci almento 4 caratteri");
        }
        if(n.matches("[a-zA-Z]+")){

        }
        else throw new IllegalArgumentException("! - Caratteri non ammessi, solo lettere");
        nome = n;
    }

 */

    public void setId(String id){
        if (!raccoltaID.contains(id)){
            raccoltaID.add(id);
        }
        else throw new IllegalArgumentException("! - ID già usato");

        this.id=id; //this.id è l'attributo, id il parametrp
    }

    public String getId(){
        return id;
    }


    @Override //notazione che ti dice "to string esiste gia lo sto sovvrascrivendo"
    public String toString() { //personalizzare il formao dell'oggetto quando lo stampo
        return "Player"+"("+id+")";
    }
}


