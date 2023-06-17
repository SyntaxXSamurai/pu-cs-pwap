package leapyear;
public class LeapYear {
    /*
     * Program: LeapYear
     * Parameters: Year
     * Description: The program takes one parameter and it will return true or false to indicate wether a year is a leap year
     */
    public static void main(String[] args) {
        // A leap year is when (a) is divisible by 400 OR (b) is divisible by 4 but not divisible by 100
        int iYear; 
        iYear = Integer.parseInt(args[0]);
        boolean bIsLeapYear = (iYear % 400 == 0);
        bIsLeapYear = bIsLeapYear || ((iYear % 4 == 0) && (iYear % 100 != 0));
        
        if (iYear > 0) {
            System.out.println("The year " + iYear + " is a leap year: " + bIsLeapYear);
        }
        else {
            System.out.println(iYear + " is not a valid year!");
        }
    }
}