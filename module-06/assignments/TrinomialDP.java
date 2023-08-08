/*
 * Description: The program TrinomialDP.java takes two integer command-line arguments 
 * n and k and computes the trinomial coefficient T(n,k) using dynamic programming.
 */
public class TrinomialDP {
    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int iN, int iK) {
        if (iN == 0 && iK == 0) {
            return 1;
        } else if (iK < -iN || iK > iN) {
            return 0; 
        }

        long[][] lTrinomialCoefficient = new long[iN + 1][iN + 1];
        lTrinomialCoefficient[0][0] = 1;
        for (int i = 1; i <= iN; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    lTrinomialCoefficient[i][j] = lTrinomialCoefficient[i - 1][j];
                } else if (i == j) {
                    lTrinomialCoefficient[i][j] = lTrinomialCoefficient[i - 1][j - 1];
                } else {
                    lTrinomialCoefficient[i][j] = 
                        lTrinomialCoefficient[i - 1][j - 1] + 
                        lTrinomialCoefficient[i - 1][j] + 
                        lTrinomialCoefficient[i - 1][j + 1]; 
                }
            }
        }

        return lTrinomialCoefficient[iN][iK];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int iN = Integer.parseInt(args[0]);
        int iK = Integer.parseInt(args[1]);

        StdOut.println(trinomial(iN, iK));   
    }
}