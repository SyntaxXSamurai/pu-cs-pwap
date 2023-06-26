public class ThueMorsePrac {
    public static void main(String[] args) {
        int iN = Integer.parseInt(args[0]);
        int[] iThueMorseSeq = new int[iN];
        int iPrevSeqMultiplier;
        int iSeqMultiplier = 1;

        while (iSeqMultiplier < iN) {
            iPrevSeqMultiplier = iSeqMultiplier;
            iSeqMultiplier *= 2;
            for (int i = iPrevSeqMultiplier; i < iSeqMultiplier && i < iThueMorseSeq.length; i++) {
                iThueMorseSeq[i] = (iThueMorseSeq[i - iPrevSeqMultiplier] + 1) % 2;
            }

            /* 
            for (int i = 0; i < iSeqMultiplier && i < iThueMorseSeq.length; i++) {
                System.out.print(iThueMorseSeq[i] + "  ");
            }
            
            System.out.println();
            */
        }

        for (int i = 0; i < iThueMorseSeq.length; i++) {
            System.out.print(iThueMorseSeq[i] + "  ");
        }
        
        System.out.println();
    }
}
