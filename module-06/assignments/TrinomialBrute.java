/*
 * Description: The program TrinomialBrute.java takes two integer command-line arguments n and k 
 * and computes the corresponding trinomial coefficient. The trinomial coefficient T(n,k) is the coefficient 
 * of x^n+k in the expansion of (1+x+x^2)^n.
 */
public class TrinomialBrute {
    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int iN, int iK) {
        if (iN == 0 && iK == 0) {
            return 1;
        } else if (iK < -iN || iK > iN) {
            return 0; 
        }

        return trinomial(iN -1, iK - 1) + trinomial(iN - 1, iK) + trinomial(iN - 1, iK + 1);
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int iN = Integer.parseInt(args[0]);
        int iK = Integer.parseInt(args[1]);

        StdOut.println(trinomial(iN, iK));
    }
}