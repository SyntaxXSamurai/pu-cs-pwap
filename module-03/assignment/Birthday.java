public class Birthday {
    /*
     * Description: The program Birthday.java takes two integer command-line arguments
     * n and trials and performs a few experiments. 
     */
    public static void main(String[] args) {
        int iN = Integer.parseInt(args[0]);
        int iTrials = Integer.parseInt(args[1]);

        /*
        iDupBirthday holds the amount of n random people that entered the room that have a 
        duplicate birthday
        */
        int[] iDupBirthday = new int[iN];
        int[] iEnteredRoom = new int[iN];
        int iTrialsCounter = 0;
        boolean bIsDupBirthday; 

        while (iTrialsCounter < iTrials) {
            bIsDupBirthday = false;

            for (int i = 0; i < iDupBirthday.length && !bIsDupBirthday; i++) {
                iEnteredRoom[i] = (int) (Math.random() * iN);
                for (int j = 0; j < i && !bIsDupBirthday; j++) {
                    if (iEnteredRoom[i] == iEnteredRoom[j]) {
                        iDupBirthday[i]++;
                        bIsDupBirthday = true;
                    }
                }
            }

            iTrialsCounter++;
        }

        int iRunningTotal = 0;
        double dFraction = 0.0;
        for (int i = 0; i < iDupBirthday.length && dFraction < 0.5; i++) {
            iRunningTotal += iDupBirthday[i];
            dFraction = (double) iRunningTotal / iTrials;
            System.out.println(i + 1 + "\t" + iRunningTotal + "\t" + dFraction);
        }
    }
}
