public class Minesweeper {
    public static void main(String[] args) {
        int iM = Integer.parseInt(args[0]);
        int iN = Integer.parseInt(args[1]);
        int iK = Integer.parseInt(args[2]);
        int[][] iGrid = new int[iM][iN];
        int[] iRandomMines = new int[iK];
        boolean bIsMine = false;

        for (int i = 0; i < iRandomMines.length; i++) {
            bIsMine = false;    

            while (!bIsMine) {
                iRandomMines[i] = (int) (Math.random() * iM * iN);
                bIsMine = true;

                for (int j = 0; j < i; j++) {
                    if (iRandomMines[i] == iRandomMines[j]) {
                        bIsMine = false;
                    } 
                }
            }
        }

        for (int iRow = 0; iRow < iM; iRow++) {
            for (int iColumn = 0; iColumn < iN; iColumn++) {
                iGrid[iRow][iColumn] = 0;
            }
        }

        int iRandom = 0;
        for (int i = 0; i < iRandomMines.length; i++) {
            iRandom = iRandomMines[i];
            iGrid[iRandom / iN][iRandom % iN] = -1;
        }

        for (int iRow = 0; iRow < iGrid.length; iRow++) {
            for (int iColumn = 0; iColumn < iGrid[iRow].length; iColumn++) {
                // First, check to see if it's not a mine.
                if (iGrid[iRow][iColumn] >= 0) {
                    // Check if the bomb is above this position.
                    if (iRow > 0) {
                        if (iGrid[iRow - 1][iColumn] == -1) {
                            iGrid[iRow][iColumn]++;
                        }

                        // Check if the bomb is to the top-left of this position.
                        if (iColumn > 0 && iGrid[iRow - 1][iColumn - 1] == -1) {
                            iGrid[iRow][iColumn]++;
                        }

                        // Check if the bomb is to the top-right of this position.
                        if (iColumn < iGrid[iRow].length - 1 && iGrid[iRow - 1][iColumn + 1] == -1) {
                            iGrid[iRow][iColumn]++;
                        }    
                    }

                    // Check if the bomb is below this position.
                    if (iRow < iGrid.length - 1) {
                        if (iGrid[iRow + 1][iColumn] == -1) {
                            iGrid[iRow][iColumn]++;
                        }

                        // Check if the bomb is to the bottom-left of this position.
                        if (iColumn > 0 && iGrid[iRow + 1][iColumn - 1] == -1) {
                            iGrid[iRow][iColumn]++;
                        }

                        // Check if the bomb is to the bottom-right of this position.
                        if (iColumn < iGrid[iRow].length - 1 && iGrid[iRow + 1][iColumn + 1] == -1) {
                            iGrid[iRow][iColumn]++;
                        }
                    }

                    // Check if the bomb is to the left of this position.
                    if (iColumn > 0) {
                        if (iGrid[iRow][iColumn - 1] == -1) {
                            iGrid[iRow][iColumn]++;
                        }
                    }

                    // Check if the bomb is to the right of this position.
                    if (iColumn < iGrid[iRow].length - 1) {
                        if (iGrid[iRow][iColumn + 1] == -1) {
                            iGrid[iRow][iColumn]++;
                        }
                    }
                }
            }
        }

        for (int iRow = 0; iRow < iGrid.length; iRow++) {
            for (int iColumn = 0; iColumn < iGrid[iRow].length; iColumn++) {
                if (iGrid[iRow][iColumn] < 0) {
                    System.out.print("*  ");
                } else {
                    System.out.print(iGrid[iRow][iColumn] + "  ");
                }
            }

            System.out.println();
        }   
    }    
}