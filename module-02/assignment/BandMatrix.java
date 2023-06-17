public class BandMatrix {
    /*
     * Description: The program BandMatrix.java takes two integer command-line arguments n and width and prints an n-by-n pattern, with a zero for each 
     * element whose distance from the main diagonal is strictly more than width, and and an asterisk for each entry that is not, and two spaces between
     * each 0 or *
     */
    public static void main(String[] args) {
        int iN = Integer.parseInt(args[0]);
        int iWidth = Integer.parseInt(args[1]);
        int iDistance;
        
        for (int iRow = 0; iRow < iN; iRow++) {
            for (int iColoumn = 0; iColoumn < iN; iColoumn++) {
                iDistance = Math.abs(iRow - iColoumn); 
                if (iColoumn == iRow || iDistance <= iWidth) {
                    System.out.print("*  ");
                } else { 
                    System.out.print("0  ");
                }     
            }
            System.out.println();
        }
    }
}
