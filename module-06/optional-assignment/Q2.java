public class Q2 {
    public static int Q2Calculation(int iN) {
        if (iN <= 0) {
            return 1;
        }

        // System.out.print(iN + " ");
        return 1 + Q2Calculation(iN - 2) + Q2Calculation(iN - 3);
    }
    public static void main(String args[]) {
        int iN = Integer.parseInt(args[0]);

        System.out.println(Q2Calculation(iN));
    }
}