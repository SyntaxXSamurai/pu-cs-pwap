public class ShannonEntropy {
    /*
     * Description: The program ShannonEntropy.java takes a command-line integer m; reads a sequence of
     * integers betweem 1 and m from standard input; and prints the Shannon Entropy to standard output, 
     * with 4 digits after he decimal point. 
     */
    public static void main(String[] args) {
        int iM = Integer.parseInt(args[0]);
        double dH = 0.0;
        double dP = 0;   
        int[] iXFrequency = new int[iM];

        int iTotalFrequency = 0;
        while (!StdIn.isEmpty()) {
            iXFrequency[StdIn.readInt() - 1]++;
            iTotalFrequency++;
        }

        for (int i = 0; i < iXFrequency.length; i++) {
            if (iXFrequency[i] > 0) {
                dP = (double) iXFrequency[i] / iTotalFrequency;
                dH += (Math.log(dP) / Math.log(2)) * dP;
            }
        }
        
        StdOut.printf("%1$.4f\n", -1 * dH);
    }
}