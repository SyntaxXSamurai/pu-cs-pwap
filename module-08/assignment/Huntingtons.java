/*
 * Description: The program Huntingtons.java analyzes a DNA string for Huntington’s 
 * disease and produce a diagnosis.
 */
public class Huntingtons {
    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int iCurrMaxRepeats = 0;
        int iMaxRepeats = 0;
        String sCurrSubString = dna.substring(0, 3); 
        String sPrevSubString = sCurrSubString;
        int iCounter = 0;

        while (iCounter < dna.length() - 2) {
            sPrevSubString = sCurrSubString;
            sCurrSubString = dna.substring(iCounter, iCounter + 3);

            if (sCurrSubString.equals("CAG")) {
                iCurrMaxRepeats++;

                while (sCurrSubString.equals("CAG") && iCounter < dna.length() - 5) {
                    sPrevSubString = sCurrSubString;
                    iCounter += 3;
                    sCurrSubString = dna.substring(iCounter, iCounter + 3);

                    if (sCurrSubString.equals(sPrevSubString)) {
                        iCurrMaxRepeats++;
                    }
                } 
                
                if (iCurrMaxRepeats > iMaxRepeats) {
                    iMaxRepeats = iCurrMaxRepeats;
                    iCurrMaxRepeats = 0;
                } else {
                    iCurrMaxRepeats = 0;
                }
            } 

            iCounter++;
        }

        return iMaxRepeats;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        return s.replace("\n", "").replace(" ", "").replace("\t", "");
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        String sDiagnose;

        if (maxRepeats <= 9) {
            sDiagnose = "not human";
        } else if (maxRepeats <= 35) {
            sDiagnose = "normal";
        } else if (maxRepeats <= 39) {
            sDiagnose = "high risk";            
        } else if (maxRepeats <= 180) {
            sDiagnose = "Huntington's";
        } else {
            sDiagnose = "not human";
        }

        return sDiagnose;
    }

    // Sample client (see below).
    public static void main(String[] args) {
        String sFile = args[0]; 
        In inputGeneticSequence = new In(sFile);
        String sGeneticSequence = inputGeneticSequence.readAll();
        
        // StdOut.println(sGeneticSequence);
        // StdOut.println(removeWhitespace(sGeneticSequence));
        // StdOut.println(diagnose(89));

        sGeneticSequence = removeWhitespace(sGeneticSequence);
        int iMaxRepeats = maxRepeats(sGeneticSequence);
        // StdOut.println(sGeneticSequence);
        // StdOut.println(maxRepeats(sGeneticSequence));
        StdOut.println("max repeats = " + iMaxRepeats);
        StdOut.println(diagnose(iMaxRepeats));
    }
}