public class RightTriangleAdvanced {
    /*
     * Description: The program RightTriangle takes three int command-line and determines whether they constitute the side lengths of some right triangle
     */
    public static void main(String[] args) {
        boolean bIsException = true;

        try {
            // First check that there are 3 arguments
            if (args.length == 3) {
                // Set exception to false
                bIsException = false; 

                int iSide1 = Integer.parseInt(args[0]);
                int iSide2 = Integer.parseInt(args[1]);
                int iSide3 = Integer.parseInt(args[2]);

                if  ((iSide1 < 0) || (iSide2 < 0) || (iSide3 < 0)) {
                    bIsException = true;
                } else {
                    iSide1 = iSide1 * iSide1;
                    iSide2 = iSide2 * iSide2;
                    iSide3 = iSide3 * iSide3;
                    
                    boolean isRightTriangle = 
                        (iSide1 + iSide2 == iSide3) ||
                        (iSide1 + iSide3 == iSide2) || 
                        (iSide2 + iSide3 == iSide1);
                    
                    System.out.println(isRightTriangle);
                }
           }  
        } catch (NumberFormatException e) {
            System.out.println(e);
            bIsException = true;
        }

        if (bIsException) {
            System.out.println("\nThe program is expecting 3 positive integers representing sides of a right triangle:\n\n" + 
                "\tRightTriangle 3 4 5\n");
        }
    }
}
