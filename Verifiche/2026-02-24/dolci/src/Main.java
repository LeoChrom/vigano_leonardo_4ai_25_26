//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    /*
    Ordinario ordinario = new Ordinario("AZ123", "ciao",false,"albicocca",15.0f);
    Atipico atipico = new Atipico("AZ123", "ciao",true,"altro",4.50f);
    System.out.println(ordinario.scontoMax());
    System.out.println(atipico.scontoMax());
     */

    Ordinario crostata = new Ordinario("ML033", "crostata",true,"Albicocca",20.45f);
    System.out.println(crostata);
    System.out.println(crostata.scontoMax());

    Ordinario tiramisu = new Ordinario("PD323", "tiramisu",true,"caffè",32.62f);
    System.out.println(tiramisu);
    System.out.println(tiramisu.scontoMax());

    Atipico cioccolata = new Atipico("CN564","Cioccolata",true,"brasile",4.50f);
    System.out.println(cioccolata);
    System.out.println(cioccolata.scontoMax());


}
