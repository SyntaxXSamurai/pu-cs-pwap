public class FilterSeq {
    public static void main(String[] args) {
        int iCurrNum = 0;
        int iPrevNum = 0;
        String sSequence = "";

        iCurrNum = StdIn.readInt();
        sSequence += iCurrNum;

        while (!StdIn.isEmpty()) {
            iPrevNum = iCurrNum;
            iCurrNum = StdIn.readInt(); 

            if (iPrevNum != iCurrNum) {
                sSequence += " " + iCurrNum;
            } 
        }
        StdOut.println(sSequence); 
    }
}
