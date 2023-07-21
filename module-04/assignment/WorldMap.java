public class WorldMap {
    /*
     * Description: The program WorldMap.java reads boundary 
     * information of a country (or other geographic entity) from 
     * standard input and plots the results to standard drawing.
     */
    public static void main(String[] args) {
        int iWidth = 0;
        int iHeight = 0;

        int iNumVertices = 0; 

        // Read in the width and heigh from StdIn, then set canvas size in pixels
        iWidth = StdIn.readInt();
        iHeight = StdIn.readInt();
        StdDraw.setCanvasSize(iWidth, iHeight);

        StdDraw.setXscale(0.0, (double) iWidth);
        StdDraw.setYscale(0.0, (double) iHeight);

        StdDraw.enableDoubleBuffering();

        while (!StdIn.isEmpty()) {
            StdIn.readString();
            iNumVertices = StdIn.readInt();

            double[] dCordListX = new double[iNumVertices];
            double[] dCordListY = new double[iNumVertices];

            for (int i = 0; i < iNumVertices; i++) {
                dCordListX[i] = StdIn.readDouble();
                dCordListY[i] = StdIn.readDouble();
            }

            StdDraw.polygon(dCordListX, dCordListY);
        }
        
        StdDraw.show();
    }
}