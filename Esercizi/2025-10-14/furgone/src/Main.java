import javax.naming.LimitExceededException;

void main() throws LimitExceededException {
    Furgone f1 = new Furgone(10);
    System.out.println(f1.getUnita());
    f1.caricaScatolone(3);
    f1.caricaScatolone(1);
    System.out.println(f1.getUnita());
    f1.caricaScatolone(3);
    System.out.println(f1.getUnita());

    f1.caricaScatolone(1);
    System.out.println(f1.getUnita());
    f1.caricaScatolone(1);
    System.out.println(f1.getUnita());
    f1.caricaScatolone(1);
    System.out.println(f1.getUnita());

    System.out.println(f1.getCosto());
    f1.svuotaFurgone();
    System.out.println(f1.getUnita());

}
