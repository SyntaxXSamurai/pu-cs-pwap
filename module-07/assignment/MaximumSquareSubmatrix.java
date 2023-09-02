/*
 * Description: Given an n-by-n matrix of 0s and 1s, find a contiguous 
 * square submatrix of maximum size that contains only 1s. 
 */
public class MaximumSquareSubmatrix {
    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int[][] iTempArr = new int[a.length][a[0].length];
        int iMaxSize = 0;

        for (int i = 0; i < a.length; i++) {
            iTempArr[0][i] = a[0][i];
            iTempArr[i][0] = a[i][0];
        }

        int iMinNum = 0;
        int iMinNumTemp = 0;
        for (int iRow = 1; iRow < iTempArr.length; iRow++) {
            for (int iCol = 1; iCol < iTempArr[0].length; iCol++) {
                iMinNumTemp = Math.min(iTempArr[iRow - 1][iCol], iTempArr[iRow - 1][iCol - 1]);
                iMinNum = Math.min(iTempArr[iRow][iCol - 1], iMinNumTemp);

                if (a[iRow][iCol] == 0) {
                    iTempArr[iRow][iCol] = 0;
                    // StdOut.print(iTempArr[iRow][iCol] + " ");
                } else {
                    iTempArr[iRow][iCol] = iMinNum + 1;
                    // StdOut.print(iTempArr[iRow][iCol] + " ");
                }
            }
        }

        for (int i = 0; i < iTempArr.length; i++) {
            for (int j = 0; j < iTempArr[0].length; j++) {
                if (iTempArr[i][j] > iMaxSize) {
                    iMaxSize = iTempArr[i][j];
                }
            }
        } 
        
        return iMaxSize;
    }
    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int iN = StdIn.readInt();
        int[][] iSubMatrix = new int[iN][iN];

        for (int i = 0; i < iSubMatrix.length; i++) {
            for (int j = 0; j < iSubMatrix[0].length; j++) {
                iSubMatrix[i][j] = StdIn.readInt();
            }
        }

        StdOut.println(size(iSubMatrix));
    }
}