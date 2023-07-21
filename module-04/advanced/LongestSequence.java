public class LongestSequence {
    /*
     * Description: The program LongestSequence.java reads in a sequence of integers 
     * and prints both the integer that appears in a longest consecutive 
     * run and the length of that run.
     */
    public static void main(String[] args) {
        int iLongSeq = 1;
        int iCurrLongSeq = 1;
        int iCurrNum = 0;
        int iPrevNum = 0;
        int iCurrSeqNum = 0;

        iCurrNum = StdIn.readInt();
        iLongSeq = iCurrLongSeq;
        iCurrSeqNum = iCurrNum; 

        while (!StdIn.isEmpty()) {
            iPrevNum = iCurrNum; 
            iCurrNum = StdIn.readInt();
            if (iPrevNum == iCurrNum) {
                iCurrLongSeq++;
                if (iCurrLongSeq >= iLongSeq) {
                    iLongSeq = iCurrLongSeq;
                    iCurrSeqNum = iPrevNum; 
                } 
            } else {
                if (iCurrLongSeq >= iLongSeq) {
                    iLongSeq = iCurrLongSeq;
                    iCurrSeqNum = iPrevNum; 
                }
                iCurrLongSeq = 1;
            }
        }
        StdOut.println("Longest Run: " + iLongSeq + " consecutive " + iCurrSeqNum + "s");
    }
}
