/*
 * Description: The program RecursiveSquares.java takes an integer 
 * command-line argument n and plots a recursive square pattern of order n.
 */
public class RecursiveSquares {
    // Draws a square centered on (x, y) of the given side length
    // with a light gray background and a black border.
    public static void drawSquare(double x, double y, double length) {
        double dHalfLength = length / 2;

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, dHalfLength);

        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, dHalfLength);
    }

    // Draws a recursive square pattern of order n, centered on (x, y)
    // of the given side length.
    public static void draw(int n, double x, double y, double length) {
        if (n == 0) {
            return;
        }

        double dLSideCornerX = x - length/2, dRSideCornerX = x + length/2;
        double dBottomSideCornerY = y - length/2, dTopSideCornerY = y + length/2;
        double dHalfLength = length / 2;

        draw(n - 1, dLSideCornerX, dTopSideCornerY, dHalfLength);
        draw(n - 1, dRSideCornerX, dTopSideCornerY, dHalfLength);
        drawSquare(x, y, length);
        draw(n - 1, dLSideCornerX, dBottomSideCornerY, dHalfLength);
        draw(n - 1, dRSideCornerX, dBottomSideCornerY, dHalfLength);

    }

    // Takes an integer command-line argument n and draws a recursive
    // square pattern of order n, centered on (0.5, 0.5) with side length 0.5.
    public static void main(String[] args) {
        int iN = Integer.parseInt(args[0]);

        draw(iN, 0.5, 0.5, 0.5);
    }
}