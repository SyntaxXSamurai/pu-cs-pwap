/*
 * Description: The program Inversions.java takes an integer command-line arguments n and a long k 
 * and prints a perumtation of length n with exactly k inversions. 
 */
public class Inversions_NotOptomised {
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
        int[] iSeqList = new int[n];
        long lInversion = 0;

        for (int i = 0; i < iSeqList.length; i++) {
            iSeqList[i] = i; 
        }

        int iTmpNum = 0;
        for (int i = 0; i < iSeqList.length && lInversion < k; i++) {
            for (int j = iSeqList.length - 1; j > i && lInversion < k; j--) {
                iTmpNum = iSeqList[j];
                iSeqList[j] = iSeqList[j - 1];
                iSeqList[j - 1] = iTmpNum;

                lInversion = count(iSeqList);
            }
        }
        
        
        return iSeqList;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int iN = Integer.parseInt(args[0]);
        long lK = Long.parseLong(args[1]);

        int[] iInvertSeq = generate(iN, lK);
        for (int i = 0; i < iN; i++) {
            StdOut.print(iInvertSeq[i] + " ");
        }
    }
}