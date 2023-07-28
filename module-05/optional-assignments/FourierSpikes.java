/*
 * Description: The program FourierSpikes.java takes a command-line argument n and plots the 
 * function (cos(t) + cos(2 t) + cos(3 t) + … + cos(n t)) / n for 500 equally spaced 
 * samples of t from -10 to 10 (in radians). Run your program for n = 5 and n = 500. 
 * Note : You will observe that the sum converges to a spike (0 everywhere except a single value). 
 * This property is the basis for a proof that any smooth function can be expressed as a sum of sinusoids.
 */
public class FourierSpikes {
    private static int iN; 
    private static int iNumSamples = 500;
    private static double[] dT = new double[iNumSamples];
    private static double[] dValue = new double[iNumSamples]; 
    public static void main(String[] args) {
        int iNParse = Integer.parseInt(args[0]);
        iN = iNParse;
        StdDraw.setXscale(-10, 10);
        StdDraw.setYscale(-1, 1);
        calculateValue();
    } 
    private static void calculateValue() {
        double dTLineSpace = 20.0 / (iNumSamples - 1);
        for (int i = 0; i < iNumSamples; i++) {
            dT[i] = -10 + i * dTLineSpace;
            dValue[i] = calculateFunctionValue(dT[i]); 
            // StdOut.print(dValue + " ");
        }
        StdStats.plotLines(dValue);
    }
    private static double calculateFunctionValue(double dT) {
        double dSum = 0.0;
        for (int i = 0; i < iN; i++) {
            dSum += Math.cos(i * dT);
        }

        return dSum / iN;
    }
}