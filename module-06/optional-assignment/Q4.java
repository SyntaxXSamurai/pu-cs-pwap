public class Q4 {
    public static void Q4Calculation(int iN) {
        if (iN <= 0) {
            return;
        }

        System.out.print(iN + " ");
        Q4Calculation(iN - 2);
        Q4Calculation(iN - 3);
        System.out.print(iN + " ");
    }
    public static void main(String args[]) {
        int iN = Integer.parseInt(args[0]);

        Q4Calculation(iN);
    }
}