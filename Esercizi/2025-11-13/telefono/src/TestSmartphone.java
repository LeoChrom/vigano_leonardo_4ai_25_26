void main() {
    Smartphone smartphone1 = new Smartphone();

    smartphone1.setMarca("Microsoft");
    smartphone1.setModello("Lumia 950");
    smartphone1.setNumPollici(5.5);
    smartphone1.setPrezzo(880);
    smartphone1.setTouch(true);
    smartphone1.setRam(8000);

    Smartphone smartphone2 = new Smartphone("Nokia","Lumia 800",600,4.8,2000,true);

    System.out.println(smartphone1);
    System.out.println(smartphone2);
}
