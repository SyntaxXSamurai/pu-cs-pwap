import java.util.Arrays;

/*
 * Description: A bar aggregates related information (name, value, and category) for use in a bar chart.
 */
public class Bar implements Comparable<Bar> {
    private final String sBarName, sBarCategory;
    private final int iBarValue;

    // Creates a new bar.
    public Bar(String name, int value, String category) {
        if (name == null) {
            throw new IllegalArgumentException("There must be a name");
        } else if (value < 0) {
            throw new IllegalArgumentException("The value must be a positive integer");
        } else if (category == null) {
            throw new IllegalArgumentException("There must be a category");
        }

        sBarName = name;
        iBarValue = value; 
        sBarCategory = category;
    }

    // Returns the name of this bar.
    public String getName() {
        return sBarName;
    }

    // Returns the value of this bar.
    public int getValue() {
        return iBarValue;
    }

    // Returns the category of this bar.
    public String getCategory() {
        return sBarCategory;
    }

    // Compare two bars by value.
    public int compareTo(Bar that) {
        if (that == null) {
            throw new NullPointerException();
        }

        if (this.iBarValue < that.iBarValue) {
            return -1;
        } else if (this.iBarValue > that.iBarValue) {
            return 1;
        } else {
            return 0;
        }
    }

    // Sample client (see below).
    public static void main(String[] args) {
        Bar[] bars = new Bar[10];
        bars[0] = new Bar("Beijing",     22674, "East Asia");
        bars[1] = new Bar("Cairo",       19850, "Middle East");
        bars[2] = new Bar("Delhi",       27890, "South Asia");
        bars[3] = new Bar("Dhaka",       19633, "South Asia");
        bars[4] = new Bar("Mexico City", 21520, "Latin America");
        bars[5] = new Bar("Mumbai",      22120, "South Asia");
        bars[6] = new Bar("Osaka",       20409, "East Asia");
        bars[7] = new Bar("São Paulo",   21698, "Latin America");
        bars[8] = new Bar("Shanghai",    25779, "East Asia");
        bars[9] = new Bar("Tokyo",       38194, "East Asia");

        // StdOut.println("Compare two bar values: " + bars[1].compareTo(bars[0]));
        // StdOut.print(bars[0].getName() + " " + bars[0].getValue() + " " + bars[0].getCategory());
        // StdOut.println();
        
        Arrays.sort(bars);
        StdOut.print(bars[0]);
    }
}