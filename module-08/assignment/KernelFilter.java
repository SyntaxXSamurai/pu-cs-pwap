/*
 * Description: The image-processing library KernelFilter.java applies various 
 * kernel filters to images, such as Gaussian blur, sharpen, Laplacian, emboss, 
 * and motion blur.
 */
import java.awt.Color;
public class KernelFilter {

    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        int[][] identity = {{0, 0, 0},
                            {0, 1, 0},
                            {0, 0, 0}};
        double dCoefficient = 1;
        
        return filterPicture(picture, identity, dCoefficient);
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        int[][] gaussian = {{1, 2, 1},
                            {2, 4, 2},
                            {1, 2, 1}};
        double dCoefficient = (double) 1 / 16;

        return filterPicture(picture, gaussian, dCoefficient);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        int[][] sharpen = {{0, -1, 0},
                           {-1, 5, -1},
                           {0, -1, 0}};
        double dCoefficient = (double) 1;

        return filterPicture(picture, sharpen, dCoefficient);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        int[][] laplacian = {{-1, -1, -1},
                             {-1, 8, -1},
                             {-1, -1, -1}};
        double dCoefficient = (double) 1;

        return filterPicture(picture, laplacian, dCoefficient);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        int[][] emboss = {{-2, -1, 0},
                           {-1, 1, 1},
                           {0, 1, 2}};
        double dCoefficient = (double) 1;

        return filterPicture(picture, emboss, dCoefficient);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        int[][] motionblur = {{1, 0, 0, 0, 0, 0, 0, 0, 0},
                              {0, 1, 0, 0, 0, 0, 0, 0, 0},
                              {0, 0, 1, 0, 0, 0, 0, 0, 0},
                              {0, 0, 0, 1, 0, 0, 0, 0, 0},
                              {0, 0, 0, 0, 1, 0, 0, 0, 0},
                              {0, 0, 0, 0, 0, 1, 0, 0, 0},
                              {0, 0, 0, 0, 0, 0, 1, 0, 0},
                              {0, 0, 0, 0, 0, 0, 0, 1, 0},
                              {0, 0, 0, 0, 0, 0, 0, 0, 1}};
        double dCoefficient = (double) 1 / 9;

        return filterPicture(picture, motionblur, dCoefficient);
    }

    private static Picture filterPicture(Picture picture, int[][] kernel, double coefficient) {
        int iRed = 0, iGreen = 0, iBlue = 0;
        Color cPixel;
        Picture pNewPicture = new Picture(picture.width(), picture.height());
        int iTempRow, iTempCol;
        int iEdgeValueRow = kernel.length / 2;
        int iEdgeValueCol = kernel[0].length / 2;

        for (int iRow = 0; iRow < picture.height(); iRow++) {
            for (int iCol = 0; iCol < picture.width(); iCol++) {
                iRed = 0;
                iGreen = 0;
                iBlue = 0;

                 
                for (int i = 0; i < kernel.length; i++) {
                    for (int j = 0; j < kernel[0].length; j++) {
                        iTempRow = iRow - iEdgeValueRow + i;
                        iTempCol = iCol - iEdgeValueCol + j;

                        if (iTempRow < 0) {
                            iTempRow = (iTempRow + picture.height()) % picture.height();
                        } else if (iTempRow > picture.height() - 1) {
                            iTempRow = iTempRow % picture.height();
                        }
                        
                        if (iTempCol < 0) {
                            iTempCol = (iTempCol + picture.width()) % picture.width();
                        } else if (iTempCol > picture.width() - 1) {
                            iTempCol = iTempCol % picture.width(); 
                        }

                        cPixel = picture.get(iTempCol, iTempRow);
                        iRed += cPixel.getRed() * kernel[i][j];
                        iGreen += cPixel.getGreen() * kernel[i][j];
                        iBlue += cPixel.getBlue() * kernel[i][j];
                    }
                }
                
                iRed = (int) Math.round(iRed * coefficient);
                iGreen = (int) Math.round(iGreen * coefficient);
                iBlue = (int) Math.round(iBlue * coefficient);
                if (iRed > 255) {
                    iRed = 255;
                } else if (iRed < 0) {
                    iRed = 0;
                }

                if (iGreen > 255) {
                    iGreen = 255;
                } else if (iGreen < 0) {
                    iGreen = 0;
                }

                if (iBlue > 255) {
                    iBlue = 255;
                } else if (iBlue < 0) {
                    iBlue = 0; 
                }

                pNewPicture.set(iCol, iRow, new Color(iRed, iGreen, iBlue));
            }
        }

        return pNewPicture;
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        Picture picture = new Picture(args[0]);
        Picture identity = identity(picture);
        Picture gaussian = gaussian(picture);
        Picture sharpen = sharpen(picture);
        Picture laplacian = laplacian(picture);
        Picture emboss = emboss(picture);
        Picture motionblur = motionBlur(picture);

        picture.show();
        identity.show();
        gaussian.show();
        sharpen.show();
        laplacian.show();
        emboss.show();
        motionblur.show();
    }
}