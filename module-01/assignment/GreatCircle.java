public class GreatCircle {
    /*
     * Description: The program GreatCircle.java takes four double command-line arguments x1, y1, x2 and y2 - the latitude and longitude (in degrees)
     * of two points on the surface of the earth and prints the great-circle distance (in kilometers) between them
     */
    public static void main(String[] args) {
        // First read in 4 parameters
        double dLat1 = Math.toRadians(Double.parseDouble(args[0]));
        double dLong1 = Math.toRadians(Double.parseDouble(args[1]));
        double dLat2 = Math.toRadians(Double.parseDouble(args[2]));
        double dLong2 = Math.toRadians(Double.parseDouble(args[3]));
        
        // Build formula 
        double dEarthRadiusKM = 6371.0;
        
        double dGreatCircleDistance = 
            2 * dEarthRadiusKM * 
            Math.asin(
                Math.sqrt(
                    Math.pow(Math.sin((dLat2 - dLat1) / 2), 2) + 
                    Math.cos(dLat1) *
                    Math.cos(dLat2) * 
                    Math.pow(Math.sin((dLong2 - dLong1) / 2), 2)
                )
            );
        System.out.println(dGreatCircleDistance + " kilometers");
    } 
}
