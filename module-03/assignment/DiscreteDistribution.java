public class DiscreteDistribution {
    /*
     * Description: The program DiscreDistribution.java takes an integer 
     * command-line argument m, followed by a sweuqence of positive integer 
     * command-line arguments and prints m random indices 
     * (seprated by whitespace), choosing each index i with probability 
     * proportional to a(i)
     */
    public static void main(String[] args) {
        int iM = Integer.parseInt(args[0]);
        int iR;
        int[] iA = new int[args.length - 1];
        int[] iS = new int[iA.length + 1];

        // System.out.println(args.length);

        for (int i = 0; i < iA.length; i++) {
            iA[i] = Integer.parseInt(args[i + 1]);
            // System.out.print(iA[i] + " ");
        }
        
        // System.out.println();

        iS[0] = 0;
        // System.out.print(iS[0] + " ");
        for (int i = 1; i < iS.length; i++) {
            iS[i] = iS[i - 1] + iA[i - 1];
            // System.out.print(iS[i] + " ");
        }

        // System.out.println();

        for (int i = 0; i < iM; i++) {
            iR = (int) (Math.random() * iS[iS.length - 1]);
            // System.out.print(iR + " ");

            for (int j = 0; j < iS.length; j++) {
                if (iR < iS[j]) {
                    if (j == 0) {
                        System.out.print(j + 1 + " ");
                    } else if (iR >= iS[j - 1]) {
                        System.out.print(j + 1 + " ");
                    }
                    // System.out.print(j + 1 + " ");
                }

            } 
        }
        
        System.out.println();
    }    
}
