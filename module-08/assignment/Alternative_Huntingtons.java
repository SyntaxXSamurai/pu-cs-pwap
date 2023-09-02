/*
 * Description: The program Huntingtons.java analyzes a DNA string for Huntington’s 
 * disease and produce a diagnosis.
 */
public class Alternative_Huntingtons {
    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int iCurrMaxRepeats = 0;
        int iMaxRepeats = 0;
        int iCurrIndex = dna.indexOf("CAG");
        int iPrevIndex = 0; 
        // StdOut.println(iTriNucleotide);

        if (iCurrIndex >= 0) {
            iCurrMaxRepeats++;
            if (iCurrMaxRepeats > iMaxRepeats) {
                iMaxRepeats = iCurrMaxRepeats;
            }
        }

        while (iCurrIndex >= 0) {
            iPrevIndex = iCurrIndex + 1;
            iCurrIndex = dna.indexOf("CAG", iPrevIndex);
            if (iCurrIndex - iPrevIndex == 2) {
                iCurrMaxRepeats++;
            } else if (iCurrIndex > iPrevIndex) {
                if (iCurrMaxRepeats > iMaxRepeats) {
                    iMaxRepeats = iCurrMaxRepeats;
                }

                iCurrMaxRepeats = 1;
            } else if (iCurrIndex == -1) {
                if (iCurrMaxRepeats > iMaxRepeats) {
                    iMaxRepeats = iCurrMaxRepeats;
                }
            }
            // StdOut.println(iPrevIndex + " " + iCurrIndex);
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