void main() {

    ClasseSgl bc = ClasseSgl.getIstanza();
    ClasseSgl vb = ClasseSgl.getIstanza();
    ClasseSgl ca = ClasseSgl.getIstanza();

    System.out.println("Prima del set");
    System.out.println(bc.toString());
    System.out.println(vb.toString());

    vb.setNome("Manu");
    System.out.println("Dopo il set");
    System.out.println(bc.toString());
    System.out.println(vb.toString());
}
