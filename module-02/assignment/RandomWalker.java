public class RandomWalker {
    /*
     * Description: The program RandomWalker.java takes an integer command-line argument r 
     * and simulates the motion of a random walk until the random walker is at Manhattan 
     * distance r from the starting point. Print the coordinates at each step of the walk 
     * (including the starting and ending points), treating the starting point as (0, 0). 
     * Also, print the total number of steps taken
     */
    public static void main(String[] args) {
        int iR = Integer.parseInt(args[0]);
        int iX = 0;
        int iY = 0; 
        int iManhattanDistance;
        double dEAST = 0.25;
        double dSOUTH = 0.50;
        double dWEST = 0.75;
        double dWalk;
        int iSteps = 0;

        System.out.println("(" + iX + ", " + iY + ")");

        iManhattanDistance = Math.abs(iX) + Math.abs(iY);
        while (iManhattanDistance != iR) {
            dWalk = Math.random();
            
            if (dWalk >= dWEST) {
                iX--;
            } else if (dWalk >= dSOUTH) {
                iY--;
            } else if (dWalk >= dEAST) {
                iX++;
            } else {
                iY++;
            }
            
            iManhattanDistance = Math.abs(iX) + Math.abs(iY);

            System.out.println("(" + iX + ", " + iY + ")");
            
            iSteps++;
        }
        
        System.out.println("steps = " + iSteps);
    }
}
