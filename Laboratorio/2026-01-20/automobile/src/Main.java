private List<Automobile> automobili= new ArrayList<>();

void main() {
    Finestra screen = new Finestra();
}

void createAuto(List<Automobile> lista,String marca, String modello, int anno, float prezzo){
    lista.add(new Automobile(marca,modello,anno,prezzo));

}

void printAuto(List<Automobile> lista){
    System.out.println("Tutte le automobili in archivio");
    for (int i = 0; i < lista.size(); i++) {
        System.out.println(lista.get(i));
    }
}

void updatePrezzo(List<Automobile> lista, int index, float newprz){
    if (index>0 && index<lista.size()){
        Automobile automobile = lista.get(index);
        automobile.setPrezzo(newprz);
    }
}

void eliminaAuto(List<Automobile> lista, int index){
    if (index>0 && index<lista.size()) lista.remove(index);
}

List<Automobile> filtraxData(List<Automobile> lista, int anno){
    List<Automobile> autoFiltrate = new ArrayList<>();
    for (Automobile automobile : lista) {
        if (automobile.getAnno() == anno) autoFiltrate.add(automobile);
    }
    return autoFiltrate;
}