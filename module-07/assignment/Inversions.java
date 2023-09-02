/*
 * Description: The program Inversions.java takes an integer command-line arguments n and a long k 
 * and prints a perumtation of length n with exactly k inversions. 
 */
public class Inversions {
    // Return the number of inversions in the permutation a[]
    public static long count(int[] a) {
        long lInversionCounter = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    lInversionCounter++;
                }
            }
        }

        return lInversionCounter;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        if (n < 0 || k < 0 || k > n * (n - 1) / 2) {
            return new int[0];    
        }

        int[] iSeqList = new int[n];
        int[] iSeqListTmp = new int[n];
        long lInversion = 0;

        for (int i = 0; i < iSeqList.length; i++) {
            iSeqList[i] = i; 
            iSeqListTmp[i] = i;
        }

        int iInversionCheat = 0;
        int iInversionCheck = 0;
        lInversion = k - iInversionCheck;
        while (lInversion >= n - iInversionCheat - 1 && lInversion > 0) {
            iSeqList[iInversionCheat] = iSeqListTmp[n - iInversionCheat - 1];

            iInversionCheck = n - iInversionCheat - 1;
            iInversionCheat++;
            lInversion = lInversion - iInversionCheck;
        }

        int iIndex = 0;
        for (int i = iInversionCheat; i < iSeqList.length; i++) {
            iSeqList[i] = iSeqListTmp[iIndex];
            iIndex++;
        }

        iIndex = 0;
        for (int i = iInversionCheat; i < iSeqList.length; i++) {
            if (i == iSeqList.length - 1 - lInversion) {
                iSeqList[i] = iSeqList[iSeqList.length - 1]; 
            } else {
                iSeqList[i] = iSeqListTmp[iIndex];
                iIndex++;
            }
        }

        // StdOut.println(lInversion);
        /* 
        int iTmpNum = 0;
        for (int i = iInversionCheat - 1; i < iSeqList.length && lInversion < k; i++) {
            for (int j = iSeqList.length - 1; j > i && lInversion < k; j--) {
                iTmpNum = iSeqList[j];
                iSeqList[j] = iSeqList[j - 1];
                iSeqList[j - 1] = iTmpNum;

                lInversion++;
            }
        }
        */

        return iSeqList;
        
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int iN = Integer.parseInt(args[0]);
        long lK = Long.parseLong(args[1]);

        int[] iInvertSeq = generate(iN, lK);
        for (int i = 0; i < iInvertSeq.length; i++) {
            StdOut.print(iInvertSeq[i] + " ");
        }
    }
}