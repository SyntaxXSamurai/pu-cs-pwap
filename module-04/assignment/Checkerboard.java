public class Checkerboard {
    /*
     * Description: The program Checkerboard.java takes a command-line integer n and plots an 
     * n-by-n checkerboard pattern to standard drawing. The squares should be coloured blue and 
     * light gray, with the bottom-left square blue.
     */
    public static void main(String[] args) {
        int iN = Integer.parseInt(args[0]);
        
        double dSquareSize = 1.0;
        double dSquareX = 0.0, dSquareY = 0.0;
        double dHalfLength = dSquareSize / 2.0;

        StdDraw.setXscale(0, (double) iN);
        StdDraw.setYscale(0, (double) iN); 

        for (int x = 0; x < iN; x++) {
            for (int y = 0; y < iN; y++) {
                if (x % 2 == 0) {
                    if (y % 2 == 0) {
                        StdDraw.setPenColor(StdDraw.BLUE);
                    } else {
                        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                    }
                } else {
                    if (y % 2 == 0) {
                        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                    } else {
                        StdDraw.setPenColor(StdDraw.BLUE);
                    }
                }

                dSquareX = x * dSquareSize + dHalfLength;
                dSquareY = y * dSquareSize + dHalfLength;
                StdDraw.filledSquare(dSquareX, dSquareY, dHalfLength);

                // StdOut.println(dSquareX + " " + dSquareY + " " + dHalfLength);
            }
        }
    }
}