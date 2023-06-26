public class ThueMorse {
    /*
     * Description: The program ThueMorse.java takes an integer command-line argument
     * n and print an n-by-n patter like the ones below. Include two integer two space 
     * between each + and - character
     */
    public static void main(String[] args) {
        int iN = Integer.parseInt(args[0]);
        int[] iThueMorseSeq = new int[iN];
        int iPrevSeqMultiplier;
        int iSeqMultiplier = 1;

        while (iSeqMultiplier < iN) {
            iPrevSeqMultiplier = iSeqMultiplier;
            iSeqMultiplier *= 2;

            for (int i = iPrevSeqMultiplier; i < iSeqMultiplier && i < iThueMorseSeq.length; i++ ) {
                iThueMorseSeq[i] = (iThueMorseSeq[i - iPrevSeqMultiplier] + 1) % 2;
            }
        }
        
        for (int i = 0; i < iN; i++) {
            for (int j = 0; j < iN; j++) {
                 if (iThueMorseSeq[i] == iThueMorseSeq[j]) {
                    System.out.print("+  ");
                 } else {
                    System.out.print("-  ");
                 }
            }

            System.out.println();
        }
    }
}
