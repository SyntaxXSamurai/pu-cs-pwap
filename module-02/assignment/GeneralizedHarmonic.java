public class GeneralizedHarmonic {
    /*
     * Description: The program GenralizedHarmonic.java takes two integer command-line arguments n and r and uses a for loop to compute the nth 
     * genralized harmonic number of order r
     */
    public static void main(String[] args) {
        int iN = Integer.parseInt(args[0]);
        int iR = Integer.parseInt(args[1]);
        double dH = 0.0;

        for (int i = 1; i <= iN; i++) {
            dH += (1 / Math.pow(i, iR));
        }
        System.out.println(dH);
    }    
}
