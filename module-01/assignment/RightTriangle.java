public class RightTriangle {
    /*
     * Description: The program RightTriangle takes three int command-line and determines whether they constitute the side lengths of some right triangle
     */
    public static void main(String[] args) {
        int iSide1 = Integer.parseInt(args[0]);
        int iSide2 = Integer.parseInt(args[1]);
        int iSide3 = Integer.parseInt(args[2]); 

        boolean isRightTriangle = 
            ((Math.pow(iSide1, 2) + Math.pow(iSide2, 2) == Math.pow(iSide3, 2)) ||
                (Math.pow(iSide2, 2) + Math.pow(iSide3, 2) == Math.pow(iSide1, 2)) ||
                (Math.pow(iSide3, 2) + Math.pow(iSide1, 2) == Math.pow(iSide2, 2))) && 
            ((iSide1 > 0) && (iSide2 > 0) && (iSide3 > 0));
                    
        System.out.println(isRightTriangle);
    }
}  
