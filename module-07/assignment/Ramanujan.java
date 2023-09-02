/*
 * Description: The program Ramanujan.java takes a long integer 
 * command-line argument n and prints true if it is a Ramanujan number,
 * and false otherwise.
 */
public class Ramanujan {
    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        if (n < 0) {
            return false; 
        }

        boolean isRamanujanNum = false;
        int iNumCubicSums = 0;
        long lTmpNum = 0;
        long lA = 1, lC = 1;
        double dB = 0.0, dD = 0.0;
        long lLengthLimit = (long) (Math.cbrt(n));
        while (iNumCubicSums < 2 && lTmpNum < lLengthLimit) {
            lTmpNum++; 

            if (iNumCubicSums == 0) {
                lA = lTmpNum * lTmpNum * lTmpNum; 
                dB = Math.cbrt(n - lA);

                if (dB % 1 == 0) {
                    iNumCubicSums++; 
                }
            } else if (iNumCubicSums == 1) {
                lC = lTmpNum * lTmpNum * lTmpNum; 
                dD = Math.cbrt(n - lC);
                
                if (dD % 1 == 0) {
                    if (lC != n - lA) {
                        iNumCubicSums++;
                    }
                }
            }
        }

        if (iNumCubicSums == 2) {
            isRamanujanNum = true;
        } else {
            isRamanujanNum = false;
        }

        return isRamanujanNum;
    }
    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long lN = Long.parseLong(args[0]);

        StdOut.println(isRamanujan(lN));
    }
}