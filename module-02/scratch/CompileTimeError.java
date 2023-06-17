public class CompileTimeError {
    public static void main(String[] args) {
        int a = 4;
        int b = 2;
        int c = 0;

        if (a > b); else b = 0;
            System.out.println(a + " " + b + " " + c);
    }
}