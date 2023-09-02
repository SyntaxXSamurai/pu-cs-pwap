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

        long[][] lTrinomialCoefficient = new long[iN + 1][2 * iN + 1]; 
        int iMiddle = iN; 
        lTrinomialCoefficient[0][iMiddle] = 1;
        for (int i = 1; i < lTrinomialCoefficient.length; i++) {
            lTrinomialCoefficient[i][iMiddle] = 
                    lTrinomialCoefficient[i - 1][iMiddle - 1] + 
                    lTrinomialCoefficient[i - 1][iMiddle] + 
                    lTrinomialCoefficient[i - 1][iMiddle + 1];

            for (int j = 0; j < i; j++) {
                if (j == i - 1) {
                    lTrinomialCoefficient[i][iMiddle - i] = 1;
                    lTrinomialCoefficient[i][iMiddle + i] = 1; 
                } else {
                    lTrinomialCoefficient[i][iMiddle - j - 1] = 
                            lTrinomialCoefficient[i - 1][iMiddle - j - 2] + 
                            lTrinomialCoefficient[i - 1][iMiddle - j - 1] + 
                            lTrinomialCoefficient[i - 1][iMiddle - j];
                    
                    lTrinomialCoefficient[i][iMiddle + j + 1] = 
                            lTrinomialCoefficient[i - 1][iMiddle + j + 2] + 
                            lTrinomialCoefficient[i - 1][iMiddle + j + 1] + 
                            lTrinomialCoefficient[i - 1][iMiddle + j];
                }
            }
        }
        
        return lTrinomialCoefficient[iN][iN + iK];
    }
    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int iN = Integer.parseInt(args[0]);
        int iK = Integer.parseInt(args[1]);

        // trinomial(iN, iK);
        StdOut.println(trinomial(iN, iK));   
    }
}