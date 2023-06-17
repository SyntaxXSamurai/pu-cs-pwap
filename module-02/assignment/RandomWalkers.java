public class RandomWalkers {
    /*
     * Description: The program RandomWalkers.java takes two integer command-line arguments r and trials. 
     * In each of trials independent experiments, simulate a random walk until the random walker is at 
     * Manhattan distance r from the starting point. Print the average number of steps
     */
    public static void main(String[] args) {
        int iR = Integer.parseInt(args[0]);
        int iTrials = Integer.parseInt(args[1]);
        int iX = 0;
        int iY = 0; 
        int iManhattanDistance = 0;
        double dEAST = 0.25;
        double dSOUTH = 0.50;
        double dWEST = 0.75;
        double dWalk;
        int iSteps = 0;

        for (int i = 0; i < iTrials; i++) {
            iManhattanDistance = 0;
            iX = 0;
            iY = 0;
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
            
                iSteps++;
            }
        }
        
        System.out.println("average number of steps = " + (double) iSteps / iTrials);
        
        // The relationship between f(r) and the average number of steps is: f(r) = r^2 * 3/5 
        // where f(r) = the average number of steps and r = Manhattan Distance
    }
}


