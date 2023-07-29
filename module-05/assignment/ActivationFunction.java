/*
 * Description: The program ActivationFunction.java computes various activation functions 
 * that arise in neural networks. An activation function is a function that maps real numbers 
 * into a desired range, such as between 0 and 1 or between –1 and +1.
 */
public class ActivationFunction {
    // Returns the Heaviside function of x.
    public static double heaviside(double dX) {
        double dH = 0.0;
        if (dX < 0) {
            dH = 0.0;
        } else if (dX == 0) {
            dH = 0.5;
        } else {
            dH = 1.0;
        }

        return dH; 
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double dX) {
        double dSigmoid = 1 / (1 + Math.exp(-dX));

        return dSigmoid;
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double dX) {
        double dTanh = (Math.exp(dX) - Math.exp(-dX)) / (Math.exp(dX) + Math.exp(-dX));

        return dTanh;
    }

    // Returns the softsign function of x.
    public static double softsign(double dX) {
        double dF = dX / (1 + Math.abs(dX));

        return dF; 
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double dX) {
        double dSQNL = 0.0; 
        
        if (dX <= -2) {
            dSQNL = -1.0; 
        } else if (-2 < dX && dX < 0) {
            dSQNL = dX + (Math.pow(dX, 2) / 4);
        } else if (0 <= dX && dX < 2) {
            dSQNL = dX - (Math.pow(dX, 2) / 4);
        } else {
            dSQNL = 1; 
        }

        return dSQNL;
    }

    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.
    public static void main(String[] args) {
        double dX = Double.parseDouble(args[0]);

        StdOut.printf("%1$17s %2$s\n", "heaviside(" + dX + ") = ", heaviside(dX));
        StdOut.printf("%1$17s %2$s\n", "sigmoid(" + dX + ") = ", sigmoid(dX));
        StdOut.printf("%1$17s %2$s\n", "tanh(" + dX + ") = ", tanh(dX));
        StdOut.printf("%1$17s %2$s\n", "softsign(" + dX + ") = ", softsign(dX));
        StdOut.printf("%1$17s %2$s\n", "sqnl(" + dX + ") = ", sqnl(dX));
    }
}