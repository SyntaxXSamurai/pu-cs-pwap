/*
 * Description: The program Divisors.java computes the greatest common divisor and related functions on integers.
 */
public class Divisors {
    // Returns the greatest common divisor of a and b.
    public static int gcd(int iA, int iB) {
        iA = Math.abs(iA);
        iB = Math.abs(iB);
        int iPrevNum = iA;

        while (iB != 0) {
            if (iB != 0) {
                iA = iB;
                iB = iPrevNum % iB;
                
                if (iB != 0) {
                    iPrevNum = iA;
                }
                // StdOut.println(iA + " " + iB + " " + iPrevNum);
            } 
        }
        
        return iA;
    }

    // Returns the least common multiple of a and b.
    public static int lcm(int iA, int iB) {
        int iLCM = 0;
        iLCM = (Math.abs(iA) * Math.abs(iB)) / gcd(iA, iB);

        return iLCM;
    }
    
    // Returns true if a and b are relatively prime; false otherwise.
    public static boolean areRelativelyPrime(int iA, int iB) {
        boolean bAreRelativelyPrime = false; 
        if (gcd(iA, iB) == 1) {
            bAreRelativelyPrime = true; 
        } 

        return bAreRelativelyPrime; 
    }

    // Returns the number of integers between 1 and n that are
    // relatively prime with n.
    public static int totient(int iN) {
        int iIsPrime = 0;
        for (int i = 1; i <= iN; i++) {
            if (areRelativelyPrime(i, iN) == true) {
                iIsPrime++;    
            }
        }

        return iIsPrime;
    }

    // Takes two integer command-line arguments a and b and prints
    // each function, evaluated in the format (and order) given below.
    public static void main(String[] args) {
        int iA = Integer.parseInt(args[0]);
        int iB = Integer.parseInt(args[1]);

        StdOut.println("gcd(" + iA + ", " + iB + ") = " + gcd(iA, iB));
        StdOut.println("lcm(" + iA + ", " + iB + ") = " + lcm(iA, iB));
        StdOut.println("areRElatielyPrime(" + iA + ", " + iB + ") = " + areRelativelyPrime(iA, iB));
        StdOut.println("totient(" + iA + ") = " + totient(iA));
        StdOut.println("totient(" + iB + ") = " + totient(iB));
    }
}