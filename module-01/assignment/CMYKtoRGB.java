public class CMYKtoRGB {
    /*
     * Description: The program must take four double command-line arguments (cyan, magenta, yellow, and black) 
     * to compute the corresponding RGB values (each rounded to the nearest integer) and print the RGB values
     */
    public static void main(String [] args) {
        double dCyan = Double.parseDouble(args[0]);
        double dMagenta = Double.parseDouble(args[1]);
        double dYellow = Double.parseDouble(args[2]);
        double dBlack = Double.parseDouble(args[3]);

        double dWhite = 1 - dBlack;
        double dRed = 255 * dWhite * (1 - dCyan);
        double dGreen = 255 * dWhite * (1 - dMagenta);
        double dBlue = 255 * dWhite * (1 - dYellow);

        System.out.println("Red  " + " = " + Math.round(dRed));
        System.out.println("Green" + " = " + Math.round(dGreen));
        System.out.println("Blue " + " = " + Math.round(dBlue));
    }
}
