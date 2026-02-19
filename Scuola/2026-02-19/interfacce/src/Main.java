//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Macchina m1 = new Macchina("ZZZ","Mercedes","W148");
    Macchina m2 = new Macchina("aaa","Mercedes","G-Class");
    Macchina m3 = new Macchina("BBB","Renault","Capture");

    List<Macchina> list = new ArrayList<>();
    list.add(m1);
    list.add(m2);
    list.add(m3);

    Collections.sort(list);

    for (Macchina m: list) System.out.println(m);
}
