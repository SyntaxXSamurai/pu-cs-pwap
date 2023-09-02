/*
 * Description: The data type ColorHSB.java represents a color in 
 * hue–saturation–brightness (HSB) format, along with a sample client.
 */
public class ColorHSB {
    private static final int MAXIMUM_HUE = 359;
    private static final int MAXIMUM_SATURATION = 100;
    private static final int MAXIMUM_BRIGTHNESS = 100;

    private final int iHue, iSaturation, iBrightness; 

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > MAXIMUM_HUE) {
            throw new IllegalArgumentException("Hue must be between 0 and 359");
        } else if (s < 0 || s > MAXIMUM_SATURATION) {
            throw new IllegalArgumentException("Saturation must be between 0 and 100");
        } else if (b < 0 || b > MAXIMUM_BRIGTHNESS) {
            throw new IllegalArgumentException("Brightness must be between 0 and 100");
        }

        iHue = h;
        iSaturation = s;
        iBrightness = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + iHue + ", " + iSaturation + ", " + iBrightness + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return (iSaturation == 0) || (iBrightness == 0);
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        int iHueDistance = this.iHue - that.iHue;
        int iMinHueDistance = (int) Math.min(iHueDistance * iHueDistance, Math.pow(360 - Math.abs(iHueDistance), 2));

        int iSaturationDistance = this.iSaturation - that.iSaturation;
        iSaturationDistance *= iSaturationDistance;

        int iBrightnessDistance = this.iBrightness - that.iBrightness;
        iBrightnessDistance *= iBrightnessDistance;

        return iMinHueDistance + iSaturationDistance + iBrightnessDistance;
    }

    // Sample client (see below). 
    public static void main(String[] args) {
        int iHue = Integer.parseInt(args[0]);
        int iSaturation = Integer.parseInt(args[1]);
        int iBrightness = Integer.parseInt(args[2]);
        ColorHSB colorHSB = new ColorHSB(iHue, iSaturation, iBrightness);
        
        ColorHSB colorHSBCheck, preDefColorHSB;
        String sColorNameCheck = "";
        String sPreDefColor = "";
        int iMinDistance = 0;
        int iCurrDistance = 0;

        sPreDefColor = StdIn.readString();
        preDefColorHSB = new ColorHSB(StdIn.readInt(), StdIn.readInt(), StdIn.readInt());
        iMinDistance = colorHSB.distanceSquaredTo(preDefColorHSB);

        while (!StdIn.isEmpty()) {
            sColorNameCheck = StdIn.readString();
            colorHSBCheck = new ColorHSB(StdIn.readInt(), StdIn.readInt(), StdIn.readInt());
            iCurrDistance = colorHSB.distanceSquaredTo(colorHSBCheck);

            if (iCurrDistance < iMinDistance) {
                sPreDefColor = sColorNameCheck;
                preDefColorHSB = colorHSBCheck;
                iMinDistance = iCurrDistance;
            }
        }

        StdOut.println(sPreDefColor +  " " + preDefColorHSB);
    }
}