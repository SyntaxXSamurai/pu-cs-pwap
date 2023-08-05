public class Q3 {
    public static void Q3Calculation(int iN) {
        if (iN <= 0) {
            return;
        }

        System.out.print(iN + " ");
        Q3Calculation(iN - 2);
        Q3Calculation(iN - 3);
        System.out.print(iN + " ");
    }
    public static void main(String args[]) {
        int iN = Integer.parseInt(args[0]);

        Q3Calculation(iN);
    }
}