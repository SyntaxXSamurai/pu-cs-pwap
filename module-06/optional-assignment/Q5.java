public class Q5 {
    public static int Q5Calculation(int iN) {
        int[] b = new int[iN + 1]; 
        b[0] = 1;

        for (int i = 2; i <= iN; i++) {
            b[i] = 0;
            for (int j = 0; j < i; j++) {
                b[i] += b[j];
            }
        }

        return b[iN];
    }
    public static void main(String args[]) {
        int iN = Integer.parseInt(args[0]);

        System.out.println(Q5Calculation(iN));
    }
}