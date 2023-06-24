public class ArrayBugsTest {
    public static void main(String[] args) {
        /* 
        double[] a = new double[10];
        for (int i = 1; i <= 10; i++)
            a[i] = Math.random(); 
        */

        /*
        double[] a;
        for (int i = 0; i < 9; i++)
            a[i] = Math.random();
        */

        /*
        a = new double[10];
        for (int i = 0; i < 10; i++)
            a[i] = Math.random();
        */
    }
}