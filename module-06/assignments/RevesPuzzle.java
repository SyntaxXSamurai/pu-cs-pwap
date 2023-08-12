/*
 * Description: The program RevesPuzzle.java takes an integer command-line argument n 
 * and prints a solution to Reve’s puzzle. 
 */
public class RevesPuzzle {
    private static void hanoi3(int iN, String from, String temp1, String to, String temp2) {
        int iK = (int) (iN + 1 - Math.round(Math.sqrt(2 * iN + 1)));

        if (iK == 0 && iN == 0) {
            return; 
        } else if (iN == 1) {
            StdOut.println("Move disk " + iN + " from " + from + " to " + to);
            return;
        }

        hanoi3(iK, from, to, temp1, temp2);
        hanoi4(iN - iK, iK, from, temp2, to);
        hanoi3(iK, temp1, from, to, temp2);
    }
    private static void hanoi4(int iN, int iK, String from, String temp1, String to) {
        if (iN == 0) {
            return; 
        }
        
        hanoi4(iN - 1, iK, from, to, temp1);
        StdOut.println("Move disk " + (iN + iK) + " from " + from + " to " + to);
        hanoi4(iN - 1, iK, temp1, from, to);
    }
    public static void main(String[] args) {
        int iN = Integer.parseInt(args[0]);

        hanoi3(iN, "A", "B", "D", "C");
    }
}