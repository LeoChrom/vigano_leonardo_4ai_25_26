//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //System.out.println(fattoriale(7));
    fibonacci(7);
}

public int fattoriale(int n){
    if (n==1) return 1;
    //System.out.println(n);
    return n * fattoriale(n-1);
}

public int fibonacci(int n) {
    if (n <= 1) {
        return n;
    }
    System.out.println(n);
    return fibonacci(n - 1) + fibonacci(n - 2);
}