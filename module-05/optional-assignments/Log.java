    /*
     * Description: The program Log.java uses a static method lg() that takes 
     * an int argument n and returns the largest integer not larger than the 
     * base-2 logarithm of n. Do not use the Math library.
     */
public class Log {
    public static int lg(int iN) {
        if (iN <= 0) {
            return 0;
        }

        int iLargestInt = 0;
        int iBase2 = 2;
        while (iBase2 <= iN) {
            iBase2 *= 2; 
            iLargestInt++;
        }

        return iLargestInt; 
    }
    public static void main(String[] args) {
        int iN = Integer.parseInt(args[0]);
        int iLargestInt = lg(iN);

        StdOut.println(iLargestInt);
    }
}