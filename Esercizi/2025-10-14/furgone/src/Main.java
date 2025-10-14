import javax.naming.LimitExceededException;

void main() throws LimitExceededException {
    Furgone f1 = new Furgone(10);
    System.out.println(f1.getUnita());
    f1.caricaScatolaGrande();
    f1.caricaScatolaPiccola();
    System.out.println(f1.getUnita());
    f1.caricaScatolaGrande();
    System.out.println(f1.getUnita());

    f1.caricaScatolaPiccola();
    System.out.println(f1.getUnita());
    f1.caricaScatolaPiccola();
    System.out.println(f1.getUnita());
    f1.caricaScatolaPiccola();
    System.out.println(f1.getUnita());

    System.out.println(f1.getCosto());
    f1.svuotaFurgone();
    System.out.println(f1.getUnita());

}
