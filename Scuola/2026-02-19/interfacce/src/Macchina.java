public class Macchina implements Comparable<Macchina>{
    private String t;
    private String ma;
    private String mo;

    public Macchina(String t, String ma, String mo) {
        this.t = t;
        this.ma = ma;
        this.mo = mo;
    }

    public String getT() {
        return t;
    }

    public String getMa() {
        return ma;
    }

    public String getMo() {
        return mo;
    }

    @Override
    public String toString() {
        return "Macchina{" +
                "t='" + t + '\'' +
                ", ma='" + ma + '\'' +
                ", mo='" + mo + '\'' +
                '}';
    }

    @Override
    public int compareTo(Macchina o) {
        //metodo implementato da interfaccia
        if (t.compareTo(o.getT()) > 0 ) return -1;
        else if (t.equals(o.getT())) return 0;
        else return 1;

        /* ancora piu semplice
        return t.compareTo(o.getT()); per meno uno per l'ordine inverso
         */
    }
}
